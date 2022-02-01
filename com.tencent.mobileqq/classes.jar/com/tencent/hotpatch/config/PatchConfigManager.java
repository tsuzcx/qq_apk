package com.tencent.hotpatch.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchConfigManager
{
  public static PatchConfig a(Context paramContext, String paramString)
  {
    paramContext = PatchSharedPreUtil.getPatchConfig(paramContext, paramString);
    paramString = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramContext)) {
          paramContext = new JSONArray();
        } else {
          paramContext = new JSONArray(paramContext);
        }
      }
      catch (JSONException paramContext)
      {
        JSONObject localJSONObject;
        QLog.d("PatchLogTag", 1, "PatchConfigManager getLatestPatchConfig", paramContext);
        if (paramString.size() <= 1) {
          continue;
        }
        Collections.sort(paramString, new PatchConfigManager.1());
        if (paramString.size() <= 0) {
          continue;
        }
        return (PatchConfig)paramString.get(0);
        return null;
      }
      if (i < paramContext.length())
      {
        localJSONObject = paramContext.getJSONObject(i);
        if (localJSONObject != null) {
          paramString.add(new PatchConfig(localJSONObject));
        }
        i += 1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public static void a(Context paramContext, PatchConfig paramPatchConfig)
  {
    if (paramPatchConfig == null) {
      return;
    }
    for (;;)
    {
      try
      {
        String str = paramPatchConfig.a();
        Object localObject = PatchSharedPreUtil.getPatchConfig(paramContext, str);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label128;
        }
        localObject = new JSONArray((String)localObject);
        if (((JSONArray)localObject).length() != 1) {
          break label128;
        }
        i = 0;
        if (new PatchConfig(((JSONArray)localObject).getJSONObject(0)).a() < paramPatchConfig.a()) {
          break label128;
        }
        if (i != 0)
        {
          localObject = new JSONArray();
          ((JSONArray)localObject).put(new JSONObject(paramPatchConfig.e()));
          PatchSharedPreUtil.updatePatchConfig(paramContext, str, ((JSONArray)localObject).toString());
          return;
        }
      }
      catch (JSONException paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchConfigManager updatePatchConfigToDisk", paramContext);
      }
      return;
      label128:
      int i = 1;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new HashMap();
        if (TextUtils.isEmpty(paramString)) {
          paramString = new JSONArray();
        } else {
          paramString = new JSONArray(paramString);
        }
      }
      catch (JSONException paramContext)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        ArrayList localArrayList;
        QLog.d("PatchLogTag", 1, "PatchConfigManager appendPatchConfigToDisk", paramContext);
      }
      if (i < paramString.length())
      {
        localObject2 = paramString.getJSONObject(i);
        if (localObject2 != null)
        {
          localObject3 = new PatchConfig((JSONObject)localObject2).a();
          if (("dex".equals(localObject3)) || ("Native".equals(localObject3))) {
            if (((HashMap)localObject1).containsKey(localObject3))
            {
              ((ArrayList)((HashMap)localObject1).get(localObject3)).add(localObject2);
            }
            else
            {
              localArrayList = new ArrayList();
              localArrayList.add(localObject2);
              ((HashMap)localObject1).put(localObject3, localArrayList);
            }
          }
        }
      }
      else
      {
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (Map.Entry)((Iterator)localObject1).next();
          localObject2 = (String)((Map.Entry)localObject3).getKey();
          paramString = PatchSharedPreUtil.getPatchConfig(paramContext, (String)localObject2);
          if (TextUtils.isEmpty(paramString)) {
            paramString = new JSONArray();
          } else {
            paramString = new JSONArray(paramString);
          }
          localObject3 = ((ArrayList)((Map.Entry)localObject3).getValue()).iterator();
          if (((Iterator)localObject3).hasNext())
          {
            paramString.put((JSONObject)((Iterator)localObject3).next());
            continue;
          }
          PatchSharedPreUtil.updatePatchConfig(paramContext, (String)localObject2, paramString.toString());
          continue;
        }
        return;
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfigManager
 * JD-Core Version:    0.7.0.1
 */