package com.tencent.biz.pubaccount.readinjoy.ugc;

import ajya;
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
import bbbm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import osg;
import osj;
import osm;
import qfn;
import qfp;
import qfr;

public class ReadInJoyPrivacyListFragment
  extends IphoneTitleBarFragment
  implements qfr
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ReadInJoyPrivacyListView jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private osm jdField_a_of_type_Osm = new qfp(this);
  private qfn jdField_a_of_type_Qfn;
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if ((localFragmentActivity.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.a(localFragmentActivity.getWindow(), localFragmentActivity.isClearCoverLayer);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(localFragmentActivity.app)) {
        break label166;
      }
      if ((bbbm.b()) || (bbbm.d())) {
        break label146;
      }
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848498);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bbbm.b()) && (!bbbm.d()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bbbm.d())
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
    osg.a().a(this.jdField_a_of_type_Long, this.b, 30);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView = ((ReadInJoyPrivacyListView)this.mContentView.findViewById(2131369318));
    this.jdField_a_of_type_Qfn = new qfn(getActivity(), this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView.setAdapter(this.jdField_a_of_type_Qfn);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyPrivacyListView.setLoadMoreCallback(this);
    setTitle(ajya.a(2131712835));
    if (this.leftView != null) {
      this.leftView.setText(ajya.a(2131712919));
    }
    a();
    osj.a().a(this.jdField_a_of_type_Osm);
  }
  
  public int getContentLayoutId()
  {
    return 2131559991;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Long = getActivity().getIntent().getLongExtra("feeds_id", 0L);
    osg.a().a(this.jdField_a_of_type_Long, this.b, 30);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    osj.a().b(this.jdField_a_of_type_Osm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyPrivacyListFragment
 * JD-Core Version:    0.7.0.1
 */