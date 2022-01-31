package com.tencent.filter;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.util.LogUtil;
import java.util.ArrayList;
import java.util.Map;

public class DeconvSharpenFilter
  extends BaseFilter
{
  float alpha;
  ArrayList<BaseFilter> dampingArray;
  int fragmentShaderId;
  ArrayList<BaseFilter> guassArray;
  float lastDamping;
  Bitmap lookupBitmap;
  String resName = null;
  
  public DeconvSharpenFilter(int paramInt, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    super(paramInt);
    this.resName = paramString;
    this.fragmentShaderId = paramInt;
    this.guassArray = new ArrayList();
    this.dampingArray = new ArrayList();
    this.lookupBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
    this.lastDamping = -123123.0F;
    generateLookUpBitmap(2.0F);
    this.alpha = 1.5F;
    LogUtil.i("sharpen", "init");
  }
  
  private void generateLookUpBitmap(float paramFloat)
  {
    LogUtil.i("sharpen", "generateLookUpBitmap");
    if (Math.abs(this.lastDamping - paramFloat) > 0.001D)
    {
      QImage localQImage = QImage.BindBitmap(this.lookupBitmap);
      FilterAlgorithm.nativeUpdateLookupBitmap(localQImage, paramFloat);
      localQImage.UnBindBitmap(this.lookupBitmap);
      this.lastDamping = paramFloat;
    }
    LogUtil.i("sharpen", "generateLookUpBitmap out");
  }
  
  private void setDamping(float paramFloat)
  {
    generateLookUpBitmap(paramFloat);
    int i = 0;
    while (i < this.dampingArray.size())
    {
      ((BaseFilter)this.dampingArray.get(i)).addParam(new Param.TextureBitmapParam("inputImageTexture3", this.lookupBitmap, 33987, false));
      i += 1;
    }
  }
  
  private void setGuass3Coeffs(BaseFilter paramBaseFilter, float paramFloat)
  {
    float[] arrayOfFloat = new float[3];
    paramFloat = (float)Math.exp(-1.0D / (2.0D * paramFloat * paramFloat));
    arrayOfFloat[2] = paramFloat;
    arrayOfFloat[0] = paramFloat;
    arrayOfFloat[1] = 1.0F;
    paramFloat = arrayOfFloat[0] + arrayOfFloat[1] + arrayOfFloat[2];
    float f = arrayOfFloat[0] / paramFloat;
    arrayOfFloat[2] = f;
    arrayOfFloat[0] = f;
    arrayOfFloat[1] /= paramFloat;
    paramBaseFilter.addParam(new Param.Float1sParam("coeffs", arrayOfFloat));
  }
  
  private void setGuass9Coeffs(BaseFilter paramBaseFilter, float paramFloat)
  {
    float[] arrayOfFloat = new float[9];
    float f = 0.0F;
    int j = 0;
    int i = -1;
    while (i <= 1)
    {
      int k = -1;
      while (k <= 1)
      {
        arrayOfFloat[j] = ((float)Math.exp(-(i * i + k * k) / (2.0D * paramFloat * paramFloat)));
        f += arrayOfFloat[j];
        j += 1;
        k += 1;
      }
      i += 1;
    }
    i = 0;
    while (i < 9)
    {
      arrayOfFloat[i] /= f;
      i += 1;
    }
    paramBaseFilter.addParam(new Param.Float1sParam("coeffs", arrayOfFloat));
  }
  
  private void setStrength(float paramFloat) {}
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    LogUtil.i("sharpen", "ApplyGLSLFilter");
    ClearGLSL();
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    this.guassArray.clear();
    this.dampingArray.clear();
    BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_RGB2YUV_SHADER);
    setNextFilter(localBaseFilter1, null);
    int i = 0;
    while (i < 5)
    {
      localBaseFilter2 = new BaseFilter(GLSLRender.VERTEXT_GAUSS_INNER_H, GLSLRender.FILTER_GAUSS_INNER_H_FRAG);
      setGuass3Coeffs(localBaseFilter2, 0.75F);
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      this.guassArray.add(localBaseFilter2);
      BaseFilter localBaseFilter3 = new BaseFilter(GLSLRender.VERTEXT_GAUSS_INNER_V, GLSLRender.FILTER_GAUSS_INNER_V_FRAG);
      setGuass3Coeffs(localBaseFilter3, 0.75F);
      localBaseFilter2.setNextFilter(localBaseFilter3, null);
      this.guassArray.add(localBaseFilter3);
      localBaseFilter1 = new BaseFilter(GLSLRender.VERTEXT_DAMPING_GAUSS_H, GLSLRender.FILTER_DAMPING_GAUSS_H_FRAG);
      setGuass9Coeffs(localBaseFilter1, 0.75F);
      localBaseFilter1.addParam(new Param.TextureBitmapParam("inputImageTexture3", this.lookupBitmap, 33987, false));
      localBaseFilter3.setNextFilter(localBaseFilter1, null);
      this.guassArray.add(localBaseFilter1);
      this.dampingArray.add(localBaseFilter1);
      i += 1;
    }
    BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_YUV2RGB_SHADER);
    localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { this.srcTextureIndex + 2 });
    localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_ALPHA_ADJUST_REAL);
    localBaseFilter1.addParam(new Param.FloatParam("filterAdjustParam", this.alpha));
    localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex });
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("intensity")) {
      this.alpha = (((Float)paramMap.get("intensity")).floatValue() * 4.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.DeconvSharpenFilter
 * JD-Core Version:    0.7.0.1
 */