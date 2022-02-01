package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.y;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class ab
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, float paramFloat)
  {
    paramd.h().setStrokeWidth(paramFloat);
    paramd.e().setStrokeWidth(paramFloat);
    return true;
  }
  
  public String a()
  {
    return "setLineWidth";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (y)com.tencent.luggage.wxa.pc.d.a(paramc);
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
    return a(paramd, g.d(paramJSONArray, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ab
 * JD-Core Version:    0.7.0.1
 */