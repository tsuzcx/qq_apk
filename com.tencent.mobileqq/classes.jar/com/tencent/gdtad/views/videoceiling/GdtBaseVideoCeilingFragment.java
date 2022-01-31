package com.tencent.gdtad.views.videoceiling;

import aanp;
import aapa;
import adky;
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
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public abstract class GdtBaseVideoCeilingFragment
  extends PublicBaseFragment
{
  public static String a;
  public static String b = "key_ad_position";
  private GdtVideoCeilingView a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "key_result_receiver";
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseVideoCeilingFragment> paramClass, GdtVideoCeilingData paramGdtVideoCeilingData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtVideoCeilingData == null) || (!paramGdtVideoCeilingData.isValid()))
    {
      aanp.d("GdtBaseVideoCeilingFragment", "start error");
      return;
    }
    aanp.b("GdtBaseVideoCeilingFragment", "start");
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putSerializable("data", paramGdtVideoCeilingData);
    paramBundle = new Intent();
    if ((paramGdtVideoCeilingData.getAd() != null) && (paramGdtVideoCeilingData.getAd().getNocoId() != 0L)) {
      paramBundle.putExtra("GdtNocoId", paramGdtVideoCeilingData.getAd().getNocoId());
    }
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras(localBundle);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      aanp.d("GdtBaseVideoCeilingFragment", "start gdt empty refId");
    }
    if (paramGdtVideoCeilingData.getStyle() == 4) {
      adky.a(paramActivity, paramBundle, PublicFragmentActivity.class, paramClass);
    }
    for (;;)
    {
      AdReporterForAnalysis.reportForStartActivity(paramActivity, paramGdtVideoCeilingData.getAd(), "GdtBaseVideoCeilingFragment");
      return;
      adky.a(paramActivity, paramBundle, PublicFragmentActivityForTool.class, paramClass);
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
    AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtBaseVideoCeilingFragment", 1);
    paramLayoutInflater = paramLayoutInflater.inflate(2131559154, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView = ((GdtVideoCeilingView)paramLayoutInflater.findViewById(2131379796));
    aapa.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.a(paramBundle);
    if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof GdtVideoCeilingData))) {
      this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingView.setData((GdtVideoCeilingData)getArguments().getSerializable("data"));
    }
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(16);
    }
    return paramLayoutInflater;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtBaseVideoCeilingFragment
 * JD-Core Version:    0.7.0.1
 */