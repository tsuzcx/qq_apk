package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.InputStream;
import mqq.app.AppRuntime;

public class RegisterGuideView
  extends GuideBaseFragment
  implements View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private Button b;
  
  public RegisterGuideView() {}
  
  @SuppressLint({"ValidFragment"})
  public RegisterGuideView(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131364044) && (i == 2131364109)) {}
    i = paramView.getId();
    Object localObject;
    if (i == 2131364044)
    {
      ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8007575", "0X8007575", 0, 0, "", "", "", "");
      ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA26", "0X800AA26", 0, 0, "", "", "", "");
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
      ((Intent)localObject).putExtra("from_register_guide", true);
      ((Intent)localObject).putExtra("is_need_show_logo_animation", true);
      localObject = GuideHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqAppAppRuntime);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack.changeGuideBaseView((GuideBaseFragment)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i == 2131364109)
      {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "0X8007576", "0X8007576", 0, 0, "", "", "", "");
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA25", "0X800AA25", 0, 0, "", "", "", "");
        localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, RegisterPhoneNumActivity.class);
        ((Intent)localObject).putExtra("key_register_from", 2);
        ((Intent)localObject).putExtra("leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131690778));
        ((Intent)localObject).addFlags(67108864);
        this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131559444, paramViewGroup, false);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131363785);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131364044));
    this.b = ((Button)paramViewGroup.findViewById(2131364109));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.b.setOnClickListener(this);
    paramBundle = (ImageView)paramViewGroup.findViewById(2131378374);
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
        ReportController.a(this.jdField_a_of_type_MqqAppAppRuntime, "dc00898", "", "", "0X800AA24", "0X800AA24", 0, 0, "", "", "", "");
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