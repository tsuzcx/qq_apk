package com.tencent.luggage.wxa.bl;

import android.content.Context;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.util.a;
import com.tencent.luggage.wxa.d.d.a;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import java.nio.ByteBuffer;

final class b$a
  implements com.tencent.luggage.wxa.d.d
{
  private final com.tencent.mm.plugin.appbrand.appstorage.o a;
  private final String b;
  
  private b$a(com.tencent.luggage.wxa.iu.d paramd)
  {
    this.b = paramd.aa();
    this.a = paramd.z();
  }
  
  public d.a a(Object paramObject, ImageDecodeConfig paramImageDecodeConfig)
  {
    paramImageDecodeConfig = new d.a();
    paramObject = (String)paramObject;
    if (this.a == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.WAGameRuntimeFileSystemImageStreamFetcher", "fetch %s, appId[%s] fs NULL", new Object[] { paramObject, this.b });
      paramImageDecodeConfig.b = r.a().getString(2131886939);
      return paramImageDecodeConfig;
    }
    i locali = new i();
    j localj = this.a.b(paramObject, locali);
    if ((localj == j.a) && (locali.a != null))
    {
      paramImageDecodeConfig.a = new a((ByteBuffer)locali.a);
      return paramImageDecodeConfig;
    }
    com.tencent.luggage.wxa.qz.o.b("MicroMsg.WAGameRuntimeFileSystemImageStreamFetcher", "fetch %s, ret %s, appId[%s]", new Object[] { paramObject, localj.name(), this.b });
    paramImageDecodeConfig.b = String.format(r.a().getString(2131886938), new Object[] { localj.name() });
    return paramImageDecodeConfig;
  }
  
  public String a()
  {
    return "appbrand_file";
  }
  
  public boolean a(Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bl.b.a
 * JD-Core Version:    0.7.0.1
 */