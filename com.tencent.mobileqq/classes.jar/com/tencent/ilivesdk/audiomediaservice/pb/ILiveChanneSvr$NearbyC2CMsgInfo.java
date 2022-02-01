package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$NearbyC2CMsgInfo
  extends MessageMicro<NearbyC2CMsgInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24 }, new String[] { "uid", "is_stranger" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false) }, NearbyC2CMsgInfo.class);
  public final PBBoolField is_stranger = PBField.initBool(false);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.NearbyC2CMsgInfo
 * JD-Core Version:    0.7.0.1
 */