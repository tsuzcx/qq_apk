package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.text.TextUtils;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.p;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONException;

public class r
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramd.e().a(paramString);
      paramd.h().a(paramString);
      return true;
    }
    return false;
  }
  
  public String a()
  {
    return "setFontFamily";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (p)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.b);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getString(0);
      return a(paramd, paramCanvas);
    }
    catch (JSONException paramd)
    {
      label22:
      break label22;
    }
    o.d("MicroMsg.SetFontFamily", "get 'fontFamily' error.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.r
 * JD-Core Version:    0.7.0.1
 */