package com.tencent.biz.pubaccount.AccountDetail.activity;

import akdh;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import ndz;
import nfr;
import nor;

public class PubAccountMoreInfoActivity
  extends IphoneTitleBarActivity
{
  float jdField_a_of_type_Float;
  private View jdField_a_of_type_AndroidViewView;
  ScrollView jdField_a_of_type_AndroidWidgetScrollView;
  public AccountDetail a;
  public mobileqq_mp.GetPublicAccountDetailInfoResponse a;
  String jdField_a_of_type_JavaLangString;
  protected NewIntent a;
  protected BusinessObserver a;
  nfr jdField_a_of_type_Nfr;
  
  private void c()
  {
    super.setContentView(2131558405);
    this.jdField_a_of_type_AndroidWidgetScrollView = ((ScrollView)super.findViewById(2131375512));
    setTitle(getResources().getString(2131695567));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131372872);
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
        this.jdField_a_of_type_Nfr = new nfr(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, true);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_Nfr.a());
      }
      return;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Nfr = new nfr(this.app, this, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail, true);
    this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_Nfr.a());
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
    localObject = (akdh)this.app.getManager(56);
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = ((akdh)localObject).a(this.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_MqqAppNewIntent = new NewIntent(super.getApplicationContext(), nor.class);
    this.jdField_a_of_type_MqqAppNewIntent.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.3.0,3,4480");
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
        this.jdField_a_of_type_MqqObserverBusinessObserver = new ndz(this);
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
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Nfr != null) {
      this.jdField_a_of_type_Nfr.b();
    }
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
  }
  
  public void doOnPause()
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