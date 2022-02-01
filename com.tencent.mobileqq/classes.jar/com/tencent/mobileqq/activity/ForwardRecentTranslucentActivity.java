package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.MotionEvent;
import android.view.Window;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

@RoutePage(desc="选人透明页面", path="/base/forwardRecentTrans")
public class ForwardRecentTranslucentActivity
  extends ForwardRecentActivity
{
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
    this.mReq = getIntent().getIntExtra("key_req", -1);
    if (2 == this.mReq)
    {
      getWindow().addFlags(24);
      ResultReceiver localResultReceiver = (ResultReceiver)getIntent().getParcelableExtra("PARAM_ActivityResultReceiver");
      if (localResultReceiver != null)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_req", 2);
        localBundle.putParcelable("receiver", new ForwardRecentTranslucentActivity.1(this, new Handler(Looper.getMainLooper())));
        localResultReceiver.send(100, localBundle);
      }
    }
    return super.doOnCreate(paramBundle);
  }
  
  protected boolean doOnCreate_init(Bundle paramBundle)
  {
    boolean bool = super.doOnCreate_init(paramBundle);
    if ((2 == this.mReq) && ((this.forwardlist == null) || (this.forwardlist.isEmpty())))
    {
      setResult(-1);
      finish();
    }
    return bool;
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
  
  protected void requestWindowFeature(Intent paramIntent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity
 * JD-Core Version:    0.7.0.1
 */