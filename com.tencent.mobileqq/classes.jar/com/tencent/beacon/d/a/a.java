package com.tencent.beacon.d.a;

import com.tencent.beacon.a.c.b;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.module.StatModule;
import java.util.Map;

class a
  implements Runnable
{
  a(c paramc) {}
  
  public void run()
  {
    f localf = f.p();
    c.a(this.a).put("A19", localf.w());
    Map localMap = c.a(this.a);
    String str;
    if (b.d) {
      str = "Y";
    } else {
      str = "N";
    }
    localMap.put("A85", str);
    c.a(this.a).put("A20", localf.I());
    c.a(this.a).put("A69", localf.J());
    c.b(this.a).b(c.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.d.a.a
 * JD-Core Version:    0.7.0.1
 */