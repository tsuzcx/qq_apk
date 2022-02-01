package com.tencent.luggage.wxa.iw;

import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appcache.v.a;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Map;

public abstract interface a
  extends Closeable
{
  public abstract int a();
  
  public abstract Map<String, v.a> a(FileChannel paramFileChannel, i parami);
  
  public abstract boolean a(v.a parama);
  
  public abstract boolean a(FileChannel paramFileChannel);
  
  public abstract int b();
  
  public abstract InputStream b(v.a parama);
  
  public abstract int c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iw.a
 * JD-Core Version:    0.7.0.1
 */