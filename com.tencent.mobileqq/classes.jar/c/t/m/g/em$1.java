package c.t.m.g;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

final class em$1
  implements Runnable
{
  em$1(em paramem, Handler paramHandler) {}
  
  public final void run()
  {
    this.b.a.clear();
    em localem = this.b;
    Handler localHandler = this.a;
    Object localObject1 = null;
    LinkedBlockingQueue localLinkedBlockingQueue = localem.a;
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      if (localem.g)
      {
        localObject4 = localObject1;
        localObject5 = localObject1;
      }
      try
      {
        em.a locala = (em.a)localLinkedBlockingQueue.take();
        localObject4 = locala;
        localObject5 = locala;
        if (em.a.d == locala) {
          return;
        }
        localObject4 = locala;
        localObject5 = locala;
        if (TencentExtraKeys.COMPHTTPIO)
        {
          localObject4 = locala;
          localObject5 = locala;
          l1 = System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject1 = localem.b;
          localObject4 = locala;
          localObject5 = locala;
          Object localObject6 = em.a.b(locala);
          localObject4 = locala;
          localObject5 = locala;
          Object localObject7 = em.a.a(locala);
          localObject4 = locala;
          localObject5 = locala;
          System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject1 = ((dx)localObject1).j.a((String)localObject6, (byte[])localObject7);
          localObject4 = locala;
          localObject5 = locala;
          System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject6 = co.d((byte[])((Pair)localObject1).first);
          if (localObject6 != null)
          {
            localObject4 = locala;
            localObject5 = locala;
            new String((byte[])localObject6, (String)((Pair)localObject1).second);
          }
          localObject4 = locala;
          localObject5 = locala;
          l1 = System.currentTimeMillis() - l1;
          localObject4 = locala;
          localObject5 = locala;
          new StringBuilder("request:").append(locala.b);
          localObject4 = locala;
          localObject5 = locala;
          long l2 = System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject1 = localem.b;
          localObject4 = locala;
          localObject5 = locala;
          localObject6 = em.a.b(locala);
          localObject4 = locala;
          localObject5 = locala;
          localObject7 = em.a.a(locala);
          localObject4 = locala;
          localObject5 = locala;
          System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject1 = ((dx)localObject1).i.a((String)localObject6, (byte[])localObject7);
          localObject4 = locala;
          localObject5 = locala;
          System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject6 = co.d((byte[])((Pair)localObject1).first);
          label445:
          long l3;
          long l4;
          if (localObject6 != null)
          {
            localObject4 = locala;
            localObject5 = locala;
            localObject6 = new String((byte[])localObject6, (String)((Pair)localObject1).second);
            localObject4 = locala;
            localObject5 = locala;
            l3 = System.currentTimeMillis() - l2;
            localObject4 = locala;
            localObject5 = locala;
            new StringBuilder("cost:").append(l3).append(",request:").append((String)localObject6);
            localObject4 = locala;
            localObject5 = locala;
            localem.c += 1L;
            localObject4 = locala;
            localObject5 = locala;
            localem.d += em.a.a(locala).length;
            localObject4 = locala;
            localObject5 = locala;
            localObject1 = co.c(((String)localObject6).getBytes());
            localObject4 = locala;
            localObject5 = locala;
            l4 = localem.e;
            if (localObject1 == null) {
              break label907;
            }
            localObject4 = locala;
            localObject5 = locala;
          }
          label907:
          for (int i = localObject1.length;; i = 0)
          {
            localObject4 = locala;
            localObject5 = locala;
            localem.e = (l4 + i);
            localObject4 = locala;
            localObject5 = locala;
            if (TencentExtraKeys.COMPHTTPIO)
            {
              localObject4 = locala;
              localObject5 = locala;
              new StringBuilder("Halley:").append(l3).append("ms,HttpURLConnection:").append(l1).append("ms");
              localObject4 = locala;
              localObject5 = locala;
              new StringBuilder("Halley:").append(l3).append("ms,HttpURLConnection:").append(l1).append("ms");
            }
            localObject4 = locala;
            localObject5 = locala;
            localObject7 = localHandler.obtainMessage();
            localObject4 = locala;
            localObject5 = locala;
            ((Message)localObject7).arg1 = ((int)l3);
            localObject4 = locala;
            localObject5 = locala;
            ((Message)localObject7).arg2 = ((int)l1);
            localObject4 = locala;
            localObject5 = locala;
            locala.c = l2;
            localObject4 = locala;
            localObject5 = locala;
            if (1 == em.a.c(locala))
            {
              localObject4 = locala;
              localObject5 = locala;
              ((Message)localObject7).obj = Pair.create(localObject6, locala);
              localObject4 = locala;
              localObject5 = locala;
              ((Message)localObject7).what = 4999;
              localObject4 = locala;
              localObject5 = locala;
              ((Message)localObject7).sendToTarget();
            }
            localObject1 = locala;
            localObject4 = locala;
            localObject5 = locala;
            if (3 != em.a.c(locala)) {
              break;
            }
            localObject4 = locala;
            localObject5 = locala;
            ((Message)localObject7).obj = Pair.create(localObject6, locala);
            localObject4 = locala;
            localObject5 = locala;
            ((Message)localObject7).what = 4997;
            localObject4 = locala;
            localObject5 = locala;
            ((Message)localObject7).sendToTarget();
            localObject1 = locala;
            break;
            localObject6 = "{}";
            break label445;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localem.a(localObject4);
          if (1 == em.a.c(localObject4)) {
            localHandler.sendEmptyMessageDelayed(4998, 60000L);
          }
          Object localObject2 = localObject4;
          if (3 != em.a.c(localObject4)) {
            break;
          }
          localHandler.sendEmptyMessageDelayed(4996, 0L);
          localObject2 = localObject4;
          break;
          long l1 = 0L;
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        Object localObject3 = localObject5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.em.1
 * JD-Core Version:    0.7.0.1
 */