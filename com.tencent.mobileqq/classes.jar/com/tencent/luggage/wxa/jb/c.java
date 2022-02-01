package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Path;
import com.tencent.luggage.wxa.jg.e;
import org.json.JSONArray;

public class c
  implements d
{
  private boolean a(Canvas paramCanvas, Path paramPath)
  {
    paramCanvas.clipPath(paramPath);
    return true;
  }
  
  public String a()
  {
    return "clipPath";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, com.tencent.luggage.wxa.jc.c paramc)
  {
    return a(paramCanvas, e.a().a((com.tencent.luggage.wxa.jd.c)com.tencent.luggage.wxa.pc.d.a(paramc)));
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    return a(paramCanvas, e.a().a(paramJSONArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.c
 * JD-Core Version:    0.7.0.1
 */