import com.tencent.qqmini.sdk.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.manager.EngineVersion;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class bgru
  implements DownloaderProxy.DownloadListener
{
  private float jdField_a_of_type_Float;
  
  bgru(bgrt parambgrt, String paramString, BaseLibInfo paramBaseLibInfo, long paramLong, File paramFile, EngineVersion paramEngineVersion, boolean paramBoolean) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.i("EngineInstaller", "[MiniEng] onDownloadFailed " + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType == 2) {
      bgyd.a(bghu.a(), 5, null, null, null, 1, "1", 0L, null);
    }
    bgrt.a(this.jdField_a_of_type_Bgrt);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (paramFloat - this.jdField_a_of_type_Float > 0.05F)
    {
      this.jdField_a_of_type_Float = paramFloat;
      bgrt.a(this.jdField_a_of_type_Bgrt, paramFloat, "正在下载引擎 " + String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(100.0F * paramFloat) }) + "%");
      QMLog.i("EngineInstaller", "[MiniEng]onDownloadProgress, progress=" + paramFloat);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, Map<String, List<String>> paramMap)
  {
    QMLog.i("EngineInstaller", "[MiniEng] onDownloadSucceed " + this.jdField_a_of_type_JavaLangString);
    paramMap = new File(paramString);
    if ((paramMap.length() == this.jdField_a_of_type_Long) || (this.jdField_a_of_type_Long < 0L))
    {
      QMLog.i("EngineInstaller", "[MiniEng] onDownloadSucceed length is match " + this.jdField_a_of_type_Long);
      bgrt.a(this.jdField_a_of_type_Bgrt, 1.0F, "正在下载引擎 100%");
      if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType == 2)
      {
        bgyd.a(bghu.a(), 5, "1");
        bgyd.a(bghu.a(), 6, "1");
      }
    }
    for (;;)
    {
      try
      {
        boolean bool = bgrt.a(this.jdField_a_of_type_Bgrt, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentQqminiSdkManagerEngineVersion, paramString, this.jdField_a_of_type_Boolean);
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelBaseLibInfo.baseLibType == 2)
        {
          paramString = bghu.a();
          if (!bool) {
            break label255;
          }
          paramInt = 0;
          bgyd.a(paramString, 7, null, null, null, paramInt, "1", 0L, null);
        }
        return;
      }
      finally {}
      QMLog.i("EngineInstaller", "[MiniEng]refuse to unzip " + paramString + " length=" + paramMap.length() + ", mEngineFileSize=" + this.jdField_a_of_type_Long);
      bgrt.a(this.jdField_a_of_type_Bgrt);
      return;
      label255:
      paramInt = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgru
 * JD-Core Version:    0.7.0.1
 */