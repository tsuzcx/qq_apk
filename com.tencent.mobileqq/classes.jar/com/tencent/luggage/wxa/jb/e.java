package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.RectF;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class e
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    RectF localRectF = new RectF(paramFloat1 - paramFloat3, paramFloat2 - paramFloat3, paramFloat1 + paramFloat3, paramFloat2 + paramFloat3);
    double d = paramFloat4;
    Double.isNaN(d);
    paramFloat1 = (float)(d / 3.141592653589793D * 180.0D);
    d = paramFloat5;
    Double.isNaN(d);
    paramCanvas.drawArc(localRectF, paramFloat1, (float)(d / 3.141592653589793D * 180.0D), true, paramd.e());
    return true;
  }
  
  public String a()
  {
    return "arc";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (com.tencent.luggage.wxa.jc.e)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramc == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramc.b, paramc.c, paramc.d, paramc.e, paramc.f);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 5) {
      return false;
    }
    return a(paramd, paramCanvas, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), (float)paramJSONArray.optDouble(3), (float)paramJSONArray.optDouble(4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.e
 * JD-Core Version:    0.7.0.1
 */