package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_struct$FeedFrdAddFrd
  extends MessageMicro<FeedFrdAddFrd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from_uid", "to_uid" }, new Object[] { null, null }, FeedFrdAddFrd.class);
  public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
  public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFrdAddFrd
 * JD-Core Version:    0.7.0.1
 */