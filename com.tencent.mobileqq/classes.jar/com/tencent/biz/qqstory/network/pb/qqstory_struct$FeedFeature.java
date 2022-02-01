package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$FeedFeature
  extends MessageMicro<FeedFeature>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field deny_comment = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field has_like = PBField.initUInt32(0);
  public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
  public final PBUInt32Field total_like_num = PBField.initUInt32(0);
  public final PBUInt32Field total_viewing_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "feed_id", "total_comment_num", "total_like_num", "total_viewing_num", "has_like", "deny_comment" }, new Object[] { localByteStringMicro, localInteger, localInteger, localInteger, localInteger, localInteger }, FeedFeature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature
 * JD-Core Version:    0.7.0.1
 */