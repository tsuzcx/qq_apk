import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bctb
  implements bcsi
{
  private void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, long paramLong1, boolean paramBoolean1, boolean paramBoolean2, long paramLong2, int paramInt)
  {
    im_msg_body.MsgBody localMsgBody = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    int i = ((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.get();
    Long localLong1 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get());
    Long localLong2 = Long.valueOf(((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get());
    long l = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
    short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
    Object localObject = localLong1.toString();
    String str = paramMessageHandler.app.getCurrentAccountUin();
    if (i == 129)
    {
      paramMsg = (msg_comm.Msg)localObject;
      if (!((String)localObject).equals(String.valueOf(localLong2))) {
        break label197;
      }
      paramMsg = (msg_comm.Msg)localObject;
      if (!((String)localObject).equals(str)) {
        break label197;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile recv  a 0x81 that is from self.");
      }
    }
    label177:
    label197:
    label508:
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
              do
              {
                do
                {
                  do
                  {
                    return;
                    if (str.equals(String.valueOf(localLong1))) {}
                    for (paramMsg = String.valueOf(localLong2);; paramMsg = String.valueOf(localLong1)) {
                      switch (i)
                      {
                      case 130: 
                      case 132: 
                      default: 
                        return;
                      case 129: 
                        if (!str.equalsIgnoreCase(String.valueOf(localLong1))) {
                          break label270;
                        }
                        if (!QLog.isColorLevel()) {
                          break label177;
                        }
                        QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.it is from self!!!");
                        return;
                      }
                    }
                    if (!paramBoolean2) {
                      break;
                    }
                  } while (!QLog.isColorLevel());
                  QLog.i("OnlineFileDecoder", 2, "recv roam online msg, return!");
                  return;
                  localObject = paramMessageHandler.app.a().a(localMsgBody.msg_content.get().toByteArray());
                  if (localObject == null) {
                    break label403;
                  }
                  if (paramMessageHandler.app.a().a((atzk)localObject)) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81 request is error.");
                return;
                if (((atzk)localObject).b) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.w("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x81. requset is no mulitend olfile.");
              return;
              paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (atzk)localObject, paramLong2, paramInt);
              return;
            } while (!QLog.isColorLevel());
            QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x81 failed.");
            return;
            localObject = paramMessageHandler.app.a().a(localMsgBody.msg_content.get().toByteArray());
            if (localObject == null) {
              break label508;
            }
            if (paramMessageHandler.app.a().a((atzk)localObject)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x83  is error.");
          return;
          paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (atzk)localObject, paramLong2, paramInt);
          return;
        } while (!QLog.isColorLevel());
        QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x83 failed.");
        return;
        localObject = paramMessageHandler.app.a().b(localMsgBody.msg_content.get().toByteArray());
        if (localObject == null) {
          break label613;
        }
        if (paramMessageHandler.app.a().a((atzk)localObject)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile 0x85  is error.");
      return;
      paramMessageHandler.app.a().b(i, String.valueOf(paramLong1), paramMsg, l, s, paramBoolean1, 0, null, (atzk)localObject, paramLong2, paramInt);
      return;
    } while (!QLog.isColorLevel());
    label270:
    label403:
    label613:
    QLog.d("OnlineFileDecoder", 2, "<---decodeC2CMsgPkg_OnlineFile decode 0x85 failed.");
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    a(paramMessageHandler, paramMsg, parambcre.e, parambcre.jdField_a_of_type_Boolean, parambcre.b, parambcre.d, parambcre.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bctb
 * JD-Core Version:    0.7.0.1
 */