package com.tencent.aelight.camera.ae.biz.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class AECircleTitleAlbumMenuChangeEvent
  extends SimpleBaseEvent
{
  private boolean isShow;
  
  public AECircleTitleAlbumMenuChangeEvent(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public boolean getIsShow()
  {
    return this.isShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.event.AECircleTitleAlbumMenuChangeEvent
 * JD-Core Version:    0.7.0.1
 */