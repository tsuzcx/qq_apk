import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype31;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;

public class arde
{
  public static List<MessageRecord> a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return paramQQAppInterface.a().a(paramString, paramInt, new int[] { -2076 }, 5);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    paramString = b(paramQQAppInterface, paramInt, paramString);
    if (paramString != null)
    {
      paramInt = 0;
      if (paramInt < paramString.size())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramString.get(paramInt);
        if ((localMessageRecord instanceof MessageForLocationShare))
        {
          if (paramInt != paramString.size() - 1) {
            break label69;
          }
          a(paramQQAppInterface, localMessageRecord, paramBoolean);
        }
        for (;;)
        {
          paramInt += 1;
          break;
          label69:
          a(paramQQAppInterface, localMessageRecord, false);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageUtil", 2, new Object[] { "updateAllLbsMsgState: invoked. ", " lbsMsgs: ", paramString, " lbsMsgs.size(): ", Integer.valueOf(paramString.size()) });
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    MessageForLocationShare localMessageForLocationShare;
    if ((paramMessageRecord instanceof MessageForLocationShare))
    {
      localMessageForLocationShare = (MessageForLocationShare)paramMessageRecord;
      if (localMessageForLocationShare.isSharingLocation == paramBoolean) {
        break label79;
      }
      localMessageForLocationShare.isSharingLocation = paramBoolean;
      paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, localMessageForLocationShare.convertToMsgData());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageUtil", 2, new Object[] { "updateMsgSharingState: invoked. updateMsgContentByUniseq to false ", " locationShare: ", localMessageForLocationShare });
      }
      return;
      label79:
      if (QLog.isColorLevel()) {
        QLog.d("LocationMessageUtil", 2, "updateMsgSharingState: invoked. state ok, no need update. ");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageUtil", 2, new Object[] { "onDecodeC2cLbsCloseRoomMessage: invoked. ", " friendUin: ", paramString });
    }
    ardf.a(paramQQAppInterface, 0, paramString, false);
    a(paramQQAppInterface, 0, paramString, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<im_msg_body.Elem> paramList, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, msg_comm.Msg paramMsg, boolean paramBoolean, aylt paramaylt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationMessageUtil", 2, new Object[] { "decodePBMsgElems_LbsShareMsg: invoked. ", "elems = [" + paramList + "], msgRecords = [" + paramList1 + "], logBuilder = [" + paramStringBuilder + "], msg = [" + paramMsg + "]" });
    }
    if ((paramList == null) || (paramList.size() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("LocationMessageUtil", 2, "decodePBMsgElems_LbsShareMsg msg decode failed");
      }
    }
    do
    {
      return;
      if (paramBoolean)
      {
        if (paramQQAppInterface.getLongAccountUin() == paramMsg.msg_head.to_uin.get()) {}
        for (paramQQAppInterface = paramMsg.msg_head.from_uin.get() + "";; paramQQAppInterface = paramMsg.msg_head.to_uin.get() + "")
        {
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            paramMsg = (im_msg_body.Elem)paramList.next();
            if ((paramMsg.common_elem.has()) && (paramMsg.common_elem.uint32_service_type.get() == 31) && (paramMsg.common_elem.bytes_pb_elem.has())) {
              try
              {
                new hummer_commelem.MsgElemInfo_servtype31().mergeFrom(paramMsg.common_elem.bytes_pb_elem.get().toByteArray());
              }
              catch (InvalidProtocolBufferMicroException paramMsg)
              {
                QLog.e("LocationMessageUtil", 1, "decodePBMsgElems_LbsShareMsg: failed. ", paramMsg);
              }
            }
          }
        }
      }
      if (paramaylt != null) {}
      for (paramQQAppInterface = paramaylt.a;; paramQQAppInterface = paramMsg.msg_head.to_uin.get() + "") {
        break;
      }
      if (QLog.isColorLevel()) {
        paramStringBuilder.append("elemType:LbsShareMsg;\n");
      }
      paramList = (MessageForLocationShare)awbi.a(-2076);
      paramList.msgtype = -2076;
      paramList.msg = BaseApplicationImpl.context.getString(2131653858);
      paramList.isSharingLocation = true;
      paramList.frienduin = paramQQAppInterface;
      paramList.parse();
      paramList1.add(paramList);
    } while (!QLog.isColorLevel());
    paramStringBuilder.append("LbsShareMsg.msg: ").append(paramList.toString() + "\n").append("\n");
  }
  
  public static List<MessageRecord> b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    return paramQQAppInterface.a().a(paramString, paramInt, 9223372036854775807L, 3, 9223372036854775807L, new int[] { -2076 }, 2147483647);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ardf.a(paramQQAppInterface, 1, paramString, false);
    a(paramQQAppInterface, 1, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arde
 * JD-Core Version:    0.7.0.1
 */