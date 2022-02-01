package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$ClearMessageResult
  extends MessageMicro<ClearMessageResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field image_uid = PBField.initUInt64(0L);
  public final PBUInt32Field last_time = PBField.initUInt32(0);
  public final PBUInt32Field remain_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "remain_num", "image_uid", "last_time" }, new Object[] { localInteger, Long.valueOf(0L), localInteger }, ClearMessageResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.ClearMessageResult
 * JD-Core Version:    0.7.0.1
 */