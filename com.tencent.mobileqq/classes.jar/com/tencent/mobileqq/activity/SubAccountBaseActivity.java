package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.MobileQQ;

public class SubAccountBaseActivity
  extends QIphoneTitleBarActivity
  implements DialogInterface.OnClickListener
{
  public AppInterface app;
  protected String fromWhere;
  private QQCustomDialog mDialog;
  private QQProgressDialog mJuhua;
  
  public void dimissDialog()
  {
    QQCustomDialog localQQCustomDialog = this.mDialog;
    if ((localQQCustomDialog != null) && (localQQCustomDialog.isShowing())) {}
    try
    {
      this.mDialog.dismiss();
      label23:
      this.mDialog = null;
      return;
    }
    catch (Exception localException)
    {
      break label23;
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
    this.app = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    this.fromWhere = getIntent().getStringExtra("fromWhere");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    ISubAccountControlService localISubAccountControlService = (ISubAccountControlService)this.app.getRuntimeService(ISubAccountControlService.class, null);
    if (localISubAccountControlService != null) {
      localISubAccountControlService.destoryHintDialog(this);
    }
  }
  
  public void finish()
  {
    hideJuhua();
    dimissDialog();
    super.finish();
  }
  
  public void hideJuhua()
  {
    QQProgressDialog localQQProgressDialog = this.mJuhua;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {}
    try
    {
      this.mJuhua.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean isNetConn()
  {
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  public boolean isNetConnToast()
  {
    boolean bool = isNetConn();
    if (!bool) {
      showQQToast(getString(2131692183));
    }
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
    onDialogCancel();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDialogCancel() {}
  
  public void showJuhua(int paramInt)
  {
    if (this.mJuhua == null)
    {
      this.mJuhua = new QQProgressDialog(this, getTitleBarHeight());
      this.mJuhua.c(true);
    }
    if (paramInt > 0) {
      this.mJuhua.c(paramInt);
    } else {
      this.mJuhua.c(2131694668);
    }
    QQProgressDialog localQQProgressDialog = this.mJuhua;
    if ((localQQProgressDialog != null) && (!localQQProgressDialog.isShowing()) && (!isFinishing())) {
      this.mJuhua.show();
    }
  }
  
  public void showQQCustomDialog(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    dimissDialog();
    this.mDialog = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.mDialog.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setNegativeButton(2131690728, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  public void showQQCustomDialogOneBtn(String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject = paramOnClickListener;
    if (paramOnClickListener == null) {
      localObject = this;
    }
    dimissDialog();
    this.mDialog = DialogUtil.a(this, 230).setTitle(paramString1).setMessage(paramString2);
    this.mDialog.setPositiveButton(2131691064, (DialogInterface.OnClickListener)localObject);
    this.mDialog.setCancelable(false);
    this.mDialog.show();
  }
  
  public void showQQToast(String paramString)
  {
    QQToast.a(this, paramString, 0).b(getTitleBarHeight());
  }
  
  public void showQQToastSuccess(String paramString)
  {
    QQToast.a(this, 2, paramString, 0).b(getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountBaseActivity
 * JD-Core Version:    0.7.0.1
 */