package com.tencent.aekit.api.supplement.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.ttpic.filter.FabbyStrokeFilter;
import com.tencent.ttpic.openapi.PTSegAttr;

public class AESegmentForQQ
  extends AEChainI
{
  private boolean isSegReady = false;
  private FabbyStrokeFilter mFabbyStrokeFilter = new FabbyStrokeFilter();
  private float strokeGapInPixel;
  private float strokeWidthInPixel;
  
  public void apply()
  {
    if (this.mIsApplied) {
      return;
    }
    this.mFabbyStrokeFilter.apply();
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if (this.mFabbyStrokeFilter != null) {
      this.mFabbyStrokeFilter.clearGLSLSelf();
    }
    this.mIsApplied = false;
  }
  
  public String printParamInfo()
  {
    return "AESegmentForQQ {strokeGapInPixel=" + this.strokeGapInPixel + ", strokeWidthInPixel=" + this.strokeWidthInPixel + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    this.mFabbyStrokeFilter.setStepX(1.0F / paramFrame.width);
    this.mFabbyStrokeFilter.setStepY(1.0F / paramFrame.height);
    Frame localFrame = paramFrame;
    if (this.isSegReady == true) {
      localFrame = this.mFabbyStrokeFilter.render(paramFrame);
    }
    return localFrame;
  }
  
  public void setBgColor(float[] paramArrayOfFloat)
  {
    this.mFabbyStrokeFilter.setBgColor(paramArrayOfFloat);
  }
  
  public void setSegAttr(PTSegAttr paramPTSegAttr)
  {
    if ((paramPTSegAttr != null) && (paramPTSegAttr.getMaskFrame() != null))
    {
      this.mFabbyStrokeFilter.setmMaskTex(paramPTSegAttr.getMaskFrame().getTextureId());
      this.isSegReady = true;
      return;
    }
    this.isSegReady = false;
  }
  
  public void setStrokeColor(float[] paramArrayOfFloat)
  {
    this.mFabbyStrokeFilter.setStrokeColor(paramArrayOfFloat);
  }
  
  public void setStrokeGapInPixel(float paramFloat)
  {
    this.strokeGapInPixel = paramFloat;
    this.mFabbyStrokeFilter.setStrokeGapInPixel(paramFloat);
  }
  
  public void setStrokeWidthInPixel(float paramFloat)
  {
    this.strokeWidthInPixel = paramFloat;
    this.mFabbyStrokeFilter.setStrokeWidthInPixel(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.supplement.filter.AESegmentForQQ
 * JD-Core Version:    0.7.0.1
 */