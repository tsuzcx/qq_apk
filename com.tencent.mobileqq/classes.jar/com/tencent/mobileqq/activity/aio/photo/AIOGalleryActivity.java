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
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractGalleryScene;
import com.tencent.common.galleryactivity.GalleryManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.QQLiveImage;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreview;
import com.tencent.mobileqq.richmedia.dc.DCAIOPreviewProgressive;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.CaptureContext;

public class AIOGalleryActivity
  extends PeakActivity
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  GalleryManager jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = new AIOGalleryActivity.AIOGalleryManager(this);
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  DCAIOPreview jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  DCAIOPreviewProgressive jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 1;
  BroadcastReceiver jdField_b_of_type_AndroidContentBroadcastReceiver = null;
  public boolean b;
  boolean c = true;
  boolean d = false;
  
  public AIOGalleryActivity()
  {
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public DCAIOPreview a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview;
  }
  
  public DCAIOPreviewProgressive a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive == null) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive;
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
    AbstractGalleryScene localAbstractGalleryScene = this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    if (AIOGalleryScene.class.isInstance(localAbstractGalleryScene)) {
      ((AIOGalleryScene)localAbstractGalleryScene).d();
    }
    QQLiveImage.releaseAll(this);
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b()) {
      super.onBackPressed();
    }
    QQLiveImage.releaseAll(this);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
    AIOConstants.a = getResources().getDisplayMetrics().density;
    ShortVideoUtils.loadShortVideoSo(CaptureContext.a());
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview = new DCAIOPreview(this);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive = new DCAIOPreviewProgressive(this);
    paramBundle = getIntent().getExtras();
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("extra.GROUP_UIN");
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("extra.IS_FROM_CHAT_FILE_HISTORY");
    try
    {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(this);
      this.jdField_b_of_type_AndroidContentBroadcastReceiver = new AIOGalleryActivity.1(this);
      paramBundle = new IntentFilter();
      paramBundle.addAction("tencent.av.v2q.StartVideoChat");
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        try
        {
          registerReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver, paramBundle);
          return;
        }
        catch (Exception paramBundle)
        {
          paramBundle.printStackTrace();
        }
        paramBundle = paramBundle;
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryActivity", 2, "", paramBundle);
        }
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryActivity", 2, "onDestroy()");
    }
    super.onDestroy();
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c(this);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider != null) {}
    try
    {
      if ((!this.jdField_b_of_type_Boolean) && (!getIntent().getBooleanExtra("extra.IS_STARTING_CHAT_FILE_HISTORY", false))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a();
      }
      for (;;)
      {
        label62:
        if (this.jdField_b_of_type_AndroidContentBroadcastReceiver != null)
        {
          unregisterReceiver(this.jdField_b_of_type_AndroidContentBroadcastReceiver);
          this.jdField_b_of_type_AndroidContentBroadcastReceiver = null;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.b(this.jdField_a_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreview.a();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive != null) {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaDcDCAIOPreviewProgressive.a();
        }
        this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
        QQLiveImage.releaseAll(this);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.c();
      }
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a(paramInt, paramKeyEvent)) {
      return super.onKeyDown(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  public void onPause()
  {
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), false);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true, 52);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, true);
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    QQLiveImage.pauseAll(this);
    super.onPause();
    if ((Build.MODEL.equals("Coolpad 5930")) && (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null)) {}
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryActivity", 2, localException.getMessage());
        }
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    SmallScreenUtils.a(BaseApplicationImpl.getContext(), true);
    ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false, 52);
    ColorNoteSmallScreenUtil.a(BaseApplicationImpl.getContext(), 2, false);
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = 0;
    AbstractGifImage.resumeAll();
    ApngImage.playByTag(0);
    QQLiveImage.resumeAll(this);
    if (Build.MODEL.equals("Coolpad 5930"))
    {
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = new AIOGalleryActivity.ScreenBroadcastReceiver(this);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
      localIntentFilter.addAction("android.intent.action.SCREEN_ON");
      localIntentFilter.addAction("android.intent.action.USER_PRESENT");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    }
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.c();
  }
  
  public void onStart()
  {
    super.onStart();
    QQLiveImage.onForeground(this);
  }
  
  public void onStop()
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
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity
 * JD-Core Version:    0.7.0.1
 */