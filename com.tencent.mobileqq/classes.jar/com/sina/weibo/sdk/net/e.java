package com.sina.weibo.sdk.net;

import android.os.Bundle;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class e
  implements d
{
  private Bundle k = new Bundle();
  private Bundle l = new Bundle();
  private Map<String, Object<File>> m = new HashMap();
  private Map<String, byte[]> n = new HashMap();
  private int o;
  private int p;
  private String url;
  
  public e(e.a parama)
  {
    this.url = parama.url;
    this.k.putAll(parama.k);
    this.l.putAll(parama.l);
    this.m.putAll(parama.m);
    this.n.putAll(parama.n);
    this.o = parama.o;
    this.p = parama.p;
  }
  
  public final int getConnectTimeout()
  {
    return this.o;
  }
  
  public final Bundle getParams()
  {
    return this.k;
  }
  
  public final int getReadTimeout()
  {
    return this.p;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public final Bundle h()
  {
    return this.l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.net.e
 * JD-Core Version:    0.7.0.1
 */