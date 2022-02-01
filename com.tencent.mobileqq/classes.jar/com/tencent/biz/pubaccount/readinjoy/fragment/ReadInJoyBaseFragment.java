package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.RIJChannelStayTimeMonitor;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.RIJXTabConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.MessageObserver;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.video.VideoAutoPlayController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.CallHotwordChange;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;

public abstract class ReadInJoyBaseFragment
  extends PublicBaseFragment
  implements KandianMergeManager.MessageObserver
{
  public static final HashMap<Integer, Integer> a;
  private int jdField_a_of_type_Int = -1;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected LayoutInflater a;
  protected ReadInJoyBaseFragment.OnNofityVisibleCallback a;
  ReadinjoyTabFrame.CallHotwordChange jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange;
  public boolean c = false;
  int d;
  protected boolean d;
  protected boolean e = false;
  public boolean f = false;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ReadInJoyBaseFragment()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static int a(int paramInt)
  {
    Integer localInteger = (Integer)jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if (localInteger != null) {
      return localInteger.intValue();
    }
    return 0;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void c(MessageRecord paramMessageRecord)
  {
    if ((ReadInJoyHelper.n()) && ((getActivity() instanceof SplashActivity))) {
      return;
    }
    d(paramMessageRecord);
    a().a(paramMessageRecord);
    a().l();
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if ((ReadInJoyHelper.o()) && ((this instanceof ReadInJoyRecommendFeedsFragment))) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyBaseFragment.1(this, paramMessageRecord));
    }
  }
  
  private int e()
  {
    try
    {
      Resources localResources = getActivity().getResources();
      i = localResources.getDimensionPixelSize(2131299166);
      j = localResources.getDimensionPixelSize(2131298859);
      int k = localResources.getDimensionPixelSize(2131298861);
      int m = ImmersiveUtils.getStatusBarHeight(getActivity());
      i = k + (i + j) + m;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        localException.printStackTrace();
        int i = 0;
      }
    }
    j = i;
    if (i <= 0) {
      j = ViewUtils.b(80.5F) + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    return j;
  }
  
  private int f()
  {
    return this.jdField_a_of_type_AndroidOsBundle.getInt("channel_padding_top", e());
  }
  
  private void h()
  {
    boolean bool2 = false;
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("is_xtab_mode", false)) {
        bool1 = true;
      }
    }
    this.f = bool1;
  }
  
  private void m()
  {
    View localView = getView();
    if (localView != null) {
      if (!a()) {
        break label55;
      }
    }
    label55:
    for (int i = b();; i = 0)
    {
      if (b()) {}
      for (int j = c();; j = 0)
      {
        if ((i > 0) || (j > 0)) {
          localView.setPadding(0, i, 0, j);
        }
        return;
      }
    }
  }
  
  public abstract int a();
  
  protected KandianMergeManager a()
  {
    return (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(ReadInJoyBaseFragment.OnNofityVisibleCallback paramOnNofityVisibleCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$OnNofityVisibleCallback = paramOnNofityVisibleCallback;
  }
  
  public void a(ReadinjoyTabFrame.CallHotwordChange paramCallHotwordChange, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadinjoyTabFrame$CallHotwordChange = paramCallHotwordChange;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    c(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    c(paramMessageRecord);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyShowSelf");
    if (a() != null) {
      a().a(this);
    }
    VideoAutoPlayController.a().a(a());
    int i;
    if (this.e)
    {
      i = a();
      if (i != -1)
      {
        RIJChannelStayTimeMonitor.a.a(i);
        paramActivity = ReadInJoyChannelViewPagerController.a(i);
        if (paramActivity == null) {
          break label238;
        }
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramActivity);
        if ((RIJXTabConfigHandler.b().a()) && (paramActivity.intValue() == 0)) {
          RIJChannelReporter.a(i, "306");
        }
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "notifyShowSelf, channelID = ", Integer.valueOf(i), ", entryPath = ", Integer.valueOf(a(i)) });
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$OnNofityVisibleCallback != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$OnNofityVisibleCallback.a_(true);
      }
      SuperMaskUIMgr.a.b(a());
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "setSuperMaskChannelId " + a() + " notifyShowSelf ");
      return;
      label238:
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(2));
      RIJChannelReporter.a(i, "301");
    }
  }
  
  protected boolean a()
  {
    return (this.e) && (((this instanceof ReadInJoyViolaChannelFragment)) || ((this instanceof ReadInJoyBBCircleFragment)) || ((this instanceof ReadInJoyFragmentWithSubChannel)) || ((this instanceof ReadinjoyAdHippyFragment)) || (this.f));
  }
  
  public int b()
  {
    if (this.f) {
      return f();
    }
    return e();
  }
  
  public String b()
  {
    return "0";
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    ReadInJoyLogicEngine.a().g();
    c(paramMessageRecord);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  protected boolean b()
  {
    return (this.e) && (((this instanceof ReadInJoyViolaChannelFragment)) || ((this instanceof ReadInJoyFragmentWithSubChannel)) || ((this instanceof ReadInJoySubChannelFragment)) || ((this instanceof ReadinjoyAdHippyFragment)));
  }
  
  public int c()
  {
    try
    {
      int i = getActivity().getResources().getDimensionPixelSize(2131297347);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean c()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public void e() {}
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public void g()
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyHideSelf");
    if (a() != null) {
      a().b(this);
    }
    if (this.e)
    {
      int i = a();
      if ((i != -1) && (RIJChannelStayTimeMonitor.a.a(i))) {
        i();
      }
      if (i != -1) {
        RIJChannelStayTimeMonitor.a.a(i, this.jdField_a_of_type_Int, b());
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$OnNofityVisibleCallback != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment$OnNofityVisibleCallback.a_(false);
    }
  }
  
  public void i() {}
  
  public void j()
  {
    getActivity().finish();
  }
  
  public void k() {}
  
  public void l() {}
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (a() != null) {
        a().b(this);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    m();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, isVisibleToUser = ", Boolean.valueOf(paramBoolean), ", mIsShowingSelf = ", Boolean.valueOf(this.jdField_d_of_type_Boolean) });
    this.jdField_d_of_type_Boolean = paramBoolean;
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, mChannelID = ", Integer.valueOf(a()) });
    if (paramBoolean)
    {
      a(false, getActivity(), null);
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment
 * JD-Core Version:    0.7.0.1
 */