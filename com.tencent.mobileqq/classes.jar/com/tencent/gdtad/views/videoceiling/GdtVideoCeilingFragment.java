package com.tencent.gdtad.views.videoceiling;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.gdtad.web.GdtWebReportQQ;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public final class GdtVideoCeilingFragment
  extends PublicBaseFragment
{
  public static String a = "key_result_receiver";
  public static String b = "key_ad_position";
  private GdtVideoCeilingView c;
  
  public static void a(Activity paramActivity, GdtVideoCeilingData paramGdtVideoCeilingData, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramGdtVideoCeilingData != null) && (paramGdtVideoCeilingData.isValid()))
    {
      GdtLog.b("GdtBaseVideoCeilingFragment", "start");
      Bundle localBundle = new Bundle();
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        localBundle.putAll(paramBundle);
      }
      a(paramGdtVideoCeilingData);
      localBundle.putSerializable("data", paramGdtVideoCeilingData);
      paramBundle = new Intent();
      if ((paramGdtVideoCeilingData.getAd() != null) && (paramGdtVideoCeilingData.getAd().getNocoId() != 0L)) {
        paramBundle.putExtra("GdtNocoId", paramGdtVideoCeilingData.getAd().getNocoId());
      }
      paramBundle.putExtra("public_fragment_window_feature", 1);
      paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
      paramBundle.putExtras(localBundle);
      paramBundle.putExtra("GdtWebReportQQ_IS_H5", false);
      paramBundle.putExtra("GdtWebReportQQ_TRACE_ID", paramGdtVideoCeilingData.getAd().getTraceId());
      paramBundle.putExtra("GdtWebReportQQ_CLICK_URL", paramGdtVideoCeilingData.getAd().getUrlForClick());
      paramBundle.putExtra("GdtWebReportQQ_POS_ID", paramGdtVideoCeilingData.getAd().getPosId());
      paramBundle.putExtra("GdtWebReportQQ_AD_ID", String.valueOf(paramGdtVideoCeilingData.getAd().getAId()));
      paramBundle.putExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
      a(paramGdtVideoCeilingData.getAd(), paramActivity);
      if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
        GdtLog.d("GdtBaseVideoCeilingFragment", "start gdt empty refId");
      }
      if (paramGdtVideoCeilingData.getStyle() == 4)
      {
        PublicFragmentActivity.Launcher.a(paramActivity, paramBundle, PublicFragmentActivity.class, GdtVideoCeilingFragment.class);
        return;
      }
      PublicFragmentActivity.Launcher.a(paramActivity, paramBundle, PublicFragmentActivityForTool.class, GdtVideoCeilingFragment.class);
      return;
    }
    GdtLog.d("GdtBaseVideoCeilingFragment", "start error");
  }
  
  private static void a(GdtAd paramGdtAd, Activity paramActivity)
  {
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(paramActivity, new InitGdtContextParams());
    link_report.LinkReport.ReportBiz localReportBiz = new link_report.LinkReport.ReportBiz();
    localReportBiz.wv_progress = 2;
    localReportBiz.lp_type = 4;
    if (GdtWebReportQQ.a(paramGdtAd.getUrlForClick())) {
      localReportBiz.click_req_type = 1;
    } else {
      localReportBiz.click_req_type = 3;
    }
    AdReporterForLinkEvent.reportAsync(paramActivity, 4003001, paramGdtAd, localReportBiz, null);
  }
  
  protected static void a(GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    try
    {
      if (paramGdtVideoCeilingData.getAd() == null) {
        return;
      }
      Object localObject = GdtJsonPbUtil.a(paramGdtVideoCeilingData.getAd().info);
      if (localObject != null)
      {
        if (JSONObject.NULL.equals(localObject)) {
          return;
        }
        localObject = localObject.toString();
        paramGdtVideoCeilingData.getAd().info = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject((String)localObject))));
        return;
      }
      return;
    }
    catch (Exception paramGdtVideoCeilingData)
    {
      QLog.e("GdtBaseVideoCeilingFragment", 1, paramGdtVideoCeilingData, new Object[0]);
    }
  }
  
  public void beforeFinish()
  {
    super.beforeFinish();
    Object localObject = getArguments();
    if (localObject != null)
    {
      localObject = (ResultReceiver)((Bundle)localObject).getParcelable(a);
      if ((localObject != null) && (this.c != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong(b, this.c.getCurrentPosition());
        ((ResultReceiver)localObject).send(-1, localBundle);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    GdtVideoCeilingView localGdtVideoCeilingView = this.c;
    return (localGdtVideoCeilingView != null) && (localGdtVideoCeilingView.f());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624953, paramViewGroup, false);
    this.c = ((GdtVideoCeilingView)paramLayoutInflater.findViewById(2131449736));
    GdtUIUtils.a(this.c);
    this.c.a(paramBundle);
    if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof GdtVideoCeilingData))) {
      this.c.setData((GdtVideoCeilingData)getArguments().getSerializable("data"));
    }
    if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null)) {
      getBaseActivity().getWindow().setSoftInputMode(16);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    GdtVideoCeilingView localGdtVideoCeilingView = this.c;
    if (localGdtVideoCeilingView != null) {
      localGdtVideoCeilingView.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    GdtVideoCeilingView localGdtVideoCeilingView = this.c;
    if (localGdtVideoCeilingView != null) {
      localGdtVideoCeilingView.e();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    GdtVideoCeilingView localGdtVideoCeilingView = this.c;
    if (localGdtVideoCeilingView != null) {
      localGdtVideoCeilingView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingFragment
 * JD-Core Version:    0.7.0.1
 */