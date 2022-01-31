package com.tencent.device.file;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class DeviceProto$MsgActionInfo
  extends MessageMicro<MsgActionInfo>
{
  public static final int BYTES_BUFF_WITH_FILE_FIELD_NUMBER = 2;
  public static final int STR_BUSSINESS_NAME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buff_with_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_bussiness_name = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_bussiness_name", "bytes_buff_with_file" }, new Object[] { "", localByteStringMicro }, MsgActionInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.file.DeviceProto.MsgActionInfo
 * JD-Core Version:    0.7.0.1
 */