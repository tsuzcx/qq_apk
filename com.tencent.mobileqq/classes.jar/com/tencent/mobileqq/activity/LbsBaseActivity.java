package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;

public class LbsBaseActivity
  extends IphoneTitleBarActivity
{
  protected static final int REQUEST_GPS = 10;
  private Dialog cleDialog;
  private Dialog entDialog;
  private Dialog gpsDialog;
  
  private void checkGPS(Runnable paramRunnable)
  {
    if (!checkGPS())
    {
      showGpsDialog(paramRunnable);
      return;
    }
    paramRunnable.run();
  }
  
  private boolean checkGPS()
  {
    Object localObject = (LocationManager)getAppInterface().getApp().getSystemService("location");
    try
    {
      bool = ((LocationManager)localObject).isProviderEnabled("gps");
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      label26:
      break label26;
    }
    bool = false;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GPS Open ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("LBS", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  private void checkGPSAndTelecom(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  private boolean isLbsEnabled()
  {
    return ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).isObtainLocAllowed(getAppInterface().getAccount());
  }
  
  private void showEnableLbsDialog(Runnable paramRunnable)
  {
    paramRunnable = new LbsBaseActivity.4(this, paramRunnable);
    this.entDialog = CustomDialogFactory.a(this, 2131888929, getContentTipsForEnableLbs(), 2131888773, 2131888770, new LbsBaseActivity.5(this), new LbsBaseActivity.6(this));
    this.entDialog.setOnDismissListener(paramRunnable);
    this.entDialog.show();
  }
  
  private void showGpsDialog(Runnable paramRunnable)
  {
    if (this.gpsDialog == null)
    {
      this.gpsDialog = CustomDialogFactory.a(this, 17039380, 2131890108, 2131915650, 2131888770, new LbsBaseActivity.1(this), new LbsBaseActivity.2(this));
      this.gpsDialog.setOnDismissListener(new LbsBaseActivity.3(this, paramRunnable));
    }
    notifyShowLbsEnableDlg();
    this.gpsDialog.show();
  }
  
  protected void checkAndEnableLbs(Runnable paramRunnable)
  {
    if (isLbsEnabled())
    {
      checkGPSAndTelecom(paramRunnable);
      return;
    }
    showEnableLbsDialog(paramRunnable);
  }
  
  protected void checkLbs(Runnable paramRunnable)
  {
    if (isLbsEnabled()) {
      checkGPSAndTelecom(paramRunnable);
    }
  }
  
  protected void checkLbsOnlySystemSwitch(Runnable paramRunnable)
  {
    checkGPSAndTelecom(paramRunnable);
  }
  
  /* Error */
  public void dialogDismiss(Dialog paramDialog)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 177	android/app/Dialog:dismiss	()V
    //   4: aload_1
    //   5: invokestatic 181	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 181	com/tencent/qqperf/monitor/memory/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: aload_2
    //   15: athrow
    //   16: astore_2
    //   17: goto -13 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	20	0	this	LbsBaseActivity
    //   0	20	1	paramDialog	Dialog
    //   9	6	2	localObject	Object
    //   16	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	9	finally
    //   0	4	16	java/lang/Exception
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
    return true;
  }
  
  protected void doOnDestroy()
  {
    Dialog localDialog = this.gpsDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      dialogDismiss(this.gpsDialog);
    }
    localDialog = this.entDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      dialogDismiss(this.entDialog);
    }
    localDialog = this.cleDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      this.cleDialog.dismiss();
    }
    super.doOnDestroy();
  }
  
  protected int getContentTipsForEnableLbs()
  {
    return 2131888927;
  }
  
  protected int getTitleBarBottom()
  {
    try
    {
      int i = ((Integer)Class.forName("com.android.internal.R$id").getField("title_container").get(null)).intValue();
      i = ((ViewGroup)getWindow().findViewById(i)).getBottom();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  protected void notifyShowLbsEnableDlg() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onDisableClick() {}
  
  protected void onEnableClick() {}
  
  protected void onLBSForbidden()
  {
    finish();
  }
  
  protected void showToast(int paramInt1, int paramInt2)
  {
    if (isResume()) {
      QQToast.makeText(this, paramInt1, getResources().getString(paramInt2), 0).show(getTitleBarHeight());
    }
  }
  
  protected void showToast(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.makeText(this, paramInt, paramString, 0).show(getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity
 * JD-Core Version:    0.7.0.1
 */