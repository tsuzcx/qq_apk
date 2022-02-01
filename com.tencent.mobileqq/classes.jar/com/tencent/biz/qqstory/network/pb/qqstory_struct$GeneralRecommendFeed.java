package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$GeneralRecommendFeed
  extends MessageMicro<GeneralRecommendFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField blurb = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.GeneralFeed recommend_feed = new qqstory_struct.GeneralFeed();
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "recommend_feed", "blurb", "recommend_id", "title_wording" }, new Object[] { null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, GeneralRecommendFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralRecommendFeed
 * JD-Core Version:    0.7.0.1
 */