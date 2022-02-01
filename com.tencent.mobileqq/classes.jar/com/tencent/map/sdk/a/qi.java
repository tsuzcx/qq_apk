package com.tencent.map.sdk.a;

import java.util.ArrayList;
import java.util.List;

public final class qi
{
  private List<String> a = new ArrayList();
  private List<String> b = new ArrayList();
  private final int c = 300;
  
  private static void a(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    if (paramList.size() <= 300) {
      return;
    }
    paramList.remove(0);
  }
  
  public final boolean a(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.trim().length() != 0)
        {
          boolean bool = this.b.contains(paramString);
          return !bool;
        }
      }
      finally {}
    }
    return false;
  }
  
  public final void b(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.trim().length() != 0)
        {
          if (this.b.contains(paramString))
          {
            this.b.remove(paramString);
            this.b.add(paramString);
            return;
          }
          if (this.a.contains(paramString))
          {
            a(this.b);
            this.b.add(paramString);
            this.a.remove(paramString);
            return;
          }
          a(this.a);
          this.a.add(paramString);
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.qi
 * JD-Core Version:    0.7.0.1
 */