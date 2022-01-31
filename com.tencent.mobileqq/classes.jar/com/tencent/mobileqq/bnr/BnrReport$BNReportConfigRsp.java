package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BnrReport$BNReportConfigRsp
  extends MessageMicro<BNReportConfigRsp>
{
  public static final int CFGLIST_FIELD_NUMBER = 2;
  public static final int RET_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ret_info", "cfglist" }, new Object[] { null, null }, BNReportConfigRsp.class);
  public final PBRepeatMessageField<BnrReport.BNReportConfig> cfglist = PBField.initRepeatMessage(BnrReport.BNReportConfig.class);
  public BnrReport.RetInfo ret_info = new BnrReport.RetInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bnr.BnrReport.BNReportConfigRsp
 * JD-Core Version:    0.7.0.1
 */