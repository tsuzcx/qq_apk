package com.huawei.hms.framework.network.grs;

import com.huawei.hms.framework.network.grs.b.d;
import java.util.Map;

class a$2
  implements b
{
  a$2(a parama, String paramString, IQueryUrlsCallBack paramIQueryUrlsCallBack, Map paramMap) {}
  
  public void a()
  {
    if ((this.c != null) && (!this.c.isEmpty()))
    {
      this.b.onCallBackSuccess(this.c);
      return;
    }
    this.b.onCallBackFail(-3);
  }
  
  public void a(d paramd)
  {
    paramd = a.a(paramd.c(), this.a);
    if ((paramd != null) && (!paramd.isEmpty()))
    {
      this.b.onCallBackSuccess(paramd);
      return;
    }
    if ((this.c != null) && (!this.c.isEmpty()))
    {
      this.b.onCallBackSuccess(this.c);
      return;
    }
    this.b.onCallBackFail(-5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.2
 * JD-Core Version:    0.7.0.1
 */