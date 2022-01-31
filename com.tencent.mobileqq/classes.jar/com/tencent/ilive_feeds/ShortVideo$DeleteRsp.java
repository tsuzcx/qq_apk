package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShortVideo$DeleteRsp
  extends MessageMicro<DeleteRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "seq", "retcode" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DeleteRsp.class);
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ilive_feeds.ShortVideo.DeleteRsp
 * JD-Core Version:    0.7.0.1
 */