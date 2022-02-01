package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.n;
import com.tencent.luggage.wxa.jf.a;
import org.json.JSONArray;

public class ac
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, float paramFloat)
  {
    paramd.h().setStrokeMiter(paramFloat);
    paramd.e().setStrokeMiter(paramFloat);
    return true;
  }
  
  public String a()
  {
    return "setMiterLimit";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (n)com.tencent.luggage.wxa.pc.d.a(paramc);
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
    return a(paramd, (float)paramJSONArray.optDouble(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ac
 * JD-Core Version:    0.7.0.1
 */