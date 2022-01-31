package com.tencent.device.file;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DeviceProto$MsgFileKey
  extends MessageMicro<MsgFileKey>
{
  public static final int BYTES_FILE_INDEX_FIELD_NUMBER = 1;
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 2;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 3;
  public static final int UINT32_APPID_FIELD_NUMBER = 5;
  public static final int UINT32_INSTID_FIELD_NUMBER = 6;
  public static final int UINT32_UIN_TYPE_FIELD_NUMBER = 8;
  public static final int UINT64_FILE_LENGTH_FIELD_NUMBER = 4;
  public static final int UINT64_SRC_UIN_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_uin_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_length = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "bytes_file_index", "bytes_file_md5", "str_file_name", "uint64_file_length", "uint32_appid", "uint32_instid", "uint64_src_uin", "uint32_uin_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, MsgFileKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.file.DeviceProto.MsgFileKey
 * JD-Core Version:    0.7.0.1
 */