package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$CompInfoBase
  extends MessageMicro<CompInfoBase>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField backgroud_url = PBField.initString("");
  public final PBStringField compared_vid = PBField.initString("");
  public final PBStringField icon_url = PBField.initString("");
  public final PBUInt32Field is_compared_able = PBField.initUInt32(0);
  public final PBUInt32Field oa_task_id = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50 }, new String[] { "title", "backgroud_url", "compared_vid", "is_compared_able", "oa_task_id", "icon_url" }, new Object[] { "", "", "", localInteger, localInteger, "" }, CompInfoBase.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.CompInfoBase
 * JD-Core Version:    0.7.0.1
 */