package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xbf8$ReqBodyType2
  extends MessageMicro<ReqBodyType2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cookie", "rpt_ret_list" }, new Object[] { "", null }, ReqBodyType2.class);
  public final PBStringField cookie = PBField.initString("");
  public final PBRepeatMessageField<oidb_cmd0xbf8.ConfigResult> rpt_ret_list = PBField.initRepeatMessage(oidb_cmd0xbf8.ConfigResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBodyType2
 * JD-Core Version:    0.7.0.1
 */