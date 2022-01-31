package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoutuOcr$YoutuOcrDetail
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "errorcode", "errormsg", "session_id", "ocr_item" }, new Object[] { Integer.valueOf(0), "", "", null }, YoutuOcrDetail.class);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBRepeatMessageField ocr_item = PBField.initRepeatMessage(YoutuOcr.OcrItem.class);
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrDetail
 * JD-Core Version:    0.7.0.1
 */