package com.tencent.mobileqq.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.notification.struct.NotificationElement;
import com.tencent.mobileqq.app.notification.struct.NotificationElementBuilder;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.service.MobileQQServiceExtend;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MessageNotificationGenerator
{
  private final QQAppInterface a;
  
  public MessageNotificationGenerator(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  static void a(QQAppInterface paramQQAppInterface, Message paramMessage, boolean paramBoolean, NotificationElement paramNotificationElement)
  {
    paramNotificationElement = paramNotificationElement.a();
    if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN))) {
      if (QQUtils.a(paramQQAppInterface.getApp()))
      {
        QQLSRecentManager localQQLSRecentManager = (QQLSRecentManager)paramQQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        if (NotifyPushSettingActivity.a()) {
          paramBoolean = false;
        } else {
          paramBoolean = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getApp().getString(2131693837), "qqsetting_lock_screen_whenexit_key", true);
        }
        boolean bool = MessageNotificationSettingManager.a(paramQQAppInterface).a(paramMessage.frienduin, paramMessage.istroop);
        if ((paramBoolean) && (bool))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "videochatting start lsActivity notificationContentTitle appinterface  buildNotificationElement");
          }
          localQQLSRecentManager.a(paramQQAppInterface, paramMessage, false, MsgPushReportHelper.a(paramMessage.frienduin, paramMessage.istroop, paramNotificationElement));
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, "screen unlock");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, @NonNull MessageRecord paramMessageRecord, NotificationElement paramNotificationElement, String paramString)
  {
    String str1 = paramNotificationElement.b();
    Bitmap localBitmap = paramNotificationElement.a();
    String str2 = paramNotificationElement.c();
    String str3 = paramNotificationElement.d();
    Intent localIntent = paramNotificationElement.a();
    if (QLog.isColorLevel())
    {
      paramNotificationElement = new StringBuilder();
      paramNotificationElement.append("showNotificationElementOfMessage. cmd=");
      paramNotificationElement.append(paramString);
      paramNotificationElement.append(", ticker=");
      paramNotificationElement.append(MessageRecordUtil.a(str1));
      paramNotificationElement.append(",msgShow:");
      paramNotificationElement.append(MessageRecordUtil.a(str3));
      paramNotificationElement.append(", bitmap=");
      paramNotificationElement.append(localBitmap);
      QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, paramNotificationElement.toString());
    }
    paramNotificationElement = localBitmap;
    if (localBitmap == null) {
      paramNotificationElement = BitmapManager.a(paramQQAppInterface.getApp().getResources(), 2130840405);
    }
    if (paramNotificationElement != null)
    {
      paramString = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), paramString);
      paramString.extraData.putStringArray("cmds", new String[] { str1, str2, str3 });
      localIntent.putExtra("param_fromuin", paramMessageRecord.senderuin);
      localIntent.putExtra("KEY_FRIEND_UIN", paramMessageRecord.frienduin);
      localIntent.putExtra("param_uinType", paramMessageRecord.istroop);
      paramString.extraData.putParcelable("intent", localIntent);
      paramString.extraData.putParcelable("bitmap", paramNotificationElement);
      paramQQAppInterface.mqqService.a(paramString);
    }
  }
  
  NotificationElement a(Message paramMessage, boolean paramBoolean)
  {
    return new NotificationElementBuilder(this.a, paramMessage, paramBoolean).a();
  }
  
  void a(QQAppInterface paramQQAppInterface, Message paramMessage, boolean paramBoolean)
  {
    NotificationElement localNotificationElement = a(paramMessage, paramBoolean);
    if (localNotificationElement == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, new Object[] { "[build] showNotificationOfMessage: invoked. [中断发通知流程，无法构造出通知实体，原因可能是反射失败]", " notificationElement: null " });
      }
      return;
    }
    a(paramQQAppInterface, paramMessage, paramBoolean, localNotificationElement);
    a(paramQQAppInterface, paramMessage, localNotificationElement, "CMD_SHOW_NOTIFIYCATION");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageNotificationGenerator
 * JD-Core Version:    0.7.0.1
 */