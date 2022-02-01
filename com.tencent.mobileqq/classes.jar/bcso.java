import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcso
  implements bcsk
{
  private void a(MessageHandler paramMessageHandler, byte[] paramArrayOfByte)
  {
    long l = PkgTools.getLongData(paramArrayOfByte, 0);
    String str2 = String.valueOf(l);
    PkgTools.getLongData(paramArrayOfByte, 10);
    int i = PkgTools.getShortData(paramArrayOfByte, 16);
    String str1 = null;
    if (i > 0) {
      str1 = PkgTools.getUTFString(paramArrayOfByte, 18, i);
    }
    if (QLog.isColorLevel()) {
      QLog.i("MsgType0x2dcDecoder", 2, "----->handleHotChatAnnouncementMsg dwGroupCode = " + l + ", len = " + i + ", announcement = " + str1);
    }
    paramArrayOfByte = (anwd)paramMessageHandler.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
    paramMessageHandler = (HotChatManager)paramMessageHandler.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if ((paramArrayOfByte != null) && (paramMessageHandler != null))
    {
      paramMessageHandler = paramMessageHandler.a(str2);
      if (paramMessageHandler != null)
      {
        if (paramMessageHandler.userCreate != 1) {
          break label158;
        }
        paramArrayOfByte.a(str2);
      }
    }
    return;
    label158:
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
              PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, 0, localObject2.length);
            } while (localObject2.length < 5);
            k = localObject2[4];
            if (QLog.isColorLevel()) {
              QLog.d("MsgType0x2dcDecoder", 2, "<---hotchat and opentroop push  groupCode:" + PkgTools.getLongData((byte[])localObject1, 0) + " subType:" + k);
            }
            if ((k != 12) && (k != 14)) {
              break;
            }
          } while (!((bgkf)paramMessageHandler.app.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a((byte[])localObject2, i));
          bcrx.a(paramMessageHandler.app.getMsgHandler(), l1, i, l2, j);
          return;
          if ((k != 16) && (k != 17) && (k != 20) && (k != 21)) {
            break;
          }
          localObject2 = new bcsp(this);
          if (localObject1.length > 7)
          {
            bgmf localbgmf = (bgmf)paramMessageHandler.app.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
            byte[] arrayOfByte = new byte[localObject1.length - 7];
            PkgTools.copyData(arrayOfByte, 0, (byte[])localObject1, 7, arrayOfByte.length);
            paramList.add(localbgmf.a(paramMessageHandler.app, arrayOfByte, i, paramMsg.msg_head.msg_time.get(), true, parambcre.d, (bcsp)localObject2));
          }
        } while (!((bcsp)localObject2).a);
        bcrx.a(paramMessageHandler.app.getMsgHandler(), l1, i, l2, j);
      } while (!QLog.isColorLevel());
      QLog.d("MsgType0x2dcDecoder", 2, String.format("handle0x2dcMessage==>sendDelMsgReqToServer fromUin:%d, seq:%d, msgUid:%d, msgType:%d", new Object[] { Long.valueOf(l1), Integer.valueOf(i), Long.valueOf(l2), Integer.valueOf(j) }));
      return;
    } while (k != 3);
    a(paramMessageHandler, (byte[])localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcso
 * JD-Core Version:    0.7.0.1
 */