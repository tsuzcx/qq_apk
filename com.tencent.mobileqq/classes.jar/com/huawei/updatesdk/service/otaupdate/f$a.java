package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.a.b.d.a.a;
import com.huawei.updatesdk.a.b.d.a.c;
import com.huawei.updatesdk.a.b.d.a.d;
import java.util.ArrayList;
import java.util.List;

class f$a
  implements a
{
  public void a(c paramc, d paramd) {}
  
  public void b(c paramc, d paramd)
  {
    if ((paramd instanceof com.huawei.updatesdk.service.appmgr.bean.b))
    {
      paramc = (com.huawei.updatesdk.service.appmgr.bean.b)paramd;
      if ((paramd.a() != 0) || (paramd.c() != 0)) {
        if (f.a() != null) {
          f.a().b(paramd.a());
        }
      }
    }
    while (f.a() == null)
    {
      do
      {
        do
        {
          return;
          if (((paramc.list_ != null) && (paramc.list_.size() != 0)) || ((paramc.notRcmList_ != null) && (paramc.notRcmList_.size() != 0))) {
            break;
          }
        } while (f.a() == null);
        f.a().a(paramd.a());
        return;
        paramc = f.a(paramc.list_);
      } while (f.a() == null);
      f.a().a(paramc);
      return;
    }
    f.a().a(paramd.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.otaupdate.f.a
 * JD-Core Version:    0.7.0.1
 */