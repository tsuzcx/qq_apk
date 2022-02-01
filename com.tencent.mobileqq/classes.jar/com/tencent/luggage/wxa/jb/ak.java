package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.af;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class ak
  implements d
{
  private boolean a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    paramCanvas.translate(paramFloat1, paramFloat2);
    return true;
  }
  
  public String a()
  {
    return "translate";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramd = (af)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramd == null) {
      return false;
    }
    return a(paramCanvas, paramd.b, paramd.c);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    return a(paramCanvas, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ak
 * JD-Core Version:    0.7.0.1
 */