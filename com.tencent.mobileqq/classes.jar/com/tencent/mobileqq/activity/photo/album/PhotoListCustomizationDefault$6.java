package com.tencent.mobileqq.activity.photo.album;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoListCustomizationDefault$6
  implements View.OnClickListener
{
  PhotoListCustomizationDefault$6(PhotoListCustomizationDefault paramPhotoListCustomizationDefault) {}
  
  public void onClick(View paramView)
  {
    this.a.a(paramView, new Bundle(), 2, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault.6
 * JD-Core Version:    0.7.0.1
 */