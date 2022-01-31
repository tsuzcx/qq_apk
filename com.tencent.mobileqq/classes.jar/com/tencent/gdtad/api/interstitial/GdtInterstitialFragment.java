package com.tencent.gdtad.api.interstitial;

import aajt;
import aajx;
import aakb;
import aakc;
import aake;
import aakj;
import aanp;
import aaoc;
import aapa;
import adky;
import alpo;
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
import bepp;
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
  private aakj jdField_a_of_type_Aakj;
  private bepp jdField_a_of_type_Bepp;
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
          aanp.b("GdtInterstitialFragment", String.format("start errorCode:%d", new Object[] { Integer.valueOf(i) }));
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
      adky.a(paramActivity, paramGdtInterstitialParams, (Class)localObject, GdtInterstitialFragment.class, 10001);
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
    aanp.b("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    if (paramBoolean) {
      if ((this.jdField_a_of_type_Bepp == null) || (!this.jdField_a_of_type_Bepp.isShowing())) {}
    }
    while ((paramBoolean) || (this.jdField_a_of_type_Bepp == null))
    {
      return;
      this.jdField_a_of_type_Bepp = new bepp(getActivity(), getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bepp.setCancelable(false);
      this.jdField_a_of_type_Bepp.a(alpo.a(2131705554) + "加载");
      this.jdField_a_of_type_Bepp.show();
      return;
    }
    if (this.jdField_a_of_type_Bepp.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Bepp.dismiss();
      this.jdField_a_of_type_Bepp = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        aanp.d("GdtInterstitialFragment", "setLoading", localThrowable);
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
      aanp.d("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int == 2)
    {
      aakc.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long == -2147483648L)
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long = System.currentTimeMillis();
        aaoc.f(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      }
    }
    a(false);
    aanp.b("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    aaoc.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
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
      aanp.d("GdtInterstitialFragment", "onClick error");
      return bool1;
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.b())
        {
          GdtHandler.Params localParams = new GdtHandler.Params();
          localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
          localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(aakb.a().a());
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
            aaoc.c(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
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
      aanp.b("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
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
        aaoc.d(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
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
    aanp.b("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    aaoc.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void beforeFinish()
  {
    aanp.b("GdtInterstitialFragment", "beforeFinish");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 4;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    if (this.jdField_a_of_type_Aakj != null) {
      this.jdField_a_of_type_Aakj.c(getActivity());
    }
    aakb.a().a(a());
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
    aanp.b("GdtInterstitialFragment", "onActivityCreated");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 6;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    aanp.b("GdtInterstitialFragment", "onAttach");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 7;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public boolean onBackEvent()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aanp.b("GdtInterstitialFragment", "onCreate");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 8;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 1;
    paramLayoutInflater = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
    boolean bool;
    if (aake.a().a() == 3)
    {
      bool = true;
      paramLayoutInflater.jdField_a_of_type_Boolean = bool;
      aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
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
          if (!aakb.a().a(a(), new WeakReference(this))) {}
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
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_b_of_type_Int = aapa.b(getActivity());
          i = j;
          this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_c_of_type_Int = aapa.d(getActivity());
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
          this.jdField_a_of_type_Aakj = new aakj(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
          i = 23;
          if (this.jdField_a_of_type_Aakj.a() == null)
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
          paramLayoutInflater.addView(this.jdField_a_of_type_Aakj.a(), paramViewGroup);
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
        aanp.d("GdtInterstitialFragment", "onCreateView", paramViewGroup);
        continue;
      }
      for (;;)
      {
        try
        {
          a(true);
          i = 3;
          AdThreadManager.INSTANCE.postDelayed(new GdtInterstitialFragment.1(this), 0, aakb.a().a(getActivity()));
          i = 4;
          aajx.a();
          i = 5;
          ArkAppNotifyCenter.setNotify(aakb.a().a().jdField_a_of_type_JavaLangString, new WeakReference(aakb.a().a()));
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
          aanp.b("GdtInterstitialFragment", String.format("onCreateView traceId:%s", new Object[] { a() }));
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
    aanp.b("GdtInterstitialFragment", "onDestroy");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 12;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    aanp.b("GdtInterstitialFragment", "onDestroyView");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 11;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onDestroyView();
  }
  
  public void onDetach()
  {
    aanp.b("GdtInterstitialFragment", "onDetach");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 13;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onDetach();
  }
  
  public void onFinish()
  {
    aanp.b("GdtInterstitialFragment", "onFinish");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 5;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    aanp.b("GdtInterstitialFragment", "onPause");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 3;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    if (this.jdField_a_of_type_Aakj != null) {
      this.jdField_a_of_type_Aakj.a(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      aakc.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_d_of_type_Long == -2147483648L)
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_d_of_type_Long = System.currentTimeMillis();
        aaoc.f(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      }
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    aanp.b("GdtInterstitialFragment", "onResume");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 2;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    if (this.jdField_a_of_type_Aakj != null) {
      this.jdField_a_of_type_Aakj.b(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      a(false);
      aakc.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long == -2147483648L)
      {
        this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_c_of_type_Long = System.currentTimeMillis();
        aaoc.f(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    aanp.b("GdtInterstitialFragment", "onStart");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 9;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void onStop()
  {
    aanp.b("GdtInterstitialFragment", "onStop");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 10;
    aaoc.e(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    super.onStop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */