package com.tencent.luggage.wxa.jp;

import android.net.http.AndroidHttpClient;
import android.text.TextUtils;
import com.tencent.luggage.wxa.jm.a;
import com.tencent.luggage.wxa.jn.d;
import com.tencent.luggage.wxa.jr.b;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

public class i
{
  private static i a;
  private MulticastSocket b;
  private InetAddress c;
  private int d = -1;
  
  private i(boolean paramBoolean)
  {
    try
    {
      this.c = InetAddress.getByName("239.255.255.250");
      if (paramBoolean)
      {
        this.b = new MulticastSocket();
        this.b.setBroadcast(true);
        this.d = this.b.getLocalPort();
        return;
      }
    }
    catch (IOException localIOException)
    {
      a.a("TransporterImpl", localIOException, "");
    }
  }
  
  public static i a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new i(true);
        }
      }
      finally {}
    }
    return a;
  }
  
  public static i b()
  {
    return new i(false);
  }
  
  private void b(d paramd)
  {
    if (this.b == null)
    {
      this.b = new MulticastSocket();
      this.b.setBroadcast(true);
      this.d = this.b.getLocalPort();
    }
    paramd = paramd.b().getBytes();
    paramd = new DatagramPacket(paramd, paramd.length, this.c, 1900);
    this.b.send(paramd);
    this.b.close();
  }
  
  private void c(d paramd)
  {
    paramd = paramd.b().getBytes();
    paramd = new DatagramPacket(paramd, paramd.length, this.c, 1900);
    this.b.send(paramd);
  }
  
  public com.tencent.luggage.wxa.jr.e a(com.tencent.luggage.wxa.jn.e parame)
  {
    Object localObject1 = null;
    try
    {
      AndroidHttpClient localAndroidHttpClient = AndroidHttpClient.newInstance("");
      localObject1 = localAndroidHttpClient;
      Object localObject2 = new i.a(parame.f(), parame.d());
      localObject1 = localAndroidHttpClient;
      Object localObject3 = parame.e();
      Map.Entry localEntry;
      if (localObject3 != null)
      {
        localObject1 = localAndroidHttpClient;
        if (!((Map)localObject3).isEmpty())
        {
          localObject1 = localAndroidHttpClient;
          localObject3 = ((Map)localObject3).entrySet().iterator();
          for (;;)
          {
            localObject1 = localAndroidHttpClient;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject1 = localAndroidHttpClient;
            localEntry = (Map.Entry)((Iterator)localObject3).next();
            localObject1 = localAndroidHttpClient;
            ((i.a)localObject2).addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
          }
        }
      }
      localObject1 = localAndroidHttpClient;
      parame = parame.b();
      localObject1 = localAndroidHttpClient;
      boolean bool = TextUtils.isEmpty(parame);
      if (!bool)
      {
        localObject1 = localAndroidHttpClient;
        parame = new StringEntity(parame, "utf-8");
        localObject1 = localAndroidHttpClient;
        parame.setContentType("text/xml; charset=\"utf-8\"");
        localObject1 = localAndroidHttpClient;
        ((i.a)localObject2).setEntity(parame);
      }
      localObject1 = localAndroidHttpClient;
      parame = localAndroidHttpClient.execute((HttpUriRequest)localObject2);
      localObject1 = localAndroidHttpClient;
      localAndroidHttpClient.close();
      int i = 0;
      localObject1 = localAndroidHttpClient;
      localObject2 = new com.tencent.luggage.wxa.jr.e(false);
      localObject1 = localAndroidHttpClient;
      ((com.tencent.luggage.wxa.jr.e)localObject2).b = new b();
      localObject1 = localAndroidHttpClient;
      localObject3 = parame.getAllHeaders();
      localObject1 = localAndroidHttpClient;
      int j = localObject3.length;
      while (i < j)
      {
        localEntry = localObject3[i];
        localObject1 = localAndroidHttpClient;
        ((com.tencent.luggage.wxa.jr.e)localObject2).b.a(localEntry.getName(), localEntry.getValue());
        i += 1;
      }
      localObject1 = localAndroidHttpClient;
      localObject3 = EntityUtils.toString(parame.getEntity(), "utf-8").replaceAll("&(?!amp;)", "&amp;");
      localObject1 = localAndroidHttpClient;
      ((com.tencent.luggage.wxa.jr.e)localObject2).c = j.a().b((String)localObject3);
      localObject1 = localAndroidHttpClient;
      ((com.tencent.luggage.wxa.jr.e)localObject2).a = parame.getStatusLine().getStatusCode();
      return localObject2;
    }
    catch (IOException parame)
    {
      if (localObject1 != null) {
        localObject1.close();
      }
      a.b("TransporterImpl", parame.toString());
    }
    for (;;)
    {
      throw parame;
    }
  }
  
  public void a(d paramd)
  {
    if (this == a)
    {
      c(paramd);
      return;
    }
    b(paramd);
  }
  
  public int c()
  {
    return this.d;
  }
  
  protected void finalize()
  {
    if (this == a) {
      this.b.close();
    }
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.i
 * JD-Core Version:    0.7.0.1
 */