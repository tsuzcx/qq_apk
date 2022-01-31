package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientInfo$InfoHead
  extends MessageMicro<InfoHead>
{
  public static final int INFO_C2S_CREATE_SESSION_REQ = 1;
  public static final int INFO_C2S_CREATE_SESSION_RSP = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, InfoHead.class);
  public final PBEnumField enum_body_type = PBField.initEnum(1);
  public final PBStringField str_session_id = PBField.initString("");
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientInfo.InfoHead
 * JD-Core Version:    0.7.0.1
 */