package com.tencent.mobileqq.activity.photo.album;

import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicBase$1
  implements View.OnClickListener
{
  PhotoPreviewLogicBase$1(PhotoPreviewLogicBase paramPhotoPreviewLogicBase) {}
  
  @RequiresApi(api=17)
  public void onClick(View paramView)
  {
    this.this$0.onSelectClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase.1
 * JD-Core Version:    0.7.0.1
 */