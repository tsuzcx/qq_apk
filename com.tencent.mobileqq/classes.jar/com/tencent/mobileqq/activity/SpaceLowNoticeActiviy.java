package com.tencent.mobileqq.activity;

import Override;
import aeys;
import aeyt;
import aeyu;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import bhdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.manager.ServerConfigManager.ConfigType;

public class SpaceLowNoticeActiviy
  extends BaseActivity
{
  private QQCustomDialog a;
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return paramLong;
      try
      {
        long l = Long.parseLong(paramQQAppInterface.getServerConfigValue(ServerConfigManager.ConfigType.common, paramString));
        if (l > 0L) {
          return l;
        }
      }
      catch (Throwable paramQQAppInterface) {}
    }
    return paramLong;
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, SpaceLowNoticeActiviy.class);
    paramContext.startActivity(localIntent);
  }
  
  public static boolean a(long paramLong)
  {
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getApplication());
    long l2 = localSharedPreferences.getLong("lastCheckTime", 0L);
    if ((l2 <= 0L) || (l1 - l2 > paramLong))
    {
      localSharedPreferences.edit().putLong("lastCheckTime", l1).commit();
      return true;
    }
    return false;
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
    super.doOnCreate(paramBundle);
    super.setContentView(2131559556);
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    this.a = bhdj.a(this, 230);
    this.a.setContentView(2131559019);
    this.a.setTitle(getString(2131698400)).setMessage(getString(2131698401)).setPositiveButton(2131698818, new aeyt(this)).setNegativeButton(2131690697, new aeys(this));
    this.a.setOnKeyListener(new aeyu(this));
    this.a.show();
    return false;
  }
  
  public void finish()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    super.finish();
  }
  
  public void onBackPressed() {}
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SpaceLowNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */