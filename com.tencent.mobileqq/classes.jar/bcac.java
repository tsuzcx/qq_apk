import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.ExtGroupKeyInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.group.broadcast.BroadcastMsgCtr.ExtGroupInfo;
import tencent.im.group.broadcast.BroadcastMsgCtr.ExtJoinGroupInfo;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcac
  implements bbzr
{
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, msg_comm.MsgHead paramMsgHead)
  {
    Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
    Long localLong = Long.valueOf(Long.parseLong((String)localObject2));
    String str2 = String.valueOf(paramLong1);
    Object localObject1 = (msg_comm.ExtGroupKeyInfo)paramMsgHead.ext_group_key_info.get();
    long l2 = ((msg_comm.ExtGroupKeyInfo)localObject1).cur_max_seq.get();
    long l3 = ((msg_comm.ExtGroupKeyInfo)localObject1).cur_time.get();
    paramLong2 = 0L;
    int j = 0;
    Object localObject3 = new BroadcastMsgCtr.ExtGroupInfo();
    long l1 = paramLong2;
    if (((msg_comm.ExtGroupKeyInfo)localObject1).bytes_ext_group_info.has()) {
      l1 = paramLong2;
    }
    for (;;)
    {
      try
      {
        ((BroadcastMsgCtr.ExtGroupInfo)localObject3).mergeFrom(((msg_comm.ExtGroupKeyInfo)localObject1).bytes_ext_group_info.get().toByteArray());
        l1 = paramLong2;
        if (!((BroadcastMsgCtr.ExtGroupInfo)localObject3).ext_join_group_info.has()) {
          break label2146;
        }
        l1 = paramLong2;
        paramLong2 = ((BroadcastMsgCtr.ExtGroupInfo)localObject3).ext_join_group_info.uint64_share_uin.get();
        l1 = paramLong2;
        i = ((BroadcastMsgCtr.ExtGroupInfo)localObject3).ext_join_group_info.enmum_join_group_type.get();
        j = i;
        if (QLog.isColorLevel()) {
          QLog.d("GrayTipsForTroop", 2, "0x21 troopUin = " + paramLong1 + " maxseq = " + l2 + ", maxTime = " + l3 + ", member = " + paramString1 + ", adminUin" + paramString2 + ", cOpt" + paramInt);
        }
        localObject3 = "" + paramMsgHead.auth_uin.get();
        localObject1 = paramMsgHead.auth_nick.get();
        paramMsgHead.auth_sex.get();
        if ((TextUtils.isEmpty((CharSequence)localObject3)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject3).equals(paramString1))) {
          break label2139;
        }
        paramMsgHead = (msg_comm.MsgHead)localObject1;
        if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!((String)localObject2).equals(paramString1))) {
          break label355;
        }
        anni.a(2131700088);
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      paramLong2 = l1;
      continue;
      label355:
      if (TextUtils.isEmpty(paramMsgHead)) {}
      for (Object localObject4 = anqc.a(paramQQAppInterface, paramString1, str2);; localObject4 = paramMsgHead) {
        for (;;)
        {
          String str1;
          Object localObject5;
          Object localObject6;
          boolean bool;
          try
          {
            l1 = Long.parseLong((String)localObject3);
            if ((paramInt == -126) || (paramInt == 2))
            {
              int k = 0;
              if (paramLong2 > 0L)
              {
                paramMsgHead = (String)localObject4 + anni.a(2131700097);
                paramString2 = anqc.a(paramQQAppInterface, String.valueOf(paramLong2), str2);
                i = k;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  i = k;
                  if (((String)localObject2).equals(String.valueOf(paramLong2))) {
                    i = 1;
                  }
                }
                if (j == 1)
                {
                  paramMsgHead = paramMsgHead + anni.a(2131700096);
                  localObject2 = paramMsgHead + paramString2 + anni.a(2131700098);
                  str1 = paramString2;
                  paramString2 = (String)localObject2;
                  localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
                  localObject5 = ((TroopManager)localObject2).c(((TroopManager)localObject2).c(str2));
                  if ((localObject5 == null) || (((TroopInfo)localObject5).cGroupOption != 2)) {
                    continue;
                  }
                  localObject3 = paramQQAppInterface.getApp().getApplicationContext().getString(2131696688);
                  if (!a(str2, paramQQAppInterface)) {
                    break label2125;
                  }
                  paramString2 = paramString2 + "，" + (String)localObject3;
                  localObject2 = "";
                  localObject6 = (MessageForGrayTips)bbzh.a(-1012);
                  ((MessageForGrayTips)localObject6).init(localLong.longValue(), paramLong1, l1, paramString2, l3, -1012, 1, paramLong3);
                  ((MessageForGrayTips)localObject6).shmsgseq = l2;
                  ((MessageForGrayTips)localObject6).switch2HightlightMsg();
                  Bundle localBundle = new Bundle();
                  localBundle.putInt("key_action", 5);
                  localBundle.putString("troop_mem_uin", paramString1);
                  localBundle.putBoolean("need_update_nick", false);
                  ((MessageForGrayTips)localObject6).addHightlightItem(0, ((String)localObject4).length(), localBundle);
                  ((MessageForGrayTips)localObject6).saveExtInfoToExtStr("troop_new_member_uin", paramString1);
                  if ((!str1.isEmpty()) && (i == 0))
                  {
                    localObject4 = new Bundle();
                    ((Bundle)localObject4).putInt("key_action", 5);
                    ((Bundle)localObject4).putString("troop_mem_uin", String.valueOf(paramLong2));
                    ((Bundle)localObject4).putBoolean("need_update_nick", false);
                    ((MessageForGrayTips)localObject6).addHightlightItem(paramMsgHead.length(), paramMsgHead.length() + str1.length(), (Bundle)localObject4);
                    ((MessageForGrayTips)localObject6).saveExtInfoToExtStr("troop_new_member_uin", String.valueOf(paramLong2));
                  }
                  if ((localObject5 == null) || (((TroopInfo)localObject5).cGroupOption != 2)) {
                    continue;
                  }
                  if (a(str2, paramQQAppInterface))
                  {
                    paramMsgHead = new Bundle();
                    paramMsgHead.putInt("key_action", 19);
                    paramMsgHead.putString("troop_mem_uin", paramString1);
                    paramMsgHead.putString("troopUin", str2);
                    ((MessageForGrayTips)localObject6).addHightlightItem(paramString2.length() - ((String)localObject3).length(), paramString2.length(), paramMsgHead);
                  }
                  ((MessageForGrayTips)localObject6).isread = true;
                  paramMsgHead = (bfuk)paramQQAppInterface.getManager(81);
                  if ((!a((MessageRecord)localObject6, paramQQAppInterface)) && (!paramMsgHead.a(paramLong1 + "", paramLong3))) {
                    continue;
                  }
                  bool = true;
                  if (!bool)
                  {
                    paramQQAppInterface.a().a((MessageRecord)localObject6, String.valueOf(localLong));
                    paramMsgHead = ((anwd)paramQQAppInterface.a(20)).a();
                    if ((paramMsgHead.b("newMember")) && (paramMsgHead.a(str2))) {
                      paramMsgHead.c(str2, paramString1);
                    }
                    new bcsy(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar").a(new String[] { str2, "", "" + bfup.b(paramQQAppInterface, str2) }).a();
                  }
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("TroopAddMemberBroadcast", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + paramString2 + "|msgFilter:" + bool);
                  return;
                }
              }
            }
          }
          catch (Exception paramMsgHead)
          {
            QLog.e("GrayTipsForTroop", 1, "senderUin=" + 0L, paramMsgHead);
            l1 = paramLong1;
            continue;
            localObject2 = paramMsgHead + paramString2 + anni.a(2131700099);
            str1 = paramString2;
            paramString2 = (String)localObject2;
            continue;
            paramString2 = (String)localObject4 + anni.a(2131700086);
            paramMsgHead = "";
            i = 0;
            str1 = "";
            continue;
            localObject2 = paramQQAppInterface.getApp().getApplicationContext().getString(2131696689);
            paramString2 = paramString2 + "，" + (String)localObject2;
            localObject3 = "";
            continue;
            paramMsgHead = new Bundle();
            paramMsgHead.putInt("key_action", 48);
            paramMsgHead.putString("troop_mem_uin", paramString1);
            paramMsgHead.putString("troopUin", str2);
            ((MessageForGrayTips)localObject6).addHightlightItem(paramString2.length() - ((String)localObject2).length(), paramString2.length(), paramMsgHead);
            continue;
            bool = false;
            continue;
          }
          if (((paramInt != -125) && (paramInt != 3)) || (((berf)paramQQAppInterface.getManager(32)).a(str2, (String)localObject3))) {
            break;
          }
          paramMsgHead = anqc.a(paramQQAppInterface, paramString2, str2);
          i = 0;
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).equals(paramString2)))
          {
            paramMsgHead = anni.a(2131700085);
            i = 1;
          }
          for (;;)
          {
            if (i != 0)
            {
              str1 = paramMsgHead + anni.a(2131700087);
              label1518:
              localObject2 = str1 + (String)localObject4 + anni.a(2131700094);
              localObject3 = paramQQAppInterface.getApp().getApplicationContext().getString(2131696689);
              localObject2 = (String)localObject2 + "，" + (String)localObject3;
              localObject5 = (MessageForGrayTips)bbzh.a(-1012);
              ((MessageForGrayTips)localObject5).init(localLong.longValue(), paramLong1, l1, (String)localObject2, l3, -1012, 1, paramLong3);
              ((MessageForGrayTips)localObject5).switch2HightlightMsg();
              ((MessageForGrayTips)localObject5).shmsgseq = l2;
              if (i == 0)
              {
                localObject6 = new Bundle();
                ((Bundle)localObject6).putInt("key_action", 5);
                ((Bundle)localObject6).putString("troop_mem_uin", paramString2);
                ((Bundle)localObject6).putBoolean("need_update_nick", false);
                ((MessageForGrayTips)localObject5).addHightlightItem(0, paramMsgHead.length(), (Bundle)localObject6);
              }
              paramString2 = new Bundle();
              paramString2.putInt("key_action", 5);
              paramString2.putString("troop_mem_uin", paramString1);
              paramString2.putBoolean("need_update_nick", false);
              ((MessageForGrayTips)localObject5).addHightlightItem(str1.length(), str1.length() + ((String)localObject4).length(), paramString2);
              ((MessageForGrayTips)localObject5).saveExtInfoToExtStr("troop_new_member_uin", paramString1);
              paramString2 = new Bundle();
              paramString2.putInt("key_action", 48);
              paramString2.putString("troop_mem_uin", paramString1);
              paramString2.putString("troopUin", str2);
              ((MessageForGrayTips)localObject5).addHightlightItem(((String)localObject2).length() - ((String)localObject3).length(), ((String)localObject2).length(), paramString2);
              ((MessageForGrayTips)localObject5).isread = true;
              paramString2 = (bfuk)paramQQAppInterface.getManager(81);
              if ((!a((MessageRecord)localObject5, paramQQAppInterface)) && (!paramString2.a(paramLong1 + "", paramLong3))) {
                break label2116;
              }
            }
            label2116:
            for (bool = true;; bool = false)
            {
              if (!bool)
              {
                paramQQAppInterface.a().a((MessageRecord)localObject5, String.valueOf(localLong));
                paramString2 = ((anwd)paramQQAppInterface.a(20)).a();
                if ((paramString2.b("newMember")) && (paramString2.a(str2))) {
                  paramString2.c(str2, paramString1);
                }
                new bcsy(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar").a(new String[] { str2, "", "" + bfup.b(paramQQAppInterface, str2) }).a();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("TroopAddMemberBroadcast", 2, "seq:" + paramLong3 + "|cOpt:" + paramInt + "|tips:" + (String)localObject2 + "|msgFilter:" + bool);
              return;
              str1 = paramMsgHead + anni.a(2131700092);
              break label1518;
            }
          }
          label2125:
          localObject2 = "";
        }
      }
      label2139:
      paramMsgHead = "";
      continue;
      label2146:
      int i = 0;
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    return anqc.a(paramQQAppInterface, paramMessageRecord, false);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    paramMsg = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = bgjw.a(paramMsg, 0);
    int i = paramMsg[4];
    String str = String.valueOf(bgjw.a(paramMsg, 5));
    i = paramMsg[9];
    long l2 = bgjw.a(paramMsg, 10);
    int j = paramMsg[14];
    try
    {
      new String(paramMsg, 15, j, "GBK");
      if (!parambbyn.d)
      {
        a(paramMessageHandler.app, i, str, String.valueOf(l2), l1, paramList.msg_time.get(), paramList.msg_seq.get(), paramList);
        ((anwd)paramMessageHandler.app.a(20)).a(l1 + "", str, paramList.auth_nick.get());
        paramMsg = new ArrayList();
        paramMsg.add(new Pair(Long.valueOf(paramList.from_uin.get()), Long.valueOf(paramList.msg_time.get())));
        ((acvt)paramMessageHandler.a("c2c_processor")).a(paramMsg);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        new String(paramMsg, 15, j);
      }
    }
  }
  
  protected boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface == null) {
      return false;
    }
    paramString = paramQQAppInterface.b(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isAdmin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcac
 * JD-Core Version:    0.7.0.1
 */