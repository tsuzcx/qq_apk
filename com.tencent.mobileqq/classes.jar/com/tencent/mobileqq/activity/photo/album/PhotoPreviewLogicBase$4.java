package com.tencent.mobileqq.activity.photo.album;

import ailq;
import android.annotation.TargetApi;
import android.view.View;
import android.widget.Adapter;
import bhqp;
import com.tencent.widget.AdapterView;

class PhotoPreviewLogicBase$4
  implements bhqp
{
  PhotoPreviewLogicBase$4(PhotoPreviewLogicBase paramPhotoPreviewLogicBase) {}
  
  @TargetApi(11)
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)paramAdapterView.getAdapter().getItem(paramInt);
    if (this.this$0.mActivity.getMediaType(paramAdapterView) == 1)
    {
      if (this.this$0.mActivity.mVideoPlayController != null) {
        this.this$0.mActivity.mVideoPlayController.f();
      }
      return;
    }
    if (this.this$0.mPhotoPreviewData.showBar)
    {
      this.this$0.mActivity.hideMenuBar();
      return;
    }
    this.this$0.mActivity.showMenuBar();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicBase.4
 * JD-Core Version:    0.7.0.1
 */