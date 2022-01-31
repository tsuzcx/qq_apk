package com.tencent.mobileqq.activity.aio;

import acin;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;

public final class AIOInputTypeHelper$1
  implements Runnable
{
  public AIOInputTypeHelper$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    acin.a(this.a).edit().putBoolean("ptt_guide_have_show", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOInputTypeHelper.1
 * JD-Core Version:    0.7.0.1
 */