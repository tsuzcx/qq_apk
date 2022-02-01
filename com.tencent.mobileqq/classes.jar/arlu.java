import OnlinePushPack.MsgInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForYanZhi;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x108.SubMsgType0x108.MsgBody;

public class arlu
{
  public static MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    if (paramArrayOfByte != null)
    {
      try
      {
        SubMsgType0x108.MsgBody localMsgBody = new SubMsgType0x108.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForYanZhi)bbzh.a(-2070);
        paramArrayOfByte.type = localMsgBody.uint32_type.get();
        paramArrayOfByte.pushUin = localMsgBody.uint64_push_uin.get();
        paramArrayOfByte.likeCount = localMsgBody.uint32_like_count.get();
        paramArrayOfByte.pushTime = localMsgBody.push_time.get();
        paramArrayOfByte.msg = (localMsgBody.uint32_like_count.get() + BaseApplicationImpl.getContext().getString(2131693829));
        long l2 = localMsgBody.push_time.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = paramMsgInfo.uRealMsgTime;
        }
        paramArrayOfByte.time = l1;
        paramArrayOfByte.msgseq = l1;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.isread = false;
        paramArrayOfByte.frienduin = anhk.H;
        paramArrayOfByte.senderuin = anhk.ap;
        paramArrayOfByte.getBytes();
        a(paramQQAppInterface, paramArrayOfByte);
        QLog.i("Q.msg_box.YanZhiHelper", 1, "decodePush0x210_0x108 decode error, e=" + paramArrayOfByte.toString());
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("decodePush0x210_0x108,decode MessageForYanZhi").append("type=").append(localMsgBody.uint32_type.get()).append(",pushUin=").append(localMsgBody.uint64_push_uin.get()).append(",likeCount=").append(localMsgBody.uint32_like_count.get()).append(",pushTime=").append(localMsgBody.push_time.get());
            QLog.i("Q.msg_box.YanZhiHelper", 2, paramQQAppInterface.toString());
          }
          return paramArrayOfByte;
        }
        catch (InvalidProtocolBufferMicroException paramMsgInfo)
        {
          for (;;)
          {
            paramQQAppInterface = paramArrayOfByte;
            paramArrayOfByte = paramMsgInfo;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
        paramQQAppInterface = null;
      }
      return paramQQAppInterface;
    }
    else
    {
      QLog.i("Q.msg_box.YanZhiHelper", 1, "decodePush0x210_0x108 pbData = null");
      return null;
    }
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, msg_comm.Msg paramMsg)
  {
    if (paramArrayOfByte != null)
    {
      try
      {
        SubMsgType0x108.MsgBody localMsgBody = new SubMsgType0x108.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (MessageForYanZhi)bbzh.a(-2070);
        paramArrayOfByte.type = localMsgBody.uint32_type.get();
        paramArrayOfByte.pushUin = localMsgBody.uint64_push_uin.get();
        paramArrayOfByte.likeCount = localMsgBody.uint32_like_count.get();
        paramArrayOfByte.pushTime = localMsgBody.push_time.get();
        paramArrayOfByte.msg = (localMsgBody.uint32_like_count.get() + BaseApplicationImpl.getContext().getString(2131693829));
        long l2 = localMsgBody.push_time.get();
        long l1 = l2;
        if (l2 <= 0L) {
          l1 = ((msg_comm.MsgHead)paramMsg.msg_head.get()).msg_time.get();
        }
        paramArrayOfByte.time = l1;
        paramArrayOfByte.msgseq = l1;
        paramArrayOfByte.shmsgseq = paramMsg.msg_head.msg_seq.get();
        paramArrayOfByte.msgUid = paramMsg.msg_head.msg_uid.get();
        paramArrayOfByte.selfuin = paramQQAppInterface.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.isread = false;
        paramArrayOfByte.frienduin = anhk.H;
        paramArrayOfByte.senderuin = anhk.ap;
        paramArrayOfByte.getBytes();
        a(paramQQAppInterface, paramArrayOfByte);
        QLog.i("Q.msg_box.YanZhiHelper", 1, "decodePull0x210_0x108 decode error, e=" + paramArrayOfByte.toString());
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            paramQQAppInterface = new StringBuilder();
            paramQQAppInterface.append("decodePull0x210_0x108,decode MessageForYanZhi").append("type=").append(localMsgBody.uint32_type.get()).append(",pushUin=").append(localMsgBody.uint64_push_uin.get()).append(",likeCount=").append(localMsgBody.uint32_like_count.get()).append(",pushTime=").append(localMsgBody.push_time.get());
            QLog.i("Q.msg_box.YanZhiHelper", 2, paramQQAppInterface.toString());
          }
          return paramArrayOfByte;
        }
        catch (InvalidProtocolBufferMicroException paramMsg)
        {
          for (;;)
          {
            paramQQAppInterface = paramArrayOfByte;
            paramArrayOfByte = paramMsg;
          }
        }
        paramArrayOfByte = paramArrayOfByte;
        paramQQAppInterface = null;
      }
      return paramQQAppInterface;
    }
    else
    {
      QLog.i("Q.msg_box.YanZhiHelper", 1, "decodePull0x210_0x108 pbData = null");
      return null;
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    paramAppInterface = (String)axdz.a(paramAppInterface.getCurrentAccountUin(), "key_banner_enter_items", "");
    try
    {
      paramAppInterface = new JSONArray(paramAppInterface);
      int i = 0;
      while (i < paramAppInterface.length())
      {
        Object localObject = paramAppInterface.optJSONObject(i);
        int j = ((JSONObject)localObject).optInt("id");
        localObject = ((JSONObject)localObject).optString("jumpUrl");
        if ((j == 2) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          paramAppInterface = (String)localObject + "5";
          return paramAppInterface;
        }
        i += 1;
      }
      return "https://nearby.qq.com/face_score/index.html?_wv=16781319&_wwv=1&_nav_txtclr=000000&_bid=2543&source=5";
    }
    catch (Exception paramAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.msg_box.YanZhiHelper", 2, "getYanzhiUrl:" + paramAppInterface.toString());
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, MessageForYanZhi paramMessageForYanZhi)
  {
    paramMessageForYanZhi = paramQQAppInterface.a().b(paramMessageForYanZhi.senderuin, paramMessageForYanZhi.istroop);
    if (paramMessageForYanZhi != null) {
      paramQQAppInterface.a().b(paramMessageForYanZhi.senderuin, paramMessageForYanZhi.istroop, paramMessageForYanZhi.uniseq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arlu
 * JD-Core Version:    0.7.0.1
 */