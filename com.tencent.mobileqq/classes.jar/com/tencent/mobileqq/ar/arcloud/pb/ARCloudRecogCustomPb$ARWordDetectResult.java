package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$ARWordDetectResult
  extends MessageMicro<ARWordDetectResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 61, 66 }, new String[] { "errorcode", "errormsg", "ar_word_detect_errorcode", "ar_word_detect_errormsg", "session_id", "word_type", "confidence", "ocr_class" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", Integer.valueOf(0), Float.valueOf(0.0F), null }, ARWordDetectResult.class);
  public final PBInt32Field ar_word_detect_errorcode = PBField.initInt32(0);
  public final PBStringField ar_word_detect_errormsg = PBField.initString("");
  public final PBFloatField confidence = PBField.initFloat(0.0F);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBRepeatMessageField<ARCloudRecogCustomPb.OcrClassify> ocr_class = PBField.initRepeatMessage(ARCloudRecogCustomPb.OcrClassify.class);
  public final PBStringField session_id = PBField.initString("");
  public final PBInt32Field word_type = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.ARWordDetectResult
 * JD-Core Version:    0.7.0.1
 */