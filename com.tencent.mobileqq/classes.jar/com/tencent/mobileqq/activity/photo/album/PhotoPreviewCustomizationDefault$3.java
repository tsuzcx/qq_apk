package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewCustomizationDefault$3
  implements View.OnClickListener
{
  PhotoPreviewCustomizationDefault$3(PhotoPreviewCustomizationDefault paramPhotoPreviewCustomizationDefault) {}
  
  public void onClick(View paramView)
  {
    this.a.s().h.toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault.3
 * JD-Core Version:    0.7.0.1
 */