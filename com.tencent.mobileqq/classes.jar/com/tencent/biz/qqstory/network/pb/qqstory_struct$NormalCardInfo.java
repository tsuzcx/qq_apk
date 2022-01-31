package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_struct$NormalCardInfo
  extends MessageMicro<NormalCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "owner", "story_video_info" }, new Object[] { null, null }, NormalCardInfo.class);
  public qqstory_struct.UserInfo owner = new qqstory_struct.UserInfo();
  public final PBRepeatMessageField<qqstory_struct.CardVideoInfo> story_video_info = PBField.initRepeatMessage(qqstory_struct.CardVideoInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo
 * JD-Core Version:    0.7.0.1
 */