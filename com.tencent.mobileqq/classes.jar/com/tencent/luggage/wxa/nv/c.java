package com.tencent.luggage.wxa.nv;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.ArrayList;
import java.util.List;

public final class c<T extends u>
{
  private final List<b> a = new ArrayList();
  
  public void a(@NonNull Context paramContext, @NonNull T paramT, String paramString1, String paramString2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < this.a.size())
    {
      b localb = (b)this.a.get(i);
      if (localb.a(paramContext, paramT, paramString1))
      {
        localArrayList1.add(localb.b(paramContext, paramT, paramString1));
        localArrayList2.add(localb);
      }
      i += 1;
    }
    boolean bool;
    if ((!paramT.v()) && (!paramT.m())) {
      bool = false;
    } else {
      bool = true;
    }
    d.a(paramContext, bool, localArrayList1, paramString2, paramT.y(), new c.1(this, localArrayList2, paramContext, paramT, paramString1));
  }
  
  public void a(b paramb)
  {
    this.a.add(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nv.c
 * JD-Core Version:    0.7.0.1
 */