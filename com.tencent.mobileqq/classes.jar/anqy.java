import android.util.DisplayMetrics;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class anqy
{
  protected static final ark.ApplicationCallback a = new anrj();
  
  public static void a()
  {
    String str3 = anog.a().a();
    String str1 = "";
    Object localObject = str1;
    String str2 = str3;
    if (1 != BaseApplicationImpl.sProcessId)
    {
      str2 = MobileQQ.getMobileQQ().getQQProcessName();
      localObject = str1;
      if (str2 != null)
      {
        int i = str2.lastIndexOf(':');
        localObject = str1;
        if (i > -1) {
          localObject = "_" + str2.substring(i + 1);
        }
      }
      str2 = str3 + (String)localObject;
    }
    ArkDelegateManager.getInstance().init(str2, (String)localObject, "8.3.5", BaseApplicationImpl.getContext());
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    ArkEnvironmentManager.getInstance().setCurrentUin(((AppRuntime)localObject).getAccount());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (anog.a() != null)
    {
      bool1 = bool2;
      if (anog.a().a() == 1) {
        bool1 = true;
      }
    }
    ArkEnvironmentManager.getInstance().setEnv(bool1);
    ArkDelegateManager.getInstance().setSetupDelegate(new anrd());
    ArkDelegateManager.getInstance().setNetDelegate(new anre());
    ArkDelegateManager.getInstance().setInputCallback(new anrk(null));
    ArkDelegateManager.getInstance().setApplicationCallback(a);
  }
  
  public static void a(boolean paramBoolean)
  {
    Object localObject1 = ArkEnvironmentManager.getInstance();
    if (!ArkAppCenter.a) {}
    try
    {
      if (!ArkAppCenter.a)
      {
        ((ArkEnvironmentManager)localObject1).setThreadCreator(new anqz());
        ((ArkEnvironmentManager)localObject1).setLogCallback(new anra());
        ((ArkEnvironmentManager)localObject1).setLibraryLoader(new anrb());
        ((ArkEnvironmentManager)localObject1).setDebugFlag(false);
        ((ArkEnvironmentManager)localObject1).setProfilingLogFlag(true);
        ((ArkEnvironmentManager)localObject1).setDataReport(new anrc());
        ArkAppCenter.a = true;
      }
      if ((paramBoolean) && (!ArkAppCenter.b))
      {
        ((ArkEnvironmentManager)localObject1).loadLibrary();
        if (ArkAppCenter.b)
        {
          if (BaseApplicationImpl.getContext() != null)
          {
            localObject1 = anob.a;
            ark.arkSetScreenSize(((DisplayMetrics)localObject1).widthPixels / ((DisplayMetrics)localObject1).density, ((DisplayMetrics)localObject1).heightPixels / ((DisplayMetrics)localObject1).density);
          }
          ArkEnvironmentManager.getInstance().setSingleThreadMode(true);
          ArkEnvironmentManager.getInstance().setThreadMode();
          QLog.i("ArkApp.ArkMultiProcUtil", 1, "setupArkEnvironment, https=true, multithreads=true");
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anqy
 * JD-Core Version:    0.7.0.1
 */