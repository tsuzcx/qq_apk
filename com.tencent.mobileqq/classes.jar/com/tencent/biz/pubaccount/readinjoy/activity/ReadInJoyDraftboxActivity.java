package com.tencent.biz.pubaccount.readinjoy.activity;

import ajjy;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import obz;
import pye;

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
    pye.a().c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    setContentView(2131492914);
    setTitle(ajjy.a(2131647100));
    this.leftView.setText(ajjy.a(2131647089));
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler))) {
      ((FlingGestureHandler)this.mFlingHandler).setTopLayout(new TopEdgeGestureLayout(this));
    }
    FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxFragment = new ReadInJoyDraftboxFragment();
    localFragmentTransaction.add(2131301051, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxFragment);
    localFragmentTransaction.show(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyUgcReadInJoyDraftboxFragment);
    localFragmentTransaction.commit();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)obz.a());
    a();
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyDraftboxActivity
 * JD-Core Version:    0.7.0.1
 */