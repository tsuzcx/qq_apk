package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetLikeList
  extends MessageMicro<RspGetLikeList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "result", "like_list", "like_total_count" }, new Object[] { null, null, Integer.valueOf(0) }, RspGetLikeList.class);
  public final PBRepeatMessageField<qqstory_struct.StoryVideoLikeInfo> like_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoLikeInfo.class);
  public final PBUInt32Field like_total_count = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetLikeList
 * JD-Core Version:    0.7.0.1
 */