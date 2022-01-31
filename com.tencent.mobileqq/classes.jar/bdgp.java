import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.1;
import com.tencent.open.appcommon.now.download.js.DownloadJSApi.2;
import com.tencent.open.downloadnew.DownloadInfo;
import mqq.os.MqqHandler;

public class bdgp
{
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    bdii.a("DownloadJSApi", "doDownloadActionBySDK pParmas =" + paramBundle);
    String str3 = paramBundle.getString(bdlb.b);
    String str4 = paramBundle.getString(bdlb.j);
    String str5 = paramBundle.getString(bdlb.f);
    int i = paramBundle.getInt(bdlb.k);
    String str6 = paramBundle.getString(bdlb.i);
    String str7 = paramBundle.getString(bdlb.l);
    paramBundle.getString(bdlb.m);
    String str2 = paramBundle.getString(bdlb.D);
    int j = paramBundle.getInt(bdlb.H);
    String str1 = paramBundle.getString(bdlb.I);
    boolean bool1 = paramBundle.getBoolean(bdlb.o);
    boolean bool2 = paramBundle.getBoolean(bdlb.y, true);
    boolean bool3 = paramBundle.getBoolean(bdlb.h, true);
    boolean bool4 = paramBundle.getBoolean(bdlb.x);
    int k = paramBundle.getInt(bdlb.C, 0);
    boolean bool5 = paramBundle.getBoolean(bdlb.J, false);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
      paramString.g = i;
      if (bool2)
      {
        paramString.jdField_a_of_type_Boolean = bool3;
        paramString.jdField_b_of_type_Boolean = bool4;
      }
      for (;;)
      {
        paramString.h = k;
        paramString.n = str2;
        paramString.i = j;
        paramString.o = str1;
        paramString.jdField_d_of_type_Boolean = bool5;
        paramString.jdField_d_of_type_Int = 0;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bdlb.e);
        bdii.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        bdgk.a().a(paramString);
        break;
        paramString.jdField_a_of_type_Boolean = false;
        paramString.jdField_b_of_type_Boolean = true;
        paramString.jdField_a_of_type_Int = 2;
      }
      paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
      paramString.g = i;
      paramString.jdField_a_of_type_Boolean = bool3;
      paramString.jdField_b_of_type_Boolean = bool4;
      paramString.jdField_d_of_type_Int = 0;
      paramString.jdField_b_of_type_Int = paramBundle.getInt(bdlb.e);
      paramString.o = str1;
      if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
      }
      bool2 = bdjq.a(bcyb.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        bdgk.a().a(paramString);
      }
      for (;;)
      {
        bdii.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          bdgk.a().a(paramString, paramApkUpdateDetail);
        } else {
          bdgk.a().a(paramString);
        }
      }
      bdgk.a().a(str3);
      continue;
      if (bool2)
      {
        bdjr.a("305", str6, str3, str1);
        bdgk.a().a(str3, str5);
        continue;
        bdgk.a().b(str3);
        continue;
        paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bdlb.e);
        paramString.jdField_b_of_type_Boolean = bool4;
        bdgk.a().a(paramString);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadJSApi.1(paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  private static void c(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadJSApi.2(paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgp
 * JD-Core Version:    0.7.0.1
 */