package com.tencent.luggage.wxa.ku;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

abstract class b<T extends d>
  extends a
{
  static final ThreadPoolExecutor a = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque());
  private final T b;
  
  public b(@NonNull T paramT)
  {
    this.b = paramT;
    this.b.a(this);
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    a.submit(new b.1(this, paramc, paramJSONObject, paramInt));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.b
 * JD-Core Version:    0.7.0.1
 */