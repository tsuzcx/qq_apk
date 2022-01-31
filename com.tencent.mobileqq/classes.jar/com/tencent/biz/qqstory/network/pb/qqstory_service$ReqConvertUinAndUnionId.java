package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqConvertUinAndUnionId
  extends MessageMicro<ReqConvertUinAndUnionId>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "convert_from", "user_id_list", "need_medal", "need_grade_speed" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqConvertUinAndUnionId.class);
  public final PBUInt32Field convert_from = PBField.initUInt32(0);
  public final PBUInt32Field need_grade_speed = PBField.initUInt32(0);
  public final PBUInt32Field need_medal = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.UserId> user_id_list = PBField.initRepeatMessage(qqstory_struct.UserId.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqConvertUinAndUnionId
 * JD-Core Version:    0.7.0.1
 */