import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class axmf
{
  public static Bundle a(QQAppInterface paramQQAppInterface)
  {
    Bundle localBundle = new Bundle();
    Object localObject = ThemeUtil.getWeekLoopTheme(paramQQAppInterface);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = paramQQAppInterface.getPreferences();
      paramQQAppInterface = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
      localObject = ((SharedPreferences)localObject).getString("previousThemeVersion", "0");
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchUtil", 2, "ThemeSwitchUtil getPreviousThemeIdVersion,themeID=" + paramQQAppInterface + ",version=" + (String)localObject);
      }
      localBundle.putString("themeID", paramQQAppInterface);
      localBundle.putString("version", (String)localObject);
      return localBundle;
    }
    localBundle.putString("themeID", (String)localObject);
    localBundle.putString("version", ThemeUtil.getUserCurrentThemeVersion(paramQQAppInterface));
    return localBundle;
  }
  
  public static Boolean a(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    String str = paramAppRuntime.getAccount();
    Object localObject = str;
    if (str == null) {
      localObject = "noLogin";
    }
    localObject = paramAppRuntime.getApplication().getSharedPreferences((String)localObject, 4);
    paramAppRuntime = paramAppRuntime.getAccount();
    str = ((SharedPreferences)localObject).getString("previousThemeId", "1000");
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("previousThemeId", paramString1);
    ((SharedPreferences.Editor)localObject).putString("previousThemeVersion", paramString2);
    QLog.d("ThemeSwitchUtil", 1, "ThemeSwitchUtil setPreviousThemeIdVersion,uin=" + paramAppRuntime + ",oldPreviousThemeId=" + str + ",set new themeId=" + paramString1);
    return Boolean.valueOf(((SharedPreferences.Editor)localObject).commit());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmf
 * JD-Core Version:    0.7.0.1
 */