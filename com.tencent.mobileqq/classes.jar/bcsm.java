import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
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

public class bcsm
  implements bcsi
{
  private void a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte)
  {
    long l = bhvd.a(paramArrayOfByte, 0);
    String str2 = String.valueOf(l);
    bhvd.a(paramArrayOfByte, 10);
    int i = bhvd.a(paramArrayOfByte, 16);
    String str1 = null;
    if (i > 0) {
      str1 = bhvd.a(paramArrayOfByte, 18, i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x2dcDecoder", 2, "----->handleHotChatAnnouncementMsg dwGroupCode = " + l + ", len = " + i + ", announcement = " + str1);
    }
    paramArrayOfByte = (anzp)paramMessageHandler.app.a(35);
    paramMessageHandler = (HotChatManager)paramMessageHandler.app.getManager(60);
    if ((paramArrayOfByte != null) && (paramMessageHandler != null))
    {
      paramMessageHandler = paramMessageHandler.a(str2);
      if (paramMessageHandler != null)
      {
        if (paramMessageHandler.userCreate != 1) {
          break label156;
        }
        paramArrayOfByte.a(str2);
      }
    }
    return;
    label156:
    paramArrayOfByte.a(paramMessageHandler.uuid.getBytes(), str2);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if ((paramList == null) || (paramMsg == null) || (!paramMsg.msg_body.has()) || (!paramMsg.msg_body.msg_content.has())) {}
    Object localObject2;
    int k;
    do
    {
      int i;
      long l1;
      long l2;
      int j;
      do
      {
        do
        {
          Object localObject1;
          do
          {
            do
            {
              return;
              localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
              i = (short)((msg_comm.MsgHead)localObject1).msg_seq.get();
              l1 = ((msg_comm.MsgHead)localObject1).from_uin.get();
              l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
              j = ((msg_comm.MsgHead)localObject1).msg_type.get();
              localObject1 = paramMsg.msg_body.msg_content.get().toByteArray();
              localObject2 = new byte[localObject1.length];
              bhvd.a((byte[])localObject2, 0, (byte[])localObject1, 0, localObject2.length);
            } while (localObject2.length < 5);
            k = localObject2[4];
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x2dcDecoder", 2, "<---hotchat and opentroop push  groupCode:" + bhvd.a((byte[])localObject1, 0) + " subType:" + k);
            }
            if ((k != 12) && (k != 14)) {
              break;
            }
          } while (!((bgsl)paramMessageHandler.app.getManager(48)).a((byte[])localObject2, i));
          bcrw.a(paramMessageHandler.app.a(), l1, i, l2, j);
          return;
          if ((k != 16) && (k != 17) && (k != 20) && (k != 21)) {
            break;
          }
          localObject2 = new bcsn(this);
          if (localObject1.length > 7)
          {
            bgul localbgul = (bgul)paramMessageHandler.app.getManager(81);
            byte[] arrayOfByte = new byte[localObject1.length - 7];
            bhvd.a(arrayOfByte, 0, (byte[])localObject1, 7, arrayOfByte.length);
            paramList.add(localbgul.a(paramMessageHandler.app, arrayOfByte, i, paramMsg.msg_head.msg_time.get(), true, parambcre.d, (bcsn)localObject2));
          }
        } while (!((bcsn)localObject2).a);
        bcrw.a(paramMessageHandler.app.a(), l1, i, l2, j);
      } while (!QLog.isColorLevel());
      QLog.d("MsgType0x2dcDecoder", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%d, seq:%d, msgUid:%d, msgType:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j) }));
      return;
    } while (k != 3);
    a(paramMessageHandler, (byte[])localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsm
 * JD-Core Version:    0.7.0.1
 */