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
    String str = "request:";
    this.b.a.clear();
    ep localep = this.b;
    Handler localHandler = this.a;
    LinkedBlockingQueue localLinkedBlockingQueue = localep.a;
    Object localObject1 = null;
    while (localep.g)
    {
      label163:
      label826:
      try
      {
        localObject3 = (ep.a)localLinkedBlockingQueue.take();
      }
      catch (Exception localException5)
      {
        Object localObject3;
        Object localObject5;
        long l3;
        long l4;
        label503:
        break label648;
      }
      try
      {
        if (ep.a.e == localObject3) {
          return;
        }
        if (!TencentExtraKeys.COMPHTTPIO) {
          break label850;
        }
        l1 = System.currentTimeMillis();
        localObject1 = localep.b;
        localObject4 = ep.a.c((ep.a)localObject3);
        localObject5 = ep.a.a((ep.a)localObject3);
        System.currentTimeMillis();
        localObject1 = ((ea)localObject1).j.a((String)localObject4, (byte[])localObject5);
        System.currentTimeMillis();
        localObject4 = co.d((byte[])((Pair)localObject1).first);
        if (localObject4 != null) {
          new String((byte[])localObject4, (String)((Pair)localObject1).second);
        }
        l1 = System.currentTimeMillis() - l1;
      }
      catch (Exception localException2)
      {
        break label645;
        l1 = 0L;
        break label163;
        localObject4 = "{}";
        break label271;
        i = 0;
        break label395;
        break label503;
      }
      new StringBuilder(str).append(((ep.a)localObject3).b);
      l3 = System.currentTimeMillis();
      localObject1 = localep.b;
      localObject4 = ep.a.c((ep.a)localObject3);
      localObject5 = ep.a.a((ep.a)localObject3);
      System.currentTimeMillis();
      localObject1 = ((ea)localObject1).i.a((String)localObject4, (byte[])localObject5);
      System.currentTimeMillis();
      localObject4 = co.d((byte[])((Pair)localObject1).first);
      if (localObject4 == null) {
        break label855;
      }
      localObject4 = new String((byte[])localObject4, (String)((Pair)localObject1).second);
      label271:
      l4 = System.currentTimeMillis() - l3;
      localObject1 = new StringBuilder(str);
      try
      {
        ((StringBuilder)localObject1).append(ep.a.c((ep.a)localObject3));
        localObject1 = new StringBuilder("cost:");
        ((StringBuilder)localObject1).append(l4);
        ((StringBuilder)localObject1).append(",request:");
        ((StringBuilder)localObject1).append((String)localObject4);
      }
      catch (Exception localException3)
      {
        long l2;
        label395:
        Object localObject2;
        label645:
        break label645;
      }
      try
      {
        localep.c += 1L;
        localep.d += ep.a.a((ep.a)localObject3).length;
        localObject1 = co.c(((String)localObject4).getBytes());
        l2 = localep.e;
        if (localObject1 == null) {
          break label862;
        }
        i = localObject1.length;
        localep.e = (l2 + i);
        if (!TencentExtraKeys.COMPHTTPIO) {
          break label867;
        }
        localObject1 = new StringBuilder("Halley:");
        ((StringBuilder)localObject1).append(l4);
        ((StringBuilder)localObject1).append("ms,HttpURLConnection:");
        l2 = l1;
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("ms");
        localObject1 = new StringBuilder("Halley:");
        ((StringBuilder)localObject1).append(l4);
        ((StringBuilder)localObject1).append("ms,HttpURLConnection:");
        ((StringBuilder)localObject1).append(l2);
        ((StringBuilder)localObject1).append("ms");
        localObject5 = localHandler.obtainMessage();
        ((Message)localObject5).arg1 = ((int)l4);
        ((Message)localObject5).arg2 = ((int)l1);
        ((ep.a)localObject3).c = l3;
        if (1 == ep.a.b((ep.a)localObject3))
        {
          ((Message)localObject5).obj = Pair.create(localObject4, localObject3);
          ((Message)localObject5).what = 4999;
          ((Message)localObject5).sendToTarget();
        }
        if (4 == ep.a.b((ep.a)localObject3))
        {
          ((Message)localObject5).obj = Pair.create(localObject4, localObject3);
          ((Message)localObject5).what = 4999;
          ((Message)localObject5).sendToTarget();
        }
        localObject1 = localObject3;
        if (3 != ep.a.b((ep.a)localObject3)) {
          break label826;
        }
        ((Message)localObject5).obj = Pair.create(localObject4, localObject3);
        ((Message)localObject5).what = 4997;
        ((Message)localObject5).sendToTarget();
        localObject1 = localObject3;
      }
      catch (Exception localException4)
      {
        break label652;
      }
      break label652;
      label648:
      localObject3 = localObject1;
      label652:
      localep.a((ep.a)localObject3);
      if (ep.a.b((ep.a)localObject3) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      try
      {
        if ((ep.a.b((ep.a)localObject3) == 1) && (localObject3 != null) && (ep.a.c((ep.a)localObject3) != null))
        {
          ep.a.d((ep.a)localObject3);
          ep.a.a((ep.a)localObject3, ep.a.c((ep.a)localObject3).replace("lbs.map.qq.com", "iplocreptest.map.qq.com"));
          new StringBuilder("postLocationIpv6Request ").append(((ep.a)localObject3).toString());
          if (ep.a.a((ep.a)localObject3) != null) {
            localep.a.offer(localObject3);
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      if ((i == 0) && (4 == ep.a.b((ep.a)localObject3))) {
        localHandler.sendEmptyMessageDelayed(4998, 60000L);
      }
      localObject2 = localObject3;
      if (3 == ep.a.b((ep.a)localObject3))
      {
        localHandler.sendEmptyMessageDelayed(4996, 0L);
        localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.ep.1
 * JD-Core Version:    0.7.0.1
 */