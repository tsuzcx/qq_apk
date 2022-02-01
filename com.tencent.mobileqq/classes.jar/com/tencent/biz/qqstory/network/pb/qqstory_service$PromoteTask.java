package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$PromoteTask
  extends MessageMicro<PromoteTask>
{
  public static final int HOME_FEED = 2;
  public static final int MSG_NODE = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_promote_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_limit_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_minimal_video_count = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_taskid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56 }, new String[] { "uint64_taskid", "uint32_promote_type", "bytes_union_id", "bytes_feed_id", "uint64_limit_count", "uint64_minimal_video_count", "uint64_expire_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PromoteTask.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.PromoteTask
 * JD-Core Version:    0.7.0.1
 */