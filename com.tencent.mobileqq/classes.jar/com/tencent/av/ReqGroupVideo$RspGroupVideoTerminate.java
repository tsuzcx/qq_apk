package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class ReqGroupVideo$RspGroupVideoTerminate
  extends MessageMicro<RspGroupVideoTerminate>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspGroupVideoTerminate.class);
  public common.ErrorInfo result = new common.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.RspGroupVideoTerminate
 * JD-Core Version:    0.7.0.1
 */