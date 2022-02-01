package com.tencent.luggage.wxa.py;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.k;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.LinkedList;

final class a$b
  implements k
{
  private final LinkedList<u> a = new LinkedList();
  
  public static b a(@NonNull d paramd)
  {
    b localb2 = (b)paramd.c(b.class);
    b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new b();
      paramd.a(localb1);
    }
    return localb1;
  }
  
  boolean a()
  {
    boolean bool = false;
    while (!this.a.isEmpty()) {
      bool |= ((u)this.a.poll()).X().a();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.py.a.b
 * JD-Core Version:    0.7.0.1
 */