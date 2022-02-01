package c.t.m.g;

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.concurrent.LinkedBlockingQueue;

final class ep$1
  implements Runnable
{
  ep$1(ep paramep, Handler paramHandler) {}
  
  public final void run()
  {
    this.b.a.clear();
    ep localep = this.b;
    Handler localHandler = this.a;
    Object localObject1 = null;
    LinkedBlockingQueue localLinkedBlockingQueue = localep.a;
    for (;;)
    {
      if (localep.g)
      {
        Object localObject3 = localObject1;
        try
        {
          ep.a locala = (ep.a)localLinkedBlockingQueue.take();
          localObject3 = locala;
          if (ep.a.e == locala) {
            return;
          }
          localObject3 = locala;
          if (TencentExtraKeys.COMPHTTPIO)
          {
            localObject3 = locala;
            l1 = System.currentTimeMillis();
            localObject3 = locala;
            localObject1 = localep.b;
            localObject3 = locala;
            localObject4 = ep.a.c(locala);
            localObject3 = locala;
            Object localObject5 = ep.a.a(locala);
            localObject3 = locala;
            System.currentTimeMillis();
            localObject3 = locala;
            localObject1 = ((ea)localObject1).j.a((String)localObject4, (byte[])localObject5);
            localObject3 = locala;
            System.currentTimeMillis();
            localObject3 = locala;
            localObject4 = co.d((byte[])((Pair)localObject1).first);
            if (localObject4 != null)
            {
              localObject3 = locala;
              new String((byte[])localObject4, (String)((Pair)localObject1).second);
            }
            localObject3 = locala;
            l1 = System.currentTimeMillis() - l1;
            localObject3 = locala;
            new StringBuilder("request:").append(locala.b);
            localObject3 = locala;
            long l2 = System.currentTimeMillis();
            localObject3 = locala;
            localObject1 = localep.b;
            localObject3 = locala;
            localObject4 = ep.a.c(locala);
            localObject3 = locala;
            localObject5 = ep.a.a(locala);
            localObject3 = locala;
            System.currentTimeMillis();
            localObject3 = locala;
            localObject1 = ((ea)localObject1).i.a((String)localObject4, (byte[])localObject5);
            localObject3 = locala;
            System.currentTimeMillis();
            localObject3 = locala;
            localObject4 = co.d((byte[])((Pair)localObject1).first);
            if (localObject4 != null)
            {
              localObject3 = locala;
              localObject4 = new String((byte[])localObject4, (String)((Pair)localObject1).second);
              label353:
              localObject3 = locala;
              long l3 = System.currentTimeMillis() - l2;
              localObject3 = locala;
              new StringBuilder("request:").append(ep.a.c(locala));
              localObject3 = locala;
              new StringBuilder("cost:").append(l3).append(",request:").append((String)localObject4);
              localObject3 = locala;
              localep.c += 1L;
              localObject3 = locala;
              localep.d += ep.a.a(locala).length;
              localObject3 = locala;
              localObject1 = co.c(((String)localObject4).getBytes());
              localObject3 = locala;
              long l4 = localep.e;
              if (localObject1 == null) {
                break label883;
              }
              localObject3 = locala;
              i = localObject1.length;
              label492:
              localObject3 = locala;
              localep.e = (l4 + i);
              localObject3 = locala;
              if (TencentExtraKeys.COMPHTTPIO)
              {
                localObject3 = locala;
                new StringBuilder("Halley:").append(l3).append("ms,HttpURLConnection:").append(l1).append("ms");
                localObject3 = locala;
                new StringBuilder("Halley:").append(l3).append("ms,HttpURLConnection:").append(l1).append("ms");
              }
              localObject3 = locala;
              localObject5 = localHandler.obtainMessage();
              localObject3 = locala;
              ((Message)localObject5).arg1 = ((int)l3);
              localObject3 = locala;
              ((Message)localObject5).arg2 = ((int)l1);
              localObject3 = locala;
              locala.c = l2;
              localObject3 = locala;
              if (1 == ep.a.b(locala))
              {
                localObject3 = locala;
                ((Message)localObject5).obj = Pair.create(localObject4, locala);
                localObject3 = locala;
                ((Message)localObject5).what = 4999;
                localObject3 = locala;
                ((Message)localObject5).sendToTarget();
              }
              localObject3 = locala;
              if (4 == ep.a.b(locala))
              {
                localObject3 = locala;
                ((Message)localObject5).obj = Pair.create(localObject4, locala);
                localObject3 = locala;
                ((Message)localObject5).what = 4999;
                localObject3 = locala;
                ((Message)localObject5).sendToTarget();
              }
              localObject1 = locala;
              localObject3 = locala;
              if (3 != ep.a.b(locala)) {
                continue;
              }
              localObject3 = locala;
              ((Message)localObject5).obj = Pair.create(localObject4, locala);
              localObject3 = locala;
              ((Message)localObject5).what = 4997;
              localObject3 = locala;
              ((Message)localObject5).sendToTarget();
              localObject1 = locala;
            }
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Object localObject4;
            localep.a(localObject3);
            int i = 0;
            if (ep.a.b(localObject3) == 1) {
              i = 1;
            }
            for (;;)
            {
              try
              {
                int j = ep.a.b(localObject3);
                if (j == 1) {
                  continue;
                }
              }
              catch (Exception localException2)
              {
                Object localObject2;
                label883:
                localException2.printStackTrace();
                continue;
              }
              if ((i == 0) && (4 == ep.a.b(localObject3))) {
                localHandler.sendEmptyMessageDelayed(4998, 60000L);
              }
              localObject2 = localObject3;
              if (3 != ep.a.b(localObject3)) {
                break;
              }
              localHandler.sendEmptyMessageDelayed(4996, 0L);
              localObject2 = localObject3;
              break;
              localObject4 = "{}";
              break label353;
              i = 0;
              break label492;
              if ((localObject3 != null) && (ep.a.c(localObject3) != null))
              {
                ep.a.d(localObject3);
                ep.a.a(localObject3, ep.a.c(localObject3).replace("lbs.map.qq.com", "iplocreptest.map.qq.com"));
                new StringBuilder("postLocationIpv6Request ").append(localObject3.toString());
                if (ep.a.a(localObject3) != null) {
                  localep.a.offer(localObject3);
                }
              }
            }
            long l1 = 0L;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.ep.1
 * JD-Core Version:    0.7.0.1
 */