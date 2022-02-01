package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ReqGroupVideo$RspScreenShareAnswer
  extends MessageMicro<RspScreenShareAnswer>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspScreenShareAnswer.class);
  public common.ErrorInfo result = new common.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.RspScreenShareAnswer
 * JD-Core Version:    0.7.0.1
 */