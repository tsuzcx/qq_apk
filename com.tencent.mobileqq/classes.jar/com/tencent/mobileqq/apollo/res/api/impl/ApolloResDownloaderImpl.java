package com.tencent.mobileqq.apollo.res.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.opengl.utils.IntArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloContentUpdateHandler.ApolloDownloadListener;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloDress;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnAudioDownloadListener;
import com.tencent.mobileqq.apollo.res.api.IApolloResDownloader.OnFaceDataDownloadListener;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.cmshow.engine.util.CMGetResPathUtil;
import com.tencent.mobileqq.cmshow.engine.util.CMResUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloResDownloaderImpl
  implements IApolloResDownloader
{
  public static final int[] DEFAULT_DRESSIDS_ROLE0 = { 1, 2, 3, 4, 5, 6, 7 };
  public static final int[] DEFAULT_DRESSIDS_ROLE1 = { 53, 54, 55, 56, 86, 87, 88 };
  public static final int[] DEFAULT_DRESSIDS_ROLE2 = { 91, 90, 63, 64, 65, 102, 103 };
  public static int FACE_ERROR_CODE_DOWNLOAD_FAIL = -5013;
  public static int FACE_ERROR_CODE_UNZIP_FAIL = 0;
  public static int FACE_ERROR_CODE_ZIP_NOT_EXISTX = 0;
  private static final String TAG = "[cmshow][ApolloResDownloader]";
  private static ConcurrentHashMap<Integer, Boolean> sActionSoundMap;
  public static ConcurrentHashMap<Integer, IntArray> sRoleDefaultDress = new ConcurrentHashMap();
  
  static
  {
    sActionSoundMap = new ConcurrentHashMap();
    FACE_ERROR_CODE_UNZIP_FAIL = -5011;
    FACE_ERROR_CODE_ZIP_NOT_EXISTX = -5012;
  }
  
  @Nullable
  public static DownloaderInterface getDownloaderInterface(AppRuntime paramAppRuntime)
  {
    paramAppRuntime = (DownloaderFactory)paramAppRuntime.getManager(QQManagerFactory.DOWNLOADER_FACTORY);
    if (paramAppRuntime == null) {
      return null;
    }
    paramAppRuntime = paramAppRuntime.a(3);
    if (paramAppRuntime == null) {
      return null;
    }
    return paramAppRuntime;
  }
  
  public static boolean hasSound(int paramInt)
  {
    if (sActionSoundMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)sActionSoundMap.get(Integer.valueOf(paramInt))).booleanValue();
    }
    Object localObject = new File(CMGetResPathUtil.a(3, paramInt), "config.json");
    if (!((File)localObject).exists()) {
      return false;
    }
    try
    {
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optJSONObject("audio");
      if (localObject == null) {
        break label153;
      }
      bool = ((JSONObject)localObject).optBoolean("hasSound");
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveResTimestamp ex!");
      localStringBuilder.append(localException.getMessage());
      QLog.e("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
      return false;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        continue;
        boolean bool = false;
      }
    }
    sActionSoundMap.put(Integer.valueOf(paramInt), Boolean.valueOf(bool));
    return bool;
    QLog.e("[cmshow][ApolloResDownloader]", 1, "saveResTimestamp OOM!");
    return false;
  }
  
  public static String readRoleBubbleTips(int paramInt)
  {
    Object localObject = new File(CMGetResPathUtil.a(1, paramInt), "config.json");
    if (!((File)localObject).exists()) {
      return null;
    }
    try
    {
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject)).optString("bubbleTips");
      return localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveResTimestamp ex!");
      localStringBuilder.append(localException.getMessage());
      QLog.e("[cmshow][ApolloResDownloader]", 1, localStringBuilder.toString());
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label43:
      break label43;
    }
    QLog.e("[cmshow][ApolloResDownloader]", 1, "saveResTimestamp OOM!");
    return null;
  }
  
  private static void saveResTimestamp(IApolloManagerService paramIApolloManagerService, int paramInt1, int paramInt2)
  {
    localObject = new File(CMGetResPathUtil.a(paramInt1, paramInt2), "config.json");
    if (((File)localObject).exists()) {
      if (paramIApolloManagerService == null) {
        return;
      }
    }
    try
    {
      localObject = new JSONObject(FileUtils.readFileToString((File)localObject));
      long l = ((JSONObject)localObject).optLong("version");
      ((ApolloManagerServiceImpl)paramIApolloManagerService).saveApolloResLocalTimestamp(paramInt1, paramInt2, l);
      if (paramInt1 != 1) {
        break label187;
      }
      paramIApolloManagerService = ((JSONObject)localObject).optJSONArray("dressIds");
      if ((paramIApolloManagerService == null) || (paramIApolloManagerService.length() <= 0)) {
        break label187;
      }
      int i = paramIApolloManagerService.length();
      localObject = new IntArray();
      paramInt1 = 0;
      while (paramInt1 < i)
      {
        ((IntArray)localObject).a(paramIApolloManagerService.optInt(paramInt1));
        paramInt1 += 1;
      }
      sRoleDefaultDress.put(Integer.valueOf(paramInt2), localObject);
      return;
    }
    catch (Exception paramIApolloManagerService)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveResTimestamp ex!");
      ((StringBuilder)localObject).append(paramIApolloManagerService.getMessage());
      QLog.e("[cmshow][ApolloResDownloader]", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (OutOfMemoryError paramIApolloManagerService)
    {
      label139:
      break label139;
    }
    QLog.e("[cmshow][ApolloResDownloader]", 1, "saveResTimestamp oom!");
  }
  
  public void checkDownloadFaceData(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener)
  {
    if (paramAppRuntime != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      try
      {
        String str = MD5Utils.toMD5(paramString);
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkDownloadFaceData e");
        ((StringBuilder)localObject2).append(localException);
        QLog.e("[cmshow][ApolloResDownloader]", 1, ((StringBuilder)localObject2).toString());
        localObject1 = null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress/").mkdir();
      new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/").mkdir();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/dress//face/");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(".zip");
      Object localObject1 = new File(((StringBuilder)localObject2).toString());
      if (((File)localObject1).exists())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("checkDownloadFaceData url data is exists:");
        paramAppRuntime.append(paramString);
        QLog.i("[cmshow][ApolloResDownloader]", 1, paramAppRuntime.toString());
        if (paramOnFaceDataDownloadListener != null) {
          paramOnFaceDataDownloadListener.a(true, 0);
        }
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkDownloadFaceData url:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.d("[cmshow][ApolloResDownloader]", 2, ((StringBuilder)localObject2).toString());
      }
      ((File)localObject1).getParentFile().mkdir();
      localObject2 = new DownloadTask(paramString, (File)localObject1);
      ((DownloadTask)localObject2).p = true;
      ((DownloadTask)localObject2).n = true;
      ((DownloadTask)localObject2).f = "apollo_res";
      ((DownloadTask)localObject2).b = 1;
      ((DownloadTask)localObject2).q = true;
      ((DownloadTask)localObject2).r = true;
      getDownloaderInterface(paramAppRuntime).startDownload((DownloadTask)localObject2, new ApolloResDownloaderImpl.4(this, paramString, paramOnFaceDataDownloadListener, (File)localObject1), null);
    }
  }
  
  public void downLoadCmshowRes(AppRuntime paramAppRuntime, String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString1 = new DownloadTask(paramString2, paramString1);
    paramString1.p = true;
    paramString1.n = true;
    paramString1.f = "apollo_res";
    paramString1.b = 1;
    paramString1.q = true;
    paramString1.r = true;
    getDownloaderInterface(paramAppRuntime).startDownload(paramString1, paramDownloadListener, paramBundle);
  }
  
  public void downLoadCmshowRes(AppRuntime paramAppRuntime, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    downLoadCmshowRes(paramAppRuntime, paramString1, paramString2, paramBundle, new ApolloContentUpdateHandler.ApolloDownloadListener());
  }
  
  public void downLoadSpecialAction(AppRuntime paramAppRuntime, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    paramString1 = new File(paramString1);
    paramString1.getParentFile().mkdirs();
    paramString2 = new DownloadTask(paramString2, paramString1);
    paramString2.p = true;
    paramString2.n = true;
    paramString2.f = "apollo_res";
    paramString2.b = 1;
    paramString2.q = true;
    paramString2.r = true;
    getDownloaderInterface(paramAppRuntime).startDownload(paramString2, new ApolloResDownloaderImpl.3(this, paramString1), null);
  }
  
  public void downloadApolloAudio(AppInterface paramAppInterface, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener, int paramInt, boolean paramBoolean)
  {
    if ((paramAppInterface != null) && (NetworkUtil.isNetworkAvailable(paramAppInterface.getApplication())))
    {
      Object localObject = new File(getAudioFilePath(paramInt));
      if ((!paramBoolean) && (((File)localObject).exists()))
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("file exsit resType->4 id->");
          paramAppInterface.append(paramInt);
          QLog.d("[cmshow][ApolloResDownloader]", 2, paramAppInterface.toString());
        }
        if (paramOnAudioDownloadListener != null) {
          paramOnAudioDownloadListener.a(true, paramInt);
        }
        return;
      }
      String str = CMResUtil.a(4, paramInt);
      if (TextUtils.isEmpty(str))
      {
        if (QLog.isColorLevel())
        {
          paramAppInterface = new StringBuilder();
          paramAppInterface.append("downloadApolloRes url is empty resType->4 id->");
          paramAppInterface.append(paramInt);
          QLog.d("[cmshow][ApolloResDownloader]", 2, paramAppInterface.toString());
        }
        if (paramOnAudioDownloadListener != null) {
          paramOnAudioDownloadListener.a(false, paramInt);
        }
        return;
      }
      paramAppInterface = getDownloaderInterface(paramAppInterface);
      if (paramAppInterface == null)
      {
        if (paramOnAudioDownloadListener != null) {
          paramOnAudioDownloadListener.a(false, paramInt);
        }
        return;
      }
      ((File)localObject).getParentFile().mkdirs();
      localObject = new DownloadTask(str, (File)localObject);
      ((DownloadTask)localObject).p = true;
      ((DownloadTask)localObject).n = true;
      ((DownloadTask)localObject).f = "apollo_res";
      ((DownloadTask)localObject).b = 1;
      ((DownloadTask)localObject).q = true;
      ((DownloadTask)localObject).r = true;
      paramAppInterface.startDownload((DownloadTask)localObject, new ApolloResDownloaderImpl.5(this, paramInt, paramOnAudioDownloadListener), null);
      return;
    }
    if (paramOnAudioDownloadListener != null) {
      paramOnAudioDownloadListener.a(false, paramInt);
    }
    QLog.e("[cmshow][ApolloResDownloader]", 1, "downloadApolloRes null Parameters!");
  }
  
  public void downloadApolloRes(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    String str = "[cmshow][ApolloResDownloader]";
    if (paramAppRuntime == null)
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      QLog.e("[cmshow][ApolloResDownloader]", 1, "downloadApolloRes null Parameters!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject1 = ((IApolloDaoManagerService)paramAppRuntime.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(paramString);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((ApolloBaseInfo)localObject1).getApolloPetDress();
    }
    if ((localObject1 != null) && (((ApolloDress)localObject1).roleId >= 0) && (localIApolloManagerService.getApolloResLocalTimestamp(1, ((ApolloDress)localObject1).roleId) / 1000L != ((ApolloDress)localObject1).roleTimeStamp))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("update pet role :");
      ((StringBuilder)localObject2).append(((ApolloDress)localObject1).roleId);
      ((StringBuilder)localObject2).append(" to:");
      ((StringBuilder)localObject2).append(((ApolloDress)localObject1).roleTimeStamp);
      QLog.i("[cmshow]ApolloPet", 1, ((StringBuilder)localObject2).toString());
      localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(1, ((ApolloDress)localObject1).roleId));
    }
    if (paramInt1 >= 0) {
      localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(1, paramInt1));
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      i = 0;
      while (i < paramArrayOfInt.length)
      {
        localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(2, paramArrayOfInt[i]));
        i += 1;
      }
    }
    if (paramInt2 > 0) {
      localArrayList.add(new ApolloResDownloaderImpl.ApolloLoadResTask(3, paramInt2));
    }
    if (localArrayList.isEmpty())
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    Object localObject2 = getDownloaderInterface(paramAppRuntime);
    if (localObject2 == null)
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      return;
    }
    localObject1 = new AtomicInteger(localArrayList.size());
    AtomicInteger localAtomicInteger2 = new AtomicInteger(0);
    AtomicInteger localAtomicInteger1 = new AtomicInteger(0);
    int i = localArrayList.size();
    int j = 0;
    while (j < i)
    {
      Object localObject3 = (ApolloResDownloaderImpl.ApolloLoadResTask)localArrayList.get(j);
      int k = ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject3).a;
      int m = ((ApolloResDownloaderImpl.ApolloLoadResTask)localObject3).b;
      localObject3 = CMResUtil.a(k, m);
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("downloadApolloRes url is empty resType->");
          ((StringBuilder)localObject3).append(k);
          ((StringBuilder)localObject3).append(" id->");
          ((StringBuilder)localObject3).append(m);
          QLog.d(str, 2, ((StringBuilder)localObject3).toString());
        }
        ((AtomicInteger)localObject1).decrementAndGet();
      }
      for (;;)
      {
        break;
        if (!paramBoolean)
        {
          boolean bool;
          if (k == 1) {
            bool = CMResUtil.b(m);
          }
          for (;;)
          {
            break;
            if (k == 2) {
              bool = CMResUtil.a(m);
            } else if (k == 3) {
              bool = CMResUtil.a(m, paramInt3);
            } else {
              bool = false;
            }
          }
          if (bool)
          {
            if (QLog.isColorLevel())
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("file exsit resType->");
              ((StringBuilder)localObject3).append(k);
              ((StringBuilder)localObject3).append(" id->");
              ((StringBuilder)localObject3).append(m);
              QLog.d(str, 2, ((StringBuilder)localObject3).toString());
            }
            ((AtomicInteger)localObject1).decrementAndGet();
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("file not exsit resType->");
            ((StringBuilder)localObject4).append(k);
            ((StringBuilder)localObject4).append(" id->");
            ((StringBuilder)localObject4).append(m);
            QLog.d(str, 2, ((StringBuilder)localObject4).toString());
          }
          else {}
        }
        if (!NetworkUtil.isNetworkAvailable(paramAppRuntime.getApplication()))
        {
          if (paramOnApolloDownLoadListener != null) {
            paramOnApolloDownLoadListener.a(false, paramString, paramInt1, paramArrayOfInt, paramInt2);
          }
          QLog.e(str, 1, "downloadApolloRes NetworkUtil.isNetworkAvailable is false!");
          return;
        }
        Object localObject4 = CMGetResPathUtil.a(k, m);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(System.currentTimeMillis());
        localStringBuilder.append("res.zip");
        localObject4 = new File((String)localObject4, localStringBuilder.toString());
        ((File)localObject4).getParentFile().mkdirs();
        localObject3 = new DownloadTask((String)localObject3, (File)localObject4);
        ((DownloadTask)localObject3).p = true;
        ((DownloadTask)localObject3).n = true;
        ((DownloadTask)localObject3).f = "apollo_res";
        ((DownloadTask)localObject3).b = 1;
        ((DownloadTask)localObject3).q = true;
        ((DownloadTask)localObject3).r = true;
        localObject4 = new ApolloResDownloaderImpl.2(this, (File)localObject4, localIApolloManagerService, k, m, localAtomicInteger1, localAtomicInteger2, (AtomicInteger)localObject1, paramOnApolloDownLoadListener, paramString, paramInt1, paramArrayOfInt, paramInt2);
        ((DownloaderInterface)localObject2).startDownload((DownloadTask)localObject3, (DownloadListener)localObject4, null);
      }
      j += 1;
    }
    if (((AtomicInteger)localObject1).get() == 0)
    {
      if (paramOnApolloDownLoadListener != null) {
        paramOnApolloDownLoadListener.a(true, paramString, paramInt1, paramArrayOfInt, paramInt2);
      }
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("downloadApolloRes local dress ok uin:");
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(", all cnt: ");
        paramAppRuntime.append(((AtomicInteger)localObject1).get());
        QLog.d(str, 2, paramAppRuntime.toString());
      }
    }
  }
  
  public void downloadApolloResOrder(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAppRuntime == null) {
      return;
    }
    if (paramInt1 < 0)
    {
      downloadApolloRes(paramAppRuntime, paramString, paramOnApolloDownLoadListener, -1, paramArrayOfInt, paramInt2, paramInt3, paramBoolean);
      return;
    }
    downloadApolloRes(paramAppRuntime, paramString, new ApolloResDownloaderImpl.1(this, paramOnApolloDownLoadListener, paramInt1, paramArrayOfInt, (ApolloManagerServiceImpl)paramAppRuntime.getRuntimeService(IApolloManagerService.class, "all"), paramAppRuntime, paramBoolean), paramInt1, null, paramInt2, paramInt3, paramBoolean);
  }
  
  public String getAudioFilePath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(CMGetResPathUtil.a(4, paramInt));
    localStringBuilder.append("music.amr");
    return localStringBuilder.toString();
  }
  
  public int[] readRoleDefaultDressIds(int paramInt)
  {
    boolean bool = sRoleDefaultDress.containsKey(Integer.valueOf(paramInt));
    localObject3 = null;
    Object localObject1;
    if (bool)
    {
      localObject1 = (IntArray)sRoleDefaultDress.get(Integer.valueOf(paramInt));
      if (localObject1 == null) {
        return null;
      }
      return ((IntArray)localObject1).a(null);
    }
    try
    {
      try
      {
        Object localObject4 = new File(CMGetResPathUtil.a(1, paramInt), "config.json");
        localObject1 = localObject3;
        if (((File)localObject4).exists())
        {
          localObject4 = new JSONObject(FileUtils.readFileToString((File)localObject4)).optJSONArray("dressIds");
          localObject1 = localObject3;
          if (localObject4 != null)
          {
            localObject1 = localObject3;
            if (((JSONArray)localObject4).length() > 0)
            {
              int j = ((JSONArray)localObject4).length();
              localObject1 = new IntArray();
              int i = 0;
              while (i < j)
              {
                ((IntArray)localObject1).a(((JSONArray)localObject4).optInt(i));
                i += 1;
              }
              sRoleDefaultDress.put(Integer.valueOf(paramInt), localObject1);
              localObject1 = ((IntArray)localObject1).a(null);
            }
          }
        }
        if ((localObject1 != null) && (localObject1.length != 0)) {
          break label299;
        }
        if (paramInt == 1) {
          break label224;
        }
        if (2 != paramInt) {
          break label237;
        }
      }
      finally
      {
        break label302;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("readRoleDefaultDressIds ex!");
        ((StringBuilder)localObject3).append(localException.getMessage());
        QLog.e("[cmshow][ApolloResDownloader]", 1, ((StringBuilder)localObject3).toString());
        if (paramInt != 1) {
          if (2 != paramInt) {}
        }
      }
      return localException;
      if (paramInt == 1) {
        break label328;
      }
      if (2 != paramInt) {
        break label320;
      }
      localObject3 = DEFAULT_DRESSIDS_ROLE2;
      break label333;
      localObject3 = DEFAULT_DRESSIDS_ROLE0;
      break label333;
      localObject3 = DEFAULT_DRESSIDS_ROLE1;
      for (;;)
      {
        throw localException;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label210:
      label224:
      label237:
      break label210;
    }
    QLog.e("[cmshow][ApolloResDownloader]", 1, "readRoleDefaultDressIds OOM!");
    if (paramInt == 1) {
      return DEFAULT_DRESSIDS_ROLE1;
    }
    if (2 == paramInt) {
      return DEFAULT_DRESSIDS_ROLE2;
    }
    return DEFAULT_DRESSIDS_ROLE0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.res.api.impl.ApolloResDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */