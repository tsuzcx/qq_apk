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
    if (paramQuestionClassInfo == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramQuestionClassInfo.jdField_a_of_type_Int;
    } while (paramQuestionClassInfo.jdField_a_of_type_JavaUtilArrayList == null);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramQuestionClassInfo.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public final void a(AvGameList.QuestionClassInfo paramQuestionClassInfo)
  {
    int j = 0;
    if (paramQuestionClassInfo == null) {
      return;
    }
    if (paramQuestionClassInfo.game_type.has()) {}
    for (int i = paramQuestionClassInfo.game_type.get();; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      paramQuestionClassInfo = paramQuestionClassInfo.question_class_list.get();
      if ((paramQuestionClassInfo == null) || (paramQuestionClassInfo.size() == 0)) {
        break;
      }
      i = j;
      while (i < paramQuestionClassInfo.size())
      {
        AvGameList.QuestionClassInfoItem localQuestionClassInfoItem = (AvGameList.QuestionClassInfoItem)paramQuestionClassInfo.get(i);
        QuestionClassInfoItem localQuestionClassInfoItem1 = new QuestionClassInfoItem();
        localQuestionClassInfoItem1.a(localQuestionClassInfoItem);
        this.jdField_a_of_type_JavaUtilArrayList.add(localQuestionClassInfoItem1);
        i += 1;
      }
      break;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typeSvr").append("=").append(this.jdField_a_of_type_Int).append("|");
    localStringBuilder.append("questionClassListSize").append("=").append(this.jdField_a_of_type_JavaUtilArrayList.size());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.QuestionClassInfo
 * JD-Core Version:    0.7.0.1
 */