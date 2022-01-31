import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.entry.MiniAppEntryHandler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class aoom
  extends aokh<aool>
{
  public static volatile int a = -1;
  public static volatile int b = -1;
  
  public static int a(int paramInt)
  {
    paramInt = a("miniapptriggerfullscreenheight", paramInt);
    QLog.d("MiniAppConfProcessor", 2, "getTriggerFullScreenHeight, height = " + paramInt);
    return paramInt;
  }
  
  /* Error */
  public static int a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 55	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4: astore_3
    //   5: aload_3
    //   6: astore_0
    //   7: invokestatic 61	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: invokevirtual 65	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   13: invokevirtual 70	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   16: astore_3
    //   17: invokestatic 61	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   20: ldc 72
    //   22: iconst_4
    //   23: invokevirtual 76	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: new 28	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   33: aload_3
    //   34: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 78
    //   39: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: iload_1
    //   50: invokestatic 82	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   53: invokeinterface 88 3 0
    //   58: invokestatic 94	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: istore_2
    //   62: iload_2
    //   63: istore_1
    //   64: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq +37 -> 104
    //   70: ldc 26
    //   72: iconst_1
    //   73: new 28	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   80: ldc 100
    //   82: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 102
    //   91: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: iload_1
    //   95: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: iload_1
    //   105: ireturn
    //   106: astore_3
    //   107: ldc 26
    //   109: iconst_1
    //   110: ldc 104
    //   112: aload_3
    //   113: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   116: goto -52 -> 64
    //   119: astore_3
    //   120: goto -13 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   0	123	1	paramInt	int
    //   61	2	2	i	int
    //   4	30	3	str	String
    //   106	7	3	localException1	Exception
    //   119	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	106	java/lang/Exception
    //   7	62	119	java/lang/Exception
  }
  
  public static aool a()
  {
    return (aool)aoks.a().a(425);
  }
  
  public static String a()
  {
    String str = "";
    aool localaool = a();
    if (localaool != null) {
      str = localaool.a();
    }
    return str;
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 55	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   4: astore_2
    //   5: aload_2
    //   6: astore_0
    //   7: invokestatic 61	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: invokevirtual 65	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   13: invokevirtual 70	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   16: astore_2
    //   17: invokestatic 61	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   20: ldc 72
    //   22: iconst_4
    //   23: invokevirtual 76	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   26: new 28	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   33: aload_2
    //   34: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 78
    //   39: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: aload_1
    //   50: invokeinterface 88 3 0
    //   55: astore_2
    //   56: aload_2
    //   57: astore_1
    //   58: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +37 -> 98
    //   64: ldc 26
    //   66: iconst_1
    //   67: new 28	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   74: ldc 100
    //   76: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 102
    //   85: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 48	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aload_1
    //   99: areturn
    //   100: astore_2
    //   101: ldc 26
    //   103: iconst_1
    //   104: ldc 104
    //   106: aload_2
    //   107: invokestatic 107	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   110: goto -52 -> 58
    //   113: astore_2
    //   114: goto -13 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString1	String
    //   0	117	1	paramString2	String
    //   4	53	2	str	String
    //   100	7	2	localException1	Exception
    //   113	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	5	100	java/lang/Exception
    //   7	56	113	java/lang/Exception
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
    aool localaool = a();
    if (localaool != null) {
      bool = localaool.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 2, "needShowMiniAppEntry: " + bool);
    }
    return bool;
  }
  
  public static boolean f()
  {
    boolean bool = false;
    aool localaool = a();
    if (localaool != null) {
      bool = localaool.h();
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
  public aool a(int paramInt)
  {
    return new aool();
  }
  
  @Nullable
  public aool a(aoko[] paramArrayOfaoko)
  {
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      new aool();
      return aool.a(paramArrayOfaoko);
    }
    return null;
  }
  
  public Class<aool> a()
  {
    return aool.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aool paramaool)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppConfProcessor", 2, "onUpdate " + paramaool.toString());
    }
    paramaool = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramaool instanceof QQAppInterface))
    {
      paramaool = (MiniAppEntryHandler)((QQAppInterface)paramaool).a(149);
      if (paramaool != null) {
        paramaool.notifyUI(0, true, null);
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
 * Qualified Name:     aoom
 * JD-Core Version:    0.7.0.1
 */