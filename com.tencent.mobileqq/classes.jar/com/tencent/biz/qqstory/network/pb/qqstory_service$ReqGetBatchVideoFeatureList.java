package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class qqstory_service$ReqGetBatchVideoFeatureList
  extends MessageMicro<ReqGetBatchVideoFeatureList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "union_id", "vid_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqGetBatchVideoFeatureList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchVideoFeatureList
 * JD-Core Version:    0.7.0.1
 */