package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$BatchGetNearbyC2CMsgInfoReq
  extends MessageMicro<BatchGetNearbyC2CMsgInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uid" }, new Object[] { Long.valueOf(0L) }, BatchGetNearbyC2CMsgInfoReq.class);
  public final PBRepeatField<Long> uid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.BatchGetNearbyC2CMsgInfoReq
 * JD-Core Version:    0.7.0.1
 */