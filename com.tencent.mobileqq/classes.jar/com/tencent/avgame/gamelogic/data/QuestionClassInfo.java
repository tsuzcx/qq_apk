package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfo;
import trpc.qq_vgame.game_list.AvGameList.QuestionClassInfoItem;

public class QuestionClassInfo
{
  public int a;
  public ArrayList<QuestionClassInfoItem> a;
  
  public QuestionClassInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public QuestionClassInfo a()
  {
    QuestionClassInfo localQuestionClassInfo = new QuestionClassInfo();
    localQuestionClassInfo.a(this);
    return localQuestionClassInfo;
  }
  
  public void a(QuestionClassInfo paramQuestionClassInfo)
  {
    if (paramQuestionClassInfo == null) {
      return;
    }
    this.jdField_a_of_type_Int = paramQuestionClassInfo.jdField_a_of_type_Int;
    paramQuestionClassInfo = paramQuestionClassInfo.jdField_a_of_type_JavaUtilArrayList;
    if (paramQuestionClassInfo != null) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQuestionClassInfo);
    }
  }
  
  public final void a(AvGameList.QuestionClassInfo paramQuestionClassInfo)
  {
    if (paramQuestionClassInfo == null) {
      return;
    }
    boolean bool = paramQuestionClassInfo.game_type.has();
    int j = 0;
    int i;
    if (bool) {
      i = paramQuestionClassInfo.game_type.get();
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    paramQuestionClassInfo = paramQuestionClassInfo.question_class_list.get();
    if (paramQuestionClassInfo != null)
    {
      i = j;
      if (paramQuestionClassInfo.size() == 0) {
        return;
      }
      while (i < paramQuestionClassInfo.size())
      {
        AvGameList.QuestionClassInfoItem localQuestionClassInfoItem = (AvGameList.QuestionClassInfoItem)paramQuestionClassInfo.get(i);
        QuestionClassInfoItem localQuestionClassInfoItem1 = new QuestionClassInfoItem();
        localQuestionClassInfoItem1.a(localQuestionClassInfoItem);
        this.jdField_a_of_type_JavaUtilArrayList.add(localQuestionClassInfoItem1);
        i += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeSvr");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("|");
    localStringBuilder.append("questionClassListSize");
    localStringBuilder.append("=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.QuestionClassInfo
 * JD-Core Version:    0.7.0.1
 */