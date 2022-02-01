package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspAuthKey
  extends MessageMicro<RspAuthKey>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField backup_server_ip1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField backup_server_ip2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field expire_time = PBField.initUInt64(0L);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField server_ip1 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField server_ip2 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "result", "user_ip", "server_ip1", "server_ip2", "backup_server_ip1", "backup_server_ip2", "auth_key", "expire_time" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L) }, RspAuthKey.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspAuthKey
 * JD-Core Version:    0.7.0.1
 */