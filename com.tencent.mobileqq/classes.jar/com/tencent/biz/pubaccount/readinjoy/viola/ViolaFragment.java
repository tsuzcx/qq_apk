package com.tencent.biz.pubaccount.readinjoy.viola;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import rjb;
import rjk;
import rjl;
import rjm;
import rjn;
import rjo;
import rjp;
import rkg;
import rko;
import rkq;
import vup;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String a;
  private rjp jdField_a_of_type_Rjp;
  public rkg a;
  public rko a;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "pageConfigParams";
  }
  
  public ViolaFragment()
  {
    this.jdField_a_of_type_Rkg = new rkg(this);
    this.jdField_a_of_type_Rko = new rko(this);
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Rkg.a(paramBundle);
  }
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.jdField_a_of_type_Rko.c(paramViewGroup);
        this.jdField_a_of_type_Rko.b(paramViewGroup);
        this.jdField_a_of_type_Rko.a(paramViewGroup, new rjk(this));
        this.jdField_a_of_type_Rkg.a(a(), paramBundle, this.jdField_a_of_type_Rko.b(), new rjl(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Rko.a(paramViewGroup);
  }
  
  private void t() {}
  
  public int a()
  {
    return 2131492919;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Rkg.a();
  }
  
  public rkq a()
  {
    return this.jdField_a_of_type_Rko.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.jdField_a_of_type_Rko.a();
    this.jdField_a_of_type_Rkg.a(new rjo(this));
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Rko.a(paramBundle);
  }
  
  public void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    b(paramBundle);
    d(paramViewGroup);
    b(paramBundle, paramViewGroup);
    a(paramViewGroup);
    t();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Rko.b())
    {
      this.jdField_a_of_type_Rkg.a(paramViewGroup);
      this.jdField_a_of_type_Rkg.a(new rjm(this));
      this.jdField_a_of_type_Rko.a(new rjn(this, paramViewGroup));
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Rko.a(paramHashMap, paramViewGroup);
  }
  
  public void a(rjp paramrjp)
  {
    this.jdField_a_of_type_Rjp = paramrjp;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rko.a(paramBoolean);
  }
  
  public void b()
  {
    FrameLayout localFrameLayout;
    if ((b() != null) && (!TextUtils.isEmpty(a())) && ("1".equals(rjb.a(a(), "support_night"))))
    {
      boolean bool = ThemeUtil.isInNightMode(getActivity().app);
      localFrameLayout = new FrameLayout(a().getContext());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localFrameLayout.setBackgroundColor(Color.parseColor("#77000000"));
      b().addView(localFrameLayout, localLayoutParams);
      if (!bool) {
        break label109;
      }
      if (localFrameLayout != null)
      {
        localFrameLayout.setVisibility(0);
        a("#ff888888", true);
      }
    }
    label109:
    while (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rkg.d(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rkg.d();
    if (this.jdField_a_of_type_Rko.b()) {
      this.jdField_a_of_type_Rkg.b(a());
    }
    while (getActivity() == null) {
      return;
    }
    getActivity().doOnBackPressed();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      boolean bool = this.jdField_a_of_type_Rkg.a();
      if (this.jdField_a_of_type_Rko.b())
      {
        this.jdField_a_of_type_Rkg.b(a());
        bool = true;
      }
      return bool;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Rkg.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (getActivity() == null) {
        break label41;
      }
      getActivity().finishAndRemoveTask();
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_Rkg.c();
        label33:
        vup.a(getActivity());
        return;
        label41:
        BaseActivity.sTopActivity.finishAndRemoveTask();
      }
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Rkg.b();
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Rkg.a();
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Rkg.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */