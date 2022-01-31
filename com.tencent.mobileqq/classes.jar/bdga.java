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

public class bdga
{
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    bdht.a("DownloadJSApi", "doDownloadActionBySDK pParmas =" + paramBundle);
    String str3 = paramBundle.getString(bdkm.b);
    String str4 = paramBundle.getString(bdkm.j);
    String str5 = paramBundle.getString(bdkm.f);
    int i = paramBundle.getInt(bdkm.k);
    String str6 = paramBundle.getString(bdkm.i);
    String str7 = paramBundle.getString(bdkm.l);
    paramBundle.getString(bdkm.m);
    String str2 = paramBundle.getString(bdkm.D);
    int j = paramBundle.getInt(bdkm.H);
    String str1 = paramBundle.getString(bdkm.I);
    boolean bool1 = paramBundle.getBoolean(bdkm.o);
    boolean bool2 = paramBundle.getBoolean(bdkm.y, true);
    boolean bool3 = paramBundle.getBoolean(bdkm.h, true);
    boolean bool4 = paramBundle.getBoolean(bdkm.x);
    int k = paramBundle.getInt(bdkm.C, 0);
    boolean bool5 = paramBundle.getBoolean(bdkm.J, false);
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
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bdkm.e);
        bdht.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        bdfv.a().a(paramString);
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
      paramString.jdField_b_of_type_Int = paramBundle.getInt(bdkm.e);
      paramString.o = str1;
      if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
      }
      bool2 = bdjb.a(bcxm.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        bdfv.a().a(paramString);
      }
      for (;;)
      {
        bdht.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          bdfv.a().a(paramString, paramApkUpdateDetail);
        } else {
          bdfv.a().a(paramString);
        }
      }
      bdfv.a().a(str3);
      continue;
      if (bool2)
      {
        bdjc.a("305", str6, str3, str1);
        bdfv.a().a(str3, str5);
        continue;
        bdfv.a().b(str3);
        continue;
        paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bdkm.e);
        paramString.jdField_b_of_type_Boolean = bool4;
        bdfv.a().a(paramString);
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
 * Qualified Name:     bdga
 * JD-Core Version:    0.7.0.1
 */