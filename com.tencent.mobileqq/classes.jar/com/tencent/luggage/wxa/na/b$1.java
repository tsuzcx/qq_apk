package com.tencent.luggage.wxa.na;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class b$1
  implements Runnable
{
  b$1(String paramString, b.a parama) {}
  
  public void run()
  {
    if (!b.a().containsKey(this.a)) {
      b.a().put(this.a, new ArrayList());
    }
    ((List)b.a().get(this.a)).add(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.b.1
 * JD-Core Version:    0.7.0.1
 */