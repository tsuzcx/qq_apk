package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon.StCommonExt;

public final class CircleSearchExhibition$StSuggestionRsp
  extends MessageMicro<StSuggestionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext_info", "infos" }, new Object[] { null, null }, StSuggestionRsp.class);
  public FeedCloudCommon.StCommonExt ext_info = new FeedCloudCommon.StCommonExt();
  public final PBRepeatMessageField<CircleSearchExhibition.StSuggestionInfo> infos = PBField.initRepeatMessage(CircleSearchExhibition.StSuggestionInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StSuggestionRsp
 * JD-Core Version:    0.7.0.1
 */