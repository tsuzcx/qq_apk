package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SerializationPB$ShareGroupFeed
  extends MessageMicro<ShareGroupFeed>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "video_list_feed", "member_count", "video_count", "des", "group_id", "today_join_member_count" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, ShareGroupFeed.class);
  public final PBStringField des = PBField.initString("");
  public final PBStringField group_id = PBField.initString("");
  public final PBUInt32Field member_count = PBField.initUInt32(0);
  public final PBUInt32Field today_join_member_count = PBField.initUInt32(0);
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  public SerializationPB.VideoListFeed video_list_feed = new SerializationPB.VideoListFeed();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.ShareGroupFeed
 * JD-Core Version:    0.7.0.1
 */