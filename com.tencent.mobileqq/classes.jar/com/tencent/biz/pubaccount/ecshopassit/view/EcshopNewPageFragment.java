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
import com.tencent.biz.pubaccount.ecshopassit.ABTestInfo;
import com.tencent.biz.pubaccount.ecshopassit.EcshopNewServlet;
import com.tencent.biz.pubaccount.ecshopassit.RedPointInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ABTestUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ReportUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.HashSet;
import tencent.im.oidb.qqshop.qq_ad.QQAdGet;

public class EcshopNewPageFragment
  extends IphoneTitleBarFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new EcshopNewPageFragment.4(this);
  private SparseArray<EcshopTabFragment> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ABTestInfo jdField_a_of_type_ComTencentBizPubaccountEcshopassitABTestInfo;
  private CustomTabView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
  private CustomTitleView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView;
  private EcshopTabFragment jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment;
  private String jdField_a_of_type_JavaLangString;
  private HashSet<Integer> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  public boolean a;
  private String jdField_b_of_type_JavaLangString = "bottom";
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  private boolean d = false;
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("tab_id", 1);
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("jump_url");
      this.jdField_b_of_type_Boolean = paramIntent.getBooleanExtra("req_qgg_title", true);
      this.d = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
      if (QLog.isColorLevel()) {
        QLog.i("Ecshop_EcshopNewPageFragment", 2, this.jdField_a_of_type_JavaLangString);
      }
      if (!"top".equals(this.jdField_b_of_type_JavaLangString)) {
        break label230;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
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
      this.jdField_b_of_type_Boolean = getArguments().getBoolean("req_qgg_title", true);
      this.d = getArguments().getBoolean("req_qgg_hide_tab", false);
      break;
      label230:
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(this.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a(View paramView)
  {
    int i = 8;
    int j = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView = ((CustomTitleView)paramView.findViewById(2131365508));
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView = ((CustomTabView)paramView.findViewById(2131365507));
    if (EcshopConfUtil.a(EcshopConfProcessor.a(), 0, this.jdField_a_of_type_Int))
    {
      if (!"top".equals(this.jdField_b_of_type_JavaLangString)) {
        break label138;
      }
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView;
      if (!this.d) {
        break label127;
      }
      i = 8;
      paramView.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(EcshopConfProcessor.a(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(this.jdField_a_of_type_Int);
      paramView = this.vg;
      if (!this.d) {
        break label132;
      }
    }
    label132:
    for (i = j;; i = 8)
    {
      paramView.setVisibility(i);
      b();
      return;
      label127:
      i = 0;
      break;
    }
    label138:
    paramView = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
    if (this.d) {}
    for (;;)
    {
      paramView.setVisibility(i);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(EcshopConfProcessor.a(), this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(this.jdField_a_of_type_Int);
      return;
      i = 0;
    }
  }
  
  private void a(EcshopTabFragment paramEcshopTabFragment)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment == null) {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.add(2131365300, paramEcshopTabFragment).commitAllowingStateLoss();
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
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).add(2131365300, paramEcshopTabFragment).commitAllowingStateLoss();
        } else {
          localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopTabFragment).show(paramEcshopTabFragment).commitAllowingStateLoss();
        }
      }
    }
  }
  
  private void a(ArrayList<RedPointInfo> paramArrayList)
  {
    RedPointUtil.a(paramArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, "[onResponseRedpoint]");
    }
    if ("top".equals(this.jdField_b_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(paramArrayList);
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(paramArrayList);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitABTestInfo == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitABTestInfo = ABTestUtil.a("exp_qqshop_tabbar");
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitABTestInfo != null) {
        this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitABTestInfo.a("tab_show", "bottom");
      }
    }
  }
  
  private void d()
  {
    Object localObject = RedPointUtil.a();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      if ("top".equals(this.jdField_b_of_type_JavaLangString)) {
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView != null) {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a((ArrayList)localObject);
        }
      }
      while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView == null) {
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a((ArrayList)localObject);
      return;
    }
    localObject = new qq_ad.QQAdGet();
    if (this.jdField_b_of_type_Boolean) {
      ((qq_ad.QQAdGet)localObject).trigger_type.set(12);
    }
    for (;;)
    {
      EcshopNewServlet.a(((qq_ad.QQAdGet)localObject).toByteArray(), "trpc.qqshop.adpush.PushService.GetAd", new EcshopNewPageFragment.1(this));
      return;
      ((qq_ad.QQAdGet)localObject).trigger_type.set(8);
    }
  }
  
  private void e()
  {
    this.vg.setTitle(getResources().getString(2131691928));
    this.vg.setRightImage(getResources().getDrawable(2130850548));
    ((ImageView)this.vg.findViewById(2131369878)).setImageResource(2130851151);
    this.vg.setOnItemSelectListener(new EcshopNewPageFragment.2(this));
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
      this.mContentView.findViewById(2131372298).setVisibility(0);
      this.vg.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      a(this.mContentView);
      return;
      this.mContentView.findViewById(2131372298).setVisibility(8);
      a();
    }
  }
  
  public void a()
  {
    if (("top".equals(this.jdField_b_of_type_JavaLangString)) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      if (getActivity().mSystemBarComp != null) {
        break label50;
      }
      getActivity().setImmersiveStatus(-1);
    }
    for (;;)
    {
      ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
      return;
      label50:
      getActivity().mSystemBarComp.setStatusBarColor(-1);
      getActivity().mSystemBarComp.setStatusColor(-1);
    }
  }
  
  public void b()
  {
    EcshopNewPageFragment.3 local3 = new EcshopNewPageFragment.3(this);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.findViewById(2131369878).setOnClickListener(local3);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.findViewById(2131369501).setOnClickListener(local3);
  }
  
  public int getContentLayoutId()
  {
    return 2131562057;
  }
  
  public void init(Bundle paramBundle)
  {
    super.init(paramBundle);
    c();
    e();
    d();
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
    c();
    return !"top".equals(this.jdField_b_of_type_JavaLangString);
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
    EcshopWebviewPool.a().a(null, "");
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
    if ("top".equals(this.jdField_b_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a();
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a();
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
    ReportUtil.a(null, "gouwu.aio.stay", this.jdField_a_of_type_Int + "", SystemClock.elapsedRealtime() + "", SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long + "");
    ReportUtil.b(null, "gouwu_aio_stay", this.jdField_a_of_type_Int + "", SystemClock.elapsedRealtime() + "", SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long + "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment
 * JD-Core Version:    0.7.0.1
 */