import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.utils.DebugUtil;
import com.tencent.mobileqq.minigame.manager.EngineInstaller;
import com.tencent.mobileqq.minigame.manager.InstalledEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"WrongConstant"})
public class arne
{
  private static volatile arne jdField_a_of_type_Arne;
  public static final String[] a;
  private int jdField_a_of_type_Int = 3;
  private InstalledEngine jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "native_lame_mp3", "c++_shared", "saturn", "traeimp-rtmp", "txffmpeg", "liteavsdk" };
  }
  
  public arne()
  {
    Iterator localIterator = EngineInstaller.getInstalledEngine(this.jdField_a_of_type_Int).iterator();
    while (localIterator.hasNext())
    {
      InstalledEngine localInstalledEngine = (InstalledEngine)localIterator.next();
      if (localInstalledEngine.isVerify) {
        this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine = localInstalledEngine;
      }
    }
  }
  
  public static arne a()
  {
    if (jdField_a_of_type_Arne == null) {}
    try
    {
      if (jdField_a_of_type_Arne == null) {
        jdField_a_of_type_Arne = new arne();
      }
      return jdField_a_of_type_Arne;
    }
    finally {}
  }
  
  private String a(InstalledEngine paramInstalledEngine)
  {
    if ((paramInstalledEngine != null) && (paramInstalledEngine.isVerify)) {
      return paramInstalledEngine.engineDir;
    }
    return null;
  }
  
  public void a(InstalledEngine paramInstalledEngine)
  {
    this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine = paramInstalledEngine;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine != null) {}
    for (;;)
    {
      boolean bool1;
      try
      {
        bool1 = bfxz.a(this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.engineDir + File.separator + "liteavsdk.jar", BaseApplicationImpl.getApplication().getApplicationContext(), getClass().getClassLoader(), "com.tencent.rtmp.ui.TXCloudVideoView", null, false);
        if (bool1)
        {
          QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar successful!!!");
          bool3 = bool1;
          String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
          int j = arrayOfString.length;
          int i = 0;
          bool1 = true;
          if (i >= j) {
            break label234;
          }
          str = arrayOfString[i];
          if ((!"liteavsdk".equals(str)) || (bool3)) {
            continue;
          }
          QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar failed?!!, and don't load liteavsdk.so ?!!");
          bool1 = false;
          i += 1;
          continue;
        }
      }
      catch (Exception localException)
      {
        String str;
        QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar failed, e:" + localException.toString());
        bool1 = false;
        continue;
        QLog.e("MiniAppSoLoader", 1, "load liteavsdk.jar failed ？!! ");
        bool3 = bool1;
        continue;
        if ((bool1) && (a(str)))
        {
          bool2 = true;
          bool1 = bool2;
          if (!"native_lame_mp3".equals(str)) {
            continue;
          }
          bool1 = bool2;
          if (!bool2) {
            continue;
          }
          this.jdField_a_of_type_Boolean = true;
          bool1 = bool2;
          continue;
        }
        boolean bool2 = false;
        continue;
      }
      label234:
      return bool1;
      boolean bool3 = false;
    }
  }
  
  protected boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine == null) || (TextUtils.isEmpty(paramString))) {
      QLog.e("MiniAppSoLoader", 1, "[MiniEng]load so " + paramString + " from " + this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine);
    }
    String str2;
    String str1;
    do
    {
      return false;
      str2 = a(this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine);
      str1 = str2 + File.separator + "lib" + paramString + ".so";
      QLog.i("MiniAppSoLoader", 1, "[MiniEng]load so " + paramString + " from " + str1);
    } while (TextUtils.isEmpty(str2));
    try
    {
      System.load(str1);
      if (this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.loadStatus == 1) {
        this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.loadStatus = 3;
      }
      QLog.i("MiniAppSoLoader", 1, "[MiniEng] load " + str1 + " success.");
      return true;
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniAppSoLoader", 1, "[MiniEng] load " + str1 + " fail: " + DebugUtil.getPrintableStackTrace(paramString), paramString);
      this.jdField_a_of_type_ComTencentMobileqqMinigameManagerInstalledEngine.loadStatus = 2;
    }
    return false;
  }
  
  public boolean b()
  {
    return a("native_lame_mp3");
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     arne
 * JD-Core Version:    0.7.0.1
 */