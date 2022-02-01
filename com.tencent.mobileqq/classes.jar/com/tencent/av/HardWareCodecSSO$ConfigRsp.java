package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class HardWareCodecSSO$ConfigRsp
  extends MessageMicro<ConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "codec_info" }, new Object[] { null }, ConfigRsp.class);
  public final PBRepeatMessageField<HardWareCodecSSO.PowerInfo> codec_info = PBField.initRepeatMessage(HardWareCodecSSO.PowerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.HardWareCodecSSO.ConfigRsp
 * JD-Core Version:    0.7.0.1
 */