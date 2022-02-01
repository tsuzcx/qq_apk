package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspCheckActivity
  extends MessageMicro<RspCheckActivity>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "result", "is_activity", "next_check_time" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspCheckActivity.class);
  public final PBUInt32Field is_activity = PBField.initUInt32(0);
  public final PBUInt32Field next_check_time = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspCheckActivity
 * JD-Core Version:    0.7.0.1
 */