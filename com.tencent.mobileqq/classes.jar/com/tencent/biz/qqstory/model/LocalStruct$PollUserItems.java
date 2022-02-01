package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class LocalStruct$PollUserItems
  extends MessageMicro<PollUserItems>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "users" }, new Object[] { null }, PollUserItems.class);
  public final PBRepeatMessageField<qqstory_struct.UserInfo> users = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.LocalStruct.PollUserItems
 * JD-Core Version:    0.7.0.1
 */