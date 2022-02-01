package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoutuOcr$YoutuOcrDetail
  extends MessageMicro<YoutuOcrDetail>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 810, 818, 826 }, new String[] { "errorcode", "errormsg", "session_id", "ocr_item", "language", "ocr_language_list", "dst_translate_language_list", "language_list" }, new Object[] { Integer.valueOf(0), "", "", null, "", "", "", null }, YoutuOcrDetail.class);
  public final PBRepeatField<String> dst_translate_language_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field errorcode = PBField.initInt32(0);
  public final PBStringField errormsg = PBField.initString("");
  public final PBStringField language = PBField.initString("");
  public final PBRepeatMessageField<YoutuOcr.Language> language_list = PBField.initRepeatMessage(YoutuOcr.Language.class);
  public final PBRepeatMessageField<YoutuOcr.OcrItem> ocr_item = PBField.initRepeatMessage(YoutuOcr.OcrItem.class);
  public final PBRepeatField<String> ocr_language_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField session_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrDetail
 * JD-Core Version:    0.7.0.1
 */