package com.tencent.mobileqq.activity.photo.album;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicDefault$3
  implements View.OnClickListener
{
  PhotoPreviewLogicDefault$3(PhotoPreviewLogicDefault paramPhotoPreviewLogicDefault) {}
  
  public void onClick(View paramView)
  {
    this.a.onMagicStickClick(paramView, -1, new Bundle(), 2, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.3
 * JD-Core Version:    0.7.0.1
 */