package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.o.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

class q$1
  implements Runnable
{
  q$1(q paramq, c paramc, int paramInt) {}
  
  public void run()
  {
    if (!this.a.d()) {
      return;
    }
    Object localObject = this.a.getFileSystem().c();
    JSONArray localJSONArray = new JSONArray();
    if ((localObject != null) && (((List)localObject).size() > 0)) {
      localObject = ((List)localObject).iterator();
    }
    for (;;)
    {
      o.a locala;
      if (((Iterator)localObject).hasNext()) {
        locala = (o.a)((Iterator)localObject).next();
      }
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("filePath", locala.a());
        localJSONObject.put("size", locala.b());
        localJSONObject.put("createTime", TimeUnit.MILLISECONDS.toSeconds(locala.c()));
        localJSONArray.put(localJSONObject);
      }
      catch (Exception localException) {}
      localObject = new HashMap(1);
      ((Map)localObject).put("fileList", localJSONArray);
      this.a.a(this.b, this.c.a("ok", (Map)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.q.1
 * JD-Core Version:    0.7.0.1
 */