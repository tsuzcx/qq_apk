package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveProto$iLiveResponse
  extends MessageMicro<iLiveResponse>
{
  public static final int BINARY_BODY_FIELD_NUMBER = 8;
  public static final int CLIENT_TYPE_FIELD_NUMBER = 10;
  public static final int CMD_FIELD_NUMBER = 2;
  public static final int ERR_CODE_FIELD_NUMBER = 6;
  public static final int ERR_MSG_FIELD_NUMBER = 7;
  public static final int EX_FIELD_NUMBER = 9;
  public static final int FLAG_FIELD_NUMBER = 11;
  public static final int SEQ_FIELD_NUMBER = 4;
  public static final int SUBCMD_FIELD_NUMBER = 3;
  public static final int UID_FIELD_NUMBER = 5;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField binary_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field err_code = PBField.initUInt32(0);
  public final PBStringField err_msg = PBField.initString("");
  public final PBBytesField ex = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74, 80, 88 }, new String[] { "version", "cmd", "subcmd", "seq", "uid", "err_code", "err_msg", "binary_body", "ex", "client_type", "flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, iLiveResponse.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huiyin.ILiveProto.iLiveResponse
 * JD-Core Version:    0.7.0.1
 */