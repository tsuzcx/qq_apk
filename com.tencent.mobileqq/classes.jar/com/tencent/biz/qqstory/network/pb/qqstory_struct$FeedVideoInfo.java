package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$FeedVideoInfo
  extends MessageMicro<FeedVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field time = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_extern_link_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.TagInfoBase video_tag = new qqstory_struct.TagInfoBase();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "video_cover", "vid", "time", "video_attr", "video_tag", "video_extern_link_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, null, localByteStringMicro4 }, FeedVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo
 * JD-Core Version:    0.7.0.1
 */