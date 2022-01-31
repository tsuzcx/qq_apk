package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import java.util.Map;

public class DepthFilter
  extends BaseFilter
{
  public static final int MethodTypeEllipse = 1;
  public static final int MethodTypeNone = 0;
  public static final int MethodTypeParallel = 2;
  public static final int MethodTypeRound = 3;
  float blurDepthr = 1.2F;
  float blurRiness = 0.5F;
  int bokehType = 1;
  int bokehmode = 1;
  float defaultWidth = 960.0F;
  float eclipseA;
  float innerRadius;
  float input_radius = 0.5F;
  float lumi_threshold = 0.0F;
  float lumi_weight = (float)(1.0D / Math.exp(0.0D));
  float outerRadius;
  int radius = 8;
  float theta;
  float tx;
  float ty;
  int type;
  
  public DepthFilter()
  {
    super(GLSLRender.FILTER_SHADER_NONE);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (IsFilterInvalute())
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
    }
    this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
    Object localObject;
    BaseFilter localBaseFilter;
    int i;
    float f2;
    float f1;
    if (this.type != 0)
    {
      if (this.bokehType == 0) {
        break label361;
      }
      this.scaleFact = (Math.min(this.defaultWidth / Math.max(paramFloat1, paramFloat2), 1.0F) * this.input_radius);
      localObject = new BokehFilter.BokehBaseFilter(this.radius, this.lumi_weight, this.lumi_threshold, this.bokehType, this.bokehmode);
      ((BaseFilter)localObject).addParam(new Param.FloatParam("lumi_p", this.radius * 1.0F));
      ((BaseFilter)localObject).setScaleFact(this.scaleFact);
      setNextFilter((BaseFilter)localObject, null);
      localBaseFilter = new BaseFilter(GLSLRender.FILTER_SHADER_NONE);
      ((BaseFilter)localObject).setNextFilter(localBaseFilter, null);
      i = GLSLRender.FILTER_TILT_TOUCH_ECLIPSE_NEW;
      f2 = this.theta;
      f1 = this.eclipseA;
      switch (this.type)
      {
      }
    }
    for (;;)
    {
      localObject = new BaseFilter(i);
      ((BaseFilter)localObject).addParam(new Param.FloatParam("ratio", paramFloat2 / paramFloat1));
      ((BaseFilter)localObject).addParam(new Param.FloatParam("tx", this.tx / paramFloat1));
      ((BaseFilter)localObject).addParam(new Param.FloatParam("ty", this.ty / paramFloat2));
      ((BaseFilter)localObject).addParam(new Param.FloatParam("innerRadius", this.innerRadius / paramFloat1));
      ((BaseFilter)localObject).addParam(new Param.FloatParam("outerRadius", this.outerRadius / paramFloat1));
      ((BaseFilter)localObject).addParam(new Param.FloatParam("theta", f2));
      ((BaseFilter)localObject).addParam(new Param.FloatParam("eclipseA", f1));
      localBaseFilter.setNextFilter((BaseFilter)localObject, new int[] { 0 });
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      label361:
      localBaseFilter = new BaseFilter(GLSLRender.FILTER_TILT_TOUCH_GAUSS);
      localBaseFilter.addParam(new Param.FloatParam("depthr", this.blurDepthr));
      setNextFilter(localBaseFilter, null);
      break;
      i = GLSLRender.FILTER_TILT_TOUCH_ECLIPSE_NEW;
      continue;
      i = GLSLRender.FILTER_TILT_TOUCH_LINE_NEW;
      continue;
      f2 = 0.0F;
      f1 = 1.0F;
      i = GLSLRender.FILTER_TILT_TOUCH_ECLIPSE_NEW;
    }
  }
  
  public void setInput_radius(float paramFloat)
  {
    this.input_radius = (1.0F - paramFloat);
    this.radius = 5;
    if ((this.input_radius < 0.8D) && (this.input_radius > 0.4F)) {
      this.radius = 8;
    }
    for (;;)
    {
      if (this.bokehmode == 2) {
        this.input_radius = (1.0F - 0.6F * paramFloat);
      }
      if (paramFloat >= 0.3D) {
        break;
      }
      this.blurDepthr = (3.0F * paramFloat);
      return;
      if (this.input_radius <= 0.4F)
      {
        this.input_radius = 0.4F;
        this.radius = ((int)(8 + 6.0F * paramFloat));
      }
    }
    this.blurDepthr = ((paramFloat - 0.3F) * 1.3F + 0.9F);
  }
  
  public void setParameterDic(Map<String, Object> paramMap)
  {
    if (paramMap.containsKey("bokehmode")) {
      this.bokehmode = ((Integer)paramMap.get("bokehmode")).intValue();
    }
    if (paramMap.containsKey("inputradius")) {
      setInput_radius(((Float)paramMap.get("input_radius")).floatValue());
    }
    if (paramMap.containsKey("blurRiness"))
    {
      this.blurRiness = ((Float)paramMap.get("blurRiness")).floatValue();
      setInput_radius(this.blurRiness);
    }
    if (paramMap.containsKey("MethodType")) {
      this.type = ((Integer)paramMap.get("MethodType")).intValue();
    }
    if (paramMap.containsKey("bokehType")) {
      this.bokehType = (((Integer)paramMap.get("bokehType")).intValue() % 6);
    }
    if (paramMap.containsKey("tx")) {
      this.tx = ((Float)paramMap.get("tx")).floatValue();
    }
    if (paramMap.containsKey("ty")) {
      this.ty = ((Float)paramMap.get("ty")).floatValue();
    }
    if (paramMap.containsKey("innerRadius")) {
      this.innerRadius = ((Float)paramMap.get("innerRadius")).floatValue();
    }
    if (paramMap.containsKey("outerRadius")) {
      this.outerRadius = ((Float)paramMap.get("outerRadius")).floatValue();
    }
    if (paramMap.containsKey("theta")) {
      this.theta = ((Float)paramMap.get("theta")).floatValue();
    }
    if (paramMap.containsKey("eclipseA")) {
      this.eclipseA = ((Float)paramMap.get("eclipseA")).floatValue();
    }
    if (paramMap.containsKey("defaultWidth")) {
      this.defaultWidth = ((Float)paramMap.get("defaultWidth")).floatValue();
    }
    if (paramMap.containsKey("lumi_threshold")) {
      this.lumi_threshold = ((Float)paramMap.get("lumi_threshold")).floatValue();
    }
    if (paramMap.containsKey("lumi_weight")) {
      this.lumi_weight = ((float)(1.0D / Math.exp(((Float)paramMap.get("lumi_weight")).floatValue())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.DepthFilter
 * JD-Core Version:    0.7.0.1
 */