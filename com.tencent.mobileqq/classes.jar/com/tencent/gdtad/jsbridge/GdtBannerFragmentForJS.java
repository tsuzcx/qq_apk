package com.tencent.gdtad.jsbridge;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import yjs;
import ykt;
import yku;
import ykv;
import ymz;
import yny;
import ypk;

public class GdtBannerFragmentForJS
  extends ymz
{
  private GdtBannerAd jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  private ykt jdField_a_of_type_Ykt;
  private yku jdField_a_of_type_Yku;
  
  public GdtAd a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd;
  }
  
  public void a()
  {
    int i = ypk.a(getActivity(), 1080, 1026);
    int j = ykv.a(this.jdField_a_of_type_Ykt.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Yku = this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.render(getActivity(), i, j);
    if (this.jdField_a_of_type_Yku == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "ad is rendered", 0).show();
      return;
    }
    if (this.jdField_a_of_type_Yku.a() == null)
    {
      Toast.makeText(getActivity().getApplicationContext(), "error", 0).show();
      return;
    }
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(i, j);
    localLayoutParams.gravity = 1;
    localLayoutParams.topMargin = 100;
    localLayoutParams.bottomMargin = 100;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_Yku.a(), localLayoutParams);
  }
  
  public void a(String paramString, qq_ad_get.QQAdGet paramQQAdGet, yjs paramyjs)
  {
    this.jdField_a_of_type_Ykt = new ykt();
    this.jdField_a_of_type_Ykt.jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet = paramQQAdGet;
    this.jdField_a_of_type_Ykt.jdField_a_of_type_Yjs = paramyjs;
    try
    {
      int i = new JSONObject(paramString).getInt("style");
      this.jdField_a_of_type_Ykt.jdField_a_of_type_Int = i;
      i = ypk.a(getActivity(), 1080, 1026);
      int j = ykv.a(this.jdField_a_of_type_Ykt.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Ykt.b = i;
      this.jdField_a_of_type_Ykt.c = j;
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd = new GdtBannerAd(this.jdField_a_of_type_Ykt);
      this.jdField_a_of_type_ComTencentGdtadApiBannerGdtBannerAd.setListener(new WeakReference(this.jdField_a_of_type_Yka));
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        yny.d("GdtBannerFragmentForJS", "createParams error", paramString);
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
    if (this.jdField_a_of_type_Yku != null) {
      this.jdField_a_of_type_Yku.c(getActivity());
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Yku != null) {
      this.jdField_a_of_type_Yku.a(getActivity());
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Yku != null) {
      this.jdField_a_of_type_Yku.b(getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtBannerFragmentForJS
 * JD-Core Version:    0.7.0.1
 */