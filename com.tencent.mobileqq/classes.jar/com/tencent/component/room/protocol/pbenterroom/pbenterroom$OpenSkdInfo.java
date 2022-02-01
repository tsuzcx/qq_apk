package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$OpenSkdInfo
  extends MessageMicro<OpenSkdInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field mode = PBField.initUInt32(0);
  public final PBBytesField sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field time = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "mode", "sig", "time" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, OpenSkdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.OpenSkdInfo
 * JD-Core Version:    0.7.0.1
 */