package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqStoryPlayerTagInfo
  extends MessageMicro<ReqStoryPlayerTagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client = PBField.initUInt32(0);
  public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "vid_list", "client", "version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqStoryPlayerTagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryPlayerTagInfo
 * JD-Core Version:    0.7.0.1
 */