import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.codec.decoder.CreateGrpInPCDecoder.1;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bblr
  implements bbls
{
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbkm parambbkm)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int i = (short)paramList.msg_seq.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_uid.get();
    int j = paramList.msg_type.get();
    paramMsg = String.valueOf(bfqc.a(paramMsg.msg_body.msg_content.get().toByteArray()));
    paramList = (TroopManager)paramMessageHandler.app.getManager(52);
    if ((paramList != null) && (paramList.b(paramMsg) == null))
    {
      parambbkm = new TroopInfo();
      parambbkm.troopuin = paramMsg;
      parambbkm.troopcode = paramMsg;
      parambbkm.dwAdditionalFlag = 1L;
      paramList.b(parambbkm);
    }
    paramList = (anca)paramMessageHandler.app.getBusinessHandler(20);
    if (paramList != null) {
      paramMessageHandler.app.getHandler(getClass()).postDelayed(new CreateGrpInPCDecoder.1(this, paramList, paramMsg), 2000L);
    }
    bblf.a(paramMessageHandler, l1, i, l2, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblr
 * JD-Core Version:    0.7.0.1
 */