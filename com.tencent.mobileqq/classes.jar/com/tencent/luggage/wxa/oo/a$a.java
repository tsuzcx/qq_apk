package com.tencent.luggage.wxa.oo;

import com.tencent.luggage.wxa.qz.af;
import java.util.HashMap;
import java.util.HashSet;

final class a$a
{
  final HashMap<String, HashSet<String>> a = new HashMap();
  
  void a()
  {
    try
    {
      this.a.clear();
      return;
    }
    finally {}
  }
  
  void a(String paramString)
  {
    if (af.c(paramString)) {
      return;
    }
    try
    {
      this.a.remove(paramString);
      return;
    }
    finally {}
  }
  
  boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = af.c(paramString1);
    boolean bool2 = false;
    if (!bool1)
    {
      if (af.c(paramString2)) {
        return false;
      }
      try
      {
        paramString1 = (HashSet)this.a.get(paramString1);
        bool1 = bool2;
        if (paramString1 != null)
        {
          bool1 = bool2;
          if (paramString1.contains(paramString2)) {
            bool1 = true;
          }
        }
        return bool1;
      }
      finally {}
    }
    return false;
  }
  
  void b(String paramString1, String paramString2)
  {
    if (!af.c(paramString1))
    {
      if (af.c(paramString2)) {
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.a.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.a.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally {}
    }
  }
  
  void c(String paramString1, String paramString2)
  {
    if (!af.c(paramString1))
    {
      if (af.c(paramString2)) {
        return;
      }
      try
      {
        paramString1 = (HashSet)this.a.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.oo.a.a
 * JD-Core Version:    0.7.0.1
 */