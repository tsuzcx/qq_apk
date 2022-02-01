package com.tencent.biz.pubaccount.readinjoy.comment.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import pcp;

public class ReadInJoyCommentBridgeFragment
  extends PublicBaseFragment
{
  private ReadInJoyCommentComponentFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment;
  private boolean jdField_a_of_type_Boolean = bmhv.g();
  
  private void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    new pcp(localFragmentActivity, localFragmentActivity.getIntent()).a();
  }
  
  private boolean a(FragmentManager paramFragmentManager)
  {
    Fragment localFragment = paramFragmentManager.findFragmentByTag("ReadInJoyCommentComponentFragment");
    if (localFragment != null)
    {
      if ((localFragment instanceof ReadInJoyCommentComponentFragment))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment = ((ReadInJoyCommentComponentFragment)localFragment);
        return true;
      }
      paramFragmentManager.beginTransaction().remove(localFragment).commitAllowingStateLoss();
    }
    return false;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        c();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.isAdded());
      localObject = getActivity();
    } while (localObject == null);
    Object localObject = ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction();
    ((FragmentTransaction)localObject).add(2131367244, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment, "ReadInJoyCommentComponentFragment");
    ((FragmentTransaction)localObject).commitAllowingStateLoss();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment != null) {}
    FragmentActivity localFragmentActivity;
    do
    {
      return;
      localFragmentActivity = getActivity();
    } while ((localFragmentActivity != null) && (a(localFragmentActivity.getSupportFragmentManager())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment = new ReadInJoyCommentComponentFragment();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.setArguments(getArguments());
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.initWindowStyleAndAnimation(paramActivity);
    }
  }
  
  public boolean isWrapContent()
  {
    b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.isWrapContent();
    }
    return false;
  }
  
  public boolean needImmersive()
  {
    b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.needImmersive();
    }
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean) {
      a();
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, null);
      return null;
      b();
    }
  }
  
  public void onFinish()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentComponentFragment.onFinish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentBridgeFragment
 * JD-Core Version:    0.7.0.1
 */