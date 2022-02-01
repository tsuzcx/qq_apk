package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class AEPbData$DebugTextureData
  extends MessageMicro<DebugTextureData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField eyebrow_uv = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField face_landmark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField face_normal = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField face_uv = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "face_uv", "face_normal", "eyebrow_uv", "face_landmark" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, DebugTextureData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.DebugTextureData
 * JD-Core Version:    0.7.0.1
 */