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
import rvx;
import rwg;
import rwh;
import rwi;
import rwj;
import rwk;
import rwl;
import rwy;
import rxb;
import rxd;
import whj;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String a;
  private rwl jdField_a_of_type_Rwl;
  public rwy a;
  public rxb a;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "pageConfigParams";
  }
  
  public ViolaFragment()
  {
    this.jdField_a_of_type_Rwy = new rwy(this);
    this.jdField_a_of_type_Rxb = new rxb(this);
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Rwy.a(paramBundle);
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
        this.jdField_a_of_type_Rxb.c(paramViewGroup);
        this.jdField_a_of_type_Rxb.b(paramViewGroup);
        this.jdField_a_of_type_Rxb.a(paramViewGroup, new rwg(this));
        this.jdField_a_of_type_Rwy.a(a(), paramBundle, this.jdField_a_of_type_Rxb.b(), new rwh(this));
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
    this.jdField_a_of_type_Rxb.a(paramViewGroup);
  }
  
  private void t() {}
  
  public int a()
  {
    return 2131558457;
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_Rwy.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Rwy.a();
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_Rxb.a();
  }
  
  public rxd a()
  {
    return this.jdField_a_of_type_Rxb.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.jdField_a_of_type_Rxb.a();
    this.jdField_a_of_type_Rwy.a(new rwk(this));
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Rxb.a(paramBundle);
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
    if (this.jdField_a_of_type_Rxb.b())
    {
      this.jdField_a_of_type_Rwy.a(paramViewGroup);
      this.jdField_a_of_type_Rwy.a(new rwi(this));
      this.jdField_a_of_type_Rxb.a(new rwj(this, paramViewGroup));
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Rxb.a(paramHashMap, paramViewGroup);
  }
  
  public void a(rwl paramrwl)
  {
    this.jdField_a_of_type_Rwl = paramrwl;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Rxb.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Rxb.b();
  }
  
  public void b()
  {
    FrameLayout localFrameLayout;
    if ((b() != null) && (!TextUtils.isEmpty(a())) && ("1".equals(rvx.a(a(), "support_night"))))
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
    this.jdField_a_of_type_Rwy.c(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Rwy.d();
    if (this.jdField_a_of_type_Rxb.b()) {
      this.jdField_a_of_type_Rwy.a(a(), true);
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
      boolean bool = this.jdField_a_of_type_Rwy.a();
      if (this.jdField_a_of_type_Rxb.b())
      {
        this.jdField_a_of_type_Rwy.a(a(), true);
        return true;
      }
      return bool;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Rwy.a(paramInt1, paramInt2, paramIntent);
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
        this.jdField_a_of_type_Rwy.c();
        label33:
        whj.a(getActivity());
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
    this.jdField_a_of_type_Rwy.b();
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Rwy.a();
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Rwy.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */