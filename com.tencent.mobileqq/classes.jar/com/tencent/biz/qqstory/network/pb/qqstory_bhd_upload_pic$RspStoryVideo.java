package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_bhd_upload_pic$RspStoryVideo
  extends MessageMicro<RspStoryVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cdn_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field retcode = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "retcode", "msg", "cdn_url", "file_key", "file_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspStoryVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic.RspStoryVideo
 * JD-Core Version:    0.7.0.1
 */