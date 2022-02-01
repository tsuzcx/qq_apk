package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class get_config$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int STR_CONFIG_NAME_FIELD_NUMBER = 5;
  public static final int U32_APPID_FIELD_NUMBER = 3;
  public static final int U32_CONFIG_VERSION_FIELD_NUMBER = 6;
  public static final int U32_PROTO_VERSION_FIELD_NUMBER = 4;
  public static final int U32_SEQ_FIELD_NUMBER = 2;
  public static final int U64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField str_config_name = PBField.initString("");
  public final PBUInt32Field u32_appid = PBField.initUInt32(0);
  public final PBUInt32Field u32_config_version = PBField.initUInt32(0);
  public final PBUInt32Field u32_proto_version = PBField.initUInt32(0);
  public final PBUInt32Field u32_seq = PBField.initUInt32(0);
  public final PBUInt64Field u64_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "u64_uin", "u32_seq", "u32_appid", "u32_proto_version", "str_config_name", "u32_config_version" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, "", localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ims.get_config.ReqBody
 * JD-Core Version:    0.7.0.1
 */