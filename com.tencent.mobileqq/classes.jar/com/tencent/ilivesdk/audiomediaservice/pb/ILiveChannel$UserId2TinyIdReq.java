package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChannel$UserId2TinyIdReq
  extends MessageMicro<UserId2TinyIdReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "target_uid", "auth_info", "sdkappid" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0) }, UserId2TinyIdReq.class);
  public ILiveChannel.AuthMsgInfo auth_info = new ILiveChannel.AuthMsgInfo();
  public final PBUInt32Field sdkappid = PBField.initUInt32(0);
  public final PBRepeatField<Long> target_uid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.UserId2TinyIdReq
 * JD-Core Version:    0.7.0.1
 */