package com.tencent.luggage.wxa.jb;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import com.tencent.luggage.wxa.jc.ab;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class af
  implements d
{
  public String a()
  {
    return "setStrokeStyle";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (ab)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramc == null) {
      return false;
    }
    return paramc.a(paramd, paramCanvas);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    if (paramJSONArray.length() < 2) {
      return false;
    }
    paramCanvas = paramJSONArray.optString(0);
    float f1;
    float f2;
    float f3;
    float[] arrayOfFloat;
    int i;
    JSONArray localJSONArray;
    if ("linear".equalsIgnoreCase(paramCanvas))
    {
      if (paramJSONArray.length() < 3) {
        return false;
      }
      paramCanvas = paramJSONArray.optJSONArray(1);
      if (paramCanvas != null)
      {
        if (paramCanvas.length() < 4) {
          return false;
        }
        f1 = g.d(paramCanvas, 0);
        f2 = g.d(paramCanvas, 1);
        f3 = g.d(paramCanvas, 2);
        float f4 = g.d(paramCanvas, 3);
        paramCanvas = paramJSONArray.optJSONArray(2);
        if (paramCanvas != null)
        {
          if (paramCanvas.length() == 0) {
            return false;
          }
          paramJSONArray = new int[paramCanvas.length()];
          arrayOfFloat = new float[paramCanvas.length()];
          i = 0;
          while (i < paramCanvas.length())
          {
            localJSONArray = paramCanvas.optJSONArray(i);
            if (localJSONArray.length() >= 2)
            {
              arrayOfFloat[i] = ((float)localJSONArray.optDouble(0));
              paramJSONArray[i] = g.a(localJSONArray.optJSONArray(1));
            }
            i += 1;
          }
          paramCanvas = new LinearGradient(f1, f2, f3, f4, paramJSONArray, arrayOfFloat, Shader.TileMode.CLAMP);
          paramd.e().setShader(paramCanvas);
          return true;
        }
      }
      return false;
    }
    if ("radial".equalsIgnoreCase(paramCanvas))
    {
      if (paramJSONArray.length() < 3) {
        return false;
      }
      paramCanvas = paramJSONArray.optJSONArray(1);
      if (paramCanvas != null)
      {
        if (paramCanvas.length() < 3) {
          return false;
        }
        f1 = g.d(paramCanvas, 1);
        f2 = g.d(paramCanvas, 2);
        f3 = g.d(paramCanvas, 3);
        paramCanvas = paramJSONArray.optJSONArray(2);
        paramJSONArray = new int[paramCanvas.length()];
        arrayOfFloat = new float[paramCanvas.length()];
        i = 0;
        while (i < paramCanvas.length())
        {
          localJSONArray = paramCanvas.optJSONArray(i);
          if (localJSONArray.length() >= 2)
          {
            arrayOfFloat[i] = ((float)localJSONArray.optDouble(0));
            paramJSONArray[i] = g.a(localJSONArray.optJSONArray(1));
          }
          i += 1;
        }
        paramCanvas = new RadialGradient(f1, f2, f3, paramJSONArray, arrayOfFloat, Shader.TileMode.CLAMP);
        paramd.e().setShader(paramCanvas);
        return true;
      }
      return false;
    }
    if ("normal".equalsIgnoreCase(paramCanvas))
    {
      paramCanvas = paramJSONArray.optJSONArray(1);
      if (paramCanvas != null)
      {
        if (paramCanvas.length() < 4) {
          return false;
        }
        paramd.e().setColor(g.a(paramCanvas));
        return true;
      }
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.af
 * JD-Core Version:    0.7.0.1
 */