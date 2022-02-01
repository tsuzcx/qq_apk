package com.tencent.mobileqq.activity.aio.doodle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DoodleItem
{
  private ArrayList<PathData> a = new ArrayList();
  private DoodleParam b = new DoodleParam();
  private long c;
  
  public DoodleParam a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public void a(PathData paramPathData, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramPathData == null) {
      return;
    }
    if (paramBoolean1) {
      this.b.a(paramPathData);
    }
    this.a.add(paramPathData);
    if (paramBoolean2) {
      this.c += paramPathData.a();
    }
  }
  
  public void a(List<PathData> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramList != null)
    {
      long l1 = 0L;
      long l2;
      if (!paramBoolean1)
      {
        l2 = l1;
        if (!paramBoolean2) {}
      }
      else
      {
        Iterator localIterator = paramList.iterator();
        for (;;)
        {
          l2 = l1;
          if (!localIterator.hasNext()) {
            break;
          }
          PathData localPathData = (PathData)localIterator.next();
          if (paramBoolean1) {
            this.b.a(localPathData);
          }
          if (paramBoolean2) {
            l1 += localPathData.a();
          }
        }
      }
      this.a.addAll(paramList);
      if (paramBoolean2) {
        this.c += l2;
      }
    }
  }
  
  public long b()
  {
    return this.c;
  }
  
  public ArrayList<PathData> c()
  {
    return this.a;
  }
  
  public String d()
  {
    if (!this.a.isEmpty())
    {
      PathData localPathData = (PathData)this.a.get(0);
      if (localPathData != null)
      {
        if (localPathData.a > 0) {
          return String.valueOf(localPathData.b());
        }
        return String.valueOf(localPathData.c());
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleItem
 * JD-Core Version:    0.7.0.1
 */