package com.tencent.mobileqq.activity.phone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import wvg;
import wvh;

@SuppressLint({"ViewConstructor"})
public class PhoneMatchView
  extends BaseActivityView
  implements View.OnClickListener
{
  private Button a;
  public ContactBindObserver a;
  
  public PhoneMatchView(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a(2130969168, true);
    j();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131365485));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
  }
  
  private void k()
  {
    if (!NetworkUtil.d(getContext()))
    {
      b(2131434613);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = new wvg(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new wvh(this));
    QQToast.a(BaseApplicationImpl.sApplication, "特征码匹配中。", 0).a();
    a(2131434453, 1000L, true);
  }
  
  protected void a()
  {
    super.a();
    this.b.setText("通讯录");
    if (this.jdField_a_of_type_Int == 2)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131437170);
      return;
    }
    if (this.jdField_a_of_type_Int == 3)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 1) && (paramInt2 != 0))
    {
      if (paramInt2 == 2)
      {
        paramIntent = new Intent(getContext(), BindNumberActivity.class);
        paramIntent.putExtra("kNeedUnbind", true);
        a(paramIntent);
      }
    }
    else {
      return;
    }
    a(new Intent(getContext(), PhoneLaunchActivity.class));
  }
  
  protected void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactContactBindObserver = null;
    }
    super.d();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      k();
      return;
    }
    a(new Intent(getContext(), SettingActivity2.class), 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneMatchView
 * JD-Core Version:    0.7.0.1
 */