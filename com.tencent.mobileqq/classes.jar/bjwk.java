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

public class bjwk
{
  protected static ITMAssistantExchangeURLListenner a;
  public static Object a;
  public static final String a;
  protected static ConcurrentHashMap<String, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bjwk.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new bjwn();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      bjvg.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bjwo.I));
    }
    bjtx.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str5 = paramBundle.getString(bjwo.b);
    String str6 = paramBundle.getString(bjwo.j);
    String str7 = paramBundle.getString(bjwo.f);
    int i = paramBundle.getInt(bjwo.k);
    String str8 = paramBundle.getString(bjwo.i);
    String str9 = paramBundle.getString(bjwo.l);
    paramBundle.getString(bjwo.m);
    String str4 = paramBundle.getString(bjwo.D);
    int j = paramBundle.getInt(bjwo.H);
    String str3 = paramBundle.getString(bjwo.I);
    boolean bool1 = paramBundle.getBoolean(bjwo.o);
    boolean bool2 = paramBundle.getBoolean(bjwo.y, true);
    boolean bool3 = paramBundle.getBoolean(bjwo.jdField_h_of_type_JavaLangString, true);
    boolean bool4 = paramBundle.getBoolean(bjwo.x);
    int k = paramBundle.getInt(bjwo.C, 0);
    boolean bool5 = paramBundle.getBoolean(bjwo.J, false);
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
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bjwo.e);
        paramString.jdField_d_of_type_Long = paramBundle.getLong(bjwo.G);
        label398:
        bjtx.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", str2);
        bjwq.a().a(paramString);
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
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bjwo.e);
        paramString.o = str3;
        if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
        }
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", str2);
        bool2 = bjvf.a(bjjo.a().a(), null).b("Common_QQ_Patch_Switch");
        if (!bool1) {
          bjwq.a().a(paramString);
        }
        for (;;)
        {
          bjtx.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
          break;
          if (bool2) {
            bjwq.a().a(paramString, paramApkUpdateDetail);
          } else {
            bjwq.a().a(paramString);
          }
        }
        return bjwq.a().a(str5);
        if (!bool2) {
          continue;
        }
        bjvg.a("305", str8, str5, str3);
        paramApkUpdateDetail = bjwq.a().a(str5);
        paramString = paramApkUpdateDetail;
        if (paramApkUpdateDetail == null)
        {
          paramString = new DownloadInfo();
          paramString.jdField_c_of_type_JavaLangString = str5;
          paramString.jdField_d_of_type_JavaLangString = str6.trim();
          paramString.e = str7;
          paramString.f = str9;
          paramString.jdField_h_of_type_JavaLangString = str8;
          paramString.j = paramBundle.getString(bjwo.jdField_c_of_type_JavaLangString);
          paramString.k = paramBundle.getString(bjwo.jdField_d_of_type_JavaLangString);
          paramString.jdField_b_of_type_Int = paramBundle.getInt(bjwo.e);
          paramString.jdField_c_of_type_Boolean = paramBundle.getBoolean(bjwo.y, true);
          paramString.jdField_h_of_type_Int = k;
          paramString.n = str4;
          paramString.jdField_d_of_type_Int = 0;
          paramString.o = str3;
        }
        paramString.a("big_brother_ref_source_key", str1);
        paramString.a("hideInstallSuccessPage", str2);
        bjwq.a().c(paramString);
        continue;
        bjwq.a().a(str5, null, true);
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
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bjjo.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      bjvg.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bjwo.I));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(bjwo.b);
    String str = paramBundle.getString(bjwo.j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      bjsy.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
      return;
      if (!TextUtils.isEmpty(str)) {
        bjsy.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localStringBuilder.toString());
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
  
  public static void a(String paramString, bjwx parambjwx)
  {
    if (paramString == null)
    {
      bjtx.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (parambjwx == null) {
      bjtx.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, parambjwx));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(List<DownloadInfo> paramList, bjwx parambjwx)
  {
    if (paramList == null)
    {
      bjtx.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (parambjwx == null) {
      bjtx.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, parambjwx));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(bjwo.k) == 5)
    {
      String str1 = paramBundle.getString(bjwo.b);
      String str2 = paramBundle.getString(bjwo.j);
      String str3 = paramBundle.getString(bjwo.f);
      String str4 = paramBundle.getString(bjwo.i);
      String str5 = paramBundle.getString(bjwo.l);
      bjvg.a("305", str4, str1, paramBundle.getString(bjwo.I));
      DownloadInfo localDownloadInfo = bjwq.a().a(str1);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.jdField_c_of_type_JavaLangString = str1;
        localDownloadInfo.jdField_d_of_type_JavaLangString = str2.trim();
        localDownloadInfo.e = str3;
        localDownloadInfo.f = str5;
        localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        localDownloadInfo.j = paramBundle.getString(bjwo.jdField_c_of_type_JavaLangString);
        localDownloadInfo.k = paramBundle.getString(bjwo.jdField_d_of_type_JavaLangString);
        localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(bjwo.e);
        localDownloadInfo.o = paramBundle.getString(bjwo.I);
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
      for (paramBundle = localDownloadInfo;; paramBundle = localDownloadInfo)
      {
        bjwq.a().c(paramBundle);
        return true;
        if (!TextUtils.isEmpty(str4)) {
          localDownloadInfo.jdField_h_of_type_JavaLangString = str4;
        }
        localDownloadInfo.a("hideInstallSuccessPage", paramBundle.getInt("hideInstallSuccessPage", 0) + "");
      }
    }
    return false;
  }
  
  public static boolean a(bjwi parambjwi)
  {
    bjsz.a().a(parambjwi);
    return bjwq.a().a(parambjwi);
  }
  
  public static boolean a(String paramString)
  {
    paramString = bjwq.a().a(paramString);
    return (paramString != null) && (paramString.jdField_c_of_type_Int == 1);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    bjtx.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bjvg.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bjwo.I));
    }
    Object localObject1;
    if (paramBundle.getInt(bjwo.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, bjjo.a().a());
      localObject1 = paramBundle.getString(bjwo.f);
      Object localObject3 = paramBundle.getString(bjwo.B);
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
            bjwq.a().b(bjjo.a().a().getString(2131694135));
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
      paramBundle.putInt(bjwo.e, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(bjwo.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(bjwo.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        bjxd.a().a(paramActivity, paramBundle, new bjwl(paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    bjxd.a().b(paramActivity, paramBundle, new bjwm(paramBundle, paramString, paramApkUpdateDetail));
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
  
  public static boolean b(bjwi parambjwi)
  {
    bjsz.a().b(parambjwi);
    return bjwq.a().b(parambjwi);
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjwk
 * JD-Core Version:    0.7.0.1
 */