package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

class BaseChatPie$18
  implements Runnable
{
  BaseChatPie$18(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.a.getPreferences().edit();
    localEditor.putInt("LT_tip_show_times" + this.this$0.a.getCurrentAccountUin(), 1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.18
 * JD-Core Version:    0.7.0.1
 */