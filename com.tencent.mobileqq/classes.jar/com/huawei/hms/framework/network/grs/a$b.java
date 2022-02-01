package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.f;

class a$b
  implements b
{
  String a;
  String b;
  IQueryUrlCallBack c;
  String d;
  Context e;
  GrsBaseInfo f;
  com.huawei.hms.framework.network.grs.a.a g;
  
  a$b(String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack, String paramString3, Context paramContext, GrsBaseInfo paramGrsBaseInfo, com.huawei.hms.framework.network.grs.a.a parama)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramIQueryUrlCallBack;
    this.d = paramString3;
    this.e = paramContext;
    this.f = paramGrsBaseInfo;
    this.g = parama;
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.d))
    {
      this.c.onCallBackSuccess(this.d);
      return;
    }
    if (TextUtils.isEmpty(this.d))
    {
      Logger.i(a.a(), "access local config for return a domain.");
      String str = com.huawei.hms.framework.network.grs.b.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true);
      this.c.onCallBackSuccess(str);
      return;
    }
    this.c.onCallBackFail(-3);
  }
  
  public void a(f paramf)
  {
    paramf = a.a(paramf.i(), this.a, this.b);
    if (!TextUtils.isEmpty(paramf)) {}
    for (;;)
    {
      this.c.onCallBackSuccess(paramf);
      return;
      if (!TextUtils.isEmpty(this.d))
      {
        this.c.onCallBackSuccess(this.d);
        return;
      }
      if (!TextUtils.isEmpty(this.d)) {
        break;
      }
      Logger.i(a.a(), "access local config for return a domain.");
      paramf = com.huawei.hms.framework.network.grs.b.b.a(this.e.getPackageName(), this.f).a(this.e, this.g, this.f, this.a, this.b, true);
    }
    this.c.onCallBackFail(-5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.b
 * JD-Core Version:    0.7.0.1
 */