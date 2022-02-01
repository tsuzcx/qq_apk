package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class ForwardRecentTranslucentActivity
  extends ForwardRecentActivity
{
  protected boolean a(Bundle paramBundle)
  {
    boolean bool = super.a(paramBundle);
    if ((g == this.e) && ((this.a == null) || (this.a.isEmpty())))
    {
      setResult(-1);
      finish();
    }
    return bool;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.e = getIntent().getIntExtra("key_req", -1);
    if (g == this.e)
    {
      getWindow().addFlags(24);
      ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("PARAM_ActivityResultReceiver");
      if (localResultReceiver != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_req", ForwardRecentActivity.g);
        localBundle.putParcelable("receiver", new ForwardRecentTranslucentActivity.1(this, new Handler(Looper.getMainLooper())));
        localResultReceiver.send(100, localBundle);
      }
    }
    return super.doOnCreate(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void requestWindowFeature(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity
 * JD-Core Version:    0.7.0.1
 */