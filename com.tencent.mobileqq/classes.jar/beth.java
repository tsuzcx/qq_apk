import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

class beth
  implements DownloaderProxy.DownloadListener
{
  beth(bete parambete, beti parambeti, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    betc.b("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.jdField_a_of_type_Beti != null) {
      this.jdField_a_of_type_Beti.a(1101);
    }
    for (;;)
    {
      bezi.a(behu.a(), 617, null, null, null, 1101);
      return;
      bete.a(this.jdField_a_of_type_Bete, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    betc.b("miniapp-process_BaseLibManager", "ApkgManager--onDownloadSucceed");
    bezi.a(behu.a(), 5, null, null, null, 0);
    bezi.a(behu.a(), 6, null, null, null, 0);
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Bete.b(this.jdField_a_of_type_JavaLangString, this.b);
        paramMap = new File(paramString);
        if (this.jdField_a_of_type_Bete.c(paramMap))
        {
          betc.b("miniapp-process_BaseLibManager", "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.b, this.c))
          {
            betc.b("miniapp-process_BaseLibManager", "update baselib local version from:" + this.c + " to:" + this.b);
            bfhm.a().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).commit();
            bfhm.a().edit().putString("version", this.b).commit();
          }
          if (this.jdField_a_of_type_Beti != null)
          {
            this.jdField_a_of_type_Beti.a(0);
            return;
          }
          bete.a(this.jdField_a_of_type_Bete, 0);
          continue;
        }
        betc.d("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        betc.d("miniapp-start", "ApkgManager--unZipFolder exception.", paramString);
        if (this.jdField_a_of_type_Beti == null) {
          break label631;
        }
        this.jdField_a_of_type_Beti.a(1103);
        return;
        if (paramMap.exists()) {
          belh.a(paramString, false);
        }
        paramMap.mkdir();
        paramInt = bemb.a(this.d, paramString);
        if (paramInt != 0) {
          break label644;
        }
        bool = bete.a(this.jdField_a_of_type_Bete, paramMap);
        bezi.a(behu.a(), 7, null, null, null, 0);
        if ((paramInt == 0) && (bool))
        {
          betc.b("miniapp-process_BaseLibManager", "unZipFolder succeed.url:" + this.jdField_a_of_type_JavaLangString + ",version:" + this.b);
          bfhm.a().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).apply();
          bfhm.a().edit().putString("version", this.b).apply();
          if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.equals(this.e, this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.c, this.b)))
          {
            betc.b("miniapp-process_BaseLibManager", "delete last path.");
            paramMap = this.jdField_a_of_type_Bete.b(this.e, this.c);
            if (!paramMap.equals(paramString))
            {
              betc.b("miniapp-start", "delete last path. oldUrl : " + this.e + "; version : " + this.b);
              belh.a(paramMap, false);
            }
          }
          if (this.jdField_a_of_type_Beti != null)
          {
            this.jdField_a_of_type_Beti.a(0);
            return;
          }
          bete.a(this.jdField_a_of_type_Bete, 0);
          continue;
        }
      }
      finally
      {
        belh.a(this.d, true);
      }
      belh.a(paramString, false);
      if (this.jdField_a_of_type_Beti != null) {
        this.jdField_a_of_type_Beti.a(1102);
      }
      for (;;)
      {
        bezi.a(behu.a(), 618, null, null, null, 1102);
        break;
        bete.a(this.jdField_a_of_type_Bete, 1102);
      }
      label631:
      bete.a(this.jdField_a_of_type_Bete, 1103);
      continue;
      label644:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beth
 * JD-Core Version:    0.7.0.1
 */