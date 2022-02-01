package com.tencent.liteav;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.a.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.c;
import java.util.HashMap;

class e$1
  implements Runnable
{
  e$1(e parame, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = a.c().a(new b(this.a, true), null);
        int j = localObject1.length;
        boolean bool2 = false;
        i = 0;
        boolean bool1 = bool2;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if ((!((com.tencent.liteav.network.a.e)localObject2).a()) || (!e.c(((com.tencent.liteav.network.a.e)localObject2).a))) {
            break label171;
          }
          bool1 = true;
        }
        Object localObject2 = e.g();
        String str = this.a;
        if (bool1) {
          localObject1 = e.a.b;
        } else {
          localObject1 = e.a.c;
        }
        ((HashMap)localObject2).put(str, localObject1);
        localObject1 = e.h();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(" isTencent ");
        ((StringBuilder)localObject2).append(bool1);
        TXCLog.d((String)localObject1, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (Exception localException)
      {
        TXCLog.e(e.h(), "check dns failed.", localException);
        return;
      }
      label171:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.e.1
 * JD-Core Version:    0.7.0.1
 */