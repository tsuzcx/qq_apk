package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractBusinessFoldedNotificationProcessor
  extends BaseUinTypeProcessor
{
  protected AbstractBusinessFoldedNotificationProcessor(QQAppInterface paramQQAppInterface, NotificationElement paramNotificationElement)
  {
    super(paramQQAppInterface, paramNotificationElement);
  }
  
  private void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
    String str3 = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c();
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.a(true);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b(true);
    localStringBuffer.append(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694542), new Object[] { Integer.valueOf(j) }));
    if (i > 1000)
    {
      localStringBuffer.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694543));
      if (j <= 1) {
        break label275;
      }
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.addFlags(335544320);
      localIntent.putExtra("tab_index", FrameControllerUtil.a);
      str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694559);
      str1 = localStringBuffer.toString();
      localBitmap = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(localIntent);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c(str2);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d(str1);
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(str3);
      return;
      localStringBuffer.append(i).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694480));
      break;
      label275:
      QLog.d("[NotificationRebuild] [NotificationProcessor] AbstractBuildLastDefaultNotificationProcessor", 1, new Object[] { "[notification] buildNotificationElement: invoked. 非独立会话数<=1，保持旧的跳转、图标、wording 已经从上面switch-case中获取 ", " conversationSizeNotSeparate: ", Integer.valueOf(j) });
    }
  }
  
  protected final int b(Message paramMessage)
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isShowMsgContent();
    int i = paramMessage.istroop;
    paramMessage = paramMessage.frienduin;
    if (NotifyIdManager.a(i, paramMessage))
    {
      if (bool) {
        return NotifyIdManager.a().a(paramMessage);
      }
      return 265;
    }
    return -113;
  }
  
  @NotNull
  protected final NotificationElement b(Message paramMessage)
  {
    a();
    a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.b() > 1) {
      i = 1;
    }
    while (i != 0) {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a.a(true) == 0)
      {
        return null;
        i = 0;
      }
      else
      {
        b();
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.AbstractBusinessFoldedNotificationProcessor
 * JD-Core Version:    0.7.0.1
 */