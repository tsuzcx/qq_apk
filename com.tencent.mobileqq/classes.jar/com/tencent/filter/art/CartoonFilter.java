package com.tencent.filter.art;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;

public class CartoonFilter
  extends BaseFilter
{
  int type;
  
  public CartoonFilter(int paramInt)
  {
    super(GLSLRender.FILTER_SHADER_NONE);
    this.type = paramInt;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    ClearGLSL();
    if (paramBoolean)
    {
      this.glsl_programID = GLSLRender.FILTER_SHADER_NONE;
      setNextFilter(null, null);
    }
    for (;;)
    {
      super.ApplyGLSLFilter(paramBoolean, paramFloat1, paramFloat2);
      return;
      this.glsl_programID = GLSLRender.FILTER_GAUSSBLURV;
      BaseFilter localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_GAUSSBLURH);
      setNextFilter(localBaseFilter2, null);
      BaseFilter localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_GRAYFILTERP);
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_DIRECTIONFILTERP);
      localBaseFilter2.addParam(new Param.FloatParam("threshold", 0.0F));
      localBaseFilter1.setNextFilter(localBaseFilter2, null);
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_STRUCTTENSORFILTER);
      localBaseFilter2.setNextFilter(localBaseFilter1, null);
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_FLOWBASEDBL);
      localBaseFilter2.addParam(new Param.FloatParam("inv_2sigma2", 127.00195F));
      localBaseFilter2.addParam(new Param.FloatParam("inv_sigma_root_2pi", 0.0008F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 2 });
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_FLOWBASEDDOGFOREDGE);
      localBaseFilter1.addParam(new Param.FloatParam("par", 0.15F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_FLOWBASEDDOG);
      localBaseFilter2.addParam(new Param.FloatParam("par", 0.35F));
      localBaseFilter2.addParam(new Param.FloatParam("par_b", 0.2F));
      localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 4, 5 });
      localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_FLOWBASEDBLUR);
      localBaseFilter1.addParam(new Param.FloatParam("inv_2sigma", 12.0F));
      localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
      if (this.type == 1)
      {
        localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_BILATERALFILTER_NEW);
        localBaseFilter2.addParam(new Param.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter2.addParam(new Param.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 5, 4 });
        localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_BILATERALFILTER2_NEW);
        localBaseFilter1.addParam(new Param.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter1.addParam(new Param.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
        localBaseFilter1.setNextFilter(new BaseFilter(GLSLRender.FILTER_MIXEDGEFILTEREDIT), new int[] { 8 });
      }
      else if (this.type == 2)
      {
        localBaseFilter2 = new BaseFilter(GLSLRender.FILTER_BILATERALFILTER_NEW);
        localBaseFilter2.addParam(new Param.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter2.addParam(new Param.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter1.setNextFilter(localBaseFilter2, new int[] { 5, 4 });
        localBaseFilter1 = new BaseFilter(GLSLRender.FILTER_BILATERALFILTER2_NEW);
        localBaseFilter1.addParam(new Param.FloatParam("inv_2sigma2", 144.5F));
        localBaseFilter1.addParam(new Param.FloatParam("inv_sigma_root_2pi", 0.02F));
        localBaseFilter2.setNextFilter(localBaseFilter1, new int[] { 4 });
        localBaseFilter1.setNextFilter(new BaseFilter(GLSLRender.FILTER_MIXEDGENOSTAGE), new int[] { 8 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.art.CartoonFilter
 * JD-Core Version:    0.7.0.1
 */