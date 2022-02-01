package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
{
  private static final a a = new a();
  private ConcurrentHashMap<Integer, WeakReference<b>> b = new ConcurrentHashMap();
  private PhoneStateListener c = null;
  private Context d;
  
  public static a a()
  {
    return a;
  }
  
  private void a(int paramInt)
  {
    try
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        b localb = (b)((WeakReference)((Map.Entry)localIterator.next()).getValue()).get();
        if (localb != null) {
          localb.onCallStateChanged(paramInt);
        } else {
          localIterator.remove();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(Context paramContext)
  {
    if (this.c != null) {
      return;
    }
    this.d = paramContext.getApplicationContext();
    new Handler(Looper.getMainLooper()).post(new a.1(this));
  }
  
  public void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    try
    {
      this.b.put(Integer.valueOf(paramb.hashCode()), new WeakReference(paramb));
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    if ((this.c != null) && (this.d != null)) {
      new Handler(Looper.getMainLooper()).post(new a.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.a
 * JD-Core Version:    0.7.0.1
 */