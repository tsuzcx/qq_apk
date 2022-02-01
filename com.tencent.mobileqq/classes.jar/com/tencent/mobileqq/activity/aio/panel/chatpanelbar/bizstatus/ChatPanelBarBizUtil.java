package com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus;

import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.type.SessionTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.pluspanel.AIOPanelIconItem;
import com.tencent.qphone.base.util.QLog;

public class ChatPanelBarBizUtil
{
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    return ((ICameraEmoRoamingManagerService)paramQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class)).getIsNeedShowGuide();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    int i = PokeItemHelper.a(paramQQAppInterface);
    boolean bool3 = false;
    boolean bool1;
    if (paramSharedPreferences != null) {
      bool1 = PokeItemHelper.a(paramSharedPreferences);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool3;
    if (i == 2)
    {
      bool2 = bool3;
      if (!bool1) {
        bool2 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = PokeItemHelper.a;
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("getUniquePokeNeedRed isUnquePokeNeedRed=");
      paramSharedPreferences.append(bool2);
      paramSharedPreferences.append("getUniquePokeConfig=");
      paramSharedPreferences.append(i);
      paramSharedPreferences.append("hasClicked=");
      paramSharedPreferences.append(bool1);
      QLog.d(paramQQAppInterface, 2, paramSharedPreferences.toString());
    }
    return bool2;
  }
  
  public static boolean a(AIOPanelIconItem paramAIOPanelIconItem, SessionInfo paramSessionInfo)
  {
    return ((paramAIOPanelIconItem.a.length >= 6) && (paramSessionInfo != null) && (paramSessionInfo.jdField_a_of_type_Boolean) && (paramSessionInfo.d) && (!paramSessionInfo.c)) || ((paramAIOPanelIconItem.a.length >= 6) && (paramSessionInfo != null) && (paramSessionInfo.b) && (paramSessionInfo.e) && (!paramSessionInfo.c)) || ((paramAIOPanelIconItem.a.length >= 6) && (paramSessionInfo != null) && (SessionTypeUtil.c(paramSessionInfo.jdField_a_of_type_Int)));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, SharedPreferences paramSharedPreferences)
  {
    boolean bool2 = true;
    int i = PokeItemHelper.b(paramQQAppInterface, 1);
    boolean bool1;
    if (paramSharedPreferences != null) {
      bool1 = PokeItemHelper.b(paramSharedPreferences);
    } else {
      bool1 = false;
    }
    if ((i != 2) || (bool1)) {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = PokeItemHelper.a;
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("getPokeNeedRed isPokeNeedRed=");
      paramSharedPreferences.append(bool2);
      paramSharedPreferences.append("getPokeMsgFoldSwitch=");
      paramSharedPreferences.append(i);
      paramSharedPreferences.append("hasClicked=");
      paramSharedPreferences.append(bool1);
      QLog.d(paramQQAppInterface, 2, paramSharedPreferences.toString());
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.chatpanelbar.bizstatus.ChatPanelBarBizUtil
 * JD-Core Version:    0.7.0.1
 */