package com.tencent.luggage.wxa.nz;

import android.annotation.TargetApi;
import android.net.nsd.NsdServiceInfo;
import android.os.Build.VERSION;
import android.util.Base64;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class p$c
{
  public Map<String, String> a = new HashMap();
  public String b;
  public String c;
  public String d;
  public int e;
  
  public p$c() {}
  
  @TargetApi(21)
  p$c(NsdServiceInfo paramNsdServiceInfo)
  {
    Object localObject = paramNsdServiceInfo.getHost();
    if (localObject != null) {
      this.d = ((InetAddress)localObject).getHostAddress();
    }
    this.e = paramNsdServiceInfo.getPort();
    this.b = paramNsdServiceInfo.getServiceName();
    this.c = paramNsdServiceInfo.getServiceType();
    localObject = null;
    if (Build.VERSION.SDK_INT >= 21) {
      localObject = paramNsdServiceInfo.getAttributes();
    }
    if (localObject != null)
    {
      paramNsdServiceInfo = ((Map)localObject).keySet().iterator();
      while (paramNsdServiceInfo.hasNext())
      {
        String str = (String)paramNsdServiceInfo.next();
        byte[] arrayOfByte = (byte[])((Map)localObject).get(str);
        if (arrayOfByte != null) {
          this.a.put(str, new String(Base64.encode(arrayOfByte, 2)));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.p.c
 * JD-Core Version:    0.7.0.1
 */