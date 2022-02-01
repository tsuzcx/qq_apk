import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg.PttRec;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.TmpPtt;

public class bbmc
  implements bbls
{
  private static int a(msg_comm.Msg paramMsg, int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
    case 0: 
    case 1: 
    case 58: 
      do
      {
        return paramInt1;
        return 1000;
        return 1004;
        paramInt1 = 1024;
      } while ((!nns.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!nns.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get()))));
      return 1025;
    case 201: 
      return 1005;
    case 129: 
    case 140: 
    case 142: 
      return 1008;
    case 130: 
      return 1006;
    case 131: 
      return 1009;
    case 124: 
      return 1001;
    case 132: 
      return 1020;
    case 121: 
      return 1021;
    case 134: 
      return 1022;
    case 133: 
      return 1023;
    case 137: 
      return 1010;
    case 144: 
      return 7400;
    case 149: 
      return 10002;
    case 153: 
      return 10004;
    case 160: 
      return 1036;
    case 156: 
      return 1032;
    case 159: 
      return 1037;
    case 161: 
      return 1038;
    case 163: 
      return 1044;
    case 164: 
      return 10007;
    case 165: 
      return 10008;
    case 166: 
      return 1045;
    case 167: 
      return 10010;
    }
    return 10009;
  }
  
  public static bblm a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface)
  {
    bblm localbblm = new bblm();
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    a(localC2CTmpMsgHead);
    localbblm.jdField_b_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
    int i = localC2CTmpMsgHead.c2c_type.get();
    int j = localC2CTmpMsgHead.service_type.get();
    localbblm.jdField_a_of_type_Int = a(paramMsg, -1, j);
    localbblm.jdField_a_of_type_Long = -1L;
    localbblm.jdField_b_of_type_Long = -1L;
    a(localbblm, localC2CTmpMsgHead, j);
    paramQQAppInterface = (abyr)paramQQAppInterface.getMessageFacade().getRegistry().a().a(Integer.valueOf(j));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramMsg, localbblm);
    }
    a(localbblm, i, j);
    return localbblm;
  }
  
  private static void a(bblm parambblm, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
      localStringBuilder.append(" c2cType:").append(paramInt1).append(" serviceType:").append(paramInt2).append("direction_flag:").append(parambblm.jdField_b_of_type_Int).append(" info:").append(parambblm.toString());
      QLog.d("TempSessionDecoder", 2, localStringBuilder.toString());
    }
  }
  
  private static void a(bblm parambblm, msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 132: 
      parambblm.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
      parambblm.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_uin.get();
      return;
    }
    parambblm.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
    parambblm.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_code.get();
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, bblm parambblm, bbkm parambbkm)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int j;
    if ((((msg_comm.MsgHead)localObject1).msg_type.get() == 529) && (((msg_comm.MsgHead)localObject1).c2c_cmd.get() == 6))
    {
      j = 1;
      if ((((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.has()) && (paramMsg.msg_body.has()) && ((j != 0) || (((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()))) {
        break label94;
      }
    }
    for (;;)
    {
      return;
      j = 0;
      break;
      label94:
      Object localObject4 = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localObject1).c2c_tmp_msg_head.get();
      int i = ((msg_comm.C2CTmpMsgHead)localObject4).c2c_type.get();
      int k = ((msg_comm.C2CTmpMsgHead)localObject4).service_type.get();
      if ((!parambbkm.jdField_d_of_type_Boolean) && (parambblm.jdField_a_of_type_Int == 1006))
      {
        localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get();
        if ((!((msg_comm.C2CTmpMsgHead)localObject4).from_phone.has()) || (localObject1 == null) || (((String)localObject1).equals("+0")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get());
          }
        }
        else {
          ContactUtils.addUinByPhoneNum(paramMessageHandler.app, ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get(), parambbkm.e + "");
        }
      }
      else
      {
        localObject3 = null;
        localObject1 = localObject3;
        if (!parambbkm.jdField_d_of_type_Boolean)
        {
          localObject1 = localObject3;
          if (((msg_comm.C2CTmpMsgHead)localObject4).sig.has())
          {
            localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).sig.get().toByteArray();
            if (QLog.isDevelopLevel()) {
              QLog.d("TempSessionDecoder", 4, "tempHead.sig.get()----> sig:" + HexUtil.bytes2HexStr((byte[])localObject1) + ",length:" + localObject1.length);
            }
          }
        }
        if (localObject1 != null) {}
        switch (parambblm.jdField_a_of_type_Int)
        {
        default: 
          localObject3 = (abyo)paramMessageHandler.app.getMessageFacade().getRegistry().a().a(Integer.valueOf(parambblm.jdField_a_of_type_Int));
          if (localObject3 != null) {
            ((abyo)localObject3).a(parambbkm, (byte[])localObject1);
          }
          label611:
          k = 0;
          i = k;
          if (paramMsg.content_head.has())
          {
            i = k;
            if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.has()) {
              if (((msg_comm.ContentHead)paramMsg.content_head.get()).auto_reply.get() != 1) {
                break label1516;
              }
            }
          }
          break;
        }
        label1516:
        for (i = 1;; i = 0)
        {
          localObject1 = null;
          if (j == 0) {
            localObject1 = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
          }
          if (i == 0) {
            break label1522;
          }
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            break;
          }
          paramMessageHandler = (im_msg_body.Text)((im_msg_body.Elem)((List)localObject1).get(0)).text.get();
          if (parambbkm.jdField_b_of_type_Boolean) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131690220) + " " + paramMessageHandler.str.get().toStringUtf8();
          paramMsg = bbli.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
          return;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().a(String.valueOf(parambbkm.e), (byte[])localObject3);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().b(String.valueOf(parambbkm.e), (byte[])localObject3);
          break label611;
          paramMessageHandler.app.getMsgCache().c(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().e(String.valueOf(parambbkm.e), (byte[])localObject3);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().f(String.valueOf(parambbkm.e), (byte[])localObject3);
          break label611;
          paramMessageHandler.app.getMsgCache().g(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().h(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().i(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().j(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().m(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().o(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().l(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().k(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().a(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().b(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().c(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().a(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1, false);
          break label611;
          if (!parambbkm.i) {
            break label611;
          }
          paramMessageHandler.app.getMsgCache().d(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().f(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().e(String.valueOf(parambbkm.e), String.valueOf(parambbkm.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().p(String.valueOf(parambbkm.e), (byte[])localObject1);
          break label611;
        }
        label1522:
        if (parambblm != null) {
          if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
          {
            parambbkm = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
            localObject1 = new im_msg_body.TmpPtt();
            try
            {
              parambbkm = (im_msg_body.TmpPtt)((im_msg_body.TmpPtt)localObject1).mergeFrom(parambbkm);
              int m;
              int n;
              if ((parambbkm != null) && (parambbkm.uint32_file_type.has()) && (parambbkm.uint32_file_type.get() == 4) && (parambbkm.bytes_file_uuid.has()))
              {
                localObject1 = parambbkm.bytes_file_uuid.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + (String)localObject1);
                }
                localObject4 = new RichMsg.PttRec();
                ((RichMsg.PttRec)localObject4).localPath.set(parambbkm.bytes_file_uuid.get().toStringUtf8());
                ((RichMsg.PttRec)localObject4).size.set(parambbkm.uint32_file_size.get());
                ((RichMsg.PttRec)localObject4).type.set(2);
                ((RichMsg.PttRec)localObject4).uuid.set((String)localObject1);
                ((RichMsg.PttRec)localObject4).isRead.set(false);
                ((RichMsg.PttRec)localObject4).serverStorageSource.set("pttcenter");
                ((RichMsg.PttRec)localObject4).isReport.set(0);
                ((RichMsg.PttRec)localObject4).version.set(5);
                ((RichMsg.PttRec)localObject4).pttFlag.set(0);
                i = 0;
                k = i;
                if (parambbkm.uint32_user_type.has())
                {
                  j = parambbkm.uint32_user_type.get();
                  if (j != 1)
                  {
                    k = i;
                    if (j != 2) {}
                  }
                  else
                  {
                    k = j;
                  }
                }
                m = 0;
                i = 0;
                n = 0;
                j = 0;
                localObject3 = "";
                localObject1 = localObject3;
                if (parambbkm.bytes_pb_reserve.has())
                {
                  localObject1 = new ptt_reserve.ReserveStruct();
                  j = n;
                  i = m;
                }
              }
              try
              {
                ((ptt_reserve.ReserveStruct)localObject1).mergeFrom(parambbkm.bytes_pb_reserve.get().toByteArray());
                j = n;
                i = m;
                m = ((ptt_reserve.ReserveStruct)localObject1).uint32_change_voice.get();
                j = n;
                i = m;
                n = ((ptt_reserve.ReserveStruct)localObject1).uint32_autototext_voice.get();
                j = n;
                i = m;
                localObject1 = ((ptt_reserve.ReserveStruct)localObject1).bytes_voice_text_abs.get().toStringUtf8();
                i = m;
                j = n;
              }
              catch (Exception localException)
              {
                for (;;)
                {
                  long l1;
                  long l2;
                  Object localObject2 = localObject3;
                }
              }
              ((RichMsg.PttRec)localObject4).longPttVipFlag.set(k);
              l1 = System.currentTimeMillis() / 1000L;
              l2 = paramMsg.msg_head.msg_time.get();
              ((RichMsg.PttRec)localObject4).msgRecTime.set(l1);
              ((RichMsg.PttRec)localObject4).msgTime.set(l2);
              ((RichMsg.PttRec)localObject4).voiceChangeFlag.set(i);
              ((RichMsg.PttRec)localObject4).busiType.set(parambbkm.uint32_busi_type.get());
              ((RichMsg.PttRec)localObject4).autototext_voice.set(j);
              ((RichMsg.PttRec)localObject4).sttText.set((String)localObject1);
              localObject1 = bbli.a(-2002);
              ((MessageRecord)localObject1).msgtype = -2002;
              ((MessageRecord)localObject1).msgData = ((RichMsg.PttRec)localObject4).toByteArray();
              ((MessageForPtt)localObject1).parse();
              if ((parambbkm.uint64_msg_id.has()) && (parambbkm.uint64_msg_id.get() != 0L)) {
                ((MessageRecord)localObject1).saveExtInfoToExtStr("pa_msgId", parambbkm.uint64_msg_id.get() + "");
              }
              apse.a(paramMsg, (MessageRecord)localObject1, paramMessageHandler.app);
              bint.a(parambblm, paramMsg, (MessageRecord)localObject1);
              paramList.add(localObject1);
              return;
            }
            catch (InvalidProtocolBufferMicroException parambbkm)
            {
              for (;;)
              {
                parambbkm.printStackTrace();
                parambbkm = null;
              }
            }
          }
        }
      }
    }
    localObject1 = new bdyi();
    ((bdyi)localObject1).a = String.valueOf(parambbkm.e);
    bblf.a(paramMessageHandler, paramList, paramMsg, true, parambbkm.jdField_b_of_type_Boolean, (bdyi)localObject1, parambblm, parambbkm);
  }
  
  private static void a(msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead)
  {
    if (!paramC2CTmpMsgHead.c2c_type.has()) {
      if (QLog.isColorLevel()) {
        QLog.e("TempSessionDecoder", 2, "It doesn't has a c2cType.");
      }
    }
    while ((paramC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.e("TempSessionDecoder", 2, "Invalid service type, the pb data has no service type.");
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbkm parambbkm)
  {
    int j = 1;
    bblm localbblm = a(paramMsg, paramMessageHandler.app);
    if (localbblm.jdField_a_of_type_Int == -1)
    {
      i = 0;
      if (i != 0)
      {
        parambbkm.jdField_d_of_type_Int = localbblm.jdField_b_of_type_Int;
        a(paramMessageHandler, paramList, paramMsg, localbblm, parambbkm);
        parambbkm.c = localbblm.jdField_a_of_type_Int;
      }
      if ((paramList.size() > 0) && (apse.a((MessageRecord)paramList.get(0)))) {
        if (!((MessageRecord)paramList.get(0)).isSelfConfessor()) {
          break label229;
        }
      }
    }
    label229:
    for (int i = 1033;; i = 1034)
    {
      localbblm.jdField_a_of_type_Int = i;
      parambbkm.c = localbblm.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("TempSessionDecoder", 2, "friendType:" + parambbkm.c + ", direction_flag:" + parambbkm.jdField_d_of_type_Int);
      }
      return;
      if ((localbblm.jdField_a_of_type_Int != 1000) && (localbblm.jdField_a_of_type_Int != 1020))
      {
        i = j;
        if (localbblm.jdField_a_of_type_Int != 1004) {
          break;
        }
      }
      parambbkm.jdField_b_of_type_Long = localbblm.jdField_b_of_type_Long;
      i = j;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmc
 * JD-Core Version:    0.7.0.1
 */