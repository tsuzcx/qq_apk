package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_group$GroupStoryItem
  extends MessageMicro<GroupStoryItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ts = PBField.initUInt32(0);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public qqstory_group.GroupStoryVideoNodeInfo video_info = new qqstory_group.GroupStoryVideoNodeInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "type", "ts", "count", "video_info", "feed_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro }, GroupStoryItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.GroupStoryItem
 * JD-Core Version:    0.7.0.1
 */