package com.tencent.ilive.audiencepages.room;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.Nullable;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.LiveAudience;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MultiAudienceRoomActivity
  extends AudienceRoomActivity
  implements AudienceMultiRoomActivityLogic.OnMultiRoomOperateListener
{
  public static void a(EnterRoomConfig paramEnterRoomConfig, Context paramContext)
  {
    Log.i("AudienceTime", "startEnter");
    if (System.currentTimeMillis() - enterTime <= 1000L)
    {
      Log.i("AudienceTime", "startEnter--reenter--return");
      return;
    }
    enterTime = System.currentTimeMillis();
    paramEnterRoomConfig = LiveAudience.getEnterRoomIntent(paramEnterRoomConfig);
    paramEnterRoomConfig.setFlags(268435456);
    paramEnterRoomConfig.setClass(paramContext, MultiAudienceRoomActivity.class);
    paramContext.startActivity(paramEnterRoomConfig);
  }
  
  private void d()
  {
    AudienceMultiRoomActivityLogic.a().b(this);
  }
  
  public void a()
  {
    if ((this.mViewPager != null) && (this.mViewPager.getParent() == null)) {
      addContentView(this.mViewPager, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  public void b()
  {
    if ((this.mViewPager != null) && ((this.mViewPager.getParent() instanceof ViewGroup))) {
      ((ViewGroup)this.mViewPager.getParent()).removeView(this.mViewPager);
    }
  }
  
  public void c()
  {
    onBackPressed();
    d();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    super.finish();
    d();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    d();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (isFinishing())
    {
      d();
      AudienceMultiRoomActivityLogic.a().c();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    a();
    AudienceMultiRoomActivityLogic.a().a(this);
    AudienceMultiRoomActivityLogic.a().a(getIntent());
  }
  
  protected void onStop()
  {
    super.onStop();
    if (AudienceMultiRoomActivityLogic.a().c(this))
    {
      AudienceMultiRoomActivityLogic.a().d();
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.MultiAudienceRoomActivity
 * JD-Core Version:    0.7.0.1
 */