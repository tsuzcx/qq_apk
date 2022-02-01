package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener;

public abstract interface g
  extends TXLivePusher.VideoCustomProcessListener
{
  public static final g a = new g.1();
  
  public abstract void a(g.a parama, float paramFloat);
  
  public abstract void a(g.b paramb, String paramString);
  
  public abstract void a(g.c paramc, String paramString);
  
  public abstract void a(String paramString, float paramFloat);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
 * JD-Core Version:    0.7.0.1
 */