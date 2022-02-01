package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_bhd_upload_pic$RspStoryPic
  extends MessageMicro<RspStoryPic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field h = PBField.initUInt32(0);
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field w = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "retcode", "url", "w", "h", "msg" }, new Object[] { localInteger, localByteStringMicro1, localInteger, localInteger, localByteStringMicro2 }, RspStoryPic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryPic
 * JD-Core Version:    0.7.0.1
 */