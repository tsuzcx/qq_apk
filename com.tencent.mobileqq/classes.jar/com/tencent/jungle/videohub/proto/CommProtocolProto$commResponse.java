package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CommProtocolProto$commResponse
  extends MessageMicro<commResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "seq", "code", "msg", "body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", localByteStringMicro }, commResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.jungle.videohub.proto.CommProtocolProto.commResponse
 * JD-Core Version:    0.7.0.1
 */