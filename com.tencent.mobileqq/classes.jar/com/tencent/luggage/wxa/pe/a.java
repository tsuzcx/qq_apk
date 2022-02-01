package com.tencent.luggage.wxa.pe;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e
{
  public static final c b = new c();
  private final e c = new b();
  private final AtomicBoolean d = new AtomicBoolean(false);
  
  private a() {}
  
  @NonNull
  public c a()
  {
    return this.c.a();
  }
  
  public void a(Context paramContext)
  {
    if (!this.d.getAndSet(true)) {
      this.c.a(paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pe.a
 * JD-Core Version:    0.7.0.1
 */