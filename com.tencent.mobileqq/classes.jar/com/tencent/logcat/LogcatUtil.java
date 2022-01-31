package com.tencent.logcat;

import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class LogcatUtil
  implements Handler.Callback
{
  private static LogcatUtil jdField_a_of_type_ComTencentLogcatLogcatUtil = new LogcatUtil();
  private static final String jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/log/logcat";
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  LogcatUtil.LogcatThread jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread;
  
  public static void a(String paramString)
  {
    if ((QLog.isColorLevel()) && (jdField_a_of_type_ComTencentLogcatLogcatUtil != null) && (jdField_a_of_type_ComTencentLogcatLogcatUtil.a(paramString))) {
      jdField_a_of_type_ComTencentLogcatLogcatUtil.b(paramString);
    }
  }
  
  private boolean a(String paramString)
  {
    return (paramString.equals("$logcat start")) || (paramString.equals("$logcat stop"));
  }
  
  private void b(String paramString)
  {
    if (paramString.equals("$logcat start")) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
    while (!paramString.equals("$logcat stop")) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread == null)
      {
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread = new LogcatUtil.LogcatThread();
        this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.start();
        continue;
        if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread != null)
        {
          if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.a != null) {
            this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.a.destroy();
          }
          if (this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.b != null) {
            this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread.b.destroy();
          }
          this.jdField_a_of_type_ComTencentLogcatLogcatUtil$LogcatThread = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.logcat.LogcatUtil
 * JD-Core Version:    0.7.0.1
 */