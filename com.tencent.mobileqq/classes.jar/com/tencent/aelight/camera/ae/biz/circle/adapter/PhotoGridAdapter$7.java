package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleJumpCameraPageEvent;
import com.tencent.aelight.camera.aebase.AEReportUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class PhotoGridAdapter$7
  implements View.OnClickListener
{
  PhotoGridAdapter$7(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public void onClick(View paramView)
  {
    SimpleEventBus.getInstance().dispatchEvent(new AECircleJumpCameraPageEvent());
    AEReportUtils.a(7, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.7
 * JD-Core Version:    0.7.0.1
 */