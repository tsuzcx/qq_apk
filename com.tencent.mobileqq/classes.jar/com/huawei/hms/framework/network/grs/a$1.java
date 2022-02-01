package com.huawei.hms.framework.network.grs;

import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.b.d;

class a$1
  implements b
{
  a$1(a parama, String paramString1, String paramString2, IQueryUrlCallBack paramIQueryUrlCallBack, String paramString3) {}
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.d))
    {
      this.c.onCallBackSuccess(this.d);
      return;
    }
    this.c.onCallBackFail(-3);
  }
  
  public void a(d paramd)
  {
    paramd = a.a(paramd.c(), this.a, this.b);
    if (!TextUtils.isEmpty(paramd))
    {
      this.c.onCallBackSuccess(paramd);
      return;
    }
    if (!TextUtils.isEmpty(this.d))
    {
      this.c.onCallBackSuccess(this.d);
      return;
    }
    this.c.onCallBackFail(-5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.a.1
 * JD-Core Version:    0.7.0.1
 */