package com.tencent.beacon.stat;

class f
  implements Runnable
{
  f(ModuleImpl paramModuleImpl) {}
  
  public void run()
  {
    ModuleImpl.access$600(this.a).a(com.tencent.beacon.core.a.f.a(ModuleImpl.access$700(this.a)));
    ModuleImpl.access$500(this.a).a(((com.tencent.beacon.core.a.f)ModuleImpl.access$600(this.a).b()).a("on_qua_date", ""));
    ModuleImpl.access$400(this.a).a(Long.valueOf(((com.tencent.beacon.core.a.f)ModuleImpl.access$600(this.a).b()).a("common_event_calls", 0L)));
    ModuleImpl.access$300(this.a).a(Long.valueOf(((com.tencent.beacon.core.a.f)ModuleImpl.access$600(this.a).b()).a("real_time_event_calls", 0L)));
    ModuleImpl.access$200(this.a).a(Long.valueOf(((com.tencent.beacon.core.a.f)ModuleImpl.access$600(this.a).b()).a("common_event_write_succ", 0L)));
    ModuleImpl.access$100(this.a).a(Long.valueOf(((com.tencent.beacon.core.a.f)ModuleImpl.access$600(this.a).b()).a("real_time_event_write_succ", 0L)));
    ModuleImpl.access$000(this.a).a(Long.valueOf(((com.tencent.beacon.core.a.f)ModuleImpl.access$600(this.a).b()).a("real_time_event_upload_succ", 0L)));
    ModuleImpl.access$800(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.f
 * JD-Core Version:    0.7.0.1
 */