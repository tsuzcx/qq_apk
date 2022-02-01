package com.tencent.av.qavperf;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Display;
import org.json.JSONObject;

public class QAVPUtils
{
  public static int a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramContext = ((DisplayManager)paramContext.getSystemService("display")).getDisplays();
      if ((paramContext != null) && (paramContext.length > 0)) {
        return (int)paramContext[0].getRefreshRate();
      }
    }
    return 60;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int k = 0;
    int j = 0;
    int i = k;
    try
    {
      paramString = new JSONObject(paramString);
      i = k;
      if (!paramString.has("qavp_switch")) {
        break label93;
      }
      i = k;
      j = paramString.getInt("qavp_switch");
      i = j;
      paramString = new StringBuilder();
      i = j;
      paramString.append("switch:");
      i = j;
      paramString.append(j);
      i = j;
      QAVPLogger.a(paramString.toString());
    }
    catch (Exception paramString)
    {
      label86:
      break label86;
    }
    QAVPLogger.a("QAVP Get Config Error");
    j = i;
    label93:
    paramContext = paramContext.getSharedPreferences("qavp_switch", 4).edit();
    paramContext.putInt("qavp_switch", j);
    paramContext.apply();
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("qavp_switch", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("开关:");
    localStringBuilder.append(paramContext.getInt("qavp_switch", -1));
    QAVPLogger.a(localStringBuilder.toString());
    return paramContext.getInt("qavp_switch", 1) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.qavperf.QAVPUtils
 * JD-Core Version:    0.7.0.1
 */