package com.tencent.mobileqq.apollo.barrage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbsDrawer<T>
{
  protected final List<Barrage> a = new ArrayList();
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.a.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = this.a.isEmpty();
      return bool ^ true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(Barrage paramBarrage)
  {
    try
    {
      boolean bool = this.a.remove(paramBarrage);
      return bool;
    }
    finally
    {
      paramBarrage = finally;
      throw paramBarrage;
    }
  }
  
  public abstract boolean a(T paramT, float paramFloat);
  
  public boolean a(List<Barrage> paramList)
  {
    if (paramList != null) {
      try
      {
        if (!paramList.isEmpty())
        {
          boolean bool = this.a.addAll(paramList);
          return bool;
        }
      }
      finally
      {
        paramList = finally;
        throw paramList;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.AbsDrawer
 * JD-Core Version:    0.7.0.1
 */