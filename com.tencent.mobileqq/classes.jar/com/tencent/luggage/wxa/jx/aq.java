package com.tencent.luggage.wxa.jx;

import android.content.Context;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.qz.af;
import org.json.JSONObject;

public class aq
  extends a<h>
{
  public static final int CTRL_INDEX = 201;
  public static final String NAME = "openUrl";
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("url");
    if (af.c(paramJSONObject))
    {
      paramh.a(paramInt, b("fail"));
      return;
    }
    Context localContext = paramh.getContext();
    if (localContext != null)
    {
      ((z)paramh.a(z.class)).a(localContext, paramJSONObject, null);
      paramh.a(paramInt, b("ok"));
      return;
    }
    paramh.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.aq
 * JD-Core Version:    0.7.0.1
 */