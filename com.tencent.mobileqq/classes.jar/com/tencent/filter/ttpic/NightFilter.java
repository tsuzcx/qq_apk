package com.tencent.filter.ttpic;

import android.opengl.GLES20;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.HistogramsStrectchFilter;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.Param.FloatsParam;
import com.tencent.filter.Param.IntParam;
import com.tencent.filter.art.DepthFilter;
import java.util.HashMap;
import java.util.Map;

public class NightFilter
  extends BaseFilter
{
  public NightFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (paramBoolean)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    float f1 = paramFloat1 / 2.0F;
    float f2 = paramFloat2 / 2.0F;
    float f3 = Math.min(paramFloat1, paramFloat2) / 4.0F;
    Object localObject1 = new DepthFilter();
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("bokehType", Integer.valueOf(1));
    ((Map)localObject2).put("blurRiness", Float.valueOf(0.4F));
    ((Map)localObject2).put("innerRadius", Float.valueOf(f3));
    ((Map)localObject2).put("outerRadius", Float.valueOf(f3 + 60.0F));
    ((Map)localObject2).put("tx", Float.valueOf(f1));
    ((Map)localObject2).put("ty", Float.valueOf(f2));
    ((Map)localObject2).put("theta", Float.valueOf(0.0F));
    ((Map)localObject2).put("eclipseA", Float.valueOf(1.5F));
    ((Map)localObject2).put("MethodType", Integer.valueOf(1));
    ((Map)localObject2).put("lumi_threshold", Float.valueOf(0.0F));
    ((Map)localObject2).put("lumi_weight", Float.valueOf(0.0F));
    ((Map)localObject2).put("defaultWidth", Float.valueOf(400.0F));
    if (canUseNormalBokeh()) {
      ((Map)localObject2).put("bokehmode", Integer.valueOf(1));
    }
    for (;;)
    {
      ((BaseFilter)localObject1).setParameterDic((Map)localObject2);
      ((Map)localObject2).clear();
      ((BaseFilter)localObject1).ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      setNextFilter((BaseFilter)localObject1, null);
      localObject2 = ((BaseFilter)localObject1).getLastFilter();
      int i = getTheFilterIndex((BaseFilter)localObject2);
      localObject1 = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
      ((BaseFilter)localObject1).scaleFact = Math.min(100.0F / Math.min(paramFloat2, paramFloat1), 1.0F);
      ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
      localObject2 = new HistogramsStrectchFilter();
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, new int[] { this.srcTextureIndex + 1 + i });
      localObject1 = new BaseFilter(GLSLRender.FILTER_HIGHTLIGHT_SHADOW_SHADER);
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("shadows", 0.45F));
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("highlights", 0.0F));
      ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
      localObject2 = new BaseFilter(GLSLRender.VERTEXT_HSVCHANNELSHARPEN_SHADER, GLSLRender.FILTER_HSVNCHANNEL_SHARPEN_SHADER);
      ((BaseFilter)localObject2).addParam(new Param.FloatParam("sharpness", 0.2F));
      ((BaseFilter)localObject2).addParam(new Param.FloatParam("inputH", 1.0F));
      ((BaseFilter)localObject2).addParam(new Param.FloatParam("inputS", 1.36F));
      ((BaseFilter)localObject2).addParam(new Param.FloatParam("inputV", 1.1F));
      ((BaseFilter)localObject2).addParam(new Param.FloatParam("imageWidthFactor", 1.0F / paramFloat1));
      ((BaseFilter)localObject2).addParam(new Param.FloatParam("imageHeightFactor", 1.0F / paramFloat2));
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
      localObject1 = new BaseFilter(GLSLRender.FILTER_VIBRANCE);
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("contrast", 1.32F));
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("saturation", 0.758F));
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("brightness", 1.0F));
      ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
      localObject2 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_BALANCE);
      ((BaseFilter)localObject2).addParam(new Param.FloatsParam("shadowsShift", new float[] { 0.0627451F, 0.0F, -0.0627451F }));
      ((BaseFilter)localObject2).addParam(new Param.FloatsParam("midtonesShift", new float[] { 0.0627451F, 0.0F, -0.0627451F }));
      ((BaseFilter)localObject2).addParam(new Param.FloatsParam("highlightsShift", new float[] { 0.0F, 0.0F, 0.0F }));
      ((BaseFilter)localObject2).addParam(new Param.IntParam("preserveLuminosity", 1));
      ((BaseFilter)localObject1).setNextFilter((BaseFilter)localObject2, null);
      localObject1 = new BaseFilter(GLSLRender.FILTER_SHADER_COLOR_TEMP);
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("scaleC", -0.2715F));
      ((BaseFilter)localObject1).addParam(new Param.FloatParam("scaleT", 0.0F));
      ((BaseFilter)localObject2).setNextFilter((BaseFilter)localObject1, null);
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      ((Map)localObject2).put("bokehmode", Integer.valueOf(2));
    }
  }
  
  public boolean canUseNormalBokeh()
  {
    String str = GLES20.glGetString(7937);
    if (str == null) {}
    while ((str.indexOf("NVIDIA Tegra") != -1) || (str.indexOf("VideoCore IV HW") != -1) || (str.indexOf("PowerVR SGX 544MP") != -1)) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.NightFilter
 * JD-Core Version:    0.7.0.1
 */