package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$VidPollInfo
  extends MessageMicro<VidPollInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field self_poll_result = PBField.initInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> video_poll_result = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatMessageField<qqstory_struct.UserInfo> video_poll_users = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "vid", "self_poll_result", "video_poll_result", "video_poll_users" }, new Object[] { localByteStringMicro, localInteger, localInteger, null }, VidPollInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.VidPollInfo
 * JD-Core Version:    0.7.0.1
 */