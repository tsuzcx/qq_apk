package c.t.m.g;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class en$a
  extends Handler
{
  volatile boolean a = false;
  
  private en$a(en paramen, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  @SuppressLint({"NewApi", "MissingPermission"})
  public final void handleMessage(Message arg1)
  {
    int i = 0;
    if (!this.b.a) {
      return;
    }
    Object localObject1 = fj.c(this.b.c);
    ??? = this.b.d;
    if (??? != null) {
      ???.a((List)localObject1);
    }
    if ((localObject1 != null) && (((List)localObject1).size() != 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Iterator)localObject1).next();
      }
    }
    if (??? != null)
    {
      if (System.currentTimeMillis() - ???.i < 3000L) {
        i = 1;
      }
      if (i != 0) {}
    }
    else if (this.b.c.f != null)
    {
      ??? = fj.b(this.b.c);
      localObject1 = et.a(this.b.c, ???);
      if (localObject1 != null)
      {
        ??? = (Message)localObject1;
        if (((et)localObject1).j) {}
      }
      else
      {
        ??? = fj.a(this.b.c);
        ??? = et.a(this.b.c, ???, this.b.j);
      }
      en.a(this.b, ???, 2);
    }
    synchronized (this.b.b)
    {
      if ((this.b.g != null) && (!this.a)) {
        co.a(this.b.g, 0, 30000L);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.en.a
 * JD-Core Version:    0.7.0.1
 */