package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_group$RspGroupVideoForward
  extends MessageMicro<RspGroupVideoForward>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "story_id" }, new Object[] { null, localByteStringMicro }, RspGroupVideoForward.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGroupVideoForward
 * JD-Core Version:    0.7.0.1
 */