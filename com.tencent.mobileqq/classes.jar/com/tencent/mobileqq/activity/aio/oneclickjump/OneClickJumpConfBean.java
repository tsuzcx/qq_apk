package com.tencent.mobileqq.activity.aio.oneclickjump;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class OneClickJumpConfBean
{
  @SerializedName("aioGotoUnreadMsgSwitch")
  private int a = 1;
  
  public static OneClickJumpConfBean a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (OneClickJumpConfBean)new Gson().fromJson(paramString, OneClickJumpConfBean.class);
  }
  
  public static boolean a()
  {
    OneClickJumpConfBean localOneClickJumpConfBean = (OneClickJumpConfBean)QConfigManager.b().b(750);
    boolean bool1 = QLog.isColorLevel();
    boolean bool2 = false;
    if (bool1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isEnablePullUp : ");
      if (localOneClickJumpConfBean.a == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.d("OneClickJumpConfProcessor", 2, localStringBuilder.toString());
    }
    bool1 = bool2;
    if (localOneClickJumpConfBean.a == 1) {
      bool1 = true;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.oneclickjump.OneClickJumpConfBean
 * JD-Core Version:    0.7.0.1
 */