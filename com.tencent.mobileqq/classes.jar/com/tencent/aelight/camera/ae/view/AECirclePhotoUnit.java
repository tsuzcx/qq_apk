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
  private IQIMCameraContainer a;
  private AECirclePhotoListFragment b;
  
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
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
  }
  
  public void ai()
  {
    super.ai();
  }
  
  public boolean ak()
  {
    if (this.a == null) {
      return false;
    }
    AECirclePhotoListFragment localAECirclePhotoListFragment = this.b;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.f())) {
      return true;
    }
    localAECirclePhotoListFragment = this.b;
    if ((localAECirclePhotoListFragment != null) && (localAECirclePhotoListFragment.a != null)) {
      this.b.a.a(null);
    }
    return true;
  }
  
  public View j()
  {
    View localView = this.a.getActivity().getLayoutInflater().inflate(2064056490, null);
    a(localView);
    return localView;
  }
  
  public void m()
  {
    super.m();
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECirclePhotoUnit
 * JD-Core Version:    0.7.0.1
 */