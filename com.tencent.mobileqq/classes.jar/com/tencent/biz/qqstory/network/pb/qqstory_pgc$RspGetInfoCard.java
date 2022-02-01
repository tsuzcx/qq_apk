package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_pgc$RspGetInfoCard
  extends MessageMicro<RspGetInfoCard>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "user" }, new Object[] { null, null }, RspGetInfoCard.class);
  public qqstory_pgc.ErrorInfo result = new qqstory_pgc.ErrorInfo();
  public qqstory_pgc.UserInfo user = new qqstory_pgc.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_pgc.RspGetInfoCard
 * JD-Core Version:    0.7.0.1
 */