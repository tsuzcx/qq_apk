package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QQAVImageBeautySkinCurveAndComposeFilter
  extends QQAVImageTwoInputFilter
{
  private List<Double> mBlueCurve;
  private List<Double> mGreenCurve;
  private float mMixPercent = 0.3F;
  private int mMixPercentUniform;
  private List<Double> mRedCurve;
  private List<Double> mRgbCompositeCurve;
  private byte[] mToneCurveByteArray = new byte[1024];
  private ByteBuffer mToneCurveDataBuffer = null;
  private int mToneCurveTexture = -1;
  private int mToneCurveTextureUniform;
  
  public QQAVImageBeautySkinCurveAndComposeFilter()
  {
    super(String.valueOf(5));
  }
  
  private List<Double> getPreparedSplineCurve(List<PointF> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      Collections.sort(paramList, new QQAVImageBeautySkinCurveAndComposeFilter.1(this));
      Object localObject = new ArrayList(paramList.size());
      int j = 0;
      int i = 0;
      while (i < paramList.size())
      {
        ((List)localObject).add(new PointF(((PointF)paramList.get(i)).x * 255.0F, ((PointF)paramList.get(i)).y * 255.0F));
        i += 1;
      }
      paramList = splineCurve((List)localObject);
      localObject = (PointF)paramList.get(0);
      if (((PointF)localObject).x > 0.0F)
      {
        i = (int)((PointF)localObject).x;
        while (i >= 0)
        {
          paramList.add(0, new PointF(i, 0.0F));
          i -= 1;
        }
      }
      localObject = (PointF)paramList.get(paramList.size() - 1);
      if (((PointF)localObject).x < 255.0F)
      {
        i = (int)(((PointF)localObject).x + 1.0F);
        while (i <= 255)
        {
          paramList.add(new PointF(i, 255.0F));
          i += 1;
        }
      }
      localObject = new ArrayList(paramList.size());
      i = j;
      while (i < paramList.size())
      {
        PointF localPointF1 = (PointF)paramList.get(i);
        PointF localPointF2 = new PointF(localPointF1.x, localPointF1.x);
        double d2 = Math.sqrt(Math.pow(localPointF2.x - localPointF1.x, 2.0D) + Math.pow(localPointF2.y - localPointF1.y, 2.0D));
        double d1 = d2;
        if (localPointF2.y > localPointF1.y) {
          d1 = -d2;
        }
        ((List)localObject).add(Double.valueOf(d1));
        i += 1;
      }
      return localObject;
    }
    return null;
  }
  
  private List<Double> secondDerivative(List<PointF> paramList)
  {
    int k = paramList.size();
    if ((k > 0) && (k != 1))
    {
      Object localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { k, 3 });
      double[] arrayOfDouble = new double[k];
      localObject1[0][1] = 4607182418800017408L;
      localObject1[0][0] = 0L;
      localObject1[0][2] = 0L;
      double d1;
      for (int i = 1;; i = j)
      {
        j = k - 1;
        if (i >= j) {
          break;
        }
        PointF localPointF1 = (PointF)paramList.get(i - 1);
        PointF localPointF2 = (PointF)paramList.get(i);
        j = i + 1;
        PointF localPointF3 = (PointF)paramList.get(j);
        Object localObject2 = localObject1[i];
        d1 = localPointF2.x - localPointF1.x;
        Double.isNaN(d1);
        localObject2[0] = (d1 / 6.0D);
        localObject2 = localObject1[i];
        d1 = localPointF3.x - localPointF1.x;
        Double.isNaN(d1);
        localObject2[1] = (d1 / 3.0D);
        localObject2 = localObject1[i];
        d1 = localPointF3.x - localPointF2.x;
        Double.isNaN(d1);
        localObject2[2] = (d1 / 6.0D);
        d1 = localPointF3.y - localPointF2.y;
        double d2 = localPointF3.x - localPointF2.x;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = localPointF2.y - localPointF1.y;
        double d3 = localPointF2.x - localPointF1.x;
        Double.isNaN(d2);
        Double.isNaN(d3);
        arrayOfDouble[i] = (d1 - d2 / d3);
      }
      arrayOfDouble[0] = 0.0D;
      arrayOfDouble[j] = 0.0D;
      localObject1[j][1] = 4607182418800017408L;
      localObject1[j][0] = 0L;
      localObject1[j][2] = 0L;
      i = 1;
      while (i < k)
      {
        d1 = localObject1[i][0];
        j = i - 1;
        d1 /= localObject1[j][1];
        paramList = localObject1[i];
        paramList[1] -= localObject1[j][2] * d1;
        localObject1[i][0] = 0L;
        arrayOfDouble[i] -= d1 * arrayOfDouble[j];
        i += 1;
      }
      i = k - 2;
      while (i >= 0)
      {
        d1 = localObject1[i][2];
        j = i + 1;
        d1 /= localObject1[j][1];
        paramList = localObject1[i];
        paramList[1] -= localObject1[j][0] * d1;
        localObject1[i][2] = 0L;
        arrayOfDouble[i] -= d1 * arrayOfDouble[j];
        i -= 1;
      }
      int j = 0;
      paramList = new double[k];
      i = 0;
      while (i < k)
      {
        arrayOfDouble[i] /= localObject1[i][1];
        i += 1;
      }
      localObject1 = new ArrayList(k);
      i = j;
      while (i < k)
      {
        ((List)localObject1).add(Double.valueOf(paramList[i]));
        i += 1;
      }
      return localObject1;
    }
    return null;
  }
  
  private List<PointF> splineCurve(List<PointF> paramList)
  {
    Object localObject1 = secondDerivative(paramList);
    int j = ((List)localObject1).size();
    if (j < 1) {
      return null;
    }
    double[] arrayOfDouble = new double[j];
    int k = 0;
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = ((Double)((List)localObject1).get(i)).doubleValue();
      i += 1;
    }
    localObject1 = new ArrayList(j + 1);
    int m;
    for (i = k;; i = m)
    {
      Object localObject2 = paramList;
      if (i >= j - 1) {
        break;
      }
      PointF localPointF = (PointF)((List)localObject2).get(i);
      m = i + 1;
      localObject2 = (PointF)((List)localObject2).get(m);
      k = (int)localPointF.x;
      while (k < (int)((PointF)localObject2).x)
      {
        float f = k;
        double d1 = f - localPointF.x;
        double d2 = ((PointF)localObject2).x - localPointF.x;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        d2 = 1.0D - d1;
        double d3 = ((PointF)localObject2).x - localPointF.x;
        double d4 = localPointF.y;
        Double.isNaN(d4);
        double d5 = ((PointF)localObject2).y;
        Double.isNaN(d5);
        Double.isNaN(d3);
        Double.isNaN(d3);
        d2 = d4 * d2 + d5 * d1 + d3 * d3 / 6.0D * ((d2 * d2 * d2 - d2) * arrayOfDouble[i] + (d1 * d1 * d1 - d1) * arrayOfDouble[m]);
        if (d2 > 255.0D)
        {
          d1 = 255.0D;
        }
        else
        {
          d1 = d2;
          if (d2 < 0.0D) {
            d1 = 0.0D;
          }
        }
        ((List)localObject1).add(new PointF(f, (float)d1));
        k += 1;
      }
    }
    ((List)localObject1).add(paramList.get(paramList.size() - 1));
    return localObject1;
  }
  
  private void updateToneCurveTexture()
  {
    Object localObject = this.mRedCurve;
    if ((localObject != null) && (((List)localObject).size() >= 256))
    {
      localObject = this.mGreenCurve;
      if ((localObject != null) && (((List)localObject).size() >= 256))
      {
        localObject = this.mBlueCurve;
        if ((localObject != null) && (((List)localObject).size() >= 256))
        {
          localObject = this.mRgbCompositeCurve;
          if ((localObject != null) && (((List)localObject).size() >= 256))
          {
            int i = 0;
            while (i < 256)
            {
              double d1 = i;
              double d2 = ((Double)this.mBlueCurve.get(i)).doubleValue();
              Double.isNaN(d1);
              int k = (short)(int)Math.min(Math.max(d2 + d1, 0.0D), 255.0D);
              localObject = this.mToneCurveByteArray;
              int j = i * 4;
              d2 = k;
              double d3 = ((Double)this.mRgbCompositeCurve.get(k)).doubleValue();
              Double.isNaN(d2);
              localObject[j] = ((byte)(int)Math.min(Math.max(d2 + d3, 0.0D), 255.0D));
              d3 = ((Double)this.mGreenCurve.get(i)).doubleValue();
              Double.isNaN(d1);
              k = (short)(int)Math.min(Math.max(d3 + d1, 0.0D), 255.0D);
              localObject = this.mToneCurveByteArray;
              d3 = ((Double)this.mRgbCompositeCurve.get(k)).doubleValue();
              Double.isNaN(d2);
              localObject[(j + 1)] = ((byte)(int)Math.min(Math.max(d2 + d3, 0.0D), 255.0D));
              d3 = ((Double)this.mRedCurve.get(i)).doubleValue();
              Double.isNaN(d1);
              k = (short)(int)Math.min(Math.max(d1 + d3, 0.0D), 255.0D);
              localObject = this.mToneCurveByteArray;
              d1 = ((Double)this.mRgbCompositeCurve.get(k)).doubleValue();
              Double.isNaN(d2);
              localObject[(j + 2)] = ((byte)(int)Math.min(Math.max(d2 + d1, 0.0D), 255.0D));
              this.mToneCurveByteArray[(j + 3)] = -1;
              i += 1;
            }
            this.mToneCurveDataBuffer.position(0);
            localObject = this.mToneCurveDataBuffer;
            byte[] arrayOfByte = this.mToneCurveByteArray;
            ((ByteBuffer)localObject).put(arrayOfByte, 0, arrayOfByte.length);
            this.mToneCurveDataBuffer.position(0);
            if (this.mToneCurveTexture == -1)
            {
              GLES20.glActiveTexture(33985);
              GLES20.glGenTextures(1, new int[] { this.mToneCurveTexture }, 0);
              GLES20.glBindTexture(3553, this.mToneCurveTexture);
              GLES20.glTexParameterf(3553, 10241, 9729.0F);
              GLES20.glTexParameterf(3553, 10240, 9729.0F);
              GLES20.glTexParameterf(3553, 10242, 33071.0F);
              GLES20.glTexParameterf(3553, 10243, 33071.0F);
            }
            else
            {
              GLES20.glActiveTexture(33985);
              GLES20.glBindTexture(3553, this.mToneCurveTexture);
            }
            GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, this.mToneCurveDataBuffer);
          }
        }
      }
    }
  }
  
  protected void onDrawArraysAfter()
  {
    super.onDrawArraysAfter();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, 0);
    GLES20.glActiveTexture(33984);
  }
  
  protected void onDrawArraysPre()
  {
    super.onDrawArraysPre();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.mToneCurveTexture);
    GLES20.glUniform1i(this.mToneCurveTextureUniform, 1);
    GLES20.glUniform1f(this.mMixPercentUniform, this.mMixPercent);
  }
  
  public void onInit()
  {
    super.onInit();
    this.mToneCurveTextureUniform = GLES20.glGetUniformLocation(getProgram(), "toneCurveTexture");
    this.mMixPercentUniform = GLES20.glGetUniformLocation(getProgram(), "mixPercent");
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new PointF(0.0F, 0.0F));
    localArrayList.add(new PointF(0.5F, 0.5F));
    localArrayList.add(new PointF(1.0F, 1.0F));
    setRedControlPoints(localArrayList);
    setGreenControlPoints(localArrayList);
    setBlueControlPoints(localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(new PointF(0.0F, 0.0F));
    localArrayList.add(new PointF(0.5490196F, 0.6196079F));
    localArrayList.add(new PointF(1.0F, 1.0F));
    setRgbCompositeControlPoints(localArrayList);
  }
  
  public void setBlueControlPoints(List<PointF> paramList)
  {
    this.mBlueCurve = getPreparedSplineCurve(paramList);
    updateToneCurveTexture();
  }
  
  public void setGreenControlPoints(List<PointF> paramList)
  {
    this.mGreenCurve = getPreparedSplineCurve(paramList);
    updateToneCurveTexture();
  }
  
  public void setMixPercent(float paramFloat)
  {
    this.mMixPercent = paramFloat;
  }
  
  public void setRedControlPoints(List<PointF> paramList)
  {
    this.mRedCurve = getPreparedSplineCurve(paramList);
    updateToneCurveTexture();
  }
  
  public void setRgbCompositeControlPoints(List<PointF> paramList)
  {
    this.mRgbCompositeCurve = getPreparedSplineCurve(paramList);
    updateToneCurveTexture();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautySkinCurveAndComposeFilter
 * JD-Core Version:    0.7.0.1
 */