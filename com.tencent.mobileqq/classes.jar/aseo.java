import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSUnlockActivity;
import com.tencent.mobileqq.activity.RecommendFriendActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.managers.PushNoticeManager.1;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.manager.Manager;
import tencent.im.oidb.cmd0x935.FriendRecommendPushExtData.LockScreenPushExtData;
import tencent.im.pushsvr.pushsvrExt.ExtData;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.ClientReport;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x101.SubMsgType0x27.PushPlatform;

public class aseo
  implements Handler.Callback, Manager
{
  private long jdField_a_of_type_Long;
  final SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray;
  private bfnk jdField_a_of_type_Bfnk = new bfnk(ThreadManagerV2.getSubThreadLooper(), this);
  private RecentItemNoticeData jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForText jdField_a_of_type_ComTencentMobileqqDataMessageForText;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private short jdField_a_of_type_Short;
  private long b;
  
  public aseo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    axqr localaxqr = new axqr();
    localaxqr.e = paramString4;
    localaxqr.d = paramString5;
    localaxqr.f = paramString1;
    localaxqr.i = paramString2;
    axqq.a(paramString3, localaxqr);
    axqq.a(paramQQAppInterface, localaxqr);
  }
  
  private boolean a(SubMsgType0x27.PushPlatform paramPushPlatform, Bundle paramBundle, int paramInt)
  {
    byte[] arrayOfByte;
    switch (paramInt)
    {
    default: 
      return true;
    case 1041: 
      arrayOfByte = a(paramPushPlatform);
      paramPushPlatform = new pushsvrExt.ExtData();
      if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        paramPushPlatform.mergeFrom(arrayOfByte);
        if (paramPushPlatform.uint64_to_uin.has())
        {
          l = paramPushPlatform.uint64_to_uin.get();
          if ((l <= 0L) || (!paramPushPlatform.str_remark.has())) {
            break label565;
          }
          paramBundle.putString("uinname", paramPushPlatform.str_remark.get().toStringUtf8());
          paramBundle.putString("param_fromuin", String.valueOf(l));
          paramBundle.putString("param_push_fromuin", String.valueOf(l));
          paramBundle.putInt("param_push_uinType", paramInt);
          paramBundle.putString("param_push_fromuin", String.valueOf(l));
          bool1 = true;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            if (!paramPushPlatform.str_remark.has()) {
              continue;
            }
            paramPushPlatform = paramPushPlatform.str_remark.get().toStringUtf8();
            QLog.i("PushNoticeManager", 2, String.format("handleExtData uin=%d nick=%s", new Object[] { Long.valueOf(l), paramPushPlatform }));
            bool2 = bool1;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PushNoticeManager", 2, String.format("handleExtData uinType=%d valid=%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(bool2) }));
          }
          return bool2;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
        long l = 0L;
        continue;
        paramPushPlatform = "";
        continue;
      }
      Object localObject = (afsa)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(295);
      if (localObject != null)
      {
        bool2 = ((afsa)localObject).b();
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.i("PushNoticeManager", 2, "getSPSwitchState user closed");
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if (!bool1)
        {
          paramPushPlatform = a(paramPushPlatform);
          localObject = new FriendRecommendPushExtData.LockScreenPushExtData();
          if ((paramPushPlatform != null) && (paramPushPlatform.length > 0)) {
            try
            {
              ((FriendRecommendPushExtData.LockScreenPushExtData)localObject).mergeFrom(paramPushPlatform);
              if (((FriendRecommendPushExtData.LockScreenPushExtData)localObject).rpt_msg_persons.has())
              {
                paramPushPlatform = ((FriendRecommendPushExtData.LockScreenPushExtData)localObject).rpt_msg_persons.get();
                if (!((FriendRecommendPushExtData.LockScreenPushExtData)localObject).uint32_push_timestamp.has()) {
                  break label524;
                }
                i = ((FriendRecommendPushExtData.LockScreenPushExtData)localObject).uint32_push_timestamp.get();
                localObject = MayKnowRecommend.covServerDataToLocal(paramPushPlatform, i);
                if (((ArrayList)localObject).size() <= 0) {
                  break label547;
                }
                paramBundle.putSerializable("may_know_recmmds", (Serializable)localObject);
                paramBundle.putInt("param_push_uinType", paramInt);
                bool1 = true;
                label446:
                bool2 = bool1;
                if (!QLog.isColorLevel()) {
                  break label544;
                }
                paramPushPlatform = new StringBuilder("handleExtData pushfrds:");
                paramBundle = ((ArrayList)localObject).iterator();
                while (paramBundle.hasNext())
                {
                  localObject = (MayKnowRecommend)paramBundle.next();
                  paramPushPlatform.append(" ").append(((MayKnowRecommend)localObject).uin);
                }
              }
            }
            catch (Exception paramPushPlatform)
            {
              for (;;)
              {
                paramPushPlatform.printStackTrace();
                continue;
                paramPushPlatform = null;
                continue;
                label524:
                int i = 0;
              }
              QLog.i("PushNoticeManager", 2, paramPushPlatform.toString());
              bool2 = bool1;
            }
          }
        }
        for (;;)
        {
          label544:
          break;
          label547:
          bool1 = false;
          break label446;
          bool2 = false;
        }
      }
      label565:
      bool1 = false;
      continue;
      boolean bool2 = false;
    }
  }
  
  private byte[] a(SubMsgType0x27.PushPlatform paramPushPlatform)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      if (paramPushPlatform.bytes_ext_data.has()) {
        localObject1 = paramPushPlatform.bytes_ext_data.get().toByteArray();
      }
      if (QLog.isColorLevel()) {
        QLog.i("PushNoticeManager", 2, String.format("getExtBytes extBytes=%s", new Object[] { Arrays.toString((byte[])localObject1) }));
      }
      return localObject1;
    }
    catch (Exception paramPushPlatform)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("PushNoticeManager", 2, paramPushPlatform.getMessage(), paramPushPlatform);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  private void b(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("push_notice_unlock", false)) {
      paramContext.startActivity(new Intent(paramContext, QQLSUnlockActivity.class));
    }
  }
  
  public RecentBaseData a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
  }
  
  public MessageForText a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null) {
      return null;
    }
    RecentItemNoticeData localRecentItemNoticeData = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText = ((MessageForText)axaq.a(-1000));
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msgtype = -1000;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop = this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.type;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.isread = false;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.senderuin = (this.jdField_a_of_type_Long + "");
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.frienduin = (this.jdField_a_of_type_Long + "");
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = localRecentItemNoticeData.wording;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = localRecentItemNoticeData.time;
    }
    if (localRecentItemNoticeData.type == 1035) {}
    for (String str = localRecentItemNoticeData.mTitleName;; str = localRecentItemNoticeData.wording)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg == null) || (!this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg.equals(str))) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.msg = str;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time != localRecentItemNoticeData.time) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.time = localRecentItemNoticeData.time;
      }
      return this.jdField_a_of_type_ComTencentMobileqqDataMessageForText;
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushNoticeManager", 2, "nothing to show");
      }
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null)
    {
      QLog.w("PushNoticeManager", 1, "recent data is null");
      return;
    }
    this.jdField_a_of_type_Bfnk.sendEmptyMessageDelayed(1, 30000L);
  }
  
  public void a(long paramLong, String arg3, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4, String paramString5, Bundle paramBundle)
  {
    if (!QQNotificationManager.getInstance().areNotificationsEnabled(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) {
      QLog.i("PushNoticeManager", 1, "notifications are disabled");
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
        if (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "qqsetting_show_push_message", true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PushNoticeManager", 2, "show push notice switch off");
      return;
      if (FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
      {
        QLog.i("PushNoticeManager", 1, "do not disturb");
        return;
      }
      localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 4);
      localIntent.setFlags(603979776);
      localIntent.putExtra("forward", paramInt1);
      paramInt1 = (Integer.valueOf(paramString4).intValue() - 1000) % 30;
      if (paramInt1 >= 0) {}
      for (;;)
      {
        paramInt1 += 482;
        localIntent.putExtra("url", paramString2);
        localIntent.putExtra("from", "push_notice");
        localIntent.putExtra("uintype", paramInt2);
        localIntent.putExtra("param_fromuin", String.valueOf(paramLong));
        localIntent.putExtra("param_uinType", paramInt2);
        localIntent.putExtra("param_notifyid", paramInt1);
        localIntent.putExtra("push_notice_tag", "push_notification_tag");
        localIntent.putExtra("param_push_notifyid", paramInt1);
        localIntent.putExtra("push_notice_service_id", paramString4);
        localIntent.putExtra("push_notice_content_id", paramString5);
        if (paramBundle != null) {
          localIntent.putExtras(paramBundle);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, new Object[] { "onReceiveNotice notifyid" + paramInt1 + "notifyUI url:", paramString2 });
        }
        paramString2 = BaseApplicationImpl.getContext();
        boolean bool = bbio.a(paramString2);
        if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) || (bool))
        {
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(localIntent);
          }
          paramString4 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
          paramString4.extraData.putStringArray("cmds", new String[] { ???, paramString3, ??? });
          paramString4.extraData.putParcelable("intent", localIntent);
          paramString4.extraData.putParcelable("bitmap", null);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(paramString4);
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt1, Integer.valueOf(paramInt2));
            if (bool)
            {
              ??? = (aseq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(72);
              if (SettingCloneUtil.readValue(paramString2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString2.getString(2131694019), "qqsetting_lock_screen_whenexit_key", true))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("PushNoticeManager", 2, "push notice start lsActivity from appinterface ");
                }
                ???.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong + "", paramInt2, false, paramInt1);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().notifyObservers(a());
            }
            avdf.a(paramInt2, 1);
            return;
            paramInt1 = 0;
          }
        }
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet() <= 3) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("PushNoticeManager", 2, "delay push notice reach the max retry");
    return;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(localIntent);
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void a(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward", -1);
    int j = paramIntent.getIntExtra("param_push_uinType", -1);
    int k = paramIntent.getIntExtra("param_push_notifyid", -1);
    String str1 = paramIntent.getStringExtra("param_push_fromuin");
    a(null, j);
    Intent localIntent;
    switch (i)
    {
    default: 
      i = j;
    case 3: 
      for (;;)
      {
        ThreadManager.post(new PushNoticeManager.1(this, i), 5, null, true);
        return;
        str1 = paramIntent.getStringExtra("url");
        localIntent = new Intent(paramContext, QQBrowserActivity.class);
        i = paramIntent.getIntExtra("uintype", -1);
        localIntent.putExtra("uintype", i);
        String str2 = paramIntent.getStringExtra("push_notice_service_id");
        String str3 = paramIntent.getStringExtra("push_notice_content_id");
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str2, str3, str1, "0X8009241", "点击业务Push");
        localIntent.putExtra("push_notice_service_id", str2);
        localIntent.putExtra("push_notice_content_id", str3);
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, "remove push notice");
        }
        localIntent.putExtra("url", str1);
        paramContext.startActivity(localIntent);
        b(paramContext, paramIntent);
        paramIntent.removeExtra("forward");
      }
    }
    if (j == 1041)
    {
      localIntent = actn.a(new Intent(paramContext, SplashActivity.class), null);
      localIntent.putExtra("uin", str1);
      localIntent.putExtra("uintype", 0);
      localIntent.putExtra("uinname", paramIntent.getStringExtra("uinname"));
      localIntent.putExtra("param_notifyid", k);
      localIntent.putExtra("enterchatwin", true);
      paramContext.startActivity(localIntent);
    }
    for (;;)
    {
      b(paramContext, paramIntent);
      paramIntent.removeExtra("forward");
      i = j;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("PushNoticeManager", 2, String.format("forward [uinType,notifyId,uin]=[%d,%d,%s]", new Object[] { Integer.valueOf(j), Integer.valueOf(k), str1 }));
      i = j;
      break;
      if (j == 1042)
      {
        localIntent = new Intent(paramContext, RecommendFriendActivity.class);
        localIntent.putExtra("EntranceId", 9);
        localIntent.putExtra("param_notifyid", k);
        localIntent.putExtra("may_know_recmmds", paramIntent.getSerializableExtra("may_know_recmmds"));
        paramContext.startActivity(localIntent);
      }
    }
  }
  
  public void a(QQNotificationManager paramQQNotificationManager, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PushNoticeManager", 2, "setRead " + paramInt);
    }
    this.jdField_a_of_type_Bfnk.removeMessages(1);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData = null;
    QQNotificationManager localQQNotificationManager = paramQQNotificationManager;
    if (paramQQNotificationManager == null) {}
    for (;;)
    {
      int i;
      try
      {
        localQQNotificationManager = QQNotificationManager.getInstance();
        paramQQNotificationManager = this.jdField_a_of_type_AndroidUtilSparseArray;
        i = 0;
        try
        {
          if (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
          {
            Integer localInteger1 = Integer.valueOf(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i));
            Integer localInteger2 = (Integer)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
            if ((localInteger1 == null) || ((paramInt >= 0) && (localInteger2 != null) && (localInteger2.intValue() != paramInt))) {
              break label233;
            }
            if (QLog.isColorLevel()) {
              QLog.d("PushNoticeManager", 2, String.format(Locale.getDefault(), "cancel push_notice [%d, %s]", new Object[] { Integer.valueOf(localInteger1.intValue()), "push_notification_tag" }));
            }
            localQQNotificationManager.cancelUseTag("PushNoticeManager_removeNotification", "push_notification_tag", localInteger1.intValue());
          }
        }
        finally {}
        this.jdField_a_of_type_AndroidUtilSparseArray.clear();
      }
      catch (Exception paramQQNotificationManager)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PushNoticeManager", 2, "setRead", paramQQNotificationManager);
        }
        return;
      }
      return;
      label233:
      i += 1;
    }
  }
  
  public void a(SubMsgType0x27.MsgBody paramMsgBody, short paramShort, long paramLong)
  {
    if ((paramMsgBody == null) || (paramMsgBody.msg_push_platform == null)) {
      return;
    }
    if ((paramShort == this.jdField_a_of_type_Short) && (paramLong == this.b))
    {
      QLog.w("PushNoticeManager", 1, "skip duplicated msg: " + paramShort + ", " + paramLong);
      return;
    }
    this.jdField_a_of_type_Short = paramShort;
    this.b = paramLong;
    Object localObject4 = paramMsgBody.msg_push_platform;
    int i = ((SubMsgType0x27.PushPlatform)localObject4).uint32_forward_type.get();
    if (i == 0) {
      i = 3;
    }
    while (i == 0)
    {
      QLog.w("PushNoticeManager", 1, "unknown forward type: " + i);
      return;
      if (i == 1) {
        i = 4;
      } else {
        i = 0;
      }
    }
    Object localObject3 = paramMsgBody.msg_client_report;
    paramLong = ((SubMsgType0x27.PushPlatform)localObject4).uint64_from_uin.get();
    this.jdField_a_of_type_Long = paramLong;
    String str = null;
    if (((SubMsgType0x27.PushPlatform)localObject4).str_desc.has()) {
      str = ((SubMsgType0x27.PushPlatform)localObject4).str_desc.get();
    }
    paramMsgBody = null;
    if (((SubMsgType0x27.PushPlatform)localObject4).str_target_url.has())
    {
      paramMsgBody = ((SubMsgType0x27.PushPlatform)localObject4).str_target_url.get();
      if (TextUtils.isEmpty(paramMsgBody)) {
        break label817;
      }
    }
    label809:
    label817:
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      long l;
      try
      {
        paramMsgBody = new String(aswx.a(paramMsgBody), "UTF-8");
        localObject1 = null;
        if (((SubMsgType0x27.PushPlatform)localObject4).str_title.has()) {
          localObject1 = ((SubMsgType0x27.PushPlatform)localObject4).str_title.get();
        }
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        if (QLog.isColorLevel()) {
          QLog.i("PushNoticeManager", 2, String.format(Locale.getDefault(), "onReceiveNotice [uin: %d wording: %s url: %s from: %s oriUrl:%s", new Object[] { Long.valueOf(paramLong), str, paramMsgBody, localObject2, ((SubMsgType0x27.PushPlatform)localObject4).str_target_url.get() }));
        }
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramMsgBody))) {
          break;
        }
        j = 1035;
        if (4 != i) {
          break label809;
        }
        if (TextUtils.equals(paramMsgBody, "newfrd_add")) {
          j = 1041;
        }
        if (TextUtils.equals(paramMsgBody, "newfrd_recommand")) {
          j = 1042;
        }
        avdf.a(j, 0);
        localObject1 = new Bundle();
        bool2 = false;
      }
      catch (Exception paramMsgBody)
      {
        try
        {
          bool1 = a((SubMsgType0x27.PushPlatform)localObject4, (Bundle)localObject1, j);
          if (!bool1) {
            break;
          }
          if (j == 1041)
          {
            paramLong = Long.valueOf(((Bundle)localObject1).getString("param_fromuin")).longValue();
            this.jdField_a_of_type_Long = paramLong;
          }
          if (QLog.isColorLevel()) {
            QLog.i("PushNoticeManager", 2, String.format("onReceiveNotice [uinType,uin]=[%d,%d]", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong) }));
          }
          this.jdField_a_of_type_Bfnk.removeMessages(1);
          localObject4 = new axqr();
          ((axqr)localObject4).e = "0X800923D";
          ((axqr)localObject4).d = "收到Push协议";
          ((axqr)localObject4).f = (((SubMsgType0x27.ClientReport)localObject3).uint32_service_id.get() + "");
          ((axqr)localObject4).i = ((SubMsgType0x27.ClientReport)localObject3).str_content_id.get();
          axqq.a(paramMsgBody, (axqr)localObject4);
          axqq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (axqr)localObject4);
          l = awzw.a();
          localObject3 = new RecentUser();
          ((RecentUser)localObject3).uin = (paramLong + "");
          ((RecentUser)localObject3).msgType = j;
          ((RecentUser)localObject3).setType(j);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData = new RecentItemNoticeData((RecentUser)localObject3);
            this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(j, paramLong, str, paramMsgBody, (String)localObject2, l);
            a(paramLong, str, paramMsgBody, (String)localObject2, i, j, ((axqr)localObject4).f, ((axqr)localObject4).i, (Bundle)localObject1);
            return;
            paramMsgBody = paramMsgBody;
            QLog.e("PushNoticeManager", 1, paramMsgBody, new Object[0]);
            paramMsgBody = null;
          }
        }
        catch (Exception localException)
        {
          boolean bool2;
          boolean bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("PushNoticeManager", 2, localException.getMessage(), localException);
          bool1 = bool2;
          continue;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(j, paramLong, str, paramMsgBody, (String)localObject2, l)) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.a(j, paramLong, str, paramMsgBody, (String)localObject2, l);
      a(paramLong, str, paramMsgBody, (String)localObject2, i, j, localException.f, localException.i, (Bundle)localObject1);
      return;
      int j = 1035;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData == null)
    {
      QLog.e("PushNoticeManager", 1, "recent data is null");
      return true;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.uin, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.wording, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.url, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.from, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.intent.getIntExtra("forward", -1), 0, this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.intent.getStringExtra("push_notice_service_id"), this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemNoticeData.intent.getStringExtra("push_notice_content_id"), null);
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PushNoticeManager", 2, "onDestroy");
    }
    a(null, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aseo
 * JD-Core Version:    0.7.0.1
 */