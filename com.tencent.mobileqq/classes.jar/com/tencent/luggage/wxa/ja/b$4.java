package com.tencent.luggage.wxa.ja;

import com.tencent.luggage.wxa.ji.b.a;
import org.json.JSONArray;

class b$4
  implements Runnable
{
  b$4(b paramb, JSONArray paramJSONArray, b.a parama) {}
  
  public void run()
  {
    b.b(this.c, true);
    if (b.e(this.c) == null)
    {
      b.a(this.c, this.a);
    }
    else
    {
      int i = 0;
      while (i < this.a.length())
      {
        b.e(this.c).put(this.a.opt(i));
        i += 1;
      }
    }
    b.c(this.c, true);
    b.a locala = this.b;
    if (locala != null) {
      locala.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ja.b.4
 * JD-Core Version:    0.7.0.1
 */