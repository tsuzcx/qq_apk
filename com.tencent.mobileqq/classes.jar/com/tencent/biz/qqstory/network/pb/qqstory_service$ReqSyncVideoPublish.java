package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqSyncVideoPublish
  extends MessageMicro<ReqSyncVideoPublish>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_service.ReqPublishVideo publish_struct = new qqstory_service.ReqPublishVideo();
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBStringField str_fileid = PBField.initString("");
  public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66 }, new String[] { "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "bytes_file_md5", "uint32_business_type", "source", "publish_struct" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, ReqSyncVideoPublish.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSyncVideoPublish
 * JD-Core Version:    0.7.0.1
 */