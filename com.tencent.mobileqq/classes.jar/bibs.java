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
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bibs
{
  protected static ITMAssistantExchangeURLListenner a;
  public static Object a;
  public static final String a;
  protected static ConcurrentHashMap<String, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bibs.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new bibv();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      bias.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bibw.I));
    }
    bhzm.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str5 = paramBundle.getString(bibw.b);
    String str6 = paramBundle.getString(bibw.j);
    String str7 = paramBundle.getString(bibw.f);
    int i = paramBundle.getInt(bibw.k);
    String str8 = paramBundle.getString(bibw.i);
    String str9 = paramBundle.getString(bibw.l);
    paramBundle.getString(bibw.m);
    String str4 = paramBundle.getString(bibw.D);
    int j = paramBundle.getInt(bibw.H);
    String str3 = paramBundle.getString(bibw.I);
    boolean bool1 = paramBundle.getBoolean(bibw.o);
    boolean bool2 = paramBundle.getBoolean(bibw.y, true);
    boolean bool3 = paramBundle.getBoolean(bibw.jdField_h_of_type_JavaLangString, true);
    boolean bool4 = paramBundle.getBoolean(bibw.x);
    int k = paramBundle.getInt(bibw.C, 0);
    boolean bool5 = paramBundle.getBoolean(bibw.J, false);
    String str1 = paramBundle.getString("big_brother_ref_source_key", "");
    String str2 = paramBundle.getInt("hideInstallSuccessPage", 0) + "";
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str5, str6.trim(), str7, str9, str8, null, paramString, bool2);
      paramString.g = i;
      if (bool2)
      {
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
        label341:
        paramString.jdField_h_of_type_Int = k;
        paramString.n = str4;
        paramString.i = j;
        paramString.o = str3;
        paramString.jdField_d_of_type_Boolean = bool5;
        paramString.jdField_d_of_type_Int = 0;
      }
      try
      {
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bibw.e);
        paramString.jdField_d_of_type_Long = paramBundle.getLong(bibw.G);
        label398:
        bhzm.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", str2);
        biby.a().a(paramString);
        continue;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_b_of_type_Boolean = true;
        paramString.jdField_a_of_type_Int = 2;
        break label341;
        paramString = new DownloadInfo(str5, str6.trim(), str7, str9, str8, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
        paramString.jdField_d_of_type_Int = 0;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bibw.e);
        paramString.o = str3;
        if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
        }
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", str2);
        bool2 = biar.a(bhpc.a().a(), null).b("Common_QQ_Patch_Switch");
        if (!bool1) {
          biby.a().a(paramString);
        }
        for (;;)
        {
          bhzm.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
          break;
          if (bool2) {
            biby.a().a(paramString, paramApkUpdateDetail);
          } else {
            biby.a().a(paramString);
          }
        }
        return biby.a().a(str5);
        if (!bool2) {
          continue;
        }
        bias.a("305", str8, str5, str3);
        paramApkUpdateDetail = biby.a().a(str5);
        paramString = paramApkUpdateDetail;
        if (paramApkUpdateDetail == null)
        {
          paramString = new DownloadInfo();
          paramString.jdField_c_of_type_JavaLangString = str5;
          paramString.jdField_d_of_type_JavaLangString = str6.trim();
          paramString.e = str7;
          paramString.f = str9;
          paramString.jdField_h_of_type_JavaLangString = str8;
          paramString.j = paramBundle.getString(bibw.jdField_c_of_type_JavaLangString);
          paramString.k = paramBundle.getString(bibw.jdField_d_of_type_JavaLangString);
          paramString.jdField_b_of_type_Int = paramBundle.getInt(bibw.e);
          paramString.jdField_c_of_type_Boolean = paramBundle.getBoolean(bibw.y, true);
          paramString.jdField_h_of_type_Int = k;
          paramString.n = str4;
          paramString.jdField_d_of_type_Int = 0;
          paramString.o = str3;
        }
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", str2);
        biby.a().c(paramString);
        continue;
        biby.a().a(str5, null, true);
      }
      catch (NumberFormatException paramBundle)
      {
        break label398;
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
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bhpc.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      bias.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bibw.I));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(bibw.b);
    String str = paramBundle.getString(bibw.j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      bhyn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
      return;
      if (!TextUtils.isEmpty(str)) {
        bhyn.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localStringBuilder.toString());
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
  
  public static void a(DownloadListener paramDownloadListener)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.11(paramDownloadListener));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.10(paramString));
  }
  
  public static void a(String paramString, bicf parambicf)
  {
    if (paramString == null)
    {
      bhzm.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (parambicf == null) {
      bhzm.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, parambicf));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(List<DownloadInfo> paramList, bicf parambicf)
  {
    if (paramList == null)
    {
      bhzm.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (parambicf == null) {
      bhzm.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, parambicf));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(bibw.k) == 5)
    {
      String str1 = paramBundle.getString(bibw.b);
      String str2 = paramBundle.getString(bibw.j);
      String str3 = paramBundle.getString(bibw.f);
      String str4 = paramBundle.getString(bibw.i);
      String str5 = paramBundle.getString(bibw.l);
      bias.a("305", str4, str1, paramBundle.getString(bibw.I));
      DownloadInfo localDownloadInfo = biby.a().a(str1);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.jdField_c_of_type_JavaLangString = str1;
        localDownloadInfo.jdField_d_of_type_JavaLangString = str2.trim();
        localDownloadInfo.e = str3;
        localDownloadInfo.f = str5;
        localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        localDownloadInfo.j = paramBundle.getString(bibw.jdField_c_of_type_JavaLangString);
        localDownloadInfo.k = paramBundle.getString(bibw.jdField_d_of_type_JavaLangString);
        localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(bibw.e);
        localDownloadInfo.o = paramBundle.getString(bibw.I);
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
      for (paramBundle = localDownloadInfo;; paramBundle = localDownloadInfo)
      {
        biby.a().c(paramBundle);
        return true;
        if (!TextUtils.isEmpty(str4)) {
          localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        }
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
    }
    return false;
  }
  
  public static boolean a(bibq parambibq)
  {
    bhyo.a().a(parambibq);
    return biby.a().a(parambibq);
  }
  
  public static boolean a(String paramString)
  {
    paramString = biby.a().a(paramString);
    return (paramString != null) && (paramString.jdField_c_of_type_Int == 1);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    bhzm.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bias.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bibw.I));
    }
    Object localObject1;
    if (paramBundle.getInt(bibw.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, bhpc.a().a());
      localObject1 = paramBundle.getString(bibw.f);
      Object localObject3 = paramBundle.getString(bibw.B);
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
            biby.a().b(bhpc.a().a().getString(2131694238));
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
      paramBundle.putInt(bibw.e, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(bibw.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(bibw.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        bicl.a().a(paramActivity, paramBundle, new bibt(paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    bicl.a().b(paramActivity, paramBundle, new bibu(paramBundle, paramString, paramApkUpdateDetail));
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
  
  public static boolean b(bibq parambibq)
  {
    bhyo.a().b(parambibq);
    return biby.a().b(parambibq);
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibs
 * JD-Core Version:    0.7.0.1
 */