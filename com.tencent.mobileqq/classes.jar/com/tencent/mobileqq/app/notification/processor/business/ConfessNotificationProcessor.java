package com.tencent.mobileqq.app.notification.processor.business;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;

public class ConfessNotificationProcessor
  extends AbstractBusinessFoldedNotificationProcessor
{
  protected ConfessNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  public int a(Message paramMessage)
  {
    return -113;
  }
  
  public NotificationElement a(Message paramMessage)
  {
    Object localObject1 = SkinUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130844994));
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject1);
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698706);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c((String)localObject1);
    localObject1 = new ConfessInfo();
    ((ConfessInfo)localObject1).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
    localObject1 = ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ConfessInfo)localObject1, paramMessage.senderuin);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append("):");
    ((StringBuilder)localObject2).append(c());
    localObject2 = ((StringBuilder)localObject2).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b((String)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(c());
    localObject1 = ((StringBuilder)localObject2).toString();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject1);
    b(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.ConfessNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */