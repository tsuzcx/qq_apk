package com.tencent.luggage.wxa.qa;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;

public abstract class e
{
  String a;
  h b;
  d c;
  @Nullable
  protected volatile f d;
  private e.a e;
  private int f = -1;
  
  public e(@NonNull String paramString, @NonNull d paramd)
  {
    this.a = paramString;
    this.c = paramd;
  }
  
  public e(@NonNull String paramString, @NonNull d paramd, h paramh)
  {
    this.a = paramString;
    this.b = paramh;
    this.c = paramd;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    f localf = this.d;
    if (localf != null) {
      localf.a(paramBitmap, this);
    }
  }
  
  public void a(e.a parama)
  {
    this.e = parama;
  }
  
  public void a(@Nullable f paramf)
  {
    this.d = paramf;
  }
  
  @Nullable
  public e.a b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public String d()
  {
    String str = this.a;
    if ((str != null) && (!str.isEmpty())) {
      return this.a;
    }
    return null;
  }
  
  public void e()
  {
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.e
 * JD-Core Version:    0.7.0.1
 */