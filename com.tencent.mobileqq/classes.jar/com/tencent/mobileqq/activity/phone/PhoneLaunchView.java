package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.util.PhoneContactUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@SuppressLint({"ViewConstructor"})
public class PhoneLaunchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public PhoneLaunchView(Activity paramActivity, int paramInt)
  {
    super(paramActivity, paramInt);
    a(2131559548);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131372509));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    PhoneContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getResources(), (ImageView)a(2131372511));
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getContext(), BindNumberActivity.class);
    localIntent.putExtra("key_is_modal_pop", true);
    localIntent.putExtra("kSrouce", this.jdField_b_of_type_Int);
    a(localIntent, 1);
    a(2130772342, 2130772004);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Int == 3) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131708014));
    } else {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131708006));
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.jdField_a_of_type_Boolean) {
      j();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(paramInt2);
        f();
        return;
      }
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("refuse_upload", false)))
        {
          f();
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(paramInt2, paramIntent);
        a(new Intent(getContext(), ContactListView.class));
        return;
      }
      if (paramInt2 == 0) {
        f();
      }
    }
  }
  
  protected void a(Intent paramIntent, PhoneInnerFrame paramPhoneInnerFrame)
  {
    if (paramIntent != null)
    {
      if (paramIntent.getBooleanExtra("k_start_number", false)) {
        this.jdField_a_of_type_Boolean = true;
      }
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("kSrouce", -1);
    }
    super.a(paramIntent, paramPhoneInnerFrame);
    if (this.jdField_a_of_type_Int == 3) {
      ((TextView)a(2131372512)).setText(2131689674);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService.getSelfBindState();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
      if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
      {
        if (i == 5)
        {
          a(new Intent(getContext(), BindNumberFromPcActivity.class), 1);
          a(2130772342, 2130772004);
        }
        else
        {
          a(HardCodeUtil.a(2131708016), HardCodeUtil.a(2131708012));
        }
      }
      else
      {
        ContactUtils.a(6);
        j();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchView
 * JD-Core Version:    0.7.0.1
 */