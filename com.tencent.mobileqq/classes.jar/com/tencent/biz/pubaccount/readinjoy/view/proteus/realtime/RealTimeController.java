package com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.loaders.StyleLoaderHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class RealTimeController
{
  private static Map<String, RealTimeController.DefaultRealTimeConfig> a = new ConcurrentHashMap();
  
  static
  {
    a();
  }
  
  public static RealTimeTemplateFactory a(String paramString)
  {
    if (a.containsKey(paramString))
    {
      paramString = (RealTimeController.DefaultRealTimeConfig)a.get(paramString);
      if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeStyleLoaderHelper != null)) {
        return paramString.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeStyleLoaderHelper.a();
      }
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject;
    try
    {
      localObject = (RealTimeController.DefaultRealTimeConfig)a.get(paramString);
      localJSONObject.put("app", "QQ");
      localJSONObject.put("appVersion", "8.5.5");
      localJSONObject.put("businessID", ((RealTimeController.DefaultRealTimeConfig)localObject).b);
      localJSONObject.put("os", "android");
      localObject = new JSONObject();
      paramString = RealTimeTemplateFactory.a(paramString, false);
      if (paramString != null)
      {
        paramString = paramString.a().entrySet().iterator();
        while (paramString.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramString.next();
          ((JSONObject)localObject).put((String)localEntry.getKey(), localEntry.getValue());
          continue;
          return localJSONObject.toString();
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.d("RealTimeController", 1, "", paramString);
    }
    for (;;)
    {
      localJSONObject.put("styles", localObject);
      QLog.d("RealTimeController", 1, "styles: " + localJSONObject);
    }
  }
  
  private static void a()
  {
    a(new RealTimeController.DefaultRealTimeConfig("default_feeds", "1"));
  }
  
  public static void a(RealTimeController.DefaultRealTimeConfig paramDefaultRealTimeConfig)
  {
    if ((paramDefaultRealTimeConfig.jdField_a_of_type_JavaLangString == null) || (paramDefaultRealTimeConfig.b == null)) {
      return;
    }
    a.put(paramDefaultRealTimeConfig.jdField_a_of_type_JavaLangString, paramDefaultRealTimeConfig);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    QLog.d("RealTimeController", 1, "serviceKey:" + paramString1 + " styles:" + paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    RealTimeController.DefaultRealTimeConfig localDefaultRealTimeConfig;
    do
    {
      return;
      localDefaultRealTimeConfig = (RealTimeController.DefaultRealTimeConfig)a.get(paramString1);
    } while (localDefaultRealTimeConfig == null);
    paramString1 = RealTimeTemplateFactory.a(paramString1, true);
    if (paramString1 == null)
    {
      QLog.d("RealTimeController", 1, "realTimeTemplateFactory == null styles:" + paramString2);
      return;
    }
    for (;;)
    {
      try
      {
        paramString1.a(StyleLoaderHelper.a());
        localObject = new JSONObject(paramString2);
        paramString2 = ((JSONObject)localObject).getString("businessID");
        QLog.d("RealTimeController", 1, "realTimeBusinessID: " + paramString2);
        paramString2 = ((JSONObject)localObject).getJSONArray("styleList");
        if (!((JSONObject)localObject).has("deleteList")) {
          break label282;
        }
        localObject = ((JSONObject)localObject).getJSONArray("deleteList");
        ArrayList localArrayList = new ArrayList();
        i = 0;
        if (i < ((JSONArray)localObject).length())
        {
          String str = ((JSONArray)localObject).getString(i);
          localArrayList.add(str);
          paramString1.d(str);
          i += 1;
          continue;
        }
        localDefaultRealTimeConfig.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeStyleLoaderHelper.a(localArrayList);
      }
      catch (Exception paramString1)
      {
        Object localObject;
        QLog.d("RealTimeController", 1, "", paramString1);
        return;
      }
      if (i >= paramString2.length()) {
        break;
      }
      localObject = (JSONObject)paramString2.get(i);
      localDefaultRealTimeConfig.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusRealtimeRealTimeStyleLoaderHelper.a(paramString1, (JSONObject)localObject, true);
      i += 1;
      continue;
      label282:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.realtime.RealTimeController
 * JD-Core Version:    0.7.0.1
 */