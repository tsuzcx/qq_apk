package com.tencent.gdtad.api.interstitial;

import aaoi;
import aaom;
import aaoq;
import aaor;
import aaot;
import aaoy;
import aase;
import aasr;
import aatp;
import adpn;
import alud;
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
import bety;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.ad.tangram.thread.AdThreadManager;
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
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public final class GdtInterstitialFragment
  extends PublicBaseFragment
{
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private aaoy jdField_a_of_type_Aaoy;
  private bety jdField_a_of_type_Bety;
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private GdtInterstitialStatus jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus = new GdtInterstitialStatus();
  
  public static int a(Activity paramActivity, GdtInterstitialParams paramGdtInterstitialParams)
  {
    int j = 4;
    int i;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      i = j;
    }
    do
    {
      do
      {
        do
        {
          aase.b("GdtInterstitialFragment", String.format("start errorCode:%d", new Object[] { Integer.valueOf(i) }));
          return i;
          i = j;
        } while (paramActivity == null);
        i = j;
      } while (paramGdtInterstitialParams == null);
      i = j;
    } while (!paramGdtInterstitialParams.b());
    Object localObject;
    if (paramGdtInterstitialParams.jdField_a_of_type_Int == 1) {
      localObject = PublicTransFragmentActivityForTool.class;
    }
    for (;;)
    {
      i = j;
      if (localObject == null) {
        break;
      }
      if (jdField_a_of_type_JavaUtilSet.contains(paramGdtInterstitialParams.a()))
      {
        i = 2;
        break;
        if (paramGdtInterstitialParams.jdField_a_of_type_Int == 0)
        {
          localObject = PublicTransFragmentActivityLandscapeForTool.class;
          continue;
        }
        if (paramGdtInterstitialParams.jdField_a_of_type_Int != 8) {
          break label262;
        }
        localObject = PublicTransFragmentActivityReverseLandscapeForTool.class;
        continue;
      }
      jdField_a_of_type_JavaUtilSet.add(paramGdtInterstitialParams.a());
      Bundle localBundle = new Bundle();
      if ((paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle != null) && (!paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle.isEmpty())) {
        localBundle.putAll(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle);
      }
      localBundle.putParcelable("interstitialParams", paramGdtInterstitialParams);
      localBundle.putLong("interstitialStartToShowTimeMillis", System.currentTimeMillis());
      localBundle.putString("interstitialProcessName", AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity));
      paramGdtInterstitialParams = new Intent();
      paramGdtInterstitialParams.putExtra("public_fragment_window_feature", 1);
      paramGdtInterstitialParams.putExtras(localBundle);
      adpn.a(paramActivity, paramGdtInterstitialParams, (Class)localObject, GdtInterstitialFragment.class, 10001);
      AdReporterForAnalysis.reportForStartActivity(paramActivity, null, "GdtInterstitialFragment");
      i = 0;
      break;
      label262:
      localObject = null;
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
    aase.b("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      if ((this.jdField_a_of_type_Bety == null) || (!this.jdField_a_of_type_Bety.isShowing())) {}
    }
    while ((paramBoolean) || (this.jdField_a_of_type_Bety == null))
    {
      return;
      this.jdField_a_of_type_Bety = new bety(getActivity(), getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bety.setCancelable(false);
      this.jdField_a_of_type_Bety.a(alud.a(2131705566) + "加载");
      this.jdField_a_of_type_Bety.show();
      return;
    }
    if (this.jdField_a_of_type_Bety.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bety.dismiss();
      this.jdField_a_of_type_Bety = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aase.d("GdtInterstitialFragment", "setLoading", localThrowable);
      }
    }
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
      aase.d("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int == 2)
    {
      aaor.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long == -2147483648L)
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long = System.currentTimeMillis();
        aasr.f(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      }
    }
    a(false);
    aase.b("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    aasr.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_f_of_type_Int = paramInt;
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
      aase.d("GdtInterstitialFragment", "onClick error");
      return bool1;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
        {
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
          localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(aaoq.a().a());
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
          localParams.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_JavaLangString;
          localParams.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle;
          bool1 = bool2;
          if (localParams.a())
          {
            GdtHandler.a(localParams);
            aasr.c(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
            bool1 = true;
          }
        }
      }
    }
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = false;
    }
    for (;;)
    {
      aase.b("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      return bool;
      a(false);
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Int = paramInt2;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_d_of_type_Int = paramInt3;
      this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Int = paramInt4;
      if (paramLong != -2147483648L) {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Long = paramLong;
      }
      if (getActivity() == null)
      {
        bool = false;
      }
      else
      {
        getActivity().finish();
        aasr.d(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
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
    aase.b("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    aasr.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void beforeFinish()
  {
    aase.b("GdtInterstitialFragment", "beforeFinish");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 4;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    if (this.jdField_a_of_type_Aaoy != null) {
      this.jdField_a_of_type_Aaoy.c(getActivity());
    }
    aaoq.a().a(a());
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
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    aase.b("GdtInterstitialFragment", "onActivityCreated");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 6;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    aase.b("GdtInterstitialFragment", "onAttach");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 7;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public boolean onBackEvent()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aase.b("GdtInterstitialFragment", "onCreate");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 8;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 1;
    paramLayoutInflater = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
    boolean bool;
    if (aaot.a().a() == 3)
    {
      bool = true;
      paramLayoutInflater.jdField_a_of_type_Boolean = bool;
      aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
    for (;;)
    {
      try
      {
        paramLayoutInflater = new FrameLayout(getActivity());
        i = 2;
      }
      catch (Throwable paramViewGroup)
      {
        try
        {
          if (!aaoq.a().a(a(), new WeakReference(this))) {}
          i = 18;
          if (getActivity() == null)
          {
            i = 18;
            j = 1;
            continue;
          }
          i = 19;
          getActivity().setRequestedOrientation(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Int);
          j = 20;
          i = j;
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_b_of_type_Int = aatp.b(getActivity());
          i = j;
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_c_of_type_Int = aatp.d(getActivity());
          j = 21;
          i = j;
          if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_b_of_type_Int <= 0) {
            break label744;
          }
          i = j;
          if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_c_of_type_Int <= 0)
          {
            i = 21;
            j = 1;
            continue;
          }
          i = 22;
          this.jdField_a_of_type_Aaoy = new aaoy(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
          i = 23;
          if (this.jdField_a_of_type_Aaoy.a() == null)
          {
            i = 23;
            j = 1;
            continue;
          }
          j = 24;
          i = j;
          paramViewGroup = new FrameLayout.LayoutParams(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_c_of_type_Int);
          i = j;
          paramViewGroup.gravity = 17;
          i = j;
          paramLayoutInflater.addView(this.jdField_a_of_type_Aaoy.a(), paramViewGroup);
          j = 25;
          i = j;
          if (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_Boolean)
          {
            i = j;
            getActivity().getWindow().addFlags(1024);
          }
          i = 26;
          j = 0;
        }
        catch (Throwable paramViewGroup)
        {
          j = 1;
          continue;
        }
        paramViewGroup = paramViewGroup;
        i = 1;
        paramLayoutInflater = null;
        j = 4;
        aase.d("GdtInterstitialFragment", "onCreateView", paramViewGroup);
        continue;
      }
      for (;;)
      {
        try
        {
          a(true);
          i = 3;
          AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialFragment.1(this), 0, aaoq.a().a(getActivity()));
          i = 4;
          aaom.a();
          i = 5;
          ArkAppNotifyCenter.setNotify(aaoq.a().a().jdField_a_of_type_JavaLangString, new WeakReference(aaoq.a().a()));
          i = 7;
          paramViewGroup = getArguments();
          if (paramViewGroup == null)
          {
            i = 7;
            j = 4;
          }
        }
        catch (Throwable paramViewGroup)
        {
          j = 4;
          break label714;
          break;
        }
        try
        {
          aase.b("GdtInterstitialFragment", String.format("onCreateView traceId:%s", new Object[] { a() }));
          AdThreadManager.INSTANCE.post(new GdtInterstitialFragment.2(this, j, i), 5);
          return paramLayoutInflater;
        }
        catch (Throwable paramViewGroup)
        {
          break label714;
          i = 21;
          j = 1;
        }
      }
      bool = false;
      break;
      i = 8;
      if (!getArguments().containsKey("interstitialParams"))
      {
        i = 8;
        j = 4;
      }
      else
      {
        i = 9;
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams = ((GdtInterstitialParams)getArguments().getParcelable("interstitialParams"));
        i = 10;
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams == null)
        {
          i = 10;
          j = 4;
        }
        else
        {
          i = 11;
          if (!this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
          {
            i = 11;
            j = 4;
          }
          else
          {
            i = 12;
            if (TextUtils.isEmpty(a()))
            {
              i = 12;
              j = 4;
            }
            else
            {
              i = 13;
              if (!getArguments().containsKey("interstitialStartToShowTimeMillis"))
              {
                i = 13;
                j = 4;
              }
              else
              {
                i = 14;
                this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_b_of_type_Long = getArguments().getLong("interstitialStartToShowTimeMillis");
                i = 15;
                if (getArguments().containsKey("interstitialProcessName")) {
                  continue;
                }
                i = 15;
                j = 4;
              }
            }
          }
        }
      }
    }
    i = 16;
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_JavaLangString = getArguments().getString("interstitialProcessName");
    i = 17;
  }
  
  public void onDestroy()
  {
    aase.b("GdtInterstitialFragment", "onDestroy");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 12;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    aase.b("GdtInterstitialFragment", "onDestroyView");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 11;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    aase.b("GdtInterstitialFragment", "onDetach");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 13;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onDetach();
  }
  
  public void onFinish()
  {
    aase.b("GdtInterstitialFragment", "onFinish");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 5;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    aase.b("GdtInterstitialFragment", "onPause");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 3;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    if (this.jdField_a_of_type_Aaoy != null) {
      this.jdField_a_of_type_Aaoy.a(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      aaor.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_d_of_type_Long == -2147483648L)
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_d_of_type_Long = System.currentTimeMillis();
        aasr.f(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    aase.b("GdtInterstitialFragment", "onResume");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 2;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    if (this.jdField_a_of_type_Aaoy != null) {
      this.jdField_a_of_type_Aaoy.b(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      a(false);
      aaor.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long == -2147483648L)
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long = System.currentTimeMillis();
        aasr.f(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    aase.b("GdtInterstitialFragment", "onStart");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 9;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void onStop()
  {
    aase.b("GdtInterstitialFragment", "onStop");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 10;
    aasr.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */