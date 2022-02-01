package com.tencent.mobileqq.ark.config.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAIKeyWordSDKShareConfig
  implements IQStorageSafable<String>
{
  public HashMap<String, String> a = new HashMap();
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("ArkAIKeyWordSDKShareConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("ark_ai_keyword_sdk_share_app_info");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          Object localObject = (JSONObject)paramString.get(i);
          String str = ((JSONObject)localObject).getString("appID");
          localObject = ((JSONObject)localObject).getString("appName");
          StringBuilder localStringBuilder = new StringBuilder("onParse ark_ai_keyword_sdk_share_app_info id=");
          localStringBuilder.append(str);
          localStringBuilder.append(", name=");
          localStringBuilder.append((String)localObject);
          QLog.i("ArkAIKeyWordSDKShareConfig", 1, localStringBuilder.toString());
          this.a.put(str, localObject);
          i += 1;
        }
      }
      QLog.i("ArkAIKeyWordSDKShareConfig", 1, "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("ArkAIKeyWordSDKShareConfig", 1, "onParse error e = ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.config.ArkAIKeyWordSDKShareConfig
 * JD-Core Version:    0.7.0.1
 */