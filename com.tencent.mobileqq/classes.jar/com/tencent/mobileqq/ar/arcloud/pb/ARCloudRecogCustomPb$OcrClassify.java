package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$OcrClassify
  extends MessageMicro<OcrClassify>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21 }, new String[] { "ocr_class", "confidence" }, new Object[] { "", Float.valueOf(0.0F) }, OcrClassify.class);
  public final PBFloatField confidence = PBField.initFloat(0.0F);
  public final PBStringField ocr_class = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.OcrClassify
 * JD-Core Version:    0.7.0.1
 */