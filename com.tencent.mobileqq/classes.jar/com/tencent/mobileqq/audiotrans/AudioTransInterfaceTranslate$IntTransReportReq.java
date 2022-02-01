package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class AudioTransInterfaceTranslate$IntTransReportReq
  extends MessageMicro<IntTransReportReq>
{
  public static final int INT_TRANS_CREATE_REPORT = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_business_type = PBField.initEnum(1);
  public final PBEnumField enum_report_reason = PBField.initEnum(1);
  
  static
  {
    Integer localInteger = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "enum_business_type", "enum_report_reason" }, new Object[] { localInteger, localInteger }, IntTransReportReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransReportReq
 * JD-Core Version:    0.7.0.1
 */