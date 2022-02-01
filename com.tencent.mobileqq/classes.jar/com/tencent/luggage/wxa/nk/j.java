package com.tencent.luggage.wxa.nk;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j
{
  private final f a;
  private List<j> b;
  private final String c;
  
  public j(f paramf, String paramString)
  {
    this.a = paramf;
    this.c = paramString;
  }
  
  public static j a(List<f> paramList)
  {
    j localj1 = new j(new j.a(), "");
    localj1.a(new j((f)paramList.get(0), ""));
    HashMap localHashMap = new HashMap();
    int i = 1;
    while (i < paramList.size() - 1)
    {
      Object localObject = (f)paramList.get(i);
      int j = ((f)localObject).h();
      if (j <= 0)
      {
        j = ((f)localObject).g();
        localObject = new j((f)localObject, "");
        localj1.a((j)localObject);
        localHashMap.put(Integer.valueOf(j), localObject);
      }
      else
      {
        j localj2 = (j)localHashMap.get(Integer.valueOf(j));
        if (localj2 == null)
        {
          o.b("StepNode", "buildStepTree unexpected branch: myGroup not found yet");
          return null;
        }
        localj2 = localj2.a((f)localObject);
        if (b((f)localObject)) {
          localHashMap.put(Integer.valueOf(((f)localObject).g()), localj2);
        }
      }
      i += 1;
    }
    localj1.a(new j((f)paramList.get(paramList.size() - 1), ""));
    return localj1;
  }
  
  public static void a(j paramj, j.b paramb)
  {
    if (paramj == null) {
      return;
    }
    if (paramb == null) {
      return;
    }
    paramb.a(paramj);
    paramj = paramj.b;
    if (paramj != null)
    {
      if (paramj.isEmpty()) {
        return;
      }
      int i = 0;
      while (i < paramj.size())
      {
        a((j)paramj.get(i), paramb);
        i += 1;
      }
    }
  }
  
  private static boolean b(f paramf)
  {
    return (paramf.f() == 3) || (paramf.f() == 2);
  }
  
  public f a()
  {
    return this.a;
  }
  
  public j a(f paramf)
  {
    if (!b(this.a))
    {
      o.b("StepNode", "addChild but not a node group");
      return null;
    }
    if (this.b == null) {
      this.b = new ArrayList();
    }
    String str;
    if (this.a.f() == 3) {
      str = "-";
    } else {
      str = ".";
    }
    if (!af.c(this.c)) {
      str = String.format("%s%s%d", new Object[] { this.c, str, Integer.valueOf(this.b.size() + 1) });
    } else {
      str = String.format("%d", new Object[] { Integer.valueOf(this.b.size() + 1) });
    }
    paramf = new j(paramf, str);
    this.b.add(paramf);
    return paramf;
  }
  
  public void a(j paramj)
  {
    if (!b(this.a))
    {
      o.b("StepNode", "addChild but not a node group");
      return;
    }
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramj);
  }
  
  @Nullable
  public b b()
  {
    f localf = this.a;
    if ((localf instanceof b)) {
      return (b)localf;
    }
    return null;
  }
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nk.j
 * JD-Core Version:    0.7.0.1
 */