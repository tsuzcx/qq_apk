package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewLogicReadInJoy$1
  implements View.OnClickListener
{
  PhotoPreviewLogicReadInJoy$1(PhotoPreviewLogicReadInJoy paramPhotoPreviewLogicReadInJoy) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewLogicReadInJoy.a(this.a) == null)
    {
      PhotoPreviewLogicReadInJoy.a(this.a, DialogUtil.a(this.a.mActivity, 0, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131718205), null, ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131718203), ((NewPhotoPreviewActivity)this.a.mActivity).getString(2131718204), new PhotoPreviewLogicReadInJoy.1.1(this), new PhotoPreviewLogicReadInJoy.1.2(this)));
      PhotoPreviewLogicReadInJoy.a(this.a).setCanceledOnTouchOutside(false);
    }
    PhotoPreviewLogicReadInJoy.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicReadInJoy.1
 * JD-Core Version:    0.7.0.1
 */