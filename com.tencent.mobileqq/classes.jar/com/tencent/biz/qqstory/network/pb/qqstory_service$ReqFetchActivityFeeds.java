package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqFetchActivityFeeds
  extends MessageMicro<ReqFetchActivityFeeds>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field feed_video_num = PBField.initUInt32(0);
  public final PBUInt64Field feeds_seq = PBField.initUInt64(0L);
  public final PBUInt32Field fetch_time = PBField.initUInt32(0);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "start_cookie", "num", "fetch_time", "feed_video_num", "feeds_seq" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqFetchActivityFeeds.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqFetchActivityFeeds
 * JD-Core Version:    0.7.0.1
 */