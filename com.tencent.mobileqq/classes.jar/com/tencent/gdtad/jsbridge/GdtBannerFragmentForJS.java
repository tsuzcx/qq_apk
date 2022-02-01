package com.tencent.gdtad.jsbridge;

import acaq;
import acbk;
import acbl;
import acbm;
import acfx;
import acfz;
import acho;
import aciv;
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
  extends acfz
{
  private acaq jdField_a_of_type_Acaq = new acfx(this);
  private acbk jdField_a_of_type_Acbk;
  private acbl jdField_a_of_type_Acbl;
  private GdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  
  public GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  }
  
  public void a()
  {
    int i = aciv.a(getActivity(), 1080, 1026);
    int j = acbm.a(this.jdField_a_of_type_Acbk.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Acbl = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.render(getActivity(), i, j);
    if (this.jdField_a_of_type_Acbl == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (this.jdField_a_of_type_Acbl.a() == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Acbl.a(), localLayoutParams);
    this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.onDisplay();
    AdThreadManager.INSTANCE.postDelayed(new GdtBannerFragmentForJS.1(this), 0, 5000L);
  }
  
  public void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.jdField_a_of_type_Acbk = new acbk();
    this.jdField_a_of_type_Acbk.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramQQAdGet;
    this.jdField_a_of_type_Acbk.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.jdField_a_of_type_Acbk.jdField_a_of_type_Int = i;
      i = aciv.a(getActivity(), 1080, 1026);
      int j = acbm.a(this.jdField_a_of_type_Acbk.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Acbk.b = i;
      this.jdField_a_of_type_Acbk.c = j;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = new GdtBannerAd(this.jdField_a_of_type_Acbk);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_Acaq));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        acho.d("GdtBannerFragmentForJS", "createParams error", paramString);
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
    if (this.jdField_a_of_type_Acbl != null) {
      this.jdField_a_of_type_Acbl.c(getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Acbl != null) {
      this.jdField_a_of_type_Acbl.a(getActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acbl != null) {
      this.jdField_a_of_type_Acbl.b(getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */