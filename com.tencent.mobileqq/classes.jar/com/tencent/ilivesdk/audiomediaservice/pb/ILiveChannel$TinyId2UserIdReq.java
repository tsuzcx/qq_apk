package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChannel$TinyId2UserIdReq
  extends MessageMicro<TinyId2UserIdReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "target_tinyid", "sdkappid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, TinyId2UserIdReq.class);
  public final PBUInt32Field sdkappid = PBField.initUInt32(0);
  public final PBRepeatField<Long> target_tinyid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.TinyId2UserIdReq
 * JD-Core Version:    0.7.0.1
 */