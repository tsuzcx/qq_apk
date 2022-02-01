package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoRoamingManager;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.qphone.base.util.QLog;

public class ChatPanelBarBizUtil
{
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((CameraEmoRoamingManager)paramQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER)).b();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool3 = false;
    int i = PokeItemHelper.a(paramQQAppInterface);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = PokeItemHelper.a(paramSharedPreferences);; bool1 = false)
    {
      boolean bool2 = bool3;
      if (i == 2)
      {
        bool2 = bool3;
        if (!bool1) {
          bool2 = true;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(PokeItemHelper.a, 2, "getUniquePokeNeedRed isUnquePokeNeedRed=" + bool2 + "getUniquePokeConfig=" + i + "hasClicked=" + bool1);
      }
      return bool2;
    }
  }
  
  public static boolean a(AIOPanelIconItem paramAIOPanelIconItem, SessionInfo paramSessionInfo)
  {
    return ((paramAIOPanelIconItem.a.length >= 6) && (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Boolean) && (paramSessionInfo.d) && (!paramSessionInfo.c)) || ((paramAIOPanelIconItem.a.length >= 6) && (paramSessionInfo != null) && (paramSessionInfo.b) && (paramSessionInfo.e) && (!paramSessionInfo.c)) || ((paramAIOPanelIconItem.a.length >= 6) && (paramSessionInfo != null) && (SessionTypeUtil.c(paramSessionInfo.jdField_a_of_type_Int)));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = PokeItemHelper.b(paramQQAppInterface, 1);
    if (paramSharedPreferences != null) {}
    for (boolean bool1 = PokeItemHelper.b(paramSharedPreferences);; bool1 = false)
    {
      if ((i == 2) && (!bool1)) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(PokeItemHelper.a, 2, "getPokeNeedRed isPokeNeedRed=" + bool2 + "getPokeMsgFoldSwitch=" + i + "hasClicked=" + bool1);
        }
        return bool2;
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.ChatPanelBarBizUtil
 * JD-Core Version:    0.7.0.1
 */