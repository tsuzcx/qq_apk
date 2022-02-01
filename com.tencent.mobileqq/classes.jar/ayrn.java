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

public class ayrn
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, ayrv paramayrv)
  {
    ilive_feeds_read.ReadNearUserFeedsReq localReadNearUserFeedsReq = new ilive_feeds_read.ReadNearUserFeedsReq();
    try
    {
      localReadNearUserFeedsReq.uin.set(Long.valueOf(paramString).longValue());
      localReadNearUserFeedsReq.pos.set(paramInt2);
      localReadNearUserFeedsReq.num.set(paramInt3);
      localReadNearUserFeedsReq.nowid.set(paramLong);
      localReadNearUserFeedsReq.id_type.set(paramInt1);
      paramString = SosoInterface.b();
      if ((paramString != null) && (paramString.a != null))
      {
        paramString = paramString.a;
        localReadNearUserFeedsReq.lat.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.a)));
        localReadNearUserFeedsReq.lng.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramString.b)));
        if (QLog.isColorLevel()) {
          QLog.i("NearbyMomentProtocol", 2, "getMomentList, req.lat=" + paramString.a + ",req.lng=" + paramString.b);
        }
      }
      new aydi(paramQQAppInterface).a(24624).b(10).a(new ayrp(paramInt2, paramayrv)).a(new ayro(paramayrv, paramInt2)).a(localReadNearUserFeedsReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      QLog.i("NearbyMomentProtocol", 1, "getNearbyMomentsList, transfer uin error, uin=" + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, ayru paramayru)
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
    new aydi(paramQQAppInterface).a(22528).b(5).a(new ayrr(paramayru, paramString)).a(new ayrq(paramayru, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ayrw paramayrw)
  {
    new aydm(paramQQAppInterface).a(paramString, new ayrs(paramayrw), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, ayrx paramayrx)
  {
    new aydm(paramQQAppInterface).b(paramString, new ayrt(paramayrx), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrn
 * JD-Core Version:    0.7.0.1
 */