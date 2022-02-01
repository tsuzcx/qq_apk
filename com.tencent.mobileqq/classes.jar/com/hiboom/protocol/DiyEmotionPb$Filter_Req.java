package com.hiboom.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyEmotionPb$Filter_Req
  extends MessageMicro<Filter_Req>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, Filter_Req.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public DiyEmotionPb.Filter_Req_Comm comm = new DiyEmotionPb.Filter_Req_Comm();
  public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
  public DiyEmotionPb.Filter_Text_Req reqcmd_0x01 = new DiyEmotionPb.Filter_Text_Req();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.hiboom.protocol.DiyEmotionPb.Filter_Req
 * JD-Core Version:    0.7.0.1
 */