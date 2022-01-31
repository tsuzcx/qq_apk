package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$RspDateVideoCollectionList
  extends MessageMicro<RspDateVideoCollectionList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_struct.DateVideoCollection> collection_list = PBField.initRepeatMessage(qqstory_struct.DateVideoCollection.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBInt32Field is_friend = PBField.initInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt64Field seqno = PBField.initUInt64(0L);
  public final PBUInt32Field total_video_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56 }, new String[] { "result", "collection_list", "is_end", "next_cookie", "total_video_count", "seqno", "is_friend" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspDateVideoCollectionList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspDateVideoCollectionList
 * JD-Core Version:    0.7.0.1
 */