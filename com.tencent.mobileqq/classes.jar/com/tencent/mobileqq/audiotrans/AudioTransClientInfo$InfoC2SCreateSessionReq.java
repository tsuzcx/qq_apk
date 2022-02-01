package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AudioTransClientInfo$InfoC2SCreateSessionReq
  extends MessageMicro<InfoC2SCreateSessionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_business_type", "rpt_member_list" }, new Object[] { Integer.valueOf(1), "" }, InfoC2SCreateSessionReq.class);
  public final PBEnumField enum_business_type = PBField.initEnum(1);
  public final PBRepeatField<String> rpt_member_list = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInfo.InfoC2SCreateSessionReq
 * JD-Core Version:    0.7.0.1
 */