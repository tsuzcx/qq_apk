package com.tencent.mobileqq.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.BaseApplication;

class ChatActivityUtils$14$2
  implements Runnable
{
  ChatActivityUtils$14$2(ChatActivityUtils.14 param14) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = MessageCache.c();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(this.this$0.h, String.valueOf(l * 1000L));
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.14.2
 * JD-Core Version:    0.7.0.1
 */