package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicAECircle$1
  implements View.OnClickListener
{
  PhotoPreviewLogicAECircle$1(PhotoPreviewLogicAECircle paramPhotoPreviewLogicAECircle) {}
  
  public void onClick(View paramView)
  {
    PhotoPreviewLogicAECircle.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicAECircle.1
 * JD-Core Version:    0.7.0.1
 */