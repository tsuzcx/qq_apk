package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class k
  implements ab
{
  protected i a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected aj e;
  private int f;
  private int g = 5000;
  private long h;
  private int i = 0;
  
  public k(i parami)
  {
    this.a = parami;
    this.b = parami.a;
    this.c = parami.a;
    this.f = parami.e;
    this.h = SystemClock.elapsedRealtime();
  }
  
  public ao a()
  {
    for (;;)
    {
      try
      {
        this.g = x.a.a("app_http_proxy_timeout", 0, 20000, 5000);
        if (this.f <= 0) {
          this.f = x.a.a("app_req_timeout", 1000, 1000000, 15000);
        }
        if ((this.a.j > 0) && (this.a.j < this.f)) {
          this.f = this.a.j;
        }
        int j = this.f;
        ao localao = a(j);
        j = cn.a((int)(this.f - (SystemClock.elapsedRealtime() - this.h)), this.f);
        String str;
        if ((localao.a == 0) && (localao.c >= 300) && (localao.c < 400) && (this.a.d) && (j > 200))
        {
          str = localao.a("location");
          if (TextUtils.isEmpty(str)) {
            localao.a = -6;
          }
        }
        else
        {
          boolean bool = this.a.i;
          if (!this.a.m) {
            break label296;
          }
          this.e.j = true;
          this.e.i = true;
          this.e.k = this.a.j;
          this.e.a(false);
          return localao;
        }
        this.c = str;
        this.i += 1;
        if (this.i > 5)
        {
          localao.a = -5;
          continue;
        }
        this.e.a(true);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return new ao(-1, cn.a(localThrowable));
      }
      continue;
      label296:
      this.e.k = (SystemClock.elapsedRealtime() - this.h);
    }
  }
  
  protected abstract ao a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.k
 * JD-Core Version:    0.7.0.1
 */