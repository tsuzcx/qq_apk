package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$InteractPasterInfo
  extends MessageMicro<InteractPasterInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "paster_type", "paster_contents" }, new Object[] { Integer.valueOf(0), "" }, InteractPasterInfo.class);
  public final PBRepeatField<String> paster_contents = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field paster_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.InteractPasterInfo
 * JD-Core Version:    0.7.0.1
 */