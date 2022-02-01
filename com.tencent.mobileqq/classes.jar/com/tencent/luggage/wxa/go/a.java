package com.tencent.luggage.wxa.go;

import android.text.TextUtils;
import com.tencent.luggage.wxa.gm.d;
import com.tencent.luggage.wxa.gn.f;
import com.tencent.luggage.wxa.gw.b;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Iterator;

public class a
  implements e
{
  private String a;
  private String b;
  
  public a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private void a(ArrayList<String> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = "";
    int i = 0;
    while (localIterator.hasNext())
    {
      localObject = (String)localIterator.next();
      d locald = f.c().a((String)localObject);
      if ((locald == null) || (!locald.e()) || (!locald.i()))
      {
        int j = f.c().b((String)localObject);
        if (j >= i)
        {
          paramArrayList = (ArrayList<String>)localObject;
          i = j;
        }
      }
    }
    Object localObject = f.c().a(paramArrayList);
    if ((localObject != null) && (((d)localObject).e()) && (!((d)localObject).i())) {
      ((d)localObject).a(this.a);
    }
    b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", new Object[] { paramArrayList, Integer.valueOf(i) });
  }
  
  public void a()
  {
    b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", new Object[] { this.a });
    Object localObject;
    if (TextUtils.isEmpty(this.b))
    {
      b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
      localObject = f.c().f();
      if (((ArrayList)localObject).size() > 0) {
        a((ArrayList)localObject);
      }
    }
    else
    {
      int i = f.c().b(this.b);
      b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", new Object[] { this.b, Integer.valueOf(i) });
      localObject = f.c().a(this.b);
      if ((localObject != null) && (((d)localObject).e()) && (!((d)localObject).i())) {
        ((d)localObject).a(this.a);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.go.a
 * JD-Core Version:    0.7.0.1
 */