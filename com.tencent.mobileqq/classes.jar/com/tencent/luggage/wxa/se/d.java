package com.tencent.luggage.wxa.se;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.luggage.wxa.sc.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d a = new d();
  private static final ConcurrentHashMap<Looper, WeakReference<Handler>> c = new ConcurrentHashMap();
  private final Looper b;
  
  private d()
  {
    HandlerThread localHandlerThread = c.b("TP#Internal");
    localHandlerThread.setPriority(8);
    localHandlerThread.start();
    this.b = localHandlerThread.getLooper();
  }
  
  public static Handler a(String paramString, Handler.Callback paramCallback)
  {
    paramString = new d.a(paramString, a.b, paramCallback);
    c.put(a.b, new WeakReference(paramString));
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.se.d
 * JD-Core Version:    0.7.0.1
 */