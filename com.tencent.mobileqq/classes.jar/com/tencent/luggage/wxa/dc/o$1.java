package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.qw.aa;
import com.tencent.luggage.wxa.qw.lv;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;

final class o$1
  implements b<lv, lv>
{
  o$1(String paramString1, String paramString2) {}
  
  public lv a(lv paramlv)
  {
    if (paramlv == null)
    {
      o.b("Luggage.WxaAttrSync", "syncPipeline wxaAttrSyncResponse fail");
      return null;
    }
    o.d("Luggage.WxaAttrSync", "syncPipeline appId:%s userName:%s wxaAttrSyncResponse errCode:%d errMsg:%s", new Object[] { this.a, this.b, Integer.valueOf(paramlv.z.a), paramlv.z.b });
    return paramlv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.o.1
 * JD-Core Version:    0.7.0.1
 */