package com.tencent.biz.pubaccount.accountdetail.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PubAccountMoreInfoActivity
  extends IphoneTitleBarActivity
{
  float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  PublicAccountDetailImpl jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl;
  AccountDetailGroupListContainer jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer;
  mobileqq_mp.GetPublicAccountDetailInfoResponse jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$GetPublicAccountDetailInfoResponse;
  String jdField_a_of_type_JavaLangString;
  protected NewIntent a;
  protected BusinessObserver a;
  
  private void c()
  {
    super.setContentView(2131558434);
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131376828));
    setTitle(getResources().getString(2131695213));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131374033);
    View localView;
    if (QQTheme.a())
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(0);
      }
    }
    else
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer = new AccountDetailGroupListContainer(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl, true);
      this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a());
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer = new AccountDetailGroupListContainer(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl, true);
    this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer.a());
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "init");
    }
    Object localObject = getIntent();
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (localObject != null) {
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
    }
    localObject = (IPublicAccountDataManager)this.app.getRuntimeService(IPublicAccountDataManager.class, "all");
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl = ((PublicAccountDetailImpl)((IPublicAccountDataManager)localObject).findAccountDetailInfo(this.jdField_a_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl == null) {
      b();
    }
  }
  
  public void a(int paramInt)
  {
    Toast.makeText(getApplicationContext(), paramInt, 0).show();
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PubAccountMoreInfoActivity", 2, "sendPublicAccountDetailInfoRequest");
    }
    Object localObject = this.jdField_a_of_type_MqqAppNewIntent;
    if (localObject != null) {
      ((NewIntent)localObject).setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServletImpl.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    localObject = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).versionInfo.set("8.7.0,3,5295");
    ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).version.set(1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl != null) {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailApiImplPublicAccountDetailImpl.seqno);
    } else {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).seqno.set(0);
    }
    try
    {
      ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).uin.set((int)Long.parseLong(this.jdField_a_of_type_JavaLangString));
      label129:
      this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", ((mobileqq_mp.GetPublicAccountDetailInfoRequest)localObject).toByteArray());
      this.jdField_a_of_type_MqqObserverBusinessObserver = new PubAccountMoreInfoActivity.1(this);
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
      this.app.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
      return;
    }
    catch (Exception localException)
    {
      break label129;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    a();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    AccountDetailGroupListContainer localAccountDetailGroupListContainer = this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailGroupListContainer;
    if (localAccountDetailGroupListContainer != null) {
      localAccountDetailGroupListContainer.b();
    }
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.activity.PubAccountMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */