package com.tencent.mobileqq.activity.registerGuideLogin;

import ajmz;
import ajna;
import alzc;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import azqs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class RegisterGuideView
  extends GuideBaseFragment
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private Button b;
  
  public RegisterGuideView() {}
  
  @SuppressLint({"ValidFragment"})
  public RegisterGuideView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    if (getActivity() != null)
    {
      localObject = getActivity();
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
      for (str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; str = "") {
        return alzc.a((Context)localObject, str);
      }
    }
    Object localObject = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; str = "") {
      return alzc.a((Context)localObject, str);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131363625) && (i == 2131363683)) {}
    switch (paramView.getId())
    {
    default: 
    case 2131363625: 
      do
      {
        return;
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007575", "0X8007575", 0, 0, "", "", "", "");
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA26", "0X800AA26", 0, 0, "", "", "", "");
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
        paramView.putExtra("from_register_guide", true);
        paramView.putExtra("is_need_show_logo_animation", true);
        paramView = ajna.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      } while (this.jdField_a_of_type_Ajmz == null);
      this.jdField_a_of_type_Ajmz.a(paramView);
      return;
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007576", "0X8007576", 0, 0, "", "", "", "");
    azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA25", "0X800AA25", 0, 0, "", "", "", "");
    paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
    paramView.putExtra("key_register_from", 2);
    paramView.putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690623));
    paramView.addFlags(67108864);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559240, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363377);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131363625));
    this.b = ((Button)paramViewGroup.findViewById(2131363683));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramBundle = (ImageView)paramViewGroup.findViewById(2131376956);
    paramLayoutInflater = "splash.jpg";
    for (;;)
    {
      try
      {
        if (paramViewGroup.getContext().getResources().getDisplayMetrics().widthPixels > 1500) {
          paramLayoutInflater = "splash_big.jpg";
        }
        paramLayoutInflater = getActivity().getAssets().open(paramLayoutInflater);
        paramBundle.setImageDrawable(new BitmapDrawable(getResources(), paramLayoutInflater));
      }
      catch (Throwable paramLayoutInflater)
      {
        QLog.e("LoginActivity.RegisterGuideView", 1, "onCreateView error2:" + paramLayoutInflater.getMessage());
        continue;
      }
      try
      {
        paramLayoutInflater.close();
        azqs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA24", "0X800AA24", 0, 0, "", "", "", "");
        return paramViewGroup;
      }
      catch (Throwable paramLayoutInflater)
      {
        QLog.e("LoginActivity.RegisterGuideView", 1, "onCreateView error1:" + paramLayoutInflater.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView
 * JD-Core Version:    0.7.0.1
 */