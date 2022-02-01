package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class ILiveChanneSvr$BatchGetNearbyC2CMsgInfoRsp
  extends MessageMicro<BatchGetNearbyC2CMsgInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "info" }, new Object[] { Integer.valueOf(0), null }, BatchGetNearbyC2CMsgInfoRsp.class);
  public final PBRepeatMessageField<ILiveChanneSvr.NearbyC2CMsgInfo> info = PBField.initRepeatMessage(ILiveChanneSvr.NearbyC2CMsgInfo.class);
  public final PBInt32Field retcode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.BatchGetNearbyC2CMsgInfoRsp
 * JD-Core Version:    0.7.0.1
 */