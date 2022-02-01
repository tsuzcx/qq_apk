package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.BaseActivity;

class DatalineChatPie$4
  implements Runnable
{
  DatalineChatPie$4(DatalineChatPie paramDatalineChatPie, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if (this.this$0.a.isFinishing()) {
        return;
      }
      try
      {
        DatalineChatPie.b(this.this$0);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.a.edit().putBoolean("dataline_guide_check_show", true).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie.4
 * JD-Core Version:    0.7.0.1
 */