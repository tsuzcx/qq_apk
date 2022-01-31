package com.tencent.filter.ttpic;

import com.tencent.filter.BaseFilter;
import com.tencent.filter.FilterAlgorithm;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.Param.FloatParam;
import com.tencent.filter.QImage;
import com.tencent.view.RendererUtils;

public class ChannelStretchFilter3
  extends BaseFilter
{
  float lastScaleFilt = 1.0F;
  int paramTEXTRUEID = 0;
  
  public ChannelStretchFilter3(float paramFloat)
  {
    super(GLSLRender.FILTER_CHANNELSTRECH3_SHADER);
    this.lastScaleFilt = paramFloat;
  }
  
  public void ApplyGLSLFilter(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    this.paramTEXTRUEID = RendererUtils.createTexture();
    addParam(new Param.FloatParam("edge", 0.5F));
    addParam(new Param.FloatParam("vmin", 0.0F));
    addParam(new Param.FloatParam("vmax", 1.0F));
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
    float[] arrayOfFloat = FilterAlgorithm.nativeGetMaxAndMin(localQImage2);
    localQImage1.Dispose();
    addParam(new Param.FloatParam("edge", (arrayOfFloat[0] + arrayOfFloat[1]) / 510.0F));
    addParam(new Param.FloatParam("vmin", arrayOfFloat[0] / 255.0F));
    addParam(new Param.FloatParam("vmax", arrayOfFloat[1] / 255.0F));
    GLSLRender.nativeTextImage(localQImage2, this.paramTEXTRUEID);
    localQImage2.Dispose();
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    return super.renderTexture(this.paramTEXTRUEID, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.filter.ttpic.ChannelStretchFilter3
 * JD-Core Version:    0.7.0.1
 */