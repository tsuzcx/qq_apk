package com.tencent.comic.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AppHelper
{
  public static Application a()
  {
    return MobileQQ.sMobileQQ;
  }
  
  public static AppRuntime a()
  {
    return MobileQQ.sMobileQQ.peekAppRuntime();
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("android.intent.action.VIEW");
    localIntent.putExtra("big_brother_source_key", paramString2);
    localIntent.putExtra("key_callback_id", paramInt);
    localIntent.setData(Uri.parse(paramString1));
    paramActivity.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.utils.AppHelper
 * JD-Core Version:    0.7.0.1
 */