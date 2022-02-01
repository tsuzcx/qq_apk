package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfoItem;

public class QuestionClassInfoItem
{
  public String a;
  public String b;
  public String c;
  
  public QuestionClassInfoItem a()
  {
    QuestionClassInfoItem localQuestionClassInfoItem = new QuestionClassInfoItem();
    localQuestionClassInfoItem.a(this);
    return localQuestionClassInfoItem;
  }
  
  public void a(QuestionClassInfoItem paramQuestionClassInfoItem)
  {
    if (paramQuestionClassInfoItem == null) {
      return;
    }
    this.a = paramQuestionClassInfoItem.a;
    this.b = paramQuestionClassInfoItem.b;
    this.c = paramQuestionClassInfoItem.c;
  }
  
  public final void a(AvGameList.QuestionClassInfoItem paramQuestionClassInfoItem)
  {
    if (paramQuestionClassInfoItem == null) {
      return;
    }
    boolean bool = paramQuestionClassInfoItem.question_class.has();
    String str2 = "";
    if (bool) {
      str1 = paramQuestionClassInfoItem.question_class.get();
    } else {
      str1 = "";
    }
    this.a = str1;
    if (paramQuestionClassInfoItem.question_class_name_url.has()) {
      str1 = paramQuestionClassInfoItem.question_class_name_url.get();
    } else {
      str1 = "";
    }
    this.b = str1;
    String str1 = str2;
    if (paramQuestionClassInfoItem.question_class_bg_url.has()) {
      str1 = paramQuestionClassInfoItem.question_class_bg_url.get();
    }
    this.c = str1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name");
    localStringBuilder.append("=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("|");
    localStringBuilder.append("nameImageUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.b);
    localStringBuilder.append("|");
    localStringBuilder.append("backgroundImageUrl");
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.QuestionClassInfoItem
 * JD-Core Version:    0.7.0.1
 */