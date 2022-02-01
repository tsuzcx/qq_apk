import android.text.TextUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.im_msg_body.MsgBody;

public class bcsr
  implements bcsi
{
  private static void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has())) {
      if (QLog.isColorLevel()) {
        QLog.e("SystemMessageDecoder", 2, "<---decodeC2CMsgPkg_AddFriend return null:hasBody:" + paramMsg.msg_body.has() + ",hasMsgContent" + ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.has() + ",isReaded:" + paramBoolean1 + "syncOther:" + paramBoolean2);
      }
    }
    String str;
    do
    {
      do
      {
        return;
        long l1 = Long.valueOf(paramMessageHandler.app.getCurrentAccountUin()).longValue();
        long l2 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).from_uin.get();
        short s = (short)((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_type.get();
        if ((!paramBoolean1) && (!paramBoolean2) && (!paramBoolean3)) {
          paramMessageHandler.a().a(l1, l2, s, -1006 - (s - 187), paramMsg, paramInt);
        }
        localObject = (msg_comm.MsgHead)paramMsg.msg_head.get();
      } while (localObject == null);
      paramMsg = "" + ((msg_comm.MsgHead)localObject).auth_uin.get();
      str = ((msg_comm.MsgHead)localObject).auth_nick.get();
      Object localObject = ((msg_comm.MsgHead)localObject).auth_remark.get();
      if (QLog.isColorLevel()) {
        QLog.d("SystemMessageDecoder.sysnick", 2, "FriendSys auUin:" + paramMsg + "aunick:" + str + "auRemark:" + (String)localObject);
      }
      if ((!TextUtils.isEmpty(paramMsg)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SystemMessageDecoder.sysremark", 2, "FriendSys saveremark");
        }
        paramMessageHandler.b(paramMsg, (String)localObject);
      }
    } while ((TextUtils.isEmpty(paramMsg)) || (TextUtils.isEmpty(str)));
    if (QLog.isColorLevel()) {
      QLog.d("SystemMessageDecoder.sysnick", 2, "FriendSys savenick");
    }
    paramMessageHandler.a(paramMsg, str);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.systemmsg.", 2, "friend system msg notify");
    }
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    int j = (short)paramList.msg_seq.get();
    long l1 = paramList.from_uin.get();
    long l2 = paramList.msg_uid.get();
    int k = paramList.msg_type.get();
    int i = 0;
    if ((k == 188) || (k == 189)) {
      i = 1;
    }
    if ((!parambcre.c) && (i == 0)) {
      paramMessageHandler.a().a(2);
    }
    parambcre.e = 9998L;
    a(paramMessageHandler, paramMsg, parambcre.a, parambcre.f, parambcre.d, j);
    bcrw.a(paramMessageHandler, l1, j, l2, k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsr
 * JD-Core Version:    0.7.0.1
 */