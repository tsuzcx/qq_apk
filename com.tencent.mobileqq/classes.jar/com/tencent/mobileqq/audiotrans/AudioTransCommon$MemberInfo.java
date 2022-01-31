package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransCommon$MemberInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "str_uin", "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0) }, MemberInfo.class);
  public final PBEnumField enum_net_type = PBField.initEnum(1);
  public final PBEnumField enum_term = PBField.initEnum(1);
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransCommon.MemberInfo
 * JD-Core Version:    0.7.0.1
 */