package com.tencent.mobileqq.activity;

import ackx;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import ayzl;
import com.tencent.qphone.base.util.BaseApplication;

public class ChatActivityUtils$36$2
  implements Runnable
{
  public ChatActivityUtils$36$2(ackx paramackx) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("free_call", 0);
    long l = ayzl.a();
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString(this.this$0.a, String.valueOf(l * 1000L));
    ((SharedPreferences.Editor)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.36.2
 * JD-Core Version:    0.7.0.1
 */