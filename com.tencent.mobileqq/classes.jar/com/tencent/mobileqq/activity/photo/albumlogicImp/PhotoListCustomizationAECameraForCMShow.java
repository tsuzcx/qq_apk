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
  protected long a;
  
  PhotoListCustomizationAECameraForCMShow(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void a(View paramView)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExit(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramView = new Intent();
    paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList);
    ((IAECMSShow)QRoute.api(IAECMSShow.class)).jumpToMe(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramView);
  }
  
  public void b(Intent paramIntent)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExit(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    super.b(paramIntent);
  }
  
  public void b(View paramView)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListClickCloseBtn();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExit(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    super.b(paramView);
  }
  
  protected void e(LocalMediaInfo paramLocalMediaInfo)
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListPickPhoto();
    super.e(paramLocalMediaInfo);
  }
  
  public void h()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoListExpose();
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationAECameraForCMShow
 * JD-Core Version:    0.7.0.1
 */