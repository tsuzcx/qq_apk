package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class BubbleDiyComu$Bubble_GetDiyText_Req
  extends MessageMicro<Bubble_GetDiyText_Req>
{
  public static final int USER_TEXT_INFO_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_text_info" }, new Object[] { null }, Bubble_GetDiyText_Req.class);
  public final PBRepeatMessageField<BubbleDiyComu.UserTextInfo> user_text_info = PBField.initRepeatMessage(BubbleDiyComu.UserTextInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_GetDiyText_Req
 * JD-Core Version:    0.7.0.1
 */