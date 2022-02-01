package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$ReqGetStoryDes
  extends MessageMicro<ReqGetStoryDes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "req_info_list" }, new Object[] { null }, ReqGetStoryDes.class);
  public final PBRepeatMessageField<qqstory_struct.StoryReqInfo> req_info_list = PBField.initRepeatMessage(qqstory_struct.StoryReqInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetStoryDes
 * JD-Core Version:    0.7.0.1
 */