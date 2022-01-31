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

public class bcbz
{
  public static int a(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    bcds.a("DownloadJSApi", "doDownloadActionBySDK pParmas =" + paramBundle);
    String str3 = paramBundle.getString(bcgl.b);
    String str4 = paramBundle.getString(bcgl.j);
    String str5 = paramBundle.getString(bcgl.f);
    int i = paramBundle.getInt(bcgl.k);
    String str6 = paramBundle.getString(bcgl.i);
    String str7 = paramBundle.getString(bcgl.l);
    paramBundle.getString(bcgl.m);
    String str2 = paramBundle.getString(bcgl.D);
    int j = paramBundle.getInt(bcgl.H);
    String str1 = paramBundle.getString(bcgl.I);
    boolean bool1 = paramBundle.getBoolean(bcgl.o);
    boolean bool2 = paramBundle.getBoolean(bcgl.y, true);
    boolean bool3 = paramBundle.getBoolean(bcgl.h, true);
    boolean bool4 = paramBundle.getBoolean(bcgl.x);
    int k = paramBundle.getInt(bcgl.C, 0);
    boolean bool5 = paramBundle.getBoolean(bcgl.J, false);
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
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
        bcds.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        bcbu.a().a(paramString);
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
      paramString.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
      paramString.o = str1;
      if ((paramApkUpdateDetail != null) && (paramString.jdField_b_of_type_Int != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
        paramString.jdField_b_of_type_Int = paramApkUpdateDetail.versioncode;
      }
      bool2 = bcfa.a(bbtm.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        bcbu.a().a(paramString);
      }
      for (;;)
      {
        bcds.c("DownloadJSApi", "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          bcbu.a().a(paramString, paramApkUpdateDetail);
        } else {
          bcbu.a().a(paramString);
        }
      }
      bcbu.a().a(str3);
      continue;
      if (bool2)
      {
        bcfb.a("305", str6, str3, str1);
        bcbu.a().a(str3, str5);
        continue;
        bcbu.a().b(str3);
        continue;
        paramString = new DownloadInfo(str3, str4.trim(), str5, str7, str6, null, paramString, bool2);
        paramString.g = i;
        paramString.jdField_b_of_type_Int = paramBundle.getInt(bcgl.e);
        paramString.jdField_b_of_type_Boolean = bool4;
        bcbu.a().a(paramString);
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
 * Qualified Name:     bcbz
 * JD-Core Version:    0.7.0.1
 */