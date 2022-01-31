package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class QQAVImageToneCurveFilter
  extends QQAVImageFilter
{
  private PointF[] mBlueControlPoints;
  private ArrayList<Float> mBlueCurve;
  private PointF[] mGreenControlPoints;
  private ArrayList<Float> mGreenCurve;
  private PointF[] mRedControlPoints;
  private ArrayList<Float> mRedCurve;
  private PointF[] mRgbCompositeControlPoints;
  private ArrayList<Float> mRgbCompositeCurve;
  private int[] mToneCurveTexture = { -1 };
  private int mToneCurveTextureUniformLocation;
  
  public QQAVImageToneCurveFilter()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(23));
    PointF[] arrayOfPointF = new PointF[3];
    arrayOfPointF[0] = new PointF(0.0F, 0.0F);
    arrayOfPointF[1] = new PointF(0.5F, 0.5F);
    arrayOfPointF[2] = new PointF(1.0F, 1.0F);
    this.mRgbCompositeControlPoints = arrayOfPointF;
    this.mRedControlPoints = arrayOfPointF;
    this.mGreenControlPoints = arrayOfPointF;
    this.mBlueControlPoints = arrayOfPointF;
  }
  
  public QQAVImageToneCurveFilter(InputStream paramInputStream)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", String.valueOf(23));
    setFromCurveFileInputStream(paramInputStream);
  }
  
  private ArrayList<Double> createSecondDerivative(Point[] paramArrayOfPoint)
  {
    int j = paramArrayOfPoint.length;
    if (j <= 1)
    {
      paramArrayOfPoint = null;
      return paramArrayOfPoint;
    }
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 3 });
    double[] arrayOfDouble1 = new double[j];
    arrayOfDouble[0][1] = 4607182418800017408L;
    arrayOfDouble[0][0] = 0L;
    arrayOfDouble[0][2] = 0L;
    int i = 1;
    while (i < j - 1)
    {
      localObject = paramArrayOfPoint[(i - 1)];
      Point localPoint1 = paramArrayOfPoint[i];
      Point localPoint2 = paramArrayOfPoint[(i + 1)];
      arrayOfDouble[i][0] = ((localPoint1.x - ((Point)localObject).x) / 6.0D);
      arrayOfDouble[i][1] = ((localPoint2.x - ((Point)localObject).x) / 3.0D);
      arrayOfDouble[i][2] = ((localPoint2.x - localPoint1.x) / 6.0D);
      arrayOfDouble1[i] = ((localPoint2.y - localPoint1.y) / (localPoint2.x - localPoint1.x) - (localPoint1.y - ((Point)localObject).y) / (localPoint1.x - ((Point)localObject).x));
      i += 1;
    }
    arrayOfDouble1[0] = 0.0D;
    arrayOfDouble1[(j - 1)] = 0.0D;
    arrayOfDouble[(j - 1)][1] = 4607182418800017408L;
    arrayOfDouble[(j - 1)][0] = 0L;
    arrayOfDouble[(j - 1)][2] = 0L;
    i = 1;
    double d;
    while (i < j)
    {
      d = arrayOfDouble[i][0] / arrayOfDouble[(i - 1)][1];
      paramArrayOfPoint = arrayOfDouble[i];
      paramArrayOfPoint[1] -= arrayOfDouble[(i - 1)][2] * d;
      arrayOfDouble[i][0] = 0L;
      arrayOfDouble1[i] -= arrayOfDouble1[(i - 1)] * d;
      i += 1;
    }
    i = j - 2;
    while (i >= 0)
    {
      d = arrayOfDouble[i][2] / arrayOfDouble[(i + 1)][1];
      paramArrayOfPoint = arrayOfDouble[i];
      paramArrayOfPoint[1] -= arrayOfDouble[(i + 1)][0] * d;
      arrayOfDouble[i][2] = 0L;
      arrayOfDouble1[i] -= arrayOfDouble1[(i + 1)] * d;
      i -= 1;
    }
    Object localObject = new ArrayList(j);
    i = 0;
    for (;;)
    {
      paramArrayOfPoint = (Point[])localObject;
      if (i >= j) {
        break;
      }
      ((ArrayList)localObject).add(Double.valueOf(arrayOfDouble1[i] / arrayOfDouble[i][1]));
      i += 1;
    }
  }
  
  private ArrayList<Float> createSplineCurve(PointF[] paramArrayOfPointF)
  {
    if ((paramArrayOfPointF == null) || (paramArrayOfPointF.length <= 0))
    {
      paramArrayOfPointF = null;
      return paramArrayOfPointF;
    }
    Object localObject1 = (PointF[])paramArrayOfPointF.clone();
    Arrays.sort((Object[])localObject1, new Comparator()
    {
      public int compare(PointF paramAnonymousPointF1, PointF paramAnonymousPointF2)
      {
        if (paramAnonymousPointF1.x < paramAnonymousPointF2.x) {
          return -1;
        }
        if (paramAnonymousPointF1.x > paramAnonymousPointF2.x) {
          return 1;
        }
        return 0;
      }
    });
    Object localObject2 = new Point[localObject1.length];
    int i = 0;
    Point localPoint;
    while (i < paramArrayOfPointF.length)
    {
      localPoint = localObject1[i];
      localObject2[i] = new Point((int)(localPoint.x * 255.0F), (int)(localPoint.y * 255.0F));
      i += 1;
    }
    paramArrayOfPointF = createSplineCurve2((Point[])localObject2);
    if (paramArrayOfPointF == null) {
      return null;
    }
    localObject1 = (Point)paramArrayOfPointF.get(0);
    if (((Point)localObject1).x > 0)
    {
      i = ((Point)localObject1).x;
      while (i >= 0)
      {
        paramArrayOfPointF.add(0, new Point(i, 0));
        i -= 1;
      }
    }
    localObject1 = (Point)paramArrayOfPointF.get(paramArrayOfPointF.size() - 1);
    if (((Point)localObject1).x < 255)
    {
      i = ((Point)localObject1).x + 1;
      while (i <= 255)
      {
        paramArrayOfPointF.add(new Point(i, 255));
        i += 1;
      }
    }
    localObject1 = new ArrayList(paramArrayOfPointF.size());
    localObject2 = paramArrayOfPointF.iterator();
    for (;;)
    {
      paramArrayOfPointF = (PointF[])localObject1;
      if (!((Iterator)localObject2).hasNext()) {
        break;
      }
      paramArrayOfPointF = (Point)((Iterator)localObject2).next();
      localPoint = new Point(paramArrayOfPointF.x, paramArrayOfPointF.x);
      float f2 = (float)Math.sqrt(Math.pow(localPoint.x - paramArrayOfPointF.x, 2.0D) + Math.pow(localPoint.y - paramArrayOfPointF.y, 2.0D));
      float f1 = f2;
      if (localPoint.y > paramArrayOfPointF.y) {
        f1 = -f2;
      }
      ((ArrayList)localObject1).add(Float.valueOf(f1));
    }
  }
  
  private ArrayList<Point> createSplineCurve2(Point[] paramArrayOfPoint)
  {
    ArrayList localArrayList = createSecondDerivative(paramArrayOfPoint);
    Object localObject;
    if (localArrayList == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      int k = localArrayList.size();
      if (k < 1) {
        return null;
      }
      localObject = new double[k];
      int i = 0;
      while (i < k)
      {
        localObject[i] = ((Double)localArrayList.get(i)).doubleValue();
        i += 1;
      }
      localArrayList = new ArrayList(k + 1);
      i = 0;
      while (i < k - 1)
      {
        Point localPoint1 = paramArrayOfPoint[i];
        Point localPoint2 = paramArrayOfPoint[(i + 1)];
        int j = localPoint1.x;
        if (j < localPoint2.x)
        {
          double d1 = (j - localPoint1.x) / (localPoint2.x - localPoint1.x);
          double d2 = 1.0D - d1;
          double d3 = localPoint2.x - localPoint1.x;
          d2 = localPoint1.y * d2 + localPoint2.y * d1 + d3 * d3 / 6.0D * ((d2 * d2 * d2 - d2) * localObject[i] + (d1 * d1 * d1 - d1) * localObject[(i + 1)]);
          if (d2 > 255.0D) {
            d1 = 255.0D;
          }
          for (;;)
          {
            localArrayList.add(new Point(j, (int)Math.round(d1)));
            j += 1;
            break;
            d1 = d2;
            if (d2 < 0.0D) {
              d1 = 0.0D;
            }
          }
        }
        i += 1;
      }
      localObject = localArrayList;
    } while (localArrayList.size() != 255);
    localArrayList.add(paramArrayOfPoint[(paramArrayOfPoint.length - 1)]);
    return localArrayList;
  }
  
  private short readShort(InputStream paramInputStream)
    throws IOException
  {
    return (short)(paramInputStream.read() << 8 | paramInputStream.read());
  }
  
  private void updateToneCurveTexture()
  {
    runOnDraw(new Runnable()
    {
      public void run()
      {
        GLES20.glActiveTexture(33987);
        GLES20.glBindTexture(3553, QQAVImageToneCurveFilter.this.mToneCurveTexture[0]);
        if ((QQAVImageToneCurveFilter.this.mRedCurve.size() >= 256) && (QQAVImageToneCurveFilter.this.mGreenCurve.size() >= 256) && (QQAVImageToneCurveFilter.this.mBlueCurve.size() >= 256) && (QQAVImageToneCurveFilter.this.mRgbCompositeCurve.size() >= 256))
        {
          byte[] arrayOfByte = new byte[1024];
          int i = 0;
          while (i < 256)
          {
            float f1 = i;
            float f2 = ((Float)QQAVImageToneCurveFilter.this.mBlueCurve.get(i)).floatValue();
            arrayOfByte[(i * 4 + 2)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.this.mRgbCompositeCurve.get(i)).floatValue() + (f1 + f2), 0.0F), 255.0F) & 0xFF));
            f1 = i;
            f2 = ((Float)QQAVImageToneCurveFilter.this.mGreenCurve.get(i)).floatValue();
            arrayOfByte[(i * 4 + 1)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.this.mRgbCompositeCurve.get(i)).floatValue() + (f1 + f2), 0.0F), 255.0F) & 0xFF));
            f1 = i;
            f2 = ((Float)QQAVImageToneCurveFilter.this.mRedCurve.get(i)).floatValue();
            arrayOfByte[(i * 4)] = ((byte)((int)Math.min(Math.max(((Float)QQAVImageToneCurveFilter.this.mRgbCompositeCurve.get(i)).floatValue() + (f1 + f2), 0.0F), 255.0F) & 0xFF));
            arrayOfByte[(i * 4 + 3)] = -1;
            i += 1;
          }
          GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(arrayOfByte));
        }
      }
    });
  }
  
  protected void onDrawArraysAfter()
  {
    if (this.mToneCurveTexture[0] != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, 0);
      GLES20.glActiveTexture(33984);
    }
  }
  
  protected void onDrawArraysPre()
  {
    if (this.mToneCurveTexture[0] != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.mToneCurveTexture[0]);
      GLES20.glUniform1i(this.mToneCurveTextureUniformLocation, 3);
    }
  }
  
  public void onInit()
  {
    super.onInit();
    this.mToneCurveTextureUniformLocation = GLES20.glGetUniformLocation(getProgram(), "toneCurveTexture");
    GLES20.glActiveTexture(33987);
    GLES20.glGenTextures(1, this.mToneCurveTexture, 0);
    GLES20.glBindTexture(3553, this.mToneCurveTexture[0]);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
  }
  
  public void onInitialized()
  {
    super.onInitialized();
    setRgbCompositeControlPoints(this.mRgbCompositeControlPoints);
    setRedControlPoints(this.mRedControlPoints);
    setGreenControlPoints(this.mGreenControlPoints);
    setBlueControlPoints(this.mBlueControlPoints);
  }
  
  public void setBlueControlPoints(PointF[] paramArrayOfPointF)
  {
    this.mBlueControlPoints = paramArrayOfPointF;
    this.mBlueCurve = createSplineCurve(this.mBlueControlPoints);
    updateToneCurveTexture();
  }
  
  public void setFromCurveFileInputStream(InputStream paramInputStream)
  {
    try
    {
      readShort(paramInputStream);
      int k = readShort(paramInputStream);
      ArrayList localArrayList = new ArrayList(k);
      int i = 0;
      while (i < k)
      {
        int m = readShort(paramInputStream);
        PointF[] arrayOfPointF = new PointF[m];
        int j = 0;
        while (j < m)
        {
          int n = readShort(paramInputStream);
          arrayOfPointF[j] = new PointF(readShort(paramInputStream) * 0.003921569F, n * 0.003921569F);
          j += 1;
        }
        localArrayList.add(arrayOfPointF);
        i += 1;
      }
      paramInputStream.close();
      this.mRgbCompositeControlPoints = ((PointF[])localArrayList.get(0));
      this.mRedControlPoints = ((PointF[])localArrayList.get(1));
      this.mGreenControlPoints = ((PointF[])localArrayList.get(2));
      this.mBlueControlPoints = ((PointF[])localArrayList.get(3));
      return;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  public void setGreenControlPoints(PointF[] paramArrayOfPointF)
  {
    this.mGreenControlPoints = paramArrayOfPointF;
    this.mGreenCurve = createSplineCurve(this.mGreenControlPoints);
    updateToneCurveTexture();
  }
  
  public void setRedControlPoints(PointF[] paramArrayOfPointF)
  {
    this.mRedControlPoints = paramArrayOfPointF;
    this.mRedCurve = createSplineCurve(this.mRedControlPoints);
    updateToneCurveTexture();
  }
  
  public void setRgbCompositeControlPoints(PointF[] paramArrayOfPointF)
  {
    this.mRgbCompositeControlPoints = paramArrayOfPointF;
    this.mRgbCompositeCurve = createSplineCurve(this.mRgbCompositeControlPoints);
    updateToneCurveTexture();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter
 * JD-Core Version:    0.7.0.1
 */