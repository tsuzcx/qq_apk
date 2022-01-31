package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspSyncVideoPublish
  extends MessageMicro<RspSyncVideoPublish>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "publish_result" }, new Object[] { null, null }, RspSyncVideoPublish.class);
  public qqstory_service.RspPublishVideo publish_result = new qqstory_service.RspPublishVideo();
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspSyncVideoPublish
 * JD-Core Version:    0.7.0.1
 */