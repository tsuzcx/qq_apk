package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class MobileQQDetect$PushDetectSrategyPacket
  extends MessageMicro<PushDetectSrategyPacket>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_buffer" }, new Object[] { localByteStringMicro }, PushDetectSrategyPacket.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect.PushDetectSrategyPacket
 * JD-Core Version:    0.7.0.1
 */