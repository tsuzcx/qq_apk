package com.tencent.mobileqq.activity;

import Override;
import android.content.res.Configuration;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class InstallActivity
  extends AppActivity
  implements Runnable
{
  boolean a = false;
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  /* Error */
  public boolean doOnCreate(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 39	mqq/app/AppActivity:doOnCreate	(Landroid/os/Bundle;)Z
    //   5: pop
    //   6: aload_0
    //   7: invokevirtual 43	com/tencent/mobileqq/activity/InstallActivity:getIntent	()Landroid/content/Intent;
    //   10: ldc 45
    //   12: invokevirtual 51	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   15: checkcast 47	android/content/Intent
    //   18: astore_2
    //   19: aload_2
    //   20: ifnonnull +59 -> 79
    //   23: new 47	android/content/Intent
    //   26: dup
    //   27: aload_0
    //   28: ldc 53
    //   30: invokestatic 59	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   33: invokespecial 62	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   36: astore_1
    //   37: aload_1
    //   38: ldc 63
    //   40: invokevirtual 67	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   43: pop
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 71	com/tencent/mobileqq/activity/InstallActivity:startActivity	(Landroid/content/Intent;)V
    //   49: aload_0
    //   50: invokevirtual 74	com/tencent/mobileqq/activity/InstallActivity:finish	()V
    //   53: iconst_0
    //   54: ireturn
    //   55: astore_3
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: astore_2
    //   60: aload_2
    //   61: invokevirtual 77	java/lang/ClassNotFoundException:printStackTrace	()V
    //   64: goto -20 -> 44
    //   67: astore_1
    //   68: iconst_m1
    //   69: invokestatic 83	java/lang/System:exit	(I)V
    //   72: goto -19 -> 53
    //   75: astore_2
    //   76: goto -16 -> 60
    //   79: aload_2
    //   80: astore_1
    //   81: goto -37 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	InstallActivity
    //   0	84	1	paramBundle	android.os.Bundle
    //   18	43	2	localObject	java.lang.Object
    //   75	5	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   55	4	3	localClassNotFoundException2	java.lang.ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   23	37	55	java/lang/ClassNotFoundException
    //   44	53	67	java/lang/Exception
    //   37	44	75	java/lang/ClassNotFoundException
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    try
    {
      setContentView(new LinearLayout(this));
      label16:
      this.mRuntime = null;
      return;
    }
    catch (Exception localException)
    {
      break label16;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.a) {
      BaseApplicationImpl.sUiHandler.post(this);
    }
  }
  
  public void run()
  {
    if (this.a) {
      return;
    }
    this.a = true;
    BaseApplicationImpl.sApplication.getResources();
    SetSplash.a(this, null, true);
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InstallActivity
 * JD-Core Version:    0.7.0.1
 */