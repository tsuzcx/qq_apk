package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ILiveChannel$AppCmdRspBody
  extends MessageMicro<AppCmdRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public ILiveChannel.CmdErrorCode msg_cmd_error_code = new ILiveChannel.CmdErrorCode();
  public final PBBytesField rspbody = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_cmd_error_code", "rspbody" }, new Object[] { null, localByteStringMicro }, AppCmdRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.AppCmdRspBody
 * JD-Core Version:    0.7.0.1
 */