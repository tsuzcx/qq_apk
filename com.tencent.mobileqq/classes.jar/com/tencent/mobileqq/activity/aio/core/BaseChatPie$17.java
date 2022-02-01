package com.tencent.mobileqq.activity.aio.core;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseChatPie$17
  implements Runnable
{
  BaseChatPie$17(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.app.getPreferences().edit();
    localEditor.putInt("LT_tip_show_times" + this.this$0.app.getCurrentAccountUin(), 1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.17
 * JD-Core Version:    0.7.0.1
 */