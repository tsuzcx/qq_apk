package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewCustomizationAIO$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationAIO$1(PhotoPreviewCustomizationAIO paramPhotoPreviewCustomizationAIO) {}
  
  public void onClick(View paramView)
  {
    this.a.s().h.toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO.1
 * JD-Core Version:    0.7.0.1
 */