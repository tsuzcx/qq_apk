package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToastNotifier;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class RegisterBaseActivity
  extends QIphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  public static final int ACT_CAPTCHA_SIG = 104;
  public static final int ACT_FINISH_CHOOSE_ACT = 105;
  public static final int ACT_FINISH_PHONE_NUM = 103;
  public static final int ACT_SEND_SMS = 102;
  public static final int ACT_SHOW_TOAST = 101;
  public static final int REQUEST_CODE_LEFT_TIME = 2;
  protected String countryCode = "86";
  protected Dialog dialog;
  protected Handler handler = new RegisterBaseActivity.1(this);
  protected ViewGroup mContextView;
  private QQCustomDialog mDialog;
  protected boolean mHasPwd = true;
  protected boolean mIsPhoneNumRegistered = false;
  protected String phoneNum;
  
  protected void closeDialog()
  {
    this.handler.post(new RegisterBaseActivity.3(this));
  }
  
  protected void createWaitingDialog(int paramInt)
  {
    try
    {
      this.handler.post(new RegisterBaseActivity.4(this, paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void dimissDialog()
  {
    if ((this.mDialog != null) && (this.mDialog.isShowing()))
    {
      this.mDialog.dismiss();
      this.mDialog = null;
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
  
  protected void notifyToast(int paramInt1, int paramInt2)
  {
    new QQToastNotifier(this).a(paramInt1, getTitleBarHeight(), 1, paramInt2);
  }
  
  protected void notifyToast(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return;
    }
    String str = paramString;
    if (paramString.endsWith("\n")) {
      str = paramString.substring(0, paramString.length() - 1);
    }
    new QQToastNotifier(this).a(str, getTitleBarHeight(), 0, paramInt);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
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
  
  void showDialog(String paramString1, String paramString2)
  {
    try
    {
      this.handler.post(new RegisterBaseActivity.2(this, paramString1, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void showQQCustomDialog(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    dimissDialog();
    this.mDialog = DialogUtil.a(getActivity(), 230).setTitle(paramString1).setMessage(paramString2);
    this.mDialog.setPositiveButton(2131718523, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  public void showQQCustomDialogOneBtn(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    dimissDialog();
    this.mDialog = DialogUtil.a(getActivity(), 230).setTitle(paramString1).setMessage(paramString2);
    this.mDialog.setPositiveButton(paramString3, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterBaseActivity
 * JD-Core Version:    0.7.0.1
 */