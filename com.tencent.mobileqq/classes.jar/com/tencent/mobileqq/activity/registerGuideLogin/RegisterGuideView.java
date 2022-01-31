package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

public class RegisterGuideView
  extends GuideBaseFragment
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  
  public RegisterGuideView() {}
  
  @SuppressLint({"ValidFragment"})
  public RegisterGuideView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_b_of_type_AndroidWidgetImageView != null) {
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    while (this.jdField_b_of_type_AndroidWidgetImageView == null) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364884: 
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007575", "0X8007575", 0, 0, "", "", "", "");
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
        paramView.putExtra("from_register_guide", true);
        paramView.putExtra("is_need_show_logo_animation", true);
        paramView = GuideHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack.a(paramView);
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007576", "0X8007576", 0, 0, "", "", "", "");
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
    paramView.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433698));
    paramView.addFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130969057, paramViewGroup, false);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364880));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131364881));
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131363109);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131364884));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)paramLayoutInflater.findViewById(2131364885));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isInMultiWindow())
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return paramLayoutInflater;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView
 * JD-Core Version:    0.7.0.1
 */