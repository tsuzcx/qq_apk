package com.tencent.luggage.wxa.ox;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a
{
  private final Map<String, List<c>> a = new HashMap();
  
  public static a a()
  {
    return a.a.a();
  }
  
  private void a(String paramString, @NonNull a.b paramb)
  {
    paramString = (List)this.a.get(paramString);
    if (paramString == null) {
      return;
    }
    int i = 0;
    while (i < paramString.size())
    {
      paramb.a((c)paramString.get(i));
      i += 1;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, new a.2(this, paramString2, paramString3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ox.a
 * JD-Core Version:    0.7.0.1
 */