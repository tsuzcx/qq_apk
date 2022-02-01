package com.hiboom.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyEmotionPb$Filter_Rsp
  extends MessageMicro<Filter_Rsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, Filter_Rsp.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public DiyEmotionPb.Filter_Rsp_Comm comm = new DiyEmotionPb.Filter_Rsp_Comm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public DiyEmotionPb.Filter_Text_Rsp rspcmd_0x01 = new DiyEmotionPb.Filter_Text_Rsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.hiboom.protocol.DiyEmotionPb.Filter_Rsp
 * JD-Core Version:    0.7.0.1
 */