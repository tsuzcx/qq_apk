package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Paint.Join;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.x;
import com.tencent.luggage.wxa.jf.a;
import org.json.JSONArray;

public class aa
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    if ("miter".equalsIgnoreCase(paramString))
    {
      paramd.h().setStrokeJoin(Paint.Join.MITER);
      paramd.e().setStrokeJoin(Paint.Join.MITER);
    }
    else if ("round".equalsIgnoreCase(paramString))
    {
      paramd.h().setStrokeJoin(Paint.Join.ROUND);
      paramd.e().setStrokeJoin(Paint.Join.ROUND);
    }
    else if ("bevel".equalsIgnoreCase(paramString))
    {
      paramd.h().setStrokeJoin(Paint.Join.BEVEL);
      paramd.e().setStrokeJoin(Paint.Join.BEVEL);
    }
    return true;
  }
  
  public String a()
  {
    return "setLineJoin";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (x)com.tencent.luggage.wxa.pc.d.a(paramc);
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
 * Qualified Name:     com.tencent.luggage.wxa.jb.aa
 * JD-Core Version:    0.7.0.1
 */