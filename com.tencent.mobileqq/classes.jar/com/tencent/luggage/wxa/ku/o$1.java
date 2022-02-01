package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.rt.i;
import java.util.HashMap;
import java.util.Map;

class o$1
  implements Runnable
{
  o$1(o paramo, com.tencent.luggage.wxa.jx.c paramc, String paramString1, int paramInt, String paramString2) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    Object localObject = this.a.getFileSystem().g(this.b);
    if (localObject == null)
    {
      this.a.a(this.c, this.e.b("fail:file doesn't exist"));
      return;
    }
    i locali = new i(((i)localObject).l());
    localObject = this.d;
    int i = -1;
    int j = ((String)localObject).hashCode();
    if (j != 107902)
    {
      if ((j == 3528965) && (((String)localObject).equals("sha1"))) {
        i = 1;
      }
    }
    else if (((String)localObject).equals("md5")) {
      i = 0;
    }
    if (i != 0)
    {
      if (i != 1) {
        localObject = "";
      } else {
        localObject = o.a(new i(locali.l()));
      }
    }
    else {
      localObject = com.tencent.luggage.wxa.gl.c.a(locali.l());
    }
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("size", Long.valueOf(locali.q()));
    localHashMap.put("digest", localObject);
    this.a.a(this.c, this.e.a("ok", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.o.1
 * JD-Core Version:    0.7.0.1
 */