package com.tencent.mobileqq.activity.pendant;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PendantMarketConfig
{
  public static List<PendantMarketConfig.EntryConfig> a;
  
  public static void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("entryList")))
    {
      paramJSONObject = paramJSONObject.optJSONArray("entryList");
      ArrayList localArrayList = new ArrayList();
      int j = paramJSONObject.length();
      int i = 2;
      if (j <= 2) {
        i = paramJSONObject.length();
      }
      j = 0;
      while (j < i)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject(j);
        PendantMarketConfig.EntryConfig localEntryConfig = new PendantMarketConfig.EntryConfig();
        localEntryConfig.jdField_a_of_type_Int = localJSONObject.optInt("id");
        Object localObject = localJSONObject.optJSONObject("image");
        if (localObject != null)
        {
          localObject = ((JSONObject)localObject).optString("src");
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("https://gxh.vip.qq.com/xydata");
            localStringBuilder.append((String)localObject);
            localEntryConfig.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
          }
        }
        localEntryConfig.c = localJSONObject.optString("name");
        localEntryConfig.d = localJSONObject.optString("desc");
        localEntryConfig.jdField_b_of_type_JavaLangString = localJSONObject.optString("url");
        localEntryConfig.jdField_a_of_type_Boolean = localJSONObject.optBoolean("isShow", true);
        localEntryConfig.jdField_b_of_type_Int = localJSONObject.optInt("tag", 0);
        localArrayList.add(localEntryConfig);
        j += 1;
      }
      a = localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.PendantMarketConfig
 * JD-Core Version:    0.7.0.1
 */