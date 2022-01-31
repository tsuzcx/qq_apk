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

public class avrj
{
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt1, int paramInt2, int paramInt3, avrr paramavrr)
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
      new avdf(paramQQAppInterface).a(24624).b(10).a(new avrl(paramInt2, paramavrr)).a(new avrk(paramavrr, paramInt2)).a(localReadNearUserFeedsReq.toByteArray());
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      QLog.i("NearbyMomentProtocol", 1, "getNearbyMomentsList, transfer uin error, uin=" + paramString);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, avrq paramavrq)
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
    new avdf(paramQQAppInterface).a(22528).b(5).a(new avrn(paramavrq, paramString)).a(new avrm(paramavrq, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, avrs paramavrs)
  {
    new avdj(paramQQAppInterface).a(paramString, new avro(paramavrs), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, avrt paramavrt)
  {
    new avdj(paramQQAppInterface).b(paramString, new avrp(paramavrt), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avrj
 * JD-Core Version:    0.7.0.1
 */