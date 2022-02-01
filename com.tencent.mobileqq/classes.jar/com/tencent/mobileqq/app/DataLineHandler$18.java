package com.tencent.mobileqq.app;

import android.content.SharedPreferences;

class DataLineHandler$18
  implements Runnable
{
  DataLineHandler$18(DataLineHandler paramDataLineHandler) {}
  
  public void run()
  {
    ??? = this.this$0.a.getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.a.getCurrentAccountUin());
    localStringBuilder.append("_DATA_LINE_OLD_MSG_UNREAD_COUNT");
    int i = ((SharedPreferences)???).getInt(localStringBuilder.toString(), 0);
    synchronized (this.this$0.a)
    {
      DataLineHandler.a(this.this$0, true);
      DataLineHandler.a(this.this$0, DataLineHandler.a(this.this$0) + i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.18
 * JD-Core Version:    0.7.0.1
 */