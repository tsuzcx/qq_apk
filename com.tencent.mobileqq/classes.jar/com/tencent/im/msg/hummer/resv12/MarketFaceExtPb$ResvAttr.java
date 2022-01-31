package com.tencent.im.msg.hummer.resv12;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MarketFaceExtPb$ResvAttr
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 56, 64, 74, 80 }, new String[] { "rpt_support_size", "uint32_source_type", "str_source_name", "str_source_jump_url", "str_source_type_name", "uint32_start_time", "uint32_end_time", "uint32_emoji_type", "rpt_apng_support_size", "uint32_has_ip_product" }, new Object[] { null, Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, ResvAttr.class);
  public final PBRepeatMessageField rpt_apng_support_size = PBField.initRepeatMessage(MarketFaceExtPb.SupportSize.class);
  public final PBRepeatMessageField rpt_support_size = PBField.initRepeatMessage(MarketFaceExtPb.SupportSize.class);
  public final PBStringField str_source_jump_url = PBField.initString("");
  public final PBStringField str_source_name = PBField.initString("");
  public final PBStringField str_source_type_name = PBField.initString("");
  public final PBUInt32Field uint32_emoji_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_has_ip_product = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr
 * JD-Core Version:    0.7.0.1
 */