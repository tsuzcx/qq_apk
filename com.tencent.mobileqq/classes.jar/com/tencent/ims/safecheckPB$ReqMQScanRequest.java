package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class safecheckPB$ReqMQScanRequest
  extends MessageMicro<ReqMQScanRequest>
{
  public static final int STRING_CHECK_PARAMETERS_FIELD_NUMBER = 4;
  public static final int STRING_CHECK_TARGET_FIELD_NUMBER = 3;
  public static final int UINT32_CHECK_CONDITION_FIELD_NUMBER = 5;
  public static final int UINT32_CHECK_TYPE_FIELD_NUMBER = 2;
  public static final int UINT32_CHECK_UID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint32_check_uid", "uint32_check_type", "string_check_target", "string_check_parameters", "uint32_check_condition" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, ReqMQScanRequest.class);
  public final PBStringField string_check_parameters = PBField.initString("");
  public final PBStringField string_check_target = PBField.initString("");
  public final PBUInt32Field uint32_check_condition = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_check_uid = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ims.safecheckPB.ReqMQScanRequest
 * JD-Core Version:    0.7.0.1
 */