package com.tencent.mobileqq.activity.phone;

import agkp;
import ajyc;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import anec;
import aume;
import axqw;
import bbcl;
import com.tencent.mobileqq.app.PhoneContactManagerImp;

public class PhoneLaunchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  public aume a;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  
  private void b()
  {
    bbcl.a(2);
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    if (getIntent().getIntExtra("kSrouce", -1) == 8) {
      localIntent.putExtra("kSrouce", 8);
    }
    startActivityForResult(localIntent, 1);
  }
  
  public void a()
  {
    PhoneLaunchActivity.1 local1 = new PhoneLaunchActivity.1(this);
    DenyRunnable localDenyRunnable = new DenyRunnable(this, new agkp(this));
    anec.a(this, this.app, local1, localDenyRunnable);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1) {
      if (paramInt2 != 0)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    }
    while ((paramInt2 != 2) || (!this.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c())) {
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    boolean bool = getIntent().hasExtra("needAlert");
    this.jdField_a_of_type_Boolean = getIntent().getBooleanExtra("fromStopAndMatch", false);
    this.b = getIntent().getBooleanExtra("fromCall", false);
    this.c = getIntent().getBooleanExtra("fromPermiPriv", false);
    this.d = getIntent().getBooleanExtra("fromAVCallInvite", false);
    this.e = getIntent().getBooleanExtra("returnAndFinish", false);
    if ((!bool) && (paramBundle == null))
    {
      finish();
      return false;
    }
    if (!this.jdField_a_of_type_Boolean) {
      if (getIntent().getStringExtra("leftViewText") == null) {
        getIntent().putExtra("leftViewText", ajyc.a(2131708005));
      }
    }
    for (;;)
    {
      setContentView(2131559374);
      setTitle(ajyc.a(2131708001));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131371425));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      if (getIntent().getBooleanExtra("k_start_number", false)) {
        b();
      }
      return true;
      getIntent().putExtra("leftViewText", ajyc.a(2131708007));
    }
  }
  
  public void finish()
  {
    super.finish();
    if (!this.jdField_a_of_type_Boolean) {
      overridePendingTransition(2130771990, 2130772280);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.jdField_a_of_type_AndroidWidgetButton)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
      if ((i == 1) || (i == 2) || (i == 3) || (i == 4)) {
        b();
      }
      for (;;)
      {
        if (this.d) {
          axqw.b(this.app, "CliOper", "", "", "0X8005D10", "0X8005D10", 0, 0, "", "", "", "");
        }
        return;
        if (i == 5)
        {
          paramView = new Intent(this, BindNumberFromPcActivity.class);
          paramView.putExtra("key_is_first_activity", false);
          startActivityForResult(paramView, 1);
        }
        else if (i == 7)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
          a();
        }
        else
        {
          a(ajyc.a(2131708003), ajyc.a(2131708002));
        }
      }
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity
 * JD-Core Version:    0.7.0.1
 */