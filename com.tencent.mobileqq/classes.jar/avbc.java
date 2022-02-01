import android.os.SystemClock;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.HotPicSendData;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class avbc
  extends ProtocolDownloader.Adapter
{
  public static final String a = bhgg.a(anhk.ba + "hotpic/");
  
  public static File a(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      paramString = new File(a + paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("hot_pic", "", paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return a(paramString).exists();
  }
  
  protected int a(String paramString, File paramFile)
  {
    paramString = new bhhf(paramString.replaceFirst("https", "http"), paramFile);
    paramString.e = 20000;
    paramString.n = true;
    paramString.b = 2;
    return bhhh.a(paramString, null, null);
  }
  
  protected String a(HotPicData paramHotPicData)
  {
    return paramHotPicData.url;
  }
  
  protected void a(int paramInt, HotPicData paramHotPicData)
  {
    if ((paramHotPicData instanceof EmotionSearchItem)) {
      awmr.e(String.valueOf(paramInt), 7);
    }
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    try
    {
      paramDownloadParams = a((HotPicData)paramDownloadParams.mExtraInfo);
      return a(paramDownloadParams);
    }
    catch (Exception paramDownloadParams)
    {
      paramDownloadParams.printStackTrace();
    }
    return false;
  }
  
  public File loadImageFile(DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramDownloadParams = (HotPicData)paramDownloadParams.mExtraInfo;
    String str = a(paramDownloadParams);
    int i = 0;
    if ((paramDownloadParams instanceof HotPicSendData)) {
      i = 1;
    }
    File localFile = a(str);
    if (localFile.exists())
    {
      if ((i == 0) && (paramURLDrawableHandler != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadSucceed:" + paramDownloadParams.picIndex);
        }
        paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
      }
      return localFile;
    }
    localFile.getParentFile().mkdirs();
    if ((bgjw.a()) && (bgjw.b() < 20971520L)) {
      throw new IOException("SD card free space is " + bgjw.b());
    }
    Object localObject = new File(a);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    SystemClock.uptimeMillis();
    int j = a(str, localFile);
    a(j, paramDownloadParams);
    if (j == 0)
    {
      str = azby.a(localFile.getAbsolutePath());
      localObject = paramDownloadParams.md5;
      if ((!paramDownloadParams.md5.equalsIgnoreCase(str)) && (QLog.isColorLevel())) {
        QLog.d("HotPicManager.HotPicDownLoader", 2, "md5 match fail: " + (String)localObject + " " + str);
      }
      if (i == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadSucceed download:" + paramDownloadParams.picIndex + localFile.getAbsolutePath());
        }
        if (paramURLDrawableHandler != null) {
          paramURLDrawableHandler.onFileDownloadSucceed(paramDownloadParams.picIndex);
        }
      }
      return localFile;
    }
    if (paramURLDrawableHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.HotPicDownLoader", 2, "onFileDownloadFailed:" + paramDownloadParams.picIndex + " " + j);
      }
      paramURLDrawableHandler.onFileDownloadFailed(paramDownloadParams.picIndex);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbc
 * JD-Core Version:    0.7.0.1
 */