package com.tencent.luggage.wxa.jg;

import android.graphics.Path;
import com.tencent.luggage.wxa.pc.d;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class h
  implements a
{
  private boolean a(Path paramPath, float paramFloat1, float paramFloat2)
  {
    paramPath.moveTo(paramFloat1, paramFloat2);
    return true;
  }
  
  public String a()
  {
    return "moveTo";
  }
  
  public boolean a(Path paramPath, com.tencent.luggage.wxa.jd.a parama)
  {
    parama = (com.tencent.luggage.wxa.jd.h)d.a(parama);
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
    return a(paramPath, g.d(paramJSONArray, 0), g.d(paramJSONArray, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jg.h
 * JD-Core Version:    0.7.0.1
 */