package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.button.AdButtonController;
import com.tencent.ad.tangram.views.button.AdButtonView;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.gdtad.api.banner.GdtBannerParams;
import com.tencent.gdtad.api.banner.GdtBannerView;
import com.tencent.gdtad.api.banner.GdtBannerViewBuilder;
import com.tencent.gdtad.api.banner.IGdtBannerAd;
import com.tencent.gdtad.api.banner.IGdtBannerAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtBannerFragmentForJS
  extends GdtBaseBannerFragment
{
  private AdButtonController jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
  private AdButtonView jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView;
  private GdtAdListener jdField_a_of_type_ComTencentGdtadApiGdtAdListener = new GdtBannerFragmentForJS.2(this);
  private GdtBannerParams jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams;
  private GdtBannerView jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
  private IGdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerIGdtBannerAd;
  
  protected GdtAd a()
  {
    IGdtBannerAd localIGdtBannerAd = this.jdField_a_of_type_ComTencentGdtadApiBannerIGdtBannerAd;
    if ((localIGdtBannerAd instanceof GdtAd)) {
      return (GdtAd)localIGdtBannerAd;
    }
    return null;
  }
  
  protected void a()
  {
    int i = AdUIUtils.getValueDependsOnScreenWidth(getQBaseActivity(), 750, 584);
    int j = AdUIUtils.getValueDependsOnScreenWidth(getQBaseActivity(), 750, 80);
    Object localObject = new LinearLayout.LayoutParams(i, j);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    ((LinearLayout.LayoutParams)localObject).topMargin = 100;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 100;
    this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView = new AdButtonView(getQBaseActivity(), i, j);
    this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController = new AdButtonController(GdtHandler.a(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params));
    this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController.registerView(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView), true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonView.getButtonView(), (ViewGroup.LayoutParams)localObject);
    i = GdtUIUtils.a(getBaseActivity(), 1080, 1026);
    j = GdtBannerViewBuilder.b(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerIGdtBannerAd.render(getBaseActivity(), i, j);
    localObject = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localObject == null)
    {
      Toast.makeText(getBaseActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (((GdtBannerView)localObject).a() == null)
    {
      Toast.makeText(getBaseActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    localObject = new LinearLayout.LayoutParams(i, j);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    ((LinearLayout.LayoutParams)localObject).topMargin = 100;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 100;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView.a(), (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentGdtadApiBannerIGdtBannerAd.onDisplay();
    AdThreadManager.INSTANCE.postDelayed(new GdtBannerFragmentForJS.1(this), 0, 5000L);
  }
  
  protected void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams = new GdtBannerParams();
    GdtBannerParams localGdtBannerParams = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams;
    localGdtBannerParams.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramQQAdGet;
    localGdtBannerParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_Int = i;
      i = GdtUIUtils.a(getBaseActivity(), 1080, 1026);
      int j = GdtBannerViewBuilder.b(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.b = i;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams.c = j;
    }
    catch (JSONException paramString)
    {
      GdtLog.d("GdtBannerFragmentForJS", "createParams error", paramString);
    }
    this.jdField_a_of_type_ComTencentGdtadApiBannerIGdtBannerAd = ((IGdtBannerAdAPI)QRoute.api(IGdtBannerAdAPI.class)).buildBannerAd(this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerParams);
    this.jdField_a_of_type_ComTencentGdtadApiBannerIGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_ComTencentGdtadApiGdtAdListener));
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
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localObject != null) {
      ((GdtBannerView)localObject).c(getBaseActivity());
    }
    localObject = this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityDestoryed();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    GdtBannerView localGdtBannerView = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localGdtBannerView != null) {
      localGdtBannerView.a(getBaseActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerView;
    if (localObject != null) {
      ((GdtBannerView)localObject).b(getBaseActivity());
    }
    localObject = this.jdField_a_of_type_ComTencentAdTangramViewsButtonAdButtonController;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */