package com.tencent.gamecenter.appointment;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.mobileqq.gamecenter.util.QQGameConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameCenterUtils
{
  public static LruCache<String, List<String>> a = new LruCache(10);
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramAppInterface, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, null);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, Map<Integer, String> paramMap)
  {
    paramAppInterface = new WadlReportBuilder();
    paramAppInterface.a("dc00087").h(paramString1).c(paramString2).b(paramString3).a(1, paramString4).a(11, paramString5).a(12, paramString6);
    if ((paramMap != null) && (paramMap.keySet().size() > 0))
    {
      paramString1 = paramMap.entrySet().iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (Map.Entry)paramString1.next();
        paramAppInterface.a(((Integer)paramString2.getKey()).intValue(), (String)paramString2.getValue());
      }
    }
    paramAppInterface.a();
  }
  
  public static void a(Map<Integer, String> paramMap, String paramString)
  {
    if (paramMap == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        if ((!TextUtils.isEmpty(paramString)) && (QQGameConstant.b != null))
        {
          Object localObject1 = (List)a.get(paramString);
          i = 0;
          int j = 0;
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("GameCenterUtils", 1, "get _orted_configs from cache");
              i = j;
            }
            if (i < ((List)localObject1).size())
            {
              paramMap.put(Integer.valueOf(15 + i), ((List)localObject1).get(i));
              i += 1;
              continue;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("GameCenterUtils", 1, "get _orted_configs from msg decode");
            }
            localObject1 = QQGameConstant.b;
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append("_orted_configs");
            localObject1 = (String)((Map)localObject1).get(((StringBuilder)localObject2).toString());
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("get _orted_configs from msg decode orted_configs = ");
                ((StringBuilder)localObject2).append((String)localObject1);
                QLog.d("GameCenterUtils", 1, ((StringBuilder)localObject2).toString());
              }
              localObject1 = new JSONArray((String)localObject1);
              localObject2 = new ArrayList();
              if (i < ((JSONArray)localObject1).length())
              {
                JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
                Iterator localIterator = localJSONObject.keys();
                if (!localIterator.hasNext()) {
                  break label374;
                }
                String str = localJSONObject.optString((String)localIterator.next());
                paramMap.put(Integer.valueOf(15 + i), str);
                ((List)localObject2).add(i, str);
                continue;
              }
              a.put(paramString, localObject2);
              return;
            }
          }
        }
      }
      catch (Throwable paramMap)
      {
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("get _orted_configs err=");
          paramString.append(paramMap.toString());
          QLog.d("GameCenterUtils", 1, paramString.toString());
        }
        paramMap.printStackTrace();
      }
      return;
      label374:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.appointment.GameCenterUtils
 * JD-Core Version:    0.7.0.1
 */