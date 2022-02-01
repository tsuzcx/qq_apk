import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.NotifyPushSettingActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amwk
{
  private final QQAppInterface a;
  
  public amwk(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  static void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean, anpt paramanpt)
  {
    paramanpt = paramanpt.a();
    if ((paramBoolean) && (paramMessage.istroop != 6000) && (paramMessage.istroop != 1009) && (!paramMessage.frienduin.equals(AppConstants.RECOMMEND_CONTACT_UIN)))
    {
      if (!bfyg.a(paramQQAppInterface.getApp())) {
        break label159;
      }
      localavnj = (avnj)paramQQAppInterface.getManager(72);
      if (!NotifyPushSettingActivity.a()) {
        break label132;
      }
      paramBoolean = false;
      bool = apka.a(paramQQAppInterface).a(paramMessage.frienduin, paramMessage.istroop);
      if ((paramBoolean) && (bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity notificationContentTitle appinterface  buildNotificationElement");
        }
        localavnj.a(paramQQAppInterface, paramMessage, false, avnf.a(paramMessage.frienduin, paramMessage.istroop, paramanpt));
      }
    }
    label132:
    label159:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        avnj localavnj;
        boolean bool;
        return;
        paramBoolean = SettingCloneUtil.readValue(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.getApp().getString(2131693533), "qqsetting_lock_screen_whenexit_key", true);
      }
    }
    QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, "screen unlock");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, @NonNull MessageRecord paramMessageRecord, anpt paramanpt, String paramString)
  {
    String str1 = paramanpt.b();
    Bitmap localBitmap = paramanpt.a();
    String str2 = paramanpt.c();
    String str3 = paramanpt.d();
    Intent localIntent = paramanpt.a();
    if (QLog.isColorLevel()) {
      QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, "showNotificationElementOfMessage. cmd=" + paramString + ", ticker=" + bftf.a(str1) + ",msgShow:" + bftf.a(str3) + ", bitmap=" + localBitmap);
    }
    paramanpt = localBitmap;
    if (localBitmap == null) {
      paramanpt = bfpx.a(paramQQAppInterface.getApp().getResources(), 2130840385);
    }
    if (paramanpt != null)
    {
      paramString = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), paramString);
      paramString.extraData.putStringArray("cmds", new String[] { str1, str2, str3 });
      localIntent.putExtra("param_fromuin", paramMessageRecord.senderuin);
      localIntent.putExtra("KEY_FRIEND_UIN", paramMessageRecord.frienduin);
      localIntent.putExtra("param_uinType", paramMessageRecord.istroop);
      paramString.extraData.putParcelable("intent", localIntent);
      paramString.extraData.putParcelable("bitmap", paramanpt);
      if (paramQQAppInterface.mqqService.a()) {
        paramQQAppInterface.mqqService.a(paramString);
      }
    }
    else
    {
      return;
    }
    int j = avnf.a(paramMessageRecord.senderuin, paramMessageRecord.istroop, localIntent);
    int i = j;
    if (j == 265)
    {
      paramanpt = bjnm.a();
      i = j;
      if (paramanpt != null) {
        i = paramanpt.a(paramMessageRecord.frienduin);
      }
    }
    localIntent.putExtra("param_notifyid", i);
    paramQQAppInterface.sendToService(paramString);
  }
  
  anpt a(QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    return new anpu(this.a, paramMessage, paramBoolean).a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    anpt localanpt = a(paramMessage, paramBoolean);
    if (localanpt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, new Object[] { "[build] showNotificationOfMessage: invoked. [中断发通知流程，无法构造出通知实体，原因可能是反射失败]", " notificationElement: null " });
      }
      return;
    }
    a(paramQQAppInterface, paramMessage, paramBoolean, localanpt);
    a(paramQQAppInterface, paramMessage, localanpt, "CMD_SHOW_NOTIFIYCATION");
  }
  
  public boolean a()
  {
    if (!((apwv)apub.a().a(566)).h) {}
    for (boolean bool = false;; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[NotificationRebuild] MessageNotificationGenerator", 2, new Object[] { "[notification-struct-config] useNewNotificationProcessorStruct: invoked. ", " useNewNotificationProcessorStruct: ", Boolean.valueOf(bool) });
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwk
 * JD-Core Version:    0.7.0.1
 */