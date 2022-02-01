package com.tencent.gdtad.views.halfScreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.jsbridge.GdtBaseHalfScreenFragmentForJs;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.webview.WebViewDirector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class GdtBaseHalfScreenFragment
  extends PublicBaseFragment
{
  private TouchWebView a;
  private GdtWebViewBuilder b;
  private AdCanvasView c;
  private TextView d;
  private FrameLayout e;
  private View f;
  private View g;
  
  private void a(int paramInt, AdCanvasData paramAdCanvasData, String paramString, FrameLayout paramFrameLayout)
  {
    Object localObject = this.e;
    if (localObject != null) {
      ((FrameLayout)localObject).setVisibility(0);
    }
    localObject = this.f;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.g;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    if (paramInt == 2)
    {
      if ((this.d != null) && (paramAdCanvasData != null) && (!TextUtils.isEmpty(paramAdCanvasData.pageTitle))) {
        this.d.setText(paramAdCanvasData.pageTitle);
      }
      this.c = new AdCanvasView(getBaseActivity());
      this.c.hideBar();
      this.c.setData(paramAdCanvasData);
      paramFrameLayout.addView(this.c);
      return;
    }
    if (paramInt == 1) {
      b(paramInt, paramString, paramFrameLayout);
    }
  }
  
  private void a(int paramInt, String paramString, FrameLayout paramFrameLayout)
  {
    b(paramInt, paramString, paramFrameLayout);
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseHalfScreenFragment> paramClass, Ad paramAd, AdCanvasData paramAdCanvasData, String paramString, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramAd != null) && (paramAd.isValid()))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start GdtBaseHalfScreenFragment");
      ((StringBuilder)localObject).append(paramInt);
      GdtLog.b("GdtBaseHalfScreenFragment", ((StringBuilder)localObject).toString());
      localObject = new Bundle();
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        ((Bundle)localObject).putAll(paramBundle);
      }
      ((Bundle)localObject).putSerializable("data", (GdtAd)paramAd);
      paramAd = new Intent();
      paramAd.putExtra("public_fragment_window_feature", 1);
      paramAd.putExtra("big_brother_source_key", "biz_src_ads");
      paramAd.putExtras((Bundle)localObject);
      paramAd.putExtra("url", paramString);
      paramAd.putExtra("canvas_data", paramAdCanvasData);
      paramAd.putExtra("style", paramInt);
      if (TextUtils.isEmpty(paramAd.getStringExtra("big_brother_ref_source_key"))) {
        GdtLog.d("GdtBaseHalfScreenFragment", "start gdt empty refId");
      }
      if (paramInt == 2)
      {
        PublicFragmentActivity.Launcher.a(paramActivity, paramAd, PublicTransFragmentActivity.class, paramClass);
        return;
      }
      PublicFragmentActivity.Launcher.a(paramActivity, paramAd, PublicTransFragmentActivityForTool.class, paramClass);
      return;
    }
    GdtLog.d("GdtBaseHalfScreenFragment", "start error");
  }
  
  public static void a(Activity paramActivity, Class<GdtBaseHalfScreenFragmentForJs> paramClass, String paramString, Bundle paramBundle)
  {
    GdtLog.b("GdtBaseHalfScreenFragment", "start GdtBaseHalfScreenFragment without ad");
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    paramBundle = new Intent();
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras(localBundle);
    paramBundle.putExtra("url", paramString);
    paramBundle.putExtra("style", 0);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      GdtLog.d("GdtBaseHalfScreenFragment", "start gdt empty refId");
    }
    PublicFragmentActivity.Launcher.a(paramActivity, paramBundle, PublicTransFragmentActivityForTool.class, paramClass);
  }
  
  private void a(FrameLayout paramFrameLayout, View paramView)
  {
    if (paramFrameLayout != null) {
      paramFrameLayout.setOnClickListener(new GdtBaseHalfScreenFragment.1(this));
    }
    if (paramView != null) {
      paramView.setOnClickListener(new GdtBaseHalfScreenFragment.2(this));
    }
  }
  
  private void b(int paramInt, String paramString, FrameLayout paramFrameLayout)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.a = new TouchWebView(getBaseActivity());
    paramFrameLayout.addView(this.a);
    this.b = new GdtBaseHalfScreenFragment.3(this, getBaseActivity(), getBaseActivity(), null, localAppInterface);
    this.b.a(this.a);
    new WebViewDirector(this.b).a(null, localAppInterface, getBaseActivity().getIntent());
    this.a.loadUrl(paramString);
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = getBaseActivity();
    paramBundle = null;
    if ((localObject != null) && (getBaseActivity().getIntent() != null))
    {
      int i = getBaseActivity().getIntent().getIntExtra("style", -2147483648);
      localObject = getBaseActivity().getIntent().getStringExtra("url");
      paramViewGroup = paramLayoutInflater.inflate(2131624941, paramViewGroup, false);
      FrameLayout localFrameLayout = (FrameLayout)paramViewGroup.findViewById(2131436840);
      this.e = ((FrameLayout)paramViewGroup.findViewById(2131447845));
      this.f = paramViewGroup.findViewById(2131429208);
      this.g = paramViewGroup.findViewById(2131437197);
      a(this.e, this.f);
      if (i == 0)
      {
        paramLayoutInflater = (RelativeLayout)paramViewGroup.findViewById(2131429673);
        paramBundle = (LinearLayout.LayoutParams)this.e.getLayoutParams();
        if (paramBundle != null)
        {
          paramBundle.weight = 1.0F;
          this.e.setLayoutParams(paramBundle);
        }
        paramBundle = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
        if (paramBundle != null)
        {
          paramBundle.weight = 1.0F;
          paramLayoutInflater.setPadding(0, AdUIUtils.dp2px(16.0F, getResources()), 0, 0);
          paramLayoutInflater.setLayoutParams(paramBundle);
        }
        a(i, (String)localObject, localFrameLayout);
        paramLayoutInflater = paramViewGroup;
        break label331;
      }
      if ((getBaseActivity().getIntent().getSerializableExtra("data") instanceof GdtAd))
      {
        paramLayoutInflater = paramBundle;
        if ((getBaseActivity().getIntent().getSerializableExtra("canvas_data") instanceof AdCanvasData)) {
          paramLayoutInflater = (AdCanvasData)getBaseActivity().getIntent().getSerializableExtra("canvas_data");
        }
        this.d = ((TextView)paramViewGroup.findViewById(2131447463));
        this.d.setMaxWidth(AdUIUtils.dp2px(120.0F, getResources()));
        a(i, paramLayoutInflater, (String)localObject, localFrameLayout);
        paramLayoutInflater = paramViewGroup;
        break label331;
      }
    }
    paramLayoutInflater = null;
    label331:
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.b;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).c();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AdCanvasView)localObject).onActivityDestroy();
    }
    localObject = this.a;
    if (localObject != null)
    {
      localObject = ((TouchWebView)localObject).getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    Object localObject = this.b;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).b();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AdCanvasView)localObject).onActivityPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.b;
    if (localObject != null) {
      ((GdtWebViewBuilder)localObject).a();
    }
    localObject = this.c;
    if (localObject != null) {
      ((AdCanvasView)localObject).onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment
 * JD-Core Version:    0.7.0.1
 */