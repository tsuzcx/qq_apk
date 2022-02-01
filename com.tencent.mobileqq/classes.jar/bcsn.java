import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class bcsn
  implements bcsk
{
  private void a(MessageHandler paramMessageHandler, bcre parambcre, byte[] paramArrayOfByte)
  {
    int k = 0;
    int j = 0;
    SubMsgType0x3.MsgBody localMsgBody = new SubMsgType0x3.MsgBody();
    label222:
    label374:
    do
    {
      int i;
      for (;;)
      {
        try
        {
          localMsgBody.mergeFrom(paramArrayOfByte);
          if (!localMsgBody.msg_fail_notify.has()) {
            break;
          }
          paramArrayOfByte = (SubMsgType0x3.FailNotify)localMsgBody.msg_fail_notify.get();
          if (paramArrayOfByte.uint32_sessionid.has())
          {
            k = paramArrayOfByte.uint32_sessionid.get();
            if (!paramArrayOfByte.uint32_retCode.has()) {
              break label222;
            }
            i = paramArrayOfByte.uint32_retCode.get();
            if (!paramArrayOfByte.bytes_reason.has()) {
              break label270;
            }
            paramArrayOfByte = new String(paramArrayOfByte.bytes_reason.get().toStringUtf8());
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : FailNotify sessionId[" + k + "], retCode[" + i + "], reason[" + paramArrayOfByte + "]");
            }
            paramMessageHandler.app.getFileTransferHandler().a(String.valueOf(parambcre.e), k, i, paramArrayOfByte);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMessageHandler)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x3] failed", paramMessageHandler);
          return;
        }
        if (QLog.isColorLevel())
        {
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
            paramArrayOfByte = "";
          }
        }
      }
      if (localMsgBody.msg_progress_notify.has())
      {
        paramArrayOfByte = (SubMsgType0x3.ProgressNotify)localMsgBody.msg_progress_notify.get();
        int m;
        if (paramArrayOfByte.uint32_sessionid.has())
        {
          m = paramArrayOfByte.uint32_sessionid.get();
          if (!paramArrayOfByte.uint32_progress.has()) {
            break label489;
          }
          i = paramArrayOfByte.uint32_progress.get();
          if (!paramArrayOfByte.uint32_average_speed.has()) {
            break label532;
          }
          j = paramArrayOfByte.uint32_average_speed.get();
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify sessionId[" + m + "], progress[" + i + "], speed[" + j + "]");
          }
          paramMessageHandler.app.getFileTransferHandler().a(String.valueOf(parambcre.e), m, i, j);
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has not sessionId");
          return;
          if (QLog.isColorLevel()) {
            QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + m + "], progressNotify has not Progress");
          }
          i = 0;
          break label374;
          j = k;
          if (QLog.isColorLevel())
          {
            QLog.w("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : sessionId[" + m + "], progressNotify has not AverageSpeed");
            j = k;
          }
        }
      }
    } while (!QLog.isColorLevel());
    label270:
    label489:
    QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : progressNotify has neither failNotify not progressNotify");
    label532:
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, bcre parambcre, List<MessageRecord> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211");
    }
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {}
    byte[] arrayOfByte;
    do
    {
      for (;;)
      {
        return;
        try
        {
          arrayOfByte = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
          int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
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
            if (QLog.isColorLevel())
            {
              QLog.d("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[" + i + "] is not implemented");
              return;
            }
            break;
          }
        }
        catch (Exception paramMessageHandler) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : failed.", paramMessageHandler);
    return;
    a(paramMessageHandler, parambcre, arrayOfByte);
    return;
    a(paramMessageHandler, paramMsg, parambcre, paramList, arrayOfByte);
    return;
    a(paramMessageHandler, paramMsg, parambcre, arrayOfByte);
    return;
    c(paramMessageHandler, paramMsg, arrayOfByte);
    return;
    b(paramMessageHandler, paramMsg, arrayOfByte);
    return;
    a(paramMessageHandler, paramMsg, arrayOfByte);
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, bcre parambcre, List<MessageRecord> paramList, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<FileAssistant>offlineFile come: cmd[0x211, 0x4]");
    }
    Object localObject = new SubMsgType0x4.MsgBody();
    SubMsgType0x4.MsgBody localMsgBody;
    try
    {
      localMsgBody = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!localMsgBody.msg_not_online_file.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : MsgBody has not NotOnlineFile");
        }
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgType0x211Decoder", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramMessageHandler);
      return;
    }
    im_msg_body.NotOnlineFile localNotOnlineFile = (im_msg_body.NotOnlineFile)localMsgBody.msg_not_online_file.get();
    paramArrayOfByte = null;
    if (localMsgBody.file_image_info.has()) {
      paramArrayOfByte = (hummer_resv_21.FileImgInfo)localMsgBody.file_image_info.get();
    }
    localObject = null;
    if (localMsgBody.resv_attr.has()) {
      localObject = (hummer_resv_21.ResvAttr)localMsgBody.resv_attr.get();
    }
    if (parambcre.jdField_d_of_type_Boolean)
    {
      paramMessageHandler = new MessageRecord();
      long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
      long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
      paramMessageHandler.msg = localNotOnlineFile.bytes_file_name.get().toStringUtf8();
      paramMessageHandler.senderuin = Long.toString(l2);
      paramMessageHandler.msgtype = -2005;
      paramMessageHandler.frienduin = Long.toString(parambcre.e);
      paramMessageHandler.time = l1;
      if (paramArrayOfByte != null)
      {
        paramMessageHandler.saveExtInfoToExtStr("file_pic_width", String.valueOf(paramArrayOfByte.uint32_file_width.get()));
        paramMessageHandler.saveExtInfoToExtStr("file_pic_heigth", String.valueOf(paramArrayOfByte.uint32_file_height.get()));
        QLog.i("MsgType0x211Decoder", 1, "Insert ThumbSize toMsg height[" + paramArrayOfByte.uint32_file_width.get() + "], width[" + paramArrayOfByte.uint32_file_height.get() + "]");
      }
      paramList.add(paramMessageHandler);
      return;
    }
    paramMessageHandler.app.getFileTransferHandler().a(paramMessageHandler, paramList, paramMsg, localNotOnlineFile, String.valueOf(parambcre.e), parambcre.jdField_a_of_type_Boolean, parambcre.b, parambcre.jdField_d_of_type_Long, parambcre.jdField_a_of_type_Int, paramArrayOfByte, (hummer_resv_21.ResvAttr)localObject);
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, bcre parambcre, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<dataline> message come: cmd[0x211, 0x7]");
    }
    SubMsgType0x7.MsgBody localMsgBody = new SubMsgType0x7.MsgBody();
    try
    {
      paramArrayOfByte = (SubMsgType0x7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      if (!parambcre.jdField_d_of_type_Boolean) {
        ((ansr)paramMessageHandler.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMsg, paramArrayOfByte);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x7] failed", paramMessageHandler);
    }
  }
  
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, byte[] paramArrayOfByte)
  {
    long l1 = paramMsg.msg_head.from_uin.get();
    long l2 = paramMsg.msg_head.to_uin.get();
    int i = paramMsg.msg_head.msg_seq.get();
    long l3 = paramMsg.msg_head.msg_uid.get();
    int j = paramMsg.msg_head.msg_type.get();
    long l4 = paramMsg.msg_head.msg_time.get();
    ((abgm)paramMessageHandler.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(l1, l2, i, l3, j, "im_push.msg_push", paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "device msg push, receive 0x11,0xd msg, fromuin2:" + l1 + ",touin:" + l2 + ", msg seq:" + i + ",msg_uid:" + l3 + ",msg_time:" + l4 + ",msgtype:" + j);
    }
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    int i;
    if ((paramMsg.msg_head.c2c_cmd.get() == 6) || (paramMsg.msg_head.c2c_tmp_msg_head.has()))
    {
      i = 1;
      if (i != 0) {
        new bcsu().a(paramMessageHandler, paramMsg, paramList, parambcre);
      }
      if (!paramMsg.msg_head.c2c_tmp_msg_head.has())
      {
        paramMessageHandler = (anvk)paramMessageHandler.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!nut.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
          break label147;
        }
        if (!paramMessageHandler.b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get()))) {
          parambcre.c = 1025;
        }
      }
    }
    label147:
    while ((!nut.a(BaseApplicationImpl.getContext(), String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))) || (paramMessageHandler.b(String.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get()))))
    {
      return;
      i = 0;
      break;
    }
    parambcre.c = 1025;
  }
  
  private void b(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MsgType0x211Decoder", 2, "<dataline printer> message come: cmd[0x211, 0x9]");
    }
    C2CType0x211_SubC2CType0x9.MsgBody localMsgBody = new C2CType0x211_SubC2CType0x9.MsgBody();
    try
    {
      paramArrayOfByte = (C2CType0x211_SubC2CType0x9.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      ((ansr)paramMessageHandler.app.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramMsg, paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramMessageHandler)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MsgType0x211Decoder", 2, "<dataline><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x9] failed", paramMessageHandler);
    }
  }
  
  private void c(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, byte[] paramArrayOfByte)
  {
    long l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
    long l3 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    localObject = null;
    if (((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.has()) {
      arrayOfByte = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).toByteArray();
    }
    try
    {
      paramMsg = ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_tmp_msg_head.get()).sig.get().toByteArray();
      localObject = arrayOfByte;
      if (paramMsg != null)
      {
        atpm.a(String.valueOf(l1), paramMsg);
        localObject = arrayOfByte;
      }
    }
    catch (Exception paramMsg)
    {
      for (;;)
      {
        localObject = arrayOfByte;
      }
    }
    paramMessageHandler.app.getQlinkServiceMgr().a(l1, i, l2, l3, localObject, paramArrayOfByte);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    b(paramMessageHandler, paramMsg, paramList, parambcre);
    a(paramMessageHandler, paramMsg, parambcre, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsn
 * JD-Core Version:    0.7.0.1
 */