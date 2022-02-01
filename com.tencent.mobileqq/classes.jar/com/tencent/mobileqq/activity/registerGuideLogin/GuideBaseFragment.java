package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.QFragment;
import com.tencent.mobileqq.activity.LoginUserPrivateHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import mqq.app.AppRuntime;

public class GuideBaseFragment
  extends QFragment
{
  protected LoginUserPrivateHelper a;
  protected GuideBaseFragment.GuideCallBack a;
  protected QBaseActivity a;
  protected String a;
  protected AppRuntime a;
  
  public GuideBaseFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public GuideBaseFragment(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginUserPrivateHelper = new LoginUserPrivateHelper();
  }
  
  public Dialog a(int paramInt)
  {
    return null;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt, Dialog paramDialog) {}
  
  public void a(Intent paramIntent) {}
  
  public void a(GuideBaseFragment.GuideCallBack paramGuideCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginGuideBaseFragment$GuideCallBack = paramGuideCallBack;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getActivity();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment
 * JD-Core Version:    0.7.0.1
 */