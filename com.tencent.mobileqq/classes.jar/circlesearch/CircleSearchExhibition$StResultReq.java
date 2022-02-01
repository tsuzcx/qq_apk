package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class CircleSearchExhibition$StResultReq
  extends MessageMicro<StResultReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext_info", "query" }, new Object[] { null, "" }, StResultReq.class);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBStringField query = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StResultReq
 * JD-Core Version:    0.7.0.1
 */