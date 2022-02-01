package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.t;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONException;

public class v
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, int paramInt)
  {
    a locala = paramd.e();
    float f = paramInt / 255.0F;
    locala.a(f);
    paramd.h().a(f);
    return true;
  }
  
  public String a()
  {
    return "setGlobalAlpha";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (t)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.b);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    try
    {
      int i = paramJSONArray.getInt(0);
      return a(paramd, i);
    }
    catch (JSONException paramd)
    {
      o.b("MicroMsg.SetGlobalAlphaAction", "getGlobalAlpha value error. exception : %s", new Object[] { paramd });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.v
 * JD-Core Version:    0.7.0.1
 */