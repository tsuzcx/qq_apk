package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientInterface$IntC2SJoinSessionRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_heartbeat_duration", "uint32_combine_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, IntC2SJoinSessionRsp.class);
  public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_heartbeat_duration = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInterface.IntC2SJoinSessionRsp
 * JD-Core Version:    0.7.0.1
 */