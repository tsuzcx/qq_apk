package com.tencent.luggage.wxa.pc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.luggage.util.k;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
{
  private static DisplayMetrics a = r.a().getResources().getDisplayMetrics();
  private static Float b;
  private static boolean c = true;
  
  public static float a()
  {
    Object localObject = b;
    if (localObject != null) {
      return ((Float)localObject).floatValue();
    }
    localObject = a;
    if (localObject != null) {
      return ((DisplayMetrics)localObject).density;
    }
    return 1.0F;
  }
  
  public static float a(float paramFloat)
  {
    return paramFloat / a();
  }
  
  public static float a(JSONArray paramJSONArray, int paramInt, float paramFloat)
  {
    if (paramJSONArray == null) {
      return paramFloat;
    }
    try
    {
      float f = b((float)paramJSONArray.getDouble(paramInt));
      return f;
    }
    catch (Exception paramJSONArray) {}
    return paramFloat;
  }
  
  public static float a(JSONObject paramJSONObject, String paramString, float paramFloat)
  {
    if (paramJSONObject == null) {
      return paramFloat;
    }
    double d = paramFloat;
    try
    {
      float f = b((float)paramJSONObject.optDouble(paramString, d));
      return f;
    }
    catch (Exception paramJSONObject) {}
    return paramFloat;
  }
  
  public static int a(int paramInt)
  {
    return (int)Math.ceil(paramInt / a());
  }
  
  public static int a(String paramString)
  {
    return a(paramString, 0);
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      int i = b(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  public static int a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() < 3) {
        return 0;
      }
      int i;
      if (paramJSONArray.length() == 3) {
        i = Color.rgb(paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF);
      } else {
        i = Color.argb(paramJSONArray.optInt(3) & 0xFF, paramJSONArray.optInt(0) & 0xFF, paramJSONArray.optInt(1) & 0xFF, paramJSONArray.optInt(2) & 0xFF);
      }
      int j = i;
      if (c) {
        j = k.a.a(i);
      }
      return j;
    }
    return 0;
  }
  
  public static int a(JSONArray paramJSONArray, int paramInt)
  {
    return a(paramJSONArray, paramInt, 0);
  }
  
  public static int a(JSONArray paramJSONArray, int paramInt1, int paramInt2)
  {
    if (paramJSONArray == null) {
      return paramInt2;
    }
    try
    {
      paramInt1 = Math.round(b((float)paramJSONArray.getDouble(paramInt1)));
      return paramInt1;
    }
    catch (Exception paramJSONArray) {}
    return paramInt2;
  }
  
  public static int a(JSONObject paramJSONObject, String paramString)
  {
    return Math.round(b((float)paramJSONObject.getDouble(paramString)));
  }
  
  public static int a(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if (paramJSONObject == null) {
      return paramInt;
    }
    try
    {
      int i = Math.round(b((float)paramJSONObject.getDouble(paramString)));
      return i;
    }
    catch (Exception paramJSONObject) {}
    return paramInt;
  }
  
  public static float b(float paramFloat)
  {
    return a() * paramFloat;
  }
  
  public static float b(JSONObject paramJSONObject, String paramString)
  {
    return a(paramJSONObject, paramString, 0.0F);
  }
  
  public static int b(int paramInt)
  {
    return (int)(paramInt / a());
  }
  
  public static int b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (f.a.containsKey(paramString)) {
        return ((Integer)f.a.get(paramString)).intValue();
      }
      if (paramString.charAt(0) == '#')
      {
        Object localObject = paramString;
        if (paramString.length() == 4)
        {
          localObject = new StringBuilder(paramString);
          ((StringBuilder)localObject).insert(2, paramString.charAt(1));
          ((StringBuilder)localObject).insert(4, paramString.charAt(2));
          ((StringBuilder)localObject).insert(6, paramString.charAt(3));
          localObject = ((StringBuilder)localObject).toString();
        }
        long l1;
        if (((String)localObject).length() == 7) {
          l1 = Long.parseLong(((String)localObject).substring(1), 16);
        }
        for (long l2 = -16777216L;; l2 = Long.parseLong(((String)localObject).substring(7, 9), 16) << 24)
        {
          break;
          if (((String)localObject).length() != 9) {
            break label189;
          }
          l1 = Long.parseLong(((String)localObject).substring(1, 7), 16);
        }
        return (int)(l1 | l2);
        label189:
        o.h("MicroMsg.JsValueUtil", "hy: Unknown color, given string is %s", new Object[] { localObject });
        throw new IllegalArgumentException("Unknown color");
      }
      return Color.parseColor(paramString);
    }
    paramString = new IllegalArgumentException("colorString isEmpty");
    for (;;)
    {
      throw paramString;
    }
  }
  
  public static int b(JSONArray paramJSONArray, int paramInt)
  {
    return Math.round(b((float)paramJSONArray.getDouble(paramInt)));
  }
  
  public static float c(JSONArray paramJSONArray, int paramInt)
  {
    return b((float)paramJSONArray.getDouble(paramInt));
  }
  
  public static float c(JSONObject paramJSONObject, String paramString)
  {
    return b((float)paramJSONObject.getDouble(paramString));
  }
  
  public static int c(int paramInt)
  {
    return Math.round(a() * paramInt);
  }
  
  public static void c(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      b = Float.valueOf(paramFloat);
    }
  }
  
  public static float d(JSONArray paramJSONArray, int paramInt)
  {
    return a(paramJSONArray, paramInt, 0.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pc.g
 * JD-Core Version:    0.7.0.1
 */