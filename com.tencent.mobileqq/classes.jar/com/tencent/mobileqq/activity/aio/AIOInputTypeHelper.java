package com.tencent.mobileqq.activity.aio;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class AIOInputTypeHelper
{
  public static volatile boolean a = false;
  public static boolean b = false;
  public static boolean c = false;
  private static boolean d = false;
  
  public static void a()
  {
    c = true;
    BaseApplication.getContext().getSharedPreferences("sp_upgrade", 0).edit().putBoolean("upgrade", true).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      try
      {
        if (!d)
        {
          a = c(paramQQAppInterface).getBoolean("ptt_guide_have_show", true);
          d = true;
          return;
        }
      }
      finally {}
    }
  }
  
  @TargetApi(9)
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    if (!d) {
      a(paramQQAppInterface);
    }
    boolean bool2 = a;
    boolean bool1 = false;
    if (bool2)
    {
      a = false;
      ThreadManager.getFileThreadHandler().post(new AIOInputTypeHelper.1(paramQQAppInterface));
      bool2 = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "inputhelper : need guide");
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public static SharedPreferences c(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_aio_input_helper_");
    localStringBuilder.append(paramQQAppInterface.getAccount());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOInputTypeHelper
 * JD-Core Version:    0.7.0.1
 */