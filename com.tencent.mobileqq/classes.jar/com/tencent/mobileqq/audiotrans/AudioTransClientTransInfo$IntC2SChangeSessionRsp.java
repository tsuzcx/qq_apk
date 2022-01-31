package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientTransInfo$IntC2SChangeSessionRsp
  extends MessageMicro<IntC2SChangeSessionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_combine_num", "enum_channel_type", "rpt_msg_interface_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(1), null }, IntC2SChangeSessionRsp.class);
  public final PBEnumField enum_channel_type = PBField.initEnum(1);
  public final PBRepeatMessageField<AudioTransCommon.NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon.NetAddr.class);
  public final PBUInt32Field uint32_combine_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntC2SChangeSessionRsp
 * JD-Core Version:    0.7.0.1
 */