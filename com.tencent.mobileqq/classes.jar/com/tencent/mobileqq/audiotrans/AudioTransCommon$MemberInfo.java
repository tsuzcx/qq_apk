package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransCommon$MemberInfo
  extends MessageMicro<MemberInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField enum_net_type = PBField.initEnum(1);
  public final PBEnumField enum_term = PBField.initEnum(1);
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger1 = Integer.valueOf(0);
    Integer localInteger2 = Integer.valueOf(1);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "str_uin", "uint32_client_ver", "enum_term", "enum_net_type", "uint32_client_port" }, new Object[] { "", localInteger1, localInteger2, localInteger2, localInteger1 }, MemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransCommon.MemberInfo
 * JD-Core Version:    0.7.0.1
 */