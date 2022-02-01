package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudMeta.StFeed;
import qqcircle.QQCircleRead.CircleDetail;

public final class CircleSearchExhibition$StResultRsp
  extends MessageMicro<StResultRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<QQCircleRead.CircleDetail> companys = PBField.initRepeatMessage(QQCircleRead.CircleDetail.class);
  public final PBUInt32Field companys_end = PBField.initUInt32(0);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<FeedCloudMeta.StFeed> feeds = PBField.initRepeatMessage(FeedCloudMeta.StFeed.class);
  public final PBUInt32Field feeds_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<QQCircleRead.CircleDetail> schools = PBField.initRepeatMessage(QQCircleRead.CircleDetail.class);
  public final PBUInt32Field schools_end = PBField.initUInt32(0);
  public final PBRepeatMessageField<CircleSearchExhibition.StExhTag> tags = PBField.initRepeatMessage(CircleSearchExhibition.StExhTag.class);
  public final PBUInt32Field tags_end = PBField.initUInt32(0);
  public final PBStringField tags_more_url = PBField.initString("");
  public final PBRepeatMessageField<CircleSearchExhibition.StExhUser> users = PBField.initRepeatMessage(CircleSearchExhibition.StExhUser.class);
  public final PBUInt32Field users_end = PBField.initUInt32(0);
  public final PBStringField users_more_url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 56, 66, 72, 82, 88, 98, 106 }, new String[] { "ext_info", "tags", "tags_end", "schools", "schools_end", "companys", "companys_end", "users", "users_end", "feeds", "feeds_end", "tags_more_url", "users_more_url" }, new Object[] { null, null, localInteger, null, localInteger, null, localInteger, null, localInteger, null, localInteger, "", "" }, StResultRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StResultRsp
 * JD-Core Version:    0.7.0.1
 */