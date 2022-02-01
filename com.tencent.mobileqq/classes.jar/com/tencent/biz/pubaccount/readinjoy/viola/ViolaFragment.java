package com.tencent.biz.pubaccount.readinjoy.viola;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tlg;
import tlq;
import tlr;
import tls;
import tlt;
import tlu;
import tlv;
import tlw;
import tlx;
import tmk;
import tmn;
import tmp;
import zuc;

public class ViolaFragment
  extends ViolaLazyFragment
{
  public static String a;
  public HippyQQEngine a;
  private tlx jdField_a_of_type_Tlx;
  public tmk a;
  public tmn a;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaLangString = "pageConfigParams";
  }
  
  public ViolaFragment()
  {
    this.jdField_a_of_type_Tmk = new tmk(this);
    this.jdField_a_of_type_Tmn = new tmn(this);
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
  
  public static ViolaFragment a(String paramString, ReadInJoyChannelActivity.SerializableMap paramSerializableMap, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localBundle.putSerializable(jdField_a_of_type_JavaLangString, paramSerializableMap);
    if (paramBoolean) {
      localBundle.putInt(tmn.b, 1);
    }
    return a(localBundle);
  }
  
  private void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Tmk.a(paramBundle);
  }
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    Object localObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(paramBundle.getString("param"));
        localObject = localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      this.jdField_a_of_type_Tmn.b(paramViewGroup);
      if (!this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.isReady()) {
        this.jdField_a_of_type_Tmn.a();
      }
      this.jdField_a_of_type_Tmn.a(paramViewGroup, new tlq(this, paramBundle, paramViewGroup));
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippy(a(), (JSONObject)localObject, this.jdField_a_of_type_Tmn.b(), new tlr(this, paramBundle, paramViewGroup));
      return;
    }
  }
  
  private void c(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.jdField_a_of_type_Tmn.c(paramViewGroup);
        this.jdField_a_of_type_Tmn.b(paramViewGroup);
        this.jdField_a_of_type_Tmn.a(paramViewGroup, new tls(this));
        if (a() == null) {
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
        this.jdField_a_of_type_Tmk.a(a(), paramBundle, this.jdField_a_of_type_Tmn.b(), new tlt(this));
        return;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void d(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Tmn.a(paramViewGroup);
  }
  
  public int a()
  {
    return 2131558463;
  }
  
  public CommonSuspensionGestureLayout a()
  {
    return this.jdField_a_of_type_Tmk.a();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_Tmk.a();
  }
  
  public HashMap a()
  {
    return this.jdField_a_of_type_Tmn.a();
  }
  
  public tmp a()
  {
    return this.jdField_a_of_type_Tmn.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tmk.d();
    if (this.jdField_a_of_type_Tmn.b()) {
      this.jdField_a_of_type_Tmk.a(a(), true);
    }
    while (getActivity() == null) {
      return;
    }
    getActivity().doOnBackPressed();
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Tmn.a(paramBundle);
  }
  
  public void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    b(paramBundle);
    d(paramViewGroup);
    int j = 0;
    String str = a();
    int i = j;
    if (!TextUtils.isEmpty(str))
    {
      i = j;
      if (str.contains("v_bundleName"))
      {
        str = Uri.parse(str).getQueryParameter("v_bundleName");
        i = j;
        if (!TextUtils.isEmpty(str))
        {
          j = HippyQQEngine.getModuleOnlineConfig(str);
          if (QLog.isColorLevel()) {
            QLog.d("Hippy", 2, "Hippy: moduleName=" + str + ", hippyOnlineConfig=" + j);
          }
          i = j;
          if (j == 1)
          {
            if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null) {
              this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = new HippyQQEngine(this, str);
            }
            b(paramBundle, paramViewGroup);
            i = j;
          }
        }
      }
    }
    if (i != 1) {
      c(paramBundle, paramViewGroup);
    }
    a(paramViewGroup);
    b();
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Tmn.b())
    {
      this.jdField_a_of_type_Tmk.a(paramViewGroup);
      this.jdField_a_of_type_Tmk.a(new tlu(this));
      this.jdField_a_of_type_Tmn.a(new tlv(this, paramViewGroup));
    }
  }
  
  public void a(HashMap<String, Object> paramHashMap, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Tmn.a(paramHashMap, paramViewGroup);
  }
  
  public void a(tlx paramtlx)
  {
    this.jdField_a_of_type_Tlx = paramtlx;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Tmn.a(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Tmn.b();
  }
  
  protected void b() {}
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Tmk.c(paramBoolean);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaFragment", 2, "reload viola Page");
    }
    this.jdField_a_of_type_Tmn.a();
    this.jdField_a_of_type_Tmk.a(new tlw(this));
  }
  
  public void d()
  {
    FrameLayout localFrameLayout;
    if ((b() != null) && (!TextUtils.isEmpty(a())) && ("1".equals(tlg.a(a(), "support_night"))))
    {
      boolean bool = ThemeUtil.isInNightMode(getActivity().app);
      localFrameLayout = new FrameLayout(a().getContext());
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localFrameLayout.setBackgroundColor(Color.parseColor("#77000000"));
      b().addView(localFrameLayout, localLayoutParams);
      if (!bool) {
        break label113;
      }
      if (localFrameLayout != null)
      {
        localFrameLayout.setVisibility(0);
        a("#ff888888", true);
      }
    }
    label113:
    while (localFrameLayout == null) {
      return;
    }
    localFrameLayout.setVisibility(8);
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      boolean bool = this.jdField_a_of_type_Tmk.a();
      if (this.jdField_a_of_type_Tmn.b())
      {
        this.jdField_a_of_type_Tmk.a(a(), true);
        return true;
      }
      return bool;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Tmk.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (getActivity() == null) {
        break label60;
      }
      getActivity().finishAndRemoveTask();
    }
    try
    {
      for (;;)
      {
        this.jdField_a_of_type_Tmk.c();
        if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine != null)
        {
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.onDestroy();
          this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = null;
        }
        label52:
        zuc.a(getActivity());
        return;
        label60:
        BaseActivity.sTopActivity.finishAndRemoveTask();
      }
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    if ((!this.jdField_a_of_type_Tmn.b()) && (getActivity() != null)) {
      getActivity().overridePendingTransition(0, 2130772012);
    }
  }
  
  public void onPause()
  {
    this.jdField_a_of_type_Tmk.b();
    super.onPause();
  }
  
  public void onResume()
  {
    this.jdField_a_of_type_Tmk.a();
    super.onResume();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    this.jdField_a_of_type_Tmk.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment
 * JD-Core Version:    0.7.0.1
 */