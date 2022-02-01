package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$ReportStrikeResultReq
  extends MessageMicro<ReportStrikeResultReq>
{
  public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 1;
  public static final int UINT32_STRIKE_RESULT_FIELD_NUMBER = 3;
  public static final int UINT32_STRIKE_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strike_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strike_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_intchk_id", "uint32_strike_type", "uint32_strike_result" }, new Object[] { localInteger, localInteger, localInteger }, ReportStrikeResultReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.intchk.ReportStrikeResultReq
 * JD-Core Version:    0.7.0.1
 */