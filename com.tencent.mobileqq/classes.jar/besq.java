import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import java.io.File;
import java.util.List;
import java.util.Map;

class besq
  implements DownloaderProxy.DownloadListener
{
  besq(besn parambesn, besr parambesr, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    besl.b("miniapp-process_BaseLibManager", "ApkgManager--onDownloadFailed");
    if (this.jdField_a_of_type_Besr != null) {
      this.jdField_a_of_type_Besr.a(1101);
    }
    for (;;)
    {
      beyr.a(behd.a(), 617, null, null, null, 1101);
      return;
      besn.a(this.jdField_a_of_type_Besn, 1101);
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2) {}
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    besl.b("miniapp-process_BaseLibManager", "ApkgManager--onDownloadSucceed");
    beyr.a(behd.a(), 5, null, null, null, 0);
    beyr.a(behd.a(), 6, null, null, null, 0);
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_Besn.b(this.jdField_a_of_type_JavaLangString, this.b);
        paramMap = new File(paramString);
        if (this.jdField_a_of_type_Besn.c(paramMap))
        {
          besl.b("miniapp-process_BaseLibManager", "unZipPath has downloaded and unziped!");
          if (BaseLibInfo.needUpdateVersion(this.b, this.c))
          {
            besl.b("miniapp-process_BaseLibManager", "update baselib local version from:" + this.c + " to:" + this.b);
            bfgv.a().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).commit();
            bfgv.a().edit().putString("version", this.b).commit();
          }
          if (this.jdField_a_of_type_Besr != null)
          {
            this.jdField_a_of_type_Besr.a(0);
            return;
          }
          besn.a(this.jdField_a_of_type_Besn, 0);
          continue;
        }
        besl.d("miniapp-process_BaseLibManager", "unZipFolder failed, read last path.");
      }
      catch (Exception paramString)
      {
        besl.d("miniapp-start", "ApkgManager--unZipFolder exception.", paramString);
        if (this.jdField_a_of_type_Besr == null) {
          break label631;
        }
        this.jdField_a_of_type_Besr.a(1103);
        return;
        if (paramMap.exists()) {
          bekq.a(paramString, false);
        }
        paramMap.mkdir();
        paramInt = belk.a(this.d, paramString);
        if (paramInt != 0) {
          break label644;
        }
        bool = besn.a(this.jdField_a_of_type_Besn, paramMap);
        beyr.a(behd.a(), 7, null, null, null, 0);
        if ((paramInt == 0) && (bool))
        {
          besl.b("miniapp-process_BaseLibManager", "unZipFolder succeed.url:" + this.jdField_a_of_type_JavaLangString + ",version:" + this.b);
          bfgv.a().edit().putString("downloadUrl", this.jdField_a_of_type_JavaLangString).apply();
          bfgv.a().edit().putString("version", this.b).apply();
          if ((!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.c)) && (!TextUtils.equals(this.e, this.jdField_a_of_type_JavaLangString)) && (!TextUtils.equals(this.c, this.b)))
          {
            besl.b("miniapp-process_BaseLibManager", "delete last path.");
            paramMap = this.jdField_a_of_type_Besn.b(this.e, this.c);
            if (!paramMap.equals(paramString))
            {
              besl.b("miniapp-start", "delete last path. oldUrl : " + this.e + "; version : " + this.b);
              bekq.a(paramMap, false);
            }
          }
          if (this.jdField_a_of_type_Besr != null)
          {
            this.jdField_a_of_type_Besr.a(0);
            return;
          }
          besn.a(this.jdField_a_of_type_Besn, 0);
          continue;
        }
      }
      finally
      {
        bekq.a(this.d, true);
      }
      bekq.a(paramString, false);
      if (this.jdField_a_of_type_Besr != null) {
        this.jdField_a_of_type_Besr.a(1102);
      }
      for (;;)
      {
        beyr.a(behd.a(), 618, null, null, null, 1102);
        break;
        besn.a(this.jdField_a_of_type_Besn, 1102);
      }
      label631:
      besn.a(this.jdField_a_of_type_Besn, 1103);
      continue;
      label644:
      boolean bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     besq
 * JD-Core Version:    0.7.0.1
 */