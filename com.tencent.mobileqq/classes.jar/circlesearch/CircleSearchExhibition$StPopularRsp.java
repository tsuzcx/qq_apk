package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class CircleSearchExhibition$StPopularRsp
  extends MessageMicro<StPopularRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext_info", "words" }, new Object[] { null, null }, StPopularRsp.class);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<CircleSearchExhibition.StPopularWord> words = PBField.initRepeatMessage(CircleSearchExhibition.StPopularWord.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StPopularRsp
 * JD-Core Version:    0.7.0.1
 */