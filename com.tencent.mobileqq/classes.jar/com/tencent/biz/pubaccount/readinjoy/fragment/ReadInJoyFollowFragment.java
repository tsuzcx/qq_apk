package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import axrn;
import bhvy;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import nte;
import onh;
import osg;

public class ReadInJoyFollowFragment
  extends ReadInJoyBaseFragment
{
  private int jdField_a_of_type_Int = 1;
  private View jdField_a_of_type_AndroidViewView;
  protected nte a;
  private boolean jdField_a_of_type_Boolean;
  
  public static ReadInJoyFollowFragment a()
  {
    ReadInJoyFollowFragment localReadInJoyFollowFragment = new ReadInJoyFollowFragment();
    localReadInJoyFollowFragment.setArguments(new Bundle());
    return localReadInJoyFollowFragment;
  }
  
  private void a()
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131374833);
    this.jdField_a_of_type_Nte = new nte(getActivity());
    this.jdField_a_of_type_Nte.a(70);
    this.jdField_a_of_type_Nte.b(0);
    this.jdField_a_of_type_Nte.a(localViewGroup);
    this.jdField_a_of_type_Nte.a();
  }
  
  public int a()
  {
    return 70;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Nte.a(paramInt1, paramInt2, paramIntent);
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    super.a(paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt, Bundle paramBundle)
  {
    super.a(paramMessageRecord, paramInt, paramBundle);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.b();
    }
    this.jdField_a_of_type_Boolean = true;
    if ((!bhvy.i()) || ((paramActivity instanceof ReadInJoyNewFeedsActivity)))
    {
      paramActivity = ((ReadInJoyNewFeedsActivity)paramActivity).a();
      int i = paramActivity.b();
      if (i == 2) {
        paramActivity.b(i);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(2) > 0) && (this.jdField_a_of_type_Nte != null)) {
        this.jdField_a_of_type_Nte.a(true);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Nte != null) {
        this.jdField_a_of_type_Nte.h();
      }
      axrn.a(getActivity()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "actReadInJoyEnterDD", true, 0L, 0L, null, null);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d(2);
    }
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    super.b(paramMessageRecord);
  }
  
  public boolean d()
  {
    return onh.g();
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(true);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.a(true);
    }
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.g();
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Nte != null) {
      this.jdField_a_of_type_Nte.k();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_Nte.a(paramInt1, paramInt2, paramIntent);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559931, paramViewGroup, false);
    a();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_Nte.d();
    osg.a().a();
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.jdField_a_of_type_Nte.c();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Nte.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Nte.h();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Nte.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    this.jdField_a_of_type_Nte.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyFollowFragment
 * JD-Core Version:    0.7.0.1
 */