package com.tencent.liteav.screencapture;

import com.tencent.liteav.basic.util.j.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class c$2
  implements j.a
{
  c$2(c paramc) {}
  
  public void onTimeout()
  {
    Object localObject = this.a;
    boolean bool = c.a((c)localObject, c.b((c)localObject));
    if (c.c(this.a) == bool) {
      return;
    }
    c.b(this.a, bool);
    localObject = c.a(this.a).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      c.a locala = (c.a)((Iterator)localObject).next();
      if (locala.d != null) {
        locala.d.a(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.c.2
 * JD-Core Version:    0.7.0.1
 */