package com.tencent.mobileqq.app.avgameshare;

import android.text.TextUtils;
import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class AVGameShareUtil$6
  extends AvGameRoomListObserver
{
  AVGameShareUtil$6(AVGameShareUtil paramAVGameShareUtil, long paramLong1, Map paramMap, BaseQQAppInterface paramBaseQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
  
  private void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localSessionInfo.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      paramBoolean = TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString);
      Object localObject = "邀请你加入派对";
      if (!paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
        ((StringBuilder)localObject).append("邀请你加入派对");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = new ArkAppMessage((String)localObject, "com.tencent.avgame", null, "invite", "1.0.0.1", AVGameShareEntry.a(String.valueOf(this.jdField_b_of_type_Long), Long.valueOf(this.jdField_c_of_type_Long).longValue(), paramString), null, null);
      ChatActivityFacade.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, localSessionInfo, paramString);
      return;
    }
    QLog.e("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg error");
  }
  
  public void a(boolean paramBoolean, String paramString, long paramLong)
  {
    if (paramLong != this.jdField_a_of_type_Long)
    {
      QLog.e("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg fail: observer not match");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("requestShareUrlAndSendMsg isSuccess: ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" shareUrl: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" mark: ");
    ((StringBuilder)localObject).append(paramLong);
    QLog.d("AvGameRoomListObserver", 1, ((StringBuilder)localObject).toString());
    localObject = (AvGameRoomListObserver)this.jdField_a_of_type_JavaUtilMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
    if (localObject == null)
    {
      QLog.e("AvGameRoomListObserver", 1, "requestShareUrlAndSendMsg fail: observer not exist");
      return;
    }
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.removeObserver((BusinessObserver)localObject);
    try
    {
      a(paramBoolean, paramString);
      return;
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleSendMsg exception: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("AvGameRoomListObserver", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.avgameshare.AVGameShareUtil.6
 * JD-Core Version:    0.7.0.1
 */