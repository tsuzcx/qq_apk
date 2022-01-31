package c.t.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class j
{
  protected i a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected ae e;
  private int f;
  private long g;
  private int h = 0;
  
  public j(i parami)
  {
    this.a = parami;
    this.b = parami.a;
    this.c = parami.a;
    this.f = parami.e;
  }
  
  public aj a()
  {
    for (;;)
    {
      try
      {
        this.g = SystemClock.elapsedRealtime();
        v.a("app_http_proxy_timeout", 0, 20000, 5000);
        if (this.f <= 0) {
          this.f = v.a("app_req_timeout", 1000, 1000000, 15000);
        }
        if ((this.a.g > 0) && (this.a.g < this.f)) {
          this.f = this.a.g;
        }
        int i = this.f;
        aj localaj = a(i);
        i = ch.a((int)(this.f - (SystemClock.elapsedRealtime() - this.g)), this.f);
        Object localObject;
        if ((localaj.a == 0) && (localaj.c >= 300) && (localaj.c < 400) && (this.a.d) && (i > 200))
        {
          localObject = localaj.a("location");
          if (TextUtils.isEmpty((CharSequence)localObject)) {
            localaj.a = -6;
          }
        }
        else
        {
          localObject = this.a;
          if (!this.a.j) {
            break label294;
          }
          this.e.j = true;
          this.e.i = true;
          this.e.k = this.a.g;
          this.e.a(false);
          return localaj;
        }
        this.c = ((String)localObject);
        this.h += 1;
        if (this.h > 5)
        {
          localaj.a = -5;
          continue;
        }
        this.e.a(true);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return new aj(-1, ch.a(localThrowable));
      }
      continue;
      label294:
      this.e.k = (SystemClock.elapsedRealtime() - this.g);
    }
  }
  
  protected abstract aj a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.j
 * JD-Core Version:    0.7.0.1
 */