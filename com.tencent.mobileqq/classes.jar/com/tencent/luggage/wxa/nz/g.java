package com.tencent.luggage.wxa.nz;

import android.text.TextUtils;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public class g
{
  protected final ArrayList<String> a = new ArrayList();
  private int b;
  private final String c;
  private SSLContext d;
  private c e;
  private final ArrayList<h> f = new ArrayList();
  
  public g(c paramc)
  {
    this.e = paramc;
    paramc = (a)paramc.b(a.class);
    this.b = paramc.i;
    this.c = paramc.u;
    this.d = j.a(paramc);
  }
  
  private void a(g.a parama, int paramInt1, String paramString1, int paramInt2, String paramString2, HttpURLConnection paramHttpURLConnection)
  {
    a(paramString2, paramHttpURLConnection);
    parama.a(paramInt1, paramString1, paramInt2);
  }
  
  private void a(g.a parama, int paramInt, String paramString1, String paramString2, HttpURLConnection paramHttpURLConnection)
  {
    a(paramString2, paramHttpURLConnection);
    parama.a(paramInt, paramString1);
  }
  
  private void a(String paramString, HttpURLConnection paramHttpURLConnection)
  {
    c(paramString);
    if (paramHttpURLConnection != null) {
      try
      {
        paramHttpURLConnection.getInputStream().close();
        paramHttpURLConnection.disconnect();
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        o.a("MicroMsg.AppBrandNetworkUpload", paramHttpURLConnection, "removeTask Exception: id %s", new Object[] { paramString });
      }
    }
  }
  
  private void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    synchronized (this.f)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.l())) {
          this.f.remove(localh);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public h a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    synchronized (this.f)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        h localh = (h)localIterator.next();
        if (paramString.equals(localh.l())) {
          return localh;
        }
      }
      return null;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a()
  {
    synchronized (this.f)
    {
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a = false;
      }
      this.f.clear();
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt, String paramString1, String arg3, JSONObject paramJSONObject, Map<String, String> paramMap, ArrayList<String> paramArrayList, g.a parama, String paramString3, String paramString4, String paramString5)
  {
    String str1 = j.c(paramJSONObject.optString("url"));
    String str2 = paramJSONObject.optString("name");
    paramJSONObject = j.b(paramJSONObject);
    synchronized (this.f)
    {
      if (this.f.size() >= this.b)
      {
        parama.a(-1, "tasked refused max connected");
        o.d("MicroMsg.AppBrandNetworkUpload", "max connected mUploadTaskList.size():%d,mMaxUploadConcurrent:%d", new Object[] { Integer.valueOf(this.f.size()), Integer.valueOf(this.b) });
        return;
      }
      if (TextUtils.isEmpty(str2))
      {
        parama.a(-1, "fileName error");
        o.d("MicroMsg.AppBrandNetworkUpload", "fileName error");
        return;
      }
      paramString1 = new h(???, str1, str2, paramString5, paramInt, paramString1, parama);
      paramString1.a(paramJSONObject);
      paramString1.b(paramMap);
      paramString1.a(paramArrayList);
      paramString1.a = true;
      paramString1.b(paramString3);
      paramString1.c(paramString4);
      synchronized (this.f)
      {
        this.f.add(paramString1);
        com.tencent.luggage.wxa.rd.a.b(new g.b(this, paramString1), "appbrand_upload_thread");
        return;
      }
    }
  }
  
  public void a(h paramh)
  {
    if (paramh == null) {
      return;
    }
    this.a.add(paramh.l());
    paramh.a = false;
    a(paramh.l(), paramh.m());
  }
  
  public boolean b(String paramString)
  {
    return this.a.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nz.g
 * JD-Core Version:    0.7.0.1
 */