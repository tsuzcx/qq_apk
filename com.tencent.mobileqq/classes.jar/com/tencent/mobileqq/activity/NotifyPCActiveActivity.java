package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class NotifyPCActiveActivity
  extends BaseActivity
{
  public static NotifyPCActiveActivity a;
  private QQCustomDialog b = null;
  private int c;
  private CardObserver d = new NotifyPCActiveActivity.4(this);
  
  private void a()
  {
    ConfigHandler localConfigHandler = (ConfigHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER);
    if (localConfigHandler != null) {
      localConfigHandler.c();
    }
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = this.b;
    if ((localObject1 != null) && (((QQCustomDialog)localObject1).isShowing())) {
      this.b.dismiss();
    }
    this.b = null;
    Object localObject2;
    if (paramInt != 1)
    {
      if (paramInt == 2)
      {
        localObject2 = getIntent().getExtras();
        localObject1 = ((Bundle)localObject2).getString("Message");
        localObject2 = ((Bundle)localObject2).getString("button");
        this.b = DialogUtil.a(this, 230).setMessage((CharSequence)localObject1).setPositiveButton((String)localObject2, new NotifyPCActiveActivity.3(this));
      }
    }
    else
    {
      this.app.addObserver(this.d, true);
      localObject1 = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      Object localObject3 = getIntent().getExtras();
      localObject2 = ((Bundle)localObject3).getString("Message");
      String str = ((Bundle)localObject3).getString("lButton");
      localObject3 = ((Bundle)localObject3).getString("rButton");
      this.b = DialogUtil.a(this, 230);
      this.b.setContentView(2131624587);
      this.b.setTitle(null).setMessage((CharSequence)localObject2).setPositiveButton((String)localObject3, new NotifyPCActiveActivity.2(this, (CardHandler)localObject1)).setNegativeButton(str, new NotifyPCActiveActivity.1(this));
    }
    localObject1 = this.b;
    if (localObject1 != null)
    {
      ((QQCustomDialog)localObject1).setCancelable(false);
      this.b.show();
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131625527);
    a = this;
    this.c = getIntent().getIntExtra("type", 0);
    paramBundle = getIntent().getAction();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NotificationActivity action = ");
      localStringBuilder.append(paramBundle);
      QLog.d("NotificationActivity", 2, localStringBuilder.toString());
    }
    if ("mqq.intent.action.PCACTIVE_TIPS".equals(paramBundle))
    {
      ReportController.b(null, "CliOper", "", "", "0X8004975", "0X8004975", 0, 0, "", "", "", "");
      this.c = 1;
      a();
    }
    else if ("mqq.intent.action.NOTICE_ON_PCACTIVE".equals(paramBundle))
    {
      this.c = 2;
    }
    a(this.c);
    return false;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.d);
    super.doOnDestroy();
    if (a != null) {
      a = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NotifyPCActiveActivity", 2, "Running in doOnDestroy()");
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
  }
  
  protected void doOnStop()
  {
    super.doOnStop();
  }
  
  protected void doOnUserLeaveHint()
  {
    super.doOnUserLeaveHint();
  }
  
  public void finish()
  {
    QQCustomDialog localQQCustomDialog = this.b;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {
      this.b.dismiss();
    }
    this.b = null;
    super.finish();
    a = null;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity
 * JD-Core Version:    0.7.0.1
 */