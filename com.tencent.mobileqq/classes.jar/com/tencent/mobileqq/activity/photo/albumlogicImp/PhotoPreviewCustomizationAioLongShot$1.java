package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PhotoPreviewCustomizationAioLongShot$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationAioLongShot$1(PhotoPreviewCustomizationAioLongShot paramPhotoPreviewCustomizationAioLongShot) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(PhotoPreviewCustomizationAioLongShot.a(this.a), (String)this.a.f.selectedPhotoList.get(0), new PhotoPreviewCustomizationAioLongShot.1.1(this));
    AIOLongShotHelper.a("0X8009DEE");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAioLongShot.1
 * JD-Core Version:    0.7.0.1
 */