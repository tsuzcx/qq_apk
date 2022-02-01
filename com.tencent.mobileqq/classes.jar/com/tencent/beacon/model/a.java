package com.tencent.beacon.model;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.info.c;
import com.tencent.beacon.core.info.e;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

class a
  implements Runnable
{
  a(ModuleImpl paramModuleImpl) {}
  
  public void run()
  {
    if (c.a(ModuleImpl.access$000(this.a)) == null)
    {
      d.b("[model] detail user info is null.", new Object[0]);
      return;
    }
    e locale = e.d(ModuleImpl.access$100(this.a));
    HashMap localHashMap = new HashMap();
    localHashMap.put("A9", locale.d());
    localHashMap.put("A10", locale.h());
    localHashMap.put("A11", locale.g());
    localHashMap.put("A12", locale.j());
    localHashMap.put("A13", ModuleImpl.access$200(this.a));
    localHashMap.put("A14", locale.q() + "m");
    localHashMap.put("A15", locale.o() + "m");
    localHashMap.put("A16", ModuleImpl.access$300(this.a));
    localHashMap.put("A17", locale.m(ModuleImpl.access$400(this.a)));
    localHashMap.put("A18", "");
    localHashMap.put("A20", locale.p(ModuleImpl.access$500(this.a)));
    localHashMap.put("A22", ModuleImpl.access$600(this.a));
    localHashMap.put("A30", ModuleImpl.access$700(this.a) + "m");
    localHashMap.put("A33", locale.k(ModuleImpl.access$800(this.a)));
    localHashMap.put("A52", "" + locale.n(ModuleImpl.access$900(this.a)));
    localHashMap.put("A53", "" + locale.e() + "m");
    localHashMap.put("A54", "" + locale.m());
    localHashMap.put("A55", locale.f());
    if (locale.s())
    {
      str = "Y";
      localHashMap.put("A56", str);
      localHashMap.put("A57", ModuleImpl.access$1000(this.a));
      if (!locale.i()) {
        break label567;
      }
    }
    label567:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A58", str);
      localHashMap.put("A59", ModuleImpl.access$1100(this.a) + "m");
      localHashMap.put("A69", ModuleImpl.access$1200(this.a));
      localHashMap.put("A82", ModuleImpl.access$1300(this.a));
      UserAction.onUserAction("rqd_model", true, 0L, 0L, localHashMap, true);
      return;
      str = "N";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.model.a
 * JD-Core Version:    0.7.0.1
 */