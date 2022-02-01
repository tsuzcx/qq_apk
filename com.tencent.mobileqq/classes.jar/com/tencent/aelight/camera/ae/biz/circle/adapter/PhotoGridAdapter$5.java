package com.tencent.aelight.camera.ae.biz.circle.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.biz.circle.event.AECircleSelectChangeEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class PhotoGridAdapter$5
  implements View.OnClickListener
{
  PhotoGridAdapter$5(PhotoGridAdapter paramPhotoGridAdapter, int paramInt, PhotoGridAdapter.PhotoVH paramPhotoVH) {}
  
  public void onClick(View paramView)
  {
    PhotoGridAdapter.b(this.c, this.a, this.b);
    SimpleEventBus.getInstance().dispatchEvent(new AECircleSelectChangeEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.5
 * JD-Core Version:    0.7.0.1
 */