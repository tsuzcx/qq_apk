package com.tencent.luggage.wxa.hj;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

public class j
{
  private static volatile j a;
  private Map<String, a> b = new HashMap();
  
  public static j a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new j();
        }
      }
      finally {}
    }
    return a;
  }
  
  public boolean a(@NonNull String paramString, @NonNull a parama)
  {
    if ((paramString != null) && (paramString.length() != 0) && (parama != null))
    {
      this.b.put(paramString, parama);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.j
 * JD-Core Version:    0.7.0.1
 */