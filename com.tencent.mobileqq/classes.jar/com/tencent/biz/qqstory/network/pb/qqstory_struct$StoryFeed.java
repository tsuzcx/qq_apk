package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$StoryFeed
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.BannerFeed banner_feed = new qqstory_struct.BannerFeed();
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.GeneralFeed general_feed = new qqstory_struct.GeneralFeed();
  public qqstory_struct.GeneralRecommendFeed general_recommend_feed = new qqstory_struct.GeneralRecommendFeed();
  public qqstory_struct.ShareGroupFeed share_group_feed = new qqstory_struct.ShareGroupFeed();
  public qqstory_struct.ShareGroupRecommendFeed share_group_recommend_feed = new qqstory_struct.ShareGroupRecommendFeed();
  public qqstory_struct.TagFeed tag_feed = new qqstory_struct.TagFeed();
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "type", "feed_id", "general_feed", "share_group_feed", "general_recommend_feed", "share_group_recommend_feed", "banner_feed", "tag_feed" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null, null }, StoryFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed
 * JD-Core Version:    0.7.0.1
 */