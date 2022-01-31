package com.tencent.mobileqq.activity;

import abpi;
import abpj;
import abpk;
import abpl;
import ajtk;
import ajtq;
import ajuf;
import android.content.Intent;
import android.os.Bundle;
import axqw;
import bbcv;
import bbgg;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class NotifyPCActiveActivity
  extends BaseActivity
{
  public static NotifyPCActiveActivity a;
  private int jdField_a_of_type_Int;
  private ajtq jdField_a_of_type_Ajtq = new abpl(this);
  private bbgg jdField_a_of_type_Bbgg;
  
  private void a()
  {
    ajuf localajuf = (ajuf)this.app.a(4);
    if (localajuf != null) {
      localajuf.a();
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    this.jdField_a_of_type_Bbgg = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bbgg != null)
      {
        this.jdField_a_of_type_Bbgg.setCancelable(false);
        this.jdField_a_of_type_Bbgg.show();
      }
      return;
      this.app.addObserver(this.jdField_a_of_type_Ajtq, true);
      Object localObject1 = (ajtk)this.app.a(2);
      Object localObject3 = getIntent().getExtras();
      Object localObject2 = ((Bundle)localObject3).getString("Message");
      String str = ((Bundle)localObject3).getString("lButton");
      localObject3 = ((Bundle)localObject3).getString("rButton");
      this.jdField_a_of_type_Bbgg = bbcv.a(this, 230);
      this.jdField_a_of_type_Bbgg.setContentView(2131558883);
      this.jdField_a_of_type_Bbgg.setTitle(null).setMessage((CharSequence)localObject2).setPositiveButton((String)localObject3, new abpj(this, (ajtk)localObject1)).setNegativeButton(str, new abpi(this));
      continue;
      localObject2 = getIntent().getExtras();
      localObject1 = ((Bundle)localObject2).getString("Message");
      localObject2 = ((Bundle)localObject2).getString("button");
      this.jdField_a_of_type_Bbgg = bbcv.a(this, 230).setMessage((CharSequence)localObject1).setPositiveButton((String)localObject2, new abpk(this));
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559347);
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = this;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqq.intent.action.PCACTIVE_TIPS".equals(paramBundle))
    {
      axqw.b(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
      this.jdField_a_of_type_Int = 1;
      a();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Int);
      return false;
      if ("mqq.intent.action.NOTICE_ON_PCACTIVE".equals(paramBundle)) {
        this.jdField_a_of_type_Int = 2;
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ajtq);
    super.doOnDestroy();
    if (jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity != null) {
      jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyPCActiveActivity", 2, "Running in doOnDestroy()");
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    super.doOnResume();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
  }
  
  public void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    if ((this.jdField_a_of_type_Bbgg != null) && (this.jdField_a_of_type_Bbgg.isShowing())) {
      this.jdField_a_of_type_Bbgg.dismiss();
    }
    this.jdField_a_of_type_Bbgg = null;
    super.finish();
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity
 * JD-Core Version:    0.7.0.1
 */