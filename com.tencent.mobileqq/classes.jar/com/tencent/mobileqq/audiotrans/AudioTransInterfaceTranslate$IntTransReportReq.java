package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class AudioTransInterfaceTranslate$IntTransReportReq
  extends MessageMicro
{
  public static final int INT_TRANS_CREATE_REPORT = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_business_type", "enum_report_reason" }, new Object[] { Integer.valueOf(1), Integer.valueOf(1) }, IntTransReportReq.class);
  public final PBEnumField enum_business_type = PBField.initEnum(1);
  public final PBEnumField enum_report_reason = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransReportReq
 * JD-Core Version:    0.7.0.1
 */