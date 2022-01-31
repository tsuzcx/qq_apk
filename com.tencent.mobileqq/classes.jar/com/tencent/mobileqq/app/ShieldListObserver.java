package com.tencent.mobileqq.app;

import java.util.ArrayList;
import java.util.List;

public class ShieldListObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, List paramList) {}
  
  public void a(boolean paramBoolean, List paramList, int paramInt) {}
  
  public void b(boolean paramBoolean, List paramList) {}
  
  public void b(boolean paramBoolean, List paramList, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int j = 0;
    int i;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramObject instanceof long[])) {
        paramObject = (long[])paramObject;
      }
      Object[] arrayOfObject;
      for (i = 0;; i = ((Integer)arrayOfObject[1]).intValue())
      {
        int k = paramObject.length;
        while (j < k)
        {
          localArrayList.add(Long.valueOf(paramObject[j]));
          j += 1;
        }
        arrayOfObject = (Object[])paramObject;
        paramObject = (long[])arrayOfObject[0];
      }
      paramObject = localArrayList;
    }
    for (;;)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        a(paramBoolean);
        return;
      case 2: 
        a(paramBoolean, paramObject);
        a(paramBoolean, paramObject, i);
        return;
      case 3: 
        b(paramBoolean, paramObject);
        b(paramBoolean, paramObject, i);
        return;
      }
      a();
      return;
      paramObject = null;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldListObserver
 * JD-Core Version:    0.7.0.1
 */