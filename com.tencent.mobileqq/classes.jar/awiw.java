import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.location.qq_lbs_share.PushExtInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x125.submsgtype0x125.MsgBody;

public class awiw
{
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CLocationPushDecoder", 2, new Object[] { "onDecodeC2cLbsUserQuitRoom: invoked. ", " operateUin = [" + paramLong1 + "], sessionUin = [" + paramLong2 + "]" });
    }
    if (paramLong1 == paramQQAppInterface.getLongAccountUin()) {
      awiz.a(paramQQAppInterface).a(new awit(0, String.valueOf(paramLong2)), false);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0x125.MsgBody paramMsgBody)
  {
    paramQQAppInterface = awiz.a(paramQQAppInterface);
    paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
    qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
    try
    {
      localPushExtInfo.mergeFrom(paramMsgBody);
      long l = localPushExtInfo.peer_uin.get();
      paramQQAppInterface.a.a(0, String.valueOf(l));
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("C2CLocationPushDecoder", 1, "onPushRoomMemberChanged: failed. ", paramQQAppInterface);
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, submsgtype0x125.MsgBody paramMsgBody, int paramInt)
  {
    paramQQAppInterface = awiz.a(paramQQAppInterface);
    long l1 = paramMsgBody.uint64_oper_uin.get();
    paramMsgBody = paramMsgBody.bytes_ext_info.get().toByteArray();
    qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
    for (;;)
    {
      try
      {
        localPushExtInfo.mergeFrom(paramMsgBody);
        long l2 = localPushExtInfo.peer_uin.get();
        paramMsgBody = new awit(0, String.valueOf(l2));
        paramQQAppInterface.a.a(0, String.valueOf(l2));
        switch (paramInt)
        {
        case 101: 
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("C2CLocationPushDecoder", 2, new Object[] { "[venue] c2c onPushRoomVenueChanged: invoked. roomKey: ", paramMsgBody + " opt: " + paramInt + " optUin: " + l1 });
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e("C2CLocationPushDecoder", 1, "[venue] c2c onPushRoomVenueChanged: failed. opt: " + paramInt + " optUin: " + l1, paramQQAppInterface);
        return;
      }
      paramQQAppInterface.a(paramMsgBody, String.valueOf(l1));
      continue;
      paramQQAppInterface.a(paramMsgBody);
      continue;
      paramQQAppInterface.b(paramMsgBody);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, short paramShort, int paramInt, boolean paramBoolean)
  {
    submsgtype0x125.MsgBody localMsgBody = new submsgtype0x125.MsgBody();
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      long l;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = awiz.a(paramQQAppInterface);
        byte[] arrayOfByte = localMsgBody.bytes_ext_info.get().toByteArray();
        qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
        localPushExtInfo.mergeFrom(arrayOfByte);
        l = localPushExtInfo.peer_uin.get();
        paramShort = localPushExtInfo.client_type.get();
        paramInt = localMsgBody.uint32_msg_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("C2CLocationPushDecoder", 2, new Object[] { "processC2C: invoked. ", " isOffline: ", Boolean.valueOf(paramBoolean), " optType: ", Integer.valueOf(paramInt) });
        }
        if (paramInt != 4) {
          break label290;
        }
        awni.a(paramQQAppInterface, String.valueOf(l));
        paramArrayOfByte.notifyUI(5, true, new Object[] { Integer.valueOf(0), String.valueOf(l) });
        awnj.a(paramQQAppInterface);
        paramArrayOfByte.notifyUI(4, true, new Object[] { localMsgBody });
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        label188:
        QLog.e("C2CLocationPushDecoder", 1, "processC2C: failed. ", paramQQAppInterface);
        return;
      }
      awnj.a(paramQQAppInterface, 0, String.valueOf(l), true);
      continue;
      label290:
      do
      {
        if (paramInt == 5)
        {
          awni.a(paramQQAppInterface, String.valueOf(l));
          paramArrayOfByte.notifyUI(6, true, new Object[] { Integer.valueOf(0), String.valueOf(l), Integer.valueOf(paramShort) });
          awnj.a(paramQQAppInterface);
          break;
        }
        if (paramInt != 3) {
          break;
        }
        a(paramQQAppInterface, localMsgBody.uint64_oper_uin.get(), l);
        break;
        return;
        if (paramInt == 1) {
          break label188;
        }
      } while (paramInt != 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awiw
 * JD-Core Version:    0.7.0.1
 */