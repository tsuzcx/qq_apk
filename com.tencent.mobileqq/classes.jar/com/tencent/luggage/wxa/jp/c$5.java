package com.tencent.luggage.wxa.jp;

import com.tencent.luggage.wxa.jr.d;
import java.util.Map;

class c$5
  implements c.a
{
  c$5(c paramc) {}
  
  public boolean a(d paramd)
  {
    String str1;
    int i;
    try
    {
      str1 = paramd.b.a("SID");
      localc = null;
      String str2 = paramd.a;
      i = -1;
      int j = str2.hashCode();
      if (j != -2006516997)
      {
        if ((j == -1725405015) && (str2.equals("rdcEvent"))) {
          i = 1;
        }
      }
      else if (str2.equals("avtEvent")) {
        i = 0;
      }
    }
    finally {}
    com.tencent.luggage.wxa.jr.c localc = (com.tencent.luggage.wxa.jr.c)c.b(this.a).get(str1);
    break label117;
    label98:
    localc = (com.tencent.luggage.wxa.jr.c)c.a(this.a).get(str1);
    for (;;)
    {
      label117:
      if ((localc != null) && (localc.c != null))
      {
        boolean bool = localc.c.a(paramd);
        return bool;
      }
      return true;
      if (i == 0) {
        break label98;
      }
      if (i == 1) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jp.c.5
 * JD-Core Version:    0.7.0.1
 */