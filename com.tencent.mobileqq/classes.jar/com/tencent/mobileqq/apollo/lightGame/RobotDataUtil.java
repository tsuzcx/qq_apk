package com.tencent.mobileqq.apollo.lightGame;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class RobotDataUtil
{
  private static final SharedPreferences a = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_robot", 4);
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      a.edit().putLong(paramString, System.currentTimeMillis()).commit();
    }
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      long l = a.getLong(paramString, 0L);
      if (System.currentTimeMillis() - l < 86400000L)
      {
        QLog.i("CmGameTemp_RobotDataUtil", 1, "isRobotUin:" + paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.RobotDataUtil
 * JD-Core Version:    0.7.0.1
 */