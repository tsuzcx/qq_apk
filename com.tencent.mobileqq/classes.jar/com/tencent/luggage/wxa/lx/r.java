package com.tencent.luggage.wxa.lx;

import android.content.Context;
import android.os.Vibrator;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class r
  extends a
{
  public static final int CTRL_INDEX = 231;
  public static final String NAME = "vibrateLong";
  
  public static void a(Context paramContext)
  {
    paramContext = (Vibrator)paramContext.getSystemService("vibrator");
    if (paramContext == null) {
      return;
    }
    paramContext.vibrate(400L);
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiVibrateLong", "JsApiVibrateLong!");
    if (paramc.getAppState() != b.a)
    {
      paramc.a(paramInt, b("fail:not allowed in background"));
      return;
    }
    a(paramc.getContext());
    paramc.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.r
 * JD-Core Version:    0.7.0.1
 */