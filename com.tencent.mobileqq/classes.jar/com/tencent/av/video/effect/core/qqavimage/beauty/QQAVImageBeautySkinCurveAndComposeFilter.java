package com.tencent.av.video.effect.core.qqavimage.beauty;

import android.graphics.PointF;
import android.opengl.GLES20;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageTwoInputFilter;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.List<Landroid.graphics.PointF;>;

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
      Collections.sort(paramList, new Comparator()
      {
        public int compare(PointF paramAnonymousPointF1, PointF paramAnonymousPointF2)
        {
          if (paramAnonymousPointF1.x > paramAnonymousPointF2.x) {
            return 1;
          }
          if (paramAnonymousPointF1.x == paramAnonymousPointF2.x) {
            return 0;
          }
          return -1;
        }
      });
      ArrayList localArrayList = new ArrayList(paramList.size());
      int i = 0;
      while (i < paramList.size())
      {
        localArrayList.add(new PointF(255.0F * ((PointF)paramList.get(i)).x, ((PointF)paramList.get(i)).y * 255.0F));
        i += 1;
      }
      List localList = splineCurve(localArrayList);
      paramList = (PointF)localList.get(0);
      if (paramList.x > 0.0F)
      {
        i = (int)paramList.x;
        while (i >= 0)
        {
          localList.add(0, new PointF(i, 0.0F));
          i -= 1;
        }
      }
      paramList = (PointF)localList.get(localList.size() - 1);
      if (paramList.x < 255.0F)
      {
        i = (int)(paramList.x + 1.0F);
        while (i <= 255)
        {
          localList.add(new PointF(i, 255.0F));
          i += 1;
        }
      }
      localArrayList = new ArrayList(localList.size());
      i = 0;
      for (;;)
      {
        paramList = localArrayList;
        if (i >= localList.size()) {
          break;
        }
        paramList = (PointF)localList.get(i);
        PointF localPointF = new PointF(paramList.x, paramList.x);
        double d2 = Math.sqrt(Math.pow(localPointF.x - paramList.x, 2.0D) + Math.pow(localPointF.y - paramList.y, 2.0D));
        double d1 = d2;
        if (localPointF.y > paramList.y) {
          d1 = -d2;
        }
        localArrayList.add(Double.valueOf(d1));
        i += 1;
      }
    }
    paramList = null;
    return paramList;
  }
  
  private List<Double> secondDerivative(List<PointF> paramList)
  {
    int j = paramList.size();
    if ((j <= 0) || (j == 1))
    {
      paramList = null;
      return paramList;
    }
    Object localObject1 = (double[][])Array.newInstance(Double.TYPE, new int[] { j, 3 });
    double[] arrayOfDouble = new double[j];
    localObject1[0][1] = 4607182418800017408L;
    localObject1[0][0] = 0L;
    localObject1[0][2] = 0L;
    int i = 1;
    while (i < j - 1)
    {
      localObject2 = (PointF)paramList.get(i - 1);
      PointF localPointF1 = (PointF)paramList.get(i);
      PointF localPointF2 = (PointF)paramList.get(i + 1);
      localObject1[i][0] = ((localPointF1.x - ((PointF)localObject2).x) / 6.0D);
      localObject1[i][1] = ((localPointF2.x - ((PointF)localObject2).x) / 3.0D);
      localObject1[i][2] = ((localPointF2.x - localPointF1.x) / 6.0D);
      arrayOfDouble[i] = ((localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x) - (localPointF1.y - ((PointF)localObject2).y) / (localPointF1.x - ((PointF)localObject2).x));
      i += 1;
    }
    arrayOfDouble[0] = 0.0D;
    arrayOfDouble[(j - 1)] = 0.0D;
    localObject1[(j - 1)][1] = 4607182418800017408L;
    localObject1[(j - 1)][0] = 0L;
    localObject1[(j - 1)][2] = 0L;
    i = 1;
    double d;
    while (i < j)
    {
      d = localObject1[i][0] / localObject1[(i - 1)][1];
      paramList = localObject1[i];
      paramList[1] -= localObject1[(i - 1)][2] * d;
      localObject1[i][0] = 0L;
      arrayOfDouble[i] -= arrayOfDouble[(i - 1)] * d;
      i += 1;
    }
    i = j - 2;
    while (i >= 0)
    {
      d = localObject1[i][2] / localObject1[(i + 1)][1];
      paramList = localObject1[i];
      paramList[1] -= localObject1[(i + 1)][0] * d;
      localObject1[i][2] = 0L;
      arrayOfDouble[i] -= arrayOfDouble[(i + 1)] * d;
      i -= 1;
    }
    Object localObject2 = new double[j];
    i = 0;
    while (i < j)
    {
      arrayOfDouble[i] /= localObject1[i][1];
      i += 1;
    }
    localObject1 = new ArrayList(j);
    i = 0;
    for (;;)
    {
      paramList = (List<PointF>)localObject1;
      if (i >= j) {
        break;
      }
      ((List)localObject1).add(Double.valueOf(localObject2[i]));
      i += 1;
    }
  }
  
  private List<PointF> splineCurve(List<PointF> paramList)
  {
    Object localObject = secondDerivative(paramList);
    int k = ((List)localObject).size();
    if (k < 1) {
      return null;
    }
    double[] arrayOfDouble = new double[k];
    int i = 0;
    while (i < k)
    {
      arrayOfDouble[i] = ((Double)((List)localObject).get(i)).doubleValue();
      i += 1;
    }
    localObject = new ArrayList(k + 1);
    i = 0;
    while (i < k - 1)
    {
      PointF localPointF1 = (PointF)paramList.get(i);
      PointF localPointF2 = (PointF)paramList.get(i + 1);
      int j = (int)localPointF1.x;
      if (j < (int)localPointF2.x)
      {
        double d1 = (j - localPointF1.x) / (localPointF2.x - localPointF1.x);
        double d2 = 1.0D - d1;
        double d3 = localPointF2.x - localPointF1.x;
        d2 = localPointF1.y * d2 + localPointF2.y * d1 + d3 * d3 / 6.0D * ((d2 * d2 * d2 - d2) * arrayOfDouble[i] + (d1 * d1 * d1 - d1) * arrayOfDouble[(i + 1)]);
        if (d2 > 255.0D) {
          d1 = 255.0D;
        }
        for (;;)
        {
          ((List)localObject).add(new PointF(j, (float)d1));
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
    ((List)localObject).add(paramList.get(paramList.size() - 1));
    return localObject;
  }
  
  private void updateToneCurveTexture()
  {
    if ((this.mRedCurve != null) && (this.mRedCurve.size() >= 256) && (this.mGreenCurve != null) && (this.mGreenCurve.size() >= 256) && (this.mBlueCurve != null) && (this.mBlueCurve.size() >= 256) && (this.mRgbCompositeCurve != null) && (this.mRgbCompositeCurve.size() >= 256))
    {
      int i = 0;
      while (i < 256)
      {
        double d = i;
        int j = (short)(int)Math.min(Math.max(((Double)this.mBlueCurve.get(i)).doubleValue() + d, 0.0D), 255.0D);
        this.mToneCurveByteArray[(i * 4)] = ((byte)(int)Math.min(Math.max(j + ((Double)this.mRgbCompositeCurve.get(j)).doubleValue(), 0.0D), 255.0D));
        d = i;
        int k = (short)(int)Math.min(Math.max(((Double)this.mGreenCurve.get(i)).doubleValue() + d, 0.0D), 255.0D);
        this.mToneCurveByteArray[(i * 4 + 1)] = ((byte)(int)Math.min(Math.max(j + ((Double)this.mRgbCompositeCurve.get(k)).doubleValue(), 0.0D), 255.0D));
        d = i;
        k = (short)(int)Math.min(Math.max(((Double)this.mRedCurve.get(i)).doubleValue() + d, 0.0D), 255.0D);
        this.mToneCurveByteArray[(i * 4 + 2)] = ((byte)(int)Math.min(Math.max(j + ((Double)this.mRgbCompositeCurve.get(k)).doubleValue(), 0.0D), 255.0D));
        this.mToneCurveByteArray[(i * 4 + 3)] = -1;
        i += 1;
      }
      this.mToneCurveDataBuffer.position(0);
      this.mToneCurveDataBuffer.put(this.mToneCurveByteArray, 0, this.mToneCurveByteArray.length);
      this.mToneCurveDataBuffer.position(0);
      if (this.mToneCurveTexture != -1) {
        break label491;
      }
      GLES20.glActiveTexture(33985);
      GLES20.glGenTextures(1, new int[] { this.mToneCurveTexture }, 0);
      GLES20.glBindTexture(3553, this.mToneCurveTexture);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    for (;;)
    {
      GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, this.mToneCurveDataBuffer);
      return;
      label491:
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.mToneCurveTexture);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.core.qqavimage.beauty.QQAVImageBeautySkinCurveAndComposeFilter
 * JD-Core Version:    0.7.0.1
 */