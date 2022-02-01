package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChanneSvr$ImportImAccountReq
  extends MessageMicro<ImportImAccountReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "im_appid", "uids" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ImportImAccountReq.class);
  public final PBUInt32Field im_appid = PBField.initUInt32(0);
  public final PBRepeatField<Long> uids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChanneSvr.ImportImAccountReq
 * JD-Core Version:    0.7.0.1
 */