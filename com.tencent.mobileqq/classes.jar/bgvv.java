import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.io.File;
import java.util.List;
import java.util.Map;

class bgvv
  implements DownloaderProxy.DownloadListener
{
  bgvv(bgvs parambgvs, bgvw parambgvw, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.jdField_a_of_type_Bgvw != null) {
      this.jdField_a_of_type_Bgvw.a(1101);
    }
    for (;;)
    {
      bhck.a(bgmb.a(), 617, null, null, null, 1101);
      return;
      bgvs.a(this.jdField_a_of_type_Bgvs, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadSucceed");
    bhck.a(bgmb.a(), 5, null, null, null, 0);
    bhck.a(bgmb.a(), 6, null, null, null, 0);
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Bgvs.b(this.jdField_a_of_type_JavaLangString, this.b);
        paramMap = new File(paramString);
        if (this.jdField_a_of_type_Bgvs.c(paramMap))
        {
          QMLog.i("miniapp-process_BaseLibManager", "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.b, this.c))
          {
            QMLog.i("miniapp-process_BaseLibManager", "update baselib local version from:" + this.c + " to:" + this.b);
            StorageUtil.getPreference().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).commit();
            StorageUtil.getPreference().edit().putString("version", this.b).commit();
          }
          if (this.jdField_a_of_type_Bgvw != null)
          {
            this.jdField_a_of_type_Bgvw.a(0);
            return;
          }
          bgvs.a(this.jdField_a_of_type_Bgvs, 0);
          continue;
        }
        QMLog.e("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        QMLog.e("miniapp-start", "ApkgManager--unZipFolder exception.", paramString);
        if (this.jdField_a_of_type_Bgvw == null) {
          break label631;
        }
        this.jdField_a_of_type_Bgvw.a(1103);
        return;
        if (paramMap.exists()) {
          bgpc.a(paramString, false);
        }
        paramMap.mkdir();
        paramInt = bgpy.a(this.d, paramString);
        if (paramInt != 0) {
          break label644;
        }
        bool = bgvs.a(this.jdField_a_of_type_Bgvs, paramMap);
        bhck.a(bgmb.a(), 7, null, null, null, 0);
        if ((paramInt == 0) && (bool))
        {
          QMLog.i("miniapp-process_BaseLibManager", "unZipFolder succeed.url:" + this.jdField_a_of_type_JavaLangString + ",version:" + this.b);
          StorageUtil.getPreference().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).apply();
          StorageUtil.getPreference().edit().putString("version", this.b).apply();
          if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.equals(this.e, this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.c, this.b)))
          {
            QMLog.i("miniapp-process_BaseLibManager", "delete last path.");
            paramMap = this.jdField_a_of_type_Bgvs.b(this.e, this.c);
            if (!paramMap.equals(paramString))
            {
              QMLog.i("miniapp-start", "delete last path. oldUrl : " + this.e + "; version : " + this.b);
              bgpc.a(paramMap, false);
            }
          }
          if (this.jdField_a_of_type_Bgvw != null)
          {
            this.jdField_a_of_type_Bgvw.a(0);
            return;
          }
          bgvs.a(this.jdField_a_of_type_Bgvs, 0);
          continue;
        }
      }
      finally
      {
        bgpc.a(this.d, true);
      }
      bgpc.a(paramString, false);
      if (this.jdField_a_of_type_Bgvw != null) {
        this.jdField_a_of_type_Bgvw.a(1102);
      }
      for (;;)
      {
        bhck.a(bgmb.a(), 618, null, null, null, 1102);
        break;
        bgvs.a(this.jdField_a_of_type_Bgvs, 1102);
      }
      label631:
      bgvs.a(this.jdField_a_of_type_Bgvs, 1103);
      continue;
      label644:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgvv
 * JD-Core Version:    0.7.0.1
 */