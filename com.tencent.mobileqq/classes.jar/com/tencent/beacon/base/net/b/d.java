package com.tencent.beacon.base.net.b;

import android.text.TextUtils;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.e.g;
import com.tencent.beacon.pack.SocketRequestPackage;
import java.util.Map;

public final class d
  implements c<k, SocketRequestPackage>
{
  private Map<String, String> b(k paramk)
  {
    paramk = paramk.d();
    if (!paramk.containsKey("sid"))
    {
      String str = g.b().c();
      if (!TextUtils.isEmpty(str)) {
        paramk.put("sid", str);
      }
    }
    return paramk;
  }
  
  public SocketRequestPackage a(k paramk)
  {
    return new SocketRequestPackage(b(paramk), paramk.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.net.b.d
 * JD-Core Version:    0.7.0.1
 */