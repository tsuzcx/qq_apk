package com.tencent.luggage.wxa.hj;

import android.os.Debug;
import android.os.SystemClock;
import com.tencent.luggage.wxa.hs.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class l$d
  extends Thread
{
  List<l.c> a = new LinkedList();
  
  public void run()
  {
    int i = 0;
    while (i == 0)
    {
      try
      {
        Thread.sleep(10000L);
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("monitor interrupted, msg = ");
        ((StringBuilder)localObject2).append(localInterruptedException.getMessage());
        b.a("IPC.IPCThreadPool", ((StringBuilder)localObject2).toString(), new Object[0]);
        i = 1;
      }
      Object localObject4 = new ArrayList();
      Object localObject2 = new ArrayList();
      synchronized (l.b())
      {
        Object localObject5 = this.a.iterator();
        while (((Iterator)localObject5).hasNext())
        {
          l.c localc = (l.c)((Iterator)localObject5).next();
          if (localc.a()) {
            ((List)localObject4).add(localc);
          } else if ((SystemClock.elapsedRealtime() - localc.b.longValue() >= 10000L) && (!Debug.isDebuggerConnected())) {
            ((List)localObject2).add(localc);
          }
        }
        if (!((List)localObject2).isEmpty())
        {
          localObject4 = new StringBuilder();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (l.c)((Iterator)localObject2).next();
            ((StringBuilder)localObject4).append("|");
            ((StringBuilder)localObject4).append(((l.c)localObject5).c);
            ((StringBuilder)localObject4).append("|");
          }
          throw new l.b(String.format("[%s] blocking operation times out", new Object[] { ((StringBuilder)localObject4).toString() }));
        }
        this.a.removeAll((Collection)localObject4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.l.d
 * JD-Core Version:    0.7.0.1
 */