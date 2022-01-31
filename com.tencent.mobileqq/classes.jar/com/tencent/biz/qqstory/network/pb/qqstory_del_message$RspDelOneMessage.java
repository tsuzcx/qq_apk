package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_del_message$RspDelOneMessage
  extends MessageMicro<RspDelOneMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "errinfo" }, new Object[] { null }, RspDelOneMessage.class);
  public qqstory_del_message.ErrorInfo errinfo = new qqstory_del_message.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_del_message.RspDelOneMessage
 * JD-Core Version:    0.7.0.1
 */