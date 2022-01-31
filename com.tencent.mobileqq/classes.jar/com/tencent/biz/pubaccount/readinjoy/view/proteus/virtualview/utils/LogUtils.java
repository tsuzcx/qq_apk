package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class LogUtils
{
  public static boolean sShouldLog = false;
  
  public static void d(String paramString1, String paramString2)
  {
    LogUtil.QLog.d(paramString1, 1, paramString2);
  }
  
  private static void dumpViewBaseHierarchy(@NonNull ViewBase paramViewBase, @NonNull JSONObject paramJSONObject)
  {
    Object localObject1 = new Rect(paramViewBase.getDrawLeft(), paramViewBase.getDrawTop(), paramViewBase.getWidth(), paramViewBase.getHeight());
    Object localObject2 = paramViewBase.getClass().getSimpleName();
    Object localObject3 = paramViewBase.getName();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("name", localObject2);
    localJSONObject.put("id", localObject3);
    localJSONObject.put("visibility", paramViewBase.getVisibility());
    localJSONObject.put("bounds", localObject1);
    paramJSONObject.put("view", localJSONObject);
    if ((paramViewBase instanceof Layout))
    {
      localObject1 = ((Layout)paramViewBase).getSubViews();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        paramViewBase = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ViewBase)((Iterator)localObject1).next();
          localObject3 = new JSONObject();
          dumpViewBaseHierarchy((ViewBase)localObject2, (JSONObject)localObject3);
          paramViewBase.put(localObject3);
        }
        paramJSONObject.put("children", paramViewBase);
      }
    }
  }
  
  public static void logViewBaseHierarchy(@NonNull ViewBase paramViewBase, String paramString)
  {
    if (shouldLog()) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      dumpViewBaseHierarchy(paramViewBase, localJSONObject);
      d(paramString, "logViewBaseHierarchy: " + localJSONObject.toString());
      return;
    }
    catch (Exception paramViewBase)
    {
      LogUtil.QLog.e(paramString, 1, "[logViewBaseHierarchy] ", paramViewBase);
    }
  }
  
  public static boolean shouldLog()
  {
    return sShouldLog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils
 * JD-Core Version:    0.7.0.1
 */