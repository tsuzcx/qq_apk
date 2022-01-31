package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetConfigFile
  extends MessageMicro<RspGetConfigFile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField config_download_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField config_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field config_file_type = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "result", "config_file_type", "config_download_url", "config_download_md5" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspGetConfigFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetConfigFile
 * JD-Core Version:    0.7.0.1
 */