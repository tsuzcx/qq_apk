package com.tencent.gdtad.jsbridge;

import acos;
import acpl;
import acpm;
import acpn;
import actt;
import actv;
import acvc;
import acwn;
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
import com.tencent.gdtad.api.banner.GdtBannerAd;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtBannerFragmentForJS
  extends actv
{
  private acos jdField_a_of_type_Acos = new actt(this);
  private acpl jdField_a_of_type_Acpl;
  private acpm jdField_a_of_type_Acpm;
  private GdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  
  public GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  }
  
  public void a()
  {
    int i = acwn.a(getActivity(), 1080, 1026);
    int j = acpn.a(this.jdField_a_of_type_Acpl.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Acpm = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.render(getActivity(), i, j);
    if (this.jdField_a_of_type_Acpm == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (this.jdField_a_of_type_Acpm.a() == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Acpm.a(), localLayoutParams);
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.onDisplay();
    AdThreadManager.INSTANCE.postDelayed(new GdtBannerFragmentForJS.1(this), 0, 5000L);
  }
  
  public void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.jdField_a_of_type_Acpl = new acpl();
    this.jdField_a_of_type_Acpl.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramQQAdGet;
    this.jdField_a_of_type_Acpl.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.jdField_a_of_type_Acpl.jdField_a_of_type_Int = i;
      i = acwn.a(getActivity(), 1080, 1026);
      int j = acpn.a(this.jdField_a_of_type_Acpl.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Acpl.b = i;
      this.jdField_a_of_type_Acpl.c = j;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = new GdtBannerAd(this.jdField_a_of_type_Acpl);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_Acos));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        acvc.d("GdtBannerFragmentForJS", "createParams error", paramString);
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
    if (this.jdField_a_of_type_Acpm != null) {
      this.jdField_a_of_type_Acpm.c(getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Acpm != null) {
      this.jdField_a_of_type_Acpm.a(getActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acpm != null) {
      this.jdField_a_of_type_Acpm.b(getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */