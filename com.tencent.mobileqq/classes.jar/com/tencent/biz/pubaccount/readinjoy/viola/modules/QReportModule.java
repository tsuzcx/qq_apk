package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import axrn;
import bbdh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.commons.Destroyable;
import com.tencent.viola.module.BaseModule;
import fi;
import java.util.HashMap;
import java.util.Iterator;
import naj;
import nol;
import onh;
import org.json.JSONException;
import org.json.JSONObject;

public class QReportModule
  extends BaseModule
  implements Destroyable
{
  public static final String MODULE_NAME = "QReport";
  public static final String TAG = "QReportModule";
  
  private HashMap getDTBase()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = (QQAppInterface)onh.a();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getAccount();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("open_id", localObject);
      }
    }
    localHashMap.put("app", "qq");
    localHashMap.put("av", "8.3.0");
    localHashMap.put("imei", bbdh.a());
    localHashMap.put("oper_time", Long.toString(System.currentTimeMillis()));
    localHashMap.put("domain", "1");
    localHashMap.put("md", Build.MODEL);
    localHashMap.put("net_type", Integer.toString(naj.a()));
    localHashMap.put("client_ip", fi.a(fi.a()));
    if (BaseApplication.getContext() != null)
    {
      localObject = BaseApplication.getContext().getResources().getDisplayMetrics();
      localHashMap.put("sr", ((DisplayMetrics)localObject).widthPixels + "*" + ((DisplayMetrics)localObject).widthPixels);
    }
    return localHashMap;
  }
  
  private void reportDTImpl(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    HashMap localHashMap;
    if (paramContext != null) {
      localHashMap = getDTBase();
    }
    for (;;)
    {
      Object localObject;
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localObject = paramJSONObject.get(str);
          if ((localObject instanceof String))
          {
            localObject = (String)localObject;
            localHashMap.put(str, localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QReportModule", 2, "reportDTImpl JSONException  e: " + paramJSONObject.getMessage());
        }
        axrn.a(paramContext).a(null, paramString, true, -1L, 0L, localHashMap, null);
      }
      if (((localObject instanceof Number)) || ((localObject instanceof Long)) || ((localObject instanceof Integer)) || ((localObject instanceof Double)) || ((localObject instanceof Float))) {
        localObject = localObject.toString();
      } else if ((localObject instanceof Boolean)) {
        localObject = localObject.toString();
      } else {
        localObject = "'undefined'";
      }
    }
  }
  
  public void destroy() {}
  
  @JSMethod(uiThread=false)
  public void reportDT(@NonNull String paramString, JSONObject paramJSONObject)
  {
    reportDTImpl(BaseApplication.getContext(), paramString, paramJSONObject);
  }
  
  @JSMethod(uiThread=false)
  public void reportT(@NonNull String paramString, JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("r2", "");
    String str2 = paramJSONObject.optString("r3", "");
    String str3 = paramJSONObject.optString("r4", "");
    paramJSONObject = paramJSONObject.optJSONObject("r5");
    if (paramJSONObject != null) {}
    for (paramJSONObject = paramJSONObject.toString();; paramJSONObject = "")
    {
      nol.a(null, null, paramString, paramString, 0, 0, str1, str2, str3, paramJSONObject, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.QReportModule
 * JD-Core Version:    0.7.0.1
 */