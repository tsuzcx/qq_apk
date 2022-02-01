package com.tencent.mobileqq.app;

import android.content.SharedPreferences;

class DataLineHandler$18
  implements Runnable
{
  DataLineHandler$18(DataLineHandler paramDataLineHandler) {}
  
  public void run()
  {
    int i = this.this$0.a.getPreferences().getInt(this.this$0.a.getCurrentAccountUin() + "_DATA_LINE_OLD_MSG_UNREAD_COUNT", 0);
    synchronized (this.this$0.a)
    {
      DataLineHandler.a(this.this$0, true);
      DataLineHandler.a(this.this$0, i + DataLineHandler.a(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.18
 * JD-Core Version:    0.7.0.1
 */