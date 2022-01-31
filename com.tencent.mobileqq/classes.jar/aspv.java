import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class aspv
  extends aspk
{
  public static URL b(String paramString)
  {
    try
    {
      paramString = new URL("hot_pic_origin", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  protected String a(HotPicData paramHotPicData)
  {
    return paramHotPicData.originalUrl;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = (HotPicData)paramDownloadParams.mExtraInfo;
    String str = a(paramDownloadParams);
    File localFile = a(str);
    if (localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotPicOriginDownLoader", 2, "loadImageFile file exist:" + localFile.getAbsolutePath());
      }
      return localFile;
    }
    localFile.getParentFile().mkdirs();
    if ((bdal.a()) && (bdal.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bdal.b());
    }
    Object localObject = new File(a);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    int i = a(str, localFile);
    if (i == 0)
    {
      localObject = awiz.a(localFile.getAbsolutePath());
      if (!paramDownloadParams.originalMD5.equalsIgnoreCase((String)localObject))
      {
        localFile.delete();
        paramURLDrawableHandler.onFileDownloadFailed(0);
        return null;
      }
      paramURLDrawableHandler.onFileDownloadSucceed(localFile.length());
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotPicOriginDownLoader", 2, "url->" + str + " result->0");
      }
      return localFile;
    }
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManager.HotPicOriginDownLoader", 2, "url->" + str + " result->" + i);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspv
 * JD-Core Version:    0.7.0.1
 */