package com.tencent.map.sdk.a;

import java.util.ArrayList;

public abstract class nm
  implements Cloneable
{
  ArrayList<Object> a = null;
  
  public nm a()
  {
    try
    {
      localObject = (nm)super.clone();
      if (this.a != null)
      {
        ArrayList localArrayList = this.a;
        ((nm)localObject).a = new ArrayList();
        int j = localArrayList.size();
        int i = 0;
        while (i < j)
        {
          ((nm)localObject).a.add(localArrayList.get(i));
          i += 1;
        }
      }
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      Object localObject;
      label68:
      break label68;
    }
    localObject = new AssertionError();
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.nm
 * JD-Core Version:    0.7.0.1
 */