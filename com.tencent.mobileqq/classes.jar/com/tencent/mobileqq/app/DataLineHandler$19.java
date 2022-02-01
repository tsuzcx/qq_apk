package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

class DataLineHandler$19
  implements Runnable
{
  DataLineHandler$19(DataLineHandler paramDataLineHandler, int paramInt) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.this$0.a.getPreferences();
    String str = this.this$0.a.getCurrentAccountUin() + "_DATA_LINE_OLD_MSG_UNREAD_COUNT";
    localSharedPreferences.edit().putInt(str, this.a).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.19
 * JD-Core Version:    0.7.0.1
 */