package com.tencent.mobileqq.biuGuide;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SSOBiuGuide$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "ret_info", "uint64_uin", "rpt_msg_uin_info" }, new Object[] { null, Long.valueOf(0L), null }, RspBody.class);
  public SSOBiuGuide.RetInfo ret_info = new SSOBiuGuide.RetInfo();
  public final PBRepeatMessageField<SSOBiuGuide.UinInfo> rpt_msg_uin_info = PBField.initRepeatMessage(SSOBiuGuide.UinInfo.class);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.biuGuide.SSOBiuGuide.RspBody
 * JD-Core Version:    0.7.0.1
 */