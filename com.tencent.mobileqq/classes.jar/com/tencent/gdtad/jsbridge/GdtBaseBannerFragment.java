package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

abstract class GdtBaseBannerFragment
  extends PublicBaseFragment
{
  protected LinearLayout a;
  private GdtAppReceiver b = new GdtAppReceiver();
  
  public static void a(Activity paramActivity, JSONObject paramJSONObject, Class<? extends GdtBaseBannerFragment> paramClass)
  {
    if ((paramActivity != null) && (paramJSONObject != null))
    {
      GdtLog.b("GdtBaseBannerFragment", "start");
      Bundle localBundle = new Bundle();
      localBundle.putString("params", paramJSONObject.toString());
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("public_fragment_window_feature", 1);
      paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramJSONObject.putExtras(localBundle);
      PublicFragmentActivity.Launcher.a(paramActivity, paramJSONObject, PublicFragmentActivityForTool.class, paramClass);
      return;
    }
    GdtLog.b("GdtBaseBannerFragment", "start error");
  }
  
  protected abstract void a();
  
  protected abstract void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams);
  
  protected abstract GdtAd b();
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (getArguments() == null)
    {
      paramLayoutInflater = null;
    }
    else
    {
      paramLayoutInflater = getArguments().getString("params");
      try
      {
        paramBundle = new JSONObject(paramLayoutInflater);
        paramViewGroup = paramBundle.getJSONObject("requestParams");
        paramBundle = paramBundle.getJSONObject("clickParams");
        boolean bool1 = paramBundle.getBoolean("reportForClick");
        boolean bool2 = paramBundle.getBoolean("appAutoDownload");
        paramBundle.optBoolean("videoCeilingSupported", false);
        paramViewGroup = (qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), paramViewGroup));
        paramBundle = new GdtHandler.Params();
        paramBundle.q = 1;
        paramBundle.r = new WeakReference(getBaseActivity());
        paramBundle.b = bool1;
        paramBundle.e = bool2;
        paramBundle.s = new WeakReference(this.b);
        paramBundle.p = new Bundle();
        paramBundle.p.putString("big_brother_ref_source_key", "biz_src_miniapp");
        a(paramLayoutInflater, paramViewGroup, paramBundle);
      }
      catch (JSONException paramLayoutInflater)
      {
        GdtLog.d("GdtBaseBannerFragment", "createParams error", paramLayoutInflater);
      }
      paramLayoutInflater = new Button(getBaseActivity());
      paramLayoutInflater.setText("load");
      paramLayoutInflater.setOnClickListener(new GdtBaseBannerFragment.1(this));
      paramViewGroup = new Button(getBaseActivity());
      paramViewGroup.setText("show");
      paramViewGroup.setOnClickListener(new GdtBaseBannerFragment.2(this));
      this.a = new LinearLayout(getBaseActivity());
      this.a.setBackgroundColor(Color.parseColor("#DBDBDB"));
      this.a.setOrientation(1);
      this.a.addView(paramLayoutInflater);
      this.a.addView(paramViewGroup);
      paramLayoutInflater = new ScrollView(getBaseActivity());
      paramLayoutInflater.addView(this.a);
      this.b.register(getBaseActivity());
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    this.b.unregister(getBaseActivity());
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBaseBannerFragment
 * JD-Core Version:    0.7.0.1
 */