package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class appoint_define$RptInterestTag
  extends MessageMicro<RptInterestTag>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_interest_tags" }, new Object[] { null }, RptInterestTag.class);
  public final PBRepeatMessageField<appoint_define.InterestTag> rpt_interest_tags = PBField.initRepeatMessage(appoint_define.InterestTag.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appoint.define.appoint_define.RptInterestTag
 * JD-Core Version:    0.7.0.1
 */