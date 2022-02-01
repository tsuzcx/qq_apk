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
  private String a;
  private int b;
  private String c;
  private int d;
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = getArguments();
    this.a = ((Bundle)localObject).getString("big_brother_source_key");
    this.b = ((Bundle)localObject).getInt("key_id");
    this.c = ((Bundle)localObject).getString("key_process_id");
    this.d = ((Bundle)localObject).getInt("key_callback_id", 0);
    try
    {
      localObject = DialogUtil.a(getActivity(), 0, null, "即将离开QQ\n打开其他应用", getString(2131887648), getString(2131918066), new JumpConfirmFragment.1(this), new JumpConfirmFragment.2(this));
      ((QQCustomDialog)localObject).setOnDismissListener(new JumpConfirmFragment.3(this));
      getQBaseActivity().setJumpDialog((Dialog)localObject);
      ((QQCustomDialog)localObject).show();
    }
    catch (Throwable localThrowable)
    {
      QLog.e("JumpConfirmFragment", 1, localThrowable, new Object[0]);
      JefsClass.getInstance().a(this.b, this.c, this.d);
      getActivity().finish();
    }
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.JumpConfirmFragment
 * JD-Core Version:    0.7.0.1
 */