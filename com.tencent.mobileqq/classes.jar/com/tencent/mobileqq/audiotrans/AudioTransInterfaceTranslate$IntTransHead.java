package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AudioTransInterfaceTranslate$IntTransHead
  extends MessageMicro
{
  public static final int INT_TRANS_CHANGE_SESSION_REQ = 3;
  public static final int INT_TRANS_CHANGE_SESSION_RSP = 4;
  public static final int INT_TRANS_CLIENT_REPORT_REQ = 9;
  public static final int INT_TRANS_CLIENT_REPORT_RSP = 10;
  public static final int INT_TRANS_EXIT_SESSION_REQ = 5;
  public static final int INT_TRANS_EXIT_SESSION_RSP = 6;
  public static final int INT_TRANS_JOIN_SESSION_REQ = 1;
  public static final int INT_TRANS_JOIN_SESSION_RSP = 2;
  public static final int INT_TRANS_RAW_DATA_REQ = 7;
  public static final int INT_TRANS_RAW_DATA_RSP = 8;
  public static final int INT_TRANS_REPORT_CHANGE_REQ = 15;
  public static final int INT_TRANS_REPORT_CHANGE_RSP = 16;
  public static final int TRANS_INT_PUSH_DATA_REQ = 11;
  public static final int TRANS_INT_PUSH_DATA_RSP = 12;
  public static final int TRANS_INT_TIMEOUT_EXIT_REQ = 13;
  public static final int TRANS_INT_TIMEOUT_EXIT_RSP = 14;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "str_session_id", "str_uin", "uint32_seq", "enum_body_type", "uint32_error_no" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) }, IntTransHead.class);
  public final PBEnumField enum_body_type = PBField.initEnum(1);
  public final PBStringField str_session_id = PBField.initString("");
  public final PBStringField str_uin = PBField.initString("");
  public final PBUInt32Field uint32_error_no = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.audiotrans.AudioTransInterfaceTranslate.IntTransHead
 * JD-Core Version:    0.7.0.1
 */