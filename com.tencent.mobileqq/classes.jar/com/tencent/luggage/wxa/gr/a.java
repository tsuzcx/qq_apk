package com.tencent.luggage.wxa.gr;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class a
  implements f
{
  private volatile HashMap<String, c> a = new HashMap();
  private volatile LinkedList<String> b = new LinkedList();
  private volatile ArrayList<String> c = new ArrayList();
  private Object d = new Object();
  private f.a e;
  
  public void a(f.a parama)
  {
    this.e = parama;
  }
  
  public boolean a(com.tencent.luggage.wxa.if.b paramb)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Audio.AudioDownloadMgr", "startDownload");
    if (paramb == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Audio.AudioDownloadMgr", "param is null");
      return false;
    }
    if (TextUtils.isEmpty(paramb.b))
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Audio.AudioDownloadMgr", "srcUrl is null");
      return false;
    }
    if (this.c.contains(paramb.b))
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Audio.AudioDownloadMgr", "srcUrl:%s is download finish", new Object[] { paramb.b });
      return false;
    }
    if (this.a.containsKey(paramb.b))
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Audio.AudioDownloadMgr", "task is exit!");
      return true;
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Audio.AudioDownloadMgr", "download src:%s, audioId:%s", new Object[] { paramb.b, paramb.a });
    c localc = new c(new b(new a.1(this)), paramb.a, 5);
    localc.a(b(paramb));
    d.a(localc);
    synchronized (this.d)
    {
      this.a.put(paramb.b, localc);
      this.b.add(paramb.b);
      return true;
    }
  }
  
  protected com.tencent.luggage.wxa.gv.c b(com.tencent.luggage.wxa.if.b paramb)
  {
    return new com.tencent.luggage.wxa.gv.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gr.a
 * JD-Core Version:    0.7.0.1
 */