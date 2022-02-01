package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryFriendAgreeInfo
  extends MessageMicro<StoryFriendAgreeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "friend_uin", "agree_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, StoryFriendAgreeInfo.class);
  public final PBUInt32Field agree_time = PBField.initUInt32(0);
  public final PBUInt64Field friend_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryFriendAgreeInfo
 * JD-Core Version:    0.7.0.1
 */