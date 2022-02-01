package com.tencent.aelight.camera.ae.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListFragment;
import com.tencent.aelight.camera.ae.biz.circle.AECirclePhotoListLogic;
import com.tencent.aelight.camera.aebase.QIMCameraLifeCycleBaseUnit;
import com.tencent.aelight.camera.aioeditor.setting.IQIMCameraContainer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;

public class AECirclePhotoUnit
  extends QIMCameraLifeCycleBaseUnit
{
  private AECirclePhotoListFragment jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
  private IQIMCameraContainer jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer;
  
  private void a(View paramView)
  {
    if (paramView == null)
    {
      QLog.e("AECirclePhotoUnit", 1, "reportDaTongRegister  view == null");
      return;
    }
    VideoReport.setPageId(paramView, "pg_xsj_choose_media_page");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().buildPageParams("AECirclePhotoUnit"));
    QLog.i("AECirclePhotoUnit", 1, "reportDaTongRegister  subPage: AECirclePhotoUnit");
  }
  
  public void I()
  {
    super.I();
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().getLayoutInflater().inflate(2064318611, null);
    a(localView);
    return localView;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer.a().finish();
  }
  
  public boolean i()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorSettingIQIMCameraContainer == null) {
      return false;
    }
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.a())) {
      return true;
    }
    localAECirclePhotoListFragment = this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.a != null)) {
      this.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECirclePhotoListFragment.a.a(null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECirclePhotoUnit
 * JD-Core Version:    0.7.0.1
 */