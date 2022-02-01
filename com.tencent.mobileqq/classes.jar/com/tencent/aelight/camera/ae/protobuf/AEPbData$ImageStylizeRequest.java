package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class AEPbData$ImageStylizeRequest
  extends MessageMicro<ImageStylizeRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "imgInfo", "stylizeType" }, new Object[] { null, Integer.valueOf(0) }, ImageStylizeRequest.class);
  public AEPbData.ImageInfo imgInfo = new AEPbData.ImageInfo();
  public final PBEnumField stylizeType = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.ImageStylizeRequest
 * JD-Core Version:    0.7.0.1
 */