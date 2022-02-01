package com.tencent.mm.plugin.appbrand.jsapi.websocket;

import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Timer;

public abstract interface e
{
  public static final String a;
  
  public abstract void a(e.a parama);
  
  public abstract void a(String paramString, int paramInt);
  
  public abstract void a(Socket paramSocket);
  
  public abstract void a(Timer paramTimer);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a_(ByteBuffer paramByteBuffer);
  
  public abstract Timer b();
  
  public abstract void b(String paramString);
  
  public abstract void c();
  
  public abstract void c_(String paramString);
  
  public abstract boolean d();
  
  public abstract void e();
  
  public abstract Socket f();
  
  public abstract String v_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.websocket.e
 * JD-Core Version:    0.7.0.1
 */