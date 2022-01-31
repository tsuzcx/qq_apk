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
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class bcgh
{
  protected static ITMAssistantExchangeURLListenner a;
  public static Object a;
  public static final String a;
  protected static ConcurrentHashMap<String, Integer> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = bcgh.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner = new bcgk();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      bcfb.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bcgl.I));
    }
    bcds.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str4 = paramBundle.getString(bcgl.b);
    String str5 = paramBundle.getString(bcgl.j);
    String str6 = paramBundle.getString(bcgl.f);
    int i = paramBundle.getInt(bcgl.k);
    String str7 = paramBundle.getString(bcgl.i);
    String str8 = paramBundle.getString(bcgl.l);
    paramBundle.getString(bcgl.m);
    String str3 = paramBundle.getString(bcgl.D);
    int j = paramBundle.getInt(bcgl.H);
    String str2 = paramBundle.getString(bcgl.I);
    boolean bool1 = paramBundle.getBoolean(bcgl.o);
    boolean bool2 = paramBundle.getBoolean(bcgl.y, true);
    boolean bool3 = paramBundle.getBoolean(bcgl.jdField_h_of_type_JavaLangString, true);
    boolean bool4 = paramBundle.getBoolean(bcgl.x);
    int k = paramBundle.getInt(bcgl.C, 0);
    boolean bool5 = paramBundle.getBoolean(bcgl.J, false);
    String str1 = paramBundle.getString("big_brother_ref_source_key", "");
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool2);
      paramString.g = i;
      if (bool2)
      {
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
        label313:
        paramString.jdField_h_of_type_Int = k;
        paramString.n = str3;
        paramString.i = j;
        paramString.o = str2;
        paramString.jdField_d_of_type_Boolean = bool5;
        paramString.jdField_d_of_type_Int = 0;
      }
      try
      {
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
        paramString.jdField_d_of_type_Long = paramBundle.getLong(bcgl.G);
        label370:
        bcds.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        paramString.a("big_brother_ref_source_key", str1);
        bcgo.a().a(paramString);
        continue;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_b_of_type_Boolean = true;
        paramString.jdField_a_of_type_Int = 2;
        break label313;
        paramString = new DownloadInfo(str4, str5.trim(), str6, str8, str7, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
        paramString.jdField_d_of_type_Int = 0;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
        paramString.o = str2;
        if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
        }
        paramString.a("big_brother_ref_source_key", str1);
        bool2 = bcfa.a(bbtm.a().a(), null).b("Common_QQ_Patch_Switch");
        if (!bool1) {
          bcgo.a().a(paramString);
        }
        for (;;)
        {
          bcds.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
          break;
          if (bool2) {
            bcgo.a().a(paramString, paramApkUpdateDetail);
          } else {
            bcgo.a().a(paramString);
          }
        }
        return bcgo.a().a(str4);
        if (!bool2) {
          continue;
        }
        bcfb.a("305", str7, str4, str2);
        paramApkUpdateDetail = bcgo.a().a(str4);
        paramString = paramApkUpdateDetail;
        if (paramApkUpdateDetail == null)
        {
          paramString = new DownloadInfo();
          paramString.jdField_c_of_type_JavaLangString = str4;
          paramString.jdField_d_of_type_JavaLangString = str5.trim();
          paramString.e = str6;
          paramString.f = str8;
          paramString.jdField_h_of_type_JavaLangString = str7;
          paramString.j = paramBundle.getString(bcgl.jdField_c_of_type_JavaLangString);
          paramString.k = paramBundle.getString(bcgl.jdField_d_of_type_JavaLangString);
          paramString.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
          paramString.jdField_c_of_type_Boolean = paramBundle.getBoolean(bcgl.y, true);
          paramString.jdField_h_of_type_Int = k;
          paramString.n = str3;
          paramString.jdField_d_of_type_Int = 0;
          paramString.o = str2;
        }
        paramString.a("big_brother_ref_source_key", str1);
        bcgo.a().c(paramString);
        continue;
        bcgo.a().a(str4, null, true);
      }
      catch (NumberFormatException paramBundle)
      {
        break label370;
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
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(bbtm.a().a()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if (paramString == "biz_src_jc_update") {
      bcfb.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bcgl.I));
    }
    Object localObject = new Throwable().getStackTrace();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    while (i < localObject.length)
    {
      localStringBuilder.append(localObject[i].toString());
      i += 1;
    }
    localObject = paramBundle.getString(bcgl.b);
    String str = paramBundle.getString(bcgl.j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      bcct.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, localStringBuilder.toString());
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
      return;
      if (!TextUtils.isEmpty(str)) {
        bcct.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localStringBuilder.toString());
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
  
  public static void a(bcgn parambcgn)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.11(parambcgn));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.10(paramString));
  }
  
  public static void a(String paramString, bcgv parambcgv)
  {
    if (paramString == null)
    {
      bcds.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia via == null");
      return;
    }
    if (parambcgv == null) {
      bcds.a(jdField_a_of_type_JavaLangString, "getQueryDownloadActionByVia listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.6(paramString, parambcgv));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.7(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static void a(List<DownloadInfo> paramList, bcgv parambcgv)
  {
    if (paramList == null)
    {
      bcds.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (parambcgv == null) {
      bcds.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadApi.5(paramList, parambcgv));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(bcgl.k) == 5)
    {
      String str2 = paramBundle.getString(bcgl.b);
      String str3 = paramBundle.getString(bcgl.j);
      String str4 = paramBundle.getString(bcgl.f);
      String str1 = paramBundle.getString(bcgl.i);
      String str5 = paramBundle.getString(bcgl.l);
      bcfb.a("305", str1, str2, paramBundle.getString(bcgl.I));
      DownloadInfo localDownloadInfo = bcgo.a().a(str2);
      if (localDownloadInfo == null)
      {
        localDownloadInfo = new DownloadInfo();
        localDownloadInfo.jdField_c_of_type_JavaLangString = str2;
        localDownloadInfo.jdField_d_of_type_JavaLangString = str3.trim();
        localDownloadInfo.e = str4;
        localDownloadInfo.f = str5;
        localDownloadInfo.jdField_h_of_type_JavaLangString = str1;
        localDownloadInfo.j = paramBundle.getString(bcgl.jdField_c_of_type_JavaLangString);
        localDownloadInfo.k = paramBundle.getString(bcgl.jdField_d_of_type_JavaLangString);
        localDownloadInfo.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
        localDownloadInfo.o = paramBundle.getString(bcgl.I);
        paramBundle = localDownloadInfo;
      }
      for (;;)
      {
        bcgo.a().c(paramBundle);
        return true;
        paramBundle = localDownloadInfo;
        if (!TextUtils.isEmpty(str1))
        {
          localDownloadInfo.jdField_h_of_type_JavaLangString = str1;
          paramBundle = localDownloadInfo;
        }
      }
    }
    return false;
  }
  
  public static boolean a(bcgf parambcgf)
  {
    bccu.a().a(parambcgf);
    return bcgo.a().a(parambcgf);
  }
  
  public static boolean a(String paramString)
  {
    paramString = bcgo.a().a(paramString);
    return (paramString != null) && (paramString.jdField_c_of_type_Int == 1);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    bcds.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      bcfb.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(bcgl.I));
    }
    Object localObject1;
    if (paramBundle.getInt(bcgl.e, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(jdField_a_of_type_ComTencentTmdatasourcesdkITMAssistantExchangeURLListenner, bbtm.a().a());
      localObject1 = paramBundle.getString(bcgl.f);
      Object localObject3 = paramBundle.getString(bcgl.B);
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
            bcgo.a().b(bbtm.a().a().getString(2131629199));
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
      paramBundle.putInt(bcgl.e, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(bcgl.t, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(bcgl.u, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        bchb.a().a(paramActivity, paramBundle, new bcgi(paramBundle, paramActivity, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    bchb.a().b(paramActivity, paramBundle, new bcgj(paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.executeOnSubThread(new DownloadApi.4(paramBundle));
  }
  
  public static void b(bcgn parambcgn)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadApi.12(parambcgn));
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadApi.8(paramString1, paramString2, paramBoolean), 32, null, true);
  }
  
  public static boolean b(bcgf parambcgf)
  {
    bccu.a().b(parambcgf);
    return bcgo.a().b(parambcgf);
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcgh
 * JD-Core Version:    0.7.0.1
 */