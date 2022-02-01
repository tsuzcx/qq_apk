package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.QuestionFeedbackInfo;

public class AVRes
{
  public int a;
  public String a;
  public String b = "";
  public String c = "";
  
  public AVRes()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  protected void a(AVRes paramAVRes)
  {
    this.jdField_a_of_type_JavaLangString = paramAVRes.jdField_a_of_type_JavaLangString;
    this.b = paramAVRes.b;
    this.jdField_a_of_type_Int = paramAVRes.jdField_a_of_type_Int;
    this.c = paramAVRes.c;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.c = paramString3;
  }
  
  public void a(AvGameCommon.QuestionFeedbackInfo paramQuestionFeedbackInfo)
  {
    if (paramQuestionFeedbackInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramQuestionFeedbackInfo.content.get();
    this.jdField_a_of_type_Int = paramQuestionFeedbackInfo.duration.get();
    this.b = paramQuestionFeedbackInfo.content_md5.get();
    this.c = "";
  }
  
  public String b()
  {
    return this.b;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append(this.jdField_a_of_type_JavaLangString).append(",").append(this.b).append(",").append(this.jdField_a_of_type_Int).append("s").append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.AVRes
 * JD-Core Version:    0.7.0.1
 */