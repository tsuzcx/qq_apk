package com.tencent.luggage.wxa.bd;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.jl.a.a;
import com.tencent.luggage.wxa.jl.a.c;
import java.util.Map;

public abstract class a
  implements a.a
{
  public void a(String paramString, a.c paramc)
  {
    a(paramString, null, paramc);
  }
  
  public void a(String paramString, @Nullable Map<String, String> paramMap, a.c paramc)
  {
    a(paramString, paramc);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a.a)) {
      return false;
    }
    if (a().equalsIgnoreCase(((a.a)paramObject).a())) {
      return true;
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bd.a
 * JD-Core Version:    0.7.0.1
 */