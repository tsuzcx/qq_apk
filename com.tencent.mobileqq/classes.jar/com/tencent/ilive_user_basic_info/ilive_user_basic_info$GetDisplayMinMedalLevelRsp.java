package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ilive_user_basic_info$GetDisplayMinMedalLevelRsp
  extends MessageMicro<GetDisplayMinMedalLevelRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field medal_id = PBField.initUInt32(0);
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "medal_id", "result" }, new Object[] { localInteger, localInteger }, GetDisplayMinMedalLevelRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.GetDisplayMinMedalLevelRsp
 * JD-Core Version:    0.7.0.1
 */