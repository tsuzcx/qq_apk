package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.avgame.business.AvGameManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class AVGameShareJoinRoomAction
  extends JumpActionBase
{
  public AVGameShareJoinRoomAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if (TextUtils.isEmpty((String)this.jdField_a_of_type_JavaUtilHashMap.get("key"))) {
        return c();
      }
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: " + localException.getMessage());
      a("AVGameShareJoinRoomAction");
    }
    return true;
  }
  
  protected boolean b()
  {
    QLog.d("AVGameShareJoinRoomAction", 1, "doAction getRoomInfoAndJoinRoom");
    String str = (String)this.jdField_a_of_type_JavaUtilHashMap.get("key");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: key is empty");
      return true;
    }
    AVGameShareUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, new AVGameShareJoinRoomAction.1(this));
    return false;
  }
  
  protected boolean c()
  {
    QLog.d("AVGameShareJoinRoomAction", 1, "doAction directJoinRoom");
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("uin");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("room");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2))) {
      QLog.e("AVGameShareJoinRoomAction", 1, "doAction error: data is empty");
    }
    AvGameManager localAvGameManager;
    do
    {
      return true;
      localAvGameManager = (AvGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    } while (localAvGameManager == null);
    ThreadManager.getUIHandler().post(new AVGameShareJoinRoomAction.2(this, localAvGameManager, str2, str1));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.AVGameShareJoinRoomAction
 * JD-Core Version:    0.7.0.1
 */