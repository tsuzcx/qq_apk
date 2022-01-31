package com.tencent.biz.huiyin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ILiveProto$iLiveRequest
  extends MessageMicro<iLiveRequest>
{
  public static final int AUTH_APPID_FIELD_NUMBER = 15;
  public static final int AUTH_IP_FIELD_NUMBER = 14;
  public static final int AUTH_KEY_FIELD_NUMBER = 12;
  public static final int AUTH_TYPE_FIELD_NUMBER = 13;
  public static final int BINARY_BODY_FIELD_NUMBER = 6;
  public static final int BUSINESS_FIELD_NUMBER = 11;
  public static final int BUSS_ID_FIELD_NUMBER = 24;
  public static final int CLIENT_IP_FIELD_NUMBER = 9;
  public static final int CLIENT_PORT_FIELD_NUMBER = 17;
  public static final int CLIENT_TYPE_FIELD_NUMBER = 8;
  public static final int CMD_FIELD_NUMBER = 2;
  public static final int CODEC_FIELD_NUMBER = 25;
  public static final int EX_FIELD_NUMBER = 7;
  public static final int FLAG_FIELD_NUMBER = 18;
  public static final int ORIGINAL_AUTH_APPID_FIELD_NUMBER = 23;
  public static final int ORIGINAL_ID_FIELD_NUMBER = 19;
  public static final int ORIGINAL_ID_TYPE_FIELD_NUMBER = 22;
  public static final int ORIGINAL_KEY_FIELD_NUMBER = 20;
  public static final int ORIGINAL_KEY_TYPE_FIELD_NUMBER = 21;
  public static final int SEQ_FIELD_NUMBER = 4;
  public static final int SERVICE_IP_FIELD_NUMBER = 10;
  public static final int SUBCMD_FIELD_NUMBER = 3;
  public static final int TINYID_FIELD_NUMBER = 16;
  public static final int UID_FIELD_NUMBER = 5;
  public static final int VERSION_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field auth_appid = PBField.initUInt64(0L);
  public final PBUInt32Field auth_ip = PBField.initUInt32(0);
  public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field auth_type = PBField.initUInt32(0);
  public final PBBytesField binary_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField business = PBField.initString("");
  public final PBUInt64Field buss_id = PBField.initUInt64(0L);
  public final PBUInt32Field client_ip = PBField.initUInt32(0);
  public final PBUInt32Field client_port = PBField.initUInt32(0);
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBUInt32Field codec = PBField.initUInt32(0);
  public final PBBytesField ex = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBUInt64Field original_auth_appid = PBField.initUInt64(0L);
  public final PBBytesField original_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original_id_type = PBField.initUInt32(0);
  public final PBBytesField original_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original_key_type = PBField.initUInt32(0);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBUInt32Field service_ip = PBField.initUInt32(0);
  public final PBUInt32Field subcmd = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 98, 104, 112, 120, 128, 136, 144, 154, 162, 168, 176, 184, 192, 200 }, new String[] { "version", "cmd", "subcmd", "seq", "uid", "binary_body", "ex", "client_type", "client_ip", "service_ip", "business", "auth_key", "auth_type", "auth_ip", "auth_appid", "tinyid", "client_port", "flag", "original_id", "original_key", "original_key_type", "original_id_type", "original_auth_appid", "buss_id", "codec" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, iLiveRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.huiyin.ILiveProto.iLiveRequest
 * JD-Core Version:    0.7.0.1
 */