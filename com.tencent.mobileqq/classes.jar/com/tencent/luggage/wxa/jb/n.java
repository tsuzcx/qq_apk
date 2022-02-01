package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.l;
import org.json.JSONArray;

public class n
  implements d
{
  private boolean a(Canvas paramCanvas, float paramFloat)
  {
    double d = paramFloat;
    Double.isNaN(d);
    paramCanvas.rotate((float)(d / 3.141592653589793D * 180.0D));
    return true;
  }
  
  public String a()
  {
    return "rotate";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramd = (l)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramd == null) {
      return false;
    }
    return a(paramCanvas, paramd.b);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 1) {
      return false;
    }
    return a(paramCanvas, (float)paramJSONArray.optDouble(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.n
 * JD-Core Version:    0.7.0.1
 */