package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ConversationHelper$LogBuilder
{
  private final String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  
  private ConversationHelper$LogBuilder(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()))
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("]");
      QLog.i(this.jdField_a_of_type_JavaLangString, 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
  }
  
  private void a(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      if (this.jdField_a_of_type_JavaLangStringBuilder == null)
      {
        this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
        this.jdField_a_of_type_JavaLangStringBuilder.append("checkRUList, src[");
        paramList = paramList.iterator();
      }
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label120;
        }
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if (localRecentUser == null)
        {
          this.jdField_a_of_type_JavaLangStringBuilder.append("null | null,");
          continue;
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          break;
        }
        this.jdField_a_of_type_JavaLangStringBuilder.append(localRecentUser.uin).append("|").append(localRecentUser.getType()).append(",");
      }
      label120:
      this.jdField_a_of_type_JavaLangStringBuilder.append("], [");
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if ((this.jdField_a_of_type_JavaLangStringBuilder != null) && (QLog.isDevelopLevel()) && (paramVarArgs != null))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.jdField_a_of_type_JavaLangStringBuilder.append(str);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationHelper.LogBuilder
 * JD-Core Version:    0.7.0.1
 */