package com.tencent.luggage.widget.decoder;

import android.graphics.Bitmap.Config;
import androidx.annotation.NonNull;
import java.lang.reflect.Constructor;

public class a<T>
  implements b<T>
{
  private final Class<? extends T> a;
  private final Bitmap.Config b;
  
  public a(@NonNull Class<? extends T> paramClass)
  {
    this(paramClass, null);
  }
  
  public a(@NonNull Class<? extends T> paramClass, Bitmap.Config paramConfig)
  {
    this.a = paramClass;
    this.b = paramConfig;
  }
  
  @NonNull
  public T a()
  {
    if (this.b == null) {
      return this.a.newInstance();
    }
    return this.a.getConstructor(new Class[] { Bitmap.Config.class }).newInstance(new Object[] { this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.widget.decoder.a
 * JD-Core Version:    0.7.0.1
 */