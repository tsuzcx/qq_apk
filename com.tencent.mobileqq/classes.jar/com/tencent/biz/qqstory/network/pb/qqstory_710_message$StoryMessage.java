package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryMessage
  extends MessageMicro<StoryMessage>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_710_message.StoryFriendAgreeInfo agree_info = new qqstory_710_message.StoryFriendAgreeInfo();
  public qqstory_710_message.StoryAnswerInfo answer_info = new qqstory_710_message.StoryAnswerInfo();
  public qqstory_710_message.StoryChallengeInfo chall_info = new qqstory_710_message.StoryChallengeInfo();
  public qqstory_710_message.StoryCommentInfo comment_info = new qqstory_710_message.StoryCommentInfo();
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_710_message.StoryGradeInfo grade_info = new qqstory_710_message.StoryGradeInfo();
  public qqstory_710_message.StoryLikeInfo like_info = new qqstory_710_message.StoryLikeInfo();
  public qqstory_710_message.StoryMedalInfo medal_info = new qqstory_710_message.StoryMedalInfo();
  public final PBUInt32Field message_id = PBField.initUInt32(0);
  public qqstory_710_message.StoryOfficialInfo official_info = new qqstory_710_message.StoryOfficialInfo();
  public qqstory_710_message.StoryPhotoTogetherInfo photo_info = new qqstory_710_message.StoryPhotoTogetherInfo();
  public qqstory_710_message.StoryPublishInfo publish_info = new qqstory_710_message.StoryPublishInfo();
  public qqstory_710_message.ShareGroupInfo share_info = new qqstory_710_message.ShareGroupInfo();
  public final PBUInt32Field src_type = PBField.initUInt32(0);
  public final PBUInt64Field src_uid = PBField.initUInt64(0L);
  public qqstory_710_message.StoryVideoInfo video_info = new qqstory_710_message.StoryVideoInfo();
  public qqstory_710_message.StoryVoteInfo vote_info = new qqstory_710_message.StoryVoteInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 74, 82, 90, 98, 106, 114, 122, 130, 138 }, new String[] { "like_info", "comment_info", "publish_info", "video_info", "feed_id", "message_id", "src_type", "src_uid", "official_info", "share_info", "medal_info", "vote_info", "grade_info", "answer_info", "agree_info", "chall_info", "photo_info" }, new Object[] { null, null, null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null }, StoryMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryMessage
 * JD-Core Version:    0.7.0.1
 */