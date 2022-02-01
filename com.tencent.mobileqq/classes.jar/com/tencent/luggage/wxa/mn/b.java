package com.tencent.luggage.wxa.mn;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;
import org.json.JSONObject;

public class b
{
  public static Boolean a(@NonNull Context paramContext)
  {
    paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
    if (paramContext == null)
    {
      o.c("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, accessibilityManager is null");
      return null;
    }
    paramContext = paramContext.getEnabledAccessibilityServiceList(1);
    int i;
    if ((paramContext != null) && (!paramContext.isEmpty())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      o.d("MicroMsg.AppBrand.Accessibility.ViewAccessibilityHelper", "isTalkBackAccessibilityEnabled, isTalkBackAccessibilityEnabled: false");
      return Boolean.valueOf(false);
    }
    return Boolean.valueOf(true);
  }
  
  public static void a(View paramView, JSONObject paramJSONObject)
  {
    if ((paramView != null) && (paramJSONObject != null) && (paramJSONObject.has("accessibility")) && (paramJSONObject.optBoolean("accessibility", false))) {
      paramView.setAccessibilityDelegate(new b.1(paramJSONObject.optString("ariaLabel", ""), paramJSONObject.optString("ariaRole", "")));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mn.b
 * JD-Core Version:    0.7.0.1
 */