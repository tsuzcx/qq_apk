import android.text.TextUtils;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aqzh
  implements aqwv<String>
{
  public HashMap<String, String> a = new HashMap();
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      ArkAppCenter.c("ArkAIKeyWordSDKShareConfig", "onParse,fileOrRes is null");
    }
    for (;;)
    {
      return;
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
            QLog.i("ArkAIKeyWordSDKShareConfig", 1, "onParse ark_ai_keyword_sdk_share_app_info id=" + str + ", name=" + (String)localObject);
            this.a.put(str, localObject);
            i += 1;
          }
        }
        ArkAppCenter.c("ArkAIKeyWordSDKShareConfig", "getArkShareConfig,ark_ai_keyword_sdk_share_app_info is empty");
        return;
      }
      catch (JSONException paramString)
      {
        QLog.e("ArkAIKeyWordSDKShareConfig", 1, "onParse error e = ", paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqzh
 * JD-Core Version:    0.7.0.1
 */