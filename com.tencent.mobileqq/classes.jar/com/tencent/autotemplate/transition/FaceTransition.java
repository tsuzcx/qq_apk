package com.tencent.autotemplate.transition;

import com.tencent.tav.coremedia.CMTimeRange;

public class FaceTransition
{
  private int position;
  private int procMethod;
  private CMTimeRange timeRange;
  
  public int getPosition()
  {
    return this.position;
  }
  
  public int getProcMethod()
  {
    return this.procMethod;
  }
  
  public CMTimeRange getTimeRange()
  {
    if (this.timeRange == null) {
      this.timeRange = CMTimeRange.CMTimeRangeInvalid;
    }
    return this.timeRange;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void setProcMethod(int paramInt)
  {
    this.procMethod = paramInt;
  }
  
  public void setTimeRange(CMTimeRange paramCMTimeRange)
  {
    this.timeRange = paramCMTimeRange;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.transition.FaceTransition
 * JD-Core Version:    0.7.0.1
 */