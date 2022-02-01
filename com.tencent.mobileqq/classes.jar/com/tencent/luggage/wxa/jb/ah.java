package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.ad;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.jf.a.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;

public class ah
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    o.d("MicroMsg.SetTextBaselineAction", "SetTextBaselineAction, align:%s", new Object[] { paramString });
    if ("top".equalsIgnoreCase(paramString))
    {
      paramd.e().a(a.a.b);
      paramd.h().a(a.a.b);
      return true;
    }
    if ("middle".equalsIgnoreCase(paramString))
    {
      paramd.e().a(a.a.d);
      paramd.h().a(a.a.d);
      return true;
    }
    if ("bottom".equalsIgnoreCase(paramString))
    {
      paramd.e().a(a.a.c);
      paramd.h().a(a.a.c);
      return true;
    }
    if ("normal".equalsIgnoreCase(paramString))
    {
      paramd.e().a(a.a.a);
      paramd.h().a(a.a.a);
    }
    return true;
  }
  
  public String a()
  {
    return "setTextBaseline";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (ad)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.b);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 1) {
      return false;
    }
    return a(paramd, paramJSONArray.optString(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ah
 * JD-Core Version:    0.7.0.1
 */