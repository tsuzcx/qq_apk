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

public class ayla
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, ayli paramayli)
  {
    ilive_feeds_read.ReadNearUserFeedsReq localReadNearUserFeedsReq = new ilive_feeds_read.ReadNearUserFeedsReq();
    localReadNearUserFeedsReq.pos.set(paramInt2);
    localReadNearUserFeedsReq.num.set(paramInt3);
    localReadNearUserFeedsReq.id_type.set(paramInt1);
    localReadNearUserFeedsReq.bus_id.set(paramLong2);
    localReadNearUserFeedsReq.tinyid.set(paramLong1);
    Object localObject = SosoInterface.getSosoInfo();
    if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).mLocation != null))
    {
      localObject = ((SosoInterface.SosoLbsInfo)localObject).mLocation;
      localReadNearUserFeedsReq.lat.set(ByteStringMicro.copyFromUtf8(String.valueOf(((SosoInterface.SosoLocation)localObject).mLat02)));
      localReadNearUserFeedsReq.lng.set(ByteStringMicro.copyFromUtf8(String.valueOf(((SosoInterface.SosoLocation)localObject).mLon02)));
      if (QLog.isColorLevel()) {
        QLog.i("NearbyMomentProtocol", 2, "getMomentList, req.lat=" + ((SosoInterface.SosoLocation)localObject).mLat02 + ",req.lng=" + ((SosoInterface.SosoLocation)localObject).mLon02);
      }
    }
    new axws(paramQQAppInterface).a(971).b(1).a(new aylc(paramInt2, paramayli)).a(new aylb(paramayli, paramInt2)).a(localReadNearUserFeedsReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, aylh paramaylh)
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
    new axws(paramQQAppInterface).a(22528).b(5).a(new ayle(paramaylh, paramString)).a(new ayld(paramaylh, paramString)).a(localDelFeedReq.toByteArray());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aylj paramaylj)
  {
    new axww(paramQQAppInterface).a(paramString, new aylf(paramaylj), null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, aylk paramaylk)
  {
    new axww(paramQQAppInterface).b(paramString, new aylg(paramaylk), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayla
 * JD-Core Version:    0.7.0.1
 */