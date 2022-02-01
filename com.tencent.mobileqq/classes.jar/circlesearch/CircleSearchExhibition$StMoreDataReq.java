package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class CircleSearchExhibition$StMoreDataReq
  extends MessageMicro<StMoreDataReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ext_info", "type", "query" }, new Object[] { null, Integer.valueOf(0), "" }, StMoreDataReq.class);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBStringField query = PBField.initString("");
  public final PBUInt32Field type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StMoreDataReq
 * JD-Core Version:    0.7.0.1
 */