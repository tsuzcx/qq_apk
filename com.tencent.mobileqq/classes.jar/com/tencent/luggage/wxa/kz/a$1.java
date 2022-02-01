package com.tencent.luggage.wxa.kz;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rc.b;
import com.tencent.luggage.wxa.rc.d;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.io.InputStream;
import org.apache.commons.io.FilenameUtils;

class a$1
  implements Runnable
{
  a$1(a parama, c paramc, String paramString, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    InputStream localInputStream = this.a.getFileSystem().k(this.b);
    if (localInputStream == null) {}
    for (;;)
    {
      try
      {
        this.a.a(this.c, this.d.b("fail file not exists"));
        continue;
        String str1 = FilenameUtils.getExtension(this.b);
        Object localObject2 = d.a(str1);
        if (!this.d.a((String)localObject2))
        {
          this.a.a(this.c, this.d.b("fail invalid file type"));
          return;
        }
        str1 = this.d.c(str1);
        boolean bool = a.a(this.d, str1, localInputStream);
        if (bool)
        {
          this.d.d(str1);
          b.a(str1, this.a.getContext());
        }
        localObject2 = this.a;
        int i = this.c;
        a locala = this.d;
        if (bool)
        {
          str1 = "ok";
          ((c)localObject2).a(i, locala.b(str1));
          return;
        }
      }
      finally
      {
        af.a(localInputStream);
      }
      String str2 = "fail";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kz.a.1
 * JD-Core Version:    0.7.0.1
 */