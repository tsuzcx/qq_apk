package com.tencent.gdtad.jsbridge;

import aaji;
import aajj;
import aajk;
import aamo;
import aanp;
import aapa;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;

public class GdtBannerFragmentForJS
  extends aamo
{
  private aaji jdField_a_of_type_Aaji;
  private aajj jdField_a_of_type_Aajj;
  private GdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  
  public GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  }
  
  public void a()
  {
    int i = aapa.a(getActivity(), 1080, 1026);
    int j = aajk.a(this.jdField_a_of_type_Aaji.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Aajj = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.render(getActivity(), i, j);
    if (this.jdField_a_of_type_Aajj == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (this.jdField_a_of_type_Aajj.a() == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Aajj.a(), localLayoutParams);
  }
  
  public void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, GdtHandler.Params paramParams)
  {
    this.jdField_a_of_type_Aaji = new aaji();
    this.jdField_a_of_type_Aaji.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramQQAdGet;
    this.jdField_a_of_type_Aaji.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramParams;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.jdField_a_of_type_Aaji.jdField_a_of_type_Int = i;
      i = aapa.a(getActivity(), 1080, 1026);
      int j = aajk.a(this.jdField_a_of_type_Aaji.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Aaji.b = i;
      this.jdField_a_of_type_Aaji.c = j;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = new GdtBannerAd(this.jdField_a_of_type_Aaji);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_Aaip));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        aanp.d("GdtBannerFragmentForJS", "createParams error", paramString);
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
    if (this.jdField_a_of_type_Aajj != null) {
      this.jdField_a_of_type_Aajj.c(getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Aajj != null) {
      this.jdField_a_of_type_Aajj.a(getActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aajj != null) {
      this.jdField_a_of_type_Aajj.b(getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */