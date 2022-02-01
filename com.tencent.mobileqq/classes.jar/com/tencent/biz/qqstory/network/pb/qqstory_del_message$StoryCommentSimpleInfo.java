package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_del_message$StoryCommentSimpleInfo
  extends MessageMicro<StoryCommentSimpleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "comment_id", "reply_uid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, StoryCommentSimpleInfo.class);
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_del_message.StoryCommentSimpleInfo
 * JD-Core Version:    0.7.0.1
 */