package com.tencent.luggage.wxa.lx;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.pc.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class i<C extends c>
  extends u<C>
{
  public static final int CTRL_INDEX = 40;
  public static final String NAME = "getSystemInfo";
  
  public final String a(C paramC, JSONObject paramJSONObject)
  {
    return a("ok", a(paramC));
  }
  
  protected Map<String, Object> a(C paramC)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("brand", Build.BRAND);
    localHashMap.put("model", Build.MODEL);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Android ");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localHashMap.put("system", localStringBuilder.toString());
    paramC = paramC.getContext().getResources().getDisplayMetrics();
    localHashMap.put("pixelRatio", Float.valueOf(paramC.density));
    localHashMap.put("screenWidth", Integer.valueOf(g.a(paramC.widthPixels)));
    localHashMap.put("screenHeight", Integer.valueOf(g.a(paramC.heightPixels)));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.i
 * JD-Core Version:    0.7.0.1
 */