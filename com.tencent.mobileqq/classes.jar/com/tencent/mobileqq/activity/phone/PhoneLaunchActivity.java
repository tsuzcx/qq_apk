package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneLaunchActivity
  extends DialogBaseActivity
  implements View.OnClickListener
{
  public ContactBindObserver a;
  private Button b;
  private boolean c = false;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  
  private void b()
  {
    ContactUtils.d(2);
    Intent localIntent = new Intent(this, BindNumberActivity.class);
    if (getIntent().getIntExtra("kSrouce", -1) == 8) {
      localIntent.putExtra("kSrouce", 8);
    }
    startActivityForResult(localIntent, 1);
  }
  
  public void a()
  {
    PermissionChecker.a(this, new PhoneLaunchActivity.1(this), new DenyRunnable(this, new PhoneLaunchActivity.2(this)));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 != 0)
      {
        setResult(paramInt2, paramIntent);
        finish();
      }
    }
    else if ((paramInt2 == 2) && (this.c) && (this.mPhoneContactService.isBindContactOk())) {
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    getIntent().putExtra("fling_action_key", 0);
    super.doOnCreate(paramBundle);
    boolean bool = getIntent().hasExtra("needAlert");
    this.c = getIntent().getBooleanExtra("fromStopAndMatch", false);
    this.d = getIntent().getBooleanExtra("fromCall", false);
    this.e = getIntent().getBooleanExtra("fromPermiPriv", false);
    this.f = getIntent().getBooleanExtra("fromAVCallInvite", false);
    this.g = getIntent().getBooleanExtra("returnAndFinish", false);
    if ((!bool) && (paramBundle == null))
    {
      finish();
      return false;
    }
    if (!this.c)
    {
      if (getIntent().getStringExtra("leftViewText") == null) {
        getIntent().putExtra("leftViewText", HardCodeUtil.a(2131905820));
      }
    }
    else {
      getIntent().putExtra("leftViewText", HardCodeUtil.a(2131905822));
    }
    setContentView(2131625570);
    setTitle(HardCodeUtil.a(2131905816));
    this.b = ((Button)findViewById(2131440033));
    this.b.setOnClickListener(this);
    if (getIntent().getBooleanExtra("k_start_number", false)) {
      b();
    }
    return true;
  }
  
  public void finish()
  {
    super.finish();
    if (!this.c) {
      overridePendingTransition(2130772007, 2130772436);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.b)
    {
      int i = this.mPhoneContactService.getSelfBindState();
      if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
      {
        if (i == 5)
        {
          Intent localIntent = new Intent(this, BindNumberFromPcActivity.class);
          localIntent.putExtra("key_is_first_activity", false);
          startActivityForResult(localIntent, 1);
        }
        else if (i == 7)
        {
          this.b.setEnabled(false);
          a();
        }
        else
        {
          showConfirmFinish(HardCodeUtil.a(2131905818), HardCodeUtil.a(2131905817));
        }
      }
      else {
        b();
      }
      if (this.f) {
        ReportController.b(this.app, "CliOper", "", "", "0X8005D10", "0X8005D10", 0, 0, "", "", "", "");
      }
    }
    else
    {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneLaunchActivity
 * JD-Core Version:    0.7.0.1
 */