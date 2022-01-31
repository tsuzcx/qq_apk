package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspMsgTabNodeVideoList
  extends MessageMicro<RspMsgTabNodeVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "video_list", "is_end", "cookie" }, new Object[] { null, null, Integer.valueOf(0), "" }, RspMsgTabNodeVideoList.class);
  public final PBStringField cookie = PBField.initString("");
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBRepeatMessageField<qqstory_service.MsgTabNodeVidInfo> video_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeVidInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspMsgTabNodeVideoList
 * JD-Core Version:    0.7.0.1
 */