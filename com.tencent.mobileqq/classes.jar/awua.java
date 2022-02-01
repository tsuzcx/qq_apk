import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import tencent.im.oidb.location.qq_lbs_share.C2CRelationInfo;
import tencent.im.oidb.location.qq_lbs_share.ResultInfo;
import tencent.im.oidb.location.qq_lbs_share.RoomKey;

public class awua
{
  @NotNull
  public static qq_lbs_share.RoomKey a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    qq_lbs_share.RoomKey localRoomKey = new qq_lbs_share.RoomKey();
    if (paramInt == 0)
    {
      localRoomKey.aio_type.set(2);
      localRoomKey.id1.set(Math.min(paramLong, paramQQAppInterface.getLongAccountUin()));
      localRoomKey.id2.set(Math.max(paramLong, paramQQAppInterface.getLongAccountUin()));
    }
    for (;;)
    {
      localRoomKey.setHasFlag(true);
      return localRoomKey;
      if (paramInt == 1)
      {
        localRoomKey.aio_type.set(1);
        localRoomKey.id1.set(paramLong);
        localRoomKey.id2.set(0L);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString, boolean paramBoolean)
  {
    if (paramInt == 0)
    {
      paramQQAppInterface = (anyw)paramQQAppInterface.getManager(51);
      paramString = paramQQAppInterface.a(paramString);
      if (paramString != null)
      {
        if (!paramBoolean) {
          break label77;
        }
        paramInt = 1;
        paramString.isSharingLocation = paramInt;
        paramQQAppInterface.a(paramString);
        if (QLog.isColorLevel()) {
          QLog.d("LocationProtoUtil", 2, new Object[] { "updateShareLocationProfileFlag: invoked. saved share state. ", " ei.isSharingLocation: ", Integer.valueOf(paramString.isSharingLocation) });
        }
      }
    }
    label77:
    do
    {
      do
      {
        do
        {
          return;
          paramInt = 0;
          break;
        } while (paramInt != 1);
        paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
        paramString = paramQQAppInterface.c(paramString);
      } while (paramString == null);
      paramString.setIsSharingLocation(paramBoolean);
      paramQQAppInterface.b(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("LocationProtoUtil", 2, "updateShareLocationProfileFlag: invoked. saved TroopInfo & lastShareLbsMsgUniseq");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return a(paramQQAppInterface, paramString);
    }
    if (paramInt == 1) {
      return b(paramQQAppInterface, paramString);
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, PBBytesField paramPBBytesField)
  {
    boolean bool = true;
    paramPBBytesField = paramPBBytesField.get().toByteArray();
    qq_lbs_share.C2CRelationInfo localC2CRelationInfo = new qq_lbs_share.C2CRelationInfo();
    try
    {
      localC2CRelationInfo.mergeFrom(paramPBBytesField);
      long l1 = localC2CRelationInfo.id1.get();
      long l2 = localC2CRelationInfo.id2.get();
      if (QLog.isColorLevel()) {
        QLog.d("LocationProtoUtil", 2, new Object[] { "isC2cSharingLocation: invoked. C2C profile flag [uin不为0即可说明正在分享]", " id1: ", Long.valueOf(l1), " id2: ", Long.valueOf(l2) });
      }
      if (paramQQAppInterface.getLongAccountUin() == l1)
      {
        if (l2 <= 0L) {
          break label147;
        }
        return true;
      }
      long l3 = paramQQAppInterface.getLongAccountUin();
      if (l3 == l2)
      {
        if (l1 <= 0L) {
          return false;
        }
      }
      else {
        return false;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("LocationProtoUtil", 1, "isC2cSharingLocation: failed. ", paramQQAppInterface);
      bool = false;
    }
    return bool;
    label147:
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((anyw)paramQQAppInterface.getManager(51)).a(paramString);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "isC2cSharingLocation: invoked. ", " isSharingLocation: ", Integer.valueOf(paramQQAppInterface.isSharingLocation), " friendUin: ", paramString });
    }
    if (paramQQAppInterface.isSharingLocation == 1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(qq_lbs_share.ResultInfo paramResultInfo)
  {
    boolean bool = true;
    if (paramResultInfo == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "rspSuccess: invoked. ", " resultInfo.uint32_result: ", Integer.valueOf(paramResultInfo.uint32_result.get()), " resultInfo.bytes_errmsg: ", paramResultInfo.bytes_errmsg.get().toStringUtf8(), " resultInfo.uint64_svr_time: ", Long.valueOf(paramResultInfo.uint64_svr_time.get()) });
    }
    if (paramResultInfo.uint32_result.get() == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    if (paramQQAppInterface == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("LocationProtoUtil", 2, new Object[] { "isGroupSharingLocation: invoked. ", " ti: ", Boolean.valueOf(paramQQAppInterface.isSharingLocation()) });
    }
    return paramQQAppInterface.isSharingLocation();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awua
 * JD-Core Version:    0.7.0.1
 */