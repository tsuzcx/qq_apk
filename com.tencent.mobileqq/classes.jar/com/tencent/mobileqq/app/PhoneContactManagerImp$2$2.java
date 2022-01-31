package com.tencent.mobileqq.app;

import altv;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;

public class PhoneContactManagerImp$2$2
  implements Runnable
{
  public PhoneContactManagerImp$2$2(altv paramaltv) {}
  
  public void run()
  {
    try
    {
      this.a.a.a.edit().putLong("contact_last_query_list_time", this.a.a.d).apply();
      if (QLog.isColorLevel()) {
        QLog.d("PhoneContact.Manager", 2, String.format("save last query time: %s", new Object[] { Long.valueOf(this.a.a.d) }));
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.2.2
 * JD-Core Version:    0.7.0.1
 */