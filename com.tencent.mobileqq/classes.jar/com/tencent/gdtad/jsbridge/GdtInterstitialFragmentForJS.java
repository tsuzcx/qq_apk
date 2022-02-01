package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.GdtAdError;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.api.interstitial.IGdtInterstitialAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtInterstitialFragmentForJS
  extends PublicBaseFragment
{
  private GdtAdLoader a;
  private GdtAdError b;
  private qq_ad_get.QQAdGet c;
  private IGdtInterstitialAd d;
  private GdtInterstitialParams e = new GdtInterstitialParams();
  private GdtAdLoader.Listener f = new GdtInterstitialFragmentForJS.5(this);
  
  public static void a(Activity paramActivity, Class<? extends PublicFragmentActivity> paramClass, JSONObject paramJSONObject)
  {
    if ((paramActivity != null) && (paramJSONObject != null))
    {
      GdtLog.b("GdtInterstitialFragmentForJS", "start");
      Bundle localBundle = new Bundle();
      localBundle.putString("params", paramJSONObject.toString());
      paramJSONObject = new Intent();
      paramJSONObject.putExtra("public_fragment_window_feature", 1);
      paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramJSONObject.putExtras(localBundle);
      PublicFragmentActivity.Launcher.a(paramActivity, paramJSONObject, paramClass, GdtInterstitialFragmentForJS.class);
      return;
    }
    GdtLog.b("GdtInterstitialFragmentForJS", "start error");
  }
  
  private static int b(Activity paramActivity)
  {
    int j = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int k = localDisplayMetrics.widthPixels;
    int m = localDisplayMetrics.heightPixels;
    int i = 0;
    if (((j != 0) && (j != 2)) || ((m <= k) && (((j != 1) && (j != 3)) || (k <= m))))
    {
      if (j == 0) {
        return i;
      }
      if (j != 1)
      {
        if (j == 2) {
          break label141;
        }
        if (j == 3) {
          break label144;
        }
        GdtLog.d("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to landscape.");
        return 0;
      }
    }
    else if (j != 0)
    {
      if (j == 1) {
        return i;
      }
      if (j == 2) {
        break label144;
      }
      if (j == 3) {
        break label141;
      }
      GdtLog.d("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to portrait.");
    }
    return 1;
    label141:
    return 8;
    label144:
    i = 9;
    return i;
  }
  
  protected int a(GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == -2147483648) {
      return 3;
    }
    int i = 6;
    if (paramInt1 != 200) {
      return 6;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 == 1) {
        i = 4;
      }
      return i;
    }
    if (paramInt3 != 0)
    {
      if (paramInt3 == 102006) {
        i = 5;
      }
      return i;
    }
    if (paramGdtAd == null) {
      return 1;
    }
    if (!paramGdtAd.isValid()) {
      return 1;
    }
    return 0;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    GdtLog.b("GdtInterstitialFragmentForJS", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 == 10001)
    {
      IGdtInterstitialAd localIGdtInterstitialAd = this.d;
      if (localIGdtInterstitialAd != null) {
        localIGdtInterstitialAd.a(getBaseActivity(), paramInt2, paramIntent);
      }
      if (paramInt2 == -1) {
        paramIntent = "on closed";
      } else {
        paramIntent = "on closed error";
      }
      Toast.makeText(getBaseActivity().getApplicationContext(), paramIntent, 0).show();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GdtManager.a().a(getBaseActivity(), new GdtManager.Params());
    paramLayoutInflater = new JSONObject();
    try
    {
      paramLayoutInflater.put("key1", "value1");
      paramLayoutInflater.put("key2", "value2");
    }
    catch (Throwable paramViewGroup)
    {
      GdtLog.d("GdtInterstitialFragmentForJS", "onCreateView", paramViewGroup);
    }
    if (getArguments() == null)
    {
      paramLayoutInflater = null;
    }
    else
    {
      paramViewGroup = getArguments().getString("params");
      try
      {
        paramBundle = new JSONObject(paramViewGroup);
        paramViewGroup = paramBundle.getJSONObject("requestParams");
        localObject = paramBundle.getJSONObject("clickParams");
        paramBundle = new JSONObject();
        paramBundle.put("options", localObject);
        this.c = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), paramViewGroup)));
        paramViewGroup = new GdtHandler.Options();
        GdtHandler.a(paramViewGroup, paramBundle.toString());
        this.e.d = paramViewGroup;
      }
      catch (JSONException paramViewGroup)
      {
        GdtLog.d("GdtInterstitialFragmentForJS", "createParams error", paramViewGroup);
      }
      paramViewGroup = new Button(getBaseActivity());
      paramViewGroup.setText("load");
      paramViewGroup.setOnClickListener(new GdtInterstitialFragmentForJS.1(this));
      paramBundle = new Button(getBaseActivity());
      paramBundle.setText("show");
      paramBundle.setOnClickListener(new GdtInterstitialFragmentForJS.2(this));
      Object localObject = new Button(getBaseActivity());
      ((Button)localObject).setText("show - close after 5s");
      ((Button)localObject).setOnClickListener(new GdtInterstitialFragmentForJS.3(this));
      Button localButton = new Button(getBaseActivity());
      localButton.setText("show with antiSpamTestParams");
      localButton.setOnClickListener(new GdtInterstitialFragmentForJS.4(this, paramLayoutInflater));
      paramLayoutInflater = new LinearLayout(getBaseActivity());
      paramLayoutInflater.setBackgroundColor(Color.parseColor("#DBDBDB"));
      paramLayoutInflater.setOrientation(1);
      paramLayoutInflater.addView(paramViewGroup);
      paramLayoutInflater.addView(paramBundle);
      paramLayoutInflater.addView((View)localObject);
      paramLayoutInflater.addView(localButton);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS
 * JD-Core Version:    0.7.0.1
 */