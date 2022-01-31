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
import bdoo;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.Constants.LogoutReason;
import mqq.os.MqqHandler;
import nwm;
import org.json.JSONException;
import ors;
import orz;
import owq;
import owy;
import oxb;
import oyy;
import rxg;

public abstract class ReadInJoyBaseFragment
  extends PublicBaseFragment
  implements owq
{
  public static final HashMap<Integer, Integer> a;
  private int jdField_a_of_type_Int = -1;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  protected KandianMergeManager a;
  protected QQAppInterface a;
  protected oyy a;
  rxg jdField_a_of_type_Rxg;
  protected boolean c;
  int d;
  protected boolean d;
  public final String f = "ReadInJoyBaseFragment";
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public ReadInJoyBaseFragment()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
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
    if ((bkbq.j()) && ((getActivity() instanceof SplashActivity))) {
      return;
    }
    d(paramMessageRecord);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
  }
  
  private void d(MessageRecord paramMessageRecord)
  {
    if ((bkbq.k()) && ((this instanceof ReadInJoyRecommendFeedsFragment))) {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyBaseFragment.1(this, paramMessageRecord));
    }
  }
  
  private void h()
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
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {}
  
  public void a(MessageRecord paramMessageRecord)
  {
    c(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    c(paramMessageRecord);
  }
  
  public void a(Constants.LogoutReason paramLogoutReason) {}
  
  public void a(oyy paramoyy)
  {
    this.jdField_a_of_type_Oyy = paramoyy;
  }
  
  public void a(rxg paramrxg, int paramInt)
  {
    this.jdField_a_of_type_Rxg = paramrxg;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    QLog.d(ReadInJoyBaseFragment.class.getSimpleName(), 2, getClass().getSimpleName() + " notifyShowSelf");
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    int i;
    if (this.jdField_d_of_type_Boolean)
    {
      i = a();
      if (i != -1)
      {
        nwm.d(i);
        paramActivity = nwm.a(i);
        if (paramActivity == null) {
          break label180;
        }
        jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), paramActivity);
      }
    }
    for (;;)
    {
      QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "notifyShowSelf, channelID = ", Integer.valueOf(i), ", entryPath = ", Integer.valueOf(a(i)) });
      if (this.jdField_a_of_type_Oyy != null) {
        this.jdField_a_of_type_Oyy.a(true);
      }
      return;
      label180:
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(i), Integer.valueOf(2));
      try
      {
        nwm.a("0X8009B94", "", new orz().a("source", "301").a(i).b("style", 0).a());
      }
      catch (JSONException paramActivity)
      {
        QLog.d("ReadInJoyBaseFragment", 2, "report click channel bar exception, e = ", paramActivity);
      }
    }
  }
  
  protected boolean a()
  {
    return (this.jdField_d_of_type_Boolean) && (((this instanceof ReadInJoyViolaChannelFragment)) || ((this instanceof ReadInJoyBBCircleFragment)) || ((this instanceof ReadInJoyFragmentWithSubChannel)));
  }
  
  public int b()
  {
    try
    {
      Resources localResources = getActivity().getResources();
      i = localResources.getDimensionPixelSize(2131298914);
      j = localResources.getDimensionPixelSize(2131298612);
      int k = localResources.getDimensionPixelSize(2131298614);
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
      j = bdoo.b(80.5F) + ImmersiveUtils.getStatusBarHeight(getActivity());
    }
    return j;
  }
  
  public String b()
  {
    return "0";
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    owy.a().g();
    c(paramMessageRecord);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  protected boolean b()
  {
    return (this.jdField_d_of_type_Boolean) && (((this instanceof ReadInJoyViolaChannelFragment)) || ((this instanceof ReadInJoyFragmentWithSubChannel)) || ((this instanceof ReadInJoySubChannelFragment)));
  }
  
  public int c()
  {
    try
    {
      int i = getActivity().getResources().getDimensionPixelSize(2131297190);
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
    return this.c;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    if (this.jdField_d_of_type_Boolean)
    {
      int i = a();
      if ((i != -1) && (nwm.b(i))) {
        i();
      }
      if (i != -1) {
        nwm.a(i, this.jdField_a_of_type_Int, b());
      }
    }
    if (this.jdField_a_of_type_Oyy != null) {
      this.jdField_a_of_type_Oyy.a(false);
    }
  }
  
  public void i() {}
  
  public void j()
  {
    getActivity().finish();
  }
  
  public void k() {}
  
  public boolean onBackEvent()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    oxb.a().a(paramConfiguration);
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    try
    {
      super.onDestroy();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
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
    h();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, isVisibleToUser = ", Boolean.valueOf(paramBoolean), ", mIsShowingSelf = ", Boolean.valueOf(this.c) });
    this.c = paramBoolean;
    QLog.d("ReadInJoyBaseFragment", 2, new Object[] { "setUserVisibleHint, mChannelID = ", Integer.valueOf(a()) });
    if (paramBoolean)
    {
      a(false, getActivity(), null);
      return;
    }
    g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment
 * JD-Core Version:    0.7.0.1
 */