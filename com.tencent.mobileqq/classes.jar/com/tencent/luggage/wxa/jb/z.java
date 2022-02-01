package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;
import org.json.JSONException;

@Deprecated
public class z
  implements d
{
  public String a()
  {
    return "setLineHeight";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    return false;
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() == 0) {
      return false;
    }
    try
    {
      g.b(paramJSONArray, 0);
      return false;
    }
    catch (JSONException paramd)
    {
      label17:
      break label17;
    }
    o.d("MicroMsg.SetLineHeight", "get 'lineHeight' error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.z
 * JD-Core Version:    0.7.0.1
 */