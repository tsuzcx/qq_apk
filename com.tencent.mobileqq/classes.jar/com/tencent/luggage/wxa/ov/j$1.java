package com.tencent.luggage.wxa.ov;

import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.ot.d;
import com.tencent.luggage.wxa.ou.g;
import com.tencent.luggage.wxa.ou.k;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.Arrays;

class j$1
  implements Runnable
{
  j$1(j paramj, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    Object localObject3 = (d)e.b(d.class);
    if (localObject3 == null)
    {
      o.b("MicroMsg.AppBrand.Report.kv_13536", "report get null kvReporter");
      return;
    }
    try
    {
      try
      {
        String str1 = (String)this.a[19];
        if (!af.c(str1))
        {
          i = str1.indexOf('?');
          if (i < 0) {
            str1 = "";
          } else {
            str1 = k.a(str1.substring(i + 1, str1.length()));
          }
          this.a[19] = str1;
        }
        str1 = (String)this.a[19];
        if (af.b(str1).length() <= 1024) {
          break label198;
        }
        str1 = str1.substring(0, 1024);
        this.a[19] = str1;
      }
      finally
      {
        break label352;
      }
    }
    catch (Exception localException)
    {
      int i;
      label143:
      Object localObject2;
      int j;
      break label143;
    }
    this.a[19] = "";
    localObject2 = (String)this.a[19];
    if (af.b((String)localObject2).length() > 1024)
    {
      localObject2 = ((String)localObject2).substring(0, 1024);
      this.a[19] = localObject2;
    }
    label198:
    localObject2 = new int[3];
    Object tmp205_203 = localObject2;
    tmp205_203[0] = 1;
    Object tmp209_205 = tmp205_203;
    tmp209_205[1] = 11;
    Object tmp214_209 = tmp209_205;
    tmp214_209[2] = 13;
    tmp214_209;
    j = localObject2.length;
    i = 0;
    while (i < j)
    {
      int k = localObject2[i];
      String str2 = (String)this.a[k];
      if (af.b(str2).length() > 1024)
      {
        str2 = str2.substring(0, 1024);
        this.a[k] = str2;
      }
      i += 1;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("report ");
    ((StringBuilder)localObject2).append(Arrays.deepToString(this.a));
    o.e("MicroMsg.AppBrand.Report.kv_13536", ((StringBuilder)localObject2).toString());
    ((d)localObject3).a(13536, g.a(this.a));
    ((d)localObject3).a();
    return;
    label352:
    localObject3 = (String)this.a[19];
    if (af.b((String)localObject3).length() > 1024)
    {
      localObject3 = ((String)localObject3).substring(0, 1024);
      this.a[19] = localObject3;
    }
    for (;;)
    {
      throw ((Throwable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ov.j.1
 * JD-Core Version:    0.7.0.1
 */