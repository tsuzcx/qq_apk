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
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import smk;
import smt;
import smu;
import smv;
import smw;
import smx;
import smy;
import snl;
import sno;
import snq;
import xwb;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String a;
  private smy jdField_a_of_type_Smy;
  public snl a;
  public sno a;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "pageConfigParams";
  }
  
  public ViolaFragment()
  {
    this.jdField_a_of_type_Snl = new snl(this);
    this.jdField_a_of_type_Sno = new sno(this);
  }
  
  private static ViolaFragment a(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = new ViolaFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  public static ViolaFragment a(String paramString1, String paramString2, ReadInJoyChannelActivity.SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    paramString2 = new Bundle();
    paramString2.putString("url", paramString1);
    paramString2.putSerializable(jdField_a_of_type_JavaLangString, paramSerializableMap);
    if (paramBoolean) {
      paramString2.putInt(sno.b, 1);
    }
    return a(paramString2);
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Snl.a(paramBundle);
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
        this.jdField_a_of_type_Sno.c(paramViewGroup);
        this.jdField_a_of_type_Sno.b(paramViewGroup);
        this.jdField_a_of_type_Sno.a(paramViewGroup, new smt(this));
        this.jdField_a_of_type_Snl.a(a(), paramBundle, this.jdField_a_of_type_Sno.b(), new smu(this));
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
    this.jdField_a_of_type_Sno.a(paramViewGroup);
  }
  
  private void v() {}
  
  public int a()
  {
    return 2131558457;
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_Snl.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Snl.a();
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_Sno.a();
  }
  
  public snq a()
  {
    return this.jdField_a_of_type_Sno.a();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.jdField_a_of_type_Sno.a();
    this.jdField_a_of_type_Snl.a(new smx(this));
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Sno.a(paramBundle);
  }
  
  public void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    b(paramBundle);
    d(paramViewGroup);
    b(paramBundle, paramViewGroup);
    a(paramViewGroup);
    v();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Sno.b())
    {
      this.jdField_a_of_type_Snl.a(paramViewGroup);
      this.jdField_a_of_type_Snl.a(new smv(this));
      this.jdField_a_of_type_Sno.a(new smw(this, paramViewGroup));
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Sno.a(paramHashMap, paramViewGroup);
  }
  
  public void a(smy paramsmy)
  {
    this.jdField_a_of_type_Smy = paramsmy;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Sno.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Sno.b();
  }
  
  public void b()
  {
    FrameLayout localFrameLayout;
    if ((b() != null) && (!TextUtils.isEmpty(a())) && ("1".equals(smk.a(a(), "support_night"))))
    {
      boolean bool = ThemeUtil.isInNightMode(getActivity().app);
      localFrameLayout = new FrameLayout(a().getContext());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localFrameLayout.setBackgroundColor(Color.parseColor("#77000000"));
      b().addView(localFrameLayout, localLayoutParams);
      if (!bool) {
        break label110;
      }
      if (localFrameLayout != null)
      {
        localFrameLayout.setVisibility(0);
        a("#ff888888", true);
      }
    }
    label110:
    while (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Snl.c(paramBoolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Snl.d();
    if (this.jdField_a_of_type_Sno.b()) {
      this.jdField_a_of_type_Snl.a(a(), true);
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
      boolean bool = this.jdField_a_of_type_Snl.a();
      if (this.jdField_a_of_type_Sno.b())
      {
        this.jdField_a_of_type_Snl.a(a(), true);
        return true;
      }
      return bool;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Snl.a(paramInt1, paramInt2, paramIntent);
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
        this.jdField_a_of_type_Snl.c();
        label33:
        xwb.a(getActivity());
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
  
  public void onFinish()
  {
    super.onFinish();
    if ((!this.jdField_a_of_type_Sno.b()) && (getActivity() != null)) {
      getActivity().overridePendingTransition(0, 2130772011);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Snl.b();
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Snl.a();
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Snl.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */