package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$PreloadVideoInfo
  extends MessageMicro<PreloadVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "id", "video_list", "union_id" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro }, PreloadVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.PreloadVideoInfo
 * JD-Core Version:    0.7.0.1
 */