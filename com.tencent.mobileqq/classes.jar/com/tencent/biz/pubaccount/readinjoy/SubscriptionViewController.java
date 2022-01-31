package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.mobileqq.app.BaseActivity;
import java.util.List;
import lbd;

public class SubscriptionViewController
  extends ReadInJoyBaseViewController
{
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ReadInJoyObserver a;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  private ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback;
  
  public SubscriptionViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lbd(this);
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    super.a();
    List localList = ReadInJoyLogicEngine.a().a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoySubscriptionListViewGroup(this, 0, null);
    ((ReadInJoySubscriptionListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).setOnSubscriptActionCallback(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback);
    if ((localList != null) && (!localList.isEmpty())) {
      ((ReadInJoySubscriptionListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(localList);
    }
    b();
    ReadInJoyLogicEngine.a().e();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(ReadInJoySubscriptionListViewGroup.OnSubscriptActionCallback paramOnSubscriptActionCallback)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySubscriptionListViewGroup$OnSubscriptActionCallback = paramOnSubscriptActionCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void b()
  {
    super.b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(null, null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(null);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(null, false);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
    }
  }
  
  public void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(null, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
  }
  
  public void e()
  {
    super.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    ReadInJoyLogicEngine.a().e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.c();
  }
  
  public void o()
  {
    super.o();
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyFeedsActivity)) && (((ReadInJoyFeedsActivity)this.jdField_a_of_type_AndroidAppActivity).a() == 1)) {
      TroopBarAssistantManager.a().d(((BaseActivity)a()).app);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.SubscriptionViewController
 * JD-Core Version:    0.7.0.1
 */