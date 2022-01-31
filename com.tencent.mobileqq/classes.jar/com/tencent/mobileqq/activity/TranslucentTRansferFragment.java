package com.tencent.mobileqq.activity;

import abvd;
import abve;
import abvf;
import ajjy;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import babr;
import bafb;
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
    bafb localbafb;
    do
    {
      return;
      localbafb = babr.a(getActivity(), 0, null, "你是否要去注册QQ？", null, null, null, null);
      localbafb.setPositiveButton(ajjy.a(2131649281), new abvd(this, localbafb));
      localbafb.setNegativeButton(ajjy.a(2131649279), new abve(this, localbafb));
      localbafb.setOnDismissListener(new abvf(this));
    } while (getActivity().isFinishing());
    localbafb.show();
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