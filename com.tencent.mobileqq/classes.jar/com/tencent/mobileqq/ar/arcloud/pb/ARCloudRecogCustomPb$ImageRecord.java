package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ARCloudRecogCustomPb$ImageRecord
  extends MessageMicro<ImageRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField angle = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field coordinate_x = PBField.initInt32(0);
  public final PBInt32Field coordinate_y = PBField.initInt32(0);
  public final PBInt32Field height = PBField.initInt32(0);
  public final PBBytesField source_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField target_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field width = PBField.initInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "source_text", "target_text", "coordinate_x", "coordinate_y", "width", "height", "angle" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, ImageRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageRecord
 * JD-Core Version:    0.7.0.1
 */