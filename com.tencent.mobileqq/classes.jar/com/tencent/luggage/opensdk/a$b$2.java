package com.tencent.luggage.opensdk;

import androidx.annotation.NonNull;
import java.util.Comparator;

class a$b$2
  implements Comparator<Runnable>
{
  a$b$2(a.b paramb) {}
  
  public int a(@NonNull Runnable paramRunnable1, @NonNull Runnable paramRunnable2)
  {
    return paramRunnable1.hashCode() - paramRunnable2.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.a.b.2
 * JD-Core Version:    0.7.0.1
 */