package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.Paint.Align;
import com.tencent.luggage.wxa.jc.ac;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jf.a;
import org.json.JSONArray;

public class ag
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    if ("left".equalsIgnoreCase(paramString))
    {
      paramd.e().setTextAlign(Paint.Align.LEFT);
      paramd.h().setTextAlign(Paint.Align.LEFT);
    }
    else if ("right".equalsIgnoreCase(paramString))
    {
      paramd.e().setTextAlign(Paint.Align.RIGHT);
      paramd.h().setTextAlign(Paint.Align.RIGHT);
    }
    else if ("center".equalsIgnoreCase(paramString))
    {
      paramd.e().setTextAlign(Paint.Align.CENTER);
      paramd.h().setTextAlign(Paint.Align.CENTER);
    }
    return true;
  }
  
  public String a()
  {
    return "setTextAlign";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (ac)com.tencent.luggage.wxa.pc.d.a(paramc);
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
 * Qualified Name:     com.tencent.luggage.wxa.jb.ag
 * JD-Core Version:    0.7.0.1
 */