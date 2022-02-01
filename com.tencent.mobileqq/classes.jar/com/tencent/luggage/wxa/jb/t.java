package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.r;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONException;

public class t
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, String paramString)
  {
    int i = paramString.hashCode();
    if (i != -1657669071)
    {
      if (i != -1178781136)
      {
        if ((i == -1039745817) && (paramString.equals("normal")))
        {
          i = 2;
          break label70;
        }
      }
      else if (paramString.equals("italic"))
      {
        i = 1;
        break label70;
      }
    }
    else if (paramString.equals("oblique"))
    {
      i = 0;
      break label70;
    }
    i = -1;
    label70:
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return true;
        }
        paramd.e().a(0);
        paramd.h().a(0);
        return true;
      }
      paramd.e().a(2);
      paramd.h().a(2);
      return true;
    }
    paramd.e().a(2);
    paramd.h().a(2);
    return true;
  }
  
  public String a()
  {
    return "setFontStyle";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (r)com.tencent.luggage.wxa.pc.d.a(paramc);
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
    o.d("MicroMsg.SetFontStyle", "get 'fontStyle' error.");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.t
 * JD-Core Version:    0.7.0.1
 */