package com.tencent.liteav.basic.d;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.liteav.basic.log.TXCLog;
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

public class b
{
  private final Map<String, String> a = new HashMap();
  private JSONObject b = null;
  
  private int a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Build.MANUFACTURER, paramJSONObject.optString("MANUFACTURER")));
    localArrayList.add(new Pair(Build.MODEL, paramJSONObject.optString("MODEL")));
    localArrayList.add(new Pair(String.valueOf(Build.VERSION.SDK_INT), paramJSONObject.optString("VERSION")));
    localArrayList.add(new Pair(Build.VERSION.INCREMENTAL, paramJSONObject.optString("VERSION_INCREMENTAL")));
    localArrayList.add(new Pair(Build.DISPLAY, paramJSONObject.optString("DISPLAY")));
    int i = 0;
    while (i < localArrayList.size())
    {
      paramJSONObject = (Pair)localArrayList.get(i);
      if (TextUtils.isEmpty((CharSequence)paramJSONObject.second)) {
        return i;
      }
      if (!((String)paramJSONObject.first).equalsIgnoreCase((String)paramJSONObject.second)) {
        return 0;
      }
      i += 1;
    }
    return localArrayList.size();
  }
  
  private void a(Map<String, String> paramMap, String paramString, JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      StringBuilder localStringBuilder;
      if ((localObject instanceof JSONObject))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".");
        localStringBuilder.append(str);
        a(paramMap, localStringBuilder.toString(), (JSONObject)localObject);
      }
      else if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(".");
        localStringBuilder.append(str);
        paramMap.put(localStringBuilder.toString(), localObject.toString());
      }
    }
  }
  
  private JSONObject b(JSONArray paramJSONArray)
  {
    Object localObject3 = null;
    localObject2 = localObject3;
    if (paramJSONArray != null)
    {
      if (paramJSONArray.length() == 0) {
        return null;
      }
      Object localObject1 = null;
      int i = 0;
      int j = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          localObject2 = paramJSONArray.getJSONObject(i);
          int m = a(((JSONObject)localObject2).optJSONObject("deviceinfo"));
          JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject("deviceconfig");
          int k = j;
          localObject2 = localObject1;
          if (m > j)
          {
            k = j;
            localObject2 = localObject1;
            if (localJSONObject != null)
            {
              localObject2 = localJSONObject;
              k = m;
            }
          }
          i += 1;
          j = k;
          localObject1 = localObject2;
        }
        return localObject2;
      }
      catch (JSONException paramJSONArray)
      {
        TXCLog.e("CompatibleConfig", "Find best match value failed.", paramJSONArray);
        TXCLog.i("CompatibleConfig", "bestMatchLevel: %d", new Object[] { Integer.valueOf(j) });
        localObject2 = localObject3;
        if (j > 0) {
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(" : ");
      localStringBuilder.append((String)localEntry.getValue());
      localStringBuilder.append("\n");
    }
    TXCLog.i("CompatibleConfig", localStringBuilder.toString());
  }
  
  public long a(String paramString, long paramLong)
  {
    long l;
    label38:
    try
    {
      paramString = (String)this.a.get(paramString);
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {}
    }
    finally {}
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      break label38;
    }
    return paramLong;
    return paramLong;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = this.b;
      return localJSONObject;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      try
      {
        this.a.clear();
        this.b = new JSONObject(paramString);
        a(this.a, "", this.b);
        b();
      }
      catch (JSONException paramString)
      {
        TXCLog.e("CompatibleConfig", "parse best match value failed.", paramString);
      }
      return;
    }
    finally {}
  }
  
  public void a(JSONArray paramJSONArray)
  {
    try
    {
      this.a.clear();
      this.b = b(paramJSONArray);
      if (this.b == null)
      {
        TXCLog.i("CompatibleConfig", "can't find best match value");
        return;
      }
      a(this.a, "", this.b);
      b();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.d.b
 * JD-Core Version:    0.7.0.1
 */