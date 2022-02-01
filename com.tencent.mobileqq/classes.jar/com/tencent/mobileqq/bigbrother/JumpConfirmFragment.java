package com.tencent.mobileqq.bigbrother;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class JumpConfirmFragment
  extends QPublicBaseFragment
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
      localObject = DialogUtil.a(getActivity(), 0, null, "即将离开QQ\n打开其他应用", getString(2131690728), getString(2131720390), new JumpConfirmFragment.1(this), new JumpConfirmFragment.2(this));
      ((QQCustomDialog)localObject).setOnDismissListener(new JumpConfirmFragment.3(this));
      getQBaseActivity().setJumpDialog((Dialog)localObject);
      ((QQCustomDialog)localObject).show();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpConfirmFragment", 1, localThrowable, new Object[0]);
      JefsClass.getInstance().a(this.jdField_a_of_type_Int, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int);
      getActivity().finish();
    }
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.JumpConfirmFragment
 * JD-Core Version:    0.7.0.1
 */