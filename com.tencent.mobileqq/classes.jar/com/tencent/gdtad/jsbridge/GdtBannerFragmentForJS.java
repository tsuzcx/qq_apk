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
  private IGdtBannerAd b;
  private GdtBannerParams c;
  private GdtBannerView d;
  private AdButtonView e;
  private AdButtonController f;
  private GdtAdListener g = new GdtBannerFragmentForJS.2(this);
  
  protected void a()
  {
    int i = AdUIUtils.getValueDependsOnScreenWidth(getQBaseActivity(), 750, 584);
    int j = AdUIUtils.getValueDependsOnScreenWidth(getQBaseActivity(), 750, 80);
    Object localObject = new LinearLayout.LayoutParams(i, j);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    ((LinearLayout.LayoutParams)localObject).topMargin = 100;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 100;
    this.e = new AdButtonView(getQBaseActivity(), i, j);
    this.f = new AdButtonController(GdtHandler.b(this.c.b));
    this.f.registerView(new WeakReference(this.e), true);
    this.a.addView(this.e.getButtonView(), (ViewGroup.LayoutParams)localObject);
    i = GdtUIUtils.a(getBaseActivity(), 1080, 1026);
    j = GdtBannerViewBuilder.b(this.c.c, i);
    this.d = this.b.render(getBaseActivity(), i, j);
    localObject = this.d;
    if (localObject == null)
    {
      Toast.makeText(getBaseActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (((GdtBannerView)localObject).getView() == null)
    {
      Toast.makeText(getBaseActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    localObject = new LinearLayout.LayoutParams(i, j);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    ((LinearLayout.LayoutParams)localObject).topMargin = 100;
    ((LinearLayout.LayoutParams)localObject).bottomMargin = 100;
    this.a.addView(this.d.getView(), (ViewGroup.LayoutParams)localObject);
    this.b.onDisplay();
    AdThreadManager.INSTANCE.postDelayed(new GdtBannerFragmentForJS.1(this), 0, 5000L);
  }
  
  protected void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.c = new GdtBannerParams();
    GdtBannerParams localGdtBannerParams = this.c;
    localGdtBannerParams.a = paramQQAdGet;
    localGdtBannerParams.b = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.c.c = i;
      i = GdtUIUtils.a(getBaseActivity(), 1080, 1026);
      int j = GdtBannerViewBuilder.b(this.c.c, i);
      this.c.d = i;
      this.c.e = j;
    }
    catch (JSONException paramString)
    {
      GdtLog.d("GdtBannerFragmentForJS", "createParams error", paramString);
    }
    this.b = ((IGdtBannerAdAPI)QRoute.api(IGdtBannerAdAPI.class)).buildBannerAd(this.c);
    this.b.setListener(new WeakReference(this.g));
  }
  
  protected GdtAd b()
  {
    IGdtBannerAd localIGdtBannerAd = this.b;
    if ((localIGdtBannerAd instanceof GdtAd)) {
      return (GdtAd)localIGdtBannerAd;
    }
    return null;
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
    Object localObject = this.d;
    if (localObject != null) {
      ((GdtBannerView)localObject).c(getBaseActivity());
    }
    localObject = this.f;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityDestoryed();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    GdtBannerView localGdtBannerView = this.d;
    if (localGdtBannerView != null) {
      localGdtBannerView.a(getBaseActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.d;
    if (localObject != null) {
      ((GdtBannerView)localObject).b(getBaseActivity());
    }
    localObject = this.f;
    if (localObject != null) {
      ((AdButtonController)localObject).onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */