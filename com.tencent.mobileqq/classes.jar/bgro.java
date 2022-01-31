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

class bgro
  implements DownloaderProxy.DownloadListener
{
  bgro(bgrl parambgrl, bgrp parambgrp, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.jdField_a_of_type_Bgrp != null) {
      this.jdField_a_of_type_Bgrp.a(1101);
    }
    for (;;)
    {
      bgyd.a(bghu.a(), 617, null, null, null, 1101);
      return;
      bgrl.a(this.jdField_a_of_type_Bgrl, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    QMLog.i("miniapp-process_BaseLibManager", "ApkgManager--onDownloadSucceed");
    bgyd.a(bghu.a(), 5, null, null, null, 0);
    bgyd.a(bghu.a(), 6, null, null, null, 0);
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Bgrl.b(this.jdField_a_of_type_JavaLangString, this.b);
        paramMap = new File(paramString);
        if (this.jdField_a_of_type_Bgrl.c(paramMap))
        {
          QMLog.i("miniapp-process_BaseLibManager", "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.b, this.c))
          {
            QMLog.i("miniapp-process_BaseLibManager", "update baselib local version from:" + this.c + " to:" + this.b);
            StorageUtil.getPreference().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).commit();
            StorageUtil.getPreference().edit().putString("version", this.b).commit();
          }
          if (this.jdField_a_of_type_Bgrp != null)
          {
            this.jdField_a_of_type_Bgrp.a(0);
            return;
          }
          bgrl.a(this.jdField_a_of_type_Bgrl, 0);
          continue;
        }
        QMLog.e("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        QMLog.e("miniapp-start", "ApkgManager--unZipFolder exception.", paramString);
        if (this.jdField_a_of_type_Bgrp == null) {
          break label631;
        }
        this.jdField_a_of_type_Bgrp.a(1103);
        return;
        if (paramMap.exists()) {
          bgkv.a(paramString, false);
        }
        paramMap.mkdir();
        paramInt = bglr.a(this.d, paramString);
        if (paramInt != 0) {
          break label644;
        }
        bool = bgrl.a(this.jdField_a_of_type_Bgrl, paramMap);
        bgyd.a(bghu.a(), 7, null, null, null, 0);
        if ((paramInt == 0) && (bool))
        {
          QMLog.i("miniapp-process_BaseLibManager", "unZipFolder succeed.url:" + this.jdField_a_of_type_JavaLangString + ",version:" + this.b);
          StorageUtil.getPreference().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).apply();
          StorageUtil.getPreference().edit().putString("version", this.b).apply();
          if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.equals(this.e, this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.c, this.b)))
          {
            QMLog.i("miniapp-process_BaseLibManager", "delete last path.");
            paramMap = this.jdField_a_of_type_Bgrl.b(this.e, this.c);
            if (!paramMap.equals(paramString))
            {
              QMLog.i("miniapp-start", "delete last path. oldUrl : " + this.e + "; version : " + this.b);
              bgkv.a(paramMap, false);
            }
          }
          if (this.jdField_a_of_type_Bgrp != null)
          {
            this.jdField_a_of_type_Bgrp.a(0);
            return;
          }
          bgrl.a(this.jdField_a_of_type_Bgrl, 0);
          continue;
        }
      }
      finally
      {
        bgkv.a(this.d, true);
      }
      bgkv.a(paramString, false);
      if (this.jdField_a_of_type_Bgrp != null) {
        this.jdField_a_of_type_Bgrp.a(1102);
      }
      for (;;)
      {
        bgyd.a(bghu.a(), 618, null, null, null, 1102);
        break;
        bgrl.a(this.jdField_a_of_type_Bgrl, 1102);
      }
      label631:
      bgrl.a(this.jdField_a_of_type_Bgrl, 1103);
      continue;
      label644:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgro
 * JD-Core Version:    0.7.0.1
 */