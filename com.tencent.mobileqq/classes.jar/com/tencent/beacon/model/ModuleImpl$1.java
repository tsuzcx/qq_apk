package com.tencent.beacon.model;

import com.tencent.beacon.core.b.c;
import com.tencent.beacon.core.b.d;
import com.tencent.beacon.core.d.b;
import com.tencent.beacon.core.d.f;
import com.tencent.beacon.event.UserAction;
import java.util.HashMap;
import java.util.Map;

final class ModuleImpl$1
  implements Runnable
{
  ModuleImpl$1(ModuleImpl paramModuleImpl) {}
  
  public final void run()
  {
    if (c.a(ModuleImpl.access$000(this.a)) == null)
    {
      b.d("[model] detail user info is null.", new Object[0]);
      return;
    }
    d.a(ModuleImpl.access$100(this.a));
    HashMap localHashMap = new HashMap();
    localHashMap.put("A9", d.e());
    localHashMap.put("A10", d.b());
    localHashMap.put("A11", ModuleImpl.access$200(this.a));
    localHashMap.put("A12", this.a.getLanguage());
    localHashMap.put("A13", ModuleImpl.access$300(this.a));
    localHashMap.put("A14", d.f() + "m");
    localHashMap.put("A15", ModuleImpl.access$400(this.a) + "m");
    localHashMap.put("A16", ModuleImpl.access$500(this.a));
    localHashMap.put("A17", ModuleImpl.access$600(this.a));
    localHashMap.put("A18", "");
    localHashMap.put("A20", d.g(ModuleImpl.access$700(this.a)));
    localHashMap.put("A22", ModuleImpl.access$800(this.a));
    localHashMap.put("A30", ModuleImpl.access$900(this.a) + "m");
    localHashMap.put("A33", d.j(ModuleImpl.access$1000(this.a)));
    localHashMap.put("A52", ModuleImpl.access$1100(this.a));
    localHashMap.put("A53", ModuleImpl.access$1200(this.a) + "m");
    localHashMap.put("A54", ModuleImpl.access$1300(this.a));
    localHashMap.put("A55", ModuleImpl.access$1400(this.a));
    if (ModuleImpl.access$1500(this.a))
    {
      str = "Y";
      localHashMap.put("A56", str);
      localHashMap.put("A57", ModuleImpl.access$1600(this.a));
      if (!f.a().b()) {
        break label562;
      }
    }
    label562:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A58", str);
      localHashMap.put("A59", ModuleImpl.access$1700(this.a) + "m");
      localHashMap.put("A69", ModuleImpl.access$1800(this.a));
      localHashMap.put("A82", ModuleImpl.access$1900(this.a));
      UserAction.onUserAction("rqd_model", true, 0L, 0L, localHashMap, true);
      return;
      str = "N";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.model.ModuleImpl.1
 * JD-Core Version:    0.7.0.1
 */