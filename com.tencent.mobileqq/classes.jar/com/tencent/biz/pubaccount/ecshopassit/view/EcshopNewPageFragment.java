package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;
import nur;
import nvc;
import nvd;
import nvg;
import nvh;
import nvi;
import nvk;

public class EcshopNewPageFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new nvh(this);
  private SparseArray<EcshopTabFragment> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private CustomTabView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
  private EcshopTabFragment jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  private void a()
  {
    this.vg.setTitle(getResources().getString(2131692016));
    this.vg.setRightImage(getResources().getDrawable(2130849577));
    ((ImageView)this.vg.findViewById(2131368979)).setImageResource(2130850061);
    this.vg.setOnItemSelectListener(new nvg(this));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      ImmersiveUtils.a(true, getActivity().getWindow());
      this.mContentView.findViewById(2131371169).setVisibility(0);
      this.vg.setBackgroundColor(-16777216);
      return;
    }
    this.mContentView.findViewById(2131371169).setVisibility(8);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null) {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("tab_id", 1);
    }
    for (this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("jump_url");; this.jdField_a_of_type_JavaLangString = getArguments().getString("jump_url", ""))
    {
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
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView = ((CustomTabView)paramView.findViewById(2131364962));
    if (nvd.a(nvc.a(), 0, this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(nvc.a());
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.setVisibility(8);
  }
  
  private void a(EcshopTabFragment paramEcshopTabFragment)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment == null) {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.add(2131364777, paramEcshopTabFragment).commitAllowingStateLoss();
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
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).add(2131364777, paramEcshopTabFragment).commitAllowingStateLoss();
        } else {
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).show(paramEcshopTabFragment).commitAllowingStateLoss();
        }
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131561699;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    a();
    a(this.mContentView);
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
      QLog.i("EcshopNewPageFragment", 2, "[onCreate]");
    }
    super.onCreate(paramBundle);
    try
    {
      if ((!this.jdField_a_of_type_Boolean) && (getActivity() != null))
      {
        getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, new IntentFilter("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
        this.jdField_a_of_type_Boolean = true;
      }
      a(null);
      return;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        QLog.e("EcshopNewPageFragment", 1, "[onCreate] regist exitreceiver fail " + paramBundle);
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("EcshopNewPageFragment", 2, "[onDestroy]");
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
    nvk.a().a(null, "");
    try
    {
      if ((this.jdField_a_of_type_Boolean) && (getActivity() != null))
      {
        getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    QLog.i("parsons", 2, " EcshopNewPageFragment [onPause] mCurrentTabId: " + this.jdField_a_of_type_Int);
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if ((localEcshopTabFragment != null) && (localEcshopTabFragment.a != null)) {
      localEcshopTabFragment.a.b();
    }
    nur.a(null, "gouwu.aio.stay", this.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long + "");
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.i("EcshopNewPageFragment", 2, " EcshopNewPageFragment [onResume] mCurrentTabId: " + this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
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