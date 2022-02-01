package com.tencent.mobileqq.activity;

import afaz;
import afba;
import afbb;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import anvx;
import bhdj;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class TranslucentTRansferFragment
  extends PublicBaseFragment
{
  private void a()
  {
    switch (getActivity().getIntent().getIntExtra("action", -1))
    {
    default: 
      return;
    }
    b();
  }
  
  private void b()
  {
    if (getActivity() == null) {}
    QQCustomDialog localQQCustomDialog;
    do
    {
      return;
      localQQCustomDialog = bhdj.a(getActivity(), 0, null, "你是否要去注册QQ？", null, null, null, null);
      localQQCustomDialog.setPositiveButton(anvx.a(2131714434), new afaz(this, localQQCustomDialog));
      localQQCustomDialog.setNegativeButton(anvx.a(2131714432), new afba(this, localQQCustomDialog));
      localQQCustomDialog.setOnDismissListener(new afbb(this));
    } while (getActivity().isFinishing());
    localQQCustomDialog.show();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
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
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (getActivity() == null) {
      return;
    }
    a();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TranslucentTRansferFragment
 * JD-Core Version:    0.7.0.1
 */