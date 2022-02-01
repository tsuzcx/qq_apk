package com.tencent.beacon.qimei;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

class b
  implements Runnable
{
  b(c paramc) {}
  
  public void run()
  {
    e.d();
    String str = e.a(c.a(this.a));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("non-main process check local qimei: ");
    localStringBuilder.append(str);
    com.tencent.beacon.base.util.c.a("[Qimei]", localStringBuilder.toString(), new Object[0]);
    if (!TextUtils.isEmpty(str))
    {
      this.a.a(str);
      e.a(System.currentTimeMillis());
      c.b(this.a);
      return;
    }
    if (c.c(this.a).getAndIncrement() > 30) {
      return;
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.qimei.b
 * JD-Core Version:    0.7.0.1
 */