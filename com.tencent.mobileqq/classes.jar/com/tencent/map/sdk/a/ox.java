package com.tencent.map.sdk.a;

import java.util.HashMap;

public final class ox<T, K>
{
  private HashMap<T, K> a;
  private int b = 0;
  private int c = 1024;
  
  public final K a(T paramT)
  {
    try
    {
      HashMap localHashMap = this.a;
      if (localHashMap == null) {
        return null;
      }
      paramT = this.a.get(paramT);
      return paramT;
    }
    finally {}
  }
  
  public final void a(T paramT, K paramK)
  {
    try
    {
      if (this.a == null) {
        this.a = new HashMap();
      }
      this.a.put(paramT, paramK);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ox
 * JD-Core Version:    0.7.0.1
 */