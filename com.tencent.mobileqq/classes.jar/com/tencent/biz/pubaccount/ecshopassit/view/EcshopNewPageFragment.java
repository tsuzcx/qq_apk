package com.tencent.biz.pubaccount.ecshopassit.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import axmv;
import bbkk;
import bcbu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import nrh;
import nrs;
import nrv;
import nrw;
import nrx;
import onh;

public class EcshopNewPageFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private EcshopWebview jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview;
  private String jdField_a_of_type_JavaLangString;
  private nrx jdField_a_of_type_Nrx;
  
  private void a()
  {
    this.jdField_a_of_type_Nrx = new nrv(this, getActivity(), getActivity(), nrh.a(), this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    this.jdField_a_of_type_Nrx.setmTimeBeforeLoadUrl(System.currentTimeMillis());
    new bcbu(this.jdField_a_of_type_Nrx).a(null, nrh.a(), null);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = ((EcshopWebview)this.jdField_a_of_type_Nrx.getWebView());
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setWillNotCacheDrawing(false);
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.setDrawingCacheEnabled(true);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, SystemBarCompact paramSystemBarCompact)
  {
    if ((paramActivity == null) || (paramSystemBarCompact == null)) {}
    while (!ThemeUtil.isNowThemeIsNight(onh.a(), false, null)) {
      return;
    }
    if ((paramBoolean) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      paramActivity.getWindow().addFlags(67108864);
      paramSystemBarCompact.init();
    }
    paramSystemBarCompact.setStatusBarColor(-1);
  }
  
  private void a(View paramView)
  {
    paramView = (CustomTabView)paramView.findViewById(2131364873);
    paramView.a(nrs.a());
    paramView.a(this.jdField_a_of_type_Int);
  }
  
  private void b(View paramView)
  {
    paramView = (NavBarCommon)paramView.findViewById(2131375329);
    paramView.setTitle(getResources().getString(2131691960));
    Object localObject = (ImageView)paramView.findViewById(2131368742);
    paramView.setRightImage(getResources().getDrawable(2130849073));
    ((ImageView)localObject).setImageResource(2130849548);
    paramView.setOnItemSelectListener(new nrw(this));
    if (axmv.a()) {
      paramView.a(true);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview = EcshopWebview.a(this.jdField_a_of_type_AndroidViewView.getContext());
    localObject = (FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364697);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent() instanceof ViewGroup)) {
      ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.getParent()).removeView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    }
    ((FrameLayout)localObject).addView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview);
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      this.jdField_a_of_type_AndroidViewView.findViewById(2131370840).setVisibility(0);
      paramView.setBackgroundColor(-16777216);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370840).setVisibility(8);
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
    this.jdField_a_of_type_Int = getArguments().getInt("tab_id");
    this.jdField_a_of_type_JavaLangString = getArguments().getString("jump_url");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageFragment", 2, "[onCreateView]");
    }
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131561491, paramViewGroup, false);
    b(this.jdField_a_of_type_AndroidViewView);
    a();
    a(this.jdField_a_of_type_AndroidViewView);
    try
    {
      getActivity().getIntent().getStringExtra("url");
      label62:
      if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview != null) && (!bbkk.a(this.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewEcshopWebview.loadUrl(this.jdField_a_of_type_JavaLangString);
      }
      return this.jdField_a_of_type_AndroidViewView;
    }
    catch (Exception paramLayoutInflater)
    {
      break label62;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageFragment", 2, "[onDestroy]");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Nrx != null) {
      this.jdField_a_of_type_Nrx.c();
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageFragment", 2, "[onPause]");
    }
    super.onPause();
    if (this.jdField_a_of_type_Nrx != null) {
      this.jdField_a_of_type_Nrx.b();
    }
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop", 2, "report stay page time tabid is" + this.jdField_a_of_type_Int);
    }
    nrh.a(null, "gouwu.aio.stay", this.jdField_a_of_type_Int + "", NetConnInfoCenter.getServerTimeMillis() + "", NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_Long + "");
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EcshopNewPageFragment", 2, "[onResume]");
    }
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    super.onResume();
    if (this.jdField_a_of_type_Nrx != null) {
      this.jdField_a_of_type_Nrx.a();
    }
    a(getActivity(), true, onh.a(getActivity()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment
 * JD-Core Version:    0.7.0.1
 */