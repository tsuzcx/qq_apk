package com.tencent.beacon.stat;

import com.tencent.beacon.core.a.f;
import com.tencent.beacon.core.e.d;

class e
  implements Runnable
{
  e(ModuleImpl paramModuleImpl) {}
  
  public void run()
  {
    try
    {
      f localf = ((f)ModuleImpl.access$600(this.a).a()).b();
      localf = localf.a("on_qua_date", ModuleImpl.access$500(this.a).a());
      localf = localf.a("common_event_calls", ModuleImpl.access$400(this.a).a());
      localf = localf.a("real_time_event_calls", ModuleImpl.access$300(this.a).a());
      localf = localf.a("common_event_write_succ", ModuleImpl.access$200(this.a).a());
      localf = localf.a("real_time_event_write_succ", ModuleImpl.access$100(this.a).a());
      localf.a("real_time_event_upload_succ", ModuleImpl.access$000(this.a).a()).a();
      return;
    }
    catch (Exception localException)
    {
      d.a(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.e
 * JD-Core Version:    0.7.0.1
 */