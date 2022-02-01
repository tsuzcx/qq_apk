package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import com.tencent.luggage.wxa.jd.f;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class d
  implements a
{
  private boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    paramPath.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
    return true;
  }
  
  public String a()
  {
    return "bezierCurveTo";
  }
  
  public boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    parama = (f)com.tencent.luggage.wxa.pc.d.a(parama);
    if (parama == null) {
      return false;
    }
    return a(paramPath, parama.b, parama.c, parama.d, parama.e, parama.f, parama.g);
  }
  
  public boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 6) {
      return false;
    }
    return a(paramPath, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3), g.d(paramJSONArray, 4), g.d(paramJSONArray, 5));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jg.d
 * JD-Core Version:    0.7.0.1
 */