import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x857.TroopTips0x857.LbsShareChangePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody;
import tencent.im.oidb.location.qq_lbs_share.PushExtInfo;

public class arve
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong, TroopTips0x857.NotifyMsgBody paramNotifyMsgBody)
  {
    paramNotifyMsgBody = (TroopTips0x857.LbsShareChangePushInfo)paramNotifyMsgBody.opt_lbs_share_change_plus_info.get();
    aruq localaruq = aruq.a(paramQQAppInterface);
    long l = paramNotifyMsgBody.uint64_group_id.get();
    int i = paramNotifyMsgBody.uint32_msg_type.get();
    if (QLog.isColorLevel()) {
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "processPacket: invoked. ", "msgSeq = [" + paramInt + "], msgTime = [" + paramLong + "], ", " pushType: ", Integer.valueOf(i), " sessionUin: ", Long.valueOf(l) });
    }
    if (i == 4)
    {
      aryw.b(paramQQAppInterface, String.valueOf(l));
      localaruq.notifyUI(5, true, new Object[] { Integer.valueOf(1), String.valueOf(l) });
      aryx.a(paramQQAppInterface);
    }
    for (;;)
    {
      localaruq.notifyUI(3, true, new Object[] { paramNotifyMsgBody });
      return;
      if ((i == 1) || (i == 2))
      {
        aryx.a(paramQQAppInterface, 1, String.valueOf(l), true);
      }
      else
      {
        if (i == 5)
        {
          paramInt = 4;
          try
          {
            byte[] arrayOfByte = paramNotifyMsgBody.bytes_ext_info.get().toByteArray();
            qq_lbs_share.PushExtInfo localPushExtInfo = new qq_lbs_share.PushExtInfo();
            localPushExtInfo.mergeFrom(arrayOfByte);
            i = localPushExtInfo.client_type.get();
            paramInt = i;
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            for (;;)
            {
              localInvalidProtocolBufferMicroException.printStackTrace();
            }
          }
          aryw.b(paramQQAppInterface, String.valueOf(l));
          localaruq.notifyUI(6, true, new Object[] { Integer.valueOf(1), String.valueOf(l), Integer.valueOf(paramInt) });
          aryx.a(paramQQAppInterface);
          continue;
        }
        if (i == 3) {
          a(paramQQAppInterface, paramNotifyMsgBody.uint64_oper_uin.get(), l);
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "onDecodeTroopLbsUserQuitRoom: invoked. ", " operateUin: ", Long.valueOf(paramLong1), " sessionUin: ", Long.valueOf(paramLong2) });
    }
    if (paramLong1 == paramQQAppInterface.getLongAccountUin()) {
      aruq.a(paramQQAppInterface).a(new aruk(1, String.valueOf(paramLong2)), false);
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, TroopTips0x857.LbsShareChangePushInfo paramLbsShareChangePushInfo)
  {
    paramQQAppInterface = aruq.a(paramQQAppInterface);
    long l = paramLbsShareChangePushInfo.uint64_group_id.get();
    paramQQAppInterface.a.a(1, String.valueOf(l));
    if (QLog.isColorLevel()) {
      QLog.d("TroopLocationPushDecoder", 2, new Object[] { "onPushRoomMemberChanged: invoked. ", " troopUin: ", Long.valueOf(l) });
    }
  }
  
  static void a(QQAppInterface paramQQAppInterface, TroopTips0x857.LbsShareChangePushInfo paramLbsShareChangePushInfo, int paramInt)
  {
    paramQQAppInterface = aruq.a(paramQQAppInterface);
    long l1 = paramLbsShareChangePushInfo.uint64_group_id.get();
    long l2 = paramLbsShareChangePushInfo.uint64_oper_uin.get();
    paramLbsShareChangePushInfo = new aruk(1, String.valueOf(l1));
    paramQQAppInterface.a.a(1, String.valueOf(l1));
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLocationPushDecoder", 2, new Object[] { "[venue] troop onPushRoomVenueChanged: invoked. roomKey: ", paramLbsShareChangePushInfo + " opt: " + paramInt + " optUin: " + l2 });
      }
      return;
      paramQQAppInterface.a(paramLbsShareChangePushInfo, String.valueOf(l2));
      continue;
      paramQQAppInterface.a(paramLbsShareChangePushInfo);
      continue;
      paramQQAppInterface.b(paramLbsShareChangePushInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arve
 * JD-Core Version:    0.7.0.1
 */