package com.tencent.biz.pubaccount.AccountDetail.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailGroupListContainer;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import kpg;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

public class PubAccountMoreInfoActivity
  extends IphoneTitleBarActivity
{
  float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  AccountDetailGroupListContainer jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  String jdField_a_of_type_JavaLangString;
  protected NewIntent a;
  protected BusinessObserver a;
  
  private void c()
  {
    super.setContentView(2130968581);
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131362711));
    setTitle(getResources().getString(2131430052));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131362712);
    if (ThemeUtil.isInNightMode(this.app)) {
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = super.getResources().getDisplayMetrics().density;
      if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer = new AccountDetailGroupListContainer(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, true);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a());
      }
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer = new AccountDetailGroupListContainer(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, true);
    this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.a());
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
    localObject = (PublicAccountDataManager)this.app.getManager(55);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = ((PublicAccountDataManager)localObject).a(this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {
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
    if (this.jdField_a_of_type_MqqAppNewIntent != null) {
      this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    }
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), PublicAccountServlet.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("7.6.3,3,3560");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail != null) {
      localGetPublicAccountDetailInfoRequest.seqno.set(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.seqno);
    }
    try
    {
      for (;;)
      {
        localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(this.jdField_a_of_type_JavaLangString));
        label119:
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
        this.jdField_a_of_type_MqqObserverBusinessObserver = new kpg(this);
        this.jdField_a_of_type_MqqAppNewIntent.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
        this.app.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        return;
        localGetPublicAccountDetailInfoRequest.seqno.set(0);
      }
    }
    catch (Exception localException)
    {
      break label119;
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
    if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailGroupListContainer.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.PubAccountMoreInfoActivity
 * JD-Core Version:    0.7.0.1
 */