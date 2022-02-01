package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.aa;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class ae
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    paramd.h().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    paramd.e().setShadowLayer(paramFloat3, paramFloat1, paramFloat2, paramInt);
    return true;
  }
  
  public String a()
  {
    return "setShadow";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (aa)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.b, paramCanvas.c, paramCanvas.d, paramCanvas.e);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 4) {
      return false;
    }
    float f1 = g.d(paramJSONArray, 0);
    float f2 = g.d(paramJSONArray, 1);
    float f3 = g.d(paramJSONArray, 2);
    paramCanvas = paramJSONArray.optJSONArray(3);
    if (paramCanvas != null)
    {
      if (paramCanvas.length() < 4) {
        return false;
      }
      return a(paramd, f1, f2, f3, g.a(paramCanvas));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ae
 * JD-Core Version:    0.7.0.1
 */