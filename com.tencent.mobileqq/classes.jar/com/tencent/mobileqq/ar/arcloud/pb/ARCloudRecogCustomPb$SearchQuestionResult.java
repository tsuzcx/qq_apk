package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ARCloudRecogCustomPb$SearchQuestionResult
  extends MessageMicro<SearchQuestionResult>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> cdb_res = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public ARCloudRecogCustomPb.QuestionRes question_res = new ARCloudRecogCustomPb.QuestionRes();
  public final PBInt32Field search_question_errorcode = PBField.initInt32(0);
  public final PBStringField search_question_errormsg = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "search_question_errorcode", "search_question_errormsg", "cdb_res", "question_res" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, null }, SearchQuestionResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.SearchQuestionResult
 * JD-Core Version:    0.7.0.1
 */