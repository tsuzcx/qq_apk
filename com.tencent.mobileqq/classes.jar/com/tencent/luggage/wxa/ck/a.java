package com.tencent.luggage.wxa.ck;

import android.app.Activity;
import android.content.Intent;
import com.tencent.image_picker.imagepicker.features.b.a;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.tencent.luggage.wxa.jx.a
{
  public static final int CTRL_INDEX = 29;
  public static final String NAME = "chooseImage";
  
  private static <T> JSONArray b(ArrayList<T> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() != 0))
    {
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        localJSONArray.put(paramArrayList.get(i));
        i += 1;
      }
      return localJSONArray;
    }
    return null;
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("sourceType");
    paramJSONObject.optString("sizeType");
    try
    {
      i = Integer.parseInt(paramJSONObject.optString("count"), 10);
    }
    catch (Exception paramJSONObject)
    {
      int i;
      label31:
      Activity localActivity;
      Object localObject;
      break label31;
    }
    i = 1;
    if (!(paramc.getContext() instanceof Activity))
    {
      paramc.a(paramInt, "fail");
      return;
    }
    localActivity = (Activity)paramc.getContext();
    localObject = null;
    paramJSONObject = (JSONObject)localObject;
    try
    {
      if (localJSONArray.length() == 1)
      {
        paramJSONObject = (JSONObject)localObject;
        if (localJSONArray.get(0).equals("camera")) {
          paramJSONObject = com.tencent.image_picker.imagepicker.features.b.b().a(localActivity);
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      o.c("MicroMsg.JsApiChooseImage", "invoke: Never arrive", new Object[] { paramJSONObject });
      paramJSONObject = (JSONObject)localObject;
    }
    localObject = paramJSONObject;
    if (paramJSONObject == null) {
      localObject = com.tencent.image_picker.imagepicker.features.b.a(localActivity).a(i).a(localActivity);
    }
    LuggageActivityHelper.FOR(paramc.getContext()).startActivityForResult((Intent)localObject, new a.1(this, paramc, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ck.a
 * JD-Core Version:    0.7.0.1
 */