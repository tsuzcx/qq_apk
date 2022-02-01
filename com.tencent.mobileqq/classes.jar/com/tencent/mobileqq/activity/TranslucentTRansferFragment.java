package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class TranslucentTRansferFragment
  extends PublicBaseFragment
{
  private void a()
  {
    if (getBaseActivity().getIntent().getIntExtra("action", -1) != 4097) {
      return;
    }
    b();
  }
  
  private void b()
  {
    if (getBaseActivity() == null) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(getBaseActivity(), 0, null, "你是否要去注册QQ？", null, null, null, null);
    localQQCustomDialog.setPositiveButton(HardCodeUtil.a(2131714859), new TranslucentTRansferFragment.1(this, localQQCustomDialog));
    localQQCustomDialog.setNegativeButton(HardCodeUtil.a(2131714857), new TranslucentTRansferFragment.2(this, localQQCustomDialog));
    localQQCustomDialog.setOnDismissListener(new TranslucentTRansferFragment.3(this));
    if (!getBaseActivity().isFinishing()) {
      localQQCustomDialog.show();
    }
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
    if (getBaseActivity() == null) {
      return;
    }
    a();
  }
  
  public void onFinish()
  {
    super.onFinish();
    BaseActivity localBaseActivity = getBaseActivity();
    if (localBaseActivity == null) {
      return;
    }
    localBaseActivity.overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TranslucentTRansferFragment
 * JD-Core Version:    0.7.0.1
 */