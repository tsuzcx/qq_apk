package com.tencent.featuretoggle.net;

import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import com.tencent.featuretoggle.SpManager;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.mmkv.MMKVPersitence;
import com.tencent.featuretoggle.models.DatasetEntity;
import com.tencent.featuretoggle.models.FeatureResult;
import com.tencent.featuretoggle.models.QueryFeatureResp;
import com.tencent.featuretoggle.models.TimeLimit;
import com.tencent.featuretoggle.utils.JSONUtil;
import com.tencent.featuretoggle.utils.LogUtils;
import com.tencent.featuretoggle.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class CacheManager
{
  private static LruCache<String, FeatureResult> a = new LruCache(ToggleSetting.b());
  private Set<Integer> b = new HashSet();
  private SparseArray<String> c = new SparseArray();
  private volatile boolean d = true;
  
  public static CacheManager a()
  {
    return CacheManager.CacheManagerHolder.a;
  }
  
  private void a(MMKVPersitence paramMMKVPersitence)
  {
    paramMMKVPersitence.b();
    this.c.clear();
    a.evictAll();
  }
  
  private void a(List<FeatureResult> paramList, MMKVPersitence paramMMKVPersitence)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      List localList = Collections.EMPTY_LIST;
      Object localObject = paramMMKVPersitence.c();
      if (localObject != null) {
        localList = Arrays.asList((Object[])localObject);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (FeatureResult)paramList.next();
        if ((localObject != null) && (!Utils.a(((FeatureResult)localObject).name)))
        {
          this.c.put(((FeatureResult)localObject).id, ((FeatureResult)localObject).name);
          if ((localList != null) && (localList.contains(((FeatureResult)localObject).name)) && ((((FeatureResult)localObject).refreshType == 2) || ((((FeatureResult)localObject).refreshType == 3) && (!this.d))))
          {
            FeatureResult localFeatureResult = b(((FeatureResult)localObject).name);
            if (localFeatureResult == null) {
              continue;
            }
            ((FeatureResult)localObject).result = localFeatureResult.result;
            ((FeatureResult)localObject).isAbtFirst = localFeatureResult.isAbtFirst;
            ((FeatureResult)localObject).timeLimitType = localFeatureResult.timeLimitType;
            ((FeatureResult)localObject).timeLimits = localFeatureResult.timeLimits;
            this.b.add(Integer.valueOf(((FeatureResult)localObject).id));
          }
          else
          {
            this.b.remove(Integer.valueOf(((FeatureResult)localObject).id));
          }
          if (a.get(((FeatureResult)localObject).name) != null) {
            a.put(((FeatureResult)localObject).name, localObject);
          }
          paramMMKVPersitence.a(((FeatureResult)localObject).name, ((FeatureResult)localObject).toJsonString());
        }
      }
      a(this.b);
    }
  }
  
  private FeatureResult b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    LruCache localLruCache = a;
    Object localObject1 = localObject2;
    if (localLruCache != null)
    {
      localObject1 = localObject2;
      if (localLruCache.size() > 0) {
        localObject1 = (FeatureResult)a.get(paramString);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = localObject1;
      if (SpManager.a().f(paramString)) {
        localObject2 = a().a(paramString);
      }
    }
    return localObject2;
  }
  
  private void b(List<Integer> paramList, MMKVPersitence paramMMKVPersitence)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        String str = (String)this.c.get(localInteger.intValue());
        a.remove(str);
        paramMMKVPersitence.a(str);
        this.c.remove(localInteger.intValue());
      }
    }
  }
  
  public FeatureResult a(String paramString)
  {
    paramString = SpManager.a().a(paramString, "");
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        paramString = new FeatureResult();
        paramString.id = localJSONObject.getInt("id");
        paramString.name = localJSONObject.getString("name");
        paramString.result = localJSONObject.getString("result");
        paramString.isAbtFirst = localJSONObject.optBoolean("isAbtFirst");
        paramString.timeLimitType = localJSONObject.optInt("timeLimitType", 1);
        paramString.refreshType = localJSONObject.optInt("refreshType", 1);
        paramString.extendField = JSONUtil.a(localJSONObject.optString("extendField"));
        Object localObject1 = localJSONObject.optJSONArray("timeLimits");
        Object localObject2 = new ArrayList();
        Object localObject3;
        if (localObject1 != null)
        {
          int j = ((JSONArray)localObject1).length();
          i = 0;
          if (i < j)
          {
            localObject3 = ((JSONArray)localObject1).getJSONObject(i);
            if (localObject3 == null) {
              break label409;
            }
            ((ArrayList)localObject2).add(new TimeLimit(((JSONObject)localObject3).optString("startTime"), ((JSONObject)localObject3).optString("endTime")));
            break label409;
          }
        }
        paramString.timeLimits = ((ArrayList)localObject2);
        localObject1 = new DatasetEntity(0, 0, new HashMap(), 0, "", "");
        localJSONObject = localJSONObject.optJSONObject("dataset");
        if (localJSONObject != null)
        {
          ((DatasetEntity)localObject1).setDatasetId(localJSONObject.optInt("datasetId"));
          ((DatasetEntity)localObject1).setVersionId(localJSONObject.optInt("versionId"));
          ((DatasetEntity)localObject1).setWeight(localJSONObject.optInt("weight"));
          localObject2 = localJSONObject.optJSONObject("data");
          if (localObject2 != null)
          {
            localObject3 = ((JSONObject)localObject2).keys();
            if (((Iterator)localObject3).hasNext())
            {
              String str1 = String.valueOf(((Iterator)localObject3).next());
              String str2 = String.valueOf(((JSONObject)localObject2).get(str1));
              ((DatasetEntity)localObject1).getData().put(str1, str2);
              continue;
            }
          }
          ((DatasetEntity)localObject1).setType(localJSONObject.optString("type"));
          ((DatasetEntity)localObject1).setValue(localJSONObject.optString("value"));
        }
        paramString.dataset = ((DatasetEntity)localObject1);
        return paramString;
      }
      catch (Throwable paramString)
      {
        if (!LogUtils.a(paramString)) {
          paramString.printStackTrace();
        }
        return null;
      }
      label409:
      i += 1;
    }
  }
  
  void a(QueryFeatureResp paramQueryFeatureResp)
  {
    SpManager.a().a(paramQueryFeatureResp.timestamp);
    SpManager.a().b(paramQueryFeatureResp.serverTime);
    a(paramQueryFeatureResp.data, paramQueryFeatureResp.deletedFeatures, paramQueryFeatureResp.increment);
  }
  
  public boolean a(List<FeatureResult> paramList, List<Integer> paramList1, boolean paramBoolean)
  {
    if (ToggleSetting.j() == null) {
      return false;
    }
    try
    {
      MMKVPersitence localMMKVPersitence = SpManager.a().g(SpManager.a);
      if (localMMKVPersitence == null) {
        return false;
      }
      if (paramBoolean) {
        b(paramList1, localMMKVPersitence);
      } else {
        a(localMMKVPersitence);
      }
      a(paramList, localMMKVPersitence);
      this.d = false;
      return true;
    }
    catch (Throwable paramList)
    {
      if (!LogUtils.a(paramList)) {
        paramList.printStackTrace();
      }
    }
    return false;
  }
  
  public boolean a(Set<Integer> paramSet)
  {
    if (paramSet == null) {
      return false;
    }
    try
    {
      paramSet = new JSONArray(paramSet);
      SpManager.a().e(paramSet.toString());
      return true;
    }
    catch (Throwable paramSet)
    {
      if (!LogUtils.a(paramSet)) {
        paramSet.printStackTrace();
      }
    }
    return false;
  }
  
  public void b()
  {
    try
    {
      this.b.clear();
      Object localObject = SpManager.a().h();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new JSONArray((String)localObject);
        int j = ((JSONArray)localObject).length();
        int i = 0;
        while (i < j)
        {
          this.b.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!LogUtils.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public LruCache<String, FeatureResult> c()
  {
    return a;
  }
  
  public void d()
  {
    LruCache localLruCache = a;
    if (localLruCache != null) {
      localLruCache.evictAll();
    }
  }
  
  public Set<Integer> e()
  {
    return this.b;
  }
  
  public SparseArray<String> f()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.net.CacheManager
 * JD-Core Version:    0.7.0.1
 */