package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import xas;
import xat;

public class PhoneMatchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  private Button jdField_a_of_type_AndroidWidgetButton;
  ContactBindObserver jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new xat(this);
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentViewB(2130969166);
    this.centerView.setText("通讯录");
    if (getIntent().getBooleanExtra("key_from_contact_first", false)) {
      ((TextView)super.findViewById(2131365489)).setText(2131436879);
    }
    this.jdField_a_of_type_Int = getIntent().getIntExtra("kSrouce", -1);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365490));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    setLeftButton(2131434953, this);
    ReportController.b(this.app, "dc00898", "", "", "0X800689B", "0X800689B", 0, 0, "", "", "", "");
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2131034122);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      if (!NetworkUtil.d(this))
      {
        b(2131434629);
        return;
      }
      this.app.a(new xas(this));
      if (this.jdField_a_of_type_Int == 16) {
        QQToast.a(BaseApplicationImpl.sApplication, "寻找通讯录联系人中。", 0).a();
      }
      for (;;)
      {
        if (getIntent().getBooleanExtra("key_from_Tab", false)) {
          ReportController.b(this.app, "CliOper", "", "", "0X80053DE", "0X80053DE", 0, 0, "", "", "", "");
        }
        if (getIntent().getBooleanExtra("key_from_l_w", false)) {
          ReportController.b(this.app, "dc00898", "", "", "0X800650C", "0X800650C", 2, 0, this.app.c(), "", "", "");
        }
        ReportController.b(this.app, "dc00898", "", "", "0X800689C", "0X800689C", 0, 0, "", "", "", "");
        a(2131434469, 1000L, true);
        return;
        QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).a();
      }
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchActivity
 * JD-Core Version:    0.7.0.1
 */