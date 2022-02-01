import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class bcnf
{
  public static String a;
  
  public static int a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + localBaseApplicationImpl.getRuntime().getAccount(), 4).getInt("search_url_config_version" + localBaseApplicationImpl.getRuntime().getAccount(), 0);
  }
  
  public static String a(int paramInt)
  {
    String str = bcjy.a(paramInt);
    return str + "_" + "websearch";
  }
  
  @NonNull
  public static String a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  source=" + paramInt);
    }
    String str1 = null;
    Object localObject = BaseApplicationImpl.getApplication();
    String str2 = ((BaseApplicationImpl)localObject).getRuntime().getAccount();
    localObject = ((BaseApplicationImpl)localObject).getSharedPreferences("SearchConfigUtils_Switch" + ((BaseApplicationImpl)localObject).getRuntime().getAccount(), 4);
    int i = ((SharedPreferences)localObject).getInt("kFTSEnhanceOnlyNetSearchJumpToWeb" + str2, 1);
    if (i == 1) {
      str1 = ((SharedPreferences)localObject).getString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb" + str2, "");
    }
    if (!TextUtils.isEmpty(str1)) {}
    for (paramString = str1.replace("$SOURCE$", "" + paramInt).replace("$FROM$", "" + URLEncoder.encode(paramString)).replace("$SEARCHID$", "" + URLEncoder.encode(UniteSearchActivity.c)).replace("$SEQNO$", "" + URLEncoder.encode(UniteSearchActivity.d));; paramString = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$".replace("$SOURCE$", "" + paramInt).replace("$FROM$", "" + URLEncoder.encode(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isSearchEnhanceEnable() uin=" + str2 + " resultUrl=" + paramString + " enhanceEnableForJumpToWeb=" + i);
      }
      return paramString;
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject = (arpd)aran.a().a(456);
    if (localObject != null) {}
    for (localObject = ((arpd)localObject).a(paramString);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isVerticalSerachSwitchOn. bizType = " + paramString + "， result = " + (String)localObject);
      }
      return localObject;
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.contains("from=native_relate_search")) {
      return paramString;
    }
    return paramString.replace("from=native_relate_search", "from=" + a(paramInt));
  }
  
  public static String a(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  word=" + paramString1 + "  source=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return a(paramInt, paramString2).replace("$KEYWORD$", Uri.encode(paramString1));
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrl()  word=" + paramString2 + "  source=" + paramInt);
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = null;
      return paramString2;
    }
    if (!TextUtils.isEmpty(paramString1)) {}
    for (paramString1 = paramString1.replace("$KEYWORD$", Uri.encode(paramString2)).replace("$SOURCE$", "" + paramInt).replace("$FROM$", "" + URLEncoder.encode(paramString3));; paramString1 = "https://sou.qq.com/kandian/kd.html?_bid=3216&_wv=3&_wwv=1293&_wvSb=0&keyword=$KEYWORD$&from=$FROM$".replace("$KEYWORD$", Uri.encode(paramString2)).replace("$SOURCE$", "" + paramInt).replace("$FROM$", "" + URLEncoder.encode(paramString3)))
    {
      paramString2 = paramString1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.uniteSearch.SearchConfigUtils", 2, "getNetSearchJumpUrlWithUrl " + paramString1);
      return paramString1;
    }
  }
  
  public static void a(ConfigurationService.Config paramConfig)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    Object localObject = localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + localBaseApplicationImpl.getRuntime().getAccount(), 4);
    int i = paramConfig.version.get();
    int j = ((SharedPreferences)localObject).getInt("search_url_config_version" + localBaseApplicationImpl.getRuntime().getAccount(), 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig. newVersion=" + i + " oldVersion=" + j);
    }
    if (i <= j) {}
    label724:
    do
    {
      do
      {
        return;
        if (paramConfig.msg_content_list.size() <= 0) {
          break;
        }
        paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      } while (paramConfig == null);
      if (paramConfig.compress.get() == 1)
      {
        paramConfig = azet.a(paramConfig.content.get().toByteArray());
        if (paramConfig == null) {}
      }
      for (;;)
      {
        try
        {
          paramConfig = new String(paramConfig, "UTF-8");
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig,xmlContent:" + paramConfig);
          }
          if (paramConfig == null) {
            break;
          }
          localObject = ((SharedPreferences)localObject).edit();
          ((SharedPreferences.Editor)localObject).putInt("search_url_config_version" + localBaseApplicationImpl.getRuntime().getAccount(), i);
          ((SharedPreferences.Editor)localObject).commit();
          try
          {
            paramConfig = new JSONObject(paramConfig);
            i = paramConfig.optInt("kFTSEnhanceOnlyNetSearchJumpToWeb");
            String str1 = paramConfig.optString("kFTSEnhanceNetSearchJumpUrlForEnhance");
            String str2 = paramConfig.optString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb");
            String str3 = paramConfig.optString("kFTSReadInJoySearchPlaceholderPrefix");
            String str4 = paramConfig.optString("kFTSDynamicTabSearchPlaceholderPrefix");
            String str5 = "kFTSDynamicTabSearchBarDontShow" + localBaseApplicationImpl.getRuntime().getAccount();
            if (paramConfig.optInt("kFTSDynamicTabSearchBarDontShow") != 1) {
              break label724;
            }
            bool = true;
            ((SharedPreferences.Editor)localObject).putBoolean(str5, bool);
            ((SharedPreferences.Editor)localObject).putInt("kFTSEnhanceOnlyNetSearchJumpToWeb" + localBaseApplicationImpl.getRuntime().getAccount(), i);
            if (!TextUtils.isEmpty(str1)) {
              ((SharedPreferences.Editor)localObject).putString("kFTSEnhanceNetSearchJumpUrlForEnhance" + localBaseApplicationImpl.getRuntime().getAccount(), str1);
            }
            if (!TextUtils.isEmpty(str2)) {
              ((SharedPreferences.Editor)localObject).putString("kFTSEnhanceNetSearchJumpUrlForOnlyNetSearchJumpToWeb" + localBaseApplicationImpl.getRuntime().getAccount(), str2);
            }
            if (!TextUtils.isEmpty(str3)) {
              ((SharedPreferences.Editor)localObject).putString("kFTSReadInJoySearchPlaceholderPrefix" + localBaseApplicationImpl.getRuntime().getAccount(), str3);
            }
            if (!TextUtils.isEmpty(str4)) {
              ((SharedPreferences.Editor)localObject).putString("kFTSDynamicTabSearchPlaceholderPrefix" + localBaseApplicationImpl.getRuntime().getAccount(), str4);
            }
            a = null;
            ((SharedPreferences.Editor)localObject).commit();
            return;
          }
          catch (Exception paramConfig) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig parseJsonError:" + paramConfig.toString());
          return;
        }
        catch (Throwable paramConfig)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "Throwable:" + paramConfig.getMessage());
          }
          paramConfig = null;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "inflateConfigString error!");
        }
        paramConfig = null;
        continue;
        paramConfig = paramConfig.content.get().toStringUtf8();
        continue;
        boolean bool = false;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "handleSearchEnhanceSwitchConfig. config is null or size = 0. config=" + paramConfig);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    String str = localBaseApplicationImpl.getRuntime().getAccount();
    if (!localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + str, 4).getBoolean("kFTSDynamicTabSearchBarDontShow" + str, false)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(int paramInt)
  {
    arow localarow = (arow)aran.a().a(433);
    if (localarow != null) {}
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isHotWordSwitchOn. " + bool);
      }
      return bool;
      bool = localarow.a();
      continue;
      bool = localarow.b();
      continue;
      bool = localarow.c();
    }
  }
  
  public static boolean a(String paramString)
  {
    BaseApplicationImpl.getContext();
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    int i = localBaseApplicationImpl.getSharedPreferences("SearchConfigUtils_Switch" + localBaseApplicationImpl.getRuntime().getAccount(), 4).getInt("search_enhance_switch" + str, 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isSearchEnhanceEnable() uin=" + paramString + " enhanceSwitch=" + i);
    }
    return i == 1;
  }
  
  public static String b(int paramInt)
  {
    String str = bcjy.a(paramInt);
    return str + "_" + "hotword";
  }
  
  public static String b(String paramString)
  {
    Object localObject = (arpd)aran.a().a(456);
    if (localObject != null) {}
    for (localObject = ((arpd)localObject).b(paramString);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isVerticalSerachSwitchOn. bizType = " + paramString + "， result = " + (String)localObject);
      }
      return localObject;
    }
  }
  
  public static String b(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.contains("from=native_relate_search")) {
      return paramString;
    }
    return paramString.replace("from=native_relate_search", "from=" + c(paramInt));
  }
  
  public static boolean b()
  {
    aroy localaroy = (aroy)aran.a().a(432);
    if (localaroy != null) {}
    for (boolean bool = localaroy.b();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "bEnableFtsSearch. " + bool);
      }
      return bool;
    }
  }
  
  public static boolean b(int paramInt)
  {
    arou localarou = (arou)aran.a().a(434);
    if (localarou != null) {}
    boolean bool;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isBusinessSwitchOn. " + bool);
      }
      return bool;
      bool = localarou.a();
      continue;
      bool = localarou.b();
      continue;
      bool = localarou.c();
    }
  }
  
  public static boolean b(String paramString)
  {
    arpd localarpd = (arpd)aran.a().a(456);
    if (localarpd != null) {}
    for (boolean bool = localarpd.a(paramString);; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "isVerticalSerachSwitchOn. bizType = " + paramString + "， result = " + bool);
      }
      return bool;
    }
  }
  
  public static String c(int paramInt)
  {
    String str = bcjy.a(paramInt);
    return str + "_" + "moresearch";
  }
  
  public static String c(String paramString)
  {
    Object localObject = (arpd)aran.a().a(456);
    if (localObject != null) {}
    for (localObject = ((arpd)localObject).c(paramString);; localObject = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "VerticalSearchName. bizType = " + paramString + "， result = " + (String)localObject);
      }
      return localObject;
    }
  }
  
  public static boolean c()
  {
    aroy localaroy = (aroy)aran.a().a(432);
    if (localaroy != null) {}
    for (boolean bool = localaroy.c();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "bEnableFtsTroop. " + bool);
      }
      return bool;
    }
  }
  
  public static boolean d()
  {
    aroy localaroy = (aroy)aran.a().a(432);
    if (localaroy != null) {}
    for (boolean bool = localaroy.d();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "bEnableFtsFilter. " + bool);
      }
      return bool;
    }
  }
  
  public static boolean e()
  {
    aroy localaroy = (aroy)aran.a().a(432);
    if (localaroy != null) {}
    for (boolean bool = localaroy.e();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "bEnableFtsMsgSearch. " + bool);
      }
      return bool;
    }
  }
  
  public static boolean f()
  {
    aroy localaroy = (aroy)aran.a().a(432);
    if (localaroy != null) {}
    for (boolean bool = localaroy.f();; bool = true)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchConfigUtils", 2, "bShowMsgSearch. " + bool);
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnf
 * JD-Core Version:    0.7.0.1
 */