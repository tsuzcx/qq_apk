package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.s;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONException;

public class u
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1039745817)
    {
      if ((i == 3029637) && (paramString.equals("bold")))
      {
        i = 0;
        break label50;
      }
    }
    else if (paramString.equals("normal"))
    {
      i = 1;
      break label50;
    }
    i = -1;
    label50:
    if (i != 0)
    {
      if (i != 1) {
        return true;
      }
      paramd.e().setFakeBoldText(false);
      paramd.h().setFakeBoldText(false);
      return true;
    }
    paramd.e().setFakeBoldText(true);
    paramd.h().setFakeBoldText(true);
    return true;
  }
  
  public String a()
  {
    return "setFontWeight";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (s)com.tencent.luggage.wxa.pc.d.a(paramc);
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
    o.d("MicroMsg.SetFontWeight", "get 'fontWeight' error.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.u
 * JD-Core Version:    0.7.0.1
 */