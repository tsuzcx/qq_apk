package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.f;
import java.util.Map;

class a$a
  implements b
{
  String a;
  Map<String, String> b;
  IQueryUrlsCallBack c;
  Context d;
  GrsBaseInfo e;
  com.huawei.hms.framework.network.grs.a.a f;
  
  a$a(String paramString, Map<String, String> paramMap, IQueryUrlsCallBack paramIQueryUrlsCallBack, Context paramContext, GrsBaseInfo paramGrsBaseInfo, com.huawei.hms.framework.network.grs.a.a parama)
  {
    this.a = paramString;
    this.b = paramMap;
    this.c = paramIQueryUrlsCallBack;
    this.d = paramContext;
    this.e = paramGrsBaseInfo;
    this.f = parama;
  }
  
  public void a()
  {
    Map localMap = this.b;
    if ((localMap != null) && (!localMap.isEmpty()))
    {
      this.c.onCallBackSuccess(this.b);
      return;
    }
    if (this.b == null)
    {
      Logger.i(a.a(), "access local config for return a domain.");
      localMap = com.huawei.hms.framework.network.grs.b.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true);
      this.c.onCallBackSuccess(localMap);
      return;
    }
    this.c.onCallBackFail(-3);
  }
  
  public void a(f paramf)
  {
    paramf = a.a(paramf.i(), this.a);
    if (!paramf.isEmpty()) {}
    for (;;)
    {
      this.c.onCallBackSuccess(paramf);
      return;
      paramf = this.b;
      if ((paramf != null) && (!paramf.isEmpty()))
      {
        this.c.onCallBackSuccess(this.b);
        return;
      }
      if (this.b != null) {
        break;
      }
      Logger.i(a.a(), "access local config for return a domain.");
      paramf = com.huawei.hms.framework.network.grs.b.b.a(this.d.getPackageName(), this.e).a(this.d, this.f, this.e, this.a, true);
    }
    this.c.onCallBackFail(-5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.a
 * JD-Core Version:    0.7.0.1
 */