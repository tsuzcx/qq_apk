package com.hiboom.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class DiyEmotionPb$Filter_Text_Rsp
  extends MessageMicro<Filter_Text_Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_valid" }, new Object[] { Boolean.valueOf(false) }, Filter_Text_Rsp.class);
  public final PBRepeatField<Boolean> is_valid = PBField.initRepeat(PBBoolField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.hiboom.protocol.DiyEmotionPb.Filter_Text_Rsp
 * JD-Core Version:    0.7.0.1
 */