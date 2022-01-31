package com.tencent.biz.webviewplugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import xcl;

public class OfflineWebResManager$1
  implements Runnable
{
  public OfflineWebResManager$1(xcl paramxcl, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    this.this$0.b();
    this.a.edit().putLong("Last_Check_Cache", System.currentTimeMillis()).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.OfflineWebResManager.1
 * JD-Core Version:    0.7.0.1
 */