package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SerializationPB$GeneralRecommendFeed
  extends MessageMicro<GeneralRecommendFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField blurb = PBField.initString("");
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public SerializationPB.VideoListFeed video_list_feed = new SerializationPB.VideoListFeed();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "video_list_feed", "blurb", "recommend_id", "title_wording" }, new Object[] { null, "", Long.valueOf(0L), localByteStringMicro }, GeneralRecommendFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.GeneralRecommendFeed
 * JD-Core Version:    0.7.0.1
 */