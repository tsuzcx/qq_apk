import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgcomm.msg_comm.MsgType0x210;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.BirthdayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MemorialDayNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneBirthdayFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.OneMemorialDayInfo;

public class bbmm
  implements bbnb
{
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = paramQQAppInterface.getMessageFacade().getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
    Object localObject1 = new SubMsgType0x76.MsgBody();
    int j;
    int i;
    try
    {
      ((SubMsgType0x76.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      j = ((SubMsgType0x76.MsgBody)localObject1).uint32_msg_type.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder().append("receive push, msg type = ").append(j).append(", local msg count = ");
        if (localObject2 != null)
        {
          i = ((List)localObject2).size();
          QLog.d("ActivateFriends.Processor", 2, i);
        }
      }
      else
      {
        if (localObject2 == null) {
          break label247;
        }
        paramArrayOfByte = ((List)localObject2).iterator();
        for (;;)
        {
          label110:
          if (paramArrayOfByte.hasNext())
          {
            localObject2 = (MessageRecord)paramArrayOfByte.next();
            if ((localObject2 instanceof MessageForActivateFriends))
            {
              localObject2 = (MessageForActivateFriends)localObject2;
              if ((((MessageForActivateFriends)localObject2).getMsgBody() != null) && (((MessageForActivateFriends)localObject2).getMsgBody().uint32_msg_type.get() != j)) {
                continue;
              }
              paramQQAppInterface.getMessageFacade().removeMsgByUniseq(AppConstants.ACTIVATE_FRIENDS_UIN, 0, ((MessageForActivateFriends)localObject2).uniseq);
              continue;
              return false;
            }
          }
        }
      }
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends", 2, "parse push got error.", paramQQAppInterface);
      }
    }
    label247:
    aneo localaneo;
    label386:
    do
    {
      i = -1;
      break;
      if (!QLog.isColorLevel()) {
        break label110;
      }
      QLog.e("ActivateFriends.Processor", 2, "local data is error." + localObject2);
      break label110;
      paramArrayOfByte = bbli.a(-5003);
      paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
      paramArrayOfByte.frienduin = AppConstants.ACTIVATE_FRIENDS_UIN;
      paramArrayOfByte.istroop = 9002;
      paramArrayOfByte.senderuin = "";
      localaneo = (aneo)paramQQAppInterface.getManager(85);
      if (j != 1) {
        break label555;
      }
      if (((SubMsgType0x76.MsgBody)localObject1).msg_geographic_notify.rpt_msg_one_friend.get().size() <= 0) {
        break label537;
      }
      localObject2 = (MessageForActivateFriends)paramArrayOfByte;
      ((MessageForActivateFriends)localObject2).msg = aneo.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgBody = ((SubMsgType0x76.MsgBody)localObject1);
      ((MessageForActivateFriends)localObject2).msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
      break label852;
      bcef.b(paramQQAppInterface, "CliOper", "", "", (String)localObject1, (String)localObject2, localaneo.a, 0, "", "", "", "");
    } while (paramArrayOfByte == null);
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends", 2, "activiate_friends|rec msg  fromUin:" + paramLong1 + " toUin:" + paramLong2 + " seq:" + paramInt1);
    }
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_from_uin", String.valueOf(paramLong1));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_to_uin", String.valueOf(paramLong2));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_seq", String.valueOf(paramInt1));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_type", String.valueOf(paramInt2));
    paramArrayOfByte.saveExtInfoToExtStr("key_msg_ext_msg_sub_type", String.valueOf(paramInt3));
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add(paramArrayOfByte);
    paramQQAppInterface.getMessageFacade().addMessage((ArrayList)localObject1, paramQQAppInterface.getCurrentAccountUin(), paramQQAppInterface.isBackgroundStop);
    localaneo.a(j);
    return true;
    label537:
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends", 2, "Geo friend list size = 0");
      break label889;
      label555:
      MessageForActivateFriends localMessageForActivateFriends;
      if (j == 2)
      {
        localObject2 = ((SubMsgType0x76.MsgBody)localObject1).msg_birthday_notify.rpt_msg_one_friend.get();
        if (((List)localObject2).size() > 0)
        {
          localMessageForActivateFriends = (MessageForActivateFriends)paramArrayOfByte;
          localMessageForActivateFriends.msgBody = ((SubMsgType0x76.MsgBody)localObject1);
          localMessageForActivateFriends.msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
          localMessageForActivateFriends.msg = aneo.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
          label621:
          localObject1 = new HashSet();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Set)localObject1).add(String.valueOf(((SubMsgType0x76.OneBirthdayFriend)((Iterator)localObject2).next()).uint64_uin.get()));
          }
        }
        if (!QLog.isColorLevel()) {
          break label894;
        }
        QLog.d("ActivateFriends", 2, "Birth friend list size = 0");
        break label894;
        paramQQAppInterface.getMsgCache().a((Set)localObject1);
      }
      else
      {
        if (j != 3) {
          break label904;
        }
        localObject2 = ((SubMsgType0x76.MsgBody)localObject1).msg_memorialday_notify.rpt_anniversary_info.get();
        if (((List)localObject2).size() > 0)
        {
          localObject2 = (SubMsgType0x76.OneMemorialDayInfo)((List)localObject2).get(0);
          localMessageForActivateFriends = (MessageForActivateFriends)paramArrayOfByte;
          localMessageForActivateFriends.msgBody = ((SubMsgType0x76.MsgBody)localObject1);
          localMessageForActivateFriends.msgData = ((SubMsgType0x76.MsgBody)localObject1).toByteArray();
          localMessageForActivateFriends.msg = aneo.a(paramQQAppInterface.getApp(), (SubMsgType0x76.MsgBody)localObject1);
          bcef.b(paramQQAppInterface, "dc00898", "", "", "0X8007AD4", "0X8007AD4", (int)((SubMsgType0x76.OneMemorialDayInfo)localObject2).uint32_type.get(), 0, "", "", "", "");
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label899;
          }
          QLog.d("ActivateFriends", 2, "Memorial friend list size = 0");
          break label899;
        }
      }
    }
    label899:
    label904:
    label909:
    label915:
    for (;;)
    {
      localObject2 = "0X8004E04";
      break;
      label852:
      if ((j == 1) || (j == 2)) {
        if (j != 1) {
          break label909;
        }
      }
      for (localObject1 = "0X8004E03";; localObject1 = "0X8004E04")
      {
        if (j != 1) {
          break label915;
        }
        localObject2 = "0X8004E03";
        break;
        label889:
        paramArrayOfByte = null;
        break label852;
        label894:
        paramArrayOfByte = null;
        break label621;
        paramArrayOfByte = null;
        break label852;
        paramArrayOfByte = null;
        break label852;
        break label386;
      }
    }
  }
  
  public void a(msg_comm.MsgType0x210 paramMsgType0x210, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbkm parambbkm, MessageHandler paramMessageHandler)
  {
    long l1 = paramMsg.msg_head.to_uin.get();
    long l2 = paramMsg.msg_head.from_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l3 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    if (a(paramMessageHandler.app, paramMsgType0x210.msg_content.get().toByteArray(), l2, l1, i, j, paramMsgType0x210.sub_msg_type.get())) {
      paramMessageHandler.a().a("handleActivateFriendsPush2", true, 1, true, false);
    }
    bblf.a(paramMessageHandler, l2, i, l3, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmm
 * JD-Core Version:    0.7.0.1
 */