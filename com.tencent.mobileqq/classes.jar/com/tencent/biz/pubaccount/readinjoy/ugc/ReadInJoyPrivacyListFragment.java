package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;

public class ReadInJoyPrivacyListFragment
  extends IphoneTitleBarFragment
  implements ReadInJoyPrivacyListView.LoadMoreCallback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new ReadInJoyPrivacyListFragment.1(this);
  private ReadInJoyPrivacyListAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListAdapter = null;
  private ReadInJoyPrivacyListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView = null;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 0;
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if ((localFragmentActivity.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(localFragmentActivity.getWindow(), localFragmentActivity.isClearCoverLayer);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(localFragmentActivity.app)) {
        break label166;
      }
      if ((SystemUtil.b()) || (SystemUtil.d())) {
        break label146;
      }
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849916);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label146:
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
      localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label166:
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!SystemUtil.d())
      {
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
        localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void b()
  {
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Long, this.b, 30);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView = ((ReadInJoyPrivacyListView)this.mContentView.findViewById(2131370504));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListAdapter = new ReadInJoyPrivacyListAdapter(getActivity(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView.setLoadMoreCallback(this);
    setTitle(HardCodeUtil.a(2131712798));
    if (this.leftView != null) {
      this.leftView.setText(HardCodeUtil.a(2131712879));
    }
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public int getContentLayoutId()
  {
    return 2131560369;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("feeds_id", 0L);
    ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_Long, this.b, 30);
    RIJDtReportHelper.a.a(getActivity());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment
 * JD-Core Version:    0.7.0.1
 */