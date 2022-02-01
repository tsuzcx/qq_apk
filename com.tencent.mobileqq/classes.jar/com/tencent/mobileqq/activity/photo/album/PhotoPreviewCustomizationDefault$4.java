package com.tencent.mobileqq.activity.photo.album;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewCustomizationDefault$4
  implements View.OnClickListener
{
  PhotoPreviewCustomizationDefault$4(PhotoPreviewCustomizationDefault paramPhotoPreviewCustomizationDefault) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView, -1, new Bundle(), 2, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault.4
 * JD-Core Version:    0.7.0.1
 */