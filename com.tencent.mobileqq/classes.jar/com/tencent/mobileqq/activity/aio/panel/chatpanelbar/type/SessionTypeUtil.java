package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;

public class SessionTypeUtil
{
  public static String a(SessionInfo paramSessionInfo)
  {
    if ((paramSessionInfo.a != 0) && (paramSessionInfo.a != 1000) && (paramSessionInfo.a != 1004) && (paramSessionInfo.a != 10008) && (paramSessionInfo.a != 10013))
    {
      if (paramSessionInfo.a == 3000) {
        return "entrance.click.group.quick";
      }
      if (paramSessionInfo.a == 1) {
        return "entrance.click.chatgroup.quick";
      }
      return "";
    }
    return "entrance.click.c2c.quick";
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1006) || (paramInt == 10008) || (paramInt == 10010) || (paramInt == 10013);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    return QFileUtils.b(paramQQAppInterface, paramSessionInfo.b);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    return (paramInt == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.b));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 1022) || (paramInt == 1023) || (paramInt == 1009) || (paramInt == 1024);
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == 1033) || (paramInt == 1034);
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == 1001) || (paramInt == 10002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil
 * JD-Core Version:    0.7.0.1
 */