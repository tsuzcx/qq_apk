package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.c.n;
import java.util.concurrent.Callable;

class c
  implements Callable<Boolean>
{
  c(d paramd, Context paramContext1, GrsBaseInfo paramGrsBaseInfo, Context paramContext2) {}
  
  public Boolean call()
  {
    d.a(this.d, new m());
    d.a(this.d, new com.huawei.hms.framework.network.grs.a.c(this.a, "share_pre_grs_conf_"));
    d.b(this.d, new com.huawei.hms.framework.network.grs.a.c(this.a, "share_pre_grs_services_"));
    Object localObject1 = this.d;
    d.a((d)localObject1, new com.huawei.hms.framework.network.grs.a.a(d.b((d)localObject1), d.c(this.d), d.a(this.d)));
    localObject1 = this.d;
    d.a((d)localObject1, new a(d.e((d)localObject1), d.d(this.d), d.a(this.d), d.c(this.d)));
    new b(this.a, this.b, true).a(this.b);
    String str = new com.huawei.hms.framework.network.grs.c.b.c(this.b, this.a).c();
    localObject1 = d.a();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("scan serviceSet is:");
    ((StringBuilder)localObject2).append(str);
    Logger.v((String)localObject1, ((StringBuilder)localObject2).toString());
    localObject1 = d.c(this.d).a("services", "");
    str = n.a((String)localObject1, str);
    if (!TextUtils.isEmpty(str))
    {
      d.c(this.d).b("services", str);
      localObject2 = d.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("postList is:");
      localStringBuilder.append(str);
      localStringBuilder.append(" currentServices:");
      localStringBuilder.append((String)localObject1);
      Logger.v((String)localObject2, localStringBuilder.toString());
      if (!str.equals(localObject1))
      {
        localObject1 = d.e(this.d).getGrsParasKey(false, true, this.a);
        d.a(this.d).a((String)localObject1);
        d.a(this.d).a(new com.huawei.hms.framework.network.grs.c.b.c(this.b, this.c), null, null, d.c(this.d));
      }
    }
    localObject1 = this.d;
    d.a((d)localObject1, d.b((d)localObject1).a());
    d.d(this.d).b(this.b, this.a);
    return Boolean.valueOf(d.a(this.d, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c
 * JD-Core Version:    0.7.0.1
 */