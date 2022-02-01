package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopHandler;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.s2c.msgtype0x210.submsgtype0x94.Submsgtype0x94.MsgBody;

public class SubType0x94
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
{
  private static void a(QQAppInterface paramQQAppInterface, MsgType0x210 paramMsgType0x210)
  {
    Object localObject1 = new Submsgtype0x94.MsgBody();
    try
    {
      ((Submsgtype0x94.MsgBody)localObject1).mergeFrom(paramMsgType0x210.vProtobuf);
      label19:
      if (((Submsgtype0x94.MsgBody)localObject1).str_folder_msg.has()) {
        paramMsgType0x210 = ((Submsgtype0x94.MsgBody)localObject1).str_folder_msg.get().trim();
      } else {
        paramMsgType0x210 = "";
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("diy string:");
        ((StringBuilder)localObject2).append(paramMsgType0x210);
        QLog.i("EcShopAssistantActivity", 2, ((StringBuilder)localObject2).toString());
      }
      boolean bool2;
      if (((Submsgtype0x94.MsgBody)localObject1).uint32_discover_reddot_flag.get() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool1;
      if (((Submsgtype0x94.MsgBody)localObject1).uint32_folder_reddot_flag.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool3;
      if (((Submsgtype0x94.MsgBody)localObject1).uint32_discount_reddot_flag.get() == 1) {
        bool3 = true;
      } else {
        bool3 = false;
      }
      boolean bool4;
      if (((Submsgtype0x94.MsgBody)localObject1).uint32_nearby_reddot_flag.get() == 1) {
        bool4 = true;
      } else {
        bool4 = false;
      }
      boolean bool5;
      if (((Submsgtype0x94.MsgBody)localObject1).uint32_mine_reddot_flag.get() == 1) {
        bool5 = true;
      } else {
        bool5 = false;
      }
      int k = ((Submsgtype0x94.MsgBody)localObject1).uint32_start_ts.get();
      int m = ((Submsgtype0x94.MsgBody)localObject1).uint32_end_ts.get();
      int n = (int)(System.currentTimeMillis() / 1000L);
      int i = ((Submsgtype0x94.MsgBody)localObject1).uint32_period_of_validity.get();
      int i1 = ((Submsgtype0x94.MsgBody)localObject1).uint32_task_type.get();
      String str1 = ((Submsgtype0x94.MsgBody)localObject1).str_task_info.get();
      String str2 = ((Submsgtype0x94.MsgBody)localObject1).str_type_name.get();
      String str3 = ((Submsgtype0x94.MsgBody)localObject1).str_type_color.get();
      Object localObject2 = ((Submsgtype0x94.MsgBody)localObject1).str_jump_url.get();
      int i2 = ((Submsgtype0x94.MsgBody)localObject1).uint32_task_id.get();
      Object localObject3;
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("reddot start=");
        ((StringBuilder)localObject3).append(k);
        ((StringBuilder)localObject3).append(",end=");
        ((StringBuilder)localObject3).append(m);
        ((StringBuilder)localObject3).append(",showtime=");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append("flags:");
        ((StringBuilder)localObject3).append(bool1);
        ((StringBuilder)localObject3).append(",");
        ((StringBuilder)localObject3).append(bool2);
        ((StringBuilder)localObject3).append(",");
        ((StringBuilder)localObject3).append(bool3);
        ((StringBuilder)localObject3).append(",");
        ((StringBuilder)localObject3).append(bool4);
        ((StringBuilder)localObject3).append(",");
        ((StringBuilder)localObject3).append(bool5);
        ((StringBuilder)localObject3).append(",type:");
        ((StringBuilder)localObject3).append(i1);
        ((StringBuilder)localObject3).append(",taskInfo:");
        ((StringBuilder)localObject3).append(str1);
        ((StringBuilder)localObject3).append(",typeName:");
        ((StringBuilder)localObject3).append(str2);
        ((StringBuilder)localObject3).append(",typeColor:");
        ((StringBuilder)localObject3).append(str3);
        ((StringBuilder)localObject3).append(",jumpUrl:");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.i("EcShopAssistantActivity", 2, ((StringBuilder)localObject3).toString());
      }
      if (n >= k)
      {
        if (n > m) {
          return;
        }
        int j = 172800000;
        if (i > 172800000) {
          i = j;
        }
        if ((!bool2) && (!bool3) && (!bool4) && (!bool5)) {
          break label587;
        }
        bool1 = true;
        label587:
        if (!bool1)
        {
          if ((!bool2) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_discover_reddot_flag.get() != 1)) {
            bool2 = false;
          } else {
            bool2 = true;
          }
          if ((!bool3) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_discount_reddot_flag.get() != 1)) {
            bool3 = false;
          } else {
            bool3 = true;
          }
          if ((!bool4) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_nearby_reddot_flag.get() != 1)) {
            bool4 = false;
          } else {
            bool4 = true;
          }
          if ((!bool5) && (((Submsgtype0x94.MsgBody)localObject1).uint32_only_mine_reddot_flag.get() != 1)) {
            bool5 = false;
          } else {
            bool5 = true;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("new flag:");
            ((StringBuilder)localObject1).append(bool2);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(bool3);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(bool4);
            ((StringBuilder)localObject1).append(",");
            ((StringBuilder)localObject1).append(bool5);
            QLog.i("EcShopAssistantActivity", 2, ((StringBuilder)localObject1).toString());
          }
        }
        localObject1 = localObject2;
        localObject3 = paramQQAppInterface.getCurrentAccountUin();
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = "noLogin";
        }
        localObject3 = paramQQAppInterface.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ecshop_sp");
        localStringBuilder.append((String)localObject2);
        localObject3 = ((BaseApplication)localObject3).getSharedPreferences(localStringBuilder.toString(), 0);
        localObject2 = ((SharedPreferences)localObject3).edit();
        if ((!((SharedPreferences)localObject3).getBoolean("disc_reddot", false)) && (!((SharedPreferences)localObject3).getBoolean("welfare_reddot", false)) && (!((SharedPreferences)localObject3).getBoolean("nearby_reddot", false)) && (!((SharedPreferences)localObject3).getBoolean("mine_reddot", false)) && (!((SharedPreferences)localObject3).getBoolean("folder_reddot", false))) {
          break label1120;
        }
        j = ((SharedPreferences)localObject3).getInt("last_show_time1", 0);
        int i3 = ((SharedPreferences)localObject3).getInt("reddot_start", 0);
        int i4 = ((SharedPreferences)localObject3).getInt("reddot_end", 0);
        int i5 = ((SharedPreferences)localObject3).getInt("max_reddot_time", 0);
        int i6 = (int)(System.currentTimeMillis() / 1000L);
        if ((i6 != 0) && (i3 != 0) && (i4 != 0) && (i5 != 0) && ((i6 < i3) || (i6 > i4) || (i6 - j >= i5)))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EcShopAssistantActivity", 2, "online push found reddot out of date!");
          }
          ((SharedPreferences.Editor)localObject2).putBoolean("disc_reddot", false);
          ((SharedPreferences.Editor)localObject2).putBoolean("welfare_reddot", false);
          ((SharedPreferences.Editor)localObject2).putBoolean("nearby_reddot", false);
          ((SharedPreferences.Editor)localObject2).putBoolean("mine_reddot", false);
          ((SharedPreferences.Editor)localObject2).putBoolean("folder_reddot", false);
        }
        label1120:
        ((SharedPreferences.Editor)localObject2).putInt("reddot_start", k);
        ((SharedPreferences.Editor)localObject2).putInt("reddot_end", m);
        ((SharedPreferences.Editor)localObject2).putInt("max_reddot_time", i);
        ((SharedPreferences.Editor)localObject2).putString("str_ecshop_diy", paramMsgType0x210);
        ((SharedPreferences.Editor)localObject2).putInt("last_show_time1", n);
        ((SharedPreferences.Editor)localObject2).putInt("PUSH_TASK_TYPE", i1);
        ((SharedPreferences.Editor)localObject2).putString("PUSH_TASK_INFO", str1);
        ((SharedPreferences.Editor)localObject2).putString("PUSH_TYPE_NAME", str2);
        ((SharedPreferences.Editor)localObject2).putString("PUSH_TYPE_COLOR", str3);
        ((SharedPreferences.Editor)localObject2).putLong("PUSH_RECEIVE_TIME", NetConnInfoCenter.getServerTime());
        ((SharedPreferences.Editor)localObject2).putInt("PUSH_TASK_ID", i2);
        if (localObject1 == null) {
          localObject1 = "";
        }
        ((SharedPreferences.Editor)localObject2).putString("PUSH_JUMP_URL", (String)localObject1);
        ((SharedPreferences.Editor)localObject2).putInt("FOLDER_MSG_TYPE", 1);
        ((SharedPreferences.Editor)localObject2).putBoolean("folder_reddot", bool1);
        ((SharedPreferences.Editor)localObject2).putBoolean("disc_reddot", bool2);
        ((SharedPreferences.Editor)localObject2).putBoolean("welfare_reddot", bool3);
        ((SharedPreferences.Editor)localObject2).putBoolean("nearby_reddot", bool4);
        ((SharedPreferences.Editor)localObject2).putBoolean("mine_reddot", bool5);
        ((SharedPreferences.Editor)localObject2).commit();
        if (bool1)
        {
          ((EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(NetConnInfoCenter.getServerTime(), bool1);
        }
        else
        {
          paramMsgType0x210 = paramQQAppInterface.getHandler(Conversation.class);
          if (paramMsgType0x210 != null) {
            paramMsgType0x210.sendEmptyMessage(1009);
          }
        }
        ((EcShopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.ECSHOP_HANDLER)).a();
        paramMsgType0x210 = null;
        if (bool2) {
          paramMsgType0x210 = "Arrived_shopdiscover_dot";
        }
        for (;;)
        {
          break;
          if (bool3) {
            paramMsgType0x210 = "Arrived_shoppreferential_dot";
          } else if (bool4) {
            paramMsgType0x210 = "Arrived_shopnearbynot_dot";
          } else if (bool5) {
            paramMsgType0x210 = "Arrived_shopmynot_dot";
          } else if (bool1) {
            paramMsgType0x210 = "Arrived_folder_dot";
          }
        }
        ReportController.b(paramQQAppInterface, "dc00898", "", "", "Shop_folder", paramMsgType0x210, 0, 0, "", "", "", "");
      }
      return;
    }
    catch (Throwable paramMsgType0x210)
    {
      break label19;
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a((QQAppInterface)paramOnLinePushMessageProcessor.a(), paramMsgType0x210);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x94
 * JD-Core Version:    0.7.0.1
 */