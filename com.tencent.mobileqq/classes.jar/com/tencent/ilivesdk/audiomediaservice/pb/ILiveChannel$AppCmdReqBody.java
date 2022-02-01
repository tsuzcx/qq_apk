package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ILiveChannel$AppCmdReqBody
  extends MessageMicro<AppCmdReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ILiveChannel.SdkData msg_sdk_data = new ILiveChannel.SdkData();
  public final PBBytesField reqbody = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_sdk_data", "reqbody" }, new Object[] { null, localByteStringMicro }, AppCmdReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.AppCmdReqBody
 * JD-Core Version:    0.7.0.1
 */