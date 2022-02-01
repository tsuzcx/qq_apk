package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetUnWatchStoryNoExpireList
  extends MessageMicro<ReqGetUnWatchStoryNoExpireList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "uin_list", "ret_user_info" }, new Object[] { null, Integer.valueOf(0) }, ReqGetUnWatchStoryNoExpireList.class);
  public final PBUInt32Field ret_user_info = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.UserSeqInfo> uin_list = PBField.initRepeatMessage(qqstory_struct.UserSeqInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUnWatchStoryNoExpireList
 * JD-Core Version:    0.7.0.1
 */