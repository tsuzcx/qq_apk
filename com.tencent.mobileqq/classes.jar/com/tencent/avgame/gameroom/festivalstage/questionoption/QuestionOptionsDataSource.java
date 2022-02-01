package com.tencent.avgame.gameroom.festivalstage.questionoption;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestionOptionsDataSource
{
  private List<QuestionOptionInfo> a = new CopyOnWriteArrayList();
  
  private String b()
  {
    int i = this.a.size();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return "";
          }
          return "D.";
        }
        return "C.";
      }
      return "B.";
    }
    return "A.";
  }
  
  public int a(String paramString)
  {
    List localList = this.a;
    localList.add(new QuestionOptionInfo(localList.size(), paramString));
    return this.a.size() - 1;
  }
  
  public QuestionOptionInfo a(int paramInt)
  {
    if (paramInt >= this.a.size()) {
      return null;
    }
    return (QuestionOptionInfo)this.a.get(paramInt);
  }
  
  public List<Integer> a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b());
        localStringBuilder.append(str);
        int i = a(localStringBuilder.toString());
        if (i >= 0) {
          localArrayList.add(Integer.valueOf(i));
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsDataSource
 * JD-Core Version:    0.7.0.1
 */