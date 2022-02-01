package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CommonUserProto$LoginCheckRsp
  extends MessageMicro<LoginCheckRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField edu_flex_url = PBField.initString("");
  public final PBBoolField enable_report = PBField.initBool(false);
  public final PBBytesField extra_room_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field imsdk_account_type = PBField.initUInt64(0L);
  public final PBUInt64Field imsdk_appid = PBField.initUInt64(0L);
  public final PBBoolField is_need_init = PBField.initBool(false);
  public final PBBoolField is_new_user = PBField.initBool(false);
  public final PBBoolField is_playing = PBField.initBool(false);
  public final PBInt32Field result = PBField.initInt32(0);
  public final PBUInt64Field server_time = PBField.initUInt64(0L);
  public final PBStringField sso_heart_prefix = PBField.initString("");
  public final PBStringField sso_prefix = PBField.initString("");
  public final PBStringField sso_report_prefix = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBInt64Field uin = PBField.initInt64(0L);
  public final PBStringField user_name = PBField.initString("");
  public final PBStringField user_sig = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 56, 64, 72, 80, 88, 98, 106, 114, 122, 128, 138 }, new String[] { "result", "user_name", "uin", "user_sig", "uid", "enable_report", "is_need_init", "server_time", "is_new_user", "imsdk_appid", "imsdk_account_type", "sso_prefix", "sso_report_prefix", "sso_heart_prefix", "edu_flex_url", "is_playing", "extra_room_data" }, new Object[] { Integer.valueOf(0), "", localLong, "", localLong, localBoolean, localBoolean, localLong, localBoolean, localLong, localLong, "", "", "", "", localBoolean, localByteStringMicro }, LoginCheckRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.jungle.videohub.proto.CommonUserProto.LoginCheckRsp
 * JD-Core Version:    0.7.0.1
 */