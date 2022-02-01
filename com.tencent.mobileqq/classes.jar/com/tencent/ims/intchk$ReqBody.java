package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int MSG_APP_INFO_FIELD_NUMBER = 2;
  public static final int MSG_CHECK_CONFIG_REQ_FIELD_NUMBER = 3;
  public static final int MSG_REPORT_CHECK_RESULT_REQ_FIELD_NUMBER = 4;
  public static final int MSG_REPORT_STRIKE_RESULT_REQ_FIELD_NUMBER = 5;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "uint32_subcmd", "msg_app_info", "msg_check_config_req", "msg_report_check_result_req", "msg_report_strike_result_req" }, new Object[] { Integer.valueOf(0), null, null, null, null }, ReqBody.class);
  public intchk.AppInfo msg_app_info = new intchk.AppInfo();
  public intchk.FetchCheckConfigReq msg_check_config_req = new intchk.FetchCheckConfigReq();
  public intchk.ReportCheckResultReq msg_report_check_result_req = new intchk.ReportCheckResultReq();
  public intchk.ReportStrikeResultReq msg_report_strike_result_req = new intchk.ReportStrikeResultReq();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.intchk.ReqBody
 * JD-Core Version:    0.7.0.1
 */