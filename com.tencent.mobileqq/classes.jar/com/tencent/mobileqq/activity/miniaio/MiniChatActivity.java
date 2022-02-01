package com.tencent.mobileqq.activity.miniaio;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MiniChatActivity
  extends PublicFragmentActivity
{
  static boolean a = false;
  
  public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    a(paramActivity, paramInt, paramString1, paramString2, true);
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2, float paramFloat1, float paramFloat2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("minaio_height_ration", paramFloat1);
    localIntent.putExtra("minaio_scaled_ration", paramFloat2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_mini_from", 3);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, MiniChatActivity.class, MiniChatFragment.class);
  }
  
  public static void a(Activity paramActivity, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramActivity, paramInt, paramString1, paramString2, true, 0);
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("key_mini_msgtab_businame", paramInt2);
    localIntent.putExtra("key_mini_from", 2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, MiniChatActivity.class, MiniChatFragment.class, 1);
    if (paramBoolean) {
      paramActivity.overridePendingTransition(2130772011, 2130772012);
    }
  }
  
  public static void a(Activity paramActivity, int paramInt1, String paramString, boolean paramBoolean, int paramInt2, long paramLong1, long paramLong2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", paramString);
    localIntent.putExtra("uintype", paramInt1);
    localIntent.putExtra("key_mini_msgtab_businame", paramInt2);
    localIntent.putExtra("key_mini_from", 2);
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("key_mini_aio_msg_shmsgseq", paramLong1);
    localIntent.putExtra("key_mini_from", 5);
    localIntent.putExtra("key_mini_aio_barrage_time_location", paramLong2);
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, MiniChatActivity.class, MiniChatFragment.class, 1);
    if (paramBoolean) {
      paramActivity.overridePendingTransition(2130772011, 2130772012);
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("key_mini_from", 1);
    paramIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramActivity, paramIntent, MiniChatActivity.class, MiniMsgTabFragment.class, paramInt);
  }
  
  public static boolean b()
  {
    return a;
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
    Intent localIntent = getIntent();
    int i = localIntent.getIntExtra("key_mini_from", -1);
    if (localIntent.getBooleanExtra("key_mini_msgtab_need_full_screen", false)) {
      getWindow().setFlags(1024, 1024);
    }
    if (i != 1)
    {
      if ((i != 2) && (i != 3) && (i != 4) && (i != 5)) {
        finish();
      }
    }
    else {
      getWindow().setDimAmount(0.0F);
    }
    if (getIntent().getBooleanExtra("isLandscape", false)) {
      findViewById(16908290).setBackgroundResource(2130842022);
    }
    return super.doOnCreate(paramBundle);
  }
  
  protected void doOnStart()
  {
    a = true;
    if (QLog.isColorLevel()) {
      QLog.d("MiniChatActivity", 2, "doOnStart : isForeGround true");
    }
    super.doOnStart();
  }
  
  protected void doOnStop()
  {
    a = false;
    if (QLog.isColorLevel()) {
      QLog.d("MiniChatActivity", 2, "doOnStop : isForeGround false");
    }
    super.doOnStop();
  }
  
  public void finish()
  {
    if (getIntent().getBooleanExtra("key_mini_need_update_unread", false)) {
      MiniMsgIPCServer.a().d();
    }
    getIntent().getIntExtra("key_mini_from", 0);
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniChatActivity
 * JD-Core Version:    0.7.0.1
 */