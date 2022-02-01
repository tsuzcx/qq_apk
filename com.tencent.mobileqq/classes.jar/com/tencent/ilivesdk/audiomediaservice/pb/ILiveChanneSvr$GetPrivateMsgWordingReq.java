package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$GetPrivateMsgWordingReq
  extends MessageMicro<GetPrivateMsgWordingReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "to_uid" }, new Object[] { Long.valueOf(0L) }, GetPrivateMsgWordingReq.class);
  public final PBUInt64Field to_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.GetPrivateMsgWordingReq
 * JD-Core Version:    0.7.0.1
 */