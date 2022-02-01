package com.tencent.luggage.wxa.hp;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hr.b;
import junit.framework.a;

public class e<T>
{
  private volatile T a;
  private Class<T> b;
  
  public e(@NonNull Class<T> paramClass)
  {
    a.a(paramClass);
    this.b = paramClass;
  }
  
  public T a()
  {
    if (this.a == null) {
      try
      {
        if (this.a == null) {
          this.a = b.a(this.b);
        }
      }
      finally {}
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hp.e
 * JD-Core Version:    0.7.0.1
 */