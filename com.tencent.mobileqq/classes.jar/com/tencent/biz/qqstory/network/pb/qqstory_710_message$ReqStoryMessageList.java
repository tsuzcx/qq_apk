package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_710_message$ReqStoryMessageList
  extends MessageMicro<ReqStoryMessageList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field start_time = PBField.initUInt32(0);
  public final PBUInt32Field version_ctrl = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "start_time", "num", "source", "version_ctrl" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, ReqStoryMessageList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.ReqStoryMessageList
 * JD-Core Version:    0.7.0.1
 */