package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class AEPbData$ImageInfo
  extends MessageMicro<ImageInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<AEPbData.FaceInfo> faceInfos = PBField.initRepeatMessage(AEPbData.FaceInfo.class);
  public final PBInt32Field faceNum = PBField.initInt32(0);
  public final PBBoolField hasFace = PBField.initBool(false);
  public final PBBytesField imageMask = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField imageRawData = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field imgHeight = PBField.initInt32(0);
  public final PBInt32Field imgWidth = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58 }, new String[] { "imageRawData", "hasFace", "faceNum", "faceInfos", "imgWidth", "imgHeight", "imageMask" }, new Object[] { localByteStringMicro1, Boolean.valueOf(false), localInteger, null, localInteger, localInteger, localByteStringMicro2 }, ImageInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageInfo
 * JD-Core Version:    0.7.0.1
 */