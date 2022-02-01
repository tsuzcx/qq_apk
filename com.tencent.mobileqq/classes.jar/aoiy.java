import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyContent;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.push_msg.PushMsg;

class aoiy
{
  private int jdField_a_of_type_Int;
  private bhau jdField_a_of_type_Bhau;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private List<bhau> jdField_a_of_type_JavaUtilList;
  private submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aoiy(boolean paramBoolean, List<bhau> paramList, bhau parambhau, int paramInt, StringBuilder paramStringBuilder, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum)
  {
    this.b = paramList;
    this.jdField_a_of_type_JavaUtilList = parambhau;
    this.jdField_a_of_type_Bhau = paramInt;
    this.jdField_a_of_type_Int = paramStringBuilder;
    this.jdField_a_of_type_JavaLangStringBuilder = paramSubCmd0x1UpdateAppUnreadNum;
    Object localObject;
    this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum = localObject;
  }
  
  private void a()
  {
    boolean bool;
    if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 101618516L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 troop mini app entrance.");
      }
      if (this.jdField_a_of_type_Bhau.b != 0)
      {
        bool = true;
        bguq.b(this.jdField_a_of_type_Aoip.app, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, bool);
        this.jdField_a_of_type_Aoip.notifyUI(136, true, new Object[] { this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) });
      }
    }
    label274:
    label365:
    do
    {
      submsgtype0x26.AppTipNotify localAppTipNotify;
      TroopManager localTroopManager;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                bool = false;
                break;
                if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1104445552L)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 homework.");
                  }
                  bgpk.a(this.jdField_a_of_type_Aoip.app, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
                  this.jdField_a_of_type_Aoip.notifyUI(61, true, new Object[] { this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, String.valueOf(1104445552), Boolean.valueOf(false) });
                  return;
                }
                if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1106611799L)
                {
                  bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "troop_game_feed", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
                  return;
                }
                if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long != 101509131L) {
                  break label274;
                }
              } while (this.jdField_a_of_type_Bhau.b <= 0);
              this.jdField_a_of_type_Aoip.a.d(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString);
              return;
              if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1106588005L)
              {
                bhlk.b(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "group_pad_template_tips", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, true);
                return;
              }
              if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1106664488L)
              {
                c();
                return;
              }
              if (!aoja.a(this.jdField_a_of_type_Aoip, this.jdField_a_of_type_Bhau, this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum, 2)) {
                break label365;
              }
            } while (!QLog.isColorLevel());
            QLog.d(".troop.survey", 2, "handleTroopNewsOnlinePush() msginfo handled by Oidb0xb36");
            return;
            if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 101796525L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TogetherControlManager", 2, "handleTroopNewsOnlinePush() for watching together.");
              }
              ((bejx)this.jdField_a_of_type_Aoip.app.getManager(339)).a(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b, this.jdField_a_of_type_Bhau.jdField_a_of_type_Int, this.jdField_a_of_type_Bhau);
              return;
            }
            if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long != 101818344L) {
              break label569;
            }
          } while (!this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has());
          localAppTipNotify = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
        } while (!localAppTipNotify.bytes_text.has());
        ((bggj)this.jdField_a_of_type_Aoip.app.getManager(346)).a(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, localAppTipNotify.bytes_text.get().toByteArray(), 0);
        localTroopManager = (TroopManager)this.jdField_a_of_type_Aoip.app.getManager(52);
      } while (localTroopManager == null);
      localTroopManager.a(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, localAppTipNotify.bytes_text.get().toByteArray(), 0);
      return;
    } while (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long != 101872323L);
    label569:
    if (this.jdField_a_of_type_Bhau.b > 0)
    {
      bguq.a(this.jdField_a_of_type_Aoip.app, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, true);
      this.jdField_a_of_type_Aoip.notifyUI(151, true, new Object[] { this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString });
      return;
    }
    bguq.a(this.jdField_a_of_type_Aoip.app, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, false);
  }
  
  private void a(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l1;
    if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has())
    {
      submsgtype0x26.AppTipNotify localAppTipNotify = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
      if ((localAppTipNotify.uint32_action.has()) && (localAppTipNotify.uint32_action.get() == 1)) {
        l1 = 0L;
      }
    }
    try
    {
      l2 = Long.parseLong(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString);
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        localNumberFormatException.printStackTrace();
        continue;
        long l2 = 0L;
      }
    }
    if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
    {
      l2 = paramArrayOfLong[0];
      if ((l1 > 0L) && (l2 > 0L))
      {
        paramArrayOfLong = ((QQAppInterface)this.jdField_a_of_type_Aoip.mApp).a();
        if (paramArrayOfLong != null)
        {
          paramArrayOfLong.a(8, l1, 2, paramInt1, paramInt2, paramInt3, 20, 1);
          paramArrayOfLong.b(l1, true);
          paramArrayOfLong.a(21, 1, l1, 0L);
        }
        VideoMsgTools.a((QQAppInterface)this.jdField_a_of_type_Aoip.mApp, 1, 13, false, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, Long.toString(l2), TextUtils.equals(this.jdField_a_of_type_Aoip.mApp.getCurrentAccountUin(), String.valueOf(l2)), null, TextUtils.equals(this.jdField_a_of_type_Aoip.mApp.getCurrentAccountUin(), String.valueOf(l2)), 2, new Object[0]);
      }
      return;
    }
  }
  
  private void b()
  {
    long l = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_id.uint64_app_id.get();
    this.jdField_a_of_type_Bhau = new bhau();
    this.jdField_a_of_type_Bhau.jdField_a_of_type_Long = l;
    this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.uint64_group_code.get());
    this.jdField_a_of_type_Bhau.b = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.sint32_unread_num.get();
    this.jdField_a_of_type_Int += this.jdField_a_of_type_Bhau.b;
    this.jdField_a_of_type_Bhau.jdField_a_of_type_Int = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.sint32_album_cnt.get();
    long[] arrayOfLong = null;
    int k = -1;
    int i;
    int j;
    if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has())
    {
      Object localObject = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
      if (((submsgtype0x26.AppTipNotify)localObject).opt_msg_app_notify_content.has())
      {
        localObject = (submsgtype0x26.AppNotifyContent)((submsgtype0x26.AppTipNotify)localObject).opt_msg_app_notify_content.get();
        List localList = ((submsgtype0x26.AppNotifyContent)localObject).opt_msg_app_notify_user.get();
        arrayOfLong = new long[localList.size()];
        i = 0;
        while (i < localList.size())
        {
          arrayOfLong[i] = ((submsgtype0x26.AppNotifyUser)localList.get(i)).opt_uint64_uin.get();
          i += 1;
        }
        i = ((submsgtype0x26.AppNotifyContent)localObject).room_mode.get();
        j = ((submsgtype0x26.AppNotifyContent)localObject).game_id.get();
        k = ((submsgtype0x26.AppNotifyContent)localObject).live_extra_mode.get();
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 2L)
      {
        bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "troop_photo_new", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
        bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "troop_album_feed", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
        bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "troop_photo_message", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.jdField_a_of_type_Int);
      }
      do
      {
        return;
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1L)
        {
          bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "troop_file_new", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1101236949L)
        {
          bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "troop_notification_new", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 21L)
        {
          msd.a().a(this.jdField_a_of_type_Aoip.app, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, new aojc(this.jdField_a_of_type_Aoip, this.jdField_a_of_type_Bhau, arrayOfLong));
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 23L)
        {
          a(arrayOfLong, i, j, k);
          ((awaa)this.jdField_a_of_type_Aoip.app.getManager(236)).a(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Aoip.app.a().a(1, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b, arrayOfLong, 14, i, j, k);
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1104651886L)
        {
          this.jdField_a_of_type_Aoip.app.a().a(1, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b, arrayOfLong, 10, i, j, k);
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1101484419L)
        {
          bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "group_activity_new_message", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bhau.b);
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1102858908L)
        {
          f();
          return;
        }
        if (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long == 1105933138L)
        {
          e();
          return;
        }
      } while (this.jdField_a_of_type_Bhau.jdField_a_of_type_Long != 1106180084L);
      d();
      return;
      j = 0;
      i = 0;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Bhau.b == -1) {
      bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aoip.notifyUI(125, true, new Object[] { "" + this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, Boolean.valueOf(true) }, false);
      return;
      bhlk.a(this.jdField_a_of_type_Aoip.app.getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, false);
    }
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "onLinePush receive 0x210_0x26_cmd0x1, [Enter Troop]");
    }
    Object localObject;
    push_msg.PushMsg localPushMsg;
    if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has())
    {
      localObject = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
      localPushMsg = new push_msg.PushMsg();
    }
    try
    {
      localPushMsg.mergeFrom(((submsgtype0x26.AppTipNotify)localObject).bytes_text.get().toByteArray());
      if (localPushMsg.rc.get() == 0)
      {
        localObject = new bfug(((group_effect.EffectInfo)localPushMsg.effect_info.get()).effect_id.get(), "" + localPushMsg.uin.get(), "" + localPushMsg.group_code.get(), localPushMsg.svip_level.get(), localPushMsg.svip_type.get(), localPushMsg.group_level.get(), localPushMsg.set_mode.get());
        this.jdField_a_of_type_Aoip.a((bfug)localObject);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopEnterEffect", 2, "onLinePush receive 0x210_0x8ca error: " + QLog.getStackTraceString(localInvalidProtocolBufferMicroException));
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bhau.b == -1)
    {
      HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_Aoip.app.getManager(60)).a(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString);
      if ((localHotChatInfo != null) && (localHotChatInfo.isBuLuoHotChat()))
      {
        localHotChatInfo.setHasRedPoint();
        this.jdField_a_of_type_Aoip.notifyUI(90, true, new Object[] { this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString });
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandlerQ.hotchat.aio_post_red_point", 2, "handleTroopNewsOnlinePush, msgInfo.nNewNum:" + this.jdField_a_of_type_Bhau.b);
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_Bhau.b == -1) || (this.jdField_a_of_type_Bhau.b > 0))
    {
      ChatActivityUtils.a(this.jdField_a_of_type_Aoip.app, this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString, Integer.valueOf(-1));
      this.b = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i(".troop.notify_feeds.data", 2, "handleTroopNewsOnlinePush, troopUin=" + this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString + ", nNewNum=" + this.jdField_a_of_type_Bhau.b);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public aoiy a()
  {
    if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.troopgetnews..troop.notification_center", 4, "unreadNum is null");
      }
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    b();
    a();
    if (QLog.isDevelopLevel()) {
      this.jdField_a_of_type_JavaLangStringBuilder.append("add photoinfo, groupCode = ").append(this.jdField_a_of_type_Bhau.jdField_a_of_type_JavaLangString).append(", appid = ").append(this.jdField_a_of_type_Bhau.jdField_a_of_type_Long).append(", messageNum = ").append(this.jdField_a_of_type_Bhau.jdField_a_of_type_Int).append(", newPhotoes = ").append(this.jdField_a_of_type_Bhau.b);
    }
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_Bhau);
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public bhau a()
  {
    return this.jdField_a_of_type_Bhau;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoiy
 * JD-Core Version:    0.7.0.1
 */