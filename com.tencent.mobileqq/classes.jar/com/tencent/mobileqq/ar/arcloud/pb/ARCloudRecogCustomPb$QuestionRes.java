package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARCloudRecogCustomPb$QuestionRes
  extends MessageMicro<QuestionRes>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin64_question_id", "str_question_content", "str_jump_url" }, new Object[] { Long.valueOf(0L), "", "" }, QuestionRes.class);
  public final PBStringField str_jump_url = PBField.initString("");
  public final PBStringField str_question_content = PBField.initString("");
  public final PBUInt64Field uin64_question_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.QuestionRes
 * JD-Core Version:    0.7.0.1
 */