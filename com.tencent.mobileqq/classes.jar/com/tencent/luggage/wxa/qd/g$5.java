package com.tencent.luggage.wxa.qd;

import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.gt.c;
import com.tencent.luggage.wxa.if.b;
import com.tencent.luggage.wxa.qz.o;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;

class g$5
  implements MessageQueue.IdleHandler
{
  g$5(g paramg, String paramString) {}
  
  public boolean queueIdle()
  {
    ??? = (b)g.f(this.b).get(this.a);
    int j = 1;
    if (??? == null)
    {
      o.d("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null, audioId:%s", new Object[] { this.a });
      synchronized (g.g(this.b))
      {
        g.g(this.b).remove(this.a);
        g.c(this.b, this.a);
        return false;
      }
    }
    if ((!TextUtils.isEmpty(((b)???).c)) && (!g.h(this.b).t(((b)???).c)))
    {
      long l1 = com.tencent.luggage.wxa.gw.a.d(((b)???).c);
      if (g.a(this.b, (b)???)) {
        l1 = ((b)???).C.limit();
      }
      o.d("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d, preloadMixCacheCount:%d", new Object[] { ((b)???).c, Long.valueOf(l1), Long.valueOf(g.i(this.b)) });
      long l2 = g.h(this.b).d();
      boolean bool = g.h(this.b).c();
      if (g.j(this.b).containsKey(((b)???).c)) {
        i = ((Integer)g.j(this.b).get(((b)???).c)).intValue();
      } else {
        i = 0;
      }
      if (bool)
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
        if (g.k(this.b) != null) {
          g.k(this.b).d(713);
        }
        g.h(this.b).r("");
      }
      else if (l2 + l1 > 50000000L)
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", new Object[] { Long.valueOf(l2), Long.valueOf(l1) });
        if (g.k(this.b) != null) {
          g.k(this.b).d(714);
        }
        g.h(this.b).r("");
      }
      else if (i >= 30)
      {
        o.b("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
      }
      else
      {
        g.h(this.b);
        if ((!c.v(((b)???).c)) && (!g.a(this.b, (b)???)))
        {
          o.b("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
        }
        else
        {
          if (!g.h(this.b).u(((b)???).c))
          {
            ((b)???).B = true;
            ((b)???).x = l1;
            g.h(this.b).a((b)???);
            g.l(this.b);
            i = j;
            break label613;
          }
          o.d("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
        }
      }
    }
    else if (!TextUtils.isEmpty(((b)???).c))
    {
      ((b)???).B = false;
      if (!g.h(this.b).b(this.a)) {
        g.h(this.b).b((b)???);
      }
      if (g.a(this.b, (b)???)) {
        ((b)???).x = ((b)???).C.limit();
      } else {
        ((b)???).x = com.tencent.luggage.wxa.gw.a.d(((b)???).c);
      }
    }
    else
    {
      ((b)???).B = false;
    }
    int i = 0;
    label613:
    synchronized (g.g(this.b))
    {
      g.g(this.b).remove(this.a);
      if (i == 0) {
        g.c(this.b, this.a);
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.5
 * JD-Core Version:    0.7.0.1
 */