package com.tencent.mobileqq.app.notification.processor.business;

import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;

public class TempGameMsgNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected TempGameMsgNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return 527;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage, c());
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    a();
    a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement);
    localObject = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleBitmap(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramMessage = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getGameRoleNickName(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.TempGameMsgNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */