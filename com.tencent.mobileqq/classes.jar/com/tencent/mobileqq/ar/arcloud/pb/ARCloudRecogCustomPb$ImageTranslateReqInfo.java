package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class ARCloudRecogCustomPb$ImageTranslateReqInfo
  extends MessageMicro<ImageTranslateReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField plateform = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField session_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField source_lang = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField target_lang = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "session_uuid", "source_lang", "target_lang", "plateform" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ImageTranslateReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ImageTranslateReqInfo
 * JD-Core Version:    0.7.0.1
 */