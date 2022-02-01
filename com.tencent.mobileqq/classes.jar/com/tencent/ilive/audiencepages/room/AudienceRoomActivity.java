package com.tencent.ilive.audiencepages.room;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkEventInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.qqsdk.QQSdkInterface;
import com.tencent.falco.base.libapi.weibosdk.WeiboSdkInterface;
import com.tencent.falco.base.libapi.wns.WnsInterface;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.EnterRoomConfig;
import com.tencent.ilive.LiveAudience;
import com.tencent.ilive.base.page.PageFactory;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilivesdk.avplayerbuilderservice_interface.AVPlayerBuilderServiceInterface;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AudienceRoomActivity
  extends RoomLiveTemplateActivity
{
  private static final String TAG = "AudienceRoomActivity";
  private static long enterTime = 0L;
  private ActivityLifeCycleService mActivityLifeCycleService;
  private SdkEventInterface mSdkEventInterface;
  private AudienceRoomViewPager mViewPager = null;
  
  private LogInterface log()
  {
    return (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  }
  
  public static void startAudienceRoom(EnterRoomConfig paramEnterRoomConfig, Context paramContext)
  {
    Log.i("AudienceTime", "startEnter");
    if (System.currentTimeMillis() - enterTime <= 1000L)
    {
      Log.i("AudienceTime", "startEnter--reenter--return");
      return;
    }
    enterTime = System.currentTimeMillis();
    Intent localIntent = LiveAudience.getEnterRoomIntent(paramEnterRoomConfig);
    int j = 1;
    int i = j;
    if (paramEnterRoomConfig.extData != null)
    {
      String str = paramEnterRoomConfig.extData.getString("mqqschema");
      i = j;
      if (!TextUtils.isEmpty(str))
      {
        i = j;
        if (str.contains("nocleartop=1")) {
          i = 0;
        }
      }
    }
    if (i != 0) {
      localIntent.setFlags(335544320);
    }
    for (;;)
    {
      PageFactory.startActivity(localIntent, paramContext, LiveAudience.getPageType(paramEnterRoomConfig));
      return;
      localIntent.setFlags(268435456);
    }
  }
  
  protected LiveTemplateFragment createFragment(boolean paramBoolean)
  {
    return null;
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
    if (this.mViewPager != null) {
      this.mViewPager.finish();
    }
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onFinish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ((WeiboSdkInterface)BizEngineMgr.getInstance().getLiveEngine().getService(WeiboSdkInterface.class)).onWeiboResult(paramInt1, paramInt2, paramIntent);
    ((QQSdkInterface)BizEngineMgr.getInstance().getLiveEngine().getService(QQSdkInterface.class)).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if ((this.mSdkEventInterface != null) && (this.mSdkEventInterface.onBackPressed())) {}
    do
    {
      return;
      super.onBackPressed();
    } while (this.mViewPager == null);
    this.mViewPager.onBackPressed();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    log().i("AudienceTime", "activity--onCreate", new Object[0]);
    getWindow().addFlags(128);
    super.onCreate(paramBundle);
    if (BizEngineMgr.getInstance().getLiveEngine() == null)
    {
      log().e("AudienceRoomActivity", "-- live or room engine is null--", new Object[0]);
      finish();
      return;
    }
    if (!((WnsInterface)BizEngineMgr.getInstance().getLiveEngine().getService(WnsInterface.class)).isGlobalInitialized())
    {
      log().e("AudienceRoomActivity", "-- Wns Global Context is null --", new Object[0]);
      finish();
      return;
    }
    if (this.isNeedLandscape)
    {
      UIUtil.setFullscreen(this, false, false);
      UIUtil.setStatusBarColor(this, 0);
    }
    for (;;)
    {
      paramBundle = new ViewGroup.LayoutParams(-1, -1);
      this.mViewPager = ((AudienceRoomViewPager)LayoutInflater.from(this).inflate(2131559370, null).findViewById(2131363083));
      this.mViewPager.initRoomPageAction(new AudienceRoomActivity.1(this));
      this.mViewPager.setIntent(getIntent());
      this.mRootLayout.addView(this.mViewPager, paramBundle);
      this.mViewPager.onCreate();
      this.mSdkEventInterface = ((HostProxyInterface)BizEngineMgr.getInstance().getLiveEngine().getService(HostProxyInterface.class)).getSdkEventInterface();
      this.mActivityLifeCycleService = ((ActivityLifeCycleService)BizEngineMgr.getInstance().getLiveEngine().getService(ActivityLifeCycleService.class));
      if (this.mActivityLifeCycleService == null) {
        break;
      }
      this.mActivityLifeCycleService.onActivityCreated(this);
      return;
      getWindow().getDecorView().setSystemUiVisibility(5376);
      UIUtil.setStatusBarColor(this, 0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mViewPager != null) {
      this.mViewPager.onDestroy();
    }
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onActivityDestroyed();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    boolean bool = paramIntent.getBooleanExtra("open_from_float_window", false);
    this.mViewPager.setIntent(paramIntent);
    if (!bool) {
      this.mViewPager.onNewIntent(paramIntent);
    }
    setIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mViewPager != null) {
      this.mViewPager.onPause();
    }
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onActivityPaused();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if ((this.mViewPager != null) && (this.mViewPager.getCurrentFragment() != null)) {
      ((AVPlayerBuilderServiceInterface)((AudienceRoomFragment)this.mViewPager.getCurrentFragment()).getRoomEngine().getService(AVPlayerBuilderServiceInterface.class)).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.mViewPager != null) {
      this.mViewPager.onResume();
    }
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onActivityResumed();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.mViewPager != null) {
      this.mViewPager.onStart();
    }
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onActivityStarted();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.mViewPager != null) {
      this.mViewPager.onStop();
    }
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onActivityStopped();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.mActivityLifeCycleService != null) {
      this.mActivityLifeCycleService.onWindowFocusChanged(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomActivity
 * JD-Core Version:    0.7.0.1
 */