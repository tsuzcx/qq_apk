package com.tencent.luggage.wxa.jx;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONObject;

class d$4
  extends ad
{
  d$4(d paramd, String paramString, m paramm, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo, Looper paramLooper) {}
  
  private String c()
  {
    try
    {
      Object localObject = d.a(this.f, this.a);
      if (localObject == null) {
        localObject = this.b.b("fail:invalid data");
      } else {
        localObject = d.a(this.f, this.b, (JSONObject)localObject, this.c, this.d);
      }
      d.a(this.f, this.b, this.a, this.c, (String)localObject);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "invokeImpl() parseDataStr oom, api[%s], data_length[%d]", new Object[] { this.b.d(), Integer.valueOf(af.b(this.a).length()) });
      throw localOutOfMemoryError;
    }
  }
  
  private void c(String paramString)
  {
    b(paramString);
    this.f.a(this.c, paramString);
  }
  
  public void a()
  {
    if (!TextUtils.isEmpty(b())) {
      return;
    }
    Object localObject = this.e;
    if ((localObject != null) && (localObject != Looper.myLooper()))
    {
      new Handler(this.e).post(new d.4.1(this, this));
      return;
    }
    int i;
    if ((!this.f.e()) && (!this.f.d())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandComponentImpl", "invoke handler.proceed() log[%s] api[%s], callbackId[%d], component not running", new Object[] { this.f.H(), this.b, Integer.valueOf(this.c) });
    }
    if (i != 0) {
      localObject = c();
    } else {
      localObject = this.b.b("fail:interrupted");
    }
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      c((String)localObject);
    }
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(b())) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      c(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.d.4
 * JD-Core Version:    0.7.0.1
 */