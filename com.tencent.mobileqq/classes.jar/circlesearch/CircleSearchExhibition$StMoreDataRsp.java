package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleRead.CircleDetail;

public final class CircleSearchExhibition$StMoreDataRsp
  extends MessageMicro<StMoreDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<QQCircleRead.CircleDetail> companys = PBField.initRepeatMessage(QQCircleRead.CircleDetail.class);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<QQCircleRead.CircleDetail> schools = PBField.initRepeatMessage(QQCircleRead.CircleDetail.class);
  public final PBRepeatMessageField<CircleSearchExhibition.StExhTag> tags = PBField.initRepeatMessage(CircleSearchExhibition.StExhTag.class);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBRepeatMessageField<CircleSearchExhibition.StExhUser> users = PBField.initRepeatMessage(CircleSearchExhibition.StExhUser.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 64 }, new String[] { "ext_info", "type", "tags", "schools", "companys", "users", "feeds", "is_end" }, new Object[] { null, localInteger, null, null, null, null, null, localInteger }, StMoreDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StMoreDataRsp
 * JD-Core Version:    0.7.0.1
 */