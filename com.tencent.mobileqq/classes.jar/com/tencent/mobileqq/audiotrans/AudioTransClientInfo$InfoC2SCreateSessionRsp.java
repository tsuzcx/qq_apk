package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class AudioTransClientInfo$InfoC2SCreateSessionRsp
  extends MessageMicro<InfoC2SCreateSessionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "enum_channel_type", "rpt_msg_interface_list", "bool_client_ans" }, new Object[] { Integer.valueOf(1), null, Boolean.valueOf(false) }, InfoC2SCreateSessionRsp.class);
  public final PBBoolField bool_client_ans = PBField.initBool(false);
  public final PBEnumField enum_channel_type = PBField.initEnum(1);
  public final PBRepeatMessageField<AudioTransCommon.NetAddr> rpt_msg_interface_list = PBField.initRepeatMessage(AudioTransCommon.NetAddr.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInfo.InfoC2SCreateSessionRsp
 * JD-Core Version:    0.7.0.1
 */