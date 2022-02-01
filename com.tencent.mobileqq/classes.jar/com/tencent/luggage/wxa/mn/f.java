package com.tencent.luggage.wxa.mn;

import android.view.View;
import androidx.annotation.NonNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class f
{
  public static void a(@NonNull View paramView, JSONObject paramJSONObject)
  {
    int k;
    float[] arrayOfFloat;
    if (paramView != null)
    {
      if (paramJSONObject == null) {
        return;
      }
      j = com.tencent.luggage.wxa.pc.g.a(paramJSONObject.optString("bgColor"));
      k = com.tencent.luggage.wxa.pc.g.a(paramJSONObject.optString("borderColor"));
      f1 = com.tencent.luggage.wxa.pc.g.a(paramJSONObject, "borderWidth", 0.0F);
      f2 = com.tencent.luggage.wxa.pc.g.a(paramJSONObject, "borderRadius", 0.0F);
      arrayOfFloat = new float[4];
      boolean bool = paramJSONObject.has("borderRadius");
      localg2 = null;
      localObject = localg2;
      if (!bool) {}
    }
    try
    {
      JSONArray localJSONArray = paramJSONObject.getJSONArray("borderRadius");
      localObject = localg2;
      if (localJSONArray != null)
      {
        localObject = localg2;
        if (localJSONArray.length() > 0)
        {
          i = 0;
          while (i < localJSONArray.length())
          {
            f3 = (float)localJSONArray.getDouble(i);
            if (i >= arrayOfFloat.length) {
              break;
            }
            arrayOfFloat[i] = com.tencent.luggage.wxa.pc.g.b(f3);
            i += 1;
          }
          localObject = arrayOfFloat;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        float f3;
        localg1 = localg2;
      }
    }
    if ((paramView instanceof g))
    {
      localg2 = (g)paramView;
      localg2.setBgColor(j);
      localg2.setBorderColor(k);
      localg2.setBorderRadius(f2);
      localg2.setBorderWidth(f1);
      localg2.setBorderRadius((float[])localObject);
      j = 1;
    }
    else
    {
      j = 0;
    }
    try
    {
      f1 = (float)paramJSONObject.getDouble("opacity");
      i = j;
      if (f1 >= 0.0F)
      {
        i = j;
        if (f1 <= 1.0F)
        {
          paramView.setAlpha(f1);
          i = 1;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        int m;
        g localg1;
        i = j;
      }
    }
    Object localObject = paramJSONObject.optJSONArray("padding");
    if ((localObject != null) && (((JSONArray)localObject).length() == 4))
    {
      j = com.tencent.luggage.wxa.pc.g.a((JSONArray)localObject, 0);
      k = com.tencent.luggage.wxa.pc.g.a((JSONArray)localObject, 1);
      m = com.tencent.luggage.wxa.pc.g.a((JSONArray)localObject, 2);
      paramView.setPadding(com.tencent.luggage.wxa.pc.g.a((JSONArray)localObject, 3), j, k, m);
    }
    float f1 = (float)paramJSONObject.optDouble("rotate", 0.0D);
    float f2 = (float)paramJSONObject.optDouble("scaleX", 1.0D);
    f3 = (float)paramJSONObject.optDouble("scaleY", 1.0D);
    if (paramJSONObject.has("rotate"))
    {
      paramView.setRotation(f1);
      i = 1;
    }
    if (paramJSONObject.has("scaleX"))
    {
      paramView.setScaleX(f2);
      i = 1;
    }
    if (paramJSONObject.has("scaleY"))
    {
      paramView.setScaleY(f3);
      i = 1;
    }
    if (i != 0) {
      paramView.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.f
 * JD-Core Version:    0.7.0.1
 */