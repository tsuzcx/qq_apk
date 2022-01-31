package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ShortVideo$CheckAuthReq
  extends MessageMicro<CheckAuthReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ver" }, new Object[] { Integer.valueOf(0) }, CheckAuthReq.class);
  public final PBInt32Field ver = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ilive_feeds.ShortVideo.CheckAuthReq
 * JD-Core Version:    0.7.0.1
 */