package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PhoneUnityPhoneLoginActivity
  extends IphoneTitleBarActivity
  implements CompoundButton.OnCheckedChangeListener
{
  private FormSwitchItem a;
  private byte[] b;
  private SecSvcObserver c = new PhoneUnityPhoneLoginActivity.1(this);
  
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
    super.setContentView(2131627633);
    setTitle(getString(2131892457));
    setContentBackgroundResource(2130838958);
    this.leftView.setText(2131897269);
    this.a = ((FormSwitchItem)super.findViewById(2131440038));
    paramBundle = this.a;
    if (paramBundle != null) {
      paramBundle.setOnCheckedChangeListener(this);
    }
    addObserver(this.c);
    paramBundle = super.getIntent();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getExtras();
      if (paramBundle != null) {
        this.b = paramBundle.getByteArray("phone_num_login_sig");
      }
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.c);
    super.doOnDestroy();
  }
  
  protected boolean onBackEvent()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("phone_num_login_result", this.a.a());
    super.setResult(-1, localIntent);
    super.finish();
    return false;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton == this.a.getSwitch())
    {
      this.a.setOnCheckedChangeListener(null);
      Object localObject = this.a;
      ((FormSwitchItem)localObject).setChecked(((FormSwitchItem)localObject).a() ^ true);
      this.a.setOnCheckedChangeListener(this);
      if (!NetworkUtil.isNetSupport(this))
      {
        QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
      }
      else
      {
        localObject = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        if (localObject != null)
        {
          byte[] arrayOfByte = this.b;
          if (arrayOfByte != null) {
            if (paramBoolean) {
              ((SecSvcHandler)localObject).a(arrayOfByte);
            } else {
              ((SecSvcHandler)localObject).b(arrayOfByte);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PhoneUnityPhoneLoginActivity
 * JD-Core Version:    0.7.0.1
 */