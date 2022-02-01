package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.w;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;
import org.json.JSONException;

public class y
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((paramArrayOfFloat != null) && (paramFloat != 1.4E-45F)) {
      paramd.e().setPathEffect(new DashPathEffect(paramArrayOfFloat, paramFloat));
    }
    return true;
  }
  
  public String a()
  {
    return "setLineDash";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramCanvas = (w)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramCanvas == null) {
      return false;
    }
    return a(paramd, paramCanvas.b, paramCanvas.c);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    try
    {
      paramCanvas = paramJSONArray.getJSONArray(0);
      if (paramCanvas == null) {
        return false;
      }
      float[] arrayOfFloat = new float[paramCanvas.length()];
      int i = 0;
      while (i < arrayOfFloat.length)
      {
        arrayOfFloat[i] = g.d(paramCanvas, i);
        i += 1;
      }
      float f = g.d(paramJSONArray, 1);
      return a(paramd, arrayOfFloat, f);
    }
    catch (JSONException paramd) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.y
 * JD-Core Version:    0.7.0.1
 */