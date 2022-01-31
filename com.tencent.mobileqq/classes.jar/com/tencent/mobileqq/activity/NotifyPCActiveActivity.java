package com.tencent.mobileqq.activity;

import adlb;
import adlc;
import adld;
import adle;
import alpk;
import alpq;
import alqf;
import android.content.Intent;
import android.os.Bundle;
import azqs;
import bdgm;
import bdjz;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class NotifyPCActiveActivity
  extends BaseActivity
{
  public static NotifyPCActiveActivity a;
  private int jdField_a_of_type_Int;
  private alpq jdField_a_of_type_Alpq = new adle(this);
  private bdjz jdField_a_of_type_Bdjz;
  
  private void a()
  {
    alqf localalqf = (alqf)this.app.a(4);
    if (localalqf != null) {
      localalqf.a();
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bdjz != null)
      {
        this.jdField_a_of_type_Bdjz.setCancelable(false);
        this.jdField_a_of_type_Bdjz.show();
      }
      return;
      this.app.addObserver(this.jdField_a_of_type_Alpq, true);
      Object localObject1 = (alpk)this.app.a(2);
      Object localObject3 = getIntent().getExtras();
      Object localObject2 = ((Bundle)localObject3).getString("Message");
      String str = ((Bundle)localObject3).getString("lButton");
      localObject3 = ((Bundle)localObject3).getString("rButton");
      this.jdField_a_of_type_Bdjz = bdgm.a(this, 230);
      this.jdField_a_of_type_Bdjz.setContentView(2131558919);
      this.jdField_a_of_type_Bdjz.setTitle(null).setMessage((CharSequence)localObject2).setPositiveButton((String)localObject3, new adlc(this, (alpk)localObject1)).setNegativeButton(str, new adlb(this));
      continue;
      localObject2 = getIntent().getExtras();
      localObject1 = ((Bundle)localObject2).getString("Message");
      localObject2 = ((Bundle)localObject2).getString("button");
      this.jdField_a_of_type_Bdjz = bdgm.a(this, 230).setMessage((CharSequence)localObject1).setPositiveButton((String)localObject2, new adld(this));
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559398);
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = this;
    this.jdField_a_of_type_Int = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel()) {
      QLog.d("NotificationActivity", 2, "NotificationActivity action = " + paramBundle);
    }
    if ("mqq.intent.action.PCACTIVE_TIPS".equals(paramBundle))
    {
      azqs.b(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
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
    this.app.removeObserver(this.jdField_a_of_type_Alpq);
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
    if ((this.jdField_a_of_type_Bdjz != null) && (this.jdField_a_of_type_Bdjz.isShowing())) {
      this.jdField_a_of_type_Bdjz.dismiss();
    }
    this.jdField_a_of_type_Bdjz = null;
    super.finish();
    jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity
 * JD-Core Version:    0.7.0.1
 */