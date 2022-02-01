package com.tencent.mobileqq.activity;

import Override;
import aevg;
import aevh;
import aevi;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import axws;
import bhgq;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class LbsBaseActivity
  extends IphoneTitleBarActivity
{
  private Dialog a;
  private Dialog b;
  private Dialog c;
  
  private boolean a()
  {
    return axws.a(getAppInterface().getAccount());
  }
  
  private void c(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  private void d(Runnable paramRunnable)
  {
    paramRunnable = new aevg(this, paramRunnable);
    this.b = bhgq.a(this, 2131691781, a(), 2131691642, 2131691639, new aevh(this), new aevi(this));
    this.b.setOnDismissListener(paramRunnable);
    this.b.show();
  }
  
  protected int a()
  {
    return 2131691779;
  }
  
  public void a()
  {
    finish();
  }
  
  public void a(int paramInt, String paramString)
  {
    if (isResume()) {
      QQToast.a(this, paramInt, paramString, 0).b(getTitleBarHeight());
    }
  }
  
  /* Error */
  public void a(Dialog paramDialog)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 102	android/app/Dialog:dismiss	()V
    //   4: aload_1
    //   5: invokestatic 106	adkm:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_2
    //   10: aload_1
    //   11: invokestatic 106	adkm:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_2
    //   16: aload_1
    //   17: invokestatic 106	adkm:a	(Landroid/app/Dialog;)V
    //   20: aload_2
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	LbsBaseActivity
    //   0	22	1	paramDialog	Dialog
    //   9	1	2	localException	java.lang.Exception
    //   15	6	2	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  protected void a(Runnable paramRunnable)
  {
    c(paramRunnable);
  }
  
  protected void b(Runnable paramRunnable)
  {
    if (a())
    {
      c(paramRunnable);
      return;
    }
    d(paramRunnable);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      a(this.a);
    }
    if ((this.b != null) && (this.b.isShowing())) {
      a(this.b);
    }
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LbsBaseActivity
 * JD-Core Version:    0.7.0.1
 */