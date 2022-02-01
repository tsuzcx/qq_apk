package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PhotoPreviewLogicAioLongShot$1
  implements View.OnClickListener
{
  PhotoPreviewLogicAioLongShot$1(PhotoPreviewLogicAioLongShot paramPhotoPreviewLogicAioLongShot) {}
  
  public void onClick(View paramView)
  {
    AIOLongShotHelper.a(this.a.mActivity, (String)PhotoPreviewLogicAioLongShot.a(this.a).selectedPhotoList.get(0), new PhotoPreviewLogicAioLongShot.1.1(this));
    AIOLongShotHelper.a("0X8009DEE");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAioLongShot.1
 * JD-Core Version:    0.7.0.1
 */