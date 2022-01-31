import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager;
import com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.MiniAppSubProcessorInfo.1;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;
import com.tencent.qqmini.sdk.launcher.shell.ProcessType;

public class bgud
{
  public int a;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public MiniAppBaseInfo a;
  public Class<?> a;
  public Runnable a;
  public final String a;
  public boolean a;
  public Class<?> b;
  public String b;
  public String c;
  
  public bgud(AppBrandLaunchManager paramAppBrandLaunchManager, String paramString, ProcessType paramProcessType, Class paramClass1, Class paramClass2)
  {
    this(paramAppBrandLaunchManager, paramString, paramClass1, paramClass2);
  }
  
  public bgud(AppBrandLaunchManager paramAppBrandLaunchManager, String paramString, Class paramClass1, Class paramClass2)
  {
    this.jdField_a_of_type_JavaLangRunnable = new AppBrandLaunchManager.MiniAppSubProcessorInfo.1(this);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangClass = paramClass1;
    this.jdField_b_of_type_JavaLangClass = paramClass2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.isEngineTypeMiniGame()) {}
    for (long l = this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppBrandLaunchManager.gameProcessRecycleTime;; l = this.jdField_a_of_type_ComTencentQqminiSdkLauncherAppBrandLaunchManager.appProcessRecycleTime)
    {
      localHandler.postDelayed(localRunnable, l);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null;
  }
  
  public boolean a(MiniAppBaseInfo paramMiniAppBaseInfo)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramMiniAppBaseInfo == null) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId)) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.getEngineType() != paramMiniAppBaseInfo.getEngineType())) {
          break;
        }
        bool1 = bool2;
      } while (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId.equals(paramMiniAppBaseInfo.appId));
      if ((TextUtils.isEmpty(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.link)) || (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.getEngineType() != paramMiniAppBaseInfo.getEngineType())) {
        break;
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.link.equals(paramMiniAppBaseInfo.link));
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public String toString()
  {
    String str1;
    String str2;
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null)
    {
      str1 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId;
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) {
        break label166;
      }
      str2 = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.name;
      label30:
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo == null) {
        break label172;
      }
    }
    label166:
    label172:
    for (int i = this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.getEngineType();; i = -1)
    {
      String str4 = this.jdField_a_of_type_JavaLangString;
      String str3 = str4;
      if (str4.contains(":")) {
        str3 = str4.substring(str4.indexOf(":"));
      }
      return "pName:" + str3 + " pid:" + this.jdField_a_of_type_Int + " appId=" + str1 + " appName=" + str2 + " engineType=" + i + " reportType=" + -1 + " preloadType=" + this.jdField_b_of_type_JavaLangString;
      str1 = "N/A";
      break;
      str2 = "N/A";
      break label30;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgud
 * JD-Core Version:    0.7.0.1
 */