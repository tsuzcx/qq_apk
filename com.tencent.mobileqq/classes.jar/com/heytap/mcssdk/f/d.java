package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class d
{
  public static void a(Context paramContext, boolean paramBoolean)
  {
    paramContext.getSharedPreferences("shared_msg_sdk", 0).edit().putBoolean("hasDefaultChannelCreated", paramBoolean).commit();
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getSharedPreferences("shared_msg_sdk", 0).getBoolean("hasDefaultChannelCreated", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.d
 * JD-Core Version:    0.7.0.1
 */