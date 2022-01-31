package com.tencent.mobileqq.activity.registerGuideLogin;

import addn;
import ajik;
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
  protected addn a;
  protected ajik a;
  public BaseActivity a;
  public QQAppInterface a;
  public String a;
  
  public GuideBaseFragment() {}
  
  @SuppressLint({"ValidFragment"})
  public GuideBaseFragment(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Addn = new addn();
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
  
  public void a(ajik paramajik)
  {
    this.jdField_a_of_type_Ajik = paramajik;
  }
  
  public void a(Intent paramIntent) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.GuideBaseFragment
 * JD-Core Version:    0.7.0.1
 */