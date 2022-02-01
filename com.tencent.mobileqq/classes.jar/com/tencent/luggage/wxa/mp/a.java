package com.tencent.luggage.wxa.mp;

import android.annotation.TargetApi;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.luggage.wxa.pc.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@TargetApi(5)
public abstract class a
  implements e
{
  private final h<String, e.c> a = new h();
  
  private void a(@NonNull Consumer<e.c> paramConsumer)
  {
    Iterator localIterator1 = this.a.a().values().iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((Collection)localIterator1.next()).iterator();
      while (localIterator2.hasNext()) {
        paramConsumer.accept((e.c)localIterator2.next());
      }
    }
  }
  
  protected void a()
  {
    a(new a.1(this));
  }
  
  public final void a(String paramString)
  {
    this.a.b(paramString);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2)
  {
    a(new a.4(this, paramString, paramInt1, paramInt2));
  }
  
  public final void a(String paramString, e.c paramc)
  {
    this.a.a(paramString, paramc);
  }
  
  protected void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    a(new a.5(this, paramArrayOfByte, paramBoolean));
  }
  
  protected void b()
  {
    a(new a.2(this));
  }
  
  public final void b(String paramString, e.c paramc)
  {
    this.a.b(paramString, paramc);
  }
  
  protected void c()
  {
    a(new a.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mp.a
 * JD-Core Version:    0.7.0.1
 */