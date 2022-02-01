package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type;

import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.QFileUtils;

public class SessionTypeUtil
{
  public static String a(SessionInfo paramSessionInfo)
  {
    String str = "";
    if ((paramSessionInfo.jdField_a_of_type_Int == 0) || (paramSessionInfo.jdField_a_of_type_Int == 1000) || (paramSessionInfo.jdField_a_of_type_Int == 1004) || (paramSessionInfo.jdField_a_of_type_Int == 10008)) {
      str = "entrance.click.c2c.quick";
    }
    do
    {
      return str;
      if (paramSessionInfo.jdField_a_of_type_Int == 3000) {
        return "entrance.click.group.quick";
      }
    } while (paramSessionInfo.jdField_a_of_type_Int != 1);
    return "entrance.click.chatgroup.quick";
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 1000) || (paramInt == 1004) || (paramInt == 1006) || (paramInt == 10008) || (paramInt == 10010);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    return QFileUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, int paramInt)
  {
    return (paramInt == 0) || (ChatActivityUtils.a(paramQQAppInterface, paramSessionInfo.jdField_a_of_type_JavaLangString));
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