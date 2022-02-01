package com.tencent.luggage.wxa.jo;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private static a a;
  private boolean b = false;
  private Map<String, c> c = new HashMap();
  private List<a.a> d = new ArrayList();
  
  public static a a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new a();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(a.a parama)
  {
    if (this.b) {
      return;
    }
    if (!this.d.contains(parama)) {
      this.d.add(parama);
    }
  }
  
  public void a(String paramString, c paramc)
  {
    if (this.b) {
      return;
    }
    boolean bool = this.c.containsKey(paramString);
    int j = 0;
    int i;
    if (bool)
    {
      localObject = (c)this.c.get(paramString);
      if ((localObject != null) && (((c)localObject).equals(paramc)))
      {
        paramc = new StringBuilder();
        paramc.append("has device uuid=");
        paramc.append(paramString);
        Log.d("DeviceManager", paramc.toString());
        return;
      }
      i = 0;
    }
    else
    {
      i = 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("new device uuid=");
    ((StringBuilder)localObject).append(paramString);
    Log.d("DeviceManager", ((StringBuilder)localObject).toString());
    this.c.put(paramString, paramc);
    while (j < this.d.size())
    {
      paramString = (a.a)this.d.get(j);
      if (paramString != null)
      {
        if (i != 0) {
          paramString.a(paramc);
        } else {
          paramString.c(paramc);
        }
        j += 1;
      }
      else
      {
        this.d.remove(j);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    return this.c.containsKey(paramString);
  }
  
  public Collection<c> b()
  {
    return this.c.values();
  }
  
  public void b(a.a parama)
  {
    this.d.remove(parama);
  }
  
  public void b(String paramString)
  {
    if (this.b) {
      return;
    }
    paramString = (c)this.c.remove(paramString);
    int i = 0;
    while (i < this.d.size())
    {
      a.a locala = (a.a)this.d.get(i);
      if (locala != null)
      {
        locala.b(paramString);
        i += 1;
      }
      else
      {
        this.d.remove(i);
      }
    }
  }
  
  public c c(String paramString)
  {
    return (c)this.c.get(paramString);
  }
  
  public void c()
  {
    this.b = true;
  }
  
  public void d()
  {
    this.c.clear();
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jo.a
 * JD-Core Version:    0.7.0.1
 */