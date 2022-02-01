package com.tencent.luggage.wxa.kd;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class e<CONTEXT extends c>
  extends a<CONTEXT>
{
  protected int a(JSONObject paramJSONObject)
  {
    throw new JSONException("viewId do not exist, override the method getViewId(data).");
  }
  
  protected int b(JSONObject paramJSONObject)
  {
    return paramJSONObject.optInt("parentId", 0);
  }
  
  protected float[] c(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("position"));
      return new float[] { g.a(localJSONObject, "left", 0.0F), g.a(localJSONObject, "top", 0.0F), g.a(localJSONObject, "width", 0.0F), g.a(localJSONObject, "height", 0.0F), paramJSONObject.optInt("zIndex", 0) };
    }
    catch (Exception paramJSONObject)
    {
      label69:
      break label69;
    }
    return null;
  }
  
  protected int d(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("hide");
      if (bool) {
        return 4;
      }
      return 0;
    }
    catch (JSONException paramJSONObject)
    {
      label15:
      break label15;
    }
    return -1;
  }
  
  protected Boolean e(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fixed");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  protected Boolean f(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.getBoolean("fullscreen");
      return Boolean.valueOf(bool);
    }
    catch (JSONException paramJSONObject)
    {
      label12:
      break label12;
    }
    return null;
  }
  
  protected Boolean g(JSONObject paramJSONObject)
  {
    return null;
  }
  
  protected boolean h(JSONObject paramJSONObject)
  {
    return paramJSONObject.optBoolean("independent", false);
  }
  
  protected boolean i(JSONObject paramJSONObject)
  {
    return paramJSONObject.optBoolean("draggable", false);
  }
  
  protected String j(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("dragConfig");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kd.e
 * JD-Core Version:    0.7.0.1
 */