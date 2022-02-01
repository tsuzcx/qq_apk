package com.tencent.mobileqq.app.notification.struct;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.notification.MessageBriefGenerator;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

public class NotificationElementBuilder
{
  private final Message jdField_a_of_type_ComTencentImcoreMessageMessage;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private NotificationElement jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  private final boolean jdField_a_of_type_Boolean;
  
  public NotificationElementBuilder(QQAppInterface paramQQAppInterface, Message paramMessage, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentImcoreMessageMessage = paramMessage;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement = new NotificationElement();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private Intent a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
  }
  
  private Bitmap a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a();
  }
  
  private String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b();
  }
  
  private void a()
  {
    Object localObject = MessageBriefGenerator.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentImcoreMessageMessage);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((String)localObject);
    String str = a().getStringExtra("uinname");
    if (str != null)
    {
      localObject = str;
      if (!"".equals(str)) {}
    }
    else
    {
      localObject = a().getStringExtra("uin");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c((String)localObject);
  }
  
  private String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.c();
  }
  
  private void b()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getIntentByMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentImcoreMessageMessage, true);
    this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a(localIntent);
    a().putExtra("entrance", 6);
    a().putExtra("key_notification_click_action", true);
  }
  
  private String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.d();
  }
  
  private void c()
  {
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.b(null);
    }
  }
  
  @Nullable
  public NotificationElement a()
  {
    b();
    a();
    int i = this.jdField_a_of_type_ComTencentImcoreMessageMessage.istroop;
    Object localObject = ProcessorFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement);
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement = ((BaseUinTypeProcessor)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageMessage);
      if (this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement != null) {}
    }
    else
    {
      return null;
    }
    i = ((BaseUinTypeProcessor)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageMessage);
    if (a() == null)
    {
      localObject = new Intent();
      this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement.a((Intent)localObject);
    }
    a().putExtra("KEY_NOTIFY_ID_FROM_PROCESSOR", i);
    a().putExtra("param_notifyid", i);
    c();
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] NotificationElementBuilder", 2, new Object[] { "[create] build: invoked. ", " notificationElement: ", this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement });
    }
    return this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement;
  }
  
  @NotNull
  public String toString()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppNotificationStructNotificationElement == null) {
      return "notificationElement: null";
    }
    Bundle localBundle = null;
    if (a() != null) {
      localBundle = a().getExtras();
    }
    if (a() != null) {}
    for (String str = String.valueOf(a().getHeight());; str = "using default bitmap") {
      return "NotificationElementBuilder{contentIntentExtras=" + localBundle + ", ticker='" + a() + '\'' + ", contentTitle='" + b() + '\'' + ", notificationContentText='" + c() + '\'' + ", notificationIconBitmapStr=" + str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.notification.struct.NotificationElementBuilder
 * JD-Core Version:    0.7.0.1
 */