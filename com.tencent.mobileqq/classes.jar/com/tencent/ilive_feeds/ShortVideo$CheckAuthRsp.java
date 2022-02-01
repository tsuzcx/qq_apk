package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ShortVideo$CheckAuthRsp
  extends MessageMicro<CheckAuthRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, CheckAuthRsp.class);
  public final PBStringField err_msg = PBField.initString("");
  public final PBInt32Field retcode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive_feeds.ShortVideo.CheckAuthRsp
 * JD-Core Version:    0.7.0.1
 */