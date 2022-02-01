package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentActivity;

class DatalineChatPie$4
  implements Runnable
{
  DatalineChatPie$4(DatalineChatPie paramDatalineChatPie, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.this$0.a.isFinishing())) {
      return;
    }
    try
    {
      DatalineChatPie.b(this.this$0);
      this.a.edit().putBoolean("dataline_guide_check_show", true).apply();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.4
 * JD-Core Version:    0.7.0.1
 */