package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicDefault$2
  implements View.OnClickListener
{
  PhotoPreviewLogicDefault$2(PhotoPreviewLogicDefault paramPhotoPreviewLogicDefault) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).flashPicCb.toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault.2
 * JD-Core Version:    0.7.0.1
 */