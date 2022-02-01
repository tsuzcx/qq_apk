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

public class bcab
  implements bbzr
{
  public static bbzl a(msg_comm.Msg paramMsg, QQAppInterface paramQQAppInterface)
  {
    bbzl localbbzl = new bbzl();
    int i = -1;
    msg_comm.C2CTmpMsgHead localC2CTmpMsgHead = (msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get();
    int j;
    int k;
    if (!localC2CTmpMsgHead.c2c_type.has())
    {
      if (QLog.isColorLevel()) {
        QLog.e("TempSessionDecoder", 2, "It doesn't has a c2cType.");
      }
      localbbzl.jdField_b_of_type_Int = localC2CTmpMsgHead.direction_flag.get();
      j = localC2CTmpMsgHead.c2c_type.get();
      k = localC2CTmpMsgHead.service_type.get();
      switch (k)
      {
      default: 
        label324:
        localbbzl.jdField_a_of_type_Int = i;
        localbbzl.jdField_a_of_type_Long = -1L;
        localbbzl.jdField_b_of_type_Long = -1L;
        switch (k)
        {
        }
        break;
      }
    }
    for (;;)
    {
      paramQQAppInterface = (acxv)paramQQAppInterface.a().a().a().a(Integer.valueOf(k));
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramMsg, localbbzl);
      }
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder("<---getC2CMsgPkgTempInfo: dump info:");
        paramMsg.append(" c2cType:").append(j).append(" serviceType:").append(k).append("direction_flag:").append(localbbzl.jdField_b_of_type_Int).append(" info:").append(localbbzl.toString());
        QLog.d("TempSessionDecoder", 2, paramMsg.toString());
      }
      return localbbzl;
      if ((localC2CTmpMsgHead.service_type.has()) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TempSessionDecoder", 2, "Invalid service type, the pb data has no service type.");
      break;
      i = 1000;
      break label324;
      i = 1004;
      break label324;
      i = 1024;
      if ((!nki.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.from_uin.get()))) && (!nki.a(BaseApplicationImpl.getContext(), String.valueOf(paramMsg.msg_head.to_uin.get())))) {
        break label324;
      }
      i = 1025;
      break label324;
      i = 1005;
      break label324;
      i = 1008;
      break label324;
      i = 1006;
      break label324;
      i = 1009;
      break label324;
      i = 1001;
      break label324;
      i = 1020;
      break label324;
      i = 1021;
      break label324;
      i = 1022;
      break label324;
      i = 1023;
      break label324;
      i = 1010;
      break label324;
      i = 7400;
      break label324;
      i = 10002;
      break label324;
      i = 10004;
      break label324;
      i = 1036;
      break label324;
      i = 1032;
      break label324;
      i = 1037;
      break label324;
      i = 1038;
      break label324;
      i = 1044;
      break label324;
      i = 10007;
      break label324;
      i = 10008;
      break label324;
      i = 1045;
      break label324;
      i = 10010;
      break label324;
      i = 10009;
      break label324;
      localbbzl.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localbbzl.jdField_b_of_type_Long = localC2CTmpMsgHead.group_uin.get();
      continue;
      localbbzl.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localbbzl.jdField_b_of_type_Long = localC2CTmpMsgHead.group_code.get();
      continue;
      localbbzl.jdField_a_of_type_Long = localC2CTmpMsgHead.group_code.get();
      localbbzl.jdField_b_of_type_Long = localC2CTmpMsgHead.group_uin.get();
    }
  }
  
  private void a(MessageHandler paramMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, bbzl parambbzl, bbyn parambbyn)
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
      if ((!parambbyn.jdField_d_of_type_Boolean) && (parambbzl.jdField_a_of_type_Int == 1006))
      {
        localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get();
        if ((!((msg_comm.C2CTmpMsgHead)localObject4).from_phone.has()) || (localObject1 == null) || (((String)localObject1).equals("+0")))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get());
          }
        }
        else {
          bglf.a(paramMessageHandler.app, ((msg_comm.C2CTmpMsgHead)localObject4).from_phone.get(), parambbyn.e + "");
        }
      }
      else
      {
        localObject3 = null;
        localObject1 = localObject3;
        if (!parambbyn.jdField_d_of_type_Boolean)
        {
          localObject1 = localObject3;
          if (((msg_comm.C2CTmpMsgHead)localObject4).sig.has())
          {
            localObject1 = ((msg_comm.C2CTmpMsgHead)localObject4).sig.get().toByteArray();
            if (QLog.isDevelopLevel()) {
              QLog.d("TempSessionDecoder", 4, "tempHead.sig.get()----> sig:" + bgmj.a((byte[])localObject1) + ",length:" + localObject1.length);
            }
          }
        }
        if (localObject1 != null) {}
        switch (parambbzl.jdField_a_of_type_Int)
        {
        default: 
          localObject3 = (acxs)paramMessageHandler.app.a().a().a().a(Integer.valueOf(parambbzl.jdField_a_of_type_Int));
          if (localObject3 != null) {
            ((acxs)localObject3).a(parambbyn, (byte[])localObject1);
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
          if (parambbyn.jdField_b_of_type_Boolean) {
            break;
          }
          paramMessageHandler = BaseApplication.getContext().getString(2131690183) + " " + paramMessageHandler.str.get().toStringUtf8();
          paramMsg = bbzh.a(-10000);
          paramMsg.msgtype = -10000;
          paramMsg.msg = paramMessageHandler;
          paramList.add(paramMsg);
          return;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bgva.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().a(String.valueOf(parambbyn.e), (byte[])localObject3);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bgva.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().b(String.valueOf(parambbyn.e), (byte[])localObject3);
          break label611;
          paramMessageHandler.app.a().c(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bgva.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().e(String.valueOf(parambbyn.e), (byte[])localObject3);
          break label611;
          localObject3 = new byte[localObject1.length + 2];
          localObject3[0] = ((byte)i);
          localObject3[1] = ((byte)k);
          bgva.a((byte[])localObject3, 2, (byte[])localObject1, 0, localObject1.length);
          paramMessageHandler.app.a().f(String.valueOf(parambbyn.e), (byte[])localObject3);
          break label611;
          paramMessageHandler.app.a().g(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().h(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().i(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().j(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().m(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().o(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().l(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().k(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().a(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().b(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().c(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().a(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1, false);
          break label611;
          if (!parambbyn.i) {
            break label611;
          }
          paramMessageHandler.app.a().d(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().f(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().e(String.valueOf(parambbyn.e), String.valueOf(parambbyn.jdField_a_of_type_Long), (byte[])localObject1);
          break label611;
          paramMessageHandler.app.a().p(String.valueOf(parambbyn.e), (byte[])localObject1);
          break label611;
        }
        label1522:
        if (parambbzl != null) {
          if ((((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get() == 529) && (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get() == 6))
          {
            parambbyn = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
            localObject1 = new im_msg_body.TmpPtt();
            try
            {
              parambbyn = (im_msg_body.TmpPtt)((im_msg_body.TmpPtt)localObject1).mergeFrom(parambbyn);
              int m;
              int n;
              if ((parambbyn != null) && (parambbyn.uint32_file_type.has()) && (parambbyn.uint32_file_type.get() == 4) && (parambbyn.bytes_file_uuid.has()))
              {
                localObject1 = parambbyn.bytes_file_uuid.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                  QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + (String)localObject1);
                }
                localObject4 = new RichMsg.PttRec();
                ((RichMsg.PttRec)localObject4).localPath.set(parambbyn.bytes_file_uuid.get().toStringUtf8());
                ((RichMsg.PttRec)localObject4).size.set(parambbyn.uint32_file_size.get());
                ((RichMsg.PttRec)localObject4).type.set(2);
                ((RichMsg.PttRec)localObject4).uuid.set((String)localObject1);
                ((RichMsg.PttRec)localObject4).isRead.set(false);
                ((RichMsg.PttRec)localObject4).serverStorageSource.set("pttcenter");
                ((RichMsg.PttRec)localObject4).isReport.set(0);
                ((RichMsg.PttRec)localObject4).version.set(5);
                ((RichMsg.PttRec)localObject4).pttFlag.set(0);
                i = 0;
                k = i;
                if (parambbyn.uint32_user_type.has())
                {
                  j = parambbyn.uint32_user_type.get();
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
                if (parambbyn.bytes_pb_reserve.has())
                {
                  localObject1 = new ptt_reserve.ReserveStruct();
                  j = n;
                  i = m;
                }
              }
              try
              {
                ((ptt_reserve.ReserveStruct)localObject1).mergeFrom(parambbyn.bytes_pb_reserve.get().toByteArray());
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
              ((RichMsg.PttRec)localObject4).busiType.set(parambbyn.uint32_busi_type.get());
              ((RichMsg.PttRec)localObject4).autototext_voice.set(j);
              ((RichMsg.PttRec)localObject4).sttText.set((String)localObject1);
              localObject1 = bbzh.a(-2002);
              ((MessageRecord)localObject1).msgtype = -2002;
              ((MessageRecord)localObject1).msgData = ((RichMsg.PttRec)localObject4).toByteArray();
              ((MessageForPtt)localObject1).parse();
              if ((parambbyn.uint64_msg_id.has()) && (parambbyn.uint64_msg_id.get() != 0L)) {
                ((MessageRecord)localObject1).saveExtInfoToExtStr("pa_msgId", parambbyn.uint64_msg_id.get() + "");
              }
              aqjq.a(paramMsg, (MessageRecord)localObject1, paramMessageHandler.app);
              bjho.a(parambbzl, paramMsg, (MessageRecord)localObject1);
              paramList.add(localObject1);
              return;
            }
            catch (InvalidProtocolBufferMicroException parambbyn)
            {
              for (;;)
              {
                parambbyn.printStackTrace();
                parambbyn = null;
              }
            }
          }
        }
      }
    }
    localObject1 = new bepr();
    ((bepr)localObject1).a = String.valueOf(parambbyn.e);
    bbzf.a(paramMessageHandler, paramList, paramMsg, true, parambbyn.jdField_b_of_type_Boolean, (bepr)localObject1, parambbzl, parambbyn);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    int j = 1;
    bbzl localbbzl = a(paramMsg, paramMessageHandler.app);
    if (localbbzl.jdField_a_of_type_Int == -1)
    {
      i = 0;
      if (i != 0)
      {
        parambbyn.jdField_d_of_type_Int = localbbzl.jdField_b_of_type_Int;
        a(paramMessageHandler, paramList, paramMsg, localbbzl, parambbyn);
        parambbyn.c = localbbzl.jdField_a_of_type_Int;
      }
      if ((paramList.size() > 0) && (aqjq.a((MessageRecord)paramList.get(0)))) {
        if (!((MessageRecord)paramList.get(0)).isSelfConfessor()) {
          break label229;
        }
      }
    }
    label229:
    for (int i = 1033;; i = 1034)
    {
      localbbzl.jdField_a_of_type_Int = i;
      parambbyn.c = localbbzl.jdField_a_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.d("TempSessionDecoder", 2, "friendType:" + parambbyn.c + ", direction_flag:" + parambbyn.jdField_d_of_type_Int);
      }
      return;
      if ((localbbzl.jdField_a_of_type_Int != 1000) && (localbbzl.jdField_a_of_type_Int != 1020))
      {
        i = j;
        if (localbbzl.jdField_a_of_type_Int != 1004) {
          break;
        }
      }
      parambbyn.jdField_b_of_type_Long = localbbzl.jdField_b_of_type_Long;
      i = j;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcab
 * JD-Core Version:    0.7.0.1
 */