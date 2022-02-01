package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfCenterViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import mqq.os.MqqHandler;

public class ReadInJoySelfActivity
  extends IphoneTitleBarActivity
  implements KandianMergeManager.OnTabRedNumsChangeListenner
{
  protected KandianMergeManager a;
  protected ReadInJoyBaseFragment a;
  protected QQAppInterface a;
  
  private void a()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    ReadInJoyWebDataManager.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localObject1 = ReadInJoyWebDataManager.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i())
      {
        i = 0;
        ((ReadInJoyWebDataManager)localObject1).a((String)localObject2, i);
      }
    }
    else
    {
      setContentView(2131558459);
      c();
      localObject2 = getSupportFragmentManager().beginTransaction();
      if (!StudyModeManager.a()) {
        break label153;
      }
    }
    label153:
    for (Object localObject1 = "3";; localObject1 = "1")
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment = ReadInJoySelfCenterViolaFragment.a("https://viola.qq.com/js/usercenter.js?_rij_violaUrl=1&hideNav=1&v_nav_immer=1&v_tid=6&v_bundleName=usercenter&v_bid=3740&jump_source=" + (String)localObject1);
      ((FragmentTransaction)localObject2).add(2131367430, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
      ((FragmentTransaction)localObject2).show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyBaseFragment);
      ((FragmentTransaction)localObject2).commit();
      return;
      i = 1;
      break;
    }
  }
  
  public static void a(Activity paramActivity) {}
  
  private void c()
  {
    hideTitleBar();
    setImmersiveStatus();
    this.titleRoot = ((RelativeLayout)findViewById(2131379546));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getWindow(), this.isClearCoverLayer);
      this.titleRoot.setFitsSystemWindows(false);
      this.titleRoot.setPadding(0, 0, 0, 0);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      this.mSystemBarComp.setStatusBarColor(0);
      this.mSystemBarComp.setStatusBarDarkMode(true);
    }
  }
  
  public void ai_()
  {
    ThreadManager.getUIHandler().post(new ReadInJoySelfActivity.1(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    a();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */