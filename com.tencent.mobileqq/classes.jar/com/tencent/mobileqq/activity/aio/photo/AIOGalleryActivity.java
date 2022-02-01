package com.tencent.mobileqq.activity.aio.photo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AIOGalleryActivity
  extends PeakActivity
{
  private TroopMemberApiClient B;
  GalleryManager a = new AIOGalleryActivity.AIOGalleryManager(this);
  IAIOImageProvider b;
  BroadcastReceiver c = null;
  BroadcastReceiver d = null;
  DCAIOPreview e;
  DCAIOPreviewProgressive f;
  boolean g = false;
  int h;
  public String i = null;
  public boolean j = false;
  boolean k = true;
  int l = 1;
  long m = -1L;
  boolean n = false;
  
  public DCAIOPreview b()
  {
    if (this.e == null) {
      this.e = new DCAIOPreview(this);
    }
    return this.e;
  }
  
  protected boolean cd_()
  {
    return false;
  }
  
  public DCAIOPreviewProgressive d()
  {
    if (this.f == null) {
      this.f = new DCAIOPreviewProgressive(this);
    }
    return this.f;
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
    AbstractGalleryScene localAbstractGalleryScene = this.a.c();
    if (AIOGalleryScene.class.isInstance(localAbstractGalleryScene)) {
      ((AIOGalleryScene)localAbstractGalleryScene).f();
    }
    QQLiveImage.releaseAll(this);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.a.i()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.a.a(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.z = false;
    super.onCreate(paramBundle);
    this.B = TroopMemberApiClient.a();
    this.B.e();
    AIOConstants.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    this.e = new DCAIOPreview(this);
    this.f = new DCAIOPreviewProgressive(this);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.i = paramBundle.getString("extra.GROUP_UIN");
      this.j = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    }
    try
    {
      this.a.b(this);
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AIOGalleryActivity", 2, "", paramBundle);
      }
      finish();
    }
    this.d = new AIOGalleryActivity.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    try
    {
      registerReceiver(this.d, paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  protected void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onDestroy()");
    }
    super.onDestroy();
    this.a.d(this);
    if (this.b != null) {}
    try
    {
      if ((!this.j) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.b.a();
      } else {
        this.b.c();
      }
    }
    catch (Exception localException)
    {
      label79:
      Object localObject;
      break label79;
    }
    localObject = this.d;
    if (localObject != null)
    {
      unregisterReceiver((BroadcastReceiver)localObject);
      this.d = null;
    }
    localObject = this.e;
    if (localObject != null)
    {
      ((DCAIOPreview)localObject).a(this.h);
      this.e.a();
    }
    localObject = this.f;
    if (localObject != null) {
      ((DCAIOPreviewProgressive)localObject).a();
    }
    this.B.f();
    QQLiveImage.releaseAll(this);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.a.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onPause()
  {
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 52);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(this);
    super.onPause();
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      BroadcastReceiver localBroadcastReceiver = this.c;
      if (localBroadcastReceiver != null) {
        try
        {
          unregisterReceiver(localBroadcastReceiver);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOGalleryActivity", 2, localException.getMessage());
          }
        }
      }
    }
    this.a.j();
  }
  
  protected void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 52);
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll(this);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.c = new AIOGalleryActivity.ScreenBroadcastReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.c, localIntentFilter);
    }
    this.a.k();
  }
  
  protected void onStart()
  {
    super.onStart();
    QQLiveImage.onForeground(this);
  }
  
  protected void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onStop()");
    }
    super.onStop();
    ((AudioManager)getSystemService("audio")).abandonAudioFocus(null);
    QQLiveImage.onBackground(this);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean) {
      this.a.c(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */