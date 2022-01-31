import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class amtb
  extends ampa<amta>
{
  public static volatile int a = -1;
  public static volatile int b = -1;
  
  public static int a(int paramInt)
  {
    paramInt = a("miniapptriggerfullscreenheight", paramInt);
    QLog.d("MiniAppConfProcessor", 2, "getTriggerFullScreenHeight, height = " + paramInt);
    return paramInt;
  }
  
  public static int a(String paramString, int paramInt)
  {
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      int i = Integer.parseInt(BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(str + "_" + paramString, String.valueOf(paramInt)));
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, error!", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, secondaryKey: " + paramString + ", Value = " + paramInt);
    }
    return paramInt;
  }
  
  public static amta a()
  {
    return (amta)ampl.a().a(425);
  }
  
  public static String a()
  {
    String str = "";
    amta localamta = a();
    if (localamta != null) {
      str = localamta.a();
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      str = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(str + "_" + paramString1, paramString2);
      paramString2 = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, error!", localException);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 1, "getMiniAppHighPriorityConfig, secondaryKey: " + paramString1 + ", Value = " + paramString2);
    }
    return paramString2;
  }
  
  public static String b()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationUin", "1038354735");
  }
  
  public static int c()
  {
    if (b == -1)
    {
      b = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappfullscreenminedatamaxnum", 50);
      QLog.d("MiniAppConfProcessor", 1, "[MiniAppUserAppInfoListManager].maxtopnum = " + b);
    }
    return b;
  }
  
  public static String c()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "miniappNotificationNickName", "小程序通知");
  }
  
  public static String d()
  {
    String str2 = "QQ小程序";
    String str1 = str2;
    try
    {
      String str3 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      str1 = str2;
      str2 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getString(str3 + "_" + "miniappfullscreentitle", "QQ小程序");
      str1 = str2;
      if (QLog.isColorLevel())
      {
        str1 = str2;
        QLog.d("MiniAppConfProcessor", 2, "[DesktopDataManager]. desktopTitleConfig title: " + str2 + "，uin: " + str3);
      }
      return str2;
    }
    catch (Exception localException)
    {
      QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. desktopTitleConfig Exception");
    }
    return str1;
  }
  
  public static boolean e()
  {
    boolean bool = true;
    amta localamta = a();
    if (localamta != null) {
      bool = localamta.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 2, "needShowMiniAppEntry: " + bool);
    }
    return bool;
  }
  
  public static boolean f()
  {
    boolean bool = false;
    amta localamta = a();
    if (localamta != null) {
      bool = localamta.h();
    }
    return bool;
  }
  
  public static boolean g()
  {
    if (a == -1) {}
    try
    {
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      a = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt(str + "_" + "miniappshowfullscreen", 1);
      QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowMiniAppFullScreen, showFullScreen = " + a);
      if (a == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a = 1;
        QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowMiniAppFullScreen Exception");
      }
    }
    return false;
  }
  
  public static boolean h()
  {
    return a("miniappshowreddot", 0) == 1;
  }
  
  public static boolean i()
  {
    return a("miniappshowmessagereddot", 0) == 1;
  }
  
  public static boolean j()
  {
    return a("miniappfullscreenshownotificationbtn", 1) == 1;
  }
  
  public static boolean k()
  {
    if (a("miniappfullscreenshownotificationreddot", 1) == 1) {}
    for (int i = 1; (j()) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  public static boolean l()
  {
    return !m();
  }
  
  public static boolean m()
  {
    for (;;)
    {
      try
      {
        String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        i = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).getInt(str + "_" + "miniappfullscreenshowsetting", 0);
        j = i;
        QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager]. needShowSettingButton Exception.");
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("MiniAppConfProcessor", 2, "[DesktopDataManager]. needShowSettingButton settingValue: " + i + "，uin: " + str);
            j = i;
          }
          QLog.d("MiniAppConfProcessor", 1, "[DesktopDataManager].needShowSettingButton, settingValue = " + j);
          if (j != 1) {
            break;
          }
          return true;
        }
        catch (Exception localException2)
        {
          int i;
          int j;
          break label129;
        }
        localException1 = localException1;
        i = 0;
      }
      label129:
      j = i;
    }
    return false;
  }
  
  public int a()
  {
    return 425;
  }
  
  @NonNull
  public amta a(int paramInt)
  {
    return new amta();
  }
  
  @Nullable
  public amta a(amph[] paramArrayOfamph)
  {
    if ((paramArrayOfamph != null) && (paramArrayOfamph.length > 0))
    {
      new amta();
      return amta.a(paramArrayOfamph);
    }
    return null;
  }
  
  public Class<amta> a()
  {
    return amta.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(amta paramamta)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 2, "onUpdate " + paramamta.toString());
    }
    paramamta = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramamta instanceof QQAppInterface))
    {
      paramamta = (MiniAppEntryHandler)((QQAppInterface)paramamta).a(149);
      if (paramamta != null) {
        paramamta.notifyUI(0, true, null);
      }
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amtb
 * JD-Core Version:    0.7.0.1
 */