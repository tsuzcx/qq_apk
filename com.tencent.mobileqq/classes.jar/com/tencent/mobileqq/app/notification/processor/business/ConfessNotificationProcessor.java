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
    Object localObject = SkinUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDrawable(2130845117));
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Bitmap)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131698640);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c((String)localObject);
    localObject = new ConfessInfo();
    ((ConfessInfo)localObject).parseFromJsonStr(paramMessage.getExtInfoFromExtStr("ext_key_confess_info"));
    localObject = ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ConfessInfo)localObject, paramMessage.senderuin);
    String str = (String)localObject + "(" + a() + "):" + c();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str);
    localObject = (String)localObject + ":" + c();
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d((String)localObject);
    b(paramMessage);
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.processor.business.ConfessNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */