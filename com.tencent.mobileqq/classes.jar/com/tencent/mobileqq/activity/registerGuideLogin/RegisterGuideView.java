package com.tencent.mobileqq.activity.registerGuideLogin;

import alfp;
import alfq;
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
import anrj;
import bcst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
        return anrj.a((Context)localObject, str);
      }
    }
    Object localObject = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; str = "") {
      return anrj.a((Context)localObject, str);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131363825) && (i == 2131363886)) {}
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007575", "0X8007575", 0, 0, "", "", "", "");
      bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA26", "0X800AA26", 0, 0, "", "", "", "");
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent();
      ((Intent)localObject).putExtra("from_register_guide", true);
      ((Intent)localObject).putExtra("is_need_show_logo_animation", true);
      localObject = alfq.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (this.jdField_a_of_type_Alfp != null)
      {
        this.jdField_a_of_type_Alfp.a((GuideBaseFragment)localObject);
        continue;
        bcst.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8007576", "0X8007576", 0, 0, "", "", "", "");
        bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA25", "0X800AA25", 0, 0, "", "", "", "");
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
        ((Intent)localObject).putExtra("key_register_from", 2);
        ((Intent)localObject).putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131690563));
        ((Intent)localObject).addFlags(67108864);
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559325, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363570);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131363825));
    this.b = ((Button)paramViewGroup.findViewById(2131363886));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramBundle = (ImageView)paramViewGroup.findViewById(2131377762);
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
        bcst.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AA24", "0X800AA24", 0, 0, "", "", "", "");
        V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
        return paramViewGroup;
      }
      catch (Throwable paramLayoutInflater)
      {
        QLog.e("LoginActivity.RegisterGuideView", 1, "onCreateView error1:" + paramLayoutInflater.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.RegisterGuideView
 * JD-Core Version:    0.7.0.1
 */