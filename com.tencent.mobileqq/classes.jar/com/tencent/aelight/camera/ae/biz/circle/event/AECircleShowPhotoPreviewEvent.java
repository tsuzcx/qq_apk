package com.tencent.aelight.camera.ae.biz.circle.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.util.List;

public class AECircleShowPhotoPreviewEvent
  extends SimpleBaseEvent
{
  public List<LocalMediaInfo> mPhotoInfoList;
  public int mPosition;
  
  public AECircleShowPhotoPreviewEvent(List<LocalMediaInfo> paramList, int paramInt)
  {
    this.mPhotoInfoList = paramList;
    this.mPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.event.AECircleShowPhotoPreviewEvent
 * JD-Core Version:    0.7.0.1
 */