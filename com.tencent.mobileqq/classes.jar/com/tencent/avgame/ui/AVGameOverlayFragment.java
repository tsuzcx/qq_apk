package com.tencent.avgame.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

public class AVGameOverlayFragment
  extends QPublicBaseFragment
{
  QQCustomDialog a;
  private QBaseActivity b;
  private int c = -1;
  private String d;
  
  private void a()
  {
    if (this.a != null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherOverlayFragment", 2, "showKickMeDialog");
    }
    this.a = DialogUtil.a(this.b, 230).setMessage(null).setNegativeButton(null, null).setPositiveButton(2131887191, new AVGameOverlayFragment.1(this));
    this.a.setTitle(null);
    QQCustomDialog localQQCustomDialog = this.a;
    String str;
    if (TextUtils.isEmpty(this.d)) {
      str = getString(2131887242);
    } else {
      str = this.d;
    }
    localQQCustomDialog.setMessage(str);
    this.a.setCancelable(false);
    this.a.setCanceledOnTouchOutside(false);
    this.a.show();
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
    this.b = getQBaseActivity();
    paramBundle = this.b.getIntent();
    if (paramBundle != null)
    {
      this.c = paramBundle.getIntExtra("type", 0);
      this.d = paramBundle.getStringExtra("tip");
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
    QBaseActivity localQBaseActivity = getQBaseActivity();
    if (localQBaseActivity == null) {
      return;
    }
    localQBaseActivity.overridePendingTransition(0, 0);
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
    if (this.c == 1)
    {
      a();
      return;
    }
    this.b.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameOverlayFragment
 * JD-Core Version:    0.7.0.1
 */