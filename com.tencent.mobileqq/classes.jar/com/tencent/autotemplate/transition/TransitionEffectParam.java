package com.tencent.autotemplate.transition;

import com.tencent.tav.coremedia.CMTime;

public class TransitionEffectParam
{
  private CMTime durationTime = CMTime.CMTimeZero;
  private String effectId = "";
  private String filePath = "";
  private boolean isFaceTransition;
  private CMTime leftTransitionTime = CMTime.CMTimeZero;
  private CMTime overlayTime = CMTime.CMTimeZero;
  private CMTime rightTransitionTime = CMTime.CMTimeZero;
  private String stickerId = "";
  
  public TransitionEffectParam clone()
  {
    TransitionEffectParam localTransitionEffectParam = new TransitionEffectParam();
    localTransitionEffectParam.setEffectId(this.effectId);
    localTransitionEffectParam.setFilePath(this.filePath);
    localTransitionEffectParam.setStickerId(this.stickerId);
    localTransitionEffectParam.setLeftTransitionTime(this.leftTransitionTime);
    localTransitionEffectParam.setRightTransitionTime(this.rightTransitionTime);
    localTransitionEffectParam.setOverlayTime(this.overlayTime);
    localTransitionEffectParam.setFaceTransition(this.isFaceTransition);
    localTransitionEffectParam.setDurationTime(this.durationTime);
    return localTransitionEffectParam;
  }
  
  public CMTime getDurationTime()
  {
    return this.durationTime;
  }
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public CMTime getLeftTransitionTime()
  {
    return this.leftTransitionTime;
  }
  
  public CMTime getOverlayTime()
  {
    return this.overlayTime;
  }
  
  public CMTime getRightTransitionTime()
  {
    return this.rightTransitionTime;
  }
  
  public String getStickerId()
  {
    return this.stickerId;
  }
  
  public boolean isFaceTransition()
  {
    return this.isFaceTransition;
  }
  
  public void setDurationTime(CMTime paramCMTime)
  {
    this.durationTime = paramCMTime;
  }
  
  public void setEffectId(String paramString)
  {
    this.effectId = paramString;
  }
  
  public void setFaceTransition(boolean paramBoolean)
  {
    this.isFaceTransition = paramBoolean;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setLeftTransitionTime(CMTime paramCMTime)
  {
    this.leftTransitionTime = paramCMTime;
  }
  
  public void setOverlayTime(CMTime paramCMTime)
  {
    this.overlayTime = paramCMTime;
  }
  
  public void setRightTransitionTime(CMTime paramCMTime)
  {
    this.rightTransitionTime = paramCMTime;
  }
  
  public void setStickerId(String paramString)
  {
    this.stickerId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.autotemplate.transition.TransitionEffectParam
 * JD-Core Version:    0.7.0.1
 */