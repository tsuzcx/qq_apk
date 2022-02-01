import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.mobileqq.utils.BusinessCommonConfig;
import com.tencent.mobileqq.utils.confighandler.ConfigHandler;
import com.tencent.qphone.base.util.QLog;

public class bgax
{
  public static int a(String paramString)
  {
    int i = 0;
    paramString = b(paramString);
    if (paramString != null) {
      i = ConfigHandler.getConfigVer(paramString, "config", "ver");
    }
    return i;
  }
  
  public static SharedPreferences a(String paramString)
  {
    return bgay.a(anzv.a, paramString, "config_qq.android.ar_");
  }
  
  public static SharedPreferences a(String paramString1, String paramString2)
  {
    return bgay.a(anzv.a, paramString1, "res_qq.android.ar_" + paramString2);
  }
  
  public static PromotionConfigInfo a(String paramString1, String paramString2)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2))
        {
          Object localObject = a(paramString1);
          if (localObject != null)
          {
            paramString2 = ((SharedPreferences)localObject).getString("config", null);
            QLog.w(anzv.a, 1, "ConfigInfo.get, step[" + i + "], configText[" + paramString2 + "]");
            localObject = new PromotionConfigInfo();
            ((PromotionConfigInfo)localObject).setUin(paramString1);
            if (!TextUtils.isEmpty(paramString2)) {
              ((PromotionConfigInfo)localObject).tryParse(anzv.a, paramString2);
            }
            return localObject;
          }
          i = 2;
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject = null;
    SharedPreferences localSharedPreferences = b(paramString);
    paramString = localObject;
    if (localSharedPreferences != null) {
      paramString = localSharedPreferences.getString("config", null);
    }
    return paramString;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    BusinessCommonConfig.saveMd5(anzv.a, a(paramString1, paramString2), "md5_" + paramInt, paramString3);
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    return BusinessCommonConfig.isResReady(anzv.a + "_" + paramString2, a(paramString1, paramString2), "md5_" + paramInt, paramString3, paramString4);
  }
  
  public static int b(String paramString)
  {
    int i = 0;
    paramString = a(paramString);
    if (paramString != null) {
      i = ConfigHandler.getConfigVer(paramString, "config", "ver");
    }
    return i;
  }
  
  public static SharedPreferences b(String paramString)
  {
    return bgay.a(anzv.a, paramString, "res_qq.android.ar_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgax
 * JD-Core Version:    0.7.0.1
 */