package com.tencent.luggage.wxa.nr;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class a
{
  public static a b = new a();
  HashMap<String, a.b> a = new HashMap();
  private volatile String c = "";
  
  public static boolean c(String paramString)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    a.a locala = new a.a();
    a.a.a(locala, paramString);
    if (locala.f()) {
      bool1 = a.a.a(locala);
    }
    return bool1;
  }
  
  public void a(int paramInt)
  {
    o.d("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(paramInt) });
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (a.b)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(this.c)) && (this.c.equalsIgnoreCase(str)))
        {
          o.d("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { this.c });
          if (localObject != null) {
            if (paramInt == 10) {
              ((a.b)localObject).a();
            } else if (paramInt == 2) {
              ((a.b)localObject).b();
            } else if (paramInt == 7) {
              ((a.b)localObject).c();
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public boolean a(String paramString, a.b paramb)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramb != null))
    {
      if (!this.a.containsKey(paramString))
      {
        this.a.put(paramString, paramb);
      }
      else
      {
        this.a.remove(paramString);
        this.a.put(paramString, paramb);
      }
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (this.a.containsKey(paramString))
    {
      this.a.remove(paramString);
      return true;
    }
    return false;
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (!paramString.equalsIgnoreCase(this.c))
    {
      o.b("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
      return false;
    }
    a.c localc = new a.c();
    localc.a = paramString;
    localc.g();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nr.a
 * JD-Core Version:    0.7.0.1
 */