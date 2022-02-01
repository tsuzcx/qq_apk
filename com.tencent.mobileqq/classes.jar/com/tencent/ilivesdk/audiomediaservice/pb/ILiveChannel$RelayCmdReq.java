package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveChannel$RelayCmdReq
  extends MessageMicro<RelayCmdReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ILiveChannel.AuthMsgInfo auth_info = new ILiveChannel.AuthMsgInfo();
  public final PBStringField cmd_name = PBField.initString("");
  public final PBBytesField request = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field sdkappid = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "tinyid", "cmd_name", "request", "auth_info", "sdkappid" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro, null, Integer.valueOf(0) }, RelayCmdReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.RelayCmdReq
 * JD-Core Version:    0.7.0.1
 */