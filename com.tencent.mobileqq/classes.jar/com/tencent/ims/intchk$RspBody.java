package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class intchk$RspBody
  extends MessageMicro
{
  public static final int MSG_CHECK_CONFIG_RSP_FIELD_NUMBER = 3;
  public static final int MSG_REPORT_CHECK_RESULT_RSP_FIELD_NUMBER = 4;
  public static final int UINT32_RESULT_FIELD_NUMBER = 2;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_subcmd", "uint32_result", "msg_check_config_rsp", "msg_report_check_result_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
  public intchk.FetchCheckConfigRsp msg_check_config_rsp = new intchk.FetchCheckConfigRsp();
  public intchk.ReportCheckResultRsp msg_report_check_result_rsp = new intchk.ReportCheckResultRsp();
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.intchk.RspBody
 * JD-Core Version:    0.7.0.1
 */