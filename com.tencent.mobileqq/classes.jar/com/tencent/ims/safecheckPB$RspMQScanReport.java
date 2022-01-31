package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class safecheckPB$RspMQScanReport
  extends MessageMicro
{
  public static final int RPT_CHECK_ITEM_FIELD_NUMBER = 3;
  public static final int UINT32_CHECK_COUNT_FIELD_NUMBER = 2;
  public static final int UINT32_CHECK_UID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_check_uid", "uint32_check_count", "rpt_check_item" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspMQScanReport.class);
  public final PBRepeatMessageField rpt_check_item = PBField.initRepeatMessage(safecheckPB.ReportItem.class);
  public final PBUInt32Field uint32_check_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_uid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.safecheckPB.RspMQScanReport
 * JD-Core Version:    0.7.0.1
 */