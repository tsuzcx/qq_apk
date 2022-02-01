package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.aelight.camera.cmsshow.api.IAECMSShow;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.qroute.QRoute;

public class PhotoListCustomizationAECameraForCMShow
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAECameraForCMShow";
  protected long i;
  
  PhotoListCustomizationAECameraForCMShow(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(View paramView)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExit(System.currentTimeMillis() - this.i);
    this.i = System.currentTimeMillis();
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.e.selectedPhotoList);
    ((IAECMSShow)QRoute.api(IAECMSShow.class)).jumpToMe(this.c, paramView);
  }
  
  public void b(Intent paramIntent)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExit(System.currentTimeMillis() - this.i);
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListClickCloseBtn();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExit(System.currentTimeMillis() - this.i);
    super.b(paramView);
  }
  
  protected void f(LocalMediaInfo paramLocalMediaInfo)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListPickPhoto();
    super.f(paramLocalMediaInfo);
  }
  
  public void k()
  {
    this.i = System.currentTimeMillis();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExpose();
    super.k();
    this.h.n.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAECameraForCMShow
 * JD-Core Version:    0.7.0.1
 */