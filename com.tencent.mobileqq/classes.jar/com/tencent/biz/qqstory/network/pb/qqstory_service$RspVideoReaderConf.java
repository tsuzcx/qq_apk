package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspVideoReaderConf
  extends MessageMicro<RspVideoReaderConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "reader_conf" }, new Object[] { null, null }, RspVideoReaderConf.class);
  public qqstory_struct.VideoReaderConf reader_conf = new qqstory_struct.VideoReaderConf();
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspVideoReaderConf
 * JD-Core Version:    0.7.0.1
 */