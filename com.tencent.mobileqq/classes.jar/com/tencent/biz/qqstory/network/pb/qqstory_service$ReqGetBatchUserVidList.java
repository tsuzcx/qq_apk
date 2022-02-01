package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

public final class qqstory_service$ReqGetBatchUserVidList
  extends MessageMicro<ReqGetBatchUserVidList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField pull_type = PBField.initEnum(1);
  public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "union_id_list", "pull_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1) }, ReqGetBatchUserVidList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetBatchUserVidList
 * JD-Core Version:    0.7.0.1
 */