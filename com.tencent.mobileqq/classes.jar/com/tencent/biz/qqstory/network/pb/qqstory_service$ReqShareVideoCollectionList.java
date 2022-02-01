package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqShareVideoCollectionList
  extends MessageMicro<ReqShareVideoCollectionList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field collection_count = PBField.initUInt32(0);
  public final PBUInt32Field collection_video_count = PBField.initUInt32(0);
  public final PBUInt64Field seqno = PBField.initUInt64(0L);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "start_cookie", "collection_count", "collection_video_count", "seqno", "union_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, ReqShareVideoCollectionList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqShareVideoCollectionList
 * JD-Core Version:    0.7.0.1
 */