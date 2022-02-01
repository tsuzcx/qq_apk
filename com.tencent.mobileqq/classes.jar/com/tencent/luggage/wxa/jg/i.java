package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import com.tencent.luggage.wxa.pc.d;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class i
  implements a
{
  private boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramPath.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return true;
  }
  
  public String a()
  {
    return "quadraticCurveTo";
  }
  
  public boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    com.tencent.luggage.wxa.jd.i locali = (com.tencent.luggage.wxa.jd.i)d.a(parama);
    if (parama == null) {
      return false;
    }
    return a(paramPath, locali.b, locali.c, locali.d, locali.e);
  }
  
  public boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 4) {
      return false;
    }
    return a(paramPath, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jg.i
 * JD-Core Version:    0.7.0.1
 */