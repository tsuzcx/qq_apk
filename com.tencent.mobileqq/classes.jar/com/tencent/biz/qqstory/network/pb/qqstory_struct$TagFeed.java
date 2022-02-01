package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$TagFeed
  extends MessageMicro<TagFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField blur = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBBytesField schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public qqstory_struct.TagItem tag_item = new qqstory_struct.TagItem();
  public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.TagVideoInfo> video_list = PBField.initRepeatMessage(qqstory_struct.TagVideoInfo.class);
  public final PBUInt32Field video_total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 98 }, new String[] { "tag_item", "video_list", "next_cookie", "is_end", "seq", "video_total", "date", "schema", "content", "blur", "recommend_id", "title_wording" }, new Object[] { null, null, localByteStringMicro1, localInteger, localInteger, localInteger, localInteger, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5 }, TagFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.TagFeed
 * JD-Core Version:    0.7.0.1
 */