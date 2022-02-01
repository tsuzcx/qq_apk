package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicAIO$1
  implements View.OnClickListener
{
  PhotoPreviewLogicAIO$1(PhotoPreviewLogicAIO paramPhotoPreviewLogicAIO) {}
  
  public void onClick(View paramView)
  {
    ((NewPhotoPreviewActivity)this.a.mActivity).flashPicCb.toggle();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAIO.1
 * JD-Core Version:    0.7.0.1
 */