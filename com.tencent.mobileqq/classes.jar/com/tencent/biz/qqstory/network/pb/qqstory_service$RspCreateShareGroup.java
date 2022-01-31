package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspCreateShareGroup
  extends MessageMicro<RspCreateShareGroup>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "share_group_info" }, new Object[] { null, null }, RspCreateShareGroup.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public qqstory_struct.ShareGroupInfo share_group_info = new qqstory_struct.ShareGroupInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspCreateShareGroup
 * JD-Core Version:    0.7.0.1
 */