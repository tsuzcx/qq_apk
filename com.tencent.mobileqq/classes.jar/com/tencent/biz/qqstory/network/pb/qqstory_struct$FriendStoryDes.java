package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_struct$FriendStoryDes
  extends MessageMicro<FriendStoryDes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "des", "simple_info_list", "user_seq_info" }, new Object[] { null, null, null }, FriendStoryDes.class);
  public qqstory_struct.StoryDes des = new qqstory_struct.StoryDes();
  public final PBRepeatMessageField<qqstory_struct.StoryVideoSimpleInfo> simple_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoSimpleInfo.class);
  public qqstory_struct.UserSeqInfo user_seq_info = new qqstory_struct.UserSeqInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FriendStoryDes
 * JD-Core Version:    0.7.0.1
 */