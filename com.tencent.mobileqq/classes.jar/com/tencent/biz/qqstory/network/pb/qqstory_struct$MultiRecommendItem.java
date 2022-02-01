package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqstory_struct$MultiRecommendItem
  extends MessageMicro<MultiRecommendItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.FeedVideoInfo> feed_video_info_list = PBField.initRepeatMessage(qqstory_struct.FeedVideoInfo.class);
  public final PBStringField rcmd_wording = PBField.initString("");
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "user", "feed_video_info_list", "rcmd_wording", "feed_id" }, new Object[] { null, null, "", localByteStringMicro }, MultiRecommendItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommendItem
 * JD-Core Version:    0.7.0.1
 */