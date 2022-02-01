package com.tencent.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;

public class HSVColorChannelFilter
  extends BaseFilter
{
  private int channelflag = -1;
  private float fh = 0.5F;
  private float flb = -1.0F;
  private float fld = -1.0F;
  private float frb = -1.0F;
  private float frd = -1.0F;
  private float fs = 0.5F;
  private float fv = 0.5F;
  
  public HSVColorChannelFilter()
  {
    super(BaseFilter.getFragmentShader(133));
  }
  
  public void applyFilterChain(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    int i = this.channelflag;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            this.glslProgramShader = BaseFilter.getFragmentShader(133);
          } else {
            this.glslProgramShader = BaseFilter.getFragmentShader(132);
          }
        }
        else {
          this.glslProgramShader = BaseFilter.getFragmentShader(131);
        }
      }
      else {
        this.glslProgramShader = BaseFilter.getFragmentShader(130);
      }
    }
    else {
      this.glslProgramShader = BaseFilter.getFragmentShader(129);
    }
    addParam(new UniformParam.FloatParam("fh", this.fh));
    addParam(new UniformParam.FloatParam("fs", this.fs));
    addParam(new UniformParam.FloatParam("fv", this.fv));
    addParam(new UniformParam.FloatParam("flb", this.flb));
    addParam(new UniformParam.FloatParam("fld", this.fld));
    addParam(new UniformParam.FloatParam("frd", this.frd));
    addParam(new UniformParam.FloatParam("frb", this.frb));
    addParam(new UniformParam.IntParam("channelflag", this.channelflag));
    super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
  }
  
  int checkColorRange(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    if ((paramDouble1 < paramDouble2) && (paramDouble2 < paramDouble3) && (paramDouble3 < paramDouble4)) {
      return 0;
    }
    if ((paramDouble1 < paramDouble2) && (paramDouble3 < paramDouble4) && (paramDouble1 > paramDouble4)) {
      return 1;
    }
    if ((paramDouble1 > paramDouble4) && (paramDouble2 < paramDouble3) && (paramDouble3 < paramDouble4)) {
      return 2;
    }
    if ((paramDouble1 < paramDouble2) && (paramDouble2 < paramDouble3) && (paramDouble1 > paramDouble4))
    {
      if ((paramDouble1 == 303.0D) && (paramDouble2 == 323.0D)) {
        return -1;
      }
      return 3;
    }
    return -1;
  }
  
  public void setInput(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7)
  {
    this.flb = (paramFloat4 / 360.0F);
    this.fld = (paramFloat5 / 360.0F);
    this.frd = (paramFloat6 / 360.0F);
    this.frb = (paramFloat7 / 360.0F);
    this.fh = (paramFloat1 / 180.0F * 0.5F);
    this.fs = (paramFloat2 / 100.0F);
    this.fv = (paramFloat3 / 100.0F);
    this.channelflag = checkColorRange(paramFloat4, paramFloat5, paramFloat6, paramFloat7);
    addParam(new UniformParam.FloatParam("fh", this.fh));
    addParam(new UniformParam.FloatParam("fs", this.fs));
    addParam(new UniformParam.FloatParam("fv", this.fv));
    addParam(new UniformParam.FloatParam("flb", this.flb));
    addParam(new UniformParam.FloatParam("fld", this.fld));
    addParam(new UniformParam.FloatParam("frd", this.frd));
    addParam(new UniformParam.FloatParam("frb", this.frb));
    addParam(new UniformParam.IntParam("channelflag", this.channelflag));
    this.glslProgramShader = BaseFilter.getFragmentShader(133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.filter.HSVColorChannelFilter
 * JD-Core Version:    0.7.0.1
 */