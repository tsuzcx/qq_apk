package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$GroupVideoBasicInfo
  extends MessageMicro<GroupVideoBasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66 }, new String[] { "author", "msg_time", "file_id", "video_vid", "group_gid", "story_source", "duration", "video_attr" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, GroupVideoBasicInfo.class);
  public final PBUInt64Field author = PBField.initUInt64(0L);
  public final PBUInt32Field duration = PBField.initUInt32(0);
  public final PBStringField file_id = PBField.initString("");
  public final PBUInt64Field group_gid = PBField.initUInt64(0L);
  public final PBUInt32Field msg_time = PBField.initUInt32(0);
  public final PBUInt32Field story_source = PBField.initUInt32(0);
  public final PBStringField video_attr = PBField.initString("");
  public final PBStringField video_vid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupVideoBasicInfo
 * JD-Core Version:    0.7.0.1
 */