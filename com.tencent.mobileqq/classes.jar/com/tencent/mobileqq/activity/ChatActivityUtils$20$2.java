package com.tencent.mobileqq.activity;

import adsg;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bbyp;
import com.tencent.qphone.base.util.BaseApplication;

public class ChatActivityUtils$20$2
  implements Runnable
{
  public ChatActivityUtils$20$2(adsg paramadsg) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = bbyp.a();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(this.this$0.a, String.valueOf(l * 1000L));
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.20.2
 * JD-Core Version:    0.7.0.1
 */