package c.t.m.g;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

final class eq$1
  implements Runnable
{
  eq$1(eq parameq, Handler paramHandler) {}
  
  public final void run()
  {
    this.b.a.clear();
    eq localeq = this.b;
    Handler localHandler = this.a;
    Object localObject1 = null;
    LinkedBlockingQueue localLinkedBlockingQueue = localeq.a;
    for (;;)
    {
      Object localObject4;
      Object localObject5;
      if (localeq.g)
      {
        localObject4 = localObject1;
        localObject5 = localObject1;
      }
      try
      {
        eq.a locala = (eq.a)localLinkedBlockingQueue.take();
        localObject4 = locala;
        localObject5 = locala;
        if (eq.a.d == locala) {
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
          localObject1 = localeq.b;
          localObject4 = locala;
          localObject5 = locala;
          Object localObject6 = eq.a.b(locala);
          localObject4 = locala;
          localObject5 = locala;
          Object localObject7 = eq.a.a(locala);
          localObject4 = locala;
          localObject5 = locala;
          System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject1 = ((ea)localObject1).j.a((String)localObject6, (byte[])localObject7);
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
          localObject1 = localeq.b;
          localObject4 = locala;
          localObject5 = locala;
          localObject6 = eq.a.b(locala);
          localObject4 = locala;
          localObject5 = locala;
          localObject7 = eq.a.a(locala);
          localObject4 = locala;
          localObject5 = locala;
          System.currentTimeMillis();
          localObject4 = locala;
          localObject5 = locala;
          localObject1 = ((ea)localObject1).i.a((String)localObject6, (byte[])localObject7);
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
            localeq.c += 1L;
            localObject4 = locala;
            localObject5 = locala;
            localeq.d += eq.a.a(locala).length;
            localObject4 = locala;
            localObject5 = locala;
            localObject1 = co.c(((String)localObject6).getBytes());
            localObject4 = locala;
            localObject5 = locala;
            l4 = localeq.e;
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
            localeq.e = (l4 + i);
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
            if (1 == eq.a.c(locala))
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
            if (3 != eq.a.c(locala)) {
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
          localeq.a(localObject4);
          if (1 == eq.a.c(localObject4)) {
            localHandler.sendEmptyMessageDelayed(4998, 60000L);
          }
          Object localObject2 = localObject4;
          if (3 != eq.a.c(localObject4)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.eq.1
 * JD-Core Version:    0.7.0.1
 */