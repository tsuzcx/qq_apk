package com.tencent.gdtad.api.adbox;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBStringField;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class GdtAdBoxPresenter
{
  private GdtAdBoxModel jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxModel;
  private GdtAdBoxView jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxView;
  
  public GdtAdBoxPresenter(GdtAdBoxView paramGdtAdBoxView, GdtAdBoxModel paramGdtAdBoxModel)
  {
    GdtLog.a("GdtAdBoxPresenter", "GdtAdBoxPresenter() called with: view = [" + paramGdtAdBoxView + "], model = [" + paramGdtAdBoxModel + "]");
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxView = paramGdtAdBoxView;
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxModel = paramGdtAdBoxModel;
    paramGdtAdBoxModel.a(this);
  }
  
  public void a()
  {
    GdtLog.a("GdtAdBoxPresenter", "onCreate() called");
    this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxView.b(this.jdField_a_of_type_ComTencentGdtadApiAdboxGdtAdBoxModel);
  }
  
  public void a(Activity paramActivity, View paramView, GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams paramAdBoxReportParams, GdtMotiveVideoClickCoordinateReportHelper paramGdtMotiveVideoClickCoordinateReportHelper)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    localParams.c = 11;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131367779);
    if (paramActivity == null) {
      GdtLog.d("GdtAdBoxPresenter", "onClick() tag == null");
    }
    do
    {
      return;
      paramActivity = (GdtAd)paramActivity;
      GdtLog.a("GdtAdBoxPresenter", "onClick() open url = [" + paramActivity.info.dest_info.landing_page.get() + "]");
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = paramActivity;
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(localGdtAppReceiver);
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", "biz_src_miniapp");
      localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
      paramView = null;
      paramActivity = paramView;
      if (localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info != null)
      {
        paramActivity = paramView;
        if (localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info != null)
        {
          paramActivity = localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.get();
          paramView = paramGdtMotiveVideoClickCoordinateReportHelper.a(paramActivity, paramAdBoxReportParams);
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.set(paramView);
        }
      }
      GdtHandler.a(localParams);
    } while (TextUtils.isEmpty(paramActivity));
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd.info.report_info.click_url.set(paramActivity);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    GdtLog.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.adbox.GdtAdBoxPresenter
 * JD-Core Version:    0.7.0.1
 */