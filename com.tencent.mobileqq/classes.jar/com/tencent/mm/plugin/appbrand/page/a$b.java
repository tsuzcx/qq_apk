package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.mm.plugin.appbrand.appcache.o;

final class a$b
  implements a.a
{
  private a$b(a parama) {}
  
  private void d(String paramString)
  {
    String str = this.a.F().a(paramString);
    if (!TextUtils.isEmpty(str))
    {
      this.a.a(paramString, str);
      return;
    }
    throw new o(paramString);
  }
  
  public void a()
  {
    a.c(this.a).a("__APP__", true);
    d("common.app.js");
    d("webview.app.js");
  }
  
  public void a(String paramString)
  {
    if (!this.a.n().am().a()) {
      return;
    }
    String str = this.a.n().am().a(paramString);
    if ("__APP__".equals(str)) {
      return;
    }
    a.c(this.a).a(str, true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    paramString = "/";
    if (str.endsWith("/")) {
      paramString = "";
    }
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("common.app.js");
    d(localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("webview.app.js");
    d(localStringBuilder.toString());
  }
  
  public String b()
  {
    return "LazyCodeLoading";
  }
  
  public void b(String paramString) {}
  
  public boolean c(String paramString)
  {
    return "webview.app.js".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.b
 * JD-Core Version:    0.7.0.1
 */