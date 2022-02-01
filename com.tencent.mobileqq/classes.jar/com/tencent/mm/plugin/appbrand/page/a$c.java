package com.tencent.mm.plugin.appbrand.page;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ed.d;
import com.tencent.mm.plugin.appbrand.appcache.o;

final class a$c
  implements a.a
{
  private a$c(a parama) {}
  
  public void a()
  {
    a.c(this.a).a("__APP__", false);
    if (this.a.n().am().a())
    {
      str = this.a.F().a("app-wxss.js");
      if (!TextUtils.isEmpty(str))
      {
        this.a.a("app-wxss.js", str);
        return;
      }
      throw new o("app-wxss.js");
    }
    String str = this.a.F().a("page-frame.html");
    this.a.a("page-frame.html", str);
  }
  
  public void a(String paramString)
  {
    if (!this.a.n().am().a()) {
      return;
    }
    String str = this.a.n().am().a(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    paramString = "/";
    if (str.endsWith("/")) {
      paramString = "";
    }
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("page-frame.js");
    paramString = ((StringBuilder)localObject).toString();
    localObject = this.a.F().a(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      a.c(this.a).a(str, false);
      this.a.a(paramString, (String)localObject);
      return;
    }
    throw new o(paramString);
  }
  
  public String b()
  {
    return "Legacy";
  }
  
  public void b(String paramString)
  {
    String str = this.a.F().a(paramString);
    this.a.a(paramString, str);
  }
  
  public boolean c(String paramString)
  {
    return ("app-wxss.js".equals(paramString)) || ("page-frame.html".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.a.c
 * JD-Core Version:    0.7.0.1
 */