package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class CircleSearchExhibition$StSuggestionReq
  extends MessageMicro<StSuggestionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext_info", "input_word" }, new Object[] { null, "" }, StSuggestionReq.class);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBStringField input_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StSuggestionReq
 * JD-Core Version:    0.7.0.1
 */