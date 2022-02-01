package com.tencent.luggage.wxa.hg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import com.tencent.luggage.wxa.qz.r;

public class a
{
  private Context a = null;
  private a.b b = null;
  private final String c = "audio_lock";
  
  public a(Context paramContext)
  {
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = r.a();
    }
    this.a = localContext;
    c();
  }
  
  @TargetApi(8)
  private void c()
  {
    com.tencent.luggage.wxa.hb.a.a(8, new a.1(this));
  }
  
  public void a(a.a parama)
  {
    a.b localb = this.b;
    if (localb != null) {
      localb.a(parama);
    }
  }
  
  public boolean a()
  {
    try
    {
      if (this.b == null) {
        return false;
      }
      boolean bool = this.b.a();
      return bool;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      if (this.b == null) {
        return false;
      }
      boolean bool = this.b.b();
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hg.a
 * JD-Core Version:    0.7.0.1
 */