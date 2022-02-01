package com.tencent.luggage.wxa.lx;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.luggage.wxa.ix.b;
import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class s
  extends a
{
  public static final int CTRL_INDEX = 230;
  public static final String NAME = "vibrateShort";
  
  @RequiresApi(api=26)
  private static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return -1;
        }
        return 255;
      }
      return 192;
    }
    return 128;
  }
  
  private static int a(@Nullable JSONObject paramJSONObject)
  {
    int i = -1;
    if (paramJSONObject == null) {
      return -1;
    }
    if (!paramJSONObject.has("style")) {
      return -1;
    }
    paramJSONObject = paramJSONObject.optString("style");
    if (af.c(paramJSONObject)) {
      return -2;
    }
    int j = paramJSONObject.hashCode();
    if (j != -1078030475)
    {
      if (j != 99152071)
      {
        if ((j == 102970646) && (paramJSONObject.equals("light"))) {
          i = 0;
        }
      }
      else if (paramJSONObject.equals("heavy")) {
        i = 2;
      }
    }
    else if (paramJSONObject.equals("medium")) {
      i = 1;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return -2;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  private static String a(@NonNull Vibrator paramVibrator, long paramLong, int paramInt)
  {
    if (-2 == paramInt)
    {
      paramVibrator.vibrate(paramLong);
      return "fail: style is illegal";
    }
    if (-1 == paramInt)
    {
      paramVibrator.vibrate(paramLong);
      return "ok";
    }
    if ((Build.VERSION.SDK_INT >= 26) && (paramVibrator.hasAmplitudeControl()))
    {
      b(paramVibrator, paramLong, paramInt);
      return "ok";
    }
    paramVibrator.vibrate(paramLong);
    return "fail: style is not support";
  }
  
  @RequiresApi(api=26)
  private static void b(@NonNull Vibrator paramVibrator, long paramLong, int paramInt)
  {
    o.e("MicroMsg.JsApiVibrateShort", "vibrateSupportAmplitude");
    paramInt = a(paramInt);
    if (-1 == paramInt)
    {
      paramVibrator.vibrate(paramLong);
      return;
    }
    paramVibrator.vibrate(VibrationEffect.createOneShot(paramLong, paramInt));
  }
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    o.e("MicroMsg.JsApiVibrateShort", "JsApiVibrateShort services!");
    if (paramc.getAppState() != b.a)
    {
      paramc.a(paramInt, b("fail:not allowed in background"));
      return;
    }
    int i = a(paramJSONObject);
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("vibrationIntensity: ");
    paramJSONObject.append(i);
    o.e("MicroMsg.JsApiVibrateShort", paramJSONObject.toString());
    try
    {
      paramJSONObject = (Vibrator)paramc.getContext().getSystemService("vibrator");
      if (paramJSONObject == null)
      {
        paramc.a(paramInt, b("fail: vibrate is not support"));
        return;
      }
      paramc.a(paramInt, b(a(paramJSONObject, 15L, i)));
      return;
    }
    catch (Exception paramJSONObject)
    {
      o.c("MicroMsg.JsApiVibrateShort", "vibrateShort exception %s", new Object[] { paramJSONObject.getMessage() });
      paramc.a(paramInt, b("fail: system internal error"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.s
 * JD-Core Version:    0.7.0.1
 */