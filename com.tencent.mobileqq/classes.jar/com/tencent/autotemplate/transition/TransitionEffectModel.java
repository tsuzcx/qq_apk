package com.tencent.autotemplate.transition;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;

public class TransitionEffectModel
{
  private String effectId = "";
  private String filePath = "";
  private long leftTransitionMs = 0L;
  private long overlayTransitionMs = 0L;
  private long rightTransitionMs = 0L;
  private String stickerId = "";
  private CMTimeRange timeRange = new CMTimeRange(CMTime.CMTimeZero, CMTime.CMTimeZero);
  private int transitionPosition = -1;
  
  public String getEffectId()
  {
    return this.effectId;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getLeftTransitionMs()
  {
    return this.leftTransitionMs;
  }
  
  public long getOverlayTransitionMs()
  {
    return this.overlayTransitionMs;
  }
  
  public long getRightTransitionMs()
  {
    return this.rightTransitionMs;
  }
  
  public String getStickerId()
  {
    return this.stickerId;
  }
  
  public CMTimeRange getTimeRange()
  {
    return this.timeRange;
  }
  
  public int getTransitionPosition()
  {
    return this.transitionPosition;
  }
  
  public void setEffectId(String paramString)
  {
    this.effectId = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setLeftTransitionMs(long paramLong)
  {
    this.leftTransitionMs = paramLong;
  }
  
  public void setOverlayTransitionMs(long paramLong)
  {
    this.overlayTransitionMs = paramLong;
  }
  
  public void setRightTransitionMs(long paramLong)
  {
    this.rightTransitionMs = paramLong;
  }
  
  public void setStickerId(String paramString)
  {
    this.stickerId = paramString;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
  
  public void setTransitionPosition(int paramInt)
  {
    this.transitionPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.TransitionEffectModel
 * JD-Core Version:    0.7.0.1
 */