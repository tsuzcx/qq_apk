package com.tencent.mobileqq.bigbrother;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class Utils
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.Utils
 * JD-Core Version:    0.7.0.1
 */