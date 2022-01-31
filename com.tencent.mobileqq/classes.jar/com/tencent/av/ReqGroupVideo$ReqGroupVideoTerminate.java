package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$ReqGroupVideoTerminate
  extends MessageMicro<ReqGroupVideoTerminate>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_operator", "uint64_group", "uint64_room_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqGroupVideoTerminate.class);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_operator = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.ReqGroupVideoTerminate
 * JD-Core Version:    0.7.0.1
 */