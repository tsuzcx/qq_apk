package com.tencent.mobileqq.app;

import java.util.ArrayList;
import java.util.List;

public class ShieldListObserver
  implements BusinessObserver
{
  protected void a() {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, List<Long> paramList, int paramInt) {}
  
  protected void b(boolean paramBoolean, List<Long> paramList) {}
  
  protected void b(boolean paramBoolean, List<Long> paramList, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    int j = 0;
    if (paramObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        i = 0;
      }
      else
      {
        Object[] arrayOfObject = (Object[])paramObject;
        paramObject = (long[])arrayOfObject[0];
        i = ((Integer)arrayOfObject[1]).intValue();
      }
      int k = paramObject.length;
      while (j < k)
      {
        localArrayList.add(Long.valueOf(paramObject[j]));
        j += 1;
      }
      paramObject = localArrayList;
    }
    else
    {
      paramObject = null;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          a();
          return;
        }
        b(paramBoolean, paramObject);
        b(paramBoolean, paramObject, i);
        return;
      }
      a(paramBoolean, paramObject);
      a(paramBoolean, paramObject, i);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShieldListObserver
 * JD-Core Version:    0.7.0.1
 */