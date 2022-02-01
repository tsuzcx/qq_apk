package com.tencent.luggage.wxa.jb;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import com.tencent.luggage.wxa.ja.e;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jf.a;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONArray;

public class q
  implements d
{
  private static Shader a(Bitmap paramBitmap, String paramString)
  {
    int j = g.c(paramBitmap.getWidth());
    int k = g.c(paramBitmap.getHeight());
    switch (paramString.hashCode())
    {
    default: 
      break;
    case -436782905: 
      if (paramString.equals("repeat-y")) {
        i = 2;
      }
      break;
    case -436782906: 
      if (paramString.equals("repeat-x")) {
        i = 1;
      }
      break;
    case -724648153: 
      if (paramString.equals("no-repeat")) {
        i = 3;
      }
      break;
    case -934531685: 
      if (paramString.equals("repeat")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          paramString = Bitmap.createBitmap(j + 1, k + 1, Bitmap.Config.ARGB_8888);
          new Canvas(paramString).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
          return new BitmapShader(paramString, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }
        paramString = Bitmap.createBitmap(j + 1, k, Bitmap.Config.ARGB_8888);
        new Canvas(paramString).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
        return new BitmapShader(paramString, Shader.TileMode.CLAMP, Shader.TileMode.REPEAT);
      }
      paramString = Bitmap.createBitmap(j, k + 1, Bitmap.Config.ARGB_8888);
      new Canvas(paramString).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(0.0F, 0.0F, j, k), null);
      return new BitmapShader(paramString, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
    }
    return new BitmapShader(Bitmap.createScaledBitmap(paramBitmap, j, k, false), Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
  }
  
  public String a()
  {
    return "setFillStyle";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (com.tencent.luggage.wxa.jc.o)com.tencent.luggage.wxa.pc.d.a(paramc);
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
    Object localObject = paramJSONArray.optString(0);
    paramCanvas = paramd.h();
    float f1;
    float f2;
    float f3;
    int i;
    JSONArray localJSONArray;
    if ("linear".equalsIgnoreCase((String)localObject))
    {
      if (paramJSONArray.length() < 3) {
        return false;
      }
      paramd = paramJSONArray.optJSONArray(1);
      if (paramd != null)
      {
        if (paramd.length() < 4) {
          return false;
        }
        f1 = g.d(paramd, 0);
        f2 = g.d(paramd, 1);
        f3 = g.d(paramd, 2);
        float f4 = g.d(paramd, 3);
        paramd = paramJSONArray.optJSONArray(2);
        if (paramd != null)
        {
          if (paramd.length() == 0) {
            return false;
          }
          paramJSONArray = new int[paramd.length()];
          localObject = new float[paramd.length()];
          i = 0;
          while (i < paramd.length())
          {
            localJSONArray = paramd.optJSONArray(i);
            if (localJSONArray.length() >= 2)
            {
              localObject[i] = ((float)localJSONArray.optDouble(0));
              paramJSONArray[i] = g.a(localJSONArray.optJSONArray(1));
            }
            i += 1;
          }
          paramCanvas.setShader(new LinearGradient(f1, f2, f3, f4, paramJSONArray, (float[])localObject, Shader.TileMode.CLAMP));
          return true;
        }
      }
      return false;
    }
    if ("radial".equalsIgnoreCase((String)localObject))
    {
      if (paramJSONArray.length() < 3) {
        return false;
      }
      paramd = paramJSONArray.optJSONArray(1);
      if (paramd != null)
      {
        if (paramd.length() < 3) {
          return false;
        }
        f1 = g.d(paramd, 0);
        f2 = g.d(paramd, 1);
        f3 = g.d(paramd, 2);
        if (f3 <= 0.0F)
        {
          com.tencent.luggage.wxa.qz.o.d("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle(radial) failed, sr(%s) <= 0.", new Object[] { Float.valueOf(f3) });
          return false;
        }
        paramd = paramJSONArray.optJSONArray(2);
        paramJSONArray = new int[paramd.length()];
        localObject = new float[paramd.length()];
        i = 0;
        while (i < paramd.length())
        {
          localJSONArray = paramd.optJSONArray(i);
          if (localJSONArray.length() >= 2)
          {
            localObject[i] = ((float)localJSONArray.optDouble(0));
            paramJSONArray[i] = g.a(localJSONArray.optJSONArray(1));
          }
          i += 1;
        }
        paramCanvas.setShader(new RadialGradient(f1, f2, f3, paramJSONArray, (float[])localObject, Shader.TileMode.CLAMP));
        return true;
      }
      return false;
    }
    if ("normal".equalsIgnoreCase((String)localObject))
    {
      paramd = paramJSONArray.optJSONArray(1);
      if (paramd != null)
      {
        if (paramd.length() < 4) {
          return false;
        }
        paramCanvas.setShader(null);
        paramCanvas.setColor(g.a(paramd));
        return true;
      }
      return false;
    }
    if ("pattern".equalsIgnoreCase((String)localObject))
    {
      localObject = paramJSONArray.optString(1);
      paramJSONArray = paramJSONArray.optString(2);
      if (af.c((String)localObject))
      {
        com.tencent.luggage.wxa.qz.o.c("MicroMsg.Canvas.SetFillStyleAction", "setFillStyle failed, type is pattern but image path is null or nil.");
        return false;
      }
      paramd = paramd.j().a(paramd, (String)localObject);
      if ((paramd != null) && (!paramd.isRecycled())) {
        paramCanvas.setShader(a(paramd, paramJSONArray));
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.q
 * JD-Core Version:    0.7.0.1
 */