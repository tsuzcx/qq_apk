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
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;

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
    a(2130969165);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131365486));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void j()
  {
    Intent localIntent = new Intent(getContext(), BindNumberActivity.class);
    localIntent.putExtra("key_is_modal_pop", true);
    localIntent.putExtra("kSrouce", this.jdField_b_of_type_Int);
    a(localIntent, 1);
    a(2131034380, 2131034131);
  }
  
  protected void a()
  {
    super.a();
    if (this.jdField_a_of_type_Int == 3) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("通讯录");
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_Boolean) {
        j();
      }
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("启用通讯录");
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (this.jdField_a_of_type_Int != 1) {
        break label26;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setResult(paramInt2);
      f();
    }
    label26:
    do
    {
      return;
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
    } while (paramInt2 != 1);
    f();
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
    if (this.jdField_a_of_type_Int == 3)
    {
      ((ImageView)a(2131365484)).setImageResource(2130839570);
      ((TextView)a(2131365485)).setText(2131435528);
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "QQPim", "Clk_address_on", 0, 0, "", "", "", "");
      if ((i == 1) || (i == 2) || (i == 3) || (i == 4))
      {
        ContactUtils.a(6);
        j();
      }
    }
    else
    {
      return;
    }
    if (i == 5)
    {
      a(new Intent(getContext(), BindNumberFromPcActivity.class), 1);
      a(2131034380, 2131034131);
      return;
    }
    a("请求出错", "请稍后重试");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchView
 * JD-Core Version:    0.7.0.1
 */