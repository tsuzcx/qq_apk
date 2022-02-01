package com.tencent.mobileqq.activity;

import acxo;
import android.app.Dialog;
import com.tencent.qphone.base.util.QLog;

public class ChatHistory$17$1
  implements Runnable
{
  public ChatHistory$17$1(acxo paramacxo) {}
  
  public void run()
  {
    try
    {
      this.a.a.b(this.a.a.b, this.a.a.a);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord Exception", localException);
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ChatHistory", 2, "onExportMessageRecord OOM", localOutOfMemoryError);
      }
      return;
    }
    finally
    {
      this.a.a.c.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.17.1
 * JD-Core Version:    0.7.0.1
 */