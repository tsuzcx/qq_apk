package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewCustomizationReadInJoy$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationReadInJoy$1(PhotoPreviewCustomizationReadInJoy paramPhotoPreviewCustomizationReadInJoy) {}
  
  public void onClick(View paramView)
  {
    if (PhotoPreviewCustomizationReadInJoy.a(this.a) == null)
    {
      PhotoPreviewCustomizationReadInJoy localPhotoPreviewCustomizationReadInJoy = this.a;
      PhotoPreviewCustomizationReadInJoy.a(localPhotoPreviewCustomizationReadInJoy, DialogUtil.a(PhotoPreviewCustomizationReadInJoy.b(localPhotoPreviewCustomizationReadInJoy), 0, PhotoPreviewCustomizationReadInJoy.c(this.a).getString(2131915340), null, PhotoPreviewCustomizationReadInJoy.d(this.a).getString(2131915338), PhotoPreviewCustomizationReadInJoy.e(this.a).getString(2131915339), new PhotoPreviewCustomizationReadInJoy.1.1(this), new PhotoPreviewCustomizationReadInJoy.1.2(this)));
      PhotoPreviewCustomizationReadInJoy.a(this.a).setCanceledOnTouchOutside(false);
    }
    PhotoPreviewCustomizationReadInJoy.a(this.a).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationReadInJoy.1
 * JD-Core Version:    0.7.0.1
 */