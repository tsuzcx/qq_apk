package com.tencent.mobileqq.activity.recent;

import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class ConversationHelper$LogBuilder
{
  private StringBuilder a = new StringBuilder();
  private final String b;
  
  private ConversationHelper$LogBuilder(String paramString)
  {
    this.b = paramString;
  }
  
  private void a()
  {
    if ((this.a != null) && (QLog.isDevelopLevel()))
    {
      this.a.append("]");
      QLog.i(this.b, 4, this.a.toString());
    }
  }
  
  private void a(List<RecentUser> paramList)
  {
    if (QLog.isDevelopLevel())
    {
      Object localObject = this.a;
      if (localObject == null) {
        this.a = new StringBuilder();
      } else {
        ((StringBuilder)localObject).setLength(0);
      }
      this.a.append("checkRUList, src[");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (RecentUser)paramList.next();
        if (localObject == null)
        {
          this.a.append("null | null,");
        }
        else
        {
          StringBuilder localStringBuilder = this.a;
          localStringBuilder.append(((RecentUser)localObject).uin);
          localStringBuilder.append("|");
          localStringBuilder.append(((RecentUser)localObject).getType());
          localStringBuilder.append(",");
        }
      }
      this.a.append("], [");
    }
  }
  
  private void a(String... paramVarArgs)
  {
    if ((this.a != null) && (QLog.isDevelopLevel()) && (paramVarArgs != null))
    {
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        String str = paramVarArgs[i];
        this.a.append(str);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.ConversationHelper.LogBuilder
 * JD-Core Version:    0.7.0.1
 */