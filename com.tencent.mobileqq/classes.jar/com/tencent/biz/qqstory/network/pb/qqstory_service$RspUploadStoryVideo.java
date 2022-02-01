package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspUploadStoryVideo
  extends MessageMicro<RspUploadStoryVideo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField check_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field exists = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBBytesField server_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field server_port = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "result", "server_ip", "server_port", "exists", "check_key", "vid" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, RspUploadStoryVideo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspUploadStoryVideo
 * JD-Core Version:    0.7.0.1
 */