package com.tencent.biz.pubaccount.readinjoy.activity;

import alud;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdep;
import bkbq;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;
import ors;
import owr;
import qzi;
import syp;

public class ReadInJoySelfActivity
  extends IphoneTitleBarActivity
  implements owr
{
  protected KandianMergeManager a;
  protected ReadInJoySelfFragment a;
  protected QQAppInterface a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  public ReadInJoySelfActivity()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void c()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    qzi.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localObject1 = qzi.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label198;
      }
    }
    label198:
    for (int i = 0;; i = 1)
    {
      ((qzi)localObject1).a((String)localObject2, i);
      this.b = bkbq.z(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      setContentView(2131558451);
      d();
      localObject1 = getIntent();
      if (localObject1 != null) {
        this.c = ((Intent)localObject1).getBooleanExtra("redTouch", false);
      }
      localObject1 = getSupportFragmentManager().beginTransaction();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment = new ReadInJoySelfFragment();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putInt("from_type", 1);
      ((Bundle)localObject2).putBoolean("show_type", this.b);
      ((Bundle)localObject2).putBoolean("redTouch", this.c);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment.setArguments((Bundle)localObject2);
      ((FragmentTransaction)localObject1).add(2131366790, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment);
      ((FragmentTransaction)localObject1).show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoySelfFragment);
      ((FragmentTransaction)localObject1).commit();
      return;
    }
  }
  
  private void d()
  {
    if (this.b)
    {
      hideTitleBar();
      setImmersiveStatus();
      this.titleRoot = ((RelativeLayout)findViewById(2131378043));
      if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        super.getWindow().addFlags(67108864);
        ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
        this.titleRoot.setFitsSystemWindows(false);
        this.titleRoot.setPadding(0, 0, 0, 0);
        if (this.mSystemBarComp == null) {
          this.mSystemBarComp = new SystemBarCompact(this, true, -1);
        }
        this.mSystemBarComp.init();
        this.mSystemBarComp.setStatusBarColor(0);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
      return;
    }
    setTitle(alud.a(2131713481));
    this.leftView.setText(alud.a(2131713256));
    a();
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.a(getWindow(), this.isClearCoverLayer);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.app)) {
        break label156;
      }
      if ((bdep.b()) || (bdep.d())) {
        break label136;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848998);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label136:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label156:
      if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bdep.d())
      {
        this.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfActivity.1(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ors.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (!this.jdField_a_of_type_Boolean) {
      syp.a("self_tab_cost", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */