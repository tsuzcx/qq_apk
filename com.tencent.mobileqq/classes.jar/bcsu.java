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

public class bcsu
  implements bcsk
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
      } while ((!nut.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!nut.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get()))));
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
  
  public static bcse a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface)
  {
    bcse localbcse = new bcse();
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    a(localC2CTmpMsgHead);
    localbcse.jdField_b_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
    int i = localC2CTmpMsgHead.c2c_type.get();
    int j = localC2CTmpMsgHead.service_type.get();
    localbcse.jdField_a_of_type_Int = a(paramMsg, -1, j);
    localbcse.jdField_a_of_type_Long = -1L;
    localbcse.jdField_b_of_type_Long = -1L;
    a(localbcse, localC2CTmpMsgHead, j);
    paramQQAppInterface = (acoy)paramQQAppInterface.getMessageFacade().getRegistry().a().a(Integer.valueOf(j));
    if (paramQQAppInterface != null) {
      paramQQAppInterface.a(paramMsg, localbcse);
    }
    a(localbcse, i, j);
    return localbcse;
  }
  
  private static void a(bcse parambcse, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
      localStringBuilder.append(" c2cType:").append(paramInt1).append(" serviceType:").append(paramInt2).append("direction_flag:").append(parambcse.jdField_b_of_type_Int).append(" info:").append(parambcse.toString());
      QLog.d("TempSessionDecoder", 2, localStringBuilder.toString());
    }
  }
  
  private static void a(bcse parambcse, msg_comm.C2CTmpMsgHead paramC2CTmpMsgHead, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
    case 132: 
      parambcse.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
      parambcse.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_uin.get();
      return;
    }
    parambcse.jdField_a_of_type_Long = paramC2CTmpMsgHead.group_code.get();
    parambcse.jdField_b_of_type_Long = paramC2CTmpMsgHead.group_code.get();
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, bcse parambcse, bcre parambcre)
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
      if ((!parambcre.jdField_d_of_type_Boolean) && (parambcse.jdField_a_of_type_Int == 1006))
      {
        localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get();
        if ((!((msg_comm.C2CTmpMsgHead)localObject4).from_phone.has()) || (localObject1 == null) || (((String)localObject1).equals("+0")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get());
          }
        }
        else {
          ContactUtils.addUinByPhoneNum(paramMessageHandler.app, ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get(), parambcre.e + "");
        }
      }
      else
      {
        localObject3 = null;
        localObject1 = localObject3;
        if (!parambcre.jdField_d_of_type_Boolean)
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
        switch (parambcse.jdField_a_of_type_Int)
        {
        default: 
          localObject3 = (acov)paramMessageHandler.app.getMessageFacade().getRegistry().a().a(Integer.valueOf(parambcse.jdField_a_of_type_Int));
          if (localObject3 != null) {
            ((acov)localObject3).a(parambcre, (byte[])localObject1);
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
          if (parambcre.jdField_b_of_type_Boolean) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131690258) + " " + paramMessageHandler.str.get().toStringUtf8();
          paramMsg = bcsa.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
          return;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().a(String.valueOf(parambcre.e), (byte[])localObject3);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().b(String.valueOf(parambcre.e), (byte[])localObject3);
          break label611;
          paramMessageHandler.app.getMsgCache().c(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().e(String.valueOf(parambcre.e), (byte[])localObject3);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          PkgTools.copyData((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.getMsgCache().f(String.valueOf(parambcre.e), (byte[])localObject3);
          break label611;
          paramMessageHandler.app.getMsgCache().g(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().h(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().i(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().j(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().m(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().o(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().l(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().k(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().a(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().b(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().c(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().a(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1, false);
          break label611;
          if (!parambcre.i) {
            break label611;
          }
          paramMessageHandler.app.getMsgCache().d(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().f(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().e(String.valueOf(parambcre.e), String.valueOf(parambcre.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.getMsgCache().p(String.valueOf(parambcre.e), (byte[])localObject1);
          break label611;
        }
        label1522:
        if (parambcse != null) {
          if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
          {
            parambcre = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
            localObject1 = new im_msg_body.TmpPtt();
            try
            {
              parambcre = (im_msg_body.TmpPtt)((im_msg_body.TmpPtt)localObject1).mergeFrom(parambcre);
              int m;
              int n;
              if ((parambcre != null) && (parambcre.uint32_file_type.has()) && (parambcre.uint32_file_type.get() == 4) && (parambcre.bytes_file_uuid.has()))
              {
                localObject1 = parambcre.bytes_file_uuid.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + (String)localObject1);
                }
                localObject4 = new RichMsg.PttRec();
                ((RichMsg.PttRec)localObject4).localPath.set(parambcre.bytes_file_uuid.get().toStringUtf8());
                ((RichMsg.PttRec)localObject4).size.set(parambcre.uint32_file_size.get());
                ((RichMsg.PttRec)localObject4).type.set(2);
                ((RichMsg.PttRec)localObject4).uuid.set((String)localObject1);
                ((RichMsg.PttRec)localObject4).isRead.set(false);
                ((RichMsg.PttRec)localObject4).serverStorageSource.set("pttcenter");
                ((RichMsg.PttRec)localObject4).isReport.set(0);
                ((RichMsg.PttRec)localObject4).version.set(5);
                ((RichMsg.PttRec)localObject4).pttFlag.set(0);
                i = 0;
                k = i;
                if (parambcre.uint32_user_type.has())
                {
                  j = parambcre.uint32_user_type.get();
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
                if (parambcre.bytes_pb_reserve.has())
                {
                  localObject1 = new ptt_reserve.ReserveStruct();
                  j = n;
                  i = m;
                }
              }
              try
              {
                ((ptt_reserve.ReserveStruct)localObject1).mergeFrom(parambcre.bytes_pb_reserve.get().toByteArray());
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
              ((RichMsg.PttRec)localObject4).busiType.set(parambcre.uint32_busi_type.get());
              ((RichMsg.PttRec)localObject4).autototext_voice.set(j);
              ((RichMsg.PttRec)localObject4).sttText.set((String)localObject1);
              localObject1 = bcsa.a(-2002);
              ((MessageRecord)localObject1).msgtype = -2002;
              ((MessageRecord)localObject1).msgData = ((RichMsg.PttRec)localObject4).toByteArray();
              ((MessageForPtt)localObject1).parse();
              if ((parambcre.uint64_msg_id.has()) && (parambcre.uint64_msg_id.get() != 0L)) {
                ((MessageRecord)localObject1).saveExtInfoToExtStr("pa_msgId", parambcre.uint64_msg_id.get() + "");
              }
              aqvh.a(paramMsg, (MessageRecord)localObject1, paramMessageHandler.app);
              bjyv.a(parambcse, paramMsg, (MessageRecord)localObject1);
              paramList.add(localObject1);
              return;
            }
            catch (InvalidProtocolBufferMicroException parambcre)
            {
              for (;;)
              {
                parambcre.printStackTrace();
                parambcre = null;
              }
            }
          }
        }
      }
    }
    localObject1 = new bffl();
    ((bffl)localObject1).a = String.valueOf(parambcre.e);
    bcrx.a(paramMessageHandler, paramList, paramMsg, true, parambcre.jdField_b_of_type_Boolean, (bffl)localObject1, parambcse, parambcre);
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
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    int j = 1;
    bcse localbcse = a(paramMsg, paramMessageHandler.app);
    if (localbcse.jdField_a_of_type_Int == -1)
    {
      i = 0;
      if (i != 0)
      {
        parambcre.jdField_d_of_type_Int = localbcse.jdField_b_of_type_Int;
        a(paramMessageHandler, paramList, paramMsg, localbcse, parambcre);
        parambcre.c = localbcse.jdField_a_of_type_Int;
      }
      if ((paramList.size() > 0) && (aqvh.a((MessageRecord)paramList.get(0)))) {
        if (!((MessageRecord)paramList.get(0)).isSelfConfessor()) {
          break label229;
        }
      }
    }
    label229:
    for (int i = 1033;; i = 1034)
    {
      localbcse.jdField_a_of_type_Int = i;
      parambcre.c = localbcse.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("TempSessionDecoder", 2, "friendType:" + parambcre.c + ", direction_flag:" + parambcre.jdField_d_of_type_Int);
      }
      return;
      if ((localbcse.jdField_a_of_type_Int != 1000) && (localbcse.jdField_a_of_type_Int != 1020))
      {
        i = j;
        if (localbcse.jdField_a_of_type_Int != 1004) {
          break;
        }
      }
      parambcre.jdField_b_of_type_Long = localbcse.jdField_b_of_type_Long;
      i = j;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsu
 * JD-Core Version:    0.7.0.1
 */