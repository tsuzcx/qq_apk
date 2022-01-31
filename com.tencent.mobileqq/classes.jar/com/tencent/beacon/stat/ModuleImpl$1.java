package com.tencent.beacon.stat;

import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.d.b;

final class ModuleImpl$1
  implements Runnable
{
  ModuleImpl$1(ModuleImpl paramModuleImpl) {}
  
  public final void run()
  {
    try
    {
      ((c)ModuleImpl.access$600(this.a).a()).a().a("on_qua_date", ModuleImpl.access$500(this.a).a()).a("common_event_calls", ModuleImpl.access$400(this.a).a()).a("real_time_event_calls", ModuleImpl.access$300(this.a).a()).a("common_event_write_succ", ModuleImpl.access$200(this.a).a()).a("real_time_event_write_succ", ModuleImpl.access$100(this.a).a()).a("real_time_event_upload_succ", ModuleImpl.access$000(this.a).a()).b();
      return;
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.stat.ModuleImpl.1
 * JD-Core Version:    0.7.0.1
 */