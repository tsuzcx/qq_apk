package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import android.graphics.Path.Direction;
import com.tencent.luggage.wxa.pc.d;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class j
  implements a
{
  private boolean a(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramPath.addRect(paramFloat1, paramFloat2, paramFloat1 + paramFloat3, paramFloat2 + paramFloat4, Path.Direction.CW);
    return true;
  }
  
  public String a()
  {
    return "rect";
  }
  
  public boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    parama = (com.tencent.luggage.wxa.jd.j)d.a(parama);
    if (parama == null) {
      return false;
    }
    return a(paramPath, parama.b, parama.c, parama.d, parama.e);
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
 * Qualified Name:     com.tencent.luggage.wxa.jg.j
 * JD-Core Version:    0.7.0.1
 */