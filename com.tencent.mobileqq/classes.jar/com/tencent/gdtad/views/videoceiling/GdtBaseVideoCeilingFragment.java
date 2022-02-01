package com.tencent.gdtad.views.videoceiling;

import abrk;
import abrl;
import absw;
import adxr;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public abstract class GdtBaseVideoCeilingFragment
  extends PublicBaseFragment
{
  public static String a;
  public static String b = "key_ad_position";
  public static String c = "key_from_process_name";
  private GdtVideoCeilingView a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "key_result_receiver";
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseVideoCeilingFragment> paramClass, GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    a(paramActivity, paramClass, paramGdtVideoCeilingData, null);
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseVideoCeilingFragment> paramClass, GdtVideoCeilingData paramGdtVideoCeilingData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()))
    {
      abrl.d("GdtBaseVideoCeilingFragment", "start error");
      return;
    }
    abrl.b("GdtBaseVideoCeilingFragment", "start");
    Object localObject = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      ((Bundle)localObject).putAll(paramBundle);
    }
    a(paramGdtVideoCeilingData);
    ((Bundle)localObject).putSerializable("data", paramGdtVideoCeilingData);
    Intent localIntent = new Intent();
    if ((paramGdtVideoCeilingData.getAd() != null) && (paramGdtVideoCeilingData.getAd().getNocoId() != 0L)) {
      localIntent.putExtra("GdtNocoId", paramGdtVideoCeilingData.getAd().getNocoId());
    }
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("big_brother_source_key", "biz_src_ads");
    localIntent.putExtras((Bundle)localObject);
    if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
      abrl.d("GdtBaseVideoCeilingFragment", "start gdt empty refId");
    }
    localObject = AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity);
    if (paramGdtVideoCeilingData.getStyle() == 4)
    {
      paramBundle = AdProcessManager.INSTANCE.getMainProcessName();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localIntent.putExtra(c, (String)localObject);
      }
      if (paramGdtVideoCeilingData.getStyle() != 4) {
        break label240;
      }
      adxr.a(paramActivity, localIntent, PublicFragmentActivity.class, paramClass);
    }
    for (;;)
    {
      AdReporterForAnalysis.reportForStartActivity(paramActivity, paramGdtVideoCeilingData.getAd(), "GdtBaseVideoCeilingFragment", paramBundle);
      return;
      paramBundle = AdProcessManager.INSTANCE.getWebProcessName();
      break;
      label240:
      adxr.a(paramActivity, localIntent, PublicFragmentActivityForTool.class, paramClass);
    }
  }
  
  protected static void a(GdtVideoCeilingData paramGdtVideoCeilingData)
  {
    try
    {
      if (paramGdtVideoCeilingData.getAd() == null) {
        return;
      }
      Object localObject = abrk.a(paramGdtVideoCeilingData.getAd().info);
      if ((localObject != null) && (!JSONObject.NULL.equals(localObject)))
      {
        localObject = localObject.toString();
        paramGdtVideoCeilingData.getAd().info = ((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(abrk.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject((String)localObject))));
        return;
      }
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
      localObject = (ResultReceiver)((Bundle)localObject).getParcelable(jdField_a_of_type_JavaLangString);
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView != null))
      {
        Bundle localBundle = new Bundle();
        localBundle.putLong(b, this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.a());
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
    return (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView != null) && (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.a());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((getArguments() != null) && (getArguments().containsKey(c))) {}
    for (String str = getArguments().getString(c);; str = null)
    {
      AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtBaseVideoCeilingFragment", 1, str);
      paramLayoutInflater = paramLayoutInflater.inflate(2131559239, paramViewGroup, false);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView = ((GdtVideoCeilingView)paramLayoutInflater.findViewById(2131380712));
      absw.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView);
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.a(paramBundle);
      if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof GdtVideoCeilingData))) {
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.setData((GdtVideoCeilingData)getArguments().getSerializable("data"));
      }
      if ((getActivity() != null) && (getActivity().getWindow() != null)) {
        getActivity().getWindow().setSoftInputMode(16);
      }
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.c();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.e();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment
 * JD-Core Version:    0.7.0.1
 */