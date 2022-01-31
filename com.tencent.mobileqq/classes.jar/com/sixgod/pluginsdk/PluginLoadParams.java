package com.sixgod.pluginsdk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sixgod.pluginsdk.component.ContainerActivity;
import com.sixgod.pluginsdk.component.ContainerService;
import com.sixgod.pluginsdk.log.SGLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginLoadParams
{
  public String apkPath = "";
  public Map componentMap = null;
  public String defaultActivityContainer = ContainerActivity.class.getName();
  public String defaultServiceContainer = ContainerService.class.getName();
  public boolean defaultUseActionBar = false;
  public ArrayList libList = null;
  public String pkgName = "";
  public PluginCallback pluginLoadCallBack;
  public String pluginName = "";
  public int pluginResourceFlag = 0;
  public Bundle preOnCreateExtras;
  public Map serviceActionMap = null;
  public List singleTaskContainers = new ArrayList();
  public List singleTopContainers = new ArrayList();
  public boolean supportMultidex = false;
  public boolean supportSpeedyClassloader = false;
  public boolean useBootClassLoader = false;
  public boolean useJni = true;
  public String versionName = "";
  
  protected PluginLoadParams()
  {
    this.componentMap = new HashMap();
    this.libList = new ArrayList();
  }
  
  public PluginLoadParams(String paramString1, String paramString2, String paramString3)
  {
    this.apkPath = paramString1;
    this.pluginName = paramString3;
    this.pkgName = paramString2;
    this.componentMap = new HashMap();
    this.serviceActionMap = new HashMap();
    this.libList = new ArrayList();
  }
  
  public static PluginLoadParams parseFromJson(String paramString)
  {
    int j = 0;
    PluginLoadParams localPluginLoadParams = new PluginLoadParams();
    for (;;)
    {
      Object localObject1;
      int i;
      Object localObject2;
      try
      {
        paramString = new JSONObject(paramString);
        localPluginLoadParams.apkPath = paramString.optString("apkPath");
        localPluginLoadParams.pluginName = paramString.optString("pluginName");
        localPluginLoadParams.pkgName = paramString.optString("pkgName");
        localPluginLoadParams.useJni = paramString.optBoolean("useJni");
        localPluginLoadParams.pluginResourceFlag = paramString.optInt("pluginResourceFlag");
        localPluginLoadParams.supportSpeedyClassloader = paramString.optBoolean("supportSpeedyClassloader");
        localPluginLoadParams.defaultUseActionBar = paramString.optBoolean("defaultUseActionBar");
        localPluginLoadParams.useBootClassLoader = paramString.optBoolean("useBootClassLoader");
        localPluginLoadParams.defaultActivityContainer = paramString.optString("defaultActivityContainer");
        localPluginLoadParams.defaultServiceContainer = paramString.optString("defaultServiceContainer");
        localPluginLoadParams.versionName = paramString.optString("versionName");
        localPluginLoadParams.supportMultidex = paramString.optBoolean("supportMultidex");
        localObject1 = paramString.optJSONArray("componentMap");
        int k;
        String str;
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          k = ((JSONArray)localObject1).length();
          i = 0;
          if (i < k)
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            str = ((JSONObject)localObject2).optString("key");
            localObject2 = ((JSONObject)localObject2).optString("value");
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label660;
            }
            localPluginLoadParams.componentMap.put(str, localObject2);
            break label660;
          }
        }
        localObject1 = paramString.optJSONArray("actionMap");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          k = ((JSONArray)localObject1).length();
          i = 0;
          if (i < k)
          {
            localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            str = ((JSONObject)localObject2).optString("key");
            localObject2 = ((JSONObject)localObject2).optString("value");
            if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label667;
            }
            localPluginLoadParams.serviceActionMap.put(str, localObject2);
            break label667;
          }
        }
        localObject1 = paramString.optJSONArray("libList");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          k = ((JSONArray)localObject1).length();
          i = 0;
          if (i < k)
          {
            localPluginLoadParams.libList.add(((JSONArray)localObject1).getString(i));
            i += 1;
            continue;
          }
        }
        localObject1 = paramString.optJSONArray("singleTasks");
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
        {
          i = 0;
          k = ((JSONArray)localObject1).length();
          if (i < k) {
            try
            {
              localPluginLoadParams.singleTaskContainers.add(Class.forName(((JSONArray)localObject1).optString(i)));
              i += 1;
            }
            catch (Exception localException1)
            {
              SGLog.b("parseSingleTask failed, msg = " + localException1.getMessage());
              continue;
            }
          }
        }
        localObject1 = paramString.optJSONArray("singleTops");
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localPluginLoadParams;
      }
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = j;
        for (;;)
        {
          j = ((JSONArray)localObject1).length();
          if (i < j) {
            try
            {
              localPluginLoadParams.singleTopContainers.add(Class.forName(((JSONArray)localObject1).optString(i)));
              i += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                SGLog.b("parseSingTop failed, msg = " + localException2.getMessage());
              }
            }
          }
        }
      }
      paramString = paramString.optJSONObject("preOnCreate");
      if (paramString != null)
      {
        localObject1 = new Intent();
        Iterator localIterator = paramString.keys();
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          ((Intent)localObject1).putExtra((String)localObject2, paramString.optString((String)localObject2));
        }
        localPluginLoadParams.preOnCreateExtras = ((Intent)localObject1).getExtras();
        return localPluginLoadParams;
        label660:
        i += 1;
        continue;
        label667:
        i += 1;
      }
    }
  }
  
  public String toJsonString()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Iterator localIterator;
    Object localObject2;
    JSONObject localJSONObject2;
    try
    {
      localJSONObject1.put("apkPath", this.apkPath);
      localJSONObject1.put("pluginName", this.pluginName);
      localJSONObject1.put("pkgName", this.pkgName);
      localJSONObject1.put("useJni", this.useJni);
      localJSONObject1.put("pluginResourceFlag", this.pluginResourceFlag);
      localJSONObject1.put("defaultUseActionBar", this.defaultUseActionBar);
      localJSONObject1.put("useBootClassLoader", this.useBootClassLoader);
      localJSONObject1.put("defaultActivityContainer", this.defaultActivityContainer);
      localJSONObject1.put("defaultServiceContainer", this.defaultServiceContainer);
      localJSONObject1.put("versionName", this.versionName);
      localJSONObject1.put("supportMultidex", this.supportMultidex);
      localJSONObject1.put("supportSpeedyClassloader", this.supportSpeedyClassloader);
      JSONArray localJSONArray = new JSONArray();
      if (this.componentMap != null)
      {
        localIterator = this.componentMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (Map.Entry)localIterator.next();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("key", (String)((Map.Entry)localObject2).getKey());
          localJSONObject2.put("value", (String)((Map.Entry)localObject2).getValue());
          localJSONArray.put(localJSONObject2);
          continue;
          return localJSONObject1.toString();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    for (;;)
    {
      localJSONObject1.put("componentMap", localException);
      Object localObject1 = new JSONArray();
      if (this.serviceActionMap != null)
      {
        localIterator = this.serviceActionMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (Map.Entry)localIterator.next();
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("key", (String)((Map.Entry)localObject2).getKey());
          localJSONObject2.put("value", (String)((Map.Entry)localObject2).getValue());
          ((JSONArray)localObject1).put(localJSONObject2);
        }
      }
      localJSONObject1.put("actionMap", localObject1);
      localObject1 = new JSONArray();
      if (this.libList != null)
      {
        int j = this.libList.size();
        int i = 0;
        while (i < j)
        {
          ((JSONArray)localObject1).put(this.libList.get(i));
          i += 1;
        }
      }
      localJSONObject1.put("libList", localObject1);
      localObject1 = new JSONArray();
      if (this.singleTaskContainers != null)
      {
        localIterator = this.singleTaskContainers.iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject1).put(((Class)localIterator.next()).getName());
        }
      }
      localJSONObject1.put("singleTasks", localObject1);
      localObject1 = new JSONArray();
      if (this.singleTopContainers != null)
      {
        localIterator = this.singleTopContainers.iterator();
        while (localIterator.hasNext()) {
          ((JSONArray)localObject1).put(((Class)localIterator.next()).getName());
        }
      }
      localJSONObject1.put("singleTops", localObject1);
      if (this.preOnCreateExtras != null)
      {
        localObject1 = new JSONObject();
        localIterator = this.preOnCreateExtras.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (String)localIterator.next();
          try
          {
            ((JSONObject)localObject1).put((String)localObject2, this.preOnCreateExtras.get((String)localObject2));
          }
          catch (JSONException localJSONException) {}
        }
        localJSONObject1.put("preOnCreate", localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.PluginLoadParams
 * JD-Core Version:    0.7.0.1
 */