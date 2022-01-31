package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AVFunChat$AVFunChatMessage
  extends MessageMicro<AVFunChatMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "enum_operator", "uint64_type", "str_msg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, AVFunChatMessage.class);
  public final PBEnumField enum_operator = PBField.initEnum(0);
  public final PBStringField str_msg = PBField.initString("");
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.AVFunChat.AVFunChatMessage
 * JD-Core Version:    0.7.0.1
 */