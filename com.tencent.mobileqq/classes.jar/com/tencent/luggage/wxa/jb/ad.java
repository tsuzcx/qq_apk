package com.tencent.luggage.wxa.jb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import com.tencent.luggage.wxa.ja.f;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.jc.z;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONArray;

public class ad
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramCanvas.isHardwareAccelerated())
    {
      if ((paramCanvas instanceof f))
      {
        ((f)paramCanvas).a(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4);
        o.f("MicroMsg.SetPixelsAction", "MCanvas.clearRect(x : %s, y : %s, w : %s, h : %s)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
      else if (paramd.g() != null)
      {
        paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.g());
        o.f("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
      else
      {
        o.f("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) failed", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      }
    }
    else if (paramd.g() != null)
    {
      paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.g());
      o.f("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with custom clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    else
    {
      paramCanvas.drawRect(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4, paramd.f());
      o.f("MicroMsg.SetPixelsAction", "clearRect(x : %s, y : %s, w : %s, h : %s) with default clearPaint", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    }
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return false;
      }
      paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new RectF(paramInt1, paramInt2, paramInt1 + paramInt3, paramInt2 + paramInt4), paramd.e());
      return true;
    }
    return false;
  }
  
  public String a()
  {
    return "__setPixels";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (z)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramc == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramc.f, paramc.b, paramc.c, paramc.d, paramc.e);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    int i = g.a(paramJSONArray, 0);
    int j = g.a(paramJSONArray, 1);
    int k = g.a(paramJSONArray, 2);
    int m = g.a(paramJSONArray, 3);
    try
    {
      paramJSONArray = (Bitmap)paramJSONArray.get(4);
      return a(paramd, paramCanvas, paramJSONArray, i, j, k, m);
    }
    catch (Exception paramd)
    {
      o.c("MicroMsg.SetPixelsAction", "get bitmap data error, %s", new Object[] { Log.getStackTraceString(paramd) });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.ad
 * JD-Core Version:    0.7.0.1
 */