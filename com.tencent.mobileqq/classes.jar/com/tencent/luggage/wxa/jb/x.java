package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Paint.Cap;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.v;
import com.tencent.luggage.wxa.jf.a;
import org.json.JSONArray;

public class x
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    if ("butt".equalsIgnoreCase(paramString))
    {
      paramd.h().setStrokeCap(Paint.Cap.BUTT);
      paramd.e().setStrokeCap(Paint.Cap.BUTT);
    }
    else if ("round".equalsIgnoreCase(paramString))
    {
      paramd.h().setStrokeCap(Paint.Cap.ROUND);
      paramd.e().setStrokeCap(Paint.Cap.ROUND);
    }
    else if ("square".equalsIgnoreCase(paramString))
    {
      paramd.h().setStrokeCap(Paint.Cap.SQUARE);
      paramd.e().setStrokeCap(Paint.Cap.SQUARE);
    }
    return true;
  }
  
  public String a()
  {
    return "setLineCap";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (v)com.tencent.luggage.wxa.pc.d.a(paramc);
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
    return a(paramd, paramJSONArray.optString(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.x
 * JD-Core Version:    0.7.0.1
 */