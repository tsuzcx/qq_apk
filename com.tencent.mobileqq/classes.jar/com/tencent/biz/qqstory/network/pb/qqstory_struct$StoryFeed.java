package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$StoryFeed
  extends MessageMicro<StoryFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field additional_feed = PBField.initUInt32(0);
  public qqstory_struct.BannerFeed banner_feed = new qqstory_struct.BannerFeed();
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field feed_source_tag_type = PBField.initUInt32(0);
  public qqstory_struct.GeneralFeed general_feed = new qqstory_struct.GeneralFeed();
  public qqstory_struct.GeneralRecommendFeed general_recommend_feed = new qqstory_struct.GeneralRecommendFeed();
  public qqstory_struct.MultiRecommend multi_recommend_feed = new qqstory_struct.MultiRecommend();
  public qqstory_struct.ShareGroupFeed share_group_feed = new qqstory_struct.ShareGroupFeed();
  public qqstory_struct.ShareGroupRecommendFeed share_group_recommend_feed = new qqstory_struct.ShareGroupRecommendFeed();
  public qqstory_struct.TagFeed tag_feed = new qqstory_struct.TagFeed();
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88 }, new String[] { "type", "feed_id", "general_feed", "share_group_feed", "general_recommend_feed", "share_group_recommend_feed", "banner_feed", "tag_feed", "multi_recommend_feed", "additional_feed", "feed_source_tag_type" }, new Object[] { localInteger, localByteStringMicro, null, null, null, null, null, null, null, localInteger, localInteger }, StoryFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed
 * JD-Core Version:    0.7.0.1
 */