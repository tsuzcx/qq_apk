package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoPreviewCustomizationAECMShow$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationAECMShow$1(PhotoPreviewCustomizationAECMShow paramPhotoPreviewCustomizationAECMShow) {}
  
  public void onClick(View paramView)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoPreviewClickConfirmBtn();
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.f.selectedPhotoList);
    ((IAECMSShow)QRoute.api(IAECMSShow.class)).jumpToMe(PhotoPreviewCustomizationAECMShow.a(this.a), localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAECMShow.1
 * JD-Core Version:    0.7.0.1
 */