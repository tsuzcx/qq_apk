package com.tencent.avgame.gamelogic.data;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.QuestionFeedbackInfo;

public class AVRes
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public String d = "";
  
  public String a()
  {
    return this.a;
  }
  
  protected void a(AVRes paramAVRes)
  {
    this.a = paramAVRes.a;
    this.b = paramAVRes.b;
    this.c = paramAVRes.c;
    this.d = paramAVRes.d;
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramInt;
    this.d = paramString3;
  }
  
  public void a(AvGameCommon.QuestionFeedbackInfo paramQuestionFeedbackInfo)
  {
    if (paramQuestionFeedbackInfo == null) {
      return;
    }
    this.a = paramQuestionFeedbackInfo.content.get();
    this.c = paramQuestionFeedbackInfo.duration.get();
    this.b = paramQuestionFeedbackInfo.content_md5.get();
    this.d = "";
  }
  
  public String b()
  {
    return this.b;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c);
    localStringBuilder.append("s");
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.AVRes
 * JD-Core Version:    0.7.0.1
 */