package com.tencent.aelight.camera.ae.biz.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class AECircleSelectChangeEvent
  extends SimpleBaseEvent
{
  boolean mImageDragEventFlag = false;
  
  public boolean getImageDragEventFlag()
  {
    return this.mImageDragEventFlag;
  }
  
  public void setImageDragEventFlag(boolean paramBoolean)
  {
    this.mImageDragEventFlag = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent
 * JD-Core Version:    0.7.0.1
 */