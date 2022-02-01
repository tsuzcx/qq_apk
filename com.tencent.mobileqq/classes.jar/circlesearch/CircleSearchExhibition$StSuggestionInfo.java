package circlesearch;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class CircleSearchExhibition$StSuggestionInfo
  extends MessageMicro<StSuggestionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "suggest_word", "suggest_type", "hit_key_word" }, new Object[] { "", Integer.valueOf(0), "" }, StSuggestionInfo.class);
  public final PBStringField hit_key_word = PBField.initString("");
  public final PBEnumField suggest_type = PBField.initEnum(0);
  public final PBStringField suggest_word = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     circlesearch.CircleSearchExhibition.StSuggestionInfo
 * JD-Core Version:    0.7.0.1
 */