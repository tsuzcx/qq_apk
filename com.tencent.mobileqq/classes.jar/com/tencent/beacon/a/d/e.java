package com.tencent.beacon.a.d;

import com.tencent.beacon.a.b.d;
import java.nio.MappedByteBuffer;
import org.json.JSONObject;

class e
  implements Runnable
{
  e(g paramg) {}
  
  public void run()
  {
    try
    {
      synchronized (g.a(this.a))
      {
        Object localObject2 = g.b(this.a).toString();
        localObject2 = ((String)localObject2).getBytes("ISO8859-1");
        g localg = this.a;
        localObject2 = g.a((byte[])localObject2);
        if (localObject2 == null) {
          return;
        }
        if (localObject2.length + 10 > g.c(this.a))
        {
          g.a(this.a, localObject2.length + 10);
          g.b(this.a, g.c(this.a));
        }
        g.d(this.a).putInt(0, localObject2.length);
        g.d(this.a).position(10);
        g.d(this.a).put((byte[])localObject2);
        g.d(this.a).force();
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      d.b().a("504", "[properties] write to file error!", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.d.e
 * JD-Core Version:    0.7.0.1
 */