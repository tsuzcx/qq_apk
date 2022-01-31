package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoutuOcr$YoutuOcrRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "youtu_ocr_errorcode", "youtu_ocr_errormsg", "youtu_orc_detail" }, new Object[] { Integer.valueOf(0), "", null }, YoutuOcrRsp.class);
  public final PBInt32Field youtu_ocr_errorcode = PBField.initInt32(0);
  public final PBStringField youtu_ocr_errormsg = PBField.initString("");
  public YoutuOcr.YoutuOcrDetail youtu_orc_detail = new YoutuOcr.YoutuOcrDetail();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrRsp
 * JD-Core Version:    0.7.0.1
 */