package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$VidQAInfo
  extends MessageMicro<VidQAInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField self_qa_result = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field total_qa_count = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.UserInfo> video_qa_users = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "vid", "self_qa_result", "video_qa_users", "total_qa_count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, VidQAInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.VidQAInfo
 * JD-Core Version:    0.7.0.1
 */