package com.tencent.luggage.wxa.hd;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import java.util.Random;

final class c$12
  extends c.b
{
  final c.c a = new c.c(256);
  
  c$12(c.a parama)
  {
    super(parama);
  }
  
  String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(c.c());
    Object localObject = this.a.a(null);
    boolean bool;
    if (localObject == null)
    {
      localObject = c.a(false);
      o.c("MicroMsg.DeviceInfo", "[!] fail to fetch devId from deprecated cache, using getIMEI instead. value: %s", new Object[] { localObject });
      bool = false;
    }
    else
    {
      bool = true;
    }
    o.d("MicroMsg.DeviceInfo", "[+] devId: %s, useDeprecatedDevId: %s", new Object[] { localObject, Boolean.valueOf(bool) });
    if (bool)
    {
      localStringBuilder1.append((String)localObject);
    }
    else if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("A");
      localStringBuilder2.append((String)localObject);
      localStringBuilder2.append("123456789ABCDEF");
      localStringBuilder1.append(localStringBuilder2.toString().substring(0, 15));
    }
    else
    {
      localObject = new Random();
      ((Random)localObject).setSeed(System.currentTimeMillis());
      localStringBuilder1.append("A");
      int i = 0;
      while (i < 15)
      {
        localStringBuilder1.append((char)(((Random)localObject).nextInt(25) + 65));
        i += 1;
      }
      this.a.b();
    }
    localStringBuilder1.append(c.b());
    localObject = localStringBuilder1.toString();
    o.d("MicroMsg.DeviceInfo", "[+] new mmguid, dev:%s", new Object[] { localObject });
    localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("A");
    localStringBuilder1.append(com.tencent.luggage.wxa.gl.c.a(((String)localObject).getBytes()).substring(0, 15));
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.c.12
 * JD-Core Version:    0.7.0.1
 */