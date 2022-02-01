package com.tencent.luggage.scanner.camera;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c
{
  private static c c;
  private ExecutorService a = Executors.newSingleThreadExecutor();
  private Handler b = new Handler(Looper.getMainLooper());
  
  public static c a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new c();
        }
      }
      finally {}
    }
    return c;
  }
  
  public void a(b.a parama)
  {
    this.a.submit(new c.4(this, parama));
  }
  
  public void a(b.b paramb, b.b.a parama)
  {
    this.a.submit(new c.1(this, paramb, parama));
  }
  
  public void a(b.c paramc, b.c.a parama)
  {
    this.a.submit(new c.5(this, paramc, parama));
  }
  
  public void a(b.d paramd, b.d.a parama)
  {
    this.a.submit(new c.2(this, paramd, parama));
  }
  
  public void a(b.e parame)
  {
    this.a.submit(new c.3(this, parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.c
 * JD-Core Version:    0.7.0.1
 */