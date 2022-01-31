package com.tencent.hotpatch.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.hotpatch.utils.PatchSharedPreUtil;
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
import qno;

public class PatchConfigManager
{
  public static BasePatchConfig a(Context paramContext, String paramString)
  {
    paramContext = PatchSharedPreUtil.a(paramContext, paramString);
    paramString = new ArrayList();
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramContext))
        {
          paramContext = new JSONArray();
          break label130;
          if (i < paramContext.length())
          {
            Object localObject = paramContext.getJSONObject(i);
            if (localObject == null) {
              break label135;
            }
            localObject = a(((JSONObject)localObject).toString());
            if (localObject == null) {
              break label135;
            }
            paramString.add(localObject);
            break label135;
          }
        }
        else
        {
          paramContext = new JSONArray(paramContext);
        }
      }
      catch (JSONException paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchConfigManager getLatestPatchConfig", paramContext);
        if (paramString.size() > 1) {
          Collections.sort(paramString, new qno());
        }
        if (paramString.size() > 0) {
          return (BasePatchConfig)paramString.get(0);
        }
        return null;
      }
      label130:
      int i = 0;
      continue;
      label135:
      i += 1;
    }
  }
  
  public static BasePatchConfig a(String paramString)
  {
    String str = BasePatchConfig.a(paramString);
    if ("dex".equals(str))
    {
      if (PatchCommonUtil.a()) {
        return new DexPatchConfigDalvik(paramString);
      }
      if (PatchCommonUtil.b()) {
        return new DexPatchConfigArtBeforeN(paramString);
      }
      if (PatchCommonUtil.c()) {
        return new DexPatchConfigArtAfterN(paramString);
      }
    }
    else if ("Native".equals(str))
    {
      return new NativePatchConfig(paramString);
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject3;
      try
      {
        localObject1 = new HashMap();
        if (TextUtils.isEmpty(paramString))
        {
          paramString = new JSONArray();
          break label287;
          if (i >= paramString.length()) {
            break label155;
          }
          localObject2 = paramString.getJSONObject(i);
          if (localObject2 == null) {
            break label292;
          }
          localObject3 = BasePatchConfig.a(((JSONObject)localObject2).toString());
          if ((!"dex".equals(localObject3)) && (!"Native".equals(localObject3))) {
            break label292;
          }
          if (((HashMap)localObject1).containsKey(localObject3))
          {
            ((ArrayList)((HashMap)localObject1).get(localObject3)).add(localObject2);
            break label292;
          }
        }
        else
        {
          paramString = new JSONArray(paramString);
          break label287;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(localObject2);
        ((HashMap)localObject1).put(localObject3, localArrayList);
      }
      catch (JSONException paramContext)
      {
        QLog.d("PatchLogTag", 1, "PatchConfigManager appendPatchConfigToDisk", paramContext);
        return;
      }
      label155:
      Object localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject1).next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        paramString = PatchSharedPreUtil.a(paramContext, (String)localObject2);
        if (TextUtils.isEmpty(paramString)) {}
        for (paramString = new JSONArray();; paramString = new JSONArray(paramString))
        {
          localObject3 = ((ArrayList)((Map.Entry)localObject3).getValue()).iterator();
          while (((Iterator)localObject3).hasNext()) {
            paramString.put((JSONObject)((Iterator)localObject3).next());
          }
        }
        PatchSharedPreUtil.a(paramContext, (String)localObject2, paramString.toString());
      }
      continue;
      label287:
      int i = 0;
      continue;
      label292:
      i += 1;
    }
  }
  
  public static void a(Context paramContext, String paramString, BasePatchConfig paramBasePatchConfig)
  {
    int i = 0;
    try
    {
      Object localObject = PatchSharedPreUtil.a(paramContext, paramString);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        i = 1;
      }
      while (i != 0)
      {
        localObject = new JSONArray();
        ((JSONArray)localObject).put(new JSONObject(paramBasePatchConfig.a()));
        PatchSharedPreUtil.a(paramContext, paramString, ((JSONArray)localObject).toString());
        return;
        localObject = new JSONArray((String)localObject);
        if (((JSONArray)localObject).length() == 1)
        {
          localObject = a(((JSONArray)localObject).getJSONObject(0).toString());
          if (localObject != null)
          {
            int j = ((BasePatchConfig)localObject).a;
            int k = paramBasePatchConfig.a;
            if (j >= k) {}
          }
          else
          {
            i = 1;
          }
        }
        else
        {
          i = 1;
        }
      }
      return;
    }
    catch (JSONException paramContext)
    {
      QLog.d("PatchLogTag", 1, "PatchConfigManager updatePatchConfigToDisk", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfigManager
 * JD-Core Version:    0.7.0.1
 */