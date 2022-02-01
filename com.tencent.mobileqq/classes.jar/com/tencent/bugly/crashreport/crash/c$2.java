package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class c$2
  extends Thread
{
  c$2(c paramc) {}
  
  public final void run()
  {
    if (!z.a(c.b(this.a), "local_crash_lock", 10000L)) {
      return;
    }
    Object localObject = this.a.p.a();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int j = ((List)localObject).size();
      int i = 0;
      x.c("Size of crash list: %s", new Object[] { Integer.valueOf(j) });
      j = ((List)localObject).size();
      if (j > 20L)
      {
        ArrayList localArrayList = new ArrayList();
        Collections.sort((List)localObject);
        while (i < 20L)
        {
          localArrayList.add(((List)localObject).get(j - 1 - i));
          i += 1;
        }
        localObject = localArrayList;
      }
      this.a.p.a((List)localObject, 0L, false, false, false);
    }
    z.b(c.b(this.a), "local_crash_lock");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.c.2
 * JD-Core Version:    0.7.0.1
 */