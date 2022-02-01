package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqUploadStoryVideo
  extends MessageMicro<ReqUploadStoryVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "sha", "size" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, ReqUploadStoryVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqUploadStoryVideo
 * JD-Core Version:    0.7.0.1
 */