package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashSet;
import odt;
import odx;
import oem;
import oen;
import oet;
import oev;
import oez;
import ofa;
import ofb;
import ofc;
import ofe;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;

public class EcshopNewPageFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ofb(this);
  private SparseArray<EcshopTabFragment> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private CustomTabView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
  private EcshopTabFragment jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public boolean a;
  private boolean b;
  private boolean c;
  private boolean d;
  
  private void a()
  {
    Object localObject = oet.a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a((ArrayList)localObject);
      }
      return;
    }
    localObject = new qq_ad.QQAdGet();
    if (this.b) {
      ((qq_ad.QQAdGet)localObject).trigger_type.set(12);
    }
    for (;;)
    {
      odt.a(((qq_ad.QQAdGet)localObject).toByteArray(), "SQQShopAdSdkSvr.getAd", new oez(this));
      return;
      ((qq_ad.QQAdGet)localObject).trigger_type.set(8);
    }
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("tab_id", 1);
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("jump_url");
      this.b = paramIntent.getBooleanExtra("req_qgg_title", true);
    }
    for (this.d = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);; this.d = getArguments().getBoolean("req_qgg_hide_tab", false))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopNewPageFragment", 2, this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(this.jdField_a_of_type_Int);
      }
      EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
      paramIntent = localEcshopTabFragment;
      if (localEcshopTabFragment == null)
      {
        paramIntent = new EcshopTabFragment();
        this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Int, paramIntent);
      }
      paramIntent.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      paramIntent = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
      if (paramIntent != null) {
        a(paramIntent);
      }
      return;
      this.jdField_a_of_type_Int = getArguments().getInt("tab_id");
      this.jdField_a_of_type_JavaLangString = getArguments().getString("jump_url", "");
      this.b = getArguments().getBoolean("req_qgg_title", true);
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView = ((CustomTabView)paramView.findViewById(2131365196));
    if (oen.a(oem.a(), 0, this.jdField_a_of_type_Int))
    {
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
      if (this.d) {}
      for (int i = 8;; i = 0)
      {
        paramView.setVisibility(i);
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(oem.a());
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(this.jdField_a_of_type_Int);
        return;
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.setVisibility(8);
  }
  
  private void a(EcshopTabFragment paramEcshopTabFragment)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment == null) {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.add(2131365005, paramEcshopTabFragment).commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment = paramEcshopTabFragment;
      return;
      localFragmentTransaction.show(paramEcshopTabFragment).commitAllowingStateLoss();
      continue;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment.a(paramEcshopTabFragment)) {
        if (!paramEcshopTabFragment.isAdded()) {
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).add(2131365005, paramEcshopTabFragment).commitAllowingStateLoss();
        } else {
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).show(paramEcshopTabFragment).commitAllowingStateLoss();
        }
      }
    }
  }
  
  private void a(ArrayList<odx> paramArrayList)
  {
    oet.a(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, "[onResponseRedpoint]");
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(paramArrayList);
    }
  }
  
  private void b()
  {
    this.vg.setTitle(getResources().getString(2131691674));
    this.vg.setRightImage(getResources().getDrawable(2130850128));
    ((ImageView)this.vg.findViewById(2131369362)).setImageResource(2130850653);
    this.vg.setOnItemSelectListener(new ofa(this));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      ImmersiveUtils.a(true, getActivity().getWindow());
      this.mContentView.findViewById(2131371728).setVisibility(0);
      this.vg.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      a(this.mContentView);
      return;
      this.mContentView.findViewById(2131371728).setVisibility(8);
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561935;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    b();
    a();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, "[onCreate]");
    }
    super.onCreate(paramBundle);
    try
    {
      if ((!this.c) && (getActivity() != null))
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.biz.pubaccount.ecshop.tabpage.finish");
        paramBundle.addAction("action_notify_view_update");
        getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        this.c = true;
      }
      a(null);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("Ecshop_EcshopNewPageFragment", 1, "[onCreate] regist exitreceiver fail " + paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("Ecshop_EcshopNewPageFragment", 2, "[onDestroy]");
    super.onDestroy();
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
          localEcshopTabFragment.a.c();
        }
        i += 1;
      }
    }
    if ((this.jdField_a_of_type_AndroidUtilSparseArray != null) && (this.jdField_a_of_type_AndroidUtilSparseArray.size() > 0)) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    ofe.a().a(null, "");
    try
    {
      if ((this.c) && (getActivity() != null))
      {
        getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.c = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, " EcshopNewPageFragment [onPause] mCurrentTabId: " + this.jdField_a_of_type_Int + "isJumpToThirdPage: " + this.jdField_a_of_type_Boolean);
    }
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
      localEcshopTabFragment.a.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    oev.a(null, "gouwu.aio.stay", this.jdField_a_of_type_Int + "", SystemClock.elapsedRealtime() + "", SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long + "");
    oev.b(null, "gouwu_aio_stay", this.jdField_a_of_type_Int + "", SystemClock.elapsedRealtime() + "", SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long + "");
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("Ecshop_EcshopNewPageFragment", 2, " EcshopNewPageFragment [onResume] mCurrentTabId: " + this.jdField_a_of_type_Int);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    }
    this.jdField_a_of_type_Boolean = false;
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
      localEcshopTabFragment.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment
 * JD-Core Version:    0.7.0.1
 */