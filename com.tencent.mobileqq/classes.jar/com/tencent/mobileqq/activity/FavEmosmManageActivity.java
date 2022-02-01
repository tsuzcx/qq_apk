package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.emogroupstore.ISDKEmotionSettingManager;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.emosm.BaseEmosmStrategy;
import com.tencent.mobileqq.emosm.EmosmStrategyFactory;
import com.tencent.mobileqq.emosm.FavEmosmViewPage;
import com.tencent.mobileqq.emosm.FavEmosmViewPage.IEmosmViewPagerListener;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.MobileQQ;

@RoutePage(desc="收藏/自拍表情管理页", path="/base/activity/FavEmosmManageActivity")
public class FavEmosmManageActivity
  extends QIphoneTitleBarActivity
  implements FavEmosmViewPage.IEmosmViewPagerListener
{
  public static final String TAG = "FavEmosmManageActivity";
  private BaseQQAppInterface app;
  private BaseEmosmStrategy emosmStrategy;
  private FavEmosmViewPage favEmosmView;
  BroadcastReceiver mFunnyPicUpdateReceiver = new FavEmosmManageActivity.1(this);
  private ISDKEmotionSettingManager sdkEmotionSettingManager;
  
  private void sdkSetEmotion()
  {
    Intent localIntent = getIntent();
    if (localIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavEmosmManageActivity", 2, "SDKEmotionSettingManager not init ");
      }
      return;
    }
    boolean bool = localIntent.getBooleanExtra("key_from_sdk_set_emotion", false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initParam fromSdkSetAvatar =  ");
      localStringBuilder.append(bool);
      QLog.d("FavEmosmManageActivity", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      this.sdkEmotionSettingManager = ((IEmosmService)QRoute.api(IEmosmService.class)).createSDKEmotionSettingManager(this);
      this.sdkEmotionSettingManager.b(localIntent);
      this.sdkEmotionSettingManager.a();
    }
  }
  
  public static void uploadEmotion(Context paramContext, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.action.upload.emotiom");
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", paramArrayList);
      paramContext.sendBroadcast(localIntent);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavEmosmManageActivity", 2, "uploadEmotion pathList is empty");
    }
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
    super.setContentView(2131561594);
    this.app = ((BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null));
    int i = getIntent().getIntExtra("camera_emo_mode", 0);
    this.favEmosmView = new FavEmosmViewPage(this.app, this);
    this.favEmosmView.a(this);
    this.emosmStrategy = EmosmStrategyFactory.a(this.app, this.favEmosmView, i);
    this.favEmosmView.a(this.emosmStrategy);
    if (this.mFunnyPicUpdateReceiver != null)
    {
      paramBundle = new IntentFilter("com.tencent.mobileqq.action.update.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.refresh.emotiom");
      paramBundle.addAction("com.tencent.mobileqq.action.upload.emotiom");
      getApplicationContext().registerReceiver(this.mFunnyPicUpdateReceiver, paramBundle);
    }
    sdkSetEmotion();
    this.emosmStrategy.a();
    this.emosmStrategy.g();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.mFunnyPicUpdateReceiver != null)
    {
      getApplicationContext().unregisterReceiver(this.mFunnyPicUpdateReceiver);
      this.mFunnyPicUpdateReceiver = null;
    }
    if (this.emosmStrategy.b) {
      getApplicationContext().sendBroadcast(new Intent("com.tencent.mobileqq.action.update.emotiom"));
    }
    ISDKEmotionSettingManager localISDKEmotionSettingManager = this.sdkEmotionSettingManager;
    if (localISDKEmotionSettingManager != null) {
      localISDKEmotionSettingManager.b();
    }
    this.emosmStrategy.d();
  }
  
  protected void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    ISDKEmotionSettingManager localISDKEmotionSettingManager = this.sdkEmotionSettingManager;
    if (localISDKEmotionSettingManager != null)
    {
      localISDKEmotionSettingManager.a(paramIntent);
      return;
    }
    setIntent(paramIntent);
    sdkSetEmotion();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    this.favEmosmView.b();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    this.favEmosmView.a();
  }
  
  protected void doOnStart()
  {
    super.doOnStart();
  }
  
  protected boolean isWrapContent()
  {
    return super.isWrapContent();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    BaseEmosmStrategy localBaseEmosmStrategy = this.emosmStrategy;
    if (localBaseEmosmStrategy != null) {
      localBaseEmosmStrategy.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean onBackEvent()
  {
    ReportController.b(this.app, "CliOper", "", "", "ep_mall", "0X80057D4", 0, 0, "", "", "", "");
    Object localObject = this.sdkEmotionSettingManager;
    if (localObject != null) {
      ((ISDKEmotionSettingManager)localObject).c();
    }
    localObject = this.favEmosmView;
    if (localObject != null) {
      ((FavEmosmViewPage)localObject).m();
    }
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onEditModeChanged(boolean paramBoolean)
  {
    setGuestureInterceptRLEnable(paramBoolean ^ true);
  }
  
  public void setGuestureInterceptRLEnable(boolean paramBoolean)
  {
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      FlingGestureHandler localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (localFlingGestureHandler.mTopLayout != null) {
        localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FavEmosmManageActivity
 * JD-Core Version:    0.7.0.1
 */