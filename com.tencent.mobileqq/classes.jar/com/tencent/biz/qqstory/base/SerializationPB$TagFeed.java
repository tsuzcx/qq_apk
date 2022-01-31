package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SerializationPB$TagFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField blur = PBField.initString("");
  public final PBStringField content = PBField.initString("");
  public final PBUInt32Field join_count = PBField.initUInt32(0);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBStringField schema = PBField.initString("");
  public final PBStringField tag_desc = PBField.initString("");
  public final PBUInt64Field tag_id = PBField.initUInt64(0L);
  public final PBStringField tag_name = PBField.initString("");
  public final PBUInt32Field tag_type = PBField.initUInt32(0);
  public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  public SerializationPB.VideoListFeed video_list_feed = new SerializationPB.VideoListFeed();
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56, 66, 74, 82, 90, 96, 106 }, new String[] { "video_list_feed", "video_count", "tag_id", "tag_name", "tag_desc", "tag_type", "join_count", "wording", "schema", "content", "blur", "recommend_id", "title_wording" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), localByteStringMicro }, TagFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.TagFeed
 * JD-Core Version:    0.7.0.1
 */