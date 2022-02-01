package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.gdtad.api.interstitial.GdtInterstitialAd;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtInterstitialFragmentForJS
  extends PublicBaseFragment
{
  private GdtAdLoader.Listener jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader$Listener = new GdtInterstitialFragmentForJS.5(this);
  private GdtAdLoader jdField_a_of_type_ComTencentGdtadAditemGdtAdLoader;
  private GdtAdError jdField_a_of_type_ComTencentGdtadApiGdtAdError;
  private GdtInterstitialAd jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialAd;
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = new GdtInterstitialParams();
  private qq_ad_get.QQAdGet jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet;
  
  public static void a(Activity paramActivity, Class<? extends PublicFragmentActivity> paramClass, JSONObject paramJSONObject)
  {
    if ((paramActivity == null) || (paramJSONObject == null))
    {
      GdtLog.b("GdtInterstitialFragmentForJS", "start error");
      return;
    }
    GdtLog.b("GdtInterstitialFragmentForJS", "start");
    Bundle localBundle = new Bundle();
    localBundle.putString("params", paramJSONObject.toString());
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramJSONObject.putExtras(localBundle);
    PublicFragmentActivity.Launcher.a(paramActivity, paramJSONObject, paramClass, GdtInterstitialFragmentForJS.class);
  }
  
  private static int b(Activity paramActivity)
  {
    int i = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j = localDisplayMetrics.widthPixels;
    int k = localDisplayMetrics.heightPixels;
    if (((i != 0) && (i != 2)) || ((k > j) || (((i == 1) || (i == 3)) && (j > k))))
    {
      switch (i)
      {
      default: 
        GdtLog.d("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to portrait.");
      case 0: 
        return 1;
      case 1: 
        return 0;
      case 2: 
        return 9;
      }
      return 8;
    }
    switch (i)
    {
    case 1: 
    default: 
      GdtLog.d("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to landscape.");
      return 0;
    case 0: 
      return 0;
    case 2: 
      return 8;
    }
    return 9;
  }
  
  protected int a(GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 6;
    int i;
    if (paramInt1 == -2147483648) {
      i = 3;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while (paramInt1 != 200);
        if (paramInt2 == 0) {
          break;
        }
        i = j;
      } while (paramInt2 != 1);
      return 4;
      if (paramInt3 == 0) {
        break;
      }
      i = j;
    } while (paramInt3 != 102006);
    return 5;
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
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialAd != null) {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialAd.a(getActivity(), paramInt2, paramIntent);
      }
      if (paramInt2 != -1) {
        break label79;
      }
    }
    label79:
    for (paramIntent = "on closed";; paramIntent = "on closed error")
    {
      Toast.makeText(getActivity().getApplicationContext(), paramIntent, 0).show();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    GdtManager.a().a(getActivity(), new GdtManager.Params());
    paramLayoutInflater = new JSONObject();
    for (;;)
    {
      try
      {
        paramLayoutInflater.put("key1", "value1");
        paramLayoutInflater.put("key2", "value2");
        if (getArguments() == null)
        {
          paramLayoutInflater = null;
          V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
          return paramLayoutInflater;
        }
      }
      catch (Throwable paramViewGroup)
      {
        GdtLog.d("GdtInterstitialFragmentForJS", "onCreateView", paramViewGroup);
        continue;
        paramViewGroup = getArguments().getString("params");
      }
      try
      {
        paramBundle = new JSONObject(paramViewGroup);
        paramViewGroup = paramBundle.getJSONObject("requestParams");
        Object localObject = paramBundle.getJSONObject("clickParams");
        paramBundle = new JSONObject();
        paramBundle.put("options", localObject);
        this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGet(), paramViewGroup)));
        paramViewGroup = new GdtHandler.Options();
        GdtHandler.a(paramViewGroup, paramBundle.toString());
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a = paramViewGroup;
        paramViewGroup = new Button(getActivity());
        paramViewGroup.setText("load");
        paramViewGroup.setOnClickListener(new GdtInterstitialFragmentForJS.1(this));
        paramBundle = new Button(getActivity());
        paramBundle.setText("show(style=0)");
        paramBundle.setOnClickListener(new GdtInterstitialFragmentForJS.2(this));
        localObject = new Button(getActivity());
        ((Button)localObject).setText("show - close after 5s(style=0)");
        ((Button)localObject).setOnClickListener(new GdtInterstitialFragmentForJS.3(this));
        Button localButton = new Button(getActivity());
        localButton.setText("show(style=1) with antiSpamTestParams");
        localButton.setOnClickListener(new GdtInterstitialFragmentForJS.4(this, paramLayoutInflater));
        paramLayoutInflater = new LinearLayout(getActivity());
        paramLayoutInflater.setBackgroundColor(Color.parseColor("#DBDBDB"));
        paramLayoutInflater.setOrientation(1);
        paramLayoutInflater.addView(paramViewGroup);
        paramLayoutInflater.addView(paramBundle);
        paramLayoutInflater.addView((View)localObject);
        paramLayoutInflater.addView(localButton);
      }
      catch (JSONException paramViewGroup)
      {
        for (;;)
        {
          GdtLog.d("GdtInterstitialFragmentForJS", "createParams error", paramViewGroup);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS
 * JD-Core Version:    0.7.0.1
 */