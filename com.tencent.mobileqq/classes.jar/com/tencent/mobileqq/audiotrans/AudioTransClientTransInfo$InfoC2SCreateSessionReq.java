package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientTransInfo$InfoC2SCreateSessionReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "enum_business_type", "rpt_member_list", "enum_business_direction", "uint32_session_test_flag", "uint32_client_ver", "enum_term", "enum_net_type", "bool_translate", "result_report_addr" }, new Object[] { Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false), null }, InfoC2SCreateSessionReq.class);
  public final PBBoolField bool_translate = PBField.initBool(false);
  public final PBEnumField enum_business_direction = PBField.initEnum(1);
  public final PBEnumField enum_business_type = PBField.initEnum(1);
  public final PBEnumField enum_net_type = PBField.initEnum(1);
  public final PBEnumField enum_term = PBField.initEnum(1);
  public AudioTransCommon.NetAddr result_report_addr = new AudioTransCommon.NetAddr();
  public final PBRepeatField rpt_member_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_session_test_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.InfoC2SCreateSessionReq
 * JD-Core Version:    0.7.0.1
 */