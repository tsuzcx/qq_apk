package com.tencent.gdtad.api.interstitial;

import abtu;
import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import bcpq;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityReverseLandscapeForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import yuj;
import yul;
import yum;
import yut;
import yxs;
import yyf;
import yze;

public final class GdtInterstitialFragment
  extends PublicBaseFragment
{
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_a_of_type_Int = 0;
  private bcpq jdField_a_of_type_Bcpq;
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private yut jdField_a_of_type_Yut;
  private boolean jdField_a_of_type_Boolean;
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) && (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())) {
      return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    yxs.b("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      if ((this.jdField_a_of_type_Bcpq == null) || (!this.jdField_a_of_type_Bcpq.isShowing())) {}
    }
    while ((paramBoolean) || (this.jdField_a_of_type_Bcpq == null))
    {
      return;
      this.jdField_a_of_type_Bcpq = new bcpq(getActivity(), getResources().getDimensionPixelSize(2131298865));
      this.jdField_a_of_type_Bcpq.setCancelable(false);
      this.jdField_a_of_type_Bcpq.a(ajyc.a(2131705171) + "加载");
      this.jdField_a_of_type_Bcpq.show();
      return;
    }
    if (this.jdField_a_of_type_Bcpq.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bcpq.dismiss();
      this.jdField_a_of_type_Bcpq = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        yxs.d("GdtInterstitialFragment", "setLoading", localThrowable);
      }
    }
  }
  
  public static boolean a(Activity paramActivity, GdtInterstitialParams paramGdtInterstitialParams)
  {
    boolean bool = false;
    int j = 4;
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = j;
    }
    for (;;)
    {
      yxs.b("GdtInterstitialFragment", String.format("start errorCode:%d", new Object[] { Integer.valueOf(i) }));
      yyf.a(paramActivity, paramGdtInterstitialParams, i);
      if (i == 0) {
        bool = true;
      }
      return bool;
      i = j;
      if (paramActivity != null)
      {
        i = j;
        if (paramGdtInterstitialParams != null)
        {
          i = j;
          if (paramGdtInterstitialParams.b())
          {
            Object localObject = null;
            if (paramGdtInterstitialParams.jdField_a_of_type_Int == 1) {
              localObject = PublicTransFragmentActivityForTool.class;
            }
            for (;;)
            {
              i = j;
              if (localObject == null) {
                break;
              }
              if (!jdField_a_of_type_JavaUtilSet.contains(paramGdtInterstitialParams.a())) {
                break label146;
              }
              i = 2;
              break;
              if (paramGdtInterstitialParams.jdField_a_of_type_Int == 0) {
                localObject = PublicTransFragmentActivityLandscapeForTool.class;
              } else if (paramGdtInterstitialParams.jdField_a_of_type_Int == 8) {
                localObject = PublicTransFragmentActivityReverseLandscapeForTool.class;
              }
            }
            label146:
            jdField_a_of_type_JavaUtilSet.add(paramGdtInterstitialParams.a());
            Bundle localBundle = new Bundle();
            if ((paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle != null) && (!paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle.isEmpty())) {
              localBundle.putAll(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle);
            }
            localBundle.putParcelable("params", paramGdtInterstitialParams);
            localBundle.putLong("startToShowTimeMillis", System.currentTimeMillis());
            Intent localIntent = new Intent();
            localIntent.putExtra("public_fragment_window_feature", 1);
            localIntent.putExtras(localBundle);
            abtu.a(paramActivity, localIntent, (Class)localObject, GdtInterstitialFragment.class, 10001);
            i = 0;
          }
        }
      }
    }
  }
  
  void a()
  {
    long l = -2147483648L;
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Int == 2) {
      yum.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams);
    }
    a(false);
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams == null) {}
    while (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b != -2147483648L)
    {
      yxs.d("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Long != -2147483648L) {
      l = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b - this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Long;
    }
    yxs.b("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(l) }));
    yyf.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams);
  }
  
  boolean a()
  {
    boolean bool2 = false;
    boolean bool1;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool1 = bool2;
    }
    for (;;)
    {
      yxs.d("GdtInterstitialFragment", "onClick error");
      return bool1;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
        {
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
          localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(yul.a().a());
          localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
          localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
          localParams.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Boolean;
          localParams.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Int;
          localParams.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_b_of_type_Int;
          localParams.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_b_of_type_Boolean;
          localParams.c = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.c;
          localParams.d = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.d;
          localParams.e = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.e;
          localParams.jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidGraphicsRect;
          localParams.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Long;
          localParams.f = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.f;
          localParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_JavaLangString;
          localParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle;
          bool1 = bool2;
          if (localParams.a())
          {
            GdtHandler.a(localParams);
            bool1 = true;
          }
        }
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      yxs.b("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      return bool;
      a(false);
      if (getActivity() == null)
      {
        bool = false;
      }
      else
      {
        getActivity().finish();
        yyf.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, paramInt1, paramInt2, paramInt3);
        bool = true;
      }
    }
  }
  
  public void beforeFinish()
  {
    yxs.b("GdtInterstitialFragment", "beforeFinish");
    this.jdField_a_of_type_Int = 4;
    if (this.jdField_a_of_type_Yut != null) {
      this.jdField_a_of_type_Yut.c(getActivity());
    }
    yul.a().a(a());
    getActivity().setResult(-1);
    super.beforeFinish();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {}
    while ((paramActivity == null) || (Build.VERSION.SDK_INT < 5)) {
      return;
    }
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_Int = 1;
    a(true);
    AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialFragment.1(this), 0, yul.a().a(getActivity()));
    yuj.a();
    paramLayoutInflater = new FrameLayout(getActivity());
    if (getArguments() == null) {}
    for (;;)
    {
      yxs.b("GdtInterstitialFragment", String.format("onCreateView traceId:%s", new Object[] { a() }));
      return paramLayoutInflater;
      if (getArguments().containsKey("params"))
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = ((GdtInterstitialParams)getArguments().getParcelable("params"));
        if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) && (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b()) && (!TextUtils.isEmpty(a())) && (getArguments().containsKey("startToShowTimeMillis")))
        {
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Long = getArguments().getLong("startToShowTimeMillis");
          if ((yul.a().a(a(), new WeakReference(this))) || (getActivity() != null))
          {
            getActivity().setRequestedOrientation(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Int);
            this.jdField_a_of_type_Yut = new yut(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams);
            if (this.jdField_a_of_type_Yut.a() != null)
            {
              paramViewGroup = new FrameLayout.LayoutParams(yze.b(getActivity()), yze.d(getActivity()));
              paramViewGroup.gravity = 17;
              paramLayoutInflater.addView(this.jdField_a_of_type_Yut.a(), paramViewGroup);
              if (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Boolean) {
                getActivity().getWindow().addFlags(1024);
              }
            }
          }
        }
      }
    }
  }
  
  public void onFinish()
  {
    yxs.b("GdtInterstitialFragment", "onFinish");
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    yxs.b("GdtInterstitialFragment", "onPause");
    this.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_Yut != null) {
      this.jdField_a_of_type_Yut.a(getActivity());
    }
    if (this.jdField_a_of_type_Boolean) {
      yum.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    yxs.b("GdtInterstitialFragment", "onResume");
    this.jdField_a_of_type_Int = 2;
    if (this.jdField_a_of_type_Yut != null) {
      this.jdField_a_of_type_Yut.b(getActivity());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(false);
      yum.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */