package com.tencent.gdtad.jsbridge;

import abtu;
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
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import ysq;
import ysr;
import yta;
import yuk;
import yxd;
import yxe;
import yxf;
import yxr;
import yxs;
import yyw;
import yyx;

public class GdtInterstitialFragmentForJS
  extends PublicBaseFragment
{
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = new GdtInterstitialParams();
  private qq_ad_get.QQAdGet jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet;
  private ysq jdField_a_of_type_Ysq;
  private ysr jdField_a_of_type_Ysr = new yxf(this);
  private yta jdField_a_of_type_Yta;
  private yuk jdField_a_of_type_Yuk;
  
  public static void a(Activity paramActivity, Class<? extends PublicFragmentActivity> paramClass, JSONObject paramJSONObject)
  {
    if ((paramActivity == null) || (paramJSONObject == null))
    {
      yxs.b("GdtInterstitialFragmentForJS", "start error");
      return;
    }
    yxs.b("GdtInterstitialFragmentForJS", "start");
    Bundle localBundle = new Bundle();
    localBundle.putString("params", paramJSONObject.toString());
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("public_fragment_window_feature", 1);
    paramJSONObject.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramJSONObject.putExtras(localBundle);
    abtu.a(paramActivity, paramJSONObject, paramClass, GdtInterstitialFragmentForJS.class);
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
        yxs.d("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to portrait.");
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
      yxs.d("GdtInterstitialFragmentForJS", "Unknown screen orientation. Defaulting to landscape.");
      return 0;
    case 0: 
      return 0;
    case 2: 
      return 8;
    }
    return 9;
  }
  
  public int a(GdtAd paramGdtAd, int paramInt1, int paramInt2, int paramInt3)
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
    yxs.b("GdtInterstitialFragmentForJS", String.format("onActivityResult requestCode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (paramInt1 == 10001) {
      if (paramInt2 != -1) {
        break label59;
      }
    }
    label59:
    for (paramIntent = "on closed";; paramIntent = "on closed error")
    {
      Toast.makeText(getActivity().getApplicationContext(), paramIntent, 0).show();
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    yyw.a().a(getActivity(), new yyx());
    if (getArguments() == null) {
      return null;
    }
    paramLayoutInflater = getArguments().getString("params");
    try
    {
      paramViewGroup = new JSONObject(paramLayoutInflater);
      paramLayoutInflater = paramViewGroup.getJSONObject("requestParams");
      paramBundle = paramViewGroup.getJSONObject("clickParams");
      paramViewGroup = new JSONObject();
      paramViewGroup.put("options", paramBundle);
      this.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = ((qq_ad_get.QQAdGet)qq_ad_get.QQAdGet.class.cast(yxr.a(new qq_ad_get.QQAdGet(), paramLayoutInflater)));
      paramLayoutInflater = new GdtHandler.Options();
      GdtHandler.a(paramLayoutInflater, paramViewGroup.toString());
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a = paramLayoutInflater;
      paramLayoutInflater = new Button(getActivity());
      paramLayoutInflater.setText("load");
      paramLayoutInflater.setOnClickListener(new yxd(this));
      paramViewGroup = new Button(getActivity());
      paramViewGroup.setText("show");
      paramViewGroup.setOnClickListener(new yxe(this));
      paramBundle = new LinearLayout(getActivity());
      paramBundle.setBackgroundColor(Color.parseColor("#DBDBDB"));
      paramBundle.setOrientation(1);
      paramBundle.addView(paramLayoutInflater);
      paramBundle.addView(paramViewGroup);
      return paramBundle;
    }
    catch (JSONException paramLayoutInflater)
    {
      for (;;)
      {
        yxs.d("GdtInterstitialFragmentForJS", "createParams error", paramLayoutInflater);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtInterstitialFragmentForJS
 * JD-Core Version:    0.7.0.1
 */