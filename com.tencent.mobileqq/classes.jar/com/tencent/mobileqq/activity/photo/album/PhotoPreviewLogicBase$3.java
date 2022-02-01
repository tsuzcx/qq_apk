package com.tencent.mobileqq.activity.photo.album;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicBase$3
  implements View.OnClickListener
{
  PhotoPreviewLogicBase$3(PhotoPreviewLogicBase paramPhotoPreviewLogicBase) {}
  
  public void onClick(View paramView)
  {
    this.this$0.mActivity.finish();
    QAlbumUtil.anim(this.this$0.mActivity, true, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase.3
 * JD-Core Version:    0.7.0.1
 */