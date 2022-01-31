package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class QQProtectRisks$QQProtectRisksResponse
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 58 }, new String[] { "uint32_sec_cmd", "str_no_risk_text", "risk_info_list", "uint32_qpim_switches", "str_risk_tip_text", "uint32_cache_time", "str_risk_exist" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0), "", Integer.valueOf(0), "" }, QQProtectRisksResponse.class);
  public final PBRepeatMessageField risk_info_list = PBField.initRepeatMessage(QQProtectRisks.RiskInfo.class);
  public final PBStringField str_no_risk_text = PBField.initString("");
  public final PBStringField str_risk_exist = PBField.initString("");
  public final PBStringField str_risk_tip_text = PBField.initString("");
  public final PBUInt32Field uint32_cache_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qpim_switches = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.ims.QQProtectRisks.QQProtectRisksResponse
 * JD-Core Version:    0.7.0.1
 */