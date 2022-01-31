package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransClientTransInfo$IntHead
  extends MessageMicro<IntHead>
{
  public static final int INT_C2S_CHANGE_SESSION_REQ = 5;
  public static final int INT_C2S_CHANGE_SESSION_RSP = 6;
  public static final int INT_C2S_EXIT_SESSION_REQ = 3;
  public static final int INT_C2S_EXIT_SESSION_RSP = 4;
  public static final int INT_C2S_HEART_BEAT_REQ = 9;
  public static final int INT_C2S_HEART_BEAT_RSP = 10;
  public static final int INT_C2S_JOIN_SESSION_REQ = 1;
  public static final int INT_C2S_JOIN_SESSION_RSP = 2;
  public static final int INT_C2S_RAW_DATA_REQ = 7;
  public static final int INT_C2S_RAW_DATA_RSP = 8;
  public static final int INT_S2C_NOTIFY_EXIT_REQ = 13;
  public static final int INT_S2C_NOTIFY_EXIT_RSP = 14;
  public static final int INT_S2C_PUSH_DATA_REQ = 11;
  public static final int INT_S2C_PUSH_DATA_RSP = 12;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, IntHead.class);
  public final PBEnumField enum_body_type = PBField.initEnum(1);
  public final PBStringField str_session_id = PBField.initString("");
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransClientTransInfo.IntHead
 * JD-Core Version:    0.7.0.1
 */