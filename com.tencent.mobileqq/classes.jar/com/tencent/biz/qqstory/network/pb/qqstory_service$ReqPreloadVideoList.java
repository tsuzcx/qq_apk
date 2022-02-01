package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqPreloadVideoList
  extends MessageMicro<ReqPreloadVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField pull_type = PBField.initEnum(1);
  public final PBRepeatField<Long> topic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "pull_type", "union_id_list", "topic_id_list" }, new Object[] { Integer.valueOf(1), localByteStringMicro, Long.valueOf(0L) }, ReqPreloadVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqPreloadVideoList
 * JD-Core Version:    0.7.0.1
 */