package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

@RoutePage(desc="安装", path="/base/install")
public class InstallActivity
  extends AppActivity
  implements Runnable
{
  public static final String NEXT_ACTIVITY = "NT_AY";
  boolean mSplashed = false;
  
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
    Intent localIntent = (Intent)getIntent().getParcelableExtra("NT_AY");
    paramBundle = localIntent;
    if (localIntent == null) {
      try
      {
        paramBundle = new Intent(this, Class.forName("com.tencent.mobileqq.activity.SplashActivity"));
        try
        {
          paramBundle.addFlags(67108864);
        }
        catch (ClassNotFoundException localClassNotFoundException1) {}
        Object localObject;
        localObject.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        paramBundle = localClassNotFoundException1;
        localObject = localClassNotFoundException2;
      }
    }
    try
    {
      startActivity(paramBundle);
      finish();
    }
    catch (Exception paramBundle)
    {
      label74:
      break label74;
    }
    System.exit(-1);
    return false;
  }
  
  protected void doOnDestroy()
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
  
  protected void onResume()
  {
    super.onResume();
    if (!this.mSplashed) {
      BaseApplicationImpl.sUiHandler.post(this);
    }
  }
  
  public void run()
  {
    if (this.mSplashed) {
      return;
    }
    this.mSplashed = true;
    BaseApplicationImpl.sApplication.getResources();
    SetSplash.a(this, null, true);
  }
  
  public boolean showPreview()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.InstallActivity
 * JD-Core Version:    0.7.0.1
 */