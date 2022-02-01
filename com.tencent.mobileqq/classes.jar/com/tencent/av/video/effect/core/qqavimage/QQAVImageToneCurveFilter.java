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
    int j = paramArrayOfPoint.length;
    if (j <= 1) {
      return null;
    }
    double[][] arrayOfDouble = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 3 });
    double[] arrayOfDouble1 = new double[j];
    arrayOfDouble[0][1] = 4607182418800017408L;
    arrayOfDouble[0][0] = 0L;
    arrayOfDouble[0][2] = 0L;
    int i = 1;
    while (i < j - 1)
    {
      Point localPoint1 = paramArrayOfPoint[(i - 1)];
      Point localPoint2 = paramArrayOfPoint[i];
      Point localPoint3 = paramArrayOfPoint[(i + 1)];
      arrayOfDouble[i][0] = ((localPoint2.x - localPoint1.x) / 6.0D);
      arrayOfDouble[i][1] = ((localPoint3.x - localPoint1.x) / 3.0D);
      arrayOfDouble[i][2] = ((localPoint3.x - localPoint2.x) / 6.0D);
      arrayOfDouble1[i] = ((localPoint3.y - localPoint2.y) / (localPoint3.x - localPoint2.x) - (localPoint2.y - localPoint1.y) / (localPoint2.x - localPoint1.x));
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
      arrayOfDouble1[i] -= d * arrayOfDouble1[(i - 1)];
      i += 1;
    }
    i = j - 2;
    while (i >= 0)
    {
      d = arrayOfDouble[i][2] / arrayOfDouble[(i + 1)][1];
      paramArrayOfPoint = arrayOfDouble[i];
      paramArrayOfPoint[1] -= arrayOfDouble[(i + 1)][0] * d;
      arrayOfDouble[i][2] = 0L;
      arrayOfDouble1[i] -= d * arrayOfDouble1[(i + 1)];
      i -= 1;
    }
    paramArrayOfPoint = new ArrayList(j);
    i = 0;
    while (i < j)
    {
      paramArrayOfPoint.add(Double.valueOf(arrayOfDouble1[i] / arrayOfDouble[i][1]));
      i += 1;
    }
    return paramArrayOfPoint;
  }
  
  private ArrayList<Float> createSplineCurve(PointF[] paramArrayOfPointF)
  {
    if ((paramArrayOfPointF == null) || (paramArrayOfPointF.length <= 0)) {
      return null;
    }
    Object localObject1 = (PointF[])paramArrayOfPointF.clone();
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
      i = paramArrayOfPointF.x + 1;
      while (i <= 255)
      {
        ((ArrayList)localObject1).add(new Point(i, 255));
        i += 1;
      }
    }
    paramArrayOfPointF = new ArrayList(((ArrayList)localObject1).size());
    localObject1 = ((ArrayList)localObject1).iterator();
    float f;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Point)((Iterator)localObject1).next();
      localPoint = new Point(((Point)localObject2).x, ((Point)localObject2).x);
      f = (float)Math.sqrt(Math.pow(localPoint.x - ((Point)localObject2).x, 2.0D) + Math.pow(localPoint.y - ((Point)localObject2).y, 2.0D));
      if (localPoint.y <= ((Point)localObject2).y) {
        break label351;
      }
      f = -f;
    }
    label351:
    for (;;)
    {
      paramArrayOfPointF.add(Float.valueOf(f));
      break;
      return paramArrayOfPointF;
    }
  }
  
  private ArrayList<Point> createSplineCurve2(Point[] paramArrayOfPoint)
  {
    ArrayList localArrayList = createSecondDerivative(paramArrayOfPoint);
    if (localArrayList == null) {
      return null;
    }
    int k = localArrayList.size();
    if (k < 1) {
      return null;
    }
    double[] arrayOfDouble = new double[k];
    int i = 0;
    while (i < k)
    {
      arrayOfDouble[i] = ((Double)localArrayList.get(i)).doubleValue();
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
        double d5 = localPoint2.x - localPoint1.x;
        double d3 = localPoint1.y;
        double d4 = localPoint2.y;
        d5 = d5 * d5 / 6.0D;
        double d6 = arrayOfDouble[i];
        d2 = ((d1 * d1 * d1 - d1) * arrayOfDouble[(i + 1)] + (d2 * d2 * d2 - d2) * d6) * d5 + (d3 * d2 + d4 * d1);
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
    if (localArrayList.size() == 255) {
      localArrayList.add(paramArrayOfPoint[(paramArrayOfPoint.length - 1)]);
    }
    return localArrayList;
  }
  
  private short readShort(InputStream paramInputStream)
  {
    return (short)(paramInputStream.read() << 8 | paramInputStream.read());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.QQAVImageToneCurveFilter
 * JD-Core Version:    0.7.0.1
 */