package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CommProtocolProto$commRequest
  extends MessageMicro<commRequest>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_name = PBField.initString("");
  public final PBUInt64Field auth_appid = PBField.initUInt64(0L);
  public final PBStringField auth_ip = PBField.initString("");
  public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField auth_type = PBField.initEnum(0);
  public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField business = PBField.initString("");
  public final PBStringField client_ip = PBField.initString("");
  public final PBStringField client_ipv6 = PBField.initString("");
  public final PBStringField client_release = PBField.initString("");
  public final PBEnumField client_type = PBField.initEnum(0);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBBytesField extra_room_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField from_id = PBField.initString("");
  public final PBUInt64Field microtime = PBField.initUInt64(0L);
  public final PBEnumField network = PBField.initEnum(-1);
  public final PBStringField openid = PBField.initString("");
  public final PBUInt64Field original_auth_appid = PBField.initUInt64(0L);
  public final PBBytesField original_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original_id_type = PBField.initUInt32(0);
  public final PBBytesField original_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field original_key_type = PBField.initUInt32(0);
  public final PBUInt32Field sdkappid = PBField.initUInt32(0);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBStringField service_ip = PBField.initString("");
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField user_sig = PBField.initString("");
  public final PBUInt32Field version = PBField.initUInt32(1);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96, 104, 114, 122, 128, 136, 146, 154, 160, 170, 178, 186, 192, 200, 208, 216, 226, 232, 242 }, new String[] { "version", "app_name", "cmd", "seq", "client_ip", "service_ip", "business", "auth_key", "auth_type", "auth_ip", "auth_appid", "uid", "uin", "openid", "body", "microtime", "client_type", "client_release", "user_sig", "network", "from_id", "original_id", "original_key", "original_key_type", "original_id_type", "original_auth_appid", "tinyid", "client_ipv6", "sdkappid", "extra_room_data" }, new Object[] { Integer.valueOf(1), "", Integer.valueOf(0), Long.valueOf(0L), "", "", "", localByteStringMicro1, Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(-1), "", localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro5 }, commRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.jungle.videohub.proto.CommProtocolProto.commRequest
 * JD-Core Version:    0.7.0.1
 */