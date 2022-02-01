package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChannel$TinyId2UserIdRsp
  extends MessageMicro<TinyId2UserIdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "result", "userid", "tinyid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, TinyId2UserIdRsp.class);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBRepeatField<Long> tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> userid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.TinyId2UserIdRsp
 * JD-Core Version:    0.7.0.1
 */