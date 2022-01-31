import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

class bdod
  implements DownloaderProxy.DownloadListener
{
  bdod(bdoa parambdoa, bdoe parambdoe, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    bdnw.b("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.jdField_a_of_type_Bdoe != null) {
      this.jdField_a_of_type_Bdoe.a(1101);
    }
    for (;;)
    {
      bdsu.a(bddc.a(), 617, null, null, null, 1101);
      return;
      bdoa.a(this.jdField_a_of_type_Bdoa, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    bdnw.b("miniapp-process_BaseLibManager", "ApkgManager--onDownloadSucceed");
    bdsu.a(bddc.a(), 5, null, null, null, 0);
    bdsu.a(bddc.a(), 6, null, null, null, 0);
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Bdoa.b(this.jdField_a_of_type_JavaLangString, this.b);
        paramMap = new File(paramString);
        if (this.jdField_a_of_type_Bdoa.c(paramMap))
        {
          bdnw.b("miniapp-process_BaseLibManager", "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.b, this.c))
          {
            bdnw.b("miniapp-process_BaseLibManager", "update baselib local version from:" + this.c + " to:" + this.b);
            bdzf.a().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).commit();
            bdzf.a().edit().putString("version", this.b).commit();
          }
          if (this.jdField_a_of_type_Bdoe != null)
          {
            this.jdField_a_of_type_Bdoe.a(0);
            return;
          }
          bdoa.a(this.jdField_a_of_type_Bdoa, 0);
          continue;
        }
        bdnw.d("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        bdnw.d("miniapp-start", "ApkgManager--unZipFolder exception.", paramString);
        if (this.jdField_a_of_type_Bdoe == null) {
          break label631;
        }
        this.jdField_a_of_type_Bdoe.a(1103);
        return;
        if (paramMap.exists()) {
          bdgo.a(paramString, false);
        }
        paramMap.mkdir();
        paramInt = bdhh.a(this.d, paramString);
        if (paramInt != 0) {
          break label644;
        }
        bool = bdoa.a(this.jdField_a_of_type_Bdoa, paramMap);
        bdsu.a(bddc.a(), 7, null, null, null, 0);
        if ((paramInt == 0) && (bool))
        {
          bdnw.b("miniapp-process_BaseLibManager", "unZipFolder succeed.url:" + this.jdField_a_of_type_JavaLangString + ",version:" + this.b);
          bdzf.a().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).apply();
          bdzf.a().edit().putString("version", this.b).apply();
          if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.equals(this.e, this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.c, this.b)))
          {
            bdnw.b("miniapp-process_BaseLibManager", "delete last path.");
            paramMap = this.jdField_a_of_type_Bdoa.b(this.e, this.c);
            if (!paramMap.equals(paramString))
            {
              bdnw.b("miniapp-start", "delete last path. oldUrl : " + this.e + "; version : " + this.b);
              bdgo.a(paramMap, false);
            }
          }
          if (this.jdField_a_of_type_Bdoe != null)
          {
            this.jdField_a_of_type_Bdoe.a(0);
            return;
          }
          bdoa.a(this.jdField_a_of_type_Bdoa, 0);
          continue;
        }
      }
      finally
      {
        bdgo.a(this.d, true);
      }
      bdgo.a(paramString, false);
      if (this.jdField_a_of_type_Bdoe != null) {
        this.jdField_a_of_type_Bdoe.a(1102);
      }
      for (;;)
      {
        bdsu.a(bddc.a(), 618, null, null, null, 1102);
        break;
        bdoa.a(this.jdField_a_of_type_Bdoa, 1102);
      }
      label631:
      bdoa.a(this.jdField_a_of_type_Bdoa, 1103);
      continue;
      label644:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdod
 * JD-Core Version:    0.7.0.1
 */