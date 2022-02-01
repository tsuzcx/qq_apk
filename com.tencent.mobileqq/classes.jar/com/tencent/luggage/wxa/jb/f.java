package com.tencent.luggage.wxa.jb;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.luggage.wxa.ja.e;
import com.tencent.luggage.wxa.jc.c;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONArray;

public class f
  implements d
{
  private boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, int paramInt1, String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    float f2 = paramFloat4;
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return false;
    }
    float f1;
    if (paramInt1 >= 5)
    {
      if (paramFloat3 != 0.0F)
      {
        if (f2 == 0.0F) {
          return true;
        }
        if (paramFloat3 < 0.0F)
        {
          paramFloat1 += paramFloat3;
          paramFloat3 = -paramFloat3;
        }
        paramFloat4 = paramFloat3;
        f1 = paramFloat1;
        if (f2 < 0.0F)
        {
          f1 = paramFloat2 + f2;
          f2 = -f2;
          paramFloat4 = paramFloat3;
          paramFloat2 = paramFloat1;
          paramFloat1 = f1;
          break label124;
        }
      }
      else
      {
        return true;
      }
    }
    else
    {
      f1 = paramFloat1;
      paramFloat4 = paramFloat3;
    }
    paramFloat1 = paramFloat2;
    paramFloat2 = f1;
    label124:
    paramFloat3 = paramFloat2 + paramFloat4;
    float f5 = paramFloat1 + f2;
    Object localObject;
    float f3;
    float f4;
    if (paramInt1 >= 9)
    {
      if ((paramInt4 != 0) && (paramInt5 != 0))
      {
        if (paramInt4 < 0)
        {
          paramInt1 = paramInt2 + paramInt4;
          paramInt4 = -paramInt4;
        }
        else
        {
          paramInt1 = paramInt2;
        }
        if (paramInt5 < 0)
        {
          paramInt2 = paramInt3 + paramInt5;
          paramInt3 = -paramInt5;
        }
        else
        {
          paramInt2 = paramInt3;
          paramInt3 = paramInt5;
        }
        int j = paramInt1 + paramInt4;
        if (j > 0)
        {
          int k = paramInt2 + paramInt3;
          if (k > 0)
          {
            if (paramInt1 > 0) {
              paramInt5 = paramInt1;
            } else {
              paramInt5 = 0;
            }
            if (paramInt2 > 0) {
              i = paramInt2;
            }
            localObject = new Rect(paramInt5, i, j, k);
            paramString = paramd.j().a(paramd, paramString, (Rect)localObject, new f.1(this));
            if ((paramString != null) && (!paramString.isRecycled()))
            {
              paramInt1 = g.c(paramInt1);
              paramInt2 = g.c(paramInt2);
              paramInt4 = g.c(paramInt4);
              paramInt3 = g.c(paramInt3);
              paramInt5 = g.c(paramInt5);
              i = g.c(i);
              j = g.c(paramString.getWidth());
              k = g.c(paramString.getHeight());
              paramFloat3 = paramFloat4 / paramInt4;
              paramFloat4 = f2 / paramInt3;
              f1 = paramFloat2 + (paramInt5 - paramInt1) * paramFloat3;
              f3 = paramFloat1 + (i - paramInt2) * paramFloat4;
              paramFloat1 = j;
              paramFloat4 = f3 + k * paramFloat4;
              f4 = paramFloat1 * paramFloat3 + f1;
              break label566;
            }
            return false;
          }
        }
        return true;
      }
      else
      {
        return true;
      }
    }
    else
    {
      localObject = paramd.j().a(paramd, paramString, new f.2(this));
      if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
        break label625;
      }
      if (paramFloat4 == 0.0F) {
        paramFloat3 = paramFloat2 + g.c(((Bitmap)localObject).getWidth());
      }
      paramString = (String)localObject;
      f1 = paramFloat2;
      f3 = paramFloat1;
      f4 = paramFloat3;
      paramFloat4 = f5;
      if (f2 == 0.0F)
      {
        paramFloat4 = paramFloat1 + g.c(((Bitmap)localObject).getHeight());
        f4 = paramFloat3;
        f3 = paramFloat1;
        f1 = paramFloat2;
        paramString = (String)localObject;
      }
    }
    label566:
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    paramCanvas.drawBitmap(paramString, new Rect(0, 0, paramString.getWidth(), paramString.getHeight()), new RectF(f1, f3, f4, paramFloat4), paramd.h());
    return true;
    label625:
    return false;
  }
  
  public String a()
  {
    return "drawImage";
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, c paramc)
  {
    paramc = (com.tencent.luggage.wxa.jc.f)com.tencent.luggage.wxa.pc.d.a(paramc);
    if (paramc == null) {
      return false;
    }
    return a(paramd, paramCanvas, paramc.b, paramc.c, paramc.d, paramc.e, paramc.f, paramc.g, paramc.h, paramc.i, paramc.j, paramc.k);
  }
  
  public boolean a(com.tencent.luggage.wxa.ja.d paramd, Canvas paramCanvas, JSONArray paramJSONArray)
  {
    int i = paramJSONArray.length();
    if (i < 3) {
      return false;
    }
    return a(paramd, paramCanvas, i, paramJSONArray.optString(0), g.d(paramJSONArray, 1), g.d(paramJSONArray, 2), g.d(paramJSONArray, 3), g.d(paramJSONArray, 4), paramJSONArray.optInt(5), paramJSONArray.optInt(6), paramJSONArray.optInt(7), paramJSONArray.optInt(8));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jb.f
 * JD-Core Version:    0.7.0.1
 */