import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedReq;
import com.tencent.pb.now.ilive_feeds_write.DelFeedStuct;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class axev
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, axfd paramaxfd)
  {
    ilive_feeds_read.ReadNearUserFeedsReq localReadNearUserFeedsReq = new ilive_feeds_read.ReadNearUserFeedsReq();
    try
    {
      localReadNearUserFeedsReq.uin.set(Long.valueOf(paramString).longValue());
      localReadNearUserFeedsReq.pos.set(paramInt2);
      localReadNearUserFeedsReq.num.set(paramInt3);
      localReadNearUserFeedsReq.nowid.set(paramLong);
      localReadNearUserFeedsReq.id_type.set(paramInt1);
      paramString = SosoInterface.getSosoInfo();
      if ((paramString != null) && (paramString.mLocation != null))
      {
        paramString = paramString.mLocation;
        localReadNearUserFeedsReq.lat.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.mLat02)));
        localReadNearUserFeedsReq.lng.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.mLon02)));
        if (QLog.isColorLevel()) {
          QLog.i("NearbyMomentProtocol", 2, "getMomentList, req.lat=" + paramString.mLat02 + ",req.lng=" + paramString.mLon02);
        }
      }
      new awqq(paramQQAppInterface).a(24624).b(10).a(new axex(paramInt2, paramaxfd)).a(new axew(paramaxfd, paramInt2)).a(localReadNearUserFeedsReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      QLog.i("NearbyMomentProtocol", 1, "getNearbyMomentsList, transfer uin error, uin=" + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, axfc paramaxfc)
  {
    ilive_feeds_write.DelFeedReq localDelFeedReq = new ilive_feeds_write.DelFeedReq();
    ilive_feeds_write.DelFeedStuct localDelFeedStuct = new ilive_feeds_write.DelFeedStuct();
    localDelFeedStuct.feed_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDelFeedStuct.timestamp.set(paramLong);
    localDelFeedStuct.feed_type.set(paramInt);
    localDelFeedReq.del_type.set(2);
    localDelFeedReq.select_all.set(0);
    localDelFeedReq.del_st.get().add(localDelFeedStuct);
    localDelFeedReq.uid.set(Long.valueOf(paramQQAppInterface.getCurrentAccountUin()).longValue());
    new awqq(paramQQAppInterface).a(22528).b(5).a(new axez(paramaxfc, paramString)).a(new axey(paramaxfc, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axfe paramaxfe)
  {
    new awqu(paramQQAppInterface).a(paramString, new axfa(paramaxfe), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, axff paramaxff)
  {
    new awqu(paramQQAppInterface).b(paramString, new axfb(paramaxff), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axev
 * JD-Core Version:    0.7.0.1
 */