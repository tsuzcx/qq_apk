package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$UnWatchStoryDes
  extends MessageMicro<UnWatchStoryDes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "des", "latest_video_list", "user_seq_info", "unwatch_count" }, new Object[] { null, null, null, Integer.valueOf(0) }, UnWatchStoryDes.class);
  public qqstory_struct.StoryDes des = new qqstory_struct.StoryDes();
  public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> latest_video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
  public final PBUInt32Field unwatch_count = PBField.initUInt32(0);
  public qqstory_struct.UserSeqInfo user_seq_info = new qqstory_struct.UserSeqInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.UnWatchStoryDes
 * JD-Core Version:    0.7.0.1
 */