import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkAppPreloader;
import com.tencent.ark.ArkAppPreloader.PreloadAppCallback;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.1;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.2;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr.3;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class aqcf
{
  private int jdField_a_of_type_Int;
  private ArkAppPreloader.PreloadAppCallback jdField_a_of_type_ComTencentArkArkAppPreloader$PreloadAppCallback = new aqch(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private ConcurrentHashMap<String, aqcj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public aqcf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_Boolean = false;
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.1(this));
  }
  
  private void a(aqcj paramaqcj)
  {
    if (paramaqcj == null)
    {
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling preDownloadApp failed for item null");
      return;
    }
    ThreadManagerV2.executeOnSubThread(new ArkAppPreDownloadMgr.3(this, paramaqcj));
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private void a(String paramString1, String paramString2, ArkAppPreloader.PreloadAppCallback paramPreloadAppCallback, int paramInt)
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    String str3 = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
    a(str3);
    ArkAppPreloader.preloadApp(paramString1, paramString2, str2, str3, str1, paramPreloadAppCallback, paramInt);
  }
  
  public static void c()
  {
    String str1 = ArkEnvironmentManager.getInstance().getCacheDirectory();
    String str2 = ArkEnvironmentManager.getInstance().getStorageDirectory();
    a(str1);
    a(str2);
    ArkAppPreloader.preloadCommon(aqbx.a(), str2, str1);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling startPredownload");
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = 0;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        aqcj localaqcj = (aqcj)((Map.Entry)localIterator.next()).getValue();
        if (!TextUtils.isEmpty(localaqcj.a)) {
          if (TextUtils.isEmpty(ArkAppMgr.getInstance().getAppPathByNameFromLocal(localaqcj.a, "", null, false))) {
            a(localaqcj);
          } else {
            QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling ark app predowloaded,app=", localaqcj.a });
          }
        }
      }
    }
  }
  
  public void a(arbz paramarbz)
  {
    if ((paramarbz != null) && (paramarbz.a() != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = paramarbz.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.e("ArkApp.ArkAppPreDownloadMgr", 2, "profiling updatePreloadConfig cfg is empty");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (!TextUtils.isEmpty(paramString))
        {
          bool = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString);
          if (bool) {}
        }
        else
        {
          return;
        }
        String str;
        HashMap localHashMap;
        try
        {
          SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_ark_app_first_use", 0);
          bool = localSharedPreferences.getBoolean(paramString, false);
          if (bool) {
            break label218;
          }
          str = BaseApplicationImpl.sApplication.getRuntime().getAccount();
          localHashMap = new HashMap();
          localHashMap.put("app_name", paramString);
          if (!paramBoolean) {
            break label193;
          }
          bdmc.a(BaseApplicationImpl.getApplication()).a(str, "ark_app_predownload_first_hit", true, 0L, 0L, localHashMap, "", false);
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit app=", paramString, ",hasUsed=", Boolean.valueOf(bool), ",hasPreDownload=", Boolean.valueOf(paramBoolean) });
          localSharedPreferences.edit().putBoolean(paramString, true).apply();
        }
        catch (Exception paramString)
        {
          QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, "profiling reportPredownloadFirstHit exception=", paramString);
        }
        continue;
        bdmc.a(BaseApplicationImpl.getApplication()).a(str, "ark_app_predownload_first_hit", false, 0L, 0L, localHashMap, "", false);
      }
      finally {}
      label193:
      continue;
      label218:
      QLog.d("ArkApp.ArkAppPreDownloadMgr", 1, new Object[] { "profiling reportPredownloadFirstHit not first use app=", paramString });
    }
  }
  
  public void b()
  {
    QLog.i("ArkApp.ArkAppPreDownloadMgr", 1, "profiling startPreload");
    ArkAppCenter.a(new ArkAppPreDownloadMgr.2(this), 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcf
 * JD-Core Version:    0.7.0.1
 */