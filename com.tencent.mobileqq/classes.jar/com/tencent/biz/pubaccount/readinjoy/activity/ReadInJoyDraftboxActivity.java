package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.widget.TextView;
import anzj;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ozs;
import rlz;

public class ReadInJoyDraftboxActivity
  extends IphoneTitleBarActivity
{
  protected ReadInJoyDraftboxFragment a;
  protected QQAppInterface a;
  
  private void a()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {
      return;
    }
    rlz.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    setContentView(2131558457);
    setTitle(anzj.a(2131711771));
    this.leftView.setText(anzj.a(2131711760));
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new TopEdgeGestureLayout(this));
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxFragment = new ReadInJoyDraftboxFragment();
    localFragmentTransaction.add(2131367109, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxFragment);
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxFragment);
    localFragmentTransaction.commit();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ozs.a());
    a();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyDraftboxActivity
 * JD-Core Version:    0.7.0.1
 */