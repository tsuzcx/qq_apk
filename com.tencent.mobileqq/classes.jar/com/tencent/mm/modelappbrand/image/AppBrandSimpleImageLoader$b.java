package com.tencent.mm.modelappbrand.image;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.luggage.wxa.rt.k;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class AppBrandSimpleImageLoader$b
  implements AppBrandSimpleImageLoader.i
{
  public OutputStream a(String paramString)
  {
    try
    {
      if ((!k.g(AppBrandSimpleImageLoader.a())) && (!new i(AppBrandSimpleImageLoader.a()).n()))
      {
        k.i(AppBrandSimpleImageLoader.a());
        k.g(AppBrandSimpleImageLoader.a());
      }
    }
    catch (Throwable localThrowable)
    {
      o.b("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", new Object[] { localThrowable });
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppBrandSimpleImageLoader.a());
    ((StringBuilder)localObject1).append(paramString);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(".wlock");
    localObject2 = ((StringBuilder)localObject2).toString();
    k.i((String)localObject2);
    k.d((String)localObject2, true);
    k.b((String)localObject2, new byte[1]);
    try
    {
      k.i((String)localObject1);
      k.d((String)localObject1, true);
      localObject1 = new AppBrandSimpleImageLoader.b.1(this, k.b((String)localObject1), (String)localObject2);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      o.a("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", localIOException, "openWrite fileName %s, parent exists[%b]", new Object[] { paramString, Boolean.valueOf(k.h(AppBrandSimpleImageLoader.a())) });
    }
    return null;
  }
  
  public InputStream b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppBrandSimpleImageLoader.a());
    ((StringBuilder)localObject).append(paramString);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".wlock");
    if (k.h(localStringBuilder.toString())) {
      return null;
    }
    try
    {
      localObject = k.a((String)localObject);
      return localObject;
    }
    catch (IOException localIOException)
    {
      o.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", new Object[] { paramString, localIOException });
    }
    return null;
  }
  
  public boolean c(String paramString)
  {
    if (!af.c(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppBrandSimpleImageLoader.a());
      localStringBuilder.append(paramString);
      if (k.i(localStringBuilder.toString())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader.b
 * JD-Core Version:    0.7.0.1
 */