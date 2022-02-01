package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_struct$FeedFollowDav_N
  extends MessageMicro<FeedFollowDav_N>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from_uid", "to_uid_list" }, new Object[] { null, null }, FeedFollowDav_N.class);
  public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
  public final PBRepeatMessageField<qqstory_struct.UserInfo> to_uid_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFollowDav_N
 * JD-Core Version:    0.7.0.1
 */