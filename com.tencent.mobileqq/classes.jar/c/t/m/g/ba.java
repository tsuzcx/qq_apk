package c.t.m.g;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ba
  extends ax
  implements bw
{
  private aa a = new aa();
  private List<d> b = new ArrayList();
  
  public ba()
  {
    String str = cc.b("settings_in_client", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      this.a.a(str);
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      cc.a("settings_in_client", "");
    }
  }
  
  private void c()
  {
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    finally {}
  }
  
  public final String a()
  {
    return "settings";
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return this.a.a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void a(String paramString1, String arg2)
  {
    if ((!TextUtils.isEmpty(???)) && (!be.a().b().equals(???))) {
      be.a().a(???, true);
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    synchronized (this.a)
    {
      this.a.b();
      this.a.a(paramString1);
      cc.a("settings_in_client", this.a.a());
      c();
      return;
    }
  }
  
  public final void a_()
  {
    by.c().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ba
 * JD-Core Version:    0.7.0.1
 */