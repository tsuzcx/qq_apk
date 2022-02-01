package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$VideoInfoItem
  extends MessageMicro<VideoInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.Address address = new qqstory_struct.Address();
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field del_flag = PBField.initUInt32(0);
  public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBUInt32Field error = PBField.initUInt32(0);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field publish_time = PBField.initUInt32(0);
  public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field url_flag = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_source = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 66, 74, 80, 90, 98, 104, 114, 120, 128 }, new String[] { "error", "story_id", "vid", "uin", "union_id", "publish_time", "duration", "cover_url", "download_url", "url_flag", "video_attr", "address", "group_id", "doodle_url", "del_flag", "video_source" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, null, Long.valueOf(0L), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0) }, VideoInfoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.VideoInfoItem
 * JD-Core Version:    0.7.0.1
 */