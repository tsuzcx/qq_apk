package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import bglp;
import bgpa;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import nev;

public class AVGameOverlayFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int = -1;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  bgpa jdField_a_of_type_Bgpa;
  private String jdField_a_of_type_JavaLangString;
  
  private void a()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showKickMeDialog");
    }
    this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage(null).setNegativeButton(null, null).setPositiveButton(2131690218, new nev(this));
    this.jdField_a_of_type_Bgpa.setTitle(null);
    bgpa localbgpa = this.jdField_a_of_type_Bgpa;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str = getString(2131690264);; str = this.jdField_a_of_type_JavaLangString)
    {
      localbgpa.setMessage(str);
      this.jdField_a_of_type_Bgpa.setCancelable(false);
      this.jdField_a_of_type_Bgpa.setCanceledOnTouchOutside(false);
      this.jdField_a_of_type_Bgpa.show();
      return;
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    paramBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getIntExtra("type", 0);
      this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("tip");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onDestroy");
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ListenTogetherOverlayFragment", 2, "onPause");
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Int == 1)
    {
      a();
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameOverlayFragment
 * JD-Core Version:    0.7.0.1
 */