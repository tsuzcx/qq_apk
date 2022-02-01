package com.tencent.avgame.gameroom.festivalstage.questionoption;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QuestionOptionsDataSource
{
  private List<QuestionOptionInfo> a = new CopyOnWriteArrayList();
  
  private String a()
  {
    switch (this.a.size())
    {
    default: 
      return "";
    case 0: 
      return "A.";
    case 1: 
      return "B.";
    case 2: 
      return "C.";
    }
    return "D.";
  }
  
  public int a(String paramString)
  {
    this.a.add(new QuestionOptionInfo(this.a.size(), paramString));
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
        int i = a(a() + str);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsDataSource
 * JD-Core Version:    0.7.0.1
 */