package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.TextureResParam;
import java.util.Map;

public class BaibianFilter
  extends BaseFilter
{
  float blurSize;
  int fragmentShaderId;
  float inputH;
  float inputS;
  float inputV;
  float intensity;
  String resName = null;
  
  public BaibianFilter(int paramInt, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    super(paramInt);
    this.resName = paramString;
    this.fragmentShaderId = paramInt;
    this.blurSize = paramFloat1;
    this.intensity = paramFloat2;
    this.inputH = paramFloat3;
    this.inputS = paramFloat4;
    this.inputV = paramFloat5;
    if ((this.resName != null) || (this.fragmentShaderId != GLSLRender.FILTER_SHADER_NONE))
    {
      addParam(new Param.TextureResParam("inputImageTexture2", this.resName, 33986));
      addParam(new Param.FloatParam("inputH", paramFloat3));
      addParam(new Param.FloatParam("inputS", paramFloat4));
      addParam(new Param.FloatParam("inputV", paramFloat5));
    }
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    if (paramBoolean) {
      if ((this.resName != null) || (this.fragmentShaderId != GLSLRender.FILTER_SHADER_NONE))
      {
        this.glsl_programID = this.fragmentShaderId;
        addParam(new Param.TextureResParam("inputImageTexture2", this.resName, 33986));
        addParam(new Param.FloatParam("inputH", this.inputH));
        addParam(new Param.FloatParam("inputS", this.inputS));
        addParam(new Param.FloatParam("inputV", this.inputV));
      }
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
      BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_GAUSSBLUR_V);
      localBaseFilter2.addParam(new Param.FloatParam("blurSize", this.blurSize));
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_GAUSSBLUR_H);
      localBaseFilter1.addParam(new Param.FloatParam("blurSize", this.blurSize));
      localBaseFilter1.addParam(new Param.FloatParam("intensity", this.intensity * 3.5F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { this.srcTextureIndex + 1 });
      if ((this.resName != null) || (this.fragmentShaderId != GLSLRender.FILTER_SHADER_NONE))
      {
        localBaseFilter2 = new BaseFilter(this.fragmentShaderId);
        localBaseFilter2.addParam(new Param.TextureResParam("inputImageTexture2", this.resName, 33986));
        localBaseFilter2.addParam(new Param.FloatParam("inputH", this.inputH));
        localBaseFilter2.addParam(new Param.FloatParam("inputS", this.inputS));
        localBaseFilter2.addParam(new Param.FloatParam("inputV", this.inputV));
        localBaseFilter1.setNextFilter(localBaseFilter2, null);
      }
    }
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("intensity")) {
      this.intensity = ((Float)paramMap.get("intensity")).floatValue();
    }
    if ((getmNextFilter() != null) && (getmNextFilter().getmNextFilter() != null)) {
      getmNextFilter().getmNextFilter().addParam(new Param.FloatParam("intensity", this.intensity * 3.5F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.BaibianFilter
 * JD-Core Version:    0.7.0.1
 */