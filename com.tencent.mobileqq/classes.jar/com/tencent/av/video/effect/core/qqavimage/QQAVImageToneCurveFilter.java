package com.tencent.av.video.effect.core.qqavimage;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
    int k = paramArrayOfPoint.length;
    if (k <= 1) {
      return null;
    }
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { k, 3 });
    double[] arrayOfDouble1 = new double[k];
    arrayOfDouble[0][1] = 4607182418800017408L;
    arrayOfDouble[0][0] = 0L;
    arrayOfDouble[0][2] = 0L;
    int j;
    double d1;
    for (int i = 1;; i = j)
    {
      j = k - 1;
      if (i >= j) {
        break;
      }
      Point localPoint1 = paramArrayOfPoint[(i - 1)];
      Point localPoint2 = paramArrayOfPoint[i];
      j = i + 1;
      Point localPoint3 = paramArrayOfPoint[j];
      double[] arrayOfDouble2 = arrayOfDouble[i];
      d1 = localPoint2.x - localPoint1.x;
      Double.isNaN(d1);
      arrayOfDouble2[0] = (d1 / 6.0D);
      arrayOfDouble2 = arrayOfDouble[i];
      d1 = localPoint3.x - localPoint1.x;
      Double.isNaN(d1);
      arrayOfDouble2[1] = (d1 / 3.0D);
      arrayOfDouble2 = arrayOfDouble[i];
      d1 = localPoint3.x - localPoint2.x;
      Double.isNaN(d1);
      arrayOfDouble2[2] = (d1 / 6.0D);
      d1 = localPoint3.y - localPoint2.y;
      double d2 = localPoint3.x - localPoint2.x;
      Double.isNaN(d1);
      Double.isNaN(d2);
      d1 /= d2;
      d2 = localPoint2.y - localPoint1.y;
      double d3 = localPoint2.x - localPoint1.x;
      Double.isNaN(d2);
      Double.isNaN(d3);
      arrayOfDouble1[i] = (d1 - d2 / d3);
    }
    arrayOfDouble1[0] = 0.0D;
    arrayOfDouble1[j] = 0.0D;
    arrayOfDouble[j][1] = 4607182418800017408L;
    arrayOfDouble[j][0] = 0L;
    arrayOfDouble[j][2] = 0L;
    i = 1;
    while (i < k)
    {
      d1 = arrayOfDouble[i][0];
      j = i - 1;
      d1 /= arrayOfDouble[j][1];
      paramArrayOfPoint = arrayOfDouble[i];
      paramArrayOfPoint[1] -= arrayOfDouble[j][2] * d1;
      arrayOfDouble[i][0] = 0L;
      arrayOfDouble1[i] -= d1 * arrayOfDouble1[j];
      i += 1;
    }
    i = k - 2;
    while (i >= 0)
    {
      d1 = arrayOfDouble[i][2];
      j = i + 1;
      d1 /= arrayOfDouble[j][1];
      paramArrayOfPoint = arrayOfDouble[i];
      paramArrayOfPoint[1] -= arrayOfDouble[j][0] * d1;
      arrayOfDouble[i][2] = 0L;
      arrayOfDouble1[i] -= d1 * arrayOfDouble1[j];
      i -= 1;
    }
    i = 0;
    paramArrayOfPoint = new ArrayList(k);
    while (i < k)
    {
      paramArrayOfPoint.add(Double.valueOf(arrayOfDouble1[i] / arrayOfDouble[i][1]));
      i += 1;
    }
    return paramArrayOfPoint;
  }
  
  private ArrayList<Float> createSplineCurve(PointF[] paramArrayOfPointF)
  {
    Object localObject1 = null;
    if (paramArrayOfPointF != null)
    {
      if (paramArrayOfPointF.length <= 0) {
        return null;
      }
      localObject1 = (PointF[])paramArrayOfPointF.clone();
      Arrays.sort((Object[])localObject1, new QQAVImageToneCurveFilter.2(this));
      Object localObject2 = new Point[localObject1.length];
      int i = 0;
      Point localPoint;
      while (i < paramArrayOfPointF.length)
      {
        localPoint = localObject1[i];
        localObject2[i] = new Point((int)(localPoint.x * 255.0F), (int)(localPoint.y * 255.0F));
        i += 1;
      }
      localObject1 = createSplineCurve2((Point[])localObject2);
      if (localObject1 == null) {
        return null;
      }
      paramArrayOfPointF = (Point)((ArrayList)localObject1).get(0);
      if (paramArrayOfPointF.x > 0)
      {
        i = paramArrayOfPointF.x;
        while (i >= 0)
        {
          ((ArrayList)localObject1).add(0, new Point(i, 0));
          i -= 1;
        }
      }
      paramArrayOfPointF = (Point)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
      if (paramArrayOfPointF.x < 255)
      {
        i = paramArrayOfPointF.x;
        for (;;)
        {
          i += 1;
          if (i > 255) {
            break;
          }
          ((ArrayList)localObject1).add(new Point(i, 255));
        }
      }
      paramArrayOfPointF = new ArrayList(((ArrayList)localObject1).size());
      localObject2 = ((ArrayList)localObject1).iterator();
      for (;;)
      {
        localObject1 = paramArrayOfPointF;
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject1 = (Point)((Iterator)localObject2).next();
        localPoint = new Point(((Point)localObject1).x, ((Point)localObject1).x);
        float f2 = (float)Math.sqrt(Math.pow(localPoint.x - ((Point)localObject1).x, 2.0D) + Math.pow(localPoint.y - ((Point)localObject1).y, 2.0D));
        float f1 = f2;
        if (localPoint.y > ((Point)localObject1).y) {
          f1 = -f2;
        }
        paramArrayOfPointF.add(Float.valueOf(f1));
      }
    }
    return localObject1;
  }
  
  private ArrayList<Point> createSplineCurve2(Point[] paramArrayOfPoint)
  {
    ArrayList localArrayList = createSecondDerivative(paramArrayOfPoint);
    if (localArrayList == null) {
      return null;
    }
    int j = localArrayList.size();
    if (j < 1) {
      return null;
    }
    double[] arrayOfDouble = new double[j];
    int k = 0;
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = ((Double)localArrayList.get(i)).doubleValue();
      i += 1;
    }
    localArrayList = new ArrayList(j + 1);
    int m;
    for (i = k;; i = m)
    {
      Object localObject2 = paramArrayOfPoint;
      if (i >= j - 1) {
        break;
      }
      Object localObject1 = localObject2[i];
      m = i + 1;
      localObject2 = localObject2[m];
      k = localObject1.x;
      while (k < ((Point)localObject2).x)
      {
        double d1 = k - localObject1.x;
        double d2 = ((Point)localObject2).x - localObject1.x;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = 1.0D - d1;
        double d3 = ((Point)localObject2).x - localObject1.x;
        double d4 = localObject1.y;
        Double.isNaN(d4);
        double d5 = ((Point)localObject2).y;
        Double.isNaN(d5);
        Double.isNaN(d3);
        Double.isNaN(d3);
        d1 = d4 * d2 + d5 * d1 + d3 * d3 / 6.0D * ((d2 * d2 * d2 - d2) * arrayOfDouble[i] + (d1 * d1 * d1 - d1) * arrayOfDouble[m]);
        d2 = 0.0D;
        if (d1 > 255.0D) {
          d1 = 255.0D;
        } else if (d1 < 0.0D) {
          d1 = d2;
        }
        localArrayList.add(new Point(k, (int)Math.round(d1)));
        k += 1;
      }
    }
    if (localArrayList.size() == 255) {
      localArrayList.add(paramArrayOfPoint[(paramArrayOfPoint.length - 1)]);
    }
    return localArrayList;
  }
  
  private short readShort(InputStream paramInputStream)
  {
    int i = paramInputStream.read();
    return (short)(paramInputStream.read() | i << 8);
  }
  
  private void updateToneCurveTexture()
  {
    runOnDraw(new QQAVImageToneCurveFilter.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter
 * JD-Core Version:    0.7.0.1
 */