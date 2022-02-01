package com.tencent.ilivesdk.audiomediaservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ILiveChannel$RelayCmdRsp
  extends MessageMicro<RelayCmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField response = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field result = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "response" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RelayCmdRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.audiomediaservice.pb.ILiveChannel.RelayCmdRsp
 * JD-Core Version:    0.7.0.1
 */