package com.tencent.mm.plugin.appbrand.appcache;

import androidx.annotation.Nullable;
import com.tencent.mm.plugin.appbrand.appstorage.y;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class x$b
  implements Closeable
{
  private final h a;
  private final Map<v, y> b = new HashMap();
  
  private x$b(h paramh)
  {
    this.a = paramh;
  }
  
  @Nullable
  y a(String paramString)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return null;
    }
    v localv = ((h)localObject).a(paramString);
    if (localv == null) {
      return null;
    }
    synchronized (this.b)
    {
      localObject = (y)this.b.get(localv);
      paramString = (String)localObject;
      if (localObject == null)
      {
        localObject = this.b;
        paramString = new y(localv);
        ((Map)localObject).put(localv, paramString);
      }
      return paramString;
    }
  }
  
  Collection<y> a()
  {
    synchronized (this.b)
    {
      Collection localCollection = this.b.values();
      return localCollection;
    }
  }
  
  public void close()
  {
    synchronized (this.b)
    {
      this.b.clear();
      ??? = this.a;
      if (??? != null) {
        ((h)???).close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.x.b
 * JD-Core Version:    0.7.0.1
 */