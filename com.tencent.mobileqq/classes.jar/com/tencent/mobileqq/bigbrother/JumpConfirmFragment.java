package com.tencent.mobileqq.bigbrother;

import allu;
import allv;
import allw;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import babr;
import bafb;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;

public class JumpConfirmFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = getArguments();
    this.jdField_a_of_type_JavaLangString = ((Bundle)localObject).getString("big_brother_source_key");
    this.jdField_a_of_type_Int = ((Bundle)localObject).getInt("key_id");
    this.jdField_b_of_type_JavaLangString = ((Bundle)localObject).getString("key_process_id");
    this.jdField_b_of_type_Int = ((Bundle)localObject).getInt("key_callback_id", 0);
    try
    {
      localObject = babr.a(getActivity(), 0, null, "即将离开QQ\n打开其他应用", getString(2131625035), getString(2131654987), new allu(this), new allv(this));
      ((bafb)localObject).setOnDismissListener(new allw(this));
      getActivity().setJumpDialog((Dialog)localObject);
      ((bafb)localObject).show();
      return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("JumpConfirmFragment", 1, localThrowable, new Object[0]);
        JefsClass.getInstance().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
        getActivity().finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.JumpConfirmFragment
 * JD-Core Version:    0.7.0.1
 */