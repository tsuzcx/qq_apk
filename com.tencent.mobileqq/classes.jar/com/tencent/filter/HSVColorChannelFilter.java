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
    switch (this.channelflag)
    {
    default: 
      this.glslProgramShader = BaseFilter.getFragmentShader(133);
    }
    for (;;)
    {
      addParam(new UniformParam.FloatParam("fh", this.fh));
      addParam(new UniformParam.FloatParam("fs", this.fs));
      addParam(new UniformParam.FloatParam("fv", this.fv));
      addParam(new UniformParam.FloatParam("flb", this.flb));
      addParam(new UniformParam.FloatParam("fld", this.fld));
      addParam(new UniformParam.FloatParam("frd", this.frd));
      addParam(new UniformParam.FloatParam("frb", this.frb));
      addParam(new UniformParam.IntParam("channelflag", this.channelflag));
      super.applyFilterChain(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glslProgramShader = BaseFilter.getFragmentShader(129);
      continue;
      this.glslProgramShader = BaseFilter.getFragmentShader(130);
      continue;
      this.glslProgramShader = BaseFilter.getFragmentShader(131);
      continue;
      this.glslProgramShader = BaseFilter.getFragmentShader(132);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.filter.HSVColorChannelFilter
 * JD-Core Version:    0.7.0.1
 */