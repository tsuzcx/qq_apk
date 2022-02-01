package com.tencent.aekit.api.supplement.filter;

import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.openapi.filter.TTBeautyV5SimpleDenoiseFilter;

public class AEDenoiseFilter
  extends AEChainI
{
  private static final String TAG = "AEDenoiseFilter";
  private boolean isLowLightEnv;
  private boolean isVeryLowEndDevice;
  private Frame[] mBeforeDenoiseFrame = new Frame[2];
  private BaseFilter mCopyFilter = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private TTBeautyV5SimpleDenoiseFilter mDenoiseFilter = new TTBeautyV5SimpleDenoiseFilter();
  private int mFrameIndex = 0;
  
  public void apply()
  {
    if (this.mIsApplied) {
      return;
    }
    this.mDenoiseFilter.apply();
    this.mCopyFilter.apply();
    int i = 0;
    while (i < this.mBeforeDenoiseFrame.length)
    {
      this.mBeforeDenoiseFrame[i] = new Frame();
      i += 1;
    }
    this.mIsApplied = true;
  }
  
  public void clear()
  {
    if (this.mDenoiseFilter != null) {
      this.mDenoiseFilter.clearGLSL();
    }
    if (this.mCopyFilter != null) {
      this.mCopyFilter.clearGLSL();
    }
    Frame[] arrayOfFrame = this.mBeforeDenoiseFrame;
    int j = arrayOfFrame.length;
    int i = 0;
    while (i < j)
    {
      Frame localFrame = arrayOfFrame[i];
      if (localFrame != null) {
        localFrame.clear();
      }
      i += 1;
    }
    this.mFrameIndex = 0;
    this.mIsApplied = false;
  }
  
  public String printParamInfo()
  {
    return "AEDenoiseFilter {isLowLightEnv=" + this.isLowLightEnv + ", isVeryLowEndDevice=" + this.isVeryLowEndDevice + '}';
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mDenoiseFilter == null) || (!this.isLowLightEnv) || (this.isVeryLowEndDevice)) {}
    do
    {
      return paramFrame;
      this.mFrameIndex += 1;
      this.mCopyFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height, -1, 0.0D, this.mBeforeDenoiseFrame[(this.mFrameIndex % 2)]);
    } while (this.mFrameIndex <= 10);
    this.mDenoiseFilter.setDenoiseTexture(this.mBeforeDenoiseFrame[((this.mFrameIndex + 1) % 2)].getTextureId());
    return this.mDenoiseFilter.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void setLowLightEnv(boolean paramBoolean)
  {
    this.isLowLightEnv = paramBoolean;
  }
  
  public void setVeryLowEndDevice(boolean paramBoolean)
  {
    this.isVeryLowEndDevice = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.supplement.filter.AEDenoiseFilter
 * JD-Core Version:    0.7.0.1
 */