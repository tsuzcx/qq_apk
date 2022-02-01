package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ILiveChannel$SdkData
  extends MessageMicro<SdkData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field sdk_app_id = PBField.initUInt32(0);
  public final PBBytesField sdk_app_token = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "sdk_app_id", "sdk_app_token" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SdkData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.SdkData
 * JD-Core Version:    0.7.0.1
 */