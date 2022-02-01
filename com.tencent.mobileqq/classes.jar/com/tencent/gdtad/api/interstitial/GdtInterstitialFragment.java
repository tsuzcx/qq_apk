package com.tencent.gdtad.api.interstitial;

import acam;
import acbu;
import acby;
import accc;
import accd;
import accf;
import acck;
import acho;
import acid;
import aciv;
import aeow;
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
import anvx;
import bisl;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForJS;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityReverseLandscapeForTool;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public final class GdtInterstitialFragment
  extends PublicBaseFragment
{
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private acck jdField_a_of_type_Acck;
  private bisl jdField_a_of_type_Bisl;
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private GdtInterstitialStatus jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus = new GdtInterstitialStatus();
  
  public static int a(Activity paramActivity, GdtInterstitialParams paramGdtInterstitialParams)
  {
    int j = 4;
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = j;
    }
    for (;;)
    {
      acho.b("GdtInterstitialFragment", String.format("start errorCode:%d", new Object[] { Integer.valueOf(i) }));
      return i;
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
            if (paramGdtInterstitialParams.jdField_b_of_type_Int == 1) {
              localObject = PublicTransFragmentActivityForTool.class;
            }
            for (;;)
            {
              i = j;
              if (localObject == null) {
                break;
              }
              if (!jdField_a_of_type_JavaUtilSet.contains(paramGdtInterstitialParams.a())) {
                break label129;
              }
              i = 2;
              break;
              if (paramGdtInterstitialParams.jdField_b_of_type_Int == 0) {
                localObject = PublicTransFragmentActivityLandscapeForTool.class;
              } else if (paramGdtInterstitialParams.jdField_b_of_type_Int == 8) {
                localObject = PublicTransFragmentActivityReverseLandscapeForTool.class;
              }
            }
            label129:
            jdField_a_of_type_JavaUtilSet.add(paramGdtInterstitialParams.a());
            Bundle localBundle = new Bundle();
            if ((paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle != null) && (!paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle.isEmpty())) {
              localBundle.putAll(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle);
            }
            localBundle.putParcelable("interstitialParams", paramGdtInterstitialParams);
            localBundle.putLong("interstitialStartToShowTimeMillis", System.currentTimeMillis());
            paramGdtInterstitialParams = new Intent();
            paramGdtInterstitialParams.putExtra("public_fragment_window_feature", 1);
            paramGdtInterstitialParams.putExtras(localBundle);
            aeow.a(paramActivity, paramGdtInterstitialParams, (Class)localObject, GdtInterstitialFragment.class, 10001);
            i = 0;
          }
        }
      }
    }
  }
  
  private String a()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null) && (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())) {
      return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    acho.b("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      if ((this.jdField_a_of_type_Bisl == null) || (!this.jdField_a_of_type_Bisl.isShowing())) {}
    }
    while ((paramBoolean) || (this.jdField_a_of_type_Bisl == null))
    {
      return;
      this.jdField_a_of_type_Bisl = new bisl(getActivity(), getResources().getDimensionPixelSize(2131299080));
      this.jdField_a_of_type_Bisl.setCancelable(false);
      this.jdField_a_of_type_Bisl.a(anvx.a(2131704649) + "加载");
      this.jdField_a_of_type_Bisl.show();
      return;
    }
    if (this.jdField_a_of_type_Bisl.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        acho.d("GdtInterstitialFragment", "setLoading", localThrowable);
      }
    }
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams == null) || (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())) {
      return;
    }
    GdtAd localGdtAd = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    if (!localGdtAd.isHitPreloadCanvasJsonExp())
    {
      acho.b("GdtInterstitialFragment", "not hitPreloadCanvasJsonExp");
      return;
    }
    acam.a().a(localGdtAd);
  }
  
  public GdtInterstitialParams a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  }
  
  public GdtInterstitialStatus a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      acho.d("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int == 2) {
      accd.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
    a(false);
    acho.b("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    acid.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_f_of_type_Int = paramInt;
  }
  
  boolean a()
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      acho.b("GdtInterstitialFragment", String.format("onClick %b", new Object[] { Boolean.valueOf(bool) }));
      return bool;
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null)
      {
        if (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
        {
          bool = false;
        }
        else
        {
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
          localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(accc.a().a());
          localParams.jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
          localParams.jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForJS.class;
          localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
          localParams.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Boolean;
          localParams.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Int;
          localParams.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_b_of_type_Int;
          localParams.jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_b_of_type_Boolean;
          localParams.c = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.c;
          localParams.d = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.d;
          localParams.jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_e_of_type_Boolean;
          localParams.jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidGraphicsRect;
          localParams.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Long;
          localParams.jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_f_of_type_Boolean;
          localParams.g = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.g;
          localParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_JavaLangString;
          localParams.jdField_a_of_type_OrgJsonJSONObject = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_OrgJsonJSONObject;
          localParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle;
          if (!localParams.a())
          {
            bool = false;
          }
          else
          {
            GdtHandler.a(localParams);
            bool = true;
          }
        }
      }
      else {
        bool = false;
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      acho.b("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      return bool;
      a(false);
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.c = paramInt2;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.d = paramInt3;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Int = paramInt4;
      if (getActivity() == null)
      {
        bool = false;
      }
      else
      {
        getActivity().finish();
        acid.d(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
        bool = true;
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_f_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_f_of_type_Boolean = true;
    acho.b("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    acid.c(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void beforeFinish()
  {
    acho.b("GdtInterstitialFragment", "beforeFinish");
    if (this.jdField_a_of_type_Acck != null) {
      this.jdField_a_of_type_Acck.c(getActivity());
    }
    accc.a().a(a());
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("interstitialStatus", this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    getActivity().setResult(-1, localIntent);
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
    i = 1;
    paramLayoutInflater = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
    boolean bool;
    if (accf.a().a() == 3)
    {
      bool = true;
      paramLayoutInflater.jdField_a_of_type_Boolean = bool;
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = new FrameLayout(getActivity());
      }
      catch (Throwable paramViewGroup)
      {
        try
        {
          if (!accc.a().a(a(), new WeakReference(this)))
          {
            i = 1;
            continue;
          }
          if (getActivity() == null)
          {
            i = 1;
            continue;
          }
          getActivity().setRequestedOrientation(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_b_of_type_Int);
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.c = aciv.b(getActivity());
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.d = aciv.d(getActivity());
          if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.c <= 0) {
            break label522;
          }
          if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.d <= 0)
          {
            i = 1;
            continue;
          }
          this.jdField_a_of_type_Acck = new acck(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
          if (this.jdField_a_of_type_Acck.a() == null)
          {
            i = 1;
            continue;
          }
          paramViewGroup = new FrameLayout.LayoutParams(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.c, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.d);
          paramViewGroup.gravity = 17;
          paramLayoutInflater.addView(this.jdField_a_of_type_Acck.a(), paramViewGroup);
          if (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Boolean) {
            getActivity().getWindow().addFlags(1024);
          }
          i = 0;
        }
        catch (Throwable paramViewGroup)
        {
          continue;
        }
        paramViewGroup = paramViewGroup;
        i = 4;
        paramLayoutInflater = null;
        acho.d("GdtInterstitialFragment", "onCreateView", paramViewGroup);
        continue;
      }
      for (;;)
      {
        try
        {
          a(true);
          AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialFragment.1(this), 0, 10000L);
          acby.a();
          ArkAppNotifyCenter.setNotify(accc.a().a().jdField_a_of_type_JavaLangString, new WeakReference(accc.a().a()));
          paramViewGroup = getArguments();
          if (paramViewGroup == null) {
            i = 4;
          }
        }
        catch (Throwable paramViewGroup)
        {
          i = 4;
          break label495;
          break;
        }
        try
        {
          acho.b("GdtInterstitialFragment", String.format("onCreateView traceId:%s", new Object[] { a() }));
          c();
          AdThreadManager.INSTANCE.post(new GdtInterstitialFragment.2(this, i), 5);
          V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
          return paramLayoutInflater;
        }
        catch (Throwable paramViewGroup)
        {
          break label495;
          i = 1;
        }
      }
      bool = false;
      break;
      if (!getArguments().containsKey("interstitialParams"))
      {
        i = 4;
      }
      else
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = ((GdtInterstitialParams)getArguments().getParcelable("interstitialParams"));
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams == null)
        {
          i = 4;
        }
        else if (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
        {
          i = 4;
        }
        else if (TextUtils.isEmpty(a()))
        {
          i = 4;
        }
        else
        {
          if (getArguments().containsKey("interstitialStartToShowTimeMillis")) {
            continue;
          }
          i = 4;
        }
      }
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Long = getArguments().getLong("interstitialStartToShowTimeMillis");
  }
  
  public void onFinish()
  {
    acho.b("GdtInterstitialFragment", "onFinish");
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    acho.b("GdtInterstitialFragment", "onPause");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 3;
    if (this.jdField_a_of_type_Acck != null) {
      this.jdField_a_of_type_Acck.a(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean) {
      accd.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    acho.b("GdtInterstitialFragment", "onResume");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 2;
    if (this.jdField_a_of_type_Acck != null) {
      this.jdField_a_of_type_Acck.b(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      a(false);
      accd.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */