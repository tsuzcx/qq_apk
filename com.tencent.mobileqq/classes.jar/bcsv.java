import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcsv
  implements bcsi
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if (parambcre.d) {}
    long l1;
    long l2;
    long l3;
    label505:
    do
    {
      int i;
      HashMap localHashMap;
      do
      {
        do
        {
          long l4;
          do
          {
            do
            {
              do
              {
                return;
                if ((paramMsg.msg_body.has()) && (((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has()) && (!parambcre.a) && (!parambcre.f)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.e("VideoDecoder", 2, "<---decodeC2CMsgPkg_Video return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + parambcre.a + "syncOther:" + parambcre.f);
              return;
              l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
              l4 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_uid.get();
              long l5 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_seq.get();
              l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
              long l6 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).to_uin.get();
              l3 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
              paramList = l2 + "-" + l6 + "-" + l5 + "-" + l4;
              if (QLog.isColorLevel()) {
                QLog.d("VideoDecoder", 2, "<---decodeC2CMsgPkg_Video :  key:" + paramList);
              }
              paramList = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
              l4 = bcrg.a() - l1;
              i = lla.a(paramList);
              if (llk.c()) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.d("svenxu", 2, "Discard video message cause device not support");
            return;
            if (l4 < 60L) {
              break;
            }
          } while ((i == 1) && (!QLog.isColorLevel()));
          QLog.d("svenxu", 2, "Discard video message because of time out " + l4 + " s");
          return;
          localHashMap = (HashMap)parambcre.a(1000);
          parambcre = (HashSet)parambcre.a(1001);
          if (i != 1) {
            break label505;
          }
          if (llk.c()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("shanezhaiSHARP", 2, "discard video push message because the sdk is lower");
        return;
      } while (localHashMap == null);
      localHashMap.put(Long.valueOf(l2), paramMsg);
      return;
      if (i != 3) {
        break;
      }
    } while (!llk.c());
    if (parambcre != null) {
      parambcre.add(Long.valueOf(l2));
    }
    paramMessageHandler.a(l3, paramList, l2, (int)l1);
    return;
    paramMessageHandler.a(l3, paramList, l2, (int)l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsv
 * JD-Core Version:    0.7.0.1
 */