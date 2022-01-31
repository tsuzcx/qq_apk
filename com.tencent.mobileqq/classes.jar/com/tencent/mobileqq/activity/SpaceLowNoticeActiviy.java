package com.tencent.mobileqq.activity;

import adzd;
import adze;
import adzf;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import bdgm;
import bdjz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.manager.ServerConfigManager.ConfigType;

public class SpaceLowNoticeActiviy
  extends BaseActivity
{
  private bdjz a;
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return paramLong;
      try
      {
        long l = Long.parseLong(paramQQAppInterface.a(ServerConfigManager.ConfigType.common, paramString));
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131559398);
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
    this.a = null;
    this.a = bdgm.a(this, 230);
    this.a.setContentView(2131558919);
    this.a.setTitle(getString(2131699245)).setMessage(getString(2131699246)).setPositiveButton(2131699777, new adze(this)).setNegativeButton(2131690648, new adzd(this));
    this.a.setOnKeyListener(new adzf(this));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SpaceLowNoticeActiviy
 * JD-Core Version:    0.7.0.1
 */