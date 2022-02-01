import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasQuickUpdateEngine.TagItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class bgjb
  extends bgit
{
  public static bgjb a;
  public static String a;
  
  static
  {
    jdField_a_of_type_Bgjb = new bgjb();
    jdField_a_of_type_JavaLangString = "theme.";
  }
  
  private boolean a(String paramString)
  {
    if ((bgkb.a()) && ((paramString.startsWith("theme.android")) || (paramString.endsWith(".cfg"))))
    {
      QLog.e("ThemeUpdateCallback", 1, "VasUpdate getItemInfo checkNewVersionValid filter scid = " + paramString);
      return true;
    }
    return false;
  }
  
  public boolean deleteFiles(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface != null) {
      if (!ThemeUtil.isIOSTheme(paramString))
      {
        Object localObject = ThemeUtil.getIDFromSCID(paramString);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = new bdbk().a((String)localObject);
          if (paramString.startsWith(jdField_a_of_type_JavaLangString)) {}
          for (paramQQAppInterface = ((bdbk)localObject).a(paramQQAppInterface.getApp(), paramString, "").c();; paramQQAppInterface = ((bdbk)localObject).b(paramQQAppInterface.getApp()))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ThemeUpdateCallback", 2, "deleteFiles: " + paramQQAppInterface);
            }
            return new File(paramQQAppInterface).delete();
          }
        }
      }
      else
      {
        QLog.e("ThemeUpdateCallback", 1, "deleteFiles ignore ios theme:" + paramString);
      }
    }
    return false;
  }
  
  protected void doOnCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (!ThemeUtil.isIOSTheme(paramString1))
    {
      ThemeSwitcher.a(paramString1, paramInt1);
      if (paramInt1 != 0)
      {
        paramQQAppInterface = ThemeUtil.getIDFromSCID(paramString1);
        bggk.a(null, "individual_v2_theme_download_fail", String.valueOf(paramInt1), "from" + paramString3 + ",httpCode=" + paramInt2 + ",errorCode:" + paramInt1 + ", scid:" + paramString1 + ", cfgScid:" + paramString2, paramQQAppInterface, String.valueOf(paramInt2), null, 0.0F, 0.0F);
        paramQQAppInterface = new HashMap();
        paramQQAppInterface.put("reportKey", "errorCode:" + paramInt1);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "individual_v2_theme_download_fail", false, 0L, -1L, paramQQAppInterface, "", true);
      }
      return;
    }
    QLog.e("ThemeUpdateCallback", 1, "onCompleted ignore ios theme:" + paramString1);
  }
  
  protected void doOnProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (!ThemeUtil.isIOSTheme(paramString1)) {
      ThemeSwitcher.a(paramString1, paramLong2, paramLong3);
    }
  }
  
  public long getBID()
  {
    return 3L;
  }
  
  public VasQuickUpdateEngine.TagItemInfo getItemInfo(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    bdbk localbdbk = null;
    Object localObject = localbdbk;
    if (paramQQAppInterface != null)
    {
      if (!"theme_mapping_config_android".equals(paramString)) {
        break label60;
      }
      localObject = new VasQuickUpdateEngine.TagItemInfo();
      ((VasQuickUpdateEngine.TagItemInfo)localObject).bPreConfig = false;
      ((VasQuickUpdateEngine.TagItemInfo)localObject).bSaveInDir = false;
      ((VasQuickUpdateEngine.TagItemInfo)localObject).strSavePath = getSavePath(paramQQAppInterface.getApp(), paramString);
    }
    label60:
    String str;
    do
    {
      do
      {
        return localObject;
        localObject = localbdbk;
      } while (a(paramString));
      if (ThemeUtil.isIOSTheme(paramString)) {
        break;
      }
      str = ThemeUtil.getIDFromSCID(paramString);
      localObject = localbdbk;
    } while (TextUtils.isEmpty(str));
    localObject = new VasQuickUpdateEngine.TagItemInfo();
    localbdbk = new bdbk().a(str);
    if (paramString.startsWith(jdField_a_of_type_JavaLangString))
    {
      ((VasQuickUpdateEngine.TagItemInfo)localObject).bPreConfig = false;
      ((VasQuickUpdateEngine.TagItemInfo)localObject).bSaveInDir = false;
      ((VasQuickUpdateEngine.TagItemInfo)localObject).strSavePath = localbdbk.a(paramQQAppInterface.getApp(), paramString, "").c();
      return localObject;
    }
    ((VasQuickUpdateEngine.TagItemInfo)localObject).bPreConfig = true;
    ((VasQuickUpdateEngine.TagItemInfo)localObject).bSaveInDir = false;
    ((VasQuickUpdateEngine.TagItemInfo)localObject).strSavePath = localbdbk.b(paramQQAppInterface.getApp());
    return localObject;
    QLog.e("ThemeUpdateCallback", 1, "getItemInfo ignore ios theme:" + paramString);
    return null;
  }
  
  public boolean isFileExists(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if ((paramQQAppInterface != null) && (!ThemeUtil.isIOSTheme(paramString)))
    {
      Object localObject = ThemeUtil.getIDFromSCID(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new bdbk().a((String)localObject);
        if (paramString.startsWith(jdField_a_of_type_JavaLangString)) {}
        for (paramQQAppInterface = ((bdbk)localObject).a(paramQQAppInterface.getApp(), paramString, "").c();; paramQQAppInterface = ((bdbk)localObject).b(paramQQAppInterface.getApp())) {
          return new File(paramQQAppInterface).exists();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjb
 * JD-Core Version:    0.7.0.1
 */