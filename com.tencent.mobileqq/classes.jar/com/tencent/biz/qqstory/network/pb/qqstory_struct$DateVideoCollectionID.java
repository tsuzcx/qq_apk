package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$DateVideoCollectionID
  extends MessageMicro<DateVideoCollectionID>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field collection_id = PBField.initUInt32(0);
  public final PBUInt32Field collection_type = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "collection_id", "collection_type", "feed_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, DateVideoCollectionID.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollectionID
 * JD-Core Version:    0.7.0.1
 */