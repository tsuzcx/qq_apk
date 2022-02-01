package com.tencent.luggage.wxa.ld;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.nz.p;
import com.tencent.luggage.wxa.nz.p.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class f
  extends a<c>
{
  public static final int CTRL_INDEX = 529;
  public static final String NAME = "operateLocalServicesScan";
  private final Map<String, f.a> a = new ConcurrentHashMap();
  
  @NonNull
  private String a(c paramc, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramc.getAppId());
    localStringBuilder.append("#");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void a(c paramc, int paramInt)
  {
    Map localMap = this.a;
    int i = 1;
    try
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        f.a locala = (f.a)localIterator.next();
        locala.b(paramInt);
        p.a.a(locala);
        i = 0;
      }
      if (i != 0) {
        paramc.a(paramInt, b("fail:task not found"));
      }
      this.a.clear();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramc;
    }
  }
  
  private void a(c paramc, String paramString, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.keySet().iterator();
      while (localIterator.hasNext()) {
        if (((String)localIterator.next()).contains(paramc.getAppId()))
        {
          paramc.a(paramInt, b("fail:scan task already exist"));
          return;
        }
      }
      ??? = new f.a(this, paramc);
      ((f.a)???).a(paramInt);
      this.a.put(a(paramc, paramString), ???);
      p.a.a(paramString, (p.b)???);
      t.a(new f.1(this, paramc, paramString, (f.a)???), 30000L);
      return;
    }
    for (;;)
    {
      throw paramc;
    }
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("action");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action = ");
    localStringBuilder.append(str);
    o.d("MicroMsg.JsApiOperateLocalServicesScan", localStringBuilder.toString());
    if (TextUtils.equals("start", str))
    {
      paramJSONObject = paramJSONObject.optString("serviceType");
      if (TextUtils.isEmpty(paramJSONObject))
      {
        paramc.a(paramInt, b("fail:invalid param"));
        return;
      }
      a(paramc, paramJSONObject, paramInt);
      return;
    }
    if (TextUtils.equals("stop", str))
    {
      a(paramc, paramInt);
      return;
    }
    paramc.a(paramInt, b("fail:invalid param"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ld.f
 * JD-Core Version:    0.7.0.1
 */