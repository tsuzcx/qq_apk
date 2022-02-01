package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RegisterBaseActivity
  extends QIphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  protected String a = "86";
  protected boolean b = false;
  protected boolean c = true;
  protected Handler d = new RegisterBaseActivity.1(this);
  protected Dialog e;
  
  protected void a()
  {
    this.d.post(new RegisterBaseActivity.3(this));
  }
  
  protected void a(String paramString, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      new QQToastNotifier(this).notifyUser(str, getTitleBarHeight(), 0, paramInt);
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
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramDialogInterface.dismiss();
      return;
    }
    paramDialogInterface.dismiss();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity
 * JD-Core Version:    0.7.0.1
 */