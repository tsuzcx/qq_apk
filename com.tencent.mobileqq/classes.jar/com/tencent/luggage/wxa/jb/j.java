package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Path;
import com.tencent.luggage.wxa.jg.e;
import org.json.JSONArray;

public class j
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, Path paramPath)
  {
    paramCanvas.drawPath(paramPath, paramd.h());
    return true;
  }
  
  public String a()
  {
    return "fillPath";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, com.tencent.luggage.wxa.jc.c paramc)
  {
    return a(paramd, paramCanvas, e.a().a((com.tencent.luggage.wxa.jd.c)com.tencent.luggage.wxa.pc.d.a(paramc)));
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    return a(paramd, paramCanvas, e.a().a(paramJSONArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.j
 * JD-Core Version:    0.7.0.1
 */