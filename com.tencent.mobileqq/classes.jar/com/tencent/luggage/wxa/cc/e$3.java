package com.tencent.luggage.wxa.cc;

import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.ev;
import com.tencent.luggage.wxa.rl.b;
import java.util.HashMap;
import java.util.Map;

class e$3
  implements b<String, ev>
{
  e$3(e parame, Map paramMap) {}
  
  public String a(ev paramev)
  {
    String str = "fail";
    if (paramev == null) {
      return this.b.a("fail", this.a);
    }
    HashMap localHashMap = new HashMap();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramev.a.a);
    localHashMap.put("errCode", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramev.b);
    localHashMap.put("expireIn", ((StringBuilder)localObject).toString());
    localObject = this.b;
    if (paramev.a.a == 0) {
      str = "ok";
    }
    return ((e)localObject).a(str, localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cc.e.3
 * JD-Core Version:    0.7.0.1
 */