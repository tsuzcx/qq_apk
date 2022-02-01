import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class anyy
{
  private final QQAppInterface a;
  
  public anyy(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  static void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean, aosm paramaosm)
  {
    paramaosm = paramaosm.a();
    if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN)))
    {
      if (!bhgy.a(paramQQAppInterface.getApp())) {
        break label160;
      }
      localawto = (awto)paramQQAppInterface.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
      if (!NotifyPushSettingActivity.a()) {
        break label133;
      }
      paramBoolean = false;
      bool = aqne.a(paramQQAppInterface).a(paramMessage.frienduin, paramMessage.istroop);
      if ((paramBoolean) && (bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity notificationContentTitle appinterface  buildNotificationElement");
        }
        localawto.a(paramQQAppInterface, paramMessage, false, awtk.a(paramMessage.frienduin, paramMessage.istroop, paramaosm));
      }
    }
    label133:
    label160:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        awto localawto;
        boolean bool;
        return;
        paramBoolean = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getApp().getString(2131693714), "qqsetting_lock_screen_whenexit_key", true);
      }
    }
    QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, "screen unlock");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, @NonNull MessageRecord paramMessageRecord, aosm paramaosm, String paramString)
  {
    String str1 = paramaosm.b();
    Bitmap localBitmap = paramaosm.a();
    String str2 = paramaosm.c();
    String str3 = paramaosm.d();
    Intent localIntent = paramaosm.a();
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, "showNotificationElementOfMessage. cmd=" + paramString + ", ticker=" + bhbx.a(str1) + ",msgShow:" + bhbx.a(str3) + ", bitmap=" + localBitmap);
    }
    paramaosm = localBitmap;
    if (localBitmap == null) {
      paramaosm = bgyo.a(paramQQAppInterface.getApp().getResources(), 2130840422);
    }
    if (paramaosm != null)
    {
      paramString = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), paramString);
      paramString.extraData.putStringArray("cmds", new String[] { str1, str2, str3 });
      localIntent.putExtra("param_fromuin", paramMessageRecord.senderuin);
      localIntent.putExtra("KEY_FRIEND_UIN", paramMessageRecord.frienduin);
      localIntent.putExtra("param_uinType", paramMessageRecord.istroop);
      paramString.extraData.putParcelable("intent", localIntent);
      paramString.extraData.putParcelable("bitmap", paramaosm);
      paramQQAppInterface.mqqService.a(paramString);
    }
  }
  
  aosm a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    return new aosn(this.a, paramMessage, paramBoolean).a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    aosm localaosm = a(paramMessage, paramBoolean);
    if (localaosm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, new Object[] { "[build] showNotificationOfMessage: invoked. [中断发通知流程，无法构造出通知实体，原因可能是反射失败]", " notificationElement: null " });
      }
      return;
    }
    a(paramQQAppInterface, paramMessage, paramBoolean, localaosm);
    a(paramQQAppInterface, paramMessage, localaosm, "CMD_SHOW_NOTIFIYCATION");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyy
 * JD-Core Version:    0.7.0.1
 */