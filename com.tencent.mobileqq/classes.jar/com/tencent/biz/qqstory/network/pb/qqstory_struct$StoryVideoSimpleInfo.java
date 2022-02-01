package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$StoryVideoSimpleInfo
  extends MessageMicro<StoryVideoSimpleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ban_type = PBField.initUInt32(0);
  public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 34, 40, 50, 58 }, new String[] { "video_cover", "vid", "group_list", "ban_type", "union_id", "video_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, StoryVideoSimpleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoSimpleInfo
 * JD-Core Version:    0.7.0.1
 */