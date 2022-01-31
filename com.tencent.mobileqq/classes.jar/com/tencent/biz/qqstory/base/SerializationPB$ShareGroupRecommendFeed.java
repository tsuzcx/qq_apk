package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SerializationPB$ShareGroupRecommendFeed
  extends MessageMicro<ShareGroupRecommendFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField blurb = PBField.initString("");
  public final PBBytesField join_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public SerializationPB.ShareGroupFeed share_group_feed = new SerializationPB.ShareGroupFeed();
  public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "share_group_feed", "blurb", "join_feed_id", "recommend_id", "title_wording" }, new Object[] { null, "", localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, ShareGroupRecommendFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.ShareGroupRecommendFeed
 * JD-Core Version:    0.7.0.1
 */