package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment;
import dov.com.qq.im.ae.report.AEBaseDataReporter;

class PhotoPreviewLogicAECMShow$1
  implements View.OnClickListener
{
  PhotoPreviewLogicAECMShow$1(PhotoPreviewLogicAECMShow paramPhotoPreviewLogicAECMShow) {}
  
  public void onClick(View paramView)
  {
    AEBaseDataReporter.a().aG();
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", PhotoPreviewLogicAECMShow.a(this.a).selectedPhotoList);
    AECMShowPhotoPreviewFragment.a(this.a.mActivity, localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAECMShow.1
 * JD-Core Version:    0.7.0.1
 */