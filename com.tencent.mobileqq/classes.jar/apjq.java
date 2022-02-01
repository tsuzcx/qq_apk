import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import org.json.JSONObject;

public class apjq
  implements apjp
{
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    paramString2 = BaseActivity.sTopActivity;
    if (paramString2 == null) {
      return false;
    }
    if (paramString1.startsWith("open/")) {
      try
      {
        int j = Integer.parseInt(paramString1.substring("open/".length(), paramString1.indexOf("?")));
        paramJSONObject = (String)bkgj.a(paramString1).get("url");
        int i = j;
        if (j != 1007)
        {
          i = j;
          if (j != 1008)
          {
            i = j;
            if (j != 1014)
            {
              i = j;
              if (j != 1036)
              {
                i = j;
                if (j != 2061)
                {
                  i = j;
                  if (j != 2072)
                  {
                    i = j;
                    if (j != 2075)
                    {
                      i = j;
                      if (j != 2085)
                      {
                        i = j;
                        if (j != 2105)
                        {
                          i = j;
                          if (j != 4012) {
                            i = 2059;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        MiniAppLauncher.startMiniApp(paramString2, paramJSONObject, i, apjm.a(), null);
        return true;
      }
      catch (Exception paramString2)
      {
        QLog.e("ArkApp", 1, "parse miniapp scheme failed:" + paramString1, paramString2);
        return false;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjq
 * JD-Core Version:    0.7.0.1
 */