package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_service$RspGetHomePOI
  extends MessageMicro<RspGetHomePOI>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "country", "city" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, RspGetHomePOI.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetHomePOI
 * JD-Core Version:    0.7.0.1
 */