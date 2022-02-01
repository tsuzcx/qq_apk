package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class QBaseActivity$2
  implements Runnable
{
  QBaseActivity$2(QBaseActivity paramQBaseActivity) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.this$0.getSharedPreferences("screen_shot", 4).edit();
    localEditor.putString("currentactivity", getClass().getName());
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */