package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$ActivityFeedNode
  extends MessageMicro<ActivityFeedNode>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "feed_type", "feed_time", "feed_add_friend", "feed_like", "feed_comment", "feed_vote", "feed_grade", "feed_follow_dav", "feed_new_friend", "feed_qa", "feed_add_frd_n", "feed_follow_dav_n", "feed_frd_add_frd" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null }, ActivityFeedNode.class);
  public qqstory_struct.FeedAddFrd_N feed_add_frd_n = new qqstory_struct.FeedAddFrd_N();
  public qqstory_struct.FeedAddFriend feed_add_friend = new qqstory_struct.FeedAddFriend();
  public qqstory_struct.FeedComment feed_comment = new qqstory_struct.FeedComment();
  public qqstory_struct.FeedFollowDav feed_follow_dav = new qqstory_struct.FeedFollowDav();
  public qqstory_struct.FeedFollowDav_N feed_follow_dav_n = new qqstory_struct.FeedFollowDav_N();
  public qqstory_struct.FeedFrdAddFrd feed_frd_add_frd = new qqstory_struct.FeedFrdAddFrd();
  public qqstory_struct.FeedGrade feed_grade = new qqstory_struct.FeedGrade();
  public qqstory_struct.FeedLike feed_like = new qqstory_struct.FeedLike();
  public qqstory_struct.FeedNewFriend feed_new_friend = new qqstory_struct.FeedNewFriend();
  public qqstory_struct.FeedQA feed_qa = new qqstory_struct.FeedQA();
  public final PBUInt32Field feed_time = PBField.initUInt32(0);
  public final PBEnumField feed_type = PBField.initEnum(1);
  public qqstory_struct.FeedVote feed_vote = new qqstory_struct.FeedVote();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.ActivityFeedNode
 * JD-Core Version:    0.7.0.1
 */