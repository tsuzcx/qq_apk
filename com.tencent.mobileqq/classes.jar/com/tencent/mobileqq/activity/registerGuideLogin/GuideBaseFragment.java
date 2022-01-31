package com.tencent.mobileqq.activity.registerGuideLogin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class GuideBaseFragment
  extends Fragment
{
  protected GuideBaseFragment.GuideCallBack a;
  public BaseActivity a;
  public QQAppInterface a;
  public String a;
  
  public GuideBaseFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public GuideBaseFragment(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = getActivity();
  }
  
  public void onDetach()
  {
    super.onDetach();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment
 * JD-Core Version:    0.7.0.1
 */