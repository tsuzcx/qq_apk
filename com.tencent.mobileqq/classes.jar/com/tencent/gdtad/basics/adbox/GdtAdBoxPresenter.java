package com.tencent.gdtad.basics.adbox;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper;
import com.tencent.gdtad.basics.motivevideo.report.GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class GdtAdBoxPresenter
{
  private GdtAdBoxView a;
  private GdtAdBoxModel b;
  
  public GdtAdBoxPresenter(GdtAdBoxView paramGdtAdBoxView, GdtAdBoxModel paramGdtAdBoxModel)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GdtAdBoxPresenter() called with: view = [");
    localStringBuilder.append(paramGdtAdBoxView);
    localStringBuilder.append("], model = [");
    localStringBuilder.append(paramGdtAdBoxModel);
    localStringBuilder.append("]");
    GdtLog.a("GdtAdBoxPresenter", localStringBuilder.toString());
    this.a = paramGdtAdBoxView;
    this.b = paramGdtAdBoxModel;
    paramGdtAdBoxModel.a(this);
  }
  
  public void a()
  {
    GdtLog.a("GdtAdBoxPresenter", "onCreate() called");
    this.a.b(this.b);
  }
  
  public void a(Activity paramActivity, View paramView, GdtMotiveVideoClickCoordinateReportHelper.AdBoxReportParams paramAdBoxReportParams, GdtMotiveVideoClickCoordinateReportHelper paramGdtMotiveVideoClickCoordinateReportHelper, GdtAdBoxData paramGdtAdBoxData)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    localParams.q = 11;
    localParams.r = new WeakReference(paramActivity);
    paramActivity = paramView.getTag(2131434080);
    if (paramActivity == null)
    {
      GdtLog.d("GdtAdBoxPresenter", "onClick() tag == null");
      return;
    }
    paramActivity = (GdtAd)paramActivity;
    StringBuffer localStringBuffer = new StringBuffer("onClick()");
    localStringBuffer.append(",url =");
    localStringBuffer.append(paramActivity.info.dest_info.landing_page.get());
    localParams.a = paramActivity;
    localParams.b = true;
    localParams.e = true;
    localParams.s = new WeakReference(localGdtAppReceiver);
    paramActivity = new Bundle();
    if (paramGdtAdBoxData != null)
    {
      localStringBuffer.append(",refId =");
      localStringBuffer.append(paramGdtAdBoxData.getRefId());
      paramActivity.putString("big_brother_ref_source_key", paramGdtAdBoxData.getRefId());
    }
    localParams.p = paramActivity;
    paramView = null;
    paramActivity = paramView;
    if (localParams.a.info != null)
    {
      paramActivity = paramView;
      if (localParams.a.info.report_info != null)
      {
        paramActivity = localParams.a.info.report_info.click_url.get();
        paramView = paramGdtMotiveVideoClickCoordinateReportHelper.a(paramActivity, paramAdBoxReportParams);
        localParams.a.info.report_info.click_url.set(paramView);
      }
    }
    QLog.i("GdtAdBoxPresenter", 1, localStringBuffer.toString());
    GdtHandler.a(localParams);
    if (!TextUtils.isEmpty(paramActivity)) {
      localParams.a.info.report_info.click_url.set(paramActivity);
    }
  }
  
  public void b()
  {
    GdtLog.a("GdtAdBoxPresenter", "onResume() called");
  }
  
  public void c() {}
  
  public void d() {}
  
  public boolean e()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBoxPresenter
 * JD-Core Version:    0.7.0.1
 */