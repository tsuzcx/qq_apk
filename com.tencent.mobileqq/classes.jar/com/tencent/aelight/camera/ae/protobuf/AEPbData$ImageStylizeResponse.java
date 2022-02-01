package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class AEPbData$ImageStylizeResponse
  extends MessageMicro<ImageStylizeResponse>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field code = PBField.initInt32(0);
  public final PBBytesField imageRawData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField msg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "code", "msg", "imageRawData" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, ImageStylizeResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageStylizeResponse
 * JD-Core Version:    0.7.0.1
 */