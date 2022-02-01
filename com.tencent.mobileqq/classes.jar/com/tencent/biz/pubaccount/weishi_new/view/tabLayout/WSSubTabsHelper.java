package com.tencent.biz.pubaccount.weishi_new.view.tabLayout;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class WSSubTabsHelper
{
  public static WSSubTabData a(String paramString)
  {
    Object localObject1 = a(paramString);
    if (localObject1 == null) {
      return null;
    }
    paramString = ((JSONObject)localObject1).optString("showType");
    localObject1 = ((JSONObject)localObject1).optJSONArray("subTabs");
    if (localObject1 == null)
    {
      WSLog.d("WSSubTabsHelper", "[WSSubTabsHelper.java] subTabs is null!!!");
      return null;
    }
    WSSubTabData localWSSubTabData = new WSSubTabData();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
      String str1 = ((JSONObject)localObject2).optString("id");
      String str2 = ((JSONObject)localObject2).optString("title");
      localObject2 = ((JSONObject)localObject2).optString("subTitle");
      localArrayList.add(new WSTabInfo(str2).a(str1).b((String)localObject2));
      i += 1;
    }
    localWSSubTabData.a(paramString);
    localWSSubTabData.a(localArrayList);
    return localWSSubTabData;
  }
  
  public static List<WSTabInfo> a(WSSubTabData paramWSSubTabData)
  {
    Object localObject = new ArrayList();
    if ((paramWSSubTabData == null) || (paramWSSubTabData.a == null) || (paramWSSubTabData.a.size() == 0)) {
      return localObject;
    }
    int i = 0;
    if (i < paramWSSubTabData.a.size())
    {
      localObject = (WSTabInfo)paramWSSubTabData.a.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        ((WSTabInfo)localObject).a(false).a(16);
      }
    }
    return paramWSSubTabData.a;
  }
  
  private static JSONObject a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      WSLog.d("WSSubTabsHelper", "[WSSubTabsHelper.java][getJsonObj] jsonStr is null!");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      WSLog.d("WSSubTabsHelper", "[WSSubTabsHelper.java] getJsonObj return null!!!");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper
 * JD-Core Version:    0.7.0.1
 */