package com.tencent.jungle.nearby.nio.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class nearby$BarInfo
  extends MessageMicro<BarInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_bar_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_bar_pic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_bar_url = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_bar_name", "bytes_bar_pic", "bytes_bar_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, BarInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jungle.nearby.nio.proto.nearby.BarInfo
 * JD-Core Version:    0.7.0.1
 */