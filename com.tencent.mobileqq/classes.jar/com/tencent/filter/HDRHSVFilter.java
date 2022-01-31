package com.tencent.filter;

import com.tencent.view.RendererUtils;
import java.util.Map;

public class HDRHSVFilter
  extends BaseFilter
{
  float max_ratio = 0.999F;
  float min_ratio = 0.001F;
  float saturationMag = 1.25F;
  private BaseFilter sharpen = null;
  float sharpnessMag = 0.3F;
  private ChannelStretchFilter stretech = null;
  float stretechMag = 25.0F;
  
  public HDRHSVFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    float f = Math.min(paramFloat2, paramFloat1);
    this.scaleFact = Math.min(100.0F / f, 1.0F);
    Object localObject2 = new HistogramsStrectchFilter(this.min_ratio, this.max_ratio);
    setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex });
    Object localObject1 = new BaseFilter(GLSLRender.FILTER_RGBTOHSV);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
    ((BaseFilter)localObject2).scaleFact = Math.min(400.0F / f, 1.0F);
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    this.stretech = new ChannelStretchFilter(((BaseFilter)localObject2).scaleFact);
    this.stretech.updateparam(this.stretechMag);
    ((BaseFilter)localObject2).setNextFilter(this.stretech, new int[] { this.srcTextureIndex + 3 });
    localObject1 = this.stretech;
    this.sharpen = new BaseFilter(GLSLRender.VERTEXT_SHADER_SHARPEN, GLSLRender.FILTER_CHANNEL_SHARPEN_FR);
    this.sharpen.addParam(new Param.FloatParam("sharpness", this.sharpnessMag));
    ((BaseFilter)localObject1).setNextFilter(this.sharpen, null);
    localObject2 = this.sharpen;
    localObject1 = new BaseFilter(GLSLRender.FILTER_HSVTORGB);
    ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
    localObject2 = new BaseFilter(GLSLRender.FILTER_CHANNEL_SATURATION);
    ((BaseFilter)localObject2).addParam(new Param.FloatParam("saturation", this.saturationMag));
    ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
    super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
  }
  
  public boolean isAdjustFilter()
  {
    return true;
  }
  
  public void setAdjustParam(float paramFloat)
  {
    paramFloat = (float)Math.max((float)Math.min(paramFloat, 1.0D), 0.0D);
    this.stretechMag = (50.0F * paramFloat);
    this.sharpnessMag = (0.6F * paramFloat);
    if (this.stretech != null) {
      this.stretech.updateparam(this.stretechMag);
    }
    if (this.sharpen != null) {
      this.sharpen.addParam(new Param.FloatParam("sharpness", this.sharpnessMag));
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("stretechMag")) {
      this.stretechMag = ((Float)paramMap.get("stretechMag")).floatValue();
    }
    if (paramMap.containsKey("sharpnessMag")) {
      this.sharpnessMag = ((Float)paramMap.get("sharpnessMag")).floatValue();
    }
    if (paramMap.containsKey("saturationMag")) {
      this.saturationMag = ((Float)paramMap.get("saturationMag")).floatValue();
    }
    if (paramMap.containsKey("percent"))
    {
      this.min_ratio = ((Float)paramMap.get("percent")).floatValue();
      this.max_ratio = (1.0F - this.min_ratio);
    }
  }
  
  public static class ChannelStretchFilter
    extends BaseFilter
  {
    float lastScaleFilt = 1.0F;
    int paramTEXTRUEID = 0;
    float stretechMag = 25.0F;
    
    public ChannelStretchFilter(float paramFloat)
    {
      super();
      this.lastScaleFilt = paramFloat;
    }
    
    public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
    {
      this.paramTEXTRUEID = RendererUtils.createTexture();
      addParam(new Param.FloatParam("strength", this.stretechMag));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
    }
    
    public void ClearGLSL()
    {
      RendererUtils.clearTexture(this.paramTEXTRUEID);
      super.ClearGLSL();
    }
    
    public void beforeRender(int paramInt1, int paramInt2, int paramInt3)
    {
      QImage localQImage1 = RendererUtils.saveTexture2QImage(paramInt1, paramInt2, paramInt3);
      QImage localQImage2 = localQImage1.InplaceBlur8bitQImage(1, (int)(80.0F * this.lastScaleFilt));
      localQImage1.Dispose();
      GLSLRender.nativeTextImage(localQImage2, this.paramTEXTRUEID);
      localQImage2.Dispose();
    }
    
    public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
    {
      setTextureParam(this.paramTEXTRUEID, 1);
      return super.renderTexture(paramInt1, paramInt2, paramInt3);
    }
    
    public void updateparam(float paramFloat)
    {
      this.stretechMag = paramFloat;
      addParam(new Param.FloatParam("strength", this.stretechMag));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.HDRHSVFilter
 * JD-Core Version:    0.7.0.1
 */