package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqDateCollectionList
  extends MessageMicro<ReqDateCollectionList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field collection_count = PBField.initUInt32(0);
  public final PBUInt32Field collection_video_count = PBField.initUInt32(0);
  public final PBInt32Field is_friend = PBField.initInt32(0);
  public final PBUInt64Field seqno = PBField.initUInt64(0L);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field time_zone = PBField.initInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56 }, new String[] { "start_cookie", "collection_count", "collection_video_count", "seqno", "time_zone", "union_id", "is_friend" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ReqDateCollectionList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDateCollectionList
 * JD-Core Version:    0.7.0.1
 */