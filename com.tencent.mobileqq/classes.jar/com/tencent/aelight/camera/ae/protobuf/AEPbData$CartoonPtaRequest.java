package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class AEPbData$CartoonPtaRequest
  extends MessageMicro<CartoonPtaRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "img", "debug" }, new Object[] { null, Boolean.valueOf(false) }, CartoonPtaRequest.class);
  public final PBBoolField debug = PBField.initBool(false);
  public AEPbData.ImageInfo img = new AEPbData.ImageInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.CartoonPtaRequest
 * JD-Core Version:    0.7.0.1
 */