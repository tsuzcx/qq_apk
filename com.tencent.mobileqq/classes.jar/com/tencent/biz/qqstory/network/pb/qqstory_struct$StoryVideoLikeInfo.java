package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$StoryVideoLikeInfo
  extends MessageMicro<StoryVideoLikeInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uid", "like_time", "role", "union_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, StoryVideoLikeInfo.class);
  public final PBUInt64Field like_time = PBField.initUInt64(0L);
  public final PBUInt32Field role = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBStringField union_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo
 * JD-Core Version:    0.7.0.1
 */