package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspMyStoryNode
  extends MessageMicro<RspMyStoryNode>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field has_more_feed = PBField.initUInt32(0);
  public final PBBytesField has_more_feed_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.StoryDayNode> list = PBField.initRepeatMessage(qqstory_struct.StoryDayNode.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "list", "has_more_feed", "has_more_feed_cover" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspMyStoryNode.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspMyStoryNode
 * JD-Core Version:    0.7.0.1
 */