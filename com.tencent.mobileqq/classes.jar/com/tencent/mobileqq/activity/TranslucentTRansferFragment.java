package com.tencent.mobileqq.activity;

import acfp;
import acfq;
import acfr;
import ajyc;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import bbcv;
import bbgg;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

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
    bbgg localbbgg;
    do
    {
      return;
      localbbgg = bbcv.a(getActivity(), 0, null, "你是否要去注册QQ？", null, null, null, null);
      localbbgg.setPositiveButton(ajyc.a(2131715070), new acfp(this, localbbgg));
      localbbgg.setNegativeButton(ajyc.a(2131715068), new acfq(this, localbbgg));
      localbbgg.setOnDismissListener(new acfr(this));
    } while (getActivity().isFinishing());
    localbbgg.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TranslucentTRansferFragment
 * JD-Core Version:    0.7.0.1
 */