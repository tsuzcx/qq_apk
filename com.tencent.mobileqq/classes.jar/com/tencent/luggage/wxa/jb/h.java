package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import org.json.JSONArray;

public class h
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramCanvas.drawRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, paramd.e());
    return true;
  }
  
  public String a()
  {
    return "strokeRect";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (com.tencent.luggage.wxa.jc.g)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramc == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramc.b, paramc.c, paramc.d, paramc.e);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 4) {
      return false;
    }
    return a(paramd, paramCanvas, com.tencent.luggage.wxa.pc.g.d(paramJSONArray, 0), com.tencent.luggage.wxa.pc.g.d(paramJSONArray, 1), com.tencent.luggage.wxa.pc.g.d(paramJSONArray, 2), com.tencent.luggage.wxa.pc.g.d(paramJSONArray, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.h
 * JD-Core Version:    0.7.0.1
 */