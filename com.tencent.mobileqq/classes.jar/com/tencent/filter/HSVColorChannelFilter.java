package com.tencent.filter;

public class HSVColorChannelFilter
  extends BaseFilter
{
  int channelflag = -1;
  float fh = 0.5F;
  float flb = -1.0F;
  float fld = -1.0F;
  float frb = -1.0F;
  float frd = -1.0F;
  float fs = 0.5F;
  float fv = 0.5F;
  
  public HSVColorChannelFilter()
  {
    super(GLSLRender.FILTER_SHADER_HSVCOLOR_ALL);
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    switch (this.channelflag)
    {
    default: 
      this.glsl_programID = GLSLRender.FILTER_SHADER_HSVCOLOR_ALL;
    }
    for (;;)
    {
      addParam(new Param.FloatParam("fh", this.fh));
      addParam(new Param.FloatParam("fs", this.fs));
      addParam(new Param.FloatParam("fv", this.fv));
      addParam(new Param.FloatParam("flb", this.flb));
      addParam(new Param.FloatParam("fld", this.fld));
      addParam(new Param.FloatParam("frd", this.frd));
      addParam(new Param.FloatParam("frb", this.frb));
      addParam(new Param.IntParam("channelflag", this.channelflag));
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glsl_programID = GLSLRender.FILTER_SHADER_HSVCOLOR_0;
      continue;
      this.glsl_programID = GLSLRender.FILTER_SHADER_HSVCOLOR_1;
      continue;
      this.glsl_programID = GLSLRender.FILTER_SHADER_HSVCOLOR_2;
      continue;
      this.glsl_programID = GLSLRender.FILTER_SHADER_HSVCOLOR_3;
    }
  }
  
  int checkColorRange(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    int j = -1;
    int i;
    if ((paramDouble1 < paramDouble2) && (paramDouble2 < paramDouble3) && (paramDouble3 < paramDouble4)) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return i;
            if ((paramDouble1 < paramDouble2) && (paramDouble3 < paramDouble4) && (paramDouble1 > paramDouble4)) {
              return 1;
            }
            if ((paramDouble1 > paramDouble4) && (paramDouble2 < paramDouble3) && (paramDouble3 < paramDouble4)) {
              return 2;
            }
            i = j;
          } while (paramDouble1 >= paramDouble2);
          i = j;
        } while (paramDouble2 >= paramDouble3);
        i = j;
      } while (paramDouble1 <= paramDouble4);
      if (paramDouble1 != 303.0D) {
        break;
      }
      i = j;
    } while (paramDouble2 == 323.0D);
    return 3;
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
    addParam(new Param.FloatParam("fh", this.fh));
    addParam(new Param.FloatParam("fs", this.fs));
    addParam(new Param.FloatParam("fv", this.fv));
    addParam(new Param.FloatParam("flb", this.flb));
    addParam(new Param.FloatParam("fld", this.fld));
    addParam(new Param.FloatParam("frd", this.frd));
    addParam(new Param.FloatParam("frb", this.frb));
    addParam(new Param.IntParam("channelflag", this.channelflag));
    this.glsl_programID = GLSLRender.FILTER_SHADER_HSVCOLOR_ALL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.HSVColorChannelFilter
 * JD-Core Version:    0.7.0.1
 */