package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtBannerFragmentForJS
  extends GdtBaseBannerFragment
{
  private GdtAdListener jdField_a_of_type_ComTencentGdtadApiGdtAdListener = new GdtBannerFragmentForJS.2(this);
  private GdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  private GdtBannerParams jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams;
  private GdtBannerView jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
  
  protected GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  }
  
  protected void a()
  {
    int i = GdtUIUtils.a(getActivity(), 1080, 1026);
    int j = GdtBannerViewBuilder.a(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.render(getActivity(), i, j);
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a() == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a(), localLayoutParams);
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.onDisplay();
    AdThreadManager.INSTANCE.postDelayed(new GdtBannerFragmentForJS.1(this), 0, 5000L);
  }
  
  protected void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams = new GdtBannerParams();
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramQQAdGet;
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_Int = i;
      i = GdtUIUtils.a(getActivity(), 1080, 1026);
      int j = GdtBannerViewBuilder.a(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.b = i;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.c = j;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = new GdtBannerAd(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_ComTencentGdtadApiGdtAdListener));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        GdtLog.d("GdtBannerFragmentForJS", "createParams error", paramString);
      }
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.c(getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a(getActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView != null) {
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.b(getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */