import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.FailNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x3.SubMsgType0x3.ProgressNotify;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;

public class bcsl
  implements bcsi
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, bcre parambcre, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    int i;
    int j;
    label452:
    label467:
    label620:
    long l1;
    label515:
    label558:
    label735:
    long l2;
    label783:
    label919:
    long l3;
    do
    {
      Object localObject1;
      do
      {
        do
        {
          for (;;)
          {
            return;
            try
            {
              localObject1 = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
              if (QLog.isColorLevel()) {
                QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "]");
              }
              switch (i)
              {
              case 5: 
              case 6: 
              case 10: 
              case 11: 
              case 12: 
              case 14: 
              case 15: 
              case 16: 
              default: 
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
                return;
              }
            }
            catch (Exception paramMessageHandler) {}
            if (QLog.isColorLevel())
            {
              QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
              return;
              paramMsg = new SubMsgType0x3.MsgBody();
              int k;
              for (;;)
              {
                try
                {
                  paramMsg.mergeFrom((byte[])localObject1);
                  if (!paramMsg.msg_fail_notify.has()) {
                    break label558;
                  }
                  j = 0;
                  paramMsg = (SubMsgType0x3.FailNotify)paramMsg.msg_fail_notify.get();
                  if (!paramMsg.uint32_sessionid.has()) {
                    break label452;
                  }
                  k = paramMsg.uint32_sessionid.get();
                  if (!paramMsg.uint32_retCode.has()) {
                    break label467;
                  }
                  i = paramMsg.uint32_retCode.get();
                  if (!paramMsg.bytes_reason.has()) {
                    break label515;
                  }
                  paramMsg = new String(paramMsg.bytes_reason.get().toStringUtf8());
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + k + "], retCode[" + i + "], reason[" + paramMsg + "]");
                  }
                  paramMessageHandler.app.a().a(String.valueOf(parambcre.e), k, i, paramMsg);
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
                return;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failNotify has not sessionId");
                return;
                i = j;
                if (QLog.isColorLevel())
                {
                  QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], failNotify has not RetCode");
                  i = j;
                  continue;
                  if (QLog.isColorLevel()) {
                    QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], failNotify has not reason");
                  }
                  paramMsg = "";
                }
              }
              if (paramMsg.msg_progress_notify.has())
              {
                j = 0;
                paramMsg = (SubMsgType0x3.ProgressNotify)paramMsg.msg_progress_notify.get();
                if (paramMsg.uint32_sessionid.has())
                {
                  k = paramMsg.uint32_sessionid.get();
                  if (!paramMsg.uint32_progress.has()) {
                    break label735;
                  }
                  i = paramMsg.uint32_progress.get();
                  if (!paramMsg.uint32_average_speed.has()) {
                    break label783;
                  }
                }
                for (j = paramMsg.uint32_average_speed.get();; j = 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + k + "], progress[" + i + "], speed[" + j + "]");
                  }
                  paramMessageHandler.app.a().a(String.valueOf(parambcre.e), k, i, j);
                  return;
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
                  return;
                  i = j;
                  if (!QLog.isColorLevel()) {
                    break label620;
                  }
                  QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not Progress");
                  i = j;
                  break label620;
                  if (QLog.isColorLevel()) {
                    QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + k + "], progressNotify has not AverageSpeed");
                  }
                }
              }
              if (QLog.isColorLevel())
              {
                QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("MsgType0x211Decoder", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
                }
                Object localObject2 = new SubMsgType0x4.MsgBody();
                SubMsgType0x4.MsgBody localMsgBody;
                try
                {
                  localMsgBody = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject2).mergeFrom((byte[])localObject1);
                  if (localMsgBody.msg_not_online_file.has()) {
                    break label919;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
                  return;
                }
                catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                if (QLog.isColorLevel())
                {
                  QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
                  return;
                  im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)localMsgBody.msg_not_online_file.get();
                  localObject1 = null;
                  if (localMsgBody.file_image_info.has()) {
                    localObject1 = (hummer_resv_21.FileImgInfo)localMsgBody.file_image_info.get();
                  }
                  localObject2 = null;
                  if (localMsgBody.resv_attr.has()) {
                    localObject2 = (hummer_resv_21.ResvAttr)localMsgBody.resv_attr.get();
                  }
                  if (parambcre.jdField_d_of_type_Boolean)
                  {
                    paramMessageHandler = new MessageRecord();
                    l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
                    l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
                    paramMessageHandler.msg = localNotOnlineFile.bytes_file_name.get().toStringUtf8();
                    paramMessageHandler.senderuin = Long.toString(l2);
                    paramMessageHandler.msgtype = -2005;
                    paramMessageHandler.frienduin = Long.toString(parambcre.e);
                    paramMessageHandler.time = l1;
                    if (localObject1 != null)
                    {
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_width", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get()));
                      paramMessageHandler.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get()));
                      QLog.i("MsgType0x211Decoder", 1, "Insert ThumbSize toMsg height[" + ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get() + "], width[" + ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get() + "]");
                    }
                    paramList.add(paramMessageHandler);
                    return;
                  }
                  paramMessageHandler.app.a().a(paramMessageHandler, paramList, paramMsg, localNotOnlineFile, String.valueOf(parambcre.e), parambcre.jdField_a_of_type_Boolean, parambcre.b, parambcre.jdField_d_of_type_Long, parambcre.jdField_a_of_type_Int, (hummer_resv_21.FileImgInfo)localObject1, (hummer_resv_21.ResvAttr)localObject2);
                  return;
                  if (QLog.isColorLevel()) {
                    QLog.d("MsgType0x211Decoder", 2, "<dataline> message come: cmd[0x211, 0x7]");
                  }
                  paramList = new SubMsgType0x7.MsgBody();
                  try
                  {
                    paramList = (SubMsgType0x7.MsgBody)paramList.mergeFrom((byte[])localObject1);
                    if (!parambcre.jdField_d_of_type_Boolean)
                    {
                      ((anvu)paramMessageHandler.app.a(8)).a(paramMsg, paramList);
                      return;
                    }
                  }
                  catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
                }
              }
            }
          }
        } while (!QLog.isColorLevel());
        QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
        return;
        l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
        l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
        l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        parambcre = null;
        if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
          paramList = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
        }
        try
        {
          paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
          parambcre = paramList;
          if (paramMsg != null)
          {
            atyw.a(String.valueOf(l1), paramMsg);
            parambcre = paramList;
          }
        }
        catch (Exception paramMsg)
        {
          for (;;)
          {
            long l4;
            parambcre = paramList;
          }
        }
        paramMessageHandler.app.a().a(l1, i, l2, l3, parambcre, (byte[])localObject1);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("MsgType0x211Decoder", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
        }
        parambcre = new C2CType0x211_SubC2CType0x9.MsgBody();
        try
        {
          parambcre = (C2CType0x211_SubC2CType0x9.MsgBody)parambcre.mergeFrom((byte[])localObject1);
          ((anvu)paramMessageHandler.app.a(8)).a(paramMsg, parambcre);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler) {}
      } while (!QLog.isColorLevel());
      QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
      return;
      l1 = paramMsg.msg_head.from_uin.get();
      l2 = paramMsg.msg_head.to_uin.get();
      i = paramMsg.msg_head.msg_seq.get();
      l3 = paramMsg.msg_head.msg_uid.get();
      j = paramMsg.msg_head.msg_type.get();
      l4 = paramMsg.msg_head.msg_time.get();
      ((abur)paramMessageHandler.app.a(51)).a(l1, l2, i, l3, j, "im_push.msg_push", (byte[])localObject1);
    } while (!QLog.isColorLevel());
    QLog.d("MsgType0x211Decoder", 2, "device msg push, receive 0x11,0xd msg, fromuin2:" + l1 + ",touin:" + l2 + ", msg seq:" + i + ",msg_uid:" + l3 + ",msg_time:" + l4 + ",msgtype:" + j);
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    int i;
    if ((paramMsg.msg_head.c2c_cmd.get() == 6) || (paramMsg.msg_head.c2c_tmp_msg_head.has()))
    {
      i = 1;
      if (i != 0) {
        new bcss().a(paramMessageHandler, paramMsg, paramList, parambcre);
      }
      if (!paramMsg.msg_head.c2c_tmp_msg_head.has())
      {
        paramMessageHandler = (anyw)paramMessageHandler.app.getManager(51);
        if (!nmd.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
          break label146;
        }
        if (!paramMessageHandler.b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
          parambcre.c = 1025;
        }
      }
    }
    label146:
    while ((!nmd.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) || (paramMessageHandler.b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))))
    {
      return;
      i = 0;
      break;
    }
    parambcre.c = 1025;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    b(paramMessageHandler, paramMsg, paramList, parambcre);
    a(paramMessageHandler, paramMsg, parambcre, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsl
 * JD-Core Version:    0.7.0.1
 */