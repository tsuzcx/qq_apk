package c.t.m.g;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public final class aq$b
  extends aq.a
{
  private String a;
  private boolean b;
  private boolean c;
  
  public aq$b(aq paramaq, String paramString)
  {
    super(paramaq, (byte)0);
    this.a = paramString;
    this.b = false;
    this.c = true;
  }
  
  public final void run()
  {
    aq.b(this.d).decrementAndGet();
    if (TextUtils.isEmpty(this.a)) {}
    int i;
    do
    {
      return;
      i = x.a.a("report_new_record_num", 1, 50, 10);
      if (ba.a(this.d.b()).b(this.a) == -1L) {
        break;
      }
      if (aq.c(this.d))
      {
        aq.a(this.d, false);
        aq.b(this.d, false);
      }
    } while (aq.d(this.d).incrementAndGet() < i);
    aq.a(this.d, false, this.c);
    return;
    aq.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.aq.b
 * JD-Core Version:    0.7.0.1
 */