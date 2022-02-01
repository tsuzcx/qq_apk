package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$ReqGroupVideoPublish
  extends MessageMicro<ReqGroupVideoPublish>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field business_type = PBField.initUInt32(0);
  public final PBUInt32Field chat_type = PBField.initUInt32(0);
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBStringField file_id = PBField.initString("");
  public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
  public final PBUInt32Field msg_time = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field sync_flag = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 64, 72, 80 }, new String[] { "chat_type", "client_type", "file_id", "group_id", "file_md5", "business_type", "source", "msg_seq", "sync_flag", "msg_time" }, new Object[] { localInteger, localInteger, "", localLong, localByteStringMicro, localInteger, localInteger, localLong, localInteger, localInteger }, ReqGroupVideoPublish.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGroupVideoPublish
 * JD-Core Version:    0.7.0.1
 */