package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShortVideo$DeleteReq
  extends MessageMicro<DeleteReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field file_type = PBField.initUInt32(0);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBInt32Field ver = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "ver", "seq", "file_type", "file_id" }, new Object[] { localInteger, localInteger, localInteger, localByteStringMicro }, DeleteReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive_feeds.ShortVideo.DeleteReq
 * JD-Core Version:    0.7.0.1
 */