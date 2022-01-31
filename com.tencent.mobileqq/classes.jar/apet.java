import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.MCardNotificationLike;

public class apet
{
  RecentItemVoteData jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  MessageForText jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  
  public apet(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private Intent a(Context paramContext)
  {
    String str = String.format("mqqapi://nearby_entry/nearby_profile?src_type=web&version=1&from=10002&from_type=0&mode=2&source_id=1001&uid=%s&PUSH_CONTENT=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.mTitleName });
    paramContext = new Intent(paramContext, JumpActivity.class);
    paramContext.setData(Uri.parse(str));
    return paramContext;
  }
  
  private void c()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    boolean bool = bdhy.a(localBaseApplication);
    Object localObject1;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) || (bool))
    {
      Object localObject2 = bcwc.a(localBaseApplication.getResources(), 2130844860);
      localObject1 = new NotificationCompat.Builder(localBaseApplication).setContentTitle(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.mTitleName).setAutoCancel(true).setSmallIcon(BaseApplicationImpl.appnewmsgicon).setTicker(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.mTitleName).setWhen(System.currentTimeMillis());
      if (localObject2 != null) {
        ((NotificationCompat.Builder)localObject1).setLargeIcon((Bitmap)localObject2);
      }
      if (Build.VERSION.SDK_INT < 11) {
        ((NotificationCompat.Builder)localObject1).setSmallIcon(2130844860);
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        localObject2 = new RemoteViews(localBaseApplication.getPackageName(), 2131560896);
        ((NotificationCompat.Builder)localObject1).setContent((RemoteViews)localObject2);
        ((RemoteViews)localObject2).setCharSequence(2131377884, "setText", this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.mTitleName);
        ((RemoteViews)localObject2).setCharSequence(2131377793, "setText", bdjj.a(System.currentTimeMillis(), true, "yyyy-MM-dd"));
      }
      localObject2 = a(localBaseApplication);
      ((Intent)localObject2).putExtra("param_notifyid", 240);
      ((NotificationCompat.Builder)localObject1).setContentIntent(PendingIntent.getActivity(localBaseApplication, 0, (Intent)localObject2, 134217728));
      localObject1 = ((NotificationCompat.Builder)localObject1).build();
      ((Notification)localObject1).flags |= 0x10;
      ((Notification)localObject1).defaults |= 0x1;
      ((Notification)localObject1).defaults |= 0x4;
      ((Notification)localObject1).icon = 2130844860;
      localObject2 = QQNotificationManager.getInstance();
      if (localObject2 != null)
      {
        ((QQNotificationManager)localObject2).cancel("nearby_like_notification_tag", 240);
        ((QQNotificationManager)localObject2).notify("nearby_like_notification_tag", 240, (Notification)localObject1);
      }
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80053CD", "0X80053CD", 0, 0, "", "", "", "");
    }
    if (bool)
    {
      localObject1 = (atvs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
      if (SettingCloneUtil.readValue(localBaseApplication, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localBaseApplication.getString(2131694136), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "videochatting start lsActivity from appinterface VoteEventMgr.notifyVoteEvent");
        }
        ((atvs)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, aljq.af, 1012, false, atvo.a(aljq.af, 1012, null));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyObservers(a());
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData == null) {
      return 0;
    }
    return 1;
  }
  
  public RecentBaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData;
  }
  
  public MessageForText a(RecentBaseData paramRecentBaseData)
  {
    paramRecentBaseData = (RecentItemVoteData)paramRecentBaseData;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)ayvw.a(-1000));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msgtype = -1000;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop = 1012;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.isread = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = aljq.ab;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = aljq.ab;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = paramRecentBaseData.mTitleName;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = paramRecentBaseData.time;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(paramRecentBaseData.mTitleName))) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = paramRecentBaseData.mTitleName;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != paramRecentBaseData.time) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = paramRecentBaseData.time;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData = null;
    BaseApplicationImpl.getContext();
    QQNotificationManager.getInstance().cancel("nearby_like_notification_tag", 240);
  }
  
  public void a(SubMsgType0x6f.MCardNotificationLike paramMCardNotificationLike)
  {
    String str2 = "";
    String str1 = str2;
    if (paramMCardNotificationLike != null)
    {
      str1 = str2;
      if (paramMCardNotificationLike.str_wording.has()) {
        str1 = paramMCardNotificationLike.str_wording.get();
      }
    }
    if (TextUtils.isEmpty(str1)) {}
    long l;
    do
    {
      return;
      l = ayvc.a();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData == null)
      {
        paramMCardNotificationLike = new RecentUser(aljq.af, 1012);
        paramMCardNotificationLike.msgType = 1012;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData = new RecentItemVoteData(paramMCardNotificationLike);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a(str1, l);
        c();
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.mTitleName.equals(str1)) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.time == l));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemVoteData.a(str1, l);
    c();
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext();
    QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
    if (localQQNotificationManager != null) {
      localQQNotificationManager.cancel("nearby_like_notification_tag", 240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apet
 * JD-Core Version:    0.7.0.1
 */