package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import com.tencent.luggage.wxa.pc.d;
import org.json.JSONArray;

public class g
  implements a
{
  private boolean a(Path paramPath, float paramFloat1, float paramFloat2)
  {
    paramPath.lineTo(paramFloat1, paramFloat2);
    return true;
  }
  
  public String a()
  {
    return "lineTo";
  }
  
  public boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    parama = (com.tencent.luggage.wxa.jd.g)d.a(parama);
    if (parama == null) {
      return false;
    }
    return a(paramPath, parama.b, parama.c);
  }
  
  public boolean a(Path paramPath, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    return a(paramPath, com.tencent.luggage.wxa.pc.g.d(paramJSONArray, 0), com.tencent.luggage.wxa.pc.g.d(paramJSONArray, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jg.g
 * JD-Core Version:    0.7.0.1
 */