package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.ProtocolDownloader.Adapter;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StickerRecDrawableDownLoader
  extends ProtocolDownloader.Adapter
{
  public static final String a;
  public Handler a;
  public EntityManager a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("keyword_emotion/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public StickerRecDrawableDownLoader()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((localObject instanceof BaseQQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = ((AppRuntime)localObject).getEntityManagerFactory().createEntityManager();
    }
    localObject = ThreadManager.getFileThreadLooper();
    if (localObject != null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler((Looper)localObject);
    }
  }
  
  public static String a(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if (!TextUtils.isEmpty(paramIStickerRecEmoticon.b())) {
      return paramIStickerRecEmoticon.b();
    }
    if (!TextUtils.isEmpty(paramIStickerRecEmoticon.a())) {
      return paramIStickerRecEmoticon.a();
    }
    return null;
  }
  
  public static boolean a(String paramString)
  {
    return StickerRecManagerImpl.getDiskFile(paramString).exists();
  }
  
  public File a(String paramString, File paramFile, URLDrawableHandler paramURLDrawableHandler)
  {
    long l = System.currentTimeMillis();
    DownloadParams localDownloadParams = new DownloadParams();
    localDownloadParams.url = new URL(paramString);
    localDownloadParams.urlStr = paramString;
    String str1 = paramFile.getPath();
    Object localObject;
    String str2;
    if (NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("keyword emotion download: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" -> ");
        ((StringBuilder)localObject).append(str1);
        QLog.d("StickerRecDrawableDownLoader", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(".tmp");
      str2 = ((StringBuilder)localObject).toString();
      localObject = new File(str2);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      paramURLDrawableHandler.publishProgress(0);
    }
    try
    {
      localObject = new FileOutputStream(str2);
    }
    catch (Exception paramURLDrawableHandler)
    {
      label235:
      break label241;
    }
    try
    {
      ((IEmosmService)QRoute.api(IEmosmService.class)).downloadImage((OutputStream)localObject, localDownloadParams, paramURLDrawableHandler);
      ((FileOutputStream)localObject).close();
      paramURLDrawableHandler = new File(str2);
      if (paramURLDrawableHandler.renameTo(paramFile)) {
        break label264;
      }
      FileUtils.copyFile(paramURLDrawableHandler, paramFile);
      paramURLDrawableHandler.delete();
    }
    catch (Exception paramURLDrawableHandler)
    {
      break label235;
    }
    paramURLDrawableHandler = (URLDrawableHandler)localObject;
    break label243;
    label241:
    paramURLDrawableHandler = null;
    label243:
    if (paramURLDrawableHandler != null) {
      paramURLDrawableHandler.close();
    }
    new File(str2).delete();
    label264:
    l = System.currentTimeMillis() - l;
    paramURLDrawableHandler = new HashMap();
    paramURLDrawableHandler.put("sticker_url", paramString);
    if ((paramFile.exists()) && (paramFile.length() > 0L))
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", true, l, 0L, paramURLDrawableHandler, "");
      return paramFile;
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "StickerRecImgDownload", false, l, 0L, null, "");
    paramFile.delete();
    paramString = new StringBuilder();
    paramString.append("downloadImage|file not exist or empty. filepath=");
    paramString.append(str1);
    QLog.e("StickerRecDrawableDownLoader", 1, paramString.toString());
    paramString = new StringBuilder();
    paramString.append("File not Found. url: ");
    paramString.append(localDownloadParams.url);
    throw new IOException(paramString.toString());
  }
  
  public boolean hasDiskFile(DownloadParams paramDownloadParams)
  {
    try
    {
      paramDownloadParams = a((StickerRecData)paramDownloadParams.mExtraInfo);
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
    paramDownloadParams = a((IStickerRecEmoticon)paramDownloadParams.mExtraInfo);
    QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile");
    File localFile1 = StickerRecManagerImpl.getDiskFile(paramDownloadParams);
    if ((localFile1.exists()) && (localFile1.length() > 0L))
    {
      QLog.d("StickerRecDrawableDownLoader", 1, "loadImageFile file.exists()");
      return localFile1;
    }
    localFile1.getParentFile().mkdirs();
    if ((Utils.a()) && (Utils.b() < 31457280L))
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("SD card free space is ");
      paramDownloadParams.append(Utils.b());
      throw new IOException(paramDownloadParams.toString());
    }
    File localFile2 = new File(jdField_a_of_type_JavaLangString);
    if (!localFile2.exists()) {
      localFile2.mkdir();
    }
    return a(paramDownloadParams, localFile1, paramURLDrawableHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecDrawableDownLoader
 * JD-Core Version:    0.7.0.1
 */