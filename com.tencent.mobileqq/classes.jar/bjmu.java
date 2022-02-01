import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadApi.1;
import com.tencent.open.downloadnew.DownloadApi.10;
import com.tencent.open.downloadnew.DownloadApi.11;
import com.tencent.open.downloadnew.DownloadApi.12;
import com.tencent.open.downloadnew.DownloadApi.2;
import com.tencent.open.downloadnew.DownloadApi.3;
import com.tencent.open.downloadnew.DownloadApi.4;
import com.tencent.open.downloadnew.DownloadApi.5;
import com.tencent.open.downloadnew.DownloadApi.6;
import com.tencent.open.downloadnew.DownloadApi.7;
import com.tencent.open.downloadnew.DownloadApi.8;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bjmu
{
  protected static ITMAssistantExchangeURLListenner a;
  public static Object a;
  public static final String a;
  protected static ConcurrentHashMap<String, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bjmu.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new bjmx();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      bjlu.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bjmy.J));
    }
    bjko.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str4 = paramBundle.getString(bjmy.b);
    String str5 = paramBundle.getString(bjmy.j);
    String str6 = paramBundle.getString(bjmy.f);
    int i = paramBundle.getInt(bjmy.k);
    String str7 = paramBundle.getString(bjmy.i);
    String str8 = paramBundle.getString(bjmy.l);
    paramBundle.getString(bjmy.m);
    String str3 = paramBundle.getString(bjmy.E);
    int j = paramBundle.getInt(bjmy.I);
    String str2 = paramBundle.getString(bjmy.J);
    boolean bool1 = paramBundle.getBoolean(bjmy.o);
    boolean bool3 = paramBundle.getBoolean(bjmy.y, true);
    boolean bool4 = paramBundle.getBoolean(bjmy.jdField_h_of_type_JavaLangString, true);
    boolean bool5 = paramBundle.getBoolean(bjmy.x);
    int k = paramBundle.getInt(bjmy.D, 0);
    boolean bool6 = paramBundle.getBoolean(bjmy.K, false);
    String str1 = paramBundle.getString("big_brother_source_key");
    boolean bool2 = paramBundle.getBoolean(bjmy.z, false);
    if (TextUtils.isEmpty(paramString)) {
      paramString = str1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "[UniteDownload] jsapi doDownloadActionBySDK: invoked. ", " sourceFromJsApi: ", str1, " source: ", paramString, " isUniteDownload: ", Boolean.valueOf(bool2) });
      }
      str1 = paramBundle.getString("big_brother_ref_source_key", "");
      String str9 = paramBundle.getInt("hideInstallSuccessPage", 0) + "";
      switch (i)
      {
      }
      for (;;)
      {
        return 0;
        paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool3);
        paramString.jdField_g_of_type_Int = i;
        if (bool3)
        {
          paramString.jdField_a_of_type_Boolean = bool4;
          paramString.jdField_b_of_type_Boolean = bool5;
          label425:
          paramString.jdField_h_of_type_Int = k;
          paramString.n = str3;
          paramString.i = j;
          paramString.o = str2;
          paramString.jdField_d_of_type_Boolean = bool6;
          paramString.jdField_d_of_type_Int = 0;
          paramString.jdField_g_of_type_Boolean = bool2;
        }
        try
        {
          paramString.jdField_b_of_type_Int = paramBundle.getInt(bjmy.e);
          paramString.jdField_d_of_type_Long = paramBundle.getLong(bjmy.H);
          label488:
          bjko.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
          paramString.a("big_brother_ref_source_key", str1);
          paramString.a("hideInstallSuccessPage", str9);
          a(paramString, bool2);
          continue;
          paramString.jdField_a_of_type_Boolean = false;
          paramString.jdField_b_of_type_Boolean = true;
          paramString.jdField_a_of_type_Int = 2;
          break label425;
          paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool3);
          paramString.jdField_g_of_type_Int = i;
          paramString.jdField_a_of_type_Boolean = bool4;
          paramString.jdField_b_of_type_Boolean = bool5;
          paramString.jdField_d_of_type_Int = 0;
          paramString.jdField_g_of_type_Boolean = bool2;
          paramString.jdField_b_of_type_Int = paramBundle.getInt(bjmy.e);
          paramString.o = str2;
          if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
            paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
          }
          paramString.a("big_brother_ref_source_key", str1);
          paramString.a("hideInstallSuccessPage", str9);
          bool3 = bjlt.a(bizw.a().a(), null).b("Common_QQ_Patch_Switch");
          if (!bool1) {
            a(paramString, bool2);
          }
          for (;;)
          {
            bjko.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
            break;
            if (bool3) {
              bjna.a().a(paramString, paramApkUpdateDetail);
            } else {
              a(paramString, bool2);
            }
          }
          return bjna.a().a(str4);
          if (bool3)
          {
            bjlu.a("305", str7, str4, str2);
            paramApkUpdateDetail = bjna.a().a(str4);
            paramString = paramApkUpdateDetail;
            if (paramApkUpdateDetail == null)
            {
              paramString = new DownloadInfo();
              paramString.jdField_c_of_type_JavaLangString = str4;
              paramString.jdField_d_of_type_JavaLangString = str5.trim();
              paramString.e = str6;
              paramString.f = str8;
              paramString.jdField_h_of_type_JavaLangString = str7;
              paramString.j = paramBundle.getString(bjmy.jdField_c_of_type_JavaLangString);
              paramString.k = paramBundle.getString(bjmy.jdField_d_of_type_JavaLangString);
              paramString.jdField_b_of_type_Int = paramBundle.getInt(bjmy.e);
              paramString.jdField_c_of_type_Boolean = paramBundle.getBoolean(bjmy.y, true);
              paramString.jdField_h_of_type_Int = k;
              paramString.n = str3;
              paramString.jdField_d_of_type_Int = 0;
              paramString.o = str2;
            }
            paramString.a("big_brother_ref_source_key", str1);
            paramString.a("hideInstallSuccessPage", str9);
            bjna.a().c(paramString);
            continue;
            bjna.a().a(str4, null, true);
          }
        }
        catch (NumberFormatException paramBundle)
        {
          break label488;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramActivity == null)) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.2(paramActivity, paramBundle));
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bizw.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      bjlu.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bjmy.J));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(bjmy.b);
    String str = paramBundle.getString(bjmy.j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      bjjp.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
      return;
      if (!TextUtils.isEmpty(str)) {
        bjjp.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.3(paramBundle));
  }
  
  private static void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      bjjq.a().b(paramDownloadInfo);
      return;
    }
    bjna.a().a(paramDownloadInfo);
  }
  
  public static void a(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.11(paramDownloadListener));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.10(paramString));
  }
  
  public static void a(String paramString, bjnh parambjnh)
  {
    if (paramString == null)
    {
      bjko.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (parambjnh == null) {
      bjko.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, parambjnh));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(List<DownloadInfo> paramList, bjnh parambjnh)
  {
    if (paramList == null)
    {
      bjko.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (parambjnh == null) {
      bjko.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, parambjnh));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(bjmy.k) == 5)
    {
      String str1 = paramBundle.getString(bjmy.b);
      String str2 = paramBundle.getString(bjmy.j);
      String str3 = paramBundle.getString(bjmy.f);
      String str4 = paramBundle.getString(bjmy.i);
      String str5 = paramBundle.getString(bjmy.l);
      bjlu.a("305", str4, str1, paramBundle.getString(bjmy.J));
      DownloadInfo localDownloadInfo = bjna.a().a(str1);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.jdField_c_of_type_JavaLangString = str1;
        localDownloadInfo.jdField_d_of_type_JavaLangString = str2.trim();
        localDownloadInfo.e = str3;
        localDownloadInfo.f = str5;
        localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        localDownloadInfo.j = paramBundle.getString(bjmy.jdField_c_of_type_JavaLangString);
        localDownloadInfo.k = paramBundle.getString(bjmy.jdField_d_of_type_JavaLangString);
        localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(bjmy.e);
        localDownloadInfo.o = paramBundle.getString(bjmy.J);
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
      for (paramBundle = localDownloadInfo;; paramBundle = localDownloadInfo)
      {
        bjna.a().c(paramBundle);
        return true;
        if (!TextUtils.isEmpty(str4)) {
          localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        }
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
    }
    return false;
  }
  
  public static boolean a(bjms parambjms)
  {
    bjjq.a().a(parambjms);
    return bjna.a().a(parambjms);
  }
  
  public static boolean a(String paramString)
  {
    paramString = bjna.a().a(paramString);
    return (paramString != null) && (paramString.jdField_c_of_type_Int == 1);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    bjko.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bjlu.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bjmy.J));
    }
    Object localObject1;
    if (paramBundle.getInt(bjmy.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, bizw.a().a());
      localObject1 = paramBundle.getString(bjmy.f);
      Object localObject3 = paramBundle.getString(bjmy.C);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder.append(";");
          localStringBuilder.append((String)localObject3);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localStringBuilder.toString());
        ((TMAssistantGetAppDetailTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
      }
    }
    label288:
    do
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        try
        {
          jdField_a_of_type_JavaLangObject.wait(5000L);
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label288;
          }
          localObject1 = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
          if (localObject1 == null)
          {
            bjna.a().b(bizw.a().a().getString(2131694436));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      paramBundle.putInt(bjmy.e, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(bjmy.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(bjmy.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        bjnn.a().a(paramActivity, paramBundle, new bjmv(paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    bjnn.a().b(paramActivity, paramBundle, new bjmw(paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.4(paramBundle));
  }
  
  public static void b(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.12(paramDownloadListener));
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.8(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static boolean b(bjms parambjms)
  {
    bjjq.a().b(parambjms);
    return bjna.a().b(parambjms);
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjmu
 * JD-Core Version:    0.7.0.1
 */